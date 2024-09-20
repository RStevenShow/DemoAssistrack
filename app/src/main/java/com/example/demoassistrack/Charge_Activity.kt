package com.example.demoassistrack

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.logging.Handler


class Charge_Activity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
       //Aqui se configura la pantalla inicial de la interfaz de usuario
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }
        //aqui inicio con mis configuraciones propias no las q me crea kotlin

        val handler = android.os.Handler()
        handler.postDelayed({
            // Iniciar la actividad de login
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish() // Cierra la actividad de carga
        }, 3000) // 3000 milisegundos = 2 segundos
    }







}



