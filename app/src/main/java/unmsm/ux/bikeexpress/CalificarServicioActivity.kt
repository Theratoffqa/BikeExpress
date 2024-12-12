package unmsm.ux.bikeexpress
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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