package com.example.testmoduleapp.ui.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import android.view.View
import butterknife.Unbinder


abstract class BaseFragment : Fragment(), MVPView {

    private val TAG = "BaseFragment"

    // butterknife
    private var mUnBinder: Unbinder? = null

    private var mActivity: BaseActivity? = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity
            this.mActivity = activity
            activity.onFragmentAttached()
        }
    }

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
        TODO("Not yet implemented")
    }

    override fun showMessage(message: String?) {
        TODO("Not yet implemented")
    }

    override fun showMessage(resId: Int) {
        TODO("Not yet implemented")
    }

    override fun isNetworkConnected(): Boolean {
        TODO("Not yet implemented")
    }

    override fun hideKeyboard() {
        TODO("Not yet implemented")
    }

    open fun setUnBinder(unBinder: Unbinder) {
        mUnBinder = unBinder
    }

    protected abstract fun setUp(view: View?)

    override fun onDestroy() {
        mUnBinder?.unbind()
        super.onDestroy()
    }

    interface Callback {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String?)
    }
}