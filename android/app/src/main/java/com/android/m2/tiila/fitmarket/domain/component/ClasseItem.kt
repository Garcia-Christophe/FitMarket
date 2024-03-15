package com.android.m2.tiila.fitmarket.domain.component

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.m2.tiila.fitmarket.domain.model.Classe
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@Composable
fun ClasseItem (
    item : Classe,
){
    val showDetail = remember { mutableStateOf<Boolean>(false) }
    Column(
        modifier = Modifier
            .border(BorderStroke(2.dp, Color.Blue))
    ) {
        Row(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(5.dp),
                verticalArrangement = Arrangement.Center

            ) {
                Button(
                    onClick = {
                        showDetail.value = !showDetail.value
                    },
                    modifier = Modifier
                        .padding(8.dp),
                ) {
                    Text(
                        text = "Détail",
                        color = Color.White
                    )
                }
            }
            Column(
                modifier = Modifier.padding(5.dp)

            ) {
                Text(
                    text = item.product?.title ?: ""
                )
                Text(
                    text = "Durée : ${item.duration}"
                )
                Text(
                    text = item.product?.description ?: ""
                )
            }

        }
        if (showDetail.value){
            Column(
                modifier = Modifier.padding(5.dp)

            ) {
                val uri = Uri.parse(item.video)
                VideoPlayer(uri)
                Text(text = "En présentiel : ")
                Text(
                    text = "Jour : ${item.day_time}"
                )
                Text(
                    text = "Adresse : "+ item.address ?: ""
                )
            }
        }
    }

}