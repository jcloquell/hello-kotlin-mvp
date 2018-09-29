package com.jcloquell.hellokotlinmvp.base

import android.app.Application
import com.jcloquell.hellokotlinmvp.base.dagger.ApplicationComponent
import com.jcloquell.hellokotlinmvp.base.dagger.ApplicationModule
import com.jcloquell.hellokotlinmvp.base.dagger.DaggerApplicationComponent

class MyApplication : Application() {

  val applicationComponent: ApplicationComponent by lazy {
    DaggerApplicationComponent.builder()
        .applicationModule(ApplicationModule(this))
        .build()
  }

  override fun onCreate() {
    super.onCreate()
    applicationComponent.inject(this)
  }
}