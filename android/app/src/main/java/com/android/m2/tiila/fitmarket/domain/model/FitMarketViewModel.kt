package com.android.m2.tiila.fitmarket.domain.model

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.m2.tiila.fitmarket.data.core.Status
import com.android.m2.tiila.fitmarket.data.repository.FitMarketRepositoryInterface
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


data class ConnectionModelState(
    var member: Member? = null,
    var errorMessage : String? = " ",
    var isLoading: Boolean = false,
)
open class FitMarketViewModel (private val repository: FitMarketRepositoryInterface) : ViewModel(){

    private val _signInResult = MutableStateFlow<ConnectionModelState>(ConnectionModelState())
    var signInResult = _signInResult.asStateFlow()

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
}