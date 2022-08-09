package fr.tifo.challengetifo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import fr.tifo.challengetifo.R
import fr.tifo.challengetifo.databinding.FragmentBranchBinding
import fr.tifo.challengetifo.databinding.FragmentHomeBinding

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


    }

}