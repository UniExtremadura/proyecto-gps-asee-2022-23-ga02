package es.unex.trackstone10.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.*
import es.unex.trackstone10.databinding.FragmentProfileBinding

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private val trackstoneViewModel : TrackstoneViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val sharedPreferences = activity?.getSharedPreferences("userid",Context.MODE_PRIVATE)
        var userid = sharedPreferences?.getInt("userid",0)
        val id = userid ?: 0
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        val view = binding.root
        trackstoneViewModel.getUserToDisplay(id)
        trackstoneViewModel.displayUserValues.observe(viewLifecycleOwner){
            binding.textViewEmail.text = it.mail
            binding.textViewUsername.text = it.username
        }


        binding.Change1.setOnClickListener {
            val mail = binding.profileEmailChange.text.toString()
            trackstoneViewModel.modifyUser(mail, id, 1)
            trackstoneViewModel.modifyUserResult.observe(viewLifecycleOwner, Observer {
                when (it) {
                    true -> {
                        Toast.makeText(activity, "Email updated!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(activity, ButtonNavigationMenuActivity::class.java)
                        startActivity(intent)
                    }
                    false -> {
                        Toast.makeText(activity, "Email cant be updated", Toast.LENGTH_SHORT).show()
                    }

                }
            })
        }

        binding.Change2.setOnClickListener {
            val username = binding.profileNameChange.text.toString()
            trackstoneViewModel.modifyUser(username, id, 2)
            trackstoneViewModel.modifyUserResult.observe(viewLifecycleOwner, Observer {
                when (it) {
                    true -> {
                        Toast.makeText(activity, "Username updated!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(activity, ButtonNavigationMenuActivity::class.java)
                        startActivity(intent)
                    }
                    false -> {
                        Toast.makeText(activity, "Username cant be updated", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }

        binding.Change3.setOnClickListener {
            val password = binding.profilePasswordChange.text.toString()
            trackstoneViewModel.modifyUser(password, id, 3)
            trackstoneViewModel.modifyUserResult.observe(viewLifecycleOwner, Observer {
                when (it) {
                    true -> {
                        Toast.makeText(activity, "Password updated!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(activity, ButtonNavigationMenuActivity::class.java)
                        startActivity(intent)
                    }
                    false -> {
                        Toast.makeText(activity, "Password cant be updated", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }

        binding.closeSessionButton.setOnClickListener {
            var edit = sharedPreferences?.edit()
            edit?.clear()
            edit?.commit()
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.deleteUserButton.setOnClickListener {
            trackstoneViewModel.deleteUser(userid)
            trackstoneViewModel.deleteResult.observe(viewLifecycleOwner, Observer {
                when (it) {
                    true -> {
                        Toast.makeText(activity, "User deleted!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(activity, LoginActivity::class.java)
                        startActivity(intent)
                    }
                    false -> {
                        Toast.makeText(activity, "That user cant be deleted", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })
        }

        return view

    }
}