package com.example.miappcarrito

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductsActivity : AppCompatActivity() {

    // Lista de productos de ejemplo
    private val productList = listOf(
        Product("Conjunto", 1000.0, R.drawable.ima1),
        Product("Capri", 500.0, R.drawable.ima2),
        Product("Vestido", 100.0, R.drawable.ima22),
        Product("Pantalon", 200.0, R.drawable.ima25)
    )

    // Lista para almacenar los productos en el carrito
    private val cart = mutableListOf<Product>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        // Configurar el RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(productList) { product ->
            addToCart(product)
        }

        // Botón de "Finalizar Compra"
        val buyButton = findViewById<Button>(R.id.buyProductButton)
        buyButton.setOnClickListener {
            finalizePurchase()
        }
    }

    // Método para agregar productos al carrito
    private fun addToCart(product: Product) {
        cart.add(product)
        Toast.makeText(this, "${product.name} agregado al carrito", Toast.LENGTH_SHORT).show()
    }

    // Método para finalizar la compra
    private fun finalizePurchase() {
        if (cart.isNotEmpty()) {
            Toast.makeText(this, "Compra finalizada con ${cart.size} productos.", Toast.LENGTH_SHORT).show()
            cart.clear()  // Limpiar el carrito después de la compra
        } else {
            Toast.makeText(this, "No hay productos en el carrito.", Toast.LENGTH_SHORT).show()
        }
    }
}



