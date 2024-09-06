package com.example.practice2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.practice2.data.Developers

@Composable

fun Mainscreen(viewModel: MainScreenViewModel = MainScreenViewModel()){
    val developers by viewModel.state.collectAsState()

   LazyColumn(modifier = Modifier.fillMaxSize()) {
       items(developers){
           developer -> cardView(developer)

       }
   }
    
    

}
@Composable
fun cardView(developer: Developers){
    Card {
        Row {
            Image(painter = rememberAsyncImagePainter(developer.avatar),
                contentDescription = "Developer Image",
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(
                                MaterialTheme.colorScheme.surface
                            ))
            
            Column {
                Text(text = developer.username)
                
                Text(text = developer.url)
            }
        }
    }
}