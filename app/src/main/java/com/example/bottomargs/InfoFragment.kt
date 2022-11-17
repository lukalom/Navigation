package com.example.bottomargs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.bottomargs.databinding.FragmentInfoBinding
import com.example.bottomargs.ui.dashboard.DashboardViewModel

class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null
    val args:InfoFragmentArgs by navArgs()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentInfoBinding.inflate(inflater, container, false)

        binding.tvInfo.text = args.number.toString()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}