package com.example.demoassistrack





import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

lateinit var txtUsuario: EditText
lateinit var txtContrasena: EditText
lateinit var btnLogin: Button


class Login : AppCompatActivity() {
    private var connectSql = ConecctSql()

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

        txtUsuario=findViewById(R.id.txtUser)
        txtContrasena=findViewById(R.id.txtPassword)
        btnLogin=findViewById(R.id.btnAcceder)



        btnLogin.setOnClickListener {



    }

      
}
}