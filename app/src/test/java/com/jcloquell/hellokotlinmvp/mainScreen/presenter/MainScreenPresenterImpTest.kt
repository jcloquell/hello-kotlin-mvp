package com.jcloquell.hellokotlinmvp.mainScreen.presenter

import com.jcloquell.hellokotlinmvp.ImmediateSchedulersRule
import com.jcloquell.hellokotlinmvp.mainScreen.interactor.MainScreenInteractor
import com.jcloquell.hellokotlinmvp.mainScreen.mapper.HelloWorldModelMapper
import com.jcloquell.hellokotlinmvp.mainScreen.model.HelloWorldModel
import com.jcloquell.hellokotlinmvp.mainScreen.view.MainScreenView
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainScreenPresenterImpTest {

  @Rule
  @JvmField
  val schedulers = ImmediateSchedulersRule()

  private val mainScreenView = mock<MainScreenView>()
  private val mainScreenInteractor = mock<MainScreenInteractor>()
  private val helloWorldModelMapper = mock<HelloWorldModelMapper>()

  private lateinit var mainScreenPresenter: MainScreenPresenter

  @Before
  fun setUp() {
    initializeMocks()
    mainScreenPresenter = MainScreenPresenterImp(mainScreenView, mainScreenInteractor,
        helloWorldModelMapper)
  }

  private fun initializeMocks() {
    whenever(mainScreenInteractor.getHelloWorldStringObservable()).thenReturn(Observable.empty())
  }

  @Test
  fun `should display hello world model when view is created`() {
    //given
    val helloWorldString = "Hello World!"
    val helloWorldModel = mock<HelloWorldModel>()
    whenever(mainScreenInteractor.getHelloWorldStringObservable()).thenReturn(
        Observable.just(helloWorldString))
    whenever(helloWorldModelMapper.mapDataModelToViewModel(helloWorldString)).thenReturn(
        helloWorldModel)

    //when
    mainScreenPresenter.viewCreated()

    //then
    verify(mainScreenView).displayHelloWorldModel(helloWorldModel)
  }

  @Test
  fun `should not display hello world model when there is an error`() {
    //given
    val throwable = mock<Throwable>()
    whenever(mainScreenInteractor.getHelloWorldStringObservable()).thenReturn(
        Observable.error(throwable))

    //when
    mainScreenPresenter.viewCreated()

    //then
    verify(mainScreenView, never()).displayHelloWorldModel(any())
  }

  @Test
  fun `should not receive more events to display hello world model when view is destroyed`() {
    //given
    val subject = PublishSubject.create<String>()
    val helloWorldString = "Hello World!"
    val helloWorldModel = mock<HelloWorldModel>()
    whenever(mainScreenInteractor.getHelloWorldStringObservable()).thenReturn(subject)
    whenever(helloWorldModelMapper.mapDataModelToViewModel(helloWorldString)).thenReturn(
        helloWorldModel)
    mainScreenPresenter.viewCreated()
    subject.onNext(helloWorldString)
    verify(mainScreenView).displayHelloWorldModel(helloWorldModel)

    //when
    mainScreenPresenter.viewDestroyed()
    subject.onNext(helloWorldString)

    //then
    verify(mainScreenView).displayHelloWorldModel(helloWorldModel)
  }
}