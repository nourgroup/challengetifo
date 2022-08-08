package fr.tifo.challengetifo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.tifo.challengetifo.R
import fr.tifo.challengetifo.databinding.FragmentHomeBinding

class BranchFragment : Fragment() {

    lateinit var _binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(
            inflater,
            container,
            false)
        return _binding.root
    }

}