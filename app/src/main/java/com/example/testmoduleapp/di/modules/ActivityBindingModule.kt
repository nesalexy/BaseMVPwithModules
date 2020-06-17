package com.example.testmoduleapp.di.modules

import com.example.testmoduleapp.ui.activities.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}