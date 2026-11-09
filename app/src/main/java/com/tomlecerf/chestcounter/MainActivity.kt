
package com.tomlecerf.chestcounter

import android.app.Activity
import android.content.Context
import android.media.projection.MediaProjectionManager
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    companion object {
        private const val REQUEST_SCREEN_CAPTURE = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(32, 32, 32, 32)

        val title = TextView(this)
        title.text = "FORTNITE CHEST COUNTER"
        title.textSize = 25f
        title.gravity = Gravity.CENTER

        val button = Button(this)
        button.text = "TESTER LA CAPTURE D'ÉCRAN"

        button.setOnClickListener {
            try {
                val manager = getSystemService(
                    Context.MEDIA_PROJECTION_SERVICE
                ) as MediaProjectionManager

                val intent = manager.createScreenCaptureIntent()
                startActivityForResult(
                    intent,
                    REQUEST_SCREEN_CAPTURE
                )
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "Erreur : ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        layout.addView(title)
        layout.addView(button)

        setContentView(layout)
    }

    @Deprecated("Deprecated in Android API")
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: android.content.Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_SCREEN_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(
                    this,
                    "Autorisation de capture accordée !",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Capture refusée",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
