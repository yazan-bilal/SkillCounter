package com.example.stopwatch.stopWatch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun StopWatchScreen(
    modifier: Modifier = Modifier,
) {
    val viewModel  = viewModel<StopWatchViewModel>()
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val runningState  = remember {
            mutableStateOf(false)
        }

        val second = viewModel.second.value
        Text(text = viewModel.hour.value.toString())
        Text(text = viewModel.minute.value.toString())
        Text(text = second.toString())
        Button(onClick = {
            viewModel.stopWatch(isRunning = !runningState.value)
        }) {
            Text(text = "Start")
        }
        Button(onClick = {
        }) {
            Text(text = "Start2")
        }

    }
}