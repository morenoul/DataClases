package com.example.dataclases

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.dataclases.data.Pais

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var españa  = Pais("España", 47000000, "Madrid")
        var marruecos = Pais("Marruecos", 35000000, "Rabat")

        //Compara el contenido de los objetos
        println(españa.equals(marruecos))
        println(españa == marruecos)

        var sahara = marruecos.copy("Sahara", 1000)
        println(sahara.toString())

        //Muestra la capital (se situa en el 3er lugar)
        println(españa.component3())

        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOf(españa.nombre, marruecos.nombre, sahara.nombre))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedOption = listOf(españa, marruecos, sahara)[position]
                //Toast.makeText(this@MainActivity, selectedOption.toString(), Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>){

            }
        }

        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOf(españa.nombre, marruecos.nombre, sahara.nombre))
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = adapter2
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedOption = listOf(españa, marruecos, sahara)[position]
                //Toast.makeText(this@MainActivity, selectedOption.toString(), Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>){
            }
        }

        val buttonCompare = findViewById<Button>(R.id.comparar)
        buttonCompare.setOnClickListener {
            Toast.makeText(this@MainActivity, "comparando....", Toast.LENGTH_SHORT).show()
            val pais1 = spinner.selectedItem.toString()

            val pais2 = spinner2.selectedItem.toString()

            if (pais1 == pais2) {
                Toast.makeText(this@MainActivity, "Los paises son iguales", Toast.LENGTH_SHORT).show()
                val frase3 = findViewById<TextView>(R.id.textcompare)
                frase3.text = "Los paises son iguales"
            } else {
                Toast.makeText(this@MainActivity, "Los paises son diferentes", Toast.LENGTH_SHORT).show()
                val frase4 = findViewById<TextView>(R.id.textcompare)
                frase4.text = "Los paises son diferentes"
            }

        }

    }
    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Hola, vengo de un start", Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Hola, vengo de un resume", Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "Hola, vengo de un pause", Toast.LENGTH_SHORT).show()
    }
    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "Hola, vengo de un stop", Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Hola, vengo de un destroy", Toast.LENGTH_SHORT).show()
    }
}