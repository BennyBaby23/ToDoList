package com.mdev.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var ToDoTask = mutableListOf<ToDo>(
        ToDo("Buy Vegetable", "Tomato,Onion"),
        ToDo("Complete Assignment", "Mobile computing"))

    lateinit var addListFAB: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addListFAB = findViewById(R.id.add_List_FAB)

        addListFAB.setOnClickListener{
            showCreateTVShowDialog()
        }
    }
    private fun showCreateTVShowDialog() {
        val dialogTitle = getString(R.string.dialog_title)
        val positiveButtonTitle = getString(R.string.add_ToDo_List)
        val builder = android.app.AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.add_new_todo_list, null)

        builder.setTitle(dialogTitle)
        builder.setView(view)

        builder.setPositiveButton(positiveButtonTitle) { dialog, _ ->
            dialog.dismiss()
            val ToDoEditText = view.findViewById<EditText>(R.id.ToDo_EditText)
            val CommentEditText = view.findViewById<EditText>(R.id.Comment_EditText)
            val newToDoTask = ToDo(ToDoEditText.text.toString(), CommentEditText.text.toString())
            ToDoTask.add(newToDoTask)

        }
        builder.create().show()
    }
}