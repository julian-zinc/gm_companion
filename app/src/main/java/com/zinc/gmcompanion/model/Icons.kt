package com.zinc.gmcompanion.model

import android.util.Log
import com.zinc.gmcompanion.R
import java.lang.reflect.Field
import java.util.*

class Icons {
    private val adventureIcons: List<Pair<Int, String>> by lazy { getAllAdventureIcons() }

    private fun getAllAdventureIcons(): List<Pair<Int, String>> {
        val fields: Array<Field> = R.mipmap::class.java.fields
        val idsToNames = mutableListOf<Pair<Int, String>>()
        Log.d("LOG_TAG", "processing-.--")
        fields.filter { it.name.startsWith("adventureicons") }
            .map { idsToNames.add(it.getInt(null) to processIconName(it.name)) }
        return idsToNames
    }

    private fun processIconName(iconName: String): String =
        iconName.removePrefix("adventureicons_").replace("_", " ")
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

    fun getAdventureIcons(quantity: Int): List<Pair<Int, String>> {
        val resList = mutableListOf<Pair<Int, String>>()
        for (x in 0 until quantity) resList.add(adventureIcons.random())
        Log.d("LOG_TAG", "reslistSize: ${resList.size}")
        return resList
    }
}