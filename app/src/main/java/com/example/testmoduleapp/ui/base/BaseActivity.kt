package com.example.testmoduleapp.ui.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import butterknife.Unbinder
import com.example.testmoduleapp.R
import com.google.android.material.snackbar.Snackbar


abstract class BaseActivity : AppCompatActivity(), MVPView {

    private val TAG = "BaseActivity"

    private var mUnBinder: Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //snakbar
    private fun showSnackBar(message: String): Unit {
        val snackbar: Snackbar = Snackbar.make(
            findViewById<View>(android.R.id.content),
            message, Snackbar.LENGTH_SHORT
        )

        val sbView: View = snackbar.getView()
        val textView = sbView
            .findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        textView.setTextColor(ContextCompat.getColor(this, R.color.white))
        snackbar.show()
    }

    open fun onFragmentAttached() {}

    override fun showLoading() {
        Log.e(TAG, "showLoading activity")
    }

    override fun hideLoading() {
        Log.e(TAG, "hideLoading activity")
    }

    override fun openActivityOnTokenExpire() {
        TODO("Not yet implemented")
    }

    override fun onError(resId: Int) {
        TODO("Not yet implemented")
    }

    override fun onError(message: String?) {
        Log.e(TAG, message)
    }

    override fun showMessage(message: String?) {
        message?.let { showSnackBar(it) }
    }

    override fun showMessage(resId: Int) {
        //showSnackBar()
    }

    override fun isNetworkConnected(): Boolean {
        Log.e(TAG, "isNetworkConnected")
        return true
    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    protected abstract fun setUp()

    open fun setUnBinder(unBinder: Unbinder) {
        mUnBinder = unBinder
    }

    override fun onDestroy() {
        mUnBinder?.unbind()
        super.onDestroy()
    }

}