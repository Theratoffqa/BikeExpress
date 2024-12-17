package unmsm.ux.bikeexpress
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import unmsm.ux.bikeexpress.ui.theme.crearGradienteFondo


class CalificarServicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calificar_servicio)

        // Referencias a los elementos del diseño
        val ratingBar: RatingBar = findViewById(R.id.ratingBar)
        val etOpinion: EditText = findViewById(R.id.etOpinion)
        val btnEnviar: Button = findViewById(R.id.btnEnviar)
        val btnCancelar: Button = findViewById(R.id.btnCancelar)


        // Configurar acción del botón Enviar
        btnEnviar.setOnClickListener {
            val rating = ratingBar.rating // Obtener la calificación
            val opinion = etOpinion.text.toString() // Obtener la opinión escrita

            // Validar si el usuario ingresó algo
            if (opinion.isEmpty()) {
                Toast.makeText(this, "Por favor escribe tu opinión.", Toast.LENGTH_SHORT).show()
            } else {
                // Aquí puedes manejar el envío de datos al servidor o base de datos
                mostrarDialogoGracias() // Mostrar el diálogo de agradecimiento
            }
        }

        // Configurar acción del botón Cancelar
        btnCancelar.setOnClickListener {
            // Cerrar la actividad actual
            Toast.makeText(this, "Calificación cancelada.", Toast.LENGTH_SHORT).show()
            finish()
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.background = crearGradienteFondo()
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
                    val intent = Intent(this, CalificarServicioActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_mapa -> {
                    val intent = Intent(this, mapa::class.java)
                    startActivity(intent)
                }
                R.id.nav_logout -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
            // Cierra el Drawer después de seleccionar una opción
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    // Función para mostrar el diálogo de agradecimiento
    private fun mostrarDialogoGracias() {
        // Crear el diálogo
        val dialog = AlertDialog.Builder(this).create()

        // Inflar el diseño personalizado
        val layout = layoutInflater.inflate(R.layout.dialogo_agradecimiento, null)
        dialog.setView(layout)

        // Configurar el botón Cerrar
        val btnCerrarDialogo: Button = layout.findViewById(R.id.btnCerrarDialogo)
        btnCerrarDialogo.setOnClickListener {
            dialog.dismiss() // Cerrar el diálogo
        }

        // Mostrar el diálogo
        dialog.show()
    }
}