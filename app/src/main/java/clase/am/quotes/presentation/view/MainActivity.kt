package clase.am.quotes.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import clase.am.quotes.R
import kotlinx.coroutines.launch
import clase.am.quotes.databinding.ActivityMainBinding
import clase.am.quotes.presentation.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    @AndroidEntryPoint
    class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding
        private val quoteViewModel: QuoteViewModel by viewModels()


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            //----------------------------
            quoteViewModel.randomQuote()
            observer()
            binding.viewContainer.setOnClickListener {
                quoteViewModel.randomQuote()
            }

        }
        private fun observer(){
            lifecycleScope.launch {
                quoteViewModel.quoteModel.collect {
                    binding.tvQuote.text = it.quote
                    binding.tvAuthor.text= it.author
                }
            }
        }


    }

        private lateinit var binding: ActivityMainBinding
        private val quoteViewModel: QuoteViewModel by viewModels()


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            //----------
            quoteViewModel.randomQuote()
            observer()
            binding.viewContainer.setOnClickListener {
                quoteViewModel.randomQuote()
            }
        }

        private fun observer() {
            lifecycleScope.launch {
                quoteViewModel.quoteModel.collect {
                    binding.tvQuote.text = it.quote
                    binding.tvAuthor.text = it.author
                }
            }
        }
        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            // Inflate the menu; this adds items to the action bar if it is present.
            menuInflater.inflate(R.menu.menu_main, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            return when (item.itemId) {
                R.id.action_settings -> true
                else -> super.onOptionsItemSelected(item)
            }
        }
    }