package com.example.lesson3

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.e("ACTIVITY","onCreate $savedInstanceState")
    }

    override fun onResume() {
        super.onResume()
        Log.e("ACTIVITY","onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.e("ACTIVITY","onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.e("ACTIVITY","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("ACTIVITY","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("ACTIVITY","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("ACTIVITY","onDestroy")
    }
}