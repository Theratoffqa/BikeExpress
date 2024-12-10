package unmsm.ux.bikeexpress

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Cargar el diseño de activity_main.xml
        setContentView(R.layout.activity_main)

        val textViewCounter: TextView = findViewById(R.id.textViewCounter)
        val buttonIngresar: Button = findViewById(R.id.loginButton)

        buttonIngresar.setOnClickListener {
            counter++ // Aumenta el contador
            textViewCounter.text = "Contador: $counter" // Actualiza el TextView con el nuevo valor
        }
    }
}
