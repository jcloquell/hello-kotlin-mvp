package com.jcloquell.hellokotlinmvp.mainScreen.dagger

import com.jcloquell.hellokotlinmvp.mainScreen.interactor.MainScreenInteractor
import com.jcloquell.hellokotlinmvp.mainScreen.interactor.MainScreenInteractorImp
import com.jcloquell.hellokotlinmvp.mainScreen.mapper.HelloWorldModelMapper
import com.jcloquell.hellokotlinmvp.mainScreen.presenter.MainScreenPresenter
import com.jcloquell.hellokotlinmvp.mainScreen.presenter.MainScreenPresenterImp
import com.jcloquell.hellokotlinmvp.mainScreen.view.MainScreenView
import dagger.Module
import dagger.Provides
import io.door2door.connect.base.dagger.scopes.ActivityScope

@Module
class MainScreenModule(private val mainScreenView: MainScreenView) {

  @ActivityScope
  @Provides
  fun providesMainScreenView(): MainScreenView = mainScreenView

  @ActivityScope
  @Provides
  fun providesMainScreenPresenter(
      mainScreenPresenter: MainScreenPresenterImp): MainScreenPresenter = mainScreenPresenter

  @ActivityScope
  @Provides
  fun providesMainScreenInteractor(
      mainScreenInteractor: MainScreenInteractorImp): MainScreenInteractor = mainScreenInteractor

  @ActivityScope
  @Provides
  fun providesHelloWorldModelMapper() = HelloWorldModelMapper()
}