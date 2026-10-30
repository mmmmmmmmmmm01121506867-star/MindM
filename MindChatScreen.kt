package com.mostafaai.mindm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp

data class Message(val text: String, val isUser: Boolean)

@Composable
fun MindChatScreen() {
    var textInput by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf(
        Message("أهلاً بيك في MindChat! أنا مساعدك الذكي باللهجة المصرية وبكل اللغات. تحب نبدأ بإيه؟", false)
    ) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(messages) { msg ->
                ChatBubble(message = msg)
            }
        }

        ChatInputRow(
            value = textInput,
            onValueChange = { textInput = it },
            onSend = {
                if (textInput.isNotBlank()) {
                    messages.add(Message(textInput, true))
                    textInput = ""
                }
            }
        )
    }
}

@Composable
fun ChatBubble(message: Message) {
    val bg = if (message.isUser) {
        Brush.horizontalGradient(listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary))
    } else {
        Brush.horizontalGradient(listOf(MaterialTheme.colorScheme.surfaceContainer, MaterialTheme.colorScheme.surfaceContainer))
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(if (message.isUser) Alignment.End else Alignment.Start)
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer)
        ) {
            Text(
                text = message.text,
                modifier = Modifier.padding(14.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun ChatInputRow(
    value: String,
    onValueChange: (String) -> Unit,
    onSend: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.weight(1f),
            placeholder = { Text("Ask MindM in Egyptian Arabic or English...") },
            shape = RoundedCornerShape(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = onSend) {
            Icon(Icons.Default.Send, contentDescription = "Send", tint = MaterialTheme.colorScheme.primary)
        }
    }
}
