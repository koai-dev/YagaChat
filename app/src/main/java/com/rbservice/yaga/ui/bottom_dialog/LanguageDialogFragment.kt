package com.rbservice.yaga.ui.bottom_dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rbservice.yaga.databinding.DialogFragmentLanguageBinding

class LanguageDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding: DialogFragmentLanguageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogFragmentLanguageBinding.inflate(layoutInflater)
        return binding.root
    }
}