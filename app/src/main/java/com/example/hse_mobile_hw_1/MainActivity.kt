package com.example.hse_mobile_hw_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_layout.*

class MainActivity : AppCompatActivity() {
    companion object {
        val availableYears: List<String> = listOf("Все", "2 года", "4 года", "1 год", "\u003c 1 года")
        var adapterFilterStates: BooleanArray = BooleanArray(availableYears.count())
        var greenDotFlag: Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        this.title = getString(R.string.main_title)
        for (index in adapterFilterStates.indices) {
            adapterFilterStates[index] = true
        }
    }

    override fun onTopResumedActivityChanged(isTopResumedActivity: Boolean) {
        val rows = mutableListOf<MainAdapter.IRow>()
        rows.add(MainAdapter.MainHeader(getString(R.string.name), getString(R.string.grade), getString(R.string.github_url)))
        rows.add(MainAdapter.ProjectIdea(getString((R.string.idea_text))))
        rows.add(MainAdapter.SkillHeader())

        val languages: MutableList<String> = resources.getStringArray(R.array.languages_skills).toMutableList()
        val yearsIndexes: MutableList<String> = resources.getStringArray(R.array.years_skills).toMutableList()

        for (i in languages.indices) {
            if (adapterFilterStates[yearsIndexes[i].toInt()]) {
                rows.add(MainAdapter.Skill(languages[i], yearsIndexes[i]))
            }
        }
        greenDotFlag = !adapterFilterStates[0]
        recycler.adapter = MainAdapter(rows, this)
        recycler.layoutManager = LinearLayoutManager(this)
    }
}
