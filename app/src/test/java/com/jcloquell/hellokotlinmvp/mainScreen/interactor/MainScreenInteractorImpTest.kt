package com.jcloquell.hellokotlinmvp.mainScreen.interactor

import android.content.res.Resources
import com.jcloquell.hellokotlinmvp.ImmediateSchedulersRule
import com.jcloquell.hellokotlinmvp.R
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainScreenInteractorImpTest {

  @Rule
  @JvmField
  val schedulers = ImmediateSchedulersRule()

  private val resources = mock<Resources>()

  private lateinit var mainScreenInteractor: MainScreenInteractor

  @Before
  fun setUp() {
    mainScreenInteractor = MainScreenInteractorImp(resources)
  }

  @Test
  fun `should return hello world string as an Observable`() {
    //given
    val observer = TestObserver.create<String>()
    val helloWorldString = "Hello World!"
    whenever(resources.getString(R.string.hello_world)).thenReturn(helloWorldString)

    //when
    mainScreenInteractor.getHelloWorldStringObservable().subscribe(observer)

    //then
    observer.assertNoErrors()
    observer.assertValue(helloWorldString)
  }
}