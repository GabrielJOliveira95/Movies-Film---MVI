package com.example.movieslist_mvi.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.movieslist_mvi.R
import com.example.movieslist_mvi.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var viewModel: LoginViewModel
    lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        initObservers()
    }

    private fun initObservers() {
        viewModel.checkFields.observe(viewLifecycleOwner, {
            if (it) {
                findNavController().navigate(R.id.action_loginFragment_to_moviesListFragment)
            }
        })
        viewModel.errorMensage.observe(viewLifecycleOwner, {
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
        })
    }

    private fun setListeners() {
        binding.loginScreemLoginBtn.setOnClickListener {
            val userName = binding.loginScreemUserNameEt.text.toString()
            val password = binding.loginScreemPasswordEt.text.toString()
            viewModel.checkLogin(LoginIntent.Login(userName, password))
        }
    }
}