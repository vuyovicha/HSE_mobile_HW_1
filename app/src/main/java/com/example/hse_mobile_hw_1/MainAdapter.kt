package com.example.hse_mobile_hw_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException

class MainAdapter(private val adapterDataList: List<IRow>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface IRow
    class MainHeader(val name: String, val grade: String, val github_url: String) : IRow // todo how to transfer an image?
    class ProjectIdea(val projectIdea: String) : IRow
    class SkillHeader() : IRow
    class Skill(val language: String, val year: String) : IRow

    companion object {
        private const val MAIN_HEADER = 0
        private const val PROJECT_IDEA = 1
        private const val SKILL_HEADER = 2
        private const val SKILL = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            MAIN_HEADER -> MainHeaderViewHolder(
                LayoutInflater.from(parent.context)
                .inflate(R.layout.header_top, parent, false))
            PROJECT_IDEA -> ProjectIdeaViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.project_idea, parent, false))
            SKILL_HEADER -> SkillHeaderViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.skills_headers, parent, false))
            SKILL -> SkillViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.skill, parent, false))
            else -> throw IllegalArgumentException("Not supported view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (adapterDataList[position]) {
            is MainHeader -> MAIN_HEADER
            is ProjectIdea -> PROJECT_IDEA
            is SkillHeader -> SKILL_HEADER
            is Skill -> SKILL
            else -> throw IllegalArgumentException("Not supported view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder.itemViewType) {
            MAIN_HEADER -> (holder as MainHeaderViewHolder).onBindMainHeader(adapterDataList[position] as MainHeader)
            PROJECT_IDEA -> (holder as ProjectIdeaViewHolder).onBindProjectIdea(adapterDataList[position] as ProjectIdea)
            SKILL -> (holder as SkillViewHolder).onBindSkill(adapterDataList[position] as Skill)
            else -> { }
        }

    override fun getItemCount() = adapterDataList.count()
}
