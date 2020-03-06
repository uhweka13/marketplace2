package com.example.marketplace

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_view_shop.*
import kotlinx.android.synthetic.main.addproduct_dialogue.*
import kotlinx.android.synthetic.main.addproduct_dialogue.view.*

class ViewShopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_shop)


        imgbtn_add_item.setOnClickListener {
            addItemToShop()
        }

        val spinner: Spinner = sp_spinner_category_shops
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


    }

    fun addItemToShop(){
        //Inflate the dialog with custom view
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.addproduct_dialogue, null)

        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this, R.style.DialogTheme)
            .setView(mDialogView)
        //show dialog
        val  mAlertDialog = mBuilder.show()

        val spinner: Spinner = mDialogView.sp_add_category
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


//        var numberFinal = "+$countryCodeSelected$userPhoneNumber"
//        mDialogView.tv_code_text_1.setText("Verify $numberFinal")
//        mDialogView.tv_phone_number_on_pin_code.setText(Html.fromHtml("waiting to automatically detect an SMS sent to <b>$numberFinal</b>."))
//        // custom menu button
//        mDialogView.imgbt_menu_code.setOnClickListener {
//            //dismiss dialog
//            mDialogView.imgbt_menu_code.visibility = View.GONE
//            mDialogView.cd_help_menu.visibility = View.VISIBLE
//        }

    }


}
