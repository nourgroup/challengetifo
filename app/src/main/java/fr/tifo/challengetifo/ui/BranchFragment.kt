package fr.tifo.challengetifo.ui

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.tifo.challengetifo.databinding.FragmentBranchBinding
import fr.tifo.challengetifo.ui.listProjets.BranchAdapter
import fr.tifo.challengetifo.ui.listProjets.ContributorAdapter
import fr.tifo.challengetifo.viewmodels.ViewModelGithub

class BranchFragment : Fragment() {
//private val args: AccueilArgs by navArgs()
    private val data : BranchFragmentArgs by navArgs()

    lateinit var _binding : FragmentBranchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentBranchBinding.inflate(
            inflater,
            container,
            false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelGithub : ViewModelGithub by viewModels()
        viewModelGithub.initRoomDatabase(context)
        _binding.project.text = data.contributor.split("/")[1]

        _binding.rvListBranches.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
        }
        viewModelGithub.getBranches(data.contributor)
        viewModelGithub.getContributor(data.contributor)

        viewModelGithub.resultbranches.observe(viewLifecycleOwner){ br ->
            if(br!=null){
                viewModelGithub.resultContributors.observe(viewLifecycleOwner){ co ->
                    if(co!=null){
                        _binding.rvListBranches.adapter = ConcatAdapter(BranchAdapter(br),ContributorAdapter(co))
                    }
                }
            }
        }
    }
}