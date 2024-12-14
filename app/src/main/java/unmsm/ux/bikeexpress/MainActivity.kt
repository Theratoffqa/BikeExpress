package unmsm.ux.bikeexpress
import android.content.Intent
import android.util.Log
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng


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

                val intent = Intent(this, mapa::class.java)
                startActivity(intent)


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

/*class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    #override fun onCreate(savedInstanceState: Bundle?) {
        #super.onCreate(savedInstanceState)
        #enableEdgeToEdge()
        #setContentView(R.layout.activity_main)
        #ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            #val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            #v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            #insets
        #}

        #val mapFragment =
            #supportFragmentManager.findFragmentById(R.id.map_fragment) as? SupportMapFragment

        #mapFragment?.getMapAsync(this)
    #}

    #override fun onMapReady(map: GoogleMap?) {
        #val latLng = LatLng(-12.05337501666028, -77.08552357119221)
        #map?.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,19f))

    #}



#}
*/