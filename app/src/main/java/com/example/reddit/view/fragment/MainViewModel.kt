package com.example.reddit.view.fragment

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.reddit.domain.model.ArticleList
import com.example.reddit.domain.usecase.GetList
import com.example.reddit.utils.Resource
import com.example.reddit.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val getList: GetList) : BaseViewModel() {

    private val _list = MutableStateFlow(emptyList<ArticleList>())
    val list get() = _list.asStateFlow()


    init {
        initRequest()
    }

    fun initRequest() {
        viewModelScope.launch {
            coroutineScope {
                fetchList()
            }
            setUiState()
        }
    }

    private suspend fun fetchList() {
        getList().collect { response ->

            when (response) {

                is Resource.Success -> {
                    _list.value = response.data.data?.children!!
                    Log.d("TAG", "fetchList: ${response.data.data?.children}")
                    areResponsesSuccessful.add(true)
                    isInitial = false
                }
                is Resource.Error -> {
                    areResponsesSuccessful.add(false)
                    Log.d("TAG", "fetchList: ${response.message}")
                    errorText = response.message
                }
            }
        }
    }

}