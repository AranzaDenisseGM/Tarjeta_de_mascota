package com.example.mimascota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mimascota.ui.theme.MiMascotaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiMascotaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = "EL ES TIRGO",
                        from = stringResource(R.string.signature_text),
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
@Composable
fun GreetingImage(
    message: String,
    from: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.tirgo)

    Box(modifier = modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}
@Composable
fun GreetingText(
    message: String,
    from: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .fillMaxSize()
            .wrapContentHeight(align = Alignment.Bottom)
    ) {
        Text(
            text = message,
            fontSize = 36.sp,
            lineHeight = 40.sp,
            textAlign = TextAlign.Start,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = from,
            fontSize = 25.sp,
            color = Color.Red,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.Start)
        )
    }
}