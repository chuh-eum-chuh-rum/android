package com.jeongg.mbti.presentation.ui.select

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeongg.mbti.data.dtos.QuestionDTO
import com.jeongg.mbti.data.repository.MbtiRepository
import com.jeongg.mbti.presentation.ui.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val PROBLEM_TOTAL: Int = 12

data class SelectState(
    val maxStep: Int = PROBLEM_TOTAL,
    val step: Int = 0,
    val selectIndex: List<Int> = emptyList(),
    val answers: List<String> = List(PROBLEM_TOTAL) { "" },
    val questions: List<QuestionDTO> = emptyList()
)

@HiltViewModel
class SelectViewModel @Inject constructor(
    private val mbtiRepository: MbtiRepository
) : ViewModel() {
    private val _state = MutableStateFlow(SelectState())
    val state: StateFlow<SelectState> = _state.asStateFlow()

    private val currentState get() = state.value

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow

    init {
        getQuestions()
    }

    private fun getQuestions() {
        viewModelScope.launch {
            _eventFlow.emit(UiEvent.LOADING)
            val response = mbtiRepository.getQuestions()
            if (response.isEmpty()) {
                _eventFlow.emit(UiEvent.ERROR("질문을 불러오는데 실패하였습니다."))
            } else {
                _state.update {
                    it.copy(questions = response)
                }
                _eventFlow.emit(UiEvent.SUCCESS)
            }
        }
    }

    fun addAnswer(index: Int) {
        _state.value = _state.value.copy()
    }

    fun navigateToNextProblem(selectIndex: Int) = viewModelScope.launch {
        if (currentState.step == PROBLEM_TOTAL - 1) {
            _eventFlow.emit(UiEvent.NavigateToResult)
            return@launch
        }
        addSelectIndex(selectIndex = selectIndex)
        plusStep()
    }

    fun minusStep() {
        _state.update {
            it.copy(step = currentState.step.minus(1))
        }
    }

    private fun plusStep() {
        _state.update {
            it.copy(
                step = currentState.step.plus(1),
            )
        }
    }

    private fun addSelectIndex(selectIndex: Int) {
        val newSelectIndex = currentState.selectIndex.toMutableList().apply {
            add(selectIndex)
        }
        _state.update {
            it.copy(
                selectIndex = newSelectIndex,
            )
        }
    }

    fun navigateToResultScreen() {

    }
}