package com.android.m2.tiila.fitmarket.domain.component

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.android.m2.tiila.fitmarket.domain.model.Classe
import com.android.m2.tiila.fitmarket.domain.model.FitMarketViewModel
import com.android.m2.tiila.fitmarket.domain.model.Member
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListClassesScreen(
    navHostController: NavHostController,
    fitMarketViewModel: FitMarketViewModel
){
    val state by fitMarketViewModel.classesResult.collectAsState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val classesListState = remember { mutableStateOf<MutableList<Classe>>(mutableListOf()) }
    val myStringState = remember { mutableStateOf<String>("") }
    val myBooleanState = remember { mutableStateOf<Boolean>(false) }
    val (firstname, lastname) = fitMarketViewModel.getLoggedInUserFullName() ?: Pair("", "")


    LaunchedEffect(state){
        classesListState.value = state.classes?.toMutableList() ?: mutableListOf()
        myBooleanState.value=state.isLoading
        myStringState.value= state.errorMessage.toString()
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                title = { Text("") },
                actions = {
                    HeaderUserLogOut(navHostController = navHostController,fitMarketViewModel = fitMarketViewModel,lastName=lastname,firstName=firstname)
                })
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .pointerInput(Unit) {
                }
        ) {
            Text(
                text = "Mes cours",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            if(myBooleanState.value){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    CircularProgressIndicator()
                }
            }else if (classesListState!=null){
                ListeClasses(classes = classesListState.value)
            }else{
                Text(text = myStringState.value ?: "")
            }
        }
    }
}