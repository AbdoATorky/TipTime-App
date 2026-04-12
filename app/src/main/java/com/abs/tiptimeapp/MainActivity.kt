package com.abs.tiptimeapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.abs.tiptimeapp.databinding.ActivityMainBinding
import kotlin.math.ceil
import kotlin.math.floor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.calculateBtn.setOnClickListener {
            val cost = binding.serviceEt.text.toString().toDouble()
            val checkedRB = binding.group.checkedRadioButtonId
            val tip = when(checkedRB){
                R.id.amazing_rb ->0.2
                R.id.good_rb -> 0.18
                else -> 0.15
            }
            var total = cost * tip
            if (binding.roundTipSwitch.isChecked)
                total = floor(total)

            binding.resultTv.text = "$$total"
        }

    }
}