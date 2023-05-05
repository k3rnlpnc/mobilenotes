package com.shurygina.mobilenotes

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.shurygina.mobilenotes.databinding.TaskItemBinding

class TaskAdapter(private var context: Context, private var items: List<String>) :
    ArrayAdapter<String>(context, R.layout.task_item, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view: View = layoutInflater.inflate(R.layout.task_item, parent, false)

        val currentTask = items[position]

        var title = view.findViewById<TextView>(R.id.title)
        title.text = currentTask

        return view
    }
}