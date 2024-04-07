package com.example.workmanagerexample

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MyWorker(appContext: Context, workerParams: WorkerParameters):
    CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        withContext(Dispatchers.Main) {
            val toast = Toast.makeText(applicationContext, "Started Work", Toast.LENGTH_SHORT)
            toast.show()
        }

        Log.d("GGG", "doWork: ")
        //Emulate data required for the task.
        val data = ByteArray(10 * 1024 * 1024) // Allocate 10 MB of memory

        // Emulate 10 second work
        delay(10000)

        withContext(Dispatchers.Main) {
            val toast = Toast.makeText(applicationContext, "Done some Work", Toast.LENGTH_SHORT)
            toast.show()
        }

        return Result.success()
    }
}