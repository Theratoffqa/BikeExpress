package unmsm.ux.bikeexpress

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions

class qrActivity : AppCompatActivity() {

    private lateinit var btnqr : Button
    private lateinit var tv1 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.qr)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnqr = findViewById(R.id.btnqr)
        tv1 = findViewById(R.id.tv1)

        registerUiListener()

    }

    private fun registerUiListener(){

        btnqr.setOnClickListener {
            scannerLauncher.launch(
                ScanOptions().setPrompt("Escanear Qr").setDesiredBarcodeFormats(ScanOptions.QR_CODE))


        }
    }

    private val  scannerLauncher = registerForActivityResult<ScanOptions , ScanIntentResult>(
        ScanContract()

    ){result ->

        if(result.contents == null){

            Toast.makeText(this , "Cancelled" , Toast.LENGTH_SHORT).show()

        }else{

            tv1.text = buildString {
                append("COD:")
                append(result.contents)
            }
            val intent = Intent(this, notificacionActivity::class.java)
            startActivity(intent)
        }
    }
}