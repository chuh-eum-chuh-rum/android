package com.jeongg.mbti.presentation.ui.util

sealed class UiEvent {
    object SUCCESS: UiEvent()
    object LOADING: UiEvent()
    data class ERROR(val message: String): UiEvent()
    data class NavigateToResult(val answer: List<String>): UiEvent()
    object Finish: UiEvent()
}