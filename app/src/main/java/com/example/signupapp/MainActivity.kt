package com.example.signupapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName: EditText = findViewById(R.id.etName)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val etAge: EditText = findViewById(R.id.etAge)
        val rgGender: RadioGroup = findViewById(R.id.rgGender)
        val cbReading: CheckBox = findViewById(R.id.cbReading)
        val cbTraveling: CheckBox = findViewById(R.id.cbTraveling)
        val cbGaming: CheckBox = findViewById(R.id.cbGaming)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val password = etPassword.text.toString()
            val age = etAge.text.toString()
            val selectedGenderId = rgGender.checkedRadioButtonId
            val selectedGender: RadioButton = findViewById(selectedGenderId)
            val gender = selectedGender.text.toString()
            val hobbies = mutableListOf<String>()
            if (cbReading.isChecked) hobbies.add("Reading")
            if (cbTraveling.isChecked) hobbies.add("Traveling")
            if (cbGaming.isChecked) hobbies.add("Gaming")

            val intent = Intent(this, DisplayDataActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("password", password)
            intent.putExtra("age", age)
            intent.putExtra("gender", gender)
            intent.putStringArrayListExtra("hobbies", ArrayList(hobbies))
            startActivity(intent)
        }
    }
}
