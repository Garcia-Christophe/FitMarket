package com.android.m2.tiila.fitmarket.domain.component

import android.widget.LinearLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.m2.tiila.fitmarket.domain.model.FitMarketViewModel
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderUserLogOut(
    navHostController: NavHostController,
    fitMarketViewModel: FitMarketViewModel,
    lastName: String,
    firstName: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray) ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ){
        Icon(
            Icons.Default.Person,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "$lastName $firstName"
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                fitMarketViewModel.logout()
                navHostController.navigate(Screen.LogInScreen.route)
            },
            modifier = Modifier
                .padding(8.dp),
        ) {
            Text(
                text = "Déconnexion",
                color = Color.White
            )
        }
    }
}