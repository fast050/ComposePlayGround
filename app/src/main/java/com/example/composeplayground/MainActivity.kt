package com.example.composeplayground

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.theme.ComposePlayGroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlayGroundTheme {
                Surface {
                    MessageCard(name = "khalid", message = "first time doing this?")
                }
            }

        }
    }
}

@Composable
fun MessageCard(name: String, message: String) {

    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "beauty asian women smiling",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column {
            Text(
                text = "Hello $name , How are you",
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(text = message)
            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = false,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewMessageCardDarkMode() {
    ComposePlayGroundTheme {
        Surface {
            MessageCard("Ahmed", "This was fun time to go haha")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = false,
)
@Composable
fun PreviewMessageCardNormalMode() {
    ComposePlayGroundTheme {
        Surface {
            MessageCard("Ahmed", "This was fun time to go haha")
        }
    }
}