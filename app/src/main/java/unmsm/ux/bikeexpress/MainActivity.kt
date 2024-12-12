package unmsm.ux.bikeexpress
import android.content.Intent
import android.util.Log
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonIngresar: Button = findViewById(R.id.loginButton)
        val buttonRegistrarse: Button = findViewById(R.id.register)

        buttonIngresar.setOnClickListener {
            val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val savedEmail = sharedPreferences.getString("email", "")
            val savedPassword = sharedPreferences.getString("password", "")

            val inputEmail = findViewById<EditText>(R.id.email).text.toString()
            val inputPassword = findViewById<EditText>(R.id.password).text.toString()

            Log.d("MainActivity", "Correo guardado: $savedEmail, Contraseña guardada: $savedPassword")
            Log.d("MainActivity", "Correo ingresado: $inputEmail, Contraseña ingresada: $inputPassword")

            if (inputEmail == savedEmail && inputPassword == savedPassword) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                // Navegar al menú principal
            } else {
                Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
        buttonRegistrarse.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
