package com.example.demoassistrack.UI

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demoassistrack.Model.LoginRequest
import com.example.demoassistrack.Model.LoginResponse
import com.example.demoassistrack.R
import com.example.demoassistrack.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var txtUsuario: EditText
lateinit var txtContrasena: EditText
lateinit var btnLogin: Button

class Login : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtUsuario = findViewById(R.id.txtUser)
        txtContrasena = findViewById(R.id.txtPassword)
        btnLogin = findViewById(R.id.btnAcceder)

        btnLogin.setOnClickListener {
            val email = txtUsuario.text.toString()
            val password = txtContrasena.text.toString()
            performLogin(email, password)
        }
    }

    private fun performLogin(email: String, password: String) {
        val loginRequest = LoginRequest(email, password)

        RetrofitClient.apiService.login(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    // Maneja la respuesta aquí
                    Toast.makeText(this@Login, "Login exitoso", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@Login, "Login fallido", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@Login, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
