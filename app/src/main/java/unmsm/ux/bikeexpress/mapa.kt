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

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.nav_view)

        // Configura el botón "rayas" para abrir el Drawer
        val imageButtonRayas = findViewById<ImageButton>(R.id.imageButton4)
        imageButtonRayas.setOnClickListener {
            // Abre el DrawerLayout cuando se hace clic en "rayas"
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Configura el Listener para el NavigationView
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    // Maneja la acción de "Home"
                }
                /*
                R.id.nav_settings -> {
                    // Maneja la acción de "Settings"
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