package com.csci448.fcamachocervantes_A2.presentation.navigation.historyscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.fcamachocervantes_A2.data.History
import com.csci448.fcamachocervantes_A2.presentation.viewmodel.GameViewModel

@Composable
fun HistoryList(
                historyList: List<History>
){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ){
        items(historyList) {history ->
            Text(
                text = history.entry,
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                modifier = Modifier
                    .padding(all = 15.dp)
            )
        }
    }
}