package com.example.hse_mobile_hw_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.filter_year.view.*
import kotlinx.android.synthetic.main.skill.view.*

class FilterAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val adapterFilterList: List<String> = MainActivity.availableYears

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FilterViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.filter_year, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FilterViewHolder).onBindFilterViewHolder(adapterFilterList[position], MainActivity.adapterFilterStates[position], position)
    }

    override fun getItemCount() = adapterFilterList.count()

    inner class FilterViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        private val checkBox: CheckBox = root.checkBox

        fun onBindFilterViewHolder(year: String, state: Boolean, index: Int) {
            checkBox.text = year
            checkBox.isChecked = state

            checkBox.setOnClickListener {
                MainActivity.adapterFilterStates[index] = !MainActivity.adapterFilterStates[index]
                if (index == 0) setAll(MainActivity.adapterFilterStates[0])
                else if (!MainActivity.adapterFilterStates[0] && checkAll(true)) MainActivity.adapterFilterStates[0] = true
                else if (MainActivity.adapterFilterStates[0] && checkAll(false)) MainActivity.adapterFilterStates[0] = false
                notifyDataSetChanged()
            }
        }

        private fun setAll(allState: Boolean) {
            for (index in MainActivity.adapterFilterStates.indices) {
                MainActivity.adapterFilterStates[index] = allState
            }
        }

        private fun checkAll(neededState: Boolean): Boolean {
            var flag: Boolean = neededState
            for (index in MainActivity.adapterFilterStates.indices) {
                if (index != 0) {
                    if (!MainActivity.adapterFilterStates[index]) {
                        flag = !neededState
                        return flag
                    }
                }
            }
            return flag
        }
    }
}
