package com.rznkolds.geniusricks.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.rznkolds.geniusricks.R
import com.rznkolds.geniusricks.presentation.ui.theme.GeniusRicksTheme
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.viewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GeniusRicksTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GetCharacterScreen()
                }
            }
        }
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalCoilApi::class)
@Composable
fun GetCharacterScreen(
    mainViewModel: MainViewModel = getViewModel()
) {
    val state by mainViewModel.state.collectAsState()

    state.apply {

        this.characters?.let { v ->

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(6.dp),
                contentPadding = PaddingValues(6.dp)
            ) {

                items(v) {

                    Card (
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Image(
                                painter = rememberImagePainter(
                                    data = it.image,
                                    builder = {
                                        placeholder(R.drawable.ic_launcher_foreground)
                                        crossfade(true)
                                    }
                                ),
                                modifier = Modifier
                                    .height(120.dp)
                                    .width(120.dp)
                                    .padding(10.dp)
                                    .fillMaxWidth()
                                    .clip(
                                        RoundedCornerShape(10.dp)
                                    ),
                                contentDescription = "Game Picture",
                                contentScale = ContentScale.Crop
                            )

                            Text(it.name.toString())
                        }
                    }
                }
            }
        }

        this.loading?.let {
            Toast.makeText(LocalContext.current, "Loading", Toast.LENGTH_SHORT).show()
        }

        this.error?.let {
            Toast.makeText(LocalContext.current, "Failed to load", Toast.LENGTH_SHORT).show()
        }
    }
}
