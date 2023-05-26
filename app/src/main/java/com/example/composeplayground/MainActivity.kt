package com.example.composeplayground

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
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

    // We keep track if the message is expanded or not in this
    // variable
    var isExpanded by remember { mutableStateOf(false) }

// surfaceColor will be updated gradually from one color to the other
    val surfaceColor by animateColorAsState(
        if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
    )
    // We toggle the isExpanded variable when we click on this Column
    Row(modifier = Modifier
            // animateContentSize will change the Surface size gradually
            .animateContentSize().padding(8.dp)
        .clickable { isExpanded = !isExpanded }) {
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
                style = MaterialTheme.typography.body2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 5.dp,
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor
            ) {
                Text(
                    text = message,
                    overflow = TextOverflow.Ellipsis,
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }
    }
}

@Composable
fun Conversation(conversations: List<Conversation>) {
    LazyColumn {
        items(conversations) { conversation ->
            MessageCard(name = conversation.name, message = conversation.message)
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


@Preview
@Composable
fun PreviewConversation() {
    ComposePlayGroundTheme {
        Surface {
            Conversation(listOfConversation + listAtTheEnd)
        }
    }
}


data class Conversation(
    val name: String,
    val message: String
)

private val listOfConversation = listOf(
    Conversation("khalid", "hello bro"),
    Conversation("ahmed", "oh long time no see"),
    Conversation("khalid", "haha you can see so , so where are you now"),
    Conversation("ahmed", "yeah am with my family , but these are hard days"),
    Conversation(
        "khalid",
        "what you mean? what happen , it just one year bro , why u look like old guy already"
    ),
    Conversation("ahmed", "if you see what i see you will be the same"),
    Conversation("khalid", "bro what happen"),
    Conversation("ahmed", "let me sit first"),
    Conversation("khalid", "i know you are trolling"),
    Conversation("ahmed", "trolling.. , maybe hear me first and then you decide"),
    Conversation("khalid", "okay let me bring a popcorn"),
    Conversation("ahmed", "ha ha very funny"),
    Conversation("khalid", "..."),
    Conversation("ahmed", "so yesterday i was in the park and some guy come from no where"),
    Conversation("Khalid", "so it like fun haha"),
)

private val listAtTheEnd = listOf(
    Conversation("FixName","FixMessage")
)