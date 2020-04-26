package com.shaggy.gitkot.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shaggy.gitkot.data.model.GitRepo
import com.shaggy.gitkot.databinding.RepositoryListItemBinding

class RepositoryListAdapter(private val gitRepos: ArrayList<GitRepo> = arrayListOf()): RecyclerView.Adapter<RepositoryListAdapter.RepoItemViewHolder>() {

    class RepoItemViewHolder(private val itemBinding: RepositoryListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(gitRepo: GitRepo) {
            itemBinding.gitRepo = gitRepo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoItemViewHolder {
        val itemBinding: RepositoryListItemBinding = RepositoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RepoItemViewHolder(itemBinding)
    }

    override fun getItemCount(): Int  = gitRepos.size

    override fun onBindViewHolder(holder: RepoItemViewHolder, position: Int) = holder.bind(gitRepos[position])


    fun setData(gitRepos: ArrayList<GitRepo>) {
        this.gitRepos.apply {
            clear()
            addAll(gitRepos)
        }

        notifyDataSetChanged()
    }
}