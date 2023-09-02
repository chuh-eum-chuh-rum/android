package com.jeongg.mbti.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jeongg.mbti.presentation.theme.MbtiTheme
import com.jeongg.mbti.presentation.ui.result.SearchResultActivity
import com.jeongg.mbti.presentation.ui.select.SelectActivity
import com.jeongg.mbti.presentation.ui.start.StartActivity
import com.jeongg.mbti.presentation.util.startActivityWithAnimation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigateToStart() // FIXME temp

        setContent {
            MbtiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    private fun navigateToStart() {
        startActivityWithAnimation<StartActivity>()
    }
    private fun navigateToSelect() {
        startActivityWithAnimation<SelectActivity>()
    }

    private fun navigateToResult() {
        startActivityWithAnimation<SearchResultActivity>()
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MbtiTheme {
        Greeting("Android")
    }
}