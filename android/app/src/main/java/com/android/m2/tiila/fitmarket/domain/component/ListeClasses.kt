package com.android.m2.tiila.fitmarket.domain.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import com.android.m2.tiila.fitmarket.domain.model.Classe
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ListeClasses (
    classes: List<Classe>
){
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        items(items = classes, itemContent = { item ->
            ClasseItem(item = item)
        })
    }
}