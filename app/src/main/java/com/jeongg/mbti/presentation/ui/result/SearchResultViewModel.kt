package com.jeongg.mbti.presentation.ui.result

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeongg.mbti.data.dtos.PostAnswerRequestDTO
import com.jeongg.mbti.data.repository.MbtiRepository
import com.jeongg.mbti.presentation.ui.util.UiEvent
import com.jeongg.mbti.data.util.log
import com.jeongg.mbti.presentation.ui.util.Extras
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(
    val saveAsHandle: SavedStateHandle,
    private val mbtiRepository: MbtiRepository
) : ViewModel() {

    init {
        val answers = getAnswer()
        postAnswer(answers)
    }

    private fun getAnswer(): List<String> {
        return try {
            val answers = saveAsHandle.getStateFlow(Extras.ANSWER, "").value
            answers.split(",")
        } catch (e: Exception) {
            emptyList()
        }
    }

    private val _state = MutableStateFlow(SearchResultState())
    val state: StateFlow<SearchResultState> = _state.asStateFlow()

    private val currentState get() = state.value

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow

    private fun postAnswer(answerList: List<String>) {
        viewModelScope.launch {
            kotlin.runCatching {
                mbtiRepository.postAnswer(PostAnswerRequestDTO(answerList))
            }.onSuccess { item ->
                _state.update {
                    it.copy(
                        title = item?.mbtiTitle ?: "",
                        imageRes = item?.imagePath ?: "",
                        description = item?.mbtiContents ?: "",
                        likeTitle = item?.goodMbti?.mbtiTitle ?: "",
                        likeImageRes = item?.goodMbti?.imagePath ?: "",
                        likeDescription = "",
                        dislikeTitle = item?.badMbti?.mbtiTitle ?: "",
                        dislikeImageRes = item?.badMbti?.imagePath ?: "",
                        dislikeDescription = "",
                    )
                }
                _eventFlow.emit(UiEvent.SUCCESS)
            }.onFailure {
                _eventFlow.emit(UiEvent.ERROR("결과를 불러오는데 실패하였습니다."))
            }
        }
    }
}