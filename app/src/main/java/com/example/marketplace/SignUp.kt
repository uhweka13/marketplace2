package com.example.marketplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private var mDatabase: FirebaseDatabase?=null
    private lateinit var hud: KProgressHUD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

//        bt_signup.setOnClickListener {
//            formValidation()
//        }
    }

//    fun formValidation(){
//        val name = et_name_signup.text.toString().trim()
//        val email = et_email_signup.text.toString().trim()
//        val phoneNumber = et_phone_number.text.toString().trim()
//        val stateSelect = et_state.text.toString().trim()
//        val ciTy = et_city.text.toString().trim()
//        val passWord = et_password.text.toString().trim()
//
//        if (name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || stateSelect.isEmpty() || ciTy.isEmpty() ||passWord.isEmpty()){
//            Toast.makeText(this, "check for empty field", Toast.LENGTH_LONG).show()
//        }else{
//
//            hud = KProgressHUD.create(this)
//                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
//                .setLabel("Please wait")
//                .setDetailsLabel("Creating User")
//                .setCancellable(true)
//                .setAnimationSpeed(2)
//                .setDimAmount(0.5f)
//
//            hud.show()
//
//            mAuth = FirebaseAuth.getInstance()
//            mDatabase = FirebaseDatabase.getInstance()
//            val mUsers: DatabaseReference = mDatabase!!.reference!!.child("Users")
//
//            mAuth!!.createUserWithEmailAndPassword(email, passWord)
//                .addOnCompleteListener(this, OnCompleteListener {task ->
//
//                    hud.dismiss()
//                    if (task.isSuccessful){
//
//                        //fetch current user id
//                        val userId = mAuth!!.currentUser!!.uid
//
//                        //update user profile information
//                        val currentUserDb = mUsers!!.child(userId)
//                        currentUserDb.child("name").setValue(name)
//                        currentUserDb.child("email").setValue(email)
//                        currentUserDb.child("phonenumber").setValue(phoneNumber)
//                        currentUserDb.child("state").setValue(stateSelect)
//                        currentUserDb.child("city").setValue(ciTy)
//                        currentUserDb.child("uid").setValue(userId)
//
//                        toLogin()
//
//                    }else{
//                        Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
//                    }
//                })
//        }
//    }
//
//    fun toLogin(){
//        val intent = Intent(this, Login::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        startActivity(intent)
//        finish()
//    }
}
