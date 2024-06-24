package com.example.signupapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_data)

        val tvData: TextView = findViewById(R.id.tvData)

        val name = intent.getStringExtra("name")
        val password = intent.getStringExtra("password")
        val age = intent.getStringExtra("age")
        val gender = intent.getStringExtra("gender")
        val hobbies = intent.getStringArrayListExtra("hobbies")

        val data = """
            Name: $name
            Password: $password
            Age: $age
            Gender: $gender
            Hobbies: ${hobbies?.joinToString(", ")}
        """.trimIndent()

        tvData.text = data
    }
}
