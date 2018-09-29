package com.jcloquell.hellokotlinmvp.mainScreen.interactor

import android.content.res.Resources
import com.jcloquell.hellokotlinmvp.R
import io.reactivex.Observable
import javax.inject.Inject

class MainScreenInteractorImp @Inject constructor(
    private val resources: Resources) : MainScreenInteractor {

  override fun getHelloWorldStringObservable(): Observable<String> {
    val helloWorldString = resources.getString(R.string.hello_world)
    return Observable.just(helloWorldString)
  }
}