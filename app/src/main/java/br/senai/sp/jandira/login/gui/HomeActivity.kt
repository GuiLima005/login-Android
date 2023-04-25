package br.senai.sp.jandira.login.gui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login.ui.theme.LoginTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.extras

        Log.i(
            "ds2m",
            "id"
        )

        setContent {
            LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    HomeScreen ("Android")

                }
            }
        }
    }
}

@Composable
fun HomeScreen(name: String) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp).fillMaxWidth()
                , shape = RectangleShape
        ) {

            Image(painter = painterResource(id = br.senai.sp.jandira.login.R.drawable.paris),
                contentDescription = "logo",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
        Text(text = stringResource(id = br.senai.sp.jandira.login.R.string.categories),
            color = Color (56, 54, 54 ),
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )

    }
}

@Preview(showBackground = true, showSystemUi = true)

@Composable
fun DefaultPreview3() {
    LoginTheme {
        HomeScreen ("Android")
    }
}