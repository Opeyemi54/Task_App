package com.hfad.taskapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.hfad.taskapp.viewModels.EditTaskViewModel
import com.hfad.taskapp.R
import com.hfad.taskapp.dataBase.TaskDatabase
import com.hfad.taskapp.databinding.FragmentEditTaskBinding
import com.hfad.taskapp.viewModels.EditTaskViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class EditTaskFragment : Fragment() {
    private var _binding: FragmentEditTaskBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var editTaskViewModelFactory: EditTaskViewModel.Factory

    // Extract taskId from the fragment arguments
    private val taskId: Long by lazy {
        EditTaskFragmentArgs.fromBundle(requireArguments()).taskId
    }

    private val viewModel: EditTaskViewModel by viewModels {
        EditTaskViewModelFactory(editTaskViewModelFactory, taskId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentEditTaskBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.navigateToList.observe(viewLifecycleOwner) { navigate ->
            if (navigate) {
                view?.findNavController()?.navigate(R.id.action_editTaskFragment_to_taskFragment)
                viewModel.onNavigatedToList()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

