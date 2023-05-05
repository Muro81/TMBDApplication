package com.example.tmbdapp.core.utils

import android.content.Context
import androidx.preference.PreferenceManager
import com.example.tmbdapp.domain.model.Movie
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceCache @Inject constructor(@ApplicationContext val context: Context) {
    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    var watchList : MutableList<Movie>
        get() = WATCH_LIST
        set(value) = with(prefs.edit()) {
            WATCH_LIST=value
            apply()
        }

    companion object {
        private var WATCH_LIST = mutableListOf<Movie>()
    }
}