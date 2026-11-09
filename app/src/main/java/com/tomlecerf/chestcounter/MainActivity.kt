package com.tomlecerf.chestcounter

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.view.Gravity

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(30, 30, 30, 30)

        val title = TextView(this)
        title.text = "FORTNITE CHEST COUNTER"
        title.textSize = 25f

        val button = Button(this)
        button.text = "Tester la capture d'écran"

        layout.addView(title)
        layout.addView(button)

        setContentView(layout)
    }
}
