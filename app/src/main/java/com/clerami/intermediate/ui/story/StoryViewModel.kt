package com.clerami.intermediate.ui.story

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.clerami.intermediate.data.remote.response.ListStoryItem
import com.clerami.intermediate.data.remote.retrofit.ApiService
import kotlinx.coroutines.launch

class StoryViewModel(
    private val storyRepository: StoryRepository,

) : ViewModel() {

    private val _stories = MutableLiveData<PagingData<ListStoryItem>>()
    val stories: LiveData<PagingData<ListStoryItem>> = _stories

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun getStories(token: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {

                storyRepository.getStories("Bearer $token").collect { pagingData ->
                    _stories.value = pagingData
                    _isLoading.value = false
                }
            } catch (exception: Exception) {
                _isLoading.value = false
                _errorMessage.value = "Error loading stories: ${exception.message}"
            }
        }
    }
}
