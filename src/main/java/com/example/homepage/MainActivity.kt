package com.example.homepage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homepage.ui.theme.HomePageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomePageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage( stringResource(R.string.welcome_text), from = stringResource(R.string.signature_text), quote = stringResource(R.string.trust_the_process) )
                }
            }
        }
    }
}
@Composable
fun GreetingText(message: String, from: String, quote: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {

        Text(
            text = message,
            fontSize = 50.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = quote,
            fontSize = 30.sp,
            lineHeight = 80.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)

        )

        Text(
            text = from,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}
@Composable
fun GreetingImage(message: String, from: String, quote: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.shiv)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            quote = quote,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}



@Preview(showBackground = false
)
@Composable
private fun BirthdayCardPreview() {
    HomePageTheme()  {
        GreetingImage( stringResource(R.string.welcome_text),
            stringResource(R.string.signature_text), quote = stringResource(R.string.trust_the_process)
        )
    }
}