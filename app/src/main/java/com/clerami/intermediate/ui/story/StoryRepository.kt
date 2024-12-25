package com.clerami.intermediate.ui.story


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.clerami.intermediate.data.remote.response.ListStoryItem
import com.clerami.intermediate.data.remote.retrofit.ApiService
import kotlinx.coroutines.flow.Flow

open class StoryRepository(private val apiService: ApiService) {

    fun getStories(token: String): Flow<PagingData<ListStoryItem>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { StoryPagingSource(apiService, token) }
        ).flow
    }


}