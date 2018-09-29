package com.jcloquell.hellokotlinmvp.mainScreen.interactor

import io.reactivex.Observable

interface MainScreenInteractor {

  fun getHelloWorldStringObservable(): Observable<String>
}