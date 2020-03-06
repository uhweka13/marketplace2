package com.example.marketplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    private lateinit var btn_login:Button
    private var mAuth: FirebaseAuth? = null
    private lateinit var hud: KProgressHUD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bt_login.setOnClickListener {
            validateInputSignIn()
        }

    }

    fun validateInputSignIn(){
        val emailLogin = et_email_login.text.toString().trim()
        val passWord = et_password_login.text.toString().trim()

        if (emailLogin.isEmpty() || passWord.isEmpty()){
            Toast.makeText(this, "empty fields", Toast.LENGTH_LONG).show()
        }else{

            mAuth = FirebaseAuth.getInstance()

            hud= KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setDetailsLabel("Authenticating User")
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)

            hud.show()

            mAuth!!.signInWithEmailAndPassword(emailLogin, passWord)
                .addOnCompleteListener (this){task ->
                    hud.dismiss()
                    if (task.isSuccessful){

                        //fetch current user id
                        val userId = mAuth!!.currentUser!!.uid
                        Log.i("valueeee", "$userId")

                        toDashBoard()
                    } else{
                        Toast.makeText(this, "Authentication failed", Toast.LENGTH_LONG).show()
                    }
                }

        }
    }

    fun toDashBoard(){
        val intent = Intent(this, DashboardActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }
}
