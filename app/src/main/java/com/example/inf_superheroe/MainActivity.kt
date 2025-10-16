package com.example.inf_superheroe

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listaSuperheores: List<Superheores> = listOf(
            Superheores(1, "Calico", "Habitante de Electronic City", R.drawable.img_1),
            Superheores(2, "Alarico", "Maestro del porro", R.drawable.img_2),
            Superheores(1, "Calico", "Habitante de Electronic City", R.drawable.img_1),
            Superheores(2, "Alarico", "Maestro del porro", R.drawable.img_2)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SuperheoreAdapter(listaSuperheores) { hero: Superheores ->
            showHeroDialog(hero)
        }
    }

    private fun showHeroDialog(hero: Superheores) {
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.item_page, null)

        val imageView = view.findViewById<ImageView>(R.id.imageViewpage)
        val titleView = view.findViewById<TextView>(R.id.textViewTitlepage)
        val subtitleView = view.findViewById<TextView>(R.id.textViewSubtitlepage)

        imageView.setImageResource(hero.idfoto)
        titleView.text = hero.idname
        subtitleView.text = hero.iddescripcion

        AlertDialog.Builder(this)
            .setView(view)
            .setPositiveButton("Cerrar", null)
            .show()
    }
}
