package fr.tifo.challengetifo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.tifo.challengetifo.R
import fr.tifo.challengetifo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var _binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
    }
}