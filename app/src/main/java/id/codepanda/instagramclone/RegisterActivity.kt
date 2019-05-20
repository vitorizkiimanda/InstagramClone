package id.codepanda.instagramclone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.intentFor

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        onClickListener()
    }
    private fun onClickListener(){
        login_button.setOnClickListener { toLogin() }
    }

    private fun toLogin(){
        startActivity(intentFor<LoginActivity>())
        finish()
    }
}
