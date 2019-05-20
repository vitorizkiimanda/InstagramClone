package id.codepanda.instagramclone

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import org.jetbrains.anko.*


class LoginActivity : AppCompatActivity() {

    private var emailBoolean : Boolean = false
    private var passwordBoolean : Boolean = false
    private var mAuthTask: UserLoginTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        onClickListener()
        onInputListener()
    }

    private fun onClickListener(){
        signup_button.setOnClickListener { toSignup() }
        button_login.setOnClickListener { doLogin() }
    }

    private fun toSignup(){
        startActivity(intentFor<AuthActivity>())
        finish()
    }

    private fun doLogin(){
        if (emailBoolean && passwordBoolean){
            button_login_text.visibility = View.GONE
            button_login_progressbar.visibility = View.VISIBLE
            mAuthTask = UserLoginTask(input_email.text.toString() , input_password.text.toString())
            mAuthTask!!.execute(null as Void?)
        }
    }


    private fun showLoginAlert(){
        alert("You can log in with your Facebook account", "Login Failed") {
        }.show()
    }

    private fun onInputListener(){
        input_email.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                emailBoolean = !s.toString().trim { it <= ' ' }.isEmpty()
                if (emailBoolean && passwordBoolean) button_login.background = getDrawable(R.drawable.rippleroundedblue)
                else button_login.background = getDrawable(R.drawable.roundedbluedissabled)
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {
                // TODO Auto-generated method stub

            }

            override fun afterTextChanged(s: Editable) {
                // TODO Auto-generated method stub

            }
        })

        input_password.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                passwordBoolean = !s.toString().trim { it <= ' ' }.isEmpty()
                if (emailBoolean && passwordBoolean) button_login.background = getDrawable(R.drawable.rippleroundedblue)
                else button_login.background = getDrawable(R.drawable.roundedbluedissabled)
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {
                // TODO Auto-generated method stub

            }

            override fun afterTextChanged(s: Editable) {
                // TODO Auto-generated method stub

            }
        })
    }

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {
        //TODO: Replace this with your own logic
        return password.length >= 8
    }

    inner class UserLoginTask internal constructor(private val mEmail: String, private val mPassword: String) :
        AsyncTask<Void, Void, Boolean>() {

        override fun doInBackground(vararg params: Void): Boolean? {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                return false
            }

            return mEmail == "vitorizkiimanda@gmail.com" && isPasswordValid(mPassword)
        }

        override fun onPostExecute(success: Boolean?) {
            button_login_text.visibility = View.VISIBLE
            button_login_progressbar.visibility = View.GONE


            if (success!!) {
                startActivity(intentFor<MainActivity>().clearTask().newTask())
            } else {
                showLoginAlert()
            }
        }

        override fun onCancelled() {
            button_login_text.visibility = View.VISIBLE
            button_login_progressbar.visibility = View.GONE
        }
    }
}
