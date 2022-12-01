package com.example.reddit.view.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.reddit.R
import com.example.reddit.databinding.FragmentHomeBinding
import com.example.reddit.domain.model.Article
import com.example.reddit.view.adapter.ArticleAdapter
import com.example.reddit.view.base.BaseFragment
import com.example.reddit.view.fragment.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel: MainViewModel by viewModels()

    val articleAdapter = ArticleAdapter()

    override val defineBindingVariables: ((FragmentHomeBinding) -> Unit)?
        get() = { binding ->
            binding.lifecycleOwner = viewLifecycleOwner
            binding.fragment = this

        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        collectFlows(listOf(::collectArticle, ::collectUiState))
    }


    private suspend fun collectArticle() {
        viewModel.list.collect {
            Log.d("TAG", "value: ${it}")

            articleAdapter.submitList(it)
        }
    }

    private suspend fun collectUiState() {
        viewModel.uiState.collect { state ->
            if (state.isError) showSnackbar(
                message = state.errorText!!,
                actionText = getString(R.string.button_retry),
                anchor = true
            ) {
                viewModel.retryConnection {
                    viewModel.initRequest()
                }
            }
        }
    }
}