package com.example.instadev.view.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instadev.R
import com.example.instadev.view.core.components.InstaButton
import com.example.instadev.view.core.components.InstaOutlinedButton
import com.example.instadev.view.core.components.InstaOutlinedTextField
import com.example.instadev.view.core.components.InstaText

@Composable
fun RegisterScreen(viewModel: RegisterViewModel = hiltViewModel(), navigateBack: () -> Unit) {

    val uiState: RegisterUiState by viewModel.uiState.collectAsStateWithLifecycle()

    val title: String
    val subTitle: String
    val label: String
    val changeModeTitle: String

    when (uiState.isPhoneMode) {
        true -> {
            title = stringResource(id = R.string.register_screen_title_phone_text)
            subTitle = stringResource(id = R.string.register_screen_subtitle_phone_text)
            label = stringResource(id = R.string.register_screen_register_phone_textfield)
            changeModeTitle = stringResource(id = R.string.register_screen_with_email_button)
        }

        false -> {

            title = stringResource(id = R.string.register_screen_title_email_text)
            subTitle = stringResource(id = R.string.register_screen_subtitle_email_text)
            label = stringResource(id = R.string.register_screen_register_email_textfield)
            changeModeTitle = stringResource(id = R.string.register_screen_with_phone_button)
        }
    }

    Scaffold(topBar = { MyTopAppBar(navigateBack) }) { padding: PaddingValues ->

        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .padding(paddingValues = padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            InstaText(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            InstaText(
                modifier = Modifier.fillMaxWidth(),
                text = subTitle,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(12.dp))

            InstaOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                labelText = label,
                value = uiState.value,
                onValueChange = { viewModel.onRegisterChanged(it)}
            )

            Spacer(modifier = Modifier.height(8.dp))

            InstaText(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.register_screen_body_text),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(12.dp))

            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                text = stringResource(R.string.register_screen_next_button),
                isEnabled = uiState.isRegisterEnable
            )

            Spacer(modifier = Modifier.height(4.dp))

            InstaOutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { viewModel.onModeChange() },
                text = changeModeTitle,
                textColor = MaterialTheme.colorScheme.onPrimary
            )

            Spacer(modifier = Modifier.weight(1f))

            InstaText(
                modifier = Modifier.padding(bottom = 14.dp),
                text = stringResource(R.string.register_screen_find_account_link),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(navigateBack: () -> Unit) {

    TopAppBar(
        title = {},
        navigationIcon = {

            Icon(
                painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = stringResource(R.string.register_screen_content_description_back),
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {

                        navigateBack.invoke()
                    },
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
    )
}

@Preview
@Composable
fun RegisterPreview() {

    RegisterScreen(navigateBack = {})
}