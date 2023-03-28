package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),Interface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
        override fun onButtonPressed(msg: String){
            var obj=supportFragmentManager.findFragmentById(R.id.fragment3) as BlankFragment3
            obj.onFragmentInteration(msg)
        }
    }