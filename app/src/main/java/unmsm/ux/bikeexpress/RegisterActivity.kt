package unmsm.ux.bikeexpress
import android.util.Log
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import unmsm.ux.bikeexpress.ui.theme.crearGradienteFondo

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etNombres: EditText = findViewById(R.id.etNombres)
        val etApellidos: EditText = findViewById(R.id.etApellidos)
        val etDni: EditText = findViewById(R.id.etDni)
        val etTelefono: EditText = findViewById(R.id.etTelefono)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val etRepeatPassword: EditText = findViewById(R.id.etRepeatPassword)
        val btnRegister: Button = findViewById(R.id.btnRegister)
        val rootLayout = findViewById<ConstraintLayout>(R.id.register)
        rootLayout.background = crearGradienteFondo()

        btnRegister.setOnClickListener {
            val nombres = etNombres.text.toString()
            val apellidos = etApellidos.text.toString()
            val dni = etDni.text.toString()
            val telefono = etTelefono.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val repeatPassword = etRepeatPassword.text.toString()

            // Validar que los campos no estén vacíos
            if (nombres.isEmpty() || apellidos.isEmpty() || dni.isEmpty() || telefono.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, llena todos los campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validar contraseñas iguales
            if (password != repeatPassword) {
                Toast.makeText(this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Guardar datos en SharedPreferences
            val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("email", email)
            editor.putString("password", password)
            editor.apply()
            Log.d("RegisterActivity", "Correo: $email, Contraseña: $password")
            // Registro exitoso
            Toast.makeText(this, "Usuario registrado correctamente.", Toast.LENGTH_SHORT).show()

            // Ir a la pantalla de inicio de sesión
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
