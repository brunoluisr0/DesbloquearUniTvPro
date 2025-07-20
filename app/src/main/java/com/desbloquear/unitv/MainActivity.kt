package com.desbloquear.unitv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val btn = Button(this).apply {
            text = "Ativar UniTv Pro"
            setOnClickListener {
                try {
                    Runtime.getRuntime().exec(arrayOf("su", "-c", "pm enable com.global.unitviptv")).waitFor()
                    Toast.makeText(this@MainActivity, "UniTv Pro reativado!", Toast.LENGTH_LONG).show()
                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, "Erro: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
        setContentView(btn)
    }
}
