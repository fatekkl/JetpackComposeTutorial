package com.proa.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.proa.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        MessageCard(
                            SampleData.conversationSample,
                            Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}


object SampleData {

    val conversationSample = listOf<Message>(
        Message(
            "Hudson Branco",
            "Test...Test...Test..."
        ),
        Message(
            "Murilo Branco",
            "LL"
        )
    )

}

data class Message(val author: String, val body: String)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun MessageCard(messages: List<Message>, modifier: Modifier) {


    LazyColumn {
        items(messages) { msg ->
            Row(Modifier.padding(40.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.example),
                    contentDescription = "Android",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )

                Column {

                    Text(
                        text = msg.author,
                        fontSize = 26.sp,
                        fontFamily = FontFamily(Font(R.font.diplomata, FontWeight.Bold)),

                    )

                    Text(
                        text = msg.body,
                    )
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        Greeting("Android")
    }
}