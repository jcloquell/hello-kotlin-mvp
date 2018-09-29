package com.jcloquell.hellokotlinmvp.base.dagger

import android.app.Application
import android.content.res.Resources
import com.jcloquell.hellokotlinmvp.base.MyApplication
import dagger.Component
import io.door2door.connect.base.dagger.scopes.ApplicationScope

@ApplicationScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

  fun inject(myApplication: MyApplication)

  val application: Application

  val resources: Resources
}

