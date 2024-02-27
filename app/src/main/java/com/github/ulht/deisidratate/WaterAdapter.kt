package com.github.ulht.deisidratate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.ulht.deisidratate.databinding.ItemWaterBinding
import java.text.SimpleDateFormat

class WaterAdapter(
  private val items: MutableList<WaterEntry> = mutableListOf(),
  private val onClick: (WaterEntry) -> Unit
) : RecyclerView.Adapter<WaterAdapter.WaterViewHolder>() {

  private val sdf = SimpleDateFormat("HH:mm")

  class WaterViewHolder(val binding: ItemWaterBinding) : RecyclerView.ViewHolder(binding.root)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaterViewHolder {
    return WaterViewHolder(
      ItemWaterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
  }

  override fun onBindViewHolder(holder: WaterViewHolder, position: Int) {
    val item = items[position]
    holder.binding.textDrinkType.text = item.drink.value
    holder.binding.textWaterQuantity.text = item.amount.toString()
    holder.binding.textWaterTime.text = sdf.format(item.date)
    holder.binding.imageWaterDaytime.setImageResource(
      when(item.dayTime) {
        DayTimeType.MORNING -> R.drawable.ic_morning
        DayTimeType.NOON -> R.drawable.ic_noon
        DayTimeType.NIGHT -> R.drawable.ic_night
      }
    )

    holder.itemView.setOnClickListener{ onClick(item) }
  }

  override fun getItemCount() = items.size

  fun update(items: List<WaterEntry>) {
    this.items.clear()
    this.items.addAll(items)
    notifyDataSetChanged()
  }

}