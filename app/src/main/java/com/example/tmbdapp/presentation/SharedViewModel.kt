package com.example.tmbdapp.presentation

import androidx.lifecycle.ViewModel
import com.example.tmbdapp.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

}

