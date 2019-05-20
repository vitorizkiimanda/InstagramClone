package id.codepanda.instagramclone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.noAnimation

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(intentFor<AuthActivity>().noAnimation())
        finish()
    }
}
