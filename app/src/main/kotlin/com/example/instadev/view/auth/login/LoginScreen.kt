package com.example.instadev.view.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.instadev.R
import com.example.instadev.view.core.components.InstaButton
import com.example.instadev.view.core.components.InstaOutlinedButton
import com.example.instadev.view.core.components.InstaOutlinedTextField
import com.example.instadev.view.core.components.InstaText
import com.example.instadev.view.core.components.InstaTextButton

@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel(), navigateToRegister: () -> Unit) {

    val uiState: LoginUiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { padding: PaddingValues ->

        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .padding(paddingValues = padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            InstaText(
                modifier = Modifier.padding(top = 22.dp),
                text = stringResource(id = R.string.login_screen_language),
                color = MaterialTheme.colorScheme.onBackground,
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                modifier = Modifier.size(60.dp),
                painter = painterResource(id = R.drawable.instadev_logo),
                contentDescription = stringResource(id = R.string.login_screen_content_description_instagram_logo)
            )

            Spacer(modifier = Modifier.weight(1f))

            InstaOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                labelText = stringResource(id = R.string.login_screen_user_text_field),
                value = uiState.email,
                onValueChange = { viewModel.onEmailChange(it) }
            )

            Spacer(modifier = Modifier.height(10.dp))

            InstaOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                labelText = stringResource(id = R.string.login_screen_user_password),
                value = uiState.password,
                onValueChange = { viewModel.onPasswordChange(it) }
            )

            Spacer(modifier = Modifier.height(10.dp))

            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                onClick = { viewModel.doLogin() },
                isEnabled = uiState.isLoginEnabled,
                shape = MaterialTheme.shapes.medium,
                text = stringResource(id = R.string.login_screen_start_session)
            )

            InstaTextButton(
                onClick = {},
                text = stringResource(id = R.string.login_screen_forgot_password)
            )

            Spacer(modifier = Modifier.weight(1.3f))

            InstaOutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navigateToRegister.invoke()},
                text = stringResource(id = R.string.login_screen_create_account)
            )

            Icon(
                modifier = Modifier
                    .width(60.dp)
                    .padding(vertical = 22.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = stringResource(id = R.string.login_screen_content_description_meta_logo),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Preview
@Composable
fun LoginPreview() {

    LoginScreen(navigateToRegister = {})
}