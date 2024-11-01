package com.example.musicapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bnb.Chatbot.Constants
import com.example.bnb.Chatbot.MessageModel
import com.example.bnb.Screen
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _currentScreen : MutableState<Screen> = mutableStateOf(Screen.BottomScreen.Booking)

    val currentState : MutableState<Screen>
        get() = _currentScreen

    fun setCurrentScreen(screen:Screen){
        _currentScreen.value = screen
    }

    private val _spotsLeftMap = mutableStateMapOf<String, MutableLiveData<Int>>()

    // Initialize with default spots for each event
    init {
//        _spotsLeftMap["Birthday Bash"] = MutableLiveData(10)
        _spotsLeftMap["Halloween Party"] = MutableLiveData(50)
        _spotsLeftMap["Bollywood Night"] = MutableLiveData(40)
        _spotsLeftMap["Mask Night"] = MutableLiveData(35)
//        _spotsLeftMap["Engagement Party"] = MutableLiveData(8)
//        _spotsLeftMap["Anniversary Celebration"] = MutableLiveData(12)
    }

    // Function to get the spots left for a specific event
    fun getSpotsLeft(eventTitle: String): LiveData<Int> {
        return _spotsLeftMap[eventTitle] ?: MutableLiveData(0)
    }

    // Function to book a slot for a specific event
    fun bookSlot(eventTitle: String) {
        val currentSpots = _spotsLeftMap[eventTitle]?.value ?: return
        if (currentSpots > 0) {
            _spotsLeftMap[eventTitle]?.value = currentSpots - 1
        }
    }


    val messageList by lazy {
        mutableStateListOf<MessageModel>()
    }
    val generativeModel =
        GenerativeModel(
            // Specify a Gemini model appropriate for your use case
            modelName = "gemini-1.5-flash",
            // Access your API key as a Build Configuration variable (see "Set up your API key" above)
            apiKey = Constants.apikey
        )

    fun sendMessage(question: String) {
        viewModelScope.launch{
            val chat = generativeModel.startChat()
            messageList.add(MessageModel(question,"user"))
            val response = chat.sendMessage(question)
            messageList.add(MessageModel(response.text.toString(),"model"))
        }

    }
}

