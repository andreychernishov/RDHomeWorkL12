package com.example.rdhomeworkl12

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val emailEd: EditText = findViewById(R.id.email_ed)
        val messageEd: EditText = findViewById(R.id.message_ed)
        val sendBtn: Button = findViewById(R.id.send_btn)

        sendBtn.setOnClickListener {
            val email = arrayOf(emailEd.text.toString())
            val message = messageEd.text.toString()
            val intent = Intent(Intent.ACTION_SENDTO)
            val uri = Uri.parse("mailto:")
            intent.setData(uri)
            intent.putExtra(Intent.EXTRA_EMAIL, email)
            intent.putExtra(Intent.EXTRA_TEXT, message)
            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)

            }
        }

    }
}