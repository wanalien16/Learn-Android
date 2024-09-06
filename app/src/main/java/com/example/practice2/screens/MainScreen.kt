package com.example.practice2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.example.practice2.data.Repositories

@Composable

fun Mainscreen(viewModel: MainScreenViewModel = MainScreenViewModel()){
    val developers by viewModel.developerstate.collectAsState()
    val repositories by viewModel.repositoriesstate.collectAsState()
Column {
    Spacer(modifier = Modifier.padding(30.dp))
    LazyColumn(modifier = Modifier.wrapContentHeight()) {
        items(developers){
                developer -> cardView(developer)


        }
    }
    Spacer(modifier = Modifier.padding(30.dp))
    LazyColumn(modifier = Modifier.wrapContentHeight()) {
        items(repositories){
                repository -> cardViewofRepository(repository)


        }
    }
}


}
@Composable
fun cardView(developer: Developers){
    Card(modifier = Modifier.fillMaxWidth()) {
        Row {
            Image(painter = rememberAsyncImagePainter(developer.avatar),
                contentDescription = "Developer Image",
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .padding(5.dp)
                            .background(
                                MaterialTheme.colorScheme.surface
                            ))
            Spacer(modifier = Modifier.padding(5.dp))
            
            Column(modifier = Modifier.padding(5.dp)) {
                Text(text = developer.username)
                
                Text(text = developer.url)
            }
        }
    }
}
@Composable
fun cardViewofRepository(repository: Repositories){
    Card(modifier = Modifier.fillMaxWidth()) {
        Row {
            Image(painter = rememberAsyncImagePainter(repository.avatar),
                contentDescription = "Developer Image",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .padding(5.dp)
                    .background(
                        MaterialTheme.colorScheme.surface
                    ))
            Spacer(modifier = Modifier.padding(5.dp))

            Column(modifier = Modifier.padding(5.dp)) {
                Text(text = repository.name)

                Text(text = repository.url)
            }
        }
    }
}