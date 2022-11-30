package es.unex.trackstone10

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import es.unex.trackstone10.AppExecutors
import es.unex.trackstone10.ButtonNavigationMenuActivity
import es.unex.trackstone10.RegisterActivity
import es.unex.trackstone10.databinding.ActivityLoginBinding
import es.unex.trackstone10.roomdb.TrackstoneDatabase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("userid",Context.MODE_PRIVATE)
        var userid = sharedPreferences.getInt("userid",0)

        if(userid != 0){
            val intent = Intent(this, ButtonNavigationMenuActivity::class.java)
            startActivity(intent)
        }
        else {
        }

        binding.registerButton.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}