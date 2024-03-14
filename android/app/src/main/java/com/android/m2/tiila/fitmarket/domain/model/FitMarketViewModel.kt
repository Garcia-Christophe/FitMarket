package com.android.m2.tiila.fitmarket.domain.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.m2.tiila.fitmarket.data.repository.FitMarketRepository
import com.android.m2.tiila.fitmarket.data.repository.FitMarketRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


data class ConnectionModelState(
    var member: Member? = null,
)
open class FitMarketViewModel (private val repository: FitMarketRepositoryInterface) : ViewModel(){

    private var _signInResult = MutableStateFlow<ConnectionModelState>(ConnectionModelState())
    var signInResult = _signInResult.asStateFlow()

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            val flow =  repository.signIn(email = email, password = password)

            flow.collect {
                _signInResult.value = ConnectionModelState(
                    member = it.data,
                )
            }
        }
    }
}