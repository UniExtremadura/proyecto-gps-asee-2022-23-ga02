package es.unex.trackstone10

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.API.APIToken
import es.unex.trackstone10.databinding.ActivityLoginBinding

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val trackstoneViewModel: TrackstoneViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        APIToken.getToken()

        val sharedPreferences = getSharedPreferences("userid", Context.MODE_PRIVATE)
        var userid = sharedPreferences.getInt("userid", 0)

        if (userid != 0) {
            val intent = Intent(this, ButtonNavigationMenuActivity::class.java)
            startActivity(intent)
        } else {
            binding.loginButton.setOnClickListener {
                if (binding.editTextTextPersonName.text.isNotEmpty() && binding.editTextPassword.text.isNotEmpty()) {
                    trackstoneViewModel.login(
                        binding.editTextTextPersonName.text.toString(),
                        binding.editTextPassword.text.toString()
                    )
                    trackstoneViewModel.loginResult.observe(this, Observer {
                        when (it) {
                            true -> {
                                val intent = Intent(this, ButtonNavigationMenuActivity::class.java)
                                startActivity(intent)
                            }
                            false -> {
                                Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    })
                }
            }
            binding.registerButton.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}


