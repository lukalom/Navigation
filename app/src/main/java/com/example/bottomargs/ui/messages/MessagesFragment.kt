package com.example.bottomargs.ui.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bottomargs.R
import com.example.bottomargs.databinding.FragmentMessagesBinding

class MessagesFragment : Fragment() {

    private var _binding: FragmentMessagesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val messagesViewModel =
            ViewModelProvider(this).get(MessagesViewModel::class.java)

        _binding = FragmentMessagesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMessages
        messagesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        binding.btSendInfo.setOnClickListener {
            sendData()
        }
        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun sendData(){
        val action = MessagesFragmentDirections.actionNavigationMessagesToInfoFragment(99)
        this.findNavController().navigate(action)
    }
}