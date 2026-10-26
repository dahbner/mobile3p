package org.ucb.mobile3p.signin.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import edu.ucb.ds.buttons.MainButton
import mobile3p.shared.generated.resources.Res
import mobile3p.shared.generated.resources.login_title
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.ucb.mobile3p.signin.presentation.viewmodel.LoginEffects
import org.ucb.mobile3p.signin.presentation.viewmodel.LoginEvents
import org.ucb.mobile3p.signin.presentation.viewmodel.LoginViewModel

@Composable
fun LoginScreen( viewModel: LoginViewModel = koinViewModel()) {

    val state = viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.effects.collect { effect ->
            when(effect) {
                LoginEffects.NavigateToHome -> TODO()
                is LoginEffects.ShowToast -> {
                    println("ERROR ${effect.message}")
                }
                LoginEffects.SignUp -> TODO()
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = state.value.email, onValueChange = {
            viewModel.emitEvent(LoginEvents.OnEmailChanged(it))
        })
        MainButton(stringResource(Res.string.login_title)) {
            viewModel.emitEvent(LoginEvents.OnSubmit)
        }
    }
}
