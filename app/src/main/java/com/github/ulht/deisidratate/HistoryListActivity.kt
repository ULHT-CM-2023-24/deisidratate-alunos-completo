package com.github.ulht.deisidratate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.github.ulht.deisidratate.databinding.ActivityHistoryListBinding

class HistoryListActivity : AppCompatActivity() {

  private val TAG = HistoryListActivity::class.java.simpleName

  private lateinit var binding: ActivityHistoryListBinding

  private val adapter = WaterAdapter(
    onClick = ::onWaterEntryClick
  )

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityHistoryListBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }

  override fun onResume() {
    super.onResume()
    val entries = EntriesBook.getAll()
    Log.i(TAG, "entries to show $entries")
    adapter.update(entries)
    binding.list.adapter = adapter
    binding.labelProgress.text = EntriesBook.getCurrentConsumption()
    binding.progressBar.progress = EntriesBook.getPercentageOfLiquids()
    binding.buttonRegister.setOnClickListener {
      startActivity(Intent(this, RegisterActivity::class.java))
    }
  }

  private fun onWaterEntryClick(entry: WaterEntry) {
    Log.i(TAG, "onWaterEntryClick got $entry")
    if(entry.notes != null) {
      Toast.makeText(this, entry.notes, Toast.LENGTH_LONG).show()
    }
  }

}