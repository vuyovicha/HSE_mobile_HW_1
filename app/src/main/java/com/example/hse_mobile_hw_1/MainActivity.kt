package com.example.hse_mobile_hw_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_layout.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        val rows = mutableListOf<MainAdapter.IRow>()
        rows.add(MainAdapter.MainHeader(getString(R.string.name), getString(R.string.grade), getString(R.string.github_url)))
        rows.add(MainAdapter.ProjectIdea(getString((R.string.idea_text))))
        rows.add(MainAdapter.SkillHeader())
        val languages: MutableList<String> = resources.getStringArray(R.array.languages_skills).toMutableList()
        val years: MutableList<String> = resources.getStringArray(R.array.years_skills).toMutableList()
        for (i in languages.indices) {
            rows.add(MainAdapter.Skill(languages[i], years[i]))
        }

        recycler.adapter = MainAdapter(rows)
        recycler.layoutManager = LinearLayoutManager(this)
    }
}
