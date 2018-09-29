package com.jcloquell.hellokotlinmvp.mainScreen.presenter

import android.util.Log
import com.jcloquell.hellokotlinmvp.mainScreen.interactor.MainScreenInteractor
import com.jcloquell.hellokotlinmvp.mainScreen.mapper.HelloWorldModelMapper
import com.jcloquell.hellokotlinmvp.mainScreen.view.MainScreenView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainScreenPresenterImp @Inject constructor(
    private val mainScreenView: MainScreenView,
    private val mainScreenInteractor: MainScreenInteractor,
    private val helloWorldModelMapper: HelloWorldModelMapper) : MainScreenPresenter {

  companion object {
    private val TAG = MainScreenPresenterImp::class.java.simpleName
  }

  private val disposables = CompositeDisposable()

  override fun viewCreated() {
    subscribeToHelloWorldStringEvents()
  }

  override fun viewDestroyed() {
    disposables.dispose()
  }

  private fun subscribeToHelloWorldStringEvents() {
    disposables.add(mainScreenInteractor.getHelloWorldStringObservable()
        .map {
          helloWorldModelMapper.mapDataModelToViewModel(it)
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          mainScreenView.displayHelloWorldModel(it)
        }, {
          Log.d(TAG, "Error getting HelloWorldString", it)
        }))
  }
}