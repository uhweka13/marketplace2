package com.example.marketplace

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog

class ViewSingleItemActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_single_item)

        val actionBar = supportActionBar
        actionBar!!.title = "Item Name"
        actionBar.setDefaultDisplayHomeAsUpEnabled(true)
        actionBar.setDefaultDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.itemsmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {

        R.id.nav_update_price->{
            updateProductPrice()
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }

    }

    fun updateProductPrice(){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.update_price_dialogue, null)

        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
        //show dialog
        val  mAlertDialog = mBuilder.show()
    }


}
