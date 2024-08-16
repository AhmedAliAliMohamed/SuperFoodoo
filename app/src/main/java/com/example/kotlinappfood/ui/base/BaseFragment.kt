package com.example.kotlinappfood.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseFragment<viewModel : BaseViewModel,binding : ViewBinding>(private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> binding) : Fragment() {
    @Inject
    lateinit var viewModel: viewModel
     private var _binding: binding? = null
     protected val binding: binding get() = _binding ?: error("Must only access binding while fragment is attached.")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        _binding = bindingInflater(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initViewModel()
        initObservers()
        initErrorObservers()
    }

    protected abstract fun initListeners()
    protected abstract fun initViewModel()
    protected abstract fun initObservers()
    protected abstract fun initErrorObservers()


}