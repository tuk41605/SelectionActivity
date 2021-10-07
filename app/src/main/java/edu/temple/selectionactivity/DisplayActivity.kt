package edu.temple.selectionactivity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super .onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val image = intent.getIntExtra("IMAGE", -1)
        val description = intent.getStringExtra("DESCRIPTION")

        val imageView = findViewById<ImageView>(R.id.spaceImageView)
        imageView.setImageResource(image)

        val textView = findViewById<TextView>(R.id.spaceTextView).apply {
            text = description
        }
    }
}