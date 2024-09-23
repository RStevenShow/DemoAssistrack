package com.example.demoassistrack.UI

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demoassistrack.R
import android.view.animation.LinearInterpolator
import androidx.activity.enableEdgeToEdge

class Charge_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Configuración de borde a borde
        setContentView(R.layout.activity_main)

        // Configuración de WindowInsets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            WindowInsetsCompat.CONSUMED
        }

        // Animación de círculo
        val circleView = findViewById<ImageView>(R.id.circelview)

        // Crear la animación de escala (agrandarse)
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 2f)
        val scaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 2f)

        val scaleAnimator = ObjectAnimator.ofPropertyValuesHolder(circleView, scaleX, scaleY)
        scaleAnimator.duration = 3000// Duración de 2 segundos
        scaleAnimator.repeatCount = ObjectAnimator.INFINITE // Repetir indefinidamente
        scaleAnimator.repeatMode = ObjectAnimator.RESTART // Reiniciar al final

        // Crear la animación de rotación
        val rotateAnimator = ObjectAnimator.ofFloat(circleView, "rotation", 0f, 360f)
        rotateAnimator.duration = 2000
        rotateAnimator.repeatCount = ObjectAnimator.INFINITE
        rotateAnimator.interpolator = LinearInterpolator() // Rotación continua suave

        // Iniciar ambas animaciones
        scaleAnimator.start()
        rotateAnimator.start()

        // Cambiar a la actividad de login después de 3 segundos
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish() // Cierra la actividad de carga
        }, 2000) // 3000 milisegundos = 3 segundos
    }
}


