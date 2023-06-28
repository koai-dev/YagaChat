package com.rbservice.yaga.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.rbservice.yaga.databinding.FragmentFaBinding

abstract class FaFragment : Fragment() {
    private lateinit var rootBinding: FragmentFaBinding
    private var binding: ViewBinding? = null
    var baseAction: BaseAction? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootBinding = FragmentFaBinding.inflate(layoutInflater)
        binding = getBindingView(container)
        if (binding!=null){
            rootBinding.container.addView(binding!!.root)
        }
        return rootBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (binding != null) {
            initView(savedInstanceState, binding!!)
            baseAction?.getData()
            baseAction?.onClick()
            baseAction?.onObserver()
        }
    }

    abstract fun getBindingView(container: ViewGroup?): ViewBinding?

    abstract fun initView(savedInstanceState: Bundle?, binding: ViewBinding)
}