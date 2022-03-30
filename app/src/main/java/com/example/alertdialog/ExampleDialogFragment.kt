package com.example.alertdialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class ExampleDialogFragment() : DialogFragment() {
    lateinit var name: String

    //Secondary Constructor untuk menangani jika DialogFragment membutuhkan data custom
    constructor(name: String): this(){
        this.name = name
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example_dialog, container, false)
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Cek apakah variable name sudah diinisialisasi?
        if(this::name.isInitialized){
            view.findViewById<TextView>(R.id.hello_text_view).text = name
        }

        view.findViewById<Button>(R.id.close_button_fragment).setOnClickListener {
            Toast.makeText(activity, "DialogFragment ditutup dari dalam fragment", Toast.LENGTH_LONG).show()
            dialog?.dismiss()
        }
    }

}