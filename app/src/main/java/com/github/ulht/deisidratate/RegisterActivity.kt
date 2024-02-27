package com.github.ulht.deisidratate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.ulht.deisidratate.databinding.ActivityRegisterBinding
import java.util.Calendar

class RegisterActivity : AppCompatActivity() {

  private lateinit var binding: ActivityRegisterBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityRegisterBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }

  override fun onResume() {
    super.onResume()
    binding.buttonSubmit.setOnClickListener {
      val amount = binding.sliderAmount.value.toInt()
      val notes = binding.inputNotes.editText?.text.toString()
      val drinkIndex = binding.spinnerDrink.selectedItemPosition
      val drink = DrinkType.entries[drinkIndex]

      val entry = WaterEntry(amount = amount, drink = drink, notes = notes)
      EntriesBook.insert(entry)
      Toast.makeText(this, getText(R.string.registered_successfully), Toast.LENGTH_LONG).show()
      finish()
    }
  }

}