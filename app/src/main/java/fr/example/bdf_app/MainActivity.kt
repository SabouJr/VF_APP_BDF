package fr.example.bdf_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.example.bdf_app.databinding.ActivityMainBinding
import fr.example.bdf_app.ui.AnecdoteDialogFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var vm: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_quizz
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        vm = ViewModelProvider(this@MainActivity)[MainActivityViewModel::class.java]

        vm.fetchAnectode()

        setUpObserver()
    }

    private fun setUpObserver() {
        vm.anecdote.observe(this@MainActivity) {
            AnecdoteDialogFragment(content = it).show(supportFragmentManager, AnecdoteDialogFragment.TAG)
        }
    }
}