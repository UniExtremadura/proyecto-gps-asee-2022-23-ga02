package es.unex.trackstone10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.databinding.ActivityRegisterBinding
import es.unex.trackstone10.roomdb.Entity.UserEntity

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val trackstoneViewModel : TrackstoneViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener {
            if (binding.editTextEmail.text.isNotEmpty() && binding.editTextTextPersonName.text.isNotEmpty()
                && binding.editTextPassword.text.isNotEmpty() && binding.confirmPassword.text.toString() == binding.editTextPassword.text.toString()
            ) {
                val user = UserEntity(
                    binding.editTextTextPersonName.text.toString(),
                    binding.editTextPassword.text.toString(),
                    binding.editTextEmail.text.toString(),
                )
                trackstoneViewModel.register(user)
                val intent = Intent(this, ButtonNavigationMenuActivity::class.java)
                startActivity(intent)
            }
        }
    }
}