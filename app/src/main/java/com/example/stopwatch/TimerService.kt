package com.example.stopwatch

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class TimerService : Service(

) {

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            Action.START.toString() -> start()
            Action.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {
        val notification = NotificationCompat.Builder(this, "Timer_Channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("just work")
            .setContentText("This is a Timer 00:04:00")
            .build()
        startForeground( 1,notification)
    }

    enum class Action {
        START, STOP
    }
}
