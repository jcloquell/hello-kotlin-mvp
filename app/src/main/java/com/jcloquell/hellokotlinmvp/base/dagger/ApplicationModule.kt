package com.jcloquell.hellokotlinmvp.base.dagger

import android.app.Application
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import io.door2door.connect.base.dagger.scopes.ApplicationScope

@Module
class ApplicationModule(private val application: Application) {

  @ApplicationScope
  @Provides
  fun providesApplication(): Application = application

  @ApplicationScope
  @Provides
  fun providesResources(): Resources = application.resources
}