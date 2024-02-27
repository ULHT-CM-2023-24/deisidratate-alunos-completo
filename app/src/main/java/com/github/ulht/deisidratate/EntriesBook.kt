package com.github.ulht.deisidratate

import java.text.SimpleDateFormat
import java.util.Date

object EntriesBook {

  private val entries = mutableListOf<WaterEntry>()

  fun insert(entry: WaterEntry) {
    entries.add(entry)
  }

  fun getAll() = entries

  fun deleteAll() {
    entries.clear()
  }

  // Dizem que são pelo menos 2L por dia (de água...)
  fun getPercentageOfLiquids(maxLimit: Int = 2000, date: Date = Date()): Int {
    val mlOfWater = calculateTotalConsumedWater(date)
    return (mlOfWater * 100) / maxLimit
  }

  fun getCurrentConsumption(maxLimit: Int = 2000, date: Date = Date()): String {
    val mlOfWater = calculateTotalConsumedWater(date)
    return "$mlOfWater/$maxLimit ml"
  }

  private fun calculateTotalConsumedWater(date: Date): Int {
    val mlOfWater = entries
      .filter { it.date.day == date.day }
      .sumOf { it.amount }
    return mlOfWater
  }

}