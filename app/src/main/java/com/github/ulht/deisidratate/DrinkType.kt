package com.github.ulht.deisidratate

enum class DrinkType(val value: String) {
  WATER("\uD83D\uDCA7 Water"),
  BEER("\uD83C\uDF7A Beer"),
  COFFEE("☕️ Coffee");

  override fun toString(): String {
    return value
  }

}