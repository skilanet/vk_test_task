package com.example.vk_test_task.ui

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import com.example.vk_test_task.R

class CustomSpinnerAdapter(
    context: Context,
    @LayoutRes private val res: Int,
    private val items: List<String>
) : ArrayAdapter<String>(context, res, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent) as TextView
        view.setTextColor(ContextCompat.getColor(context, R.color.white))
        view.gravity = Gravity.CENTER
        view.text = renderCodes(position)
        view.textSize = 32f
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent) as TextView
        view.text = items[position]
        return view
    }

    private fun renderCodes(position: Int): String {
        return when (position) {
            0 -> "₽"
            1 -> "$"
            2 -> "€"
            3 -> "¥"
            4 -> "£"
            else -> ""
        }
    }
}
