package com.android.m2.tiila.fitmarket.domain.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import com.android.m2.tiila.fitmarket.domain.model.FitMarketViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun LogInScreen(
    navHostController: NavHostController,
    onLoginTextChanged: (String) -> Unit = {},
    onPasswordTextChanged: (String) -> Unit = {},
) {
    val fitMarketViewModel = getViewModel<FitMarketViewModel>()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Surface {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            Text(
                text = "FitMarket",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
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
                submit = { fitMarketViewModel.signIn(email,password) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    fitMarketViewModel.signIn(email,password)
                    println("Connecter : "+fitMarketViewModel.signInResult.value.member)
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