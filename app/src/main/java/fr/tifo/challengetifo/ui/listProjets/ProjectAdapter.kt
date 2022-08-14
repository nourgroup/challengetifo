package fr.tifo.challengetifo.ui.listProjets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.tifo.challengetifo.R
import fr.tifo.challengetifo.data.Project.Data
import fr.tifo.challengetifo.data.Project.Project

class ProjectAdapter (
    private val mListProjects: List<Project>,
    private val listener : (String) -> Unit
    ) : RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {

    //lateinit var _binding : ItemProjectBinding
        // create new views
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            // inflates the card_view_design view
            // that is used to hold list item
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_project, parent, false)

            return ViewHolder(view)
        }

        // binds the list items to a view
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val itemsViewModel = mListProjects.get(position)
            // sets the text to the textview from our itemHolder class
            holder.projectName.text = itemsViewModel.full_name
            holder.description.text = itemsViewModel.description
            holder.language.text = itemsViewModel.language
            holder.nbr.text = itemsViewModel.stargazers_count.toString()

            holder.item.setOnClickListener {
                listener(itemsViewModel.full_name)
            }

        }

        // return the number of the items in the list
        override fun getItemCount(): Int {
            return mListProjects.size
        }

        // Holds the views for adding it to image and text
        class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            val projectName: TextView = itemView.findViewById(R.id.tv_project_name)
            val description: TextView = itemView.findViewById(R.id.tv_description)
            val language: TextView = itemView.findViewById(R.id.tv_language)
            val nbr: TextView = itemView.findViewById(R.id.tv_nbr)
            val item: LinearLayout = itemView.findViewById(R.id.ll_item)
        }
    }
