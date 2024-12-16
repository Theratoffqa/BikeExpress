package unmsm.ux.bikeexpress

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.navigation.NavigationView


class mapa : AppCompatActivity(),  OnMapReadyCallback {

    private lateinit var imageButtonqr : ImageButton
    private lateinit var mMap: GoogleMap
    private lateinit var drawerLayout: DrawerLayout // Declaro el DrawerLayout
    private lateinit var navigationView: NavigationView // Declaro el NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mapa)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val  mapFragment =
        supportFragmentManager.findFragmentById(R.id.map_fragment) as? SupportMapFragment

        mapFragment?.getMapAsync(this)
        imageButtonqr = findViewById(R.id.imageButtonqr)

        imageButtonqr.setOnClickListener {
            val intent = Intent(this, qrActivity::class.java)
            startActivity(intent)
        }

        // Inicializa el DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout)

        // Configura el botón para abrir el menú lateral
        val menuButton: ImageButton = findViewById(R.id.imageButton4)
        menuButton.setOnClickListener {
            // Abre el menú lateral (Drawer)
            drawerLayout.openDrawer(GravityCompat.START)
        }
        // Inicializa y configura el NavigationView
        navigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    // Acción cuando se selecciona "Inicio"
                    // Aquí podrías mostrar un mensaje o cambiar la pantalla
                }
                /*R.id.nav_profile -> {
                    // Acción cuando se selecciona "Perfil"
                }
                R.id.nav_settings -> {
                    // Acción cuando se selecciona "Configuración"
                }
                R.id.nav_logout -> {
                    // Acción cuando se selecciona "Cerrar sesión"
                }*/
            }
            // Cierra el Drawer después de seleccionar una opción
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }


    }

    override fun onMapReady(map: GoogleMap?) {
        val latLng = LatLng(-12.05337501666028, -77.08552357119221)
        map?.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,19f))

        }
}