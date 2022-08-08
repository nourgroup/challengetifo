package fr.tifo.challengetifo.ui.listProjets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import fr.tifo.challengetifo.R
import fr.tifo.challengetifo.data.Data

class ProjectAdapter (
    private val mListProjects: List<Data>
    ) : RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {

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
            val itemsViewModel = mListProjects[position]
            // sets the text to the textview from our itemHolder class
            holder.projectName.text = itemsViewModel.name
            holder.description.text = "description ${ itemsViewModel.name }"
        }

        // return the number of the items in the list
        override fun getItemCount(): Int {
            return mListProjects.size
        }

        // Holds the views for adding it to image and text
        class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            val projectName: TextView = itemView.findViewById(R.id.project_name)
            val description: TextView = itemView.findViewById(R.id.description)
        }
    }
