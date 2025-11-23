package sample.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import sample.common.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(R.drawable.sample_icon)
            val isDark = isSystemInDarkTheme()

            val lightColors = lightColorScheme()
            val darkColors = darkColorScheme()
            MaterialTheme(
                colorScheme = if (isDark) darkColors else lightColors,
            ) {
                Surface(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                ) {

                    Column(
                        modifier = Modifier.padding(vertical = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = if (isDark) {
                                "Dark Mode"
                            } else {
                                "Light Mode"
                            },
                            style = MaterialTheme.typography.headlineLarge
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Text("Regular Image")
                        Spacer(modifier = Modifier.height(8.dp))
                        Image(
                            painter = painter,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        HorizontalDivider(thickness = 2.dp)
                        Spacer(modifier = Modifier.height(20.dp))
                        Text("Async Image")
                        Spacer(modifier = Modifier.height(8.dp))
                        AsyncImage(
                            model = "https://imagedoesnotexist.com/image.png",
                            contentDescription = "Image",
                            error = painter
                        )
                    }
                }
            }
        }
    }
}
