package com.jeongg.mbti.presentation.ui.result

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.jeongg.mbti.data.util.log
import com.jeongg.mbti.presentation.ui.util.Extras
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(
    val saveAsHandle: SavedStateHandle
) : ViewModel() {

    init {
        val answers = getAnswer()
        postAnswer(answers)
    }

    private fun getAnswer(): List<String> {
        val answers = saveAsHandle.getStateFlow(Extras.ANSWER, "").value
        return answers.split(",")
    }

    private fun postAnswer(answers: List<String>) {
        answers.toString().log()
    }

    private val _state = MutableStateFlow(SearchResultState())
    val state: StateFlow<SearchResultState> = _state.asStateFlow()

    private val currentState get() = state.value

}