package com.example.snehaAssignment1.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.model.SignUpEventModel
import com.example.snehaAssignment1.model.UserDetails
import com.example.snehaAssignment1.repositories.SignUpRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpViewModel(private val app: Application) : AndroidViewModel(app) {
    private val defaultScope = CoroutineScope(Dispatchers.Default)
    private val signUpEvent = MutableSharedFlow<SignUpEventModel>()
    private val repo = SignUpRepo(app)  //connection between view model and repository
    private lateinit var userDetails: UserDetails

    val signUpFlow =
        signUpEvent.asSharedFlow()   //signUpFlow is used to provide data from SignUpViewModel to SignUpFragment
    var userName = ""
    var emailId = ""
    var mobileNumber = ""
    var password = ""

    private val usernamePattern = "^[A-Za-z][A-Za-z0-9_]{7,29}$"
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+"
    private val mobilePattern = "/^(\\+\\d{1,3}[- ]?)?\\d{10}\$/"
    private val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,}"

    fun onSignUpClick() {

        defaultScope.launch {
            /////////////two way binding is used////////////////////
            when {
                userName.isBlank() -> {
                    withContext(Dispatchers.Main) {
                        val signUpEventModel = SignUpEventModel(app.getString(R.string.alert_username_should_not_be_blank))
                        signUpEvent.emit(signUpEventModel)  // here message is given to fragment
                    }
                }
                !userName.matches(usernamePattern.toRegex()) -> {
                    withContext(Dispatchers.Main) {
                        val signUpEventModel =
                            SignUpEventModel(app.getString(R.string.alert_username_should_contain_uppercase_lowercase_number))
                        signUpEvent.emit(signUpEventModel)
                    }
                }
                emailId.isBlank() -> {
                    withContext(Dispatchers.Main) {
                        val signUpEventModel = SignUpEventModel(app.getString(R.string.alert_email_should_not_be_blank))
                        signUpEvent.emit(signUpEventModel)
                    }
                }
                !emailId.matches(emailPattern.toRegex()) -> {
                    withContext(Dispatchers.Main) {
                        val signUpEventModel = SignUpEventModel(app.getString(R.string.alert_enter_valid_emailId))
                        signUpEvent.emit(signUpEventModel)
                    }
                }
                mobileNumber.isBlank() -> {
                    withContext(Dispatchers.Main) {
                        val signUpEventModel = SignUpEventModel(app.getString(R.string.alert_Mobile_number_should_not_be_blank))
                        signUpEvent.emit(signUpEventModel)
                    }
                }
                !mobileNumber.matches(mobilePattern.toRegex()) -> {
                    withContext(Dispatchers.Main) {
                        val signUpEventModel = SignUpEventModel(app.getString(R.string.alert_Enter_valid_mobile_number))
                        signUpEvent.emit(signUpEventModel)
                    }
                }
                password.isBlank() -> {
                    withContext(Dispatchers.Main) {
                        val signUpEventModel = SignUpEventModel(app.getString(R.string.alert_password_should_not_be_blank))
                        signUpEvent.emit(signUpEventModel)
                    }
                }
                !password.matches(passwordPattern.toRegex()) -> {
                    withContext(Dispatchers.Main) {
                        val signUpEventModel = SignUpEventModel(app.getString(R.string.alert_enter_valid_password))
                        signUpEvent.emit(signUpEventModel)
                    }
                }
                else -> {
                    val userDetails =
                        UserDetails(1, userName, emailId, password, mobileNumber, "13-01-1998")
                    val exists = repo.checkUserExists(userDetails.email)

                    if (exists) {
                        withContext(Dispatchers.Main) {
                            val signUpEventModel = SignUpEventModel(app.getString(R.string.alert_user_already_exist))
                            signUpEvent.emit(signUpEventModel)
                        }
                    } else {
                        repo.insert(userDetails)
                    }
                }
            }
        }
    }

    private fun isPhoneNumberValid(mobileNumber: String): Boolean {
        return android.util.Patterns.PHONE.matcher(mobileNumber).matches()
    }

    fun onLoginClick() {
        defaultScope.launch {
            val signUpEventModel = SignUpEventModel(clickEvent = ClickEvent.LoginTextClick)
            signUpEvent.emit(signUpEventModel)

        }
    }

    fun onDOBClick() {

    }
}
