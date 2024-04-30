package com.example.stopwatch.stopWatch

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Timer
class StopWatchViewModel:ViewModel(){

    private val _time= Time()
    private val _hour = mutableIntStateOf(_time.hour)
    val hour: State<Int> = _hour


    private val _second = mutableIntStateOf(_time.second)
    val second: State<Int> = _second

    private val _minute = mutableIntStateOf(_time.minute)
    val minute: State<Int> = _minute


   private fun increaseByOne(){
        _second.intValue ++
    }
    suspend fun increaseTime(isRunning:Boolean = true){
        while (isRunning) {

            if (_second.intValue == 60 ){
                _minute.intValue++
                _second.intValue = 0
            }
            if(_minute.intValue == 60){
                _hour.intValue++
                _minute.intValue = 0
            }
            delay(1000)
            _second.intValue++
        }
    }
    fun stopWatch(isRunning: Boolean){
        viewModelScope.launch{
            increaseTime(isRunning)
        }
    }


}