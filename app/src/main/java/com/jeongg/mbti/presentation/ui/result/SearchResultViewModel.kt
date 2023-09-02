package com.jeongg.mbti.presentation.ui.result

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(

) : ViewModel() {

    private val _state = MutableStateFlow(SearchResultState())
    val state: StateFlow<SearchResultState> = _state.asStateFlow()

    private val currentState get() = state.value

}