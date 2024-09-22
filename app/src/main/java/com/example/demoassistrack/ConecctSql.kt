package com.example.demoassistrack
import android.annotation.SuppressLint
import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConecctSql {
    private val ip = "192.168.13.139"
    private val db = "Hackaton"
    private val username = "Radmin"
    private val password = "1007031029M"




    class ConecctSql {
        private val ip = "192.168.13.139"
        private val db = "Hackaton"
        private val username = "Radmin"
        private val password = "1007031029M"

        @SuppressLint("NewApi")
        fun connect(): Connection? {
            var connection: Connection? = null
            var connectionURL: String? = null
            try {
                val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
                StrictMode.setThreadPolicy(policy)

                Class.forName("net.sourceforge.jtds.jdbc.Driver")
                connectionURL = "jdbc:jtds:sqlServer://$ip;databaseName=$db;user=$username;password=$password"
                connection = DriverManager.getConnection(connectionURL)
            } catch (e: SQLException) {
                Log.e("Error de Conexion SQL:", e.message ?: "SQLException sin mensaje")
            } catch (e: ClassNotFoundException) {
                Log.e("Error de Conexion SQL:", e.message ?: "Driver no encontrado")
            } catch (e: Exception) {
                Log.e("Error de Conexion SQL:", e.message ?: "Error general")
            }
            return connection
        }
    }






}

