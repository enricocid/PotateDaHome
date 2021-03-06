package com.iven.potatowalls.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.iven.potatowalls.R

class ColorsAdapter(@NonNull private val context: Context) :
    RecyclerView.Adapter<ColorsAdapter.ColorsHolder>() {

    var onColorClick: ((Pair<Int, Int>) -> Unit)? = null

    //first = background color, second = vector color
    private val mColors = listOf(
        //from https://www.canva.com/learn/100-color-combinations/
        Pair(R.color.midnight_blue, R.color.ink),
        Pair(R.color.dark_navy, R.color.blue_berry),
        Pair(R.color.shadow, R.color.mist),
        Pair(R.color.crevice, R.color.desert),
        Pair(R.color.deep_aqua, R.color.wave),
        Pair(R.color.blue_black, R.color.rain),
        Pair(R.color.blue_pine, R.color.reflection),
        Pair(R.color.ink, R.color.light_blue_berry),
        Pair(R.color.greece, R.color.plaster),
        Pair(R.color.cocoa, R.color.chocolate),
        Pair(R.color.slate, R.color.ceramic),

        Pair(R.color.chocolate, R.color.toffee),
        Pair(R.color.chocolate, R.color.frosting),
        Pair(R.color.egg_plant, R.color.lemon_lime),
        Pair(R.color.blue_berry, R.color.daffodil),
        Pair(R.color.cloud, R.color.moss),
        Pair(R.color.blue, R.color.sun),
        Pair(R.color.sky, R.color.sunflower),
        Pair(R.color.sea, R.color.sandstone),
        Pair(R.color.stem, R.color.poppy),
        Pair(R.color.turquoise, R.color.pink_tulip),
        Pair(R.color.branch, R.color.berry),
        Pair(R.color.glacier, R.color.ice),
        Pair(R.color.ice, R.color.overcast),
        Pair(R.color.ceramic, R.color.latte),
        Pair(R.color.plaster, R.color.greece)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorsHolder {
        return ColorsHolder(LayoutInflater.from(parent.context).inflate(R.layout.color_option, parent, false))
    }

    override fun getItemCount(): Int {
        return mColors.size
    }

    override fun onBindViewHolder(holder: ColorsHolder, position: Int) {
        holder.bindItems(mColors[holder.adapterPosition])
    }

    inner class ColorsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(combo: Pair<Int, Int>) {

            val colorItem = itemView as MaterialCardView

            colorItem.setCardBackgroundColor(ContextCompat.getColor(context, combo.second))
            colorItem.strokeColor = ContextCompat.getColor(context, combo.first)

            itemView.setOnClickListener {
                onColorClick?.invoke(combo)
            }
        }
    }
}