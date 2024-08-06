package gemini.julian.myapplication

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    val messageList by lazy {
        mutableStateListOf<MessageModel>()
    }

    val generativeModel: GenerativeModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = Constants.apikey
    )

    fun sendMessage(message: String) {
        viewModelScope.launch {
            try {
                val chat = generativeModel.startChat(
                    history = messageList.map {
                        content(it.role) { text(it.message) }
                    }.toList()
                )
                messageList.add(MessageModel(message, "user"))
                messageList.add(MessageModel("Typing...", "model"))
                val res = chat.sendMessage(message)
                messageList.removeLast()
                messageList.add(MessageModel(res.text.toString(), "model"))

            } catch (e: Exception) {
                messageList.removeLast()
                messageList.add(MessageModel("Error" + e.message, "model"))

            }
        }
    }
}