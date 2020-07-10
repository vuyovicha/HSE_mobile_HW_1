package com.example.hse_mobile_hw_1

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.header_top.view.*
import kotlinx.android.synthetic.main.project_idea.view.*
import kotlinx.android.synthetic.main.skill.view.*
import kotlinx.android.synthetic.main.skills_headers.view.*

class MainHeaderViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
    private val buttonMain = root.button
    private val name: TextView = root.name
    private val grade: TextView = root.grade

    fun onBindMainHeader(row: MainAdapter.MainHeader) {
        name.text = row.name
        grade.text = row.grade

        buttonMain.setOnClickListener {
            root.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(row.github_url)))
        }
    }
}

class ProjectIdeaViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
    private val projectIdea: TextView = root.idea

    fun onBindProjectIdea(row: MainAdapter.ProjectIdea) {
        projectIdea.text = row.projectIdea
    }
}

class SkillHeaderViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
    private val filterButton: ImageView = root.imageFilter

    fun onBindSkillHeader(row: MainAdapter.SkillHeader) {
        filterButton.setOnClickListener {
            root.context.startActivity(Intent(root.context, FilterActivity::class.java))
        }
    }
}

class SkillViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
    private val language: TextView = root.language
    private val year: TextView = root.year

    fun onBindSkill(row: MainAdapter.Skill) {
        language.text = row.language
        year.text = MainActivity.availableYears[row.yearIndex.toInt()]
    }
}
