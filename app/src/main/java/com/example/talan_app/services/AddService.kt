package com.example.talan_app.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.talan_app.R
import com.example.talan_app.databinding.ActivityAddServiceBinding
import com.google.android.material.textfield.TextInputEditText

class AddService : AppCompatActivity() {

    private lateinit var binding: ActivityAddServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.DescriptionServ.setOnClickListener {
            var txt : String = "Le Bitcoin, depuis quelques années déjà, fait beaucoup parler de lui. Mais savez-vous au juste de quoi il s’agit ? Qui l’a créé ? À quoi sert-il ? Comment payer en Bitcoin ? Comment acheter du Bitcoin ? Comment miner des Bitcoins ?"
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