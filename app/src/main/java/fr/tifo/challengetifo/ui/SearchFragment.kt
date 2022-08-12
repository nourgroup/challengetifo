package fr.tifo.challengetifo.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import fr.tifo.challengetifo.databinding.FragmentSearchBinding
import fr.tifo.challengetifo.ui.listProjets.ProjectAdapter
import fr.tifo.challengetifo.viewmodels.ViewModelGithub
import java.lang.Exception
import androidx.navigation.fragment.findNavController

class SearchFragment : Fragment() {

    lateinit var _binding : FragmentSearchBinding
    var lengthText =0

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

        val viewModel : ViewModelGithub by viewModels()

        viewModel.initRoomDatabase(context)
        /*_binding.etSearchProject.addTextChangedListener {
            try{
                if(it!!.length>lengthText){
                    _binding.swipeRefresh.isRefreshing = true
                    viewModel.getData(it.toString())
                }
                lengthText=it!!.length
            }catch (Ex : Exception){

            }
        }*/
        _binding.etSearchProject.setOnEditorActionListener { _, actionId, _ ->
            _binding.swipeRefresh.isRefreshing = true
            viewModel.getData(_binding.etSearchProject.text.toString())
                true
            }

        _binding.rvListProjects.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
        }


        viewModel.resultProject.observe(viewLifecycleOwner){ pr ->
                if(pr!=null){
                    var adapter = ProjectAdapter(pr){ choice ->
                        try{
                            var action = SearchFragmentDirections.actionSearchToBranch()
                            action.contributor = choice
                            findNavController().navigate(action)
                        }catch(ex : IllegalArgumentException){
                            Toast.makeText(activity, "something went wrong", Toast.LENGTH_SHORT).show()
                        }
                    }
                    _binding.rvListProjects.adapter = adapter
                    adapter?.notifyDataSetChanged()
                }
            _binding.swipeRefresh.isRefreshing = false
        }


    }

}