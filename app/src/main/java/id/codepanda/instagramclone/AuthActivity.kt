package id.codepanda.instagramclone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_auth.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.noAnimation

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
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
