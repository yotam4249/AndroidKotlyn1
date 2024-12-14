package com.example.lesson3

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.Button
import com.example.lesson3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    enum class Turn{
        NOUGHT,
        CROSS
    }
    private var firstTurn=Turn.CROSS
    private var currentTurn=Turn.CROSS

    private var boardList = mutableListOf<Button>()

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        initBoard()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.e("ACTIVITY","onCreate $savedInstanceState")
    }

    private fun initBoard() {
        boardList.add(binding.a1)
        boardList.add(binding.a2)
        boardList.add(binding.a3)
        boardList.add(binding.b1)
        boardList.add(binding.b2)
        boardList.add(binding.b3)
        boardList.add(binding.c1)
        boardList.add(binding.c2)
        boardList.add(binding.c3)


    }

    fun boardTapped(view: View){
        if(view !is Button){
            return
        }
        addToBoard(view)
    }
    private fun addToBoard(button: Button) {
        if(button.text!="")
            return
        if(currentTurn==Turn.NOUGHT){
            button.text= NOUGHT
            currentTurn=Turn.CROSS
        }
        else if(currentTurn==Turn.CROSS){
            button.text= CROSS
            currentTurn=Turn.NOUGHT
    }
        setTurnLabel()
    }

    private fun setTurnLabel() {
        var turnText=""
        if(currentTurn==Turn.CROSS){
            turnText="Turn$CROSS"
        }
        else if(currentTurn==Turn.NOUGHT){
            turnText="Turn$NOUGHT"
        }
        binding.turnTV.text=turnText
    }

    companion object{
        const val CROSS="X"
        const val NOUGHT="0"
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

