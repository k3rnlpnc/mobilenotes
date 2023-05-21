package com.shurygina.mobilenotes

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import com.shurygina.mobilenotes.db.MainDb

@RequiresApi(Build.VERSION_CODES.O)
class TaskAdapter(private var context: Context, private var items: List<Task>) :
    ArrayAdapter<Task>(context, R.layout.task_item, items) {
    @SuppressLint("ResourceAsColor")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = layoutInflater.inflate(R.layout.task_item, parent, false)

        val currentTask = items[position]

        val title = view.findViewById<TextView>(R.id.title)
        title.text = currentTask.title

        val done = view.findViewById<CheckBox>(R.id.isDone)
        done.isChecked = items[position].isDone
        done.setOnClickListener {
            items[position].isDone = !items[position].isDone
        }

        val removeBtn = view.findViewById<Button>(R.id.removeBtn)
        removeBtn.setOnClickListener {
            this.remove(items[position])
        }

        return view
    }

    override fun getPosition(item: Task?): Int {
        return super.getPosition(item)
    }

    override fun remove(`object`: Task?) {
        notifyDataSetChanged()
        super.remove(`object`)
    }
}