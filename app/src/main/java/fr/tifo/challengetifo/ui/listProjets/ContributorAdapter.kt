package fr.tifo.challengetifo.ui.listProjets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.tifo.challengetifo.R
import fr.tifo.challengetifo.data.Contributor.Contributor

class ContributorAdapter (
    private val mListBranches: List<Contributor>
    ) : RecyclerView.Adapter<ContributorAdapter.ViewHolder>() {

    //lateinit var _binding : ItemProjectBinding
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contributor, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //val itemsViewModel = mListBranches.get(position)
        val itemsViewModel = mListBranches.get(position)
        // sets the text to the textview from our itemHolder class
        holder.nameBranch.text = itemsViewModel.login
        Picasso.get().load(itemsViewModel.avatar_url).into(holder.avatar)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mListBranches.size
        //return mListBranches.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val nameBranch: TextView = itemView.findViewById(R.id.tv_name_branch)
        val avatar: ImageView = itemView.findViewById(R.id.iv_avatar)
    }
}
