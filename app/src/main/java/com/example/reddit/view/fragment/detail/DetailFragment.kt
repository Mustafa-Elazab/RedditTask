package com.example.reddit.view.fragment.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.reddit.R
import com.example.reddit.databinding.FragmentDetailBinding
import com.example.reddit.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {


    val navArgs by navArgs<DetailFragmentArgs>()


    override val defineBindingVariables: ((FragmentDetailBinding) -> Unit)?
        get() = { binding ->
            binding.article = navArgs.article
            binding.lifecycleOwner = viewLifecycleOwner
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}