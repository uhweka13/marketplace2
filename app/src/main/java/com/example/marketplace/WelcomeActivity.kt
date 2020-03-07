package com.example.marketplace

import PreferenceHelper
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.github.paolorotolo.appintro.AppIntro

class WelcomeActivity : AppIntro() {

    private var preferenceHelper: PreferenceHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main);

        preferenceHelper = PreferenceHelper(this)

        if (preferenceHelper!!.getIntro().equals("no")) {
            val intent = Intent(this@WelcomeActivity, SignUp::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            this.finish()
        }

        addSlide(IntroFragment1())  //extend AppIntro and comment setContentView
        addSlide(IntroFragment2())
        addSlide(IntroFragment3())
        addSlide(IntroFragment4())

    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)

        preferenceHelper!!.putIntro("no")

        val intent = Intent(this@WelcomeActivity, SignUp::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        this.finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)

        preferenceHelper!!.putIntro("no")

        val intent = Intent(this@WelcomeActivity, SignUp::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        this.finish()
    }

     override fun onSlideChanged(oldFragment: Fragment?, newFragment: Fragment?) {
        super.onSlideChanged(oldFragment, newFragment)
        // Do something when the slide changes.
    }
}
