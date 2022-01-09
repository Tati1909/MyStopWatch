package com.example.mystopwatch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.mystopwatch.app
import com.example.mystopwatch.databinding.FragmentStopwatchBinding
import com.example.mystopwatch.viewmodel.StopwatchViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StopwatchFragment : Fragment() {

    private var _binding: FragmentStopwatchBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: StopwatchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStopwatchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, app.stopwatchViewModelFactory)
            .get(StopwatchViewModel::class.java)

        setListeners()

        /**
         * вызываем из сопрограммы
         */
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                //import kotlinx.coroutines.flow.collect
                viewModel.ticker.collect {
                    binding.textTime.text = it
                }
            }
        }
    }

    private fun setListeners() {
        binding.buttonStart.setOnClickListener {
            viewModel.onStartClicked()
        }
        binding.buttonPause.setOnClickListener {
            viewModel.onPauseClicked()
        }
        binding.buttonStop.setOnClickListener {
            viewModel.onStopClicked()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}