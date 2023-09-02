package com.jeongg.mbti.presentation.ui.select

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

private const val PROBLEM_TOTAL: Int = 10

data class SelectState(
    val maxStep: Int = PROBLEM_TOTAL,
    val step: Int = 0,
    val selectIndex: List<Int> = emptyList(),
)

@HiltViewModel
class SelectViewModel @Inject constructor(
) : ViewModel() {
    private val _state = MutableStateFlow(SelectState())
    val state: StateFlow<SelectState> = _state.asStateFlow()

    private val currentState get() = state.value

    fun navigateToNextProblem(selectIndex: Int) {
        addSelectIndex(selectIndex = selectIndex)
        plusStep()
        if (currentState.step == PROBLEM_TOTAL) navigateToResultScreen()
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