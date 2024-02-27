package com.github.ulht.deisidratate

import java.util.Date

// data implementa o toString, equals e hashcode
data class WaterEntry(
  val drink: DrinkType,
  val amount: Int,
  val date: Date = Date(),
  val notes: String? = null,
) {

  val dayTime: DayTimeType
    get() {
      // Maior que 6 e menor que 12
      return if(date.hours in 7..11) DayTimeType.MORNING
      else if(date.hours in 12..20) DayTimeType.NOON
      else DayTimeType.NIGHT
    }

}