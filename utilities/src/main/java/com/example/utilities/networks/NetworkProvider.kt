package com.example.utilities.networks

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.example.utilities.resources.IResourceProvider

//class NetworkProvider: INetworkProvider {
class NetworkProvider(private val context: Context?): INetworkProvider {

    override fun isNetwork(): Boolean {
        Log.e("NetworkProvider", "isNetwork and context")
        return true
    }

}