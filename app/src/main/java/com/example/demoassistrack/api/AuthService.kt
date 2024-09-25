package com.example.demoassistrack.api

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class AuthService {

    fun login(context: Context, url: String, username: String, password: String, callback: (Boolean, String?) -> Unit) {
        val stringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                try {
                    // Procesar la respuesta JSON
                    val jsonResponse = JSONObject(response)
                    val success = jsonResponse.getBoolean("success")

                    if (success) {
                        val nombreUsuario = jsonResponse.getString("nombreUsuario")
                        val nombre = jsonResponse.getString("nombre")
                        val apellido = jsonResponse.getString("apellido")
                        val email = jsonResponse.getString("Email")
                        val tipo = jsonResponse.getString("tipo")

                        // Llamar al callback de éxito
                        callback(true, "$nombre $apellido")
                    } else {
                        callback(false, "Usuario o contraseña incorrectos")
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(context, "Error al procesar la respuesta", Toast.LENGTH_SHORT).show()
                    callback(false, null)
                }
            },
            Response.ErrorListener { error ->
                // Manejo de errores
                error.printStackTrace()
                Toast.makeText(context, "Error en la solicitud: ${error.message}", Toast.LENGTH_SHORT).show()
                callback(false, null)
            }) {

            // Parámetros enviados al servidor
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["username"] = username
                params["password"] = password
                return params
            }
        }

        // Cola de solicitudes Volley
        val requestQueue = Volley.newRequestQueue(context)
        requestQueue.add(stringRequest)
    }
}
