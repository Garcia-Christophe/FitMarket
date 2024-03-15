package com.android.m2.tiila.fitmarket.domain.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.m2.tiila.fitmarket.data.core.Status
import com.android.m2.tiila.fitmarket.data.repository.FitMarketRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


data class ConnectionModelState(
    var member: Member? = null,
    var errorMessage : String? = " ",
    var isLoading: Boolean = false,
)

data class ClassesModelState(
    var classes: List<Classe>? = null,
    var errorMessage : String? = " ",
    var isLoading: Boolean = false,
)
open class FitMarketViewModel (private val repository: FitMarketRepositoryInterface) : ViewModel(){

    private val _signInResult = MutableStateFlow<ConnectionModelState>(ConnectionModelState())
    var signInResult = _signInResult.asStateFlow()

    private val _classesResult = MutableStateFlow<ClassesModelState>(ClassesModelState())
    var classesResult = _classesResult.asStateFlow()

    fun logout() {
        _signInResult.value.member=null;
        _signInResult.value.errorMessage=" ";
    }

    fun getLoggedInUserFullName(): Pair<String, String>? {
        val user = signInResult.value?.member
        return if (user != null) {
            Pair(user.firstname.orEmpty(), user.lastname.orEmpty())
        } else {
            null
        }
    }

    fun getLoggedInUserId(): Int? {
        val user = signInResult.value?.member
       return user?.id
    }

    fun submitForm(email: String, password: String) = signIn(email=email,password=password)

    private fun signIn(email: String, password: String) {
        viewModelScope.launch {

            val flow =  repository.signIn(email = email, password = password)

            flow.collect {
                _signInResult.value = ConnectionModelState(
                    member = it.data?.member,
                    errorMessage = it.data?.error,
                    isLoading = it.status == Status.LOADING
                )
            }
        }

    }

    fun collectClassesUser() {
        viewModelScope.launch {

            val flow = getLoggedInUserId()?.let { repository.collectClassesUser(id = it) }

            if (flow != null) {
                flow.collect {
                    _classesResult.value = ClassesModelState(
                        classes = it.data?.classes,
                        errorMessage = it.data?.error,
                        isLoading = it.status == Status.LOADING
                    )
                }
            }
        }


    }
}