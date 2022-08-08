package fr.tifo.challengetifo.viewmodels

import androidx.lifecycle.ViewModel
import fr.tifo.challengetifo.repository.impl.RepositoryGitHub
import ft.exomind.testexomind.webservices.impl.WebServiceGitHub

class ViewModelGithub : ViewModel() {


    var mRepositoryGitHub = RepositoryGitHub(WebServiceGitHub())



}