package net.estemon.studio.latorre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import net.estemon.studio.latorre.ui.LaTorreApp
import net.estemon.studio.latorre.ui.theme.LaTorreTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaTorreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSice = calculateWindowSizeClass(this)

                    LaTorreApp(
                        windowSize = windowSice.widthSizeClass
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.DEFAULT
)
@Composable
fun LaTorreCompactPreview() {
    LaTorreTheme {
        Surface {
            LaTorreApp(
                windowSize = WindowWidthSizeClass.Compact
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.FOLDABLE
)
@Composable
fun LaTorreMediumPreview() {
    LaTorreTheme {
        Surface {
            LaTorreApp(
                windowSize = WindowWidthSizeClass.Medium
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.TABLET
)
@Composable
fun LaTorreExpandedPreview() {
    LaTorreTheme {
        Surface {
            LaTorreApp(
                windowSize = WindowWidthSizeClass.Expanded
            )
        }
    }
}