package unmsm.ux.bikeexpress.ui.theme
import android.graphics.Color
import android.graphics.drawable.GradientDrawable

fun crearGradienteFondo(): GradientDrawable {
    // Definir los colores
    val colorSuperior = "#E57373"  // Salmón
    val colorCentral = "#FFFFFF"   // Blanco
    val colorInferior = "#E57373"  // Salmón

    // Crear el gradiente con tres colores
    val gradiente = GradientDrawable(
        GradientDrawable.Orientation.TOP_BOTTOM,
        intArrayOf(
            android.graphics.Color.parseColor(colorSuperior), // Parte superior
            android.graphics.Color.parseColor(colorCentral),  // Parte central (blanco)
            android.graphics.Color.parseColor(colorCentral),
            android.graphics.Color.parseColor(colorCentral),
            android.graphics.Color.parseColor(colorCentral),
            android.graphics.Color.parseColor(colorCentral),
            android.graphics.Color.parseColor(colorCentral),
            android.graphics.Color.parseColor(colorCentral),
            android.graphics.Color.parseColor(colorCentral),
            android.graphics.Color.parseColor(colorInferior)   // Parte inferior
        )
    )

    // Especificar cómo se distribuyen los colores a lo largo del fondo
    gradiente.cornerRadius = 0.5f  // Sin bordes redondeados, si prefieres bordes redondeados, cambia este valor.

    return gradiente
}