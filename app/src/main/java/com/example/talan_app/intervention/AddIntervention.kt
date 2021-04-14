package com.example.talan_app.intervention

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.talan_app.R
import com.example.talan_app.databinding.ActivityAddInterventionBinding
import com.google.android.material.textfield.TextInputEditText

class AddIntervention : AppCompatActivity() {
    private lateinit var binding : ActivityAddInterventionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddInterventionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.DescriptionInterv.setOnClickListener {
            var txt : String = "Dans un programme, une coroutine est une unité de traitement qui s'apparente à une routine, à ceci près que, alors que la sortie d'une routine met fin à la routine, la sortie de la coroutine peut être le résultat d'une suspension de son traitement jusqu'à ce qu'il lui soit signalé de reprendre son cours"
                    descriptioview(txt)
        }

    }
    fun descriptioview(txt :String){
        val view = View.inflate(this,R.layout.dialog_description_detaille,null)
        val builder = AlertDialog.Builder(this)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        val textView = dialog.findViewById<TextInputEditText>(R.id.DetaiDescription) as TextView
        textView.text= txt
        dialog.findViewById<Button>(R.id.btnok1)?.setOnClickListener { dialog.dismiss() }
    }
}