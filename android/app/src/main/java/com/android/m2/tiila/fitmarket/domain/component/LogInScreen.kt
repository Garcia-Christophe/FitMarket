package com.android.m2.tiila.fitmarket.domain.component

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import com.android.m2.tiila.fitmarket.domain.model.FitMarketViewModel

@Composable
fun LogInScreen(
    navHostController: NavHostController,
    onLoginTextChanged: (String) -> Unit = {},
    onPasswordTextChanged: (String) -> Unit = {},
    fitMarketViewModel: FitMarketViewModel
) {

    val focusManager = LocalFocusManager.current
    val state by fitMarketViewModel.signInResult.collectAsState()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorText by remember { mutableStateOf("") }

    LaunchedEffect(state) {
        if(!state.isLoading){
            if (state.errorMessage == null || state.errorMessage!!.isEmpty()) {
                fitMarketViewModel.collectClassesUser()
                errorText = ""
                navHostController.navigate(route = Screen.ListClassesScreen.route)
            } else {
                errorText = state.errorMessage ?: "Erreur"
            }
        }else{
            print("ok")
        }

    }

    Surface {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        focusManager.clearFocus()
                    })
                }
        ) {
            Text(
                text = "FitMarket",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            LoginField(
                value = email,
                onChange = {
                    email = it
                    onLoginTextChanged(it)
                },
                modifier = Modifier.fillMaxWidth()
            )
            PasswordField(
                value = password,
                onChange = {
                    password = it
                    onPasswordTextChanged(it)
                },
                submit = {  },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            if (errorText.isNotEmpty()) {
                Text(
                    text = errorText,
                    color = Color.Red,
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
            Button(
                onClick = {
                        fitMarketViewModel.submitForm(email=email, password=password)
                },
                enabled = true,
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Connexion")
            }
        }
    }


}