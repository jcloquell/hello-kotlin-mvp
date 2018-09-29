package com.jcloquell.hellokotlinmvp.mainScreen.dagger

import com.jcloquell.hellokotlinmvp.base.dagger.ApplicationComponent
import com.jcloquell.hellokotlinmvp.mainScreen.view.MainScreenActivity
import dagger.Component
import io.door2door.connect.base.dagger.scopes.ActivityScope

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [MainScreenModule::class])
interface MainScreenComponent {

  fun inject(mainScreenActivity: MainScreenActivity)
}

