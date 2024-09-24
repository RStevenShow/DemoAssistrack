package com.example.demoassistrack.UI

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demoassistrack.R
import com.example.demoassistrack.api.AuthService

class Login : AppCompatActivity() {

    private lateinit var txtUsuario: EditText
    private lateinit var txtContrasena: EditText
    private lateinit var btnLogin: Button
    private lateinit var authService: AuthService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        // Ajustes de interfaz
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicialización de los campos de texto y el botón
        txtUsuario = findViewById(R.id.txtUser)
        txtContrasena = findViewById(R.id.txtPassword)
        btnLogin = findViewById(R.id.btnAcceder)

        // Inicializar el servicio de autenticación
        authService = AuthService()

        // Acción al hacer clic en el botón de login
        btnLogin.setOnClickListener {
            val username = txtUsuario.text.toString()
            val password = txtContrasena.text.toString()

            // Validación simple de campos vacíos
            if (username.isNotEmpty() && password.isNotEmpty()) {
                authService.login(this, "http://10.0.2.2/Login.php", username, password) { success, message ->
                    if (success) {
                        Toast.makeText(this, "Bienvenido $message", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, message ?: "Error desconocido", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Por favor ingresa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

