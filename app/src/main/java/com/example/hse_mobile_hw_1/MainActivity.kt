package com.example.hse_mobile_hw_1

import android.app.Activity
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_layout.*

class MainActivity : AppCompatActivity() {
    //val availableYears: MutableList<String> = Resources.getSystem().getStringArray(R.array.available_years_skills).toMutableList()

    companion object {
        private const val REQUEST_CODE = 3876
        private const val TRANSFER_STATES = "states_list"
        val availableYears: List<String> = listOf("Все", "2 года", "4 года", "1 год", "\u003c 1 года")
        var filterStates: BooleanArray = BooleanArray(availableYears.count())

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        for (index in filterStates.indices) {
            filterStates[index] = true
        }

        val rows = mutableListOf<MainAdapter.IRow>()
        rows.add(MainAdapter.MainHeader(getString(R.string.name), getString(R.string.grade), getString(R.string.github_url)))
        rows.add(MainAdapter.ProjectIdea(getString((R.string.idea_text))))
        rows.add(MainAdapter.SkillHeader())
        val languages: MutableList<String> = resources.getStringArray(R.array.languages_skills).toMutableList()
        val yearsIndexes: MutableList<String> = resources.getStringArray(R.array.years_skills).toMutableList()

        for (i in languages.indices) {
            rows.add(MainAdapter.Skill(languages[i], yearsIndexes[i]))
        }

        recycler.adapter = MainAdapter(rows, this)
        recycler.layoutManager = LinearLayoutManager(this)
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            filterStates = data.getBooleanArrayExtra(TRANSFER_STATES)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }*/
}
