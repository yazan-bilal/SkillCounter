package com.example.stopwatch

import android.Manifest
import android.app.Application
import android.content.ActivityNotFoundException
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.example.stopwatch.stopWatch.StopWatchScreen
import com.example.stopwatch.ui.theme.StopWatchTheme
import dagger.hilt.android.qualifiers.ApplicationContext
import java.net.URI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                0
            )
        }
        setContent {
            StopWatchTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                    StopWatchScreen()
                    Button(onClick = {
                        Intent(applicationContext,TimerService::class.java).also {
                            it.action = TimerService.Action.START.toString()
                            startService(it)
                        }
                    }) {
                        Text(text = "Start Service")
                    }
                    Button(onClick = {
                        Intent(applicationContext,TimerService::class.java).also {
                            it.action = TimerService.Action.STOP.toString()
                            startService(it)

                        }
                    }) {
                        Text(text = "Stop Service")
                    }
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}

