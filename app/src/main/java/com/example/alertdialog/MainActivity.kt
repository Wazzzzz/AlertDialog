package com.example.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    private lateinit var alertDialogStandardButton: Button
    private lateinit var alertDialogActionButton: Button
    private lateinit var alertDialogCustomButton: Button
    private lateinit var alertDialogFragmentButton: Button
    private lateinit var alertDialogFragmentDataButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alertDialogStandardButton = findViewById(R.id.alert_dialog_standard_button)
        alertDialogActionButton = findViewById(R.id.alert_dialog_action_button)
        alertDialogCustomButton = findViewById(R.id.alert_dialog_custom_button)
        alertDialogFragmentButton = findViewById(R.id.fragment_dialog_button)
        alertDialogFragmentDataButton = findViewById(R.id.fragment_dialog_data_button)

        alertDialogStandardButton.setOnClickListener {
            alertDialogStandard()
        }

        alertDialogActionButton.setOnClickListener {
            alertDialogAction()
        }

        alertDialogCustomButton.setOnClickListener {
            alertDialogCustom()
        }

        alertDialogFragmentButton.setOnClickListener {
            alertDialogFragment()
        }

        alertDialogFragmentDataButton.setOnClickListener {
            alertDialogFragmentData()
        }

    }

    private fun alertDialogStandard(){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog Cancelable")
        dialog.setMessage("Dialog cancelable bisa ditutup dengan klik bagian luar dialog")
        dialog.setCancelable(true)
        dialog.show()
    }

    private fun alertDialogAction(){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog dengan button")
        dialog.setMessage("Dialog dengan button untuk berbagi aksi")
        dialog.setIcon(R.mipmap.ic_launcher)

        dialog.setCancelable(false)
        dialog.setPositiveButton("Positive button"){
                dialogInterface, p1 -> Toast.makeText(this, "Positive button clicked", Toast.LENGTH_LONG).show()
        }
        dialog.setNegativeButton("Negative button"){
                dialogInterface, p1 -> Toast.makeText(this, "Negative button clicked", Toast.LENGTH_LONG).show()
        }
        dialog.setNeutralButton("Neutral button"){
                dialogInterface, p1 -> Toast.makeText(this, "Neutral button clicked", Toast.LENGTH_LONG).show()
        }
        dialog.show()
    }

    private fun alertDialogCustom(){
        val view = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null, false)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(view)

        val dialog = dialogBuilder.create()

        view.findViewById<Button>(R.id.close_button).setOnClickListener {
            Toast.makeText(this,"Custom Dialog Closed",Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun alertDialogFragment(){
        val dialogFragment = ExampleDialogFragment()
        dialogFragment.show(supportFragmentManager, null)
    }

    private fun alertDialogFragmentData(){
        val dialogFragment = ExampleDialogFragment(findViewById<EditText>(R.id.name_edit_text).text.toString())
        dialogFragment.show(supportFragmentManager, null)
    }

}