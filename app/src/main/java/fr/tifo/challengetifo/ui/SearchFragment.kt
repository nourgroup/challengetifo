package fr.tifo.challengetifo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import fr.tifo.challengetifo.R
import fr.tifo.challengetifo.data.Data
import fr.tifo.challengetifo.databinding.FragmentHomeBinding
import fr.tifo.challengetifo.databinding.FragmentSearchBinding
import fr.tifo.challengetifo.ui.listProjets.ProjectAdapter

class SearchFragment : Fragment() {


    lateinit var _binding : FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(
            inflater,
            container,
            false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mProjectAdapter = ProjectAdapter(listOf(Data("osiiiiii")))
        _binding.rvListProjects.apply{
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = mProjectAdapter
        }
    }

}