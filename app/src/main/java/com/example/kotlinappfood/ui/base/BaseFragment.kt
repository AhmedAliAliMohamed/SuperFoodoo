package com.example.kotlinappfood.ui.base

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.kotlinappfood.R
import com.example.kotlinappfood.databinding.ViewProgressBinding
import javax.inject.Inject

abstract class BaseFragment<viewModel : BaseViewModel,binding : ViewBinding>
    (private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> binding) : Fragment() {
    @Inject
    lateinit var viewModel: viewModel
     private var _binding: binding? = null
     protected val binding: binding get() = _binding ?: error("Must only access binding while fragment is attached.")
     private lateinit var alertDialog : Dialog

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
        alertDialog = Dialog(requireActivity())
        initListeners()
        initViewModel()
        initObservers()
        initErrorObservers()
    }

    protected abstract fun initListeners()
    protected abstract fun initViewModel()
    protected abstract fun initObservers()
    protected abstract fun initErrorObservers()


    protected fun showProgressDialog() {
        val binding: ViewProgressBinding = ViewProgressBinding.inflate(layoutInflater)
        alertDialog.setContentView(binding.root)
        alertDialog.setCancelable(false)
        alertDialog.show() // Ensure the window is created by showing the dialog first
        // Now, modify the dialog window insets
        alertDialog.window?.setBackgroundDrawableResource(R.color.transparent)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            alertDialog.window?.let { window ->
                window.setDecorFitsSystemWindows(false)
                window.insetsController?.let { controller ->
                    controller.hide(WindowInsets.Type.navigationBars())
                    controller.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                }
            }
        } else {
            // Fallback for older versions
            @Suppress("DEPRECATION")
            alertDialog.window!!.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }

    protected fun hideProgressDialog() {
        if (alertDialog.isShowing) {
            alertDialog.dismiss()
        }
    }


}