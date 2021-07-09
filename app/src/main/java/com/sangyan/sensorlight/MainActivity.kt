package com.sangyan.sensorlight

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.mikhaellopez.circularprogressbar.CircularProgressBar

import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

var isPLAYING : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mySensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val lightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        if (lightSensor != null) {
            avalible!!.text = "LIGHT Available"
            mySensorManager.registerListener(
                lightSensorListener,
                lightSensor,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        } else {
            avalible!!.text = "LIGHT NOT Available"
        }
    }

    private val lightSensorListener: SensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
            // TODO Auto-generated method stub
        }


        override fun onSensorChanged(event: SensorEvent) {
            if (event.sensor.type == Sensor.TYPE_LIGHT) {
                intensity!!.text = "" + event.values[0]

                if (event.values[0] in 0.0..50.0) {
                    light!!.text = "Switch On Lights"


                    circularProgressBar.apply {
                        // Set Progress
                        progress = 65f
                        // or with animation
                        setProgressWithAnimation(65f, 1000) // =1s

                        // Set Progress Max
                        progressMax = 200f

                        // Set ProgressBar Color
                        progressBarColor = Color.BLACK
                        // or with gradient
                        progressBarColorStart = Color.GRAY
                        progressBarColorEnd = Color.WHITE
                        progressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set background ProgressBar Color
                        backgroundProgressBarColor = Color.GRAY
                        // or with gradient
                        backgroundProgressBarColorStart = Color.WHITE
                        backgroundProgressBarColorEnd = Color.WHITE
                        backgroundProgressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set Width
                        progressBarWidth = 7f // in DP
                        backgroundProgressBarWidth = 3f // in DP

                        // Other
                        roundBorder = true
                        startAngle = 180f
                        progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
                         




                    }


                } else if (event.values[0] in 50.0..100.0) {

                    light!!.text = "Dim Light"
                    circularProgressBar.apply {
                        // Set Progress
                        progress = 65f
                        // or with animation
                        setProgressWithAnimation(65f, 1000) // =1s

                        // Set Progress Max
                        progressMax = 200f

                        // Set ProgressBar Color
                        progressBarColor = Color.BLACK
                        // or with gradient
                        progressBarColorStart = Color.GRAY
                        progressBarColorEnd = Color.RED
                        progressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set background ProgressBar Color
                        backgroundProgressBarColor = Color.GRAY
                        // or with gradient
                        backgroundProgressBarColorStart = Color.WHITE
                        backgroundProgressBarColorEnd = Color.WHITE
                        backgroundProgressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set Width
                        progressBarWidth = 7f // in DP
                        backgroundProgressBarWidth = 3f // in DP

                        // Other
                        roundBorder = true
                        startAngle = 180f
                        progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT


                    }
                } else if (event.values[0] in 100.0..200.0) {
                    light!!.text = "Bright Light"
                    PlayMusic(
                        "https://firebasestorage.googleapis.com/v0/b/spotify-1c1d0.appspot.com/o/Skrillex%20-%20Dirty%20Vibe%20with%20Diplo%2C%20G-Dragon%20and%20CL%20(DJ%20Snake%20%26%20Aazar%20Remix).mp3?alt=media&token=f6e7672c-6de1-494d-b7f7-02bc5e78034a")


                    circularProgressBar.apply {
                        // Set Progress
                        progress = 65f
                        // or with animation
                        setProgressWithAnimation(65f, 20000) // =2s

                        // Set Progress Max
                        progressMax = 200f

                        // Set ProgressBar Color
                        progressBarColor = Color.BLACK
                        // or with gradient
                        progressBarColorStart = Color.GRAY
                        progressBarColorEnd = Color.RED
                        progressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set background ProgressBar Color
                        backgroundProgressBarColor = Color.GRAY
                        // or with gradient
                        backgroundProgressBarColorStart = Color.WHITE
                        backgroundProgressBarColorEnd = Color.RED
                        backgroundProgressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set Width
                        progressBarWidth = 7f // in DP
                        backgroundProgressBarWidth = 3f // in DP

                        // Other
                        roundBorder = true
                        startAngle = 180f
                        progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT



                    }

                } else {

                    circularProgressBar.apply{
                        light!!.text = "Very Bright Light"
                        progress = 65f
                        // or with animation
                        setProgressWithAnimation(65f, 1000) // =1s

                        // Set Progress Max
                        progressMax = 200f

                        // Set ProgressBar Color
                        progressBarColor = Color.BLACK
                        // or with gradient
                        progressBarColorStart = Color.GRAY
                        progressBarColorEnd = Color.RED
                        progressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set background ProgressBar Color
                        backgroundProgressBarColor = Color.GRAY
                        // or with gradient
                        backgroundProgressBarColorStart = Color.WHITE
                        backgroundProgressBarColorEnd = Color.MAGENTA
                        backgroundProgressBarColorDirection =
                            CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                        // Set Width
                        progressBarWidth = 7f // in DP
                        backgroundProgressBarWidth = 3f // in DP

                        // Other
                        roundBorder = true
                        startAngle = 180f
                        progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT

                    }


                }
            }
        }
    }
    fun PlayMusic(url : String){
        if (!isPLAYING) {
            isPLAYING = true

            try {
                var mp = MediaPlayer()
                mp.setDataSource(url)
                mp.prepare()
                mp.start()
            } catch (e: java.lang.Exception) {
              Toast.makeText(applicationContext,"error  $e ",Toast.LENGTH_SHORT).show()
            }
        } else {
            isPLAYING = false

        }
    }

    }


