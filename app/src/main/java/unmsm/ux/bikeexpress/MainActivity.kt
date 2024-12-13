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

##Hay muchas cosas que cambie asi que lo aniaditodo
#package com.example.myvideo
#
#import android.os.Bundle
#import androidx.activity.enableEdgeToEdge
#import androidx.appcompat.app.AppCompatActivity
#import androidx.core.view.ViewCompat
#import androidx.core.view.WindowInsetsCompat
#import com.google.android.gms.maps.CameraUpdateFactory
#import com.google.android.gms.maps.GoogleMap
#import com.google.android.gms.maps.OnMapReadyCallback
#import com.google.android.gms.maps.SupportMapFragment
#import com.google.android.gms.maps.model.LatLng

#class MainActivity : AppCompatActivity(), OnMapReadyCallback {
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
