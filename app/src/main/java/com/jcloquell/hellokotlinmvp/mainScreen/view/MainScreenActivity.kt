package com.jcloquell.hellokotlinmvp.mainScreen.view

import android.os.Bundle
import com.jcloquell.hellokotlinmvp.R
import com.jcloquell.hellokotlinmvp.base.view.BaseActivity
import com.jcloquell.hellokotlinmvp.mainScreen.dagger.DaggerMainScreenComponent
import com.jcloquell.hellokotlinmvp.mainScreen.dagger.MainScreenModule
import com.jcloquell.hellokotlinmvp.mainScreen.model.HelloWorldModel
import com.jcloquell.hellokotlinmvp.mainScreen.presenter.MainScreenPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainScreenActivity : BaseActivity(), MainScreenView {

  @Inject
  lateinit var mainScreenPresenter: MainScreenPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    injectDependencies()
    mainScreenPresenter.viewCreated()
  }

  private fun injectDependencies() {
    DaggerMainScreenComponent.builder()
        .applicationComponent(applicationComponent)
        .mainScreenModule(MainScreenModule(this))
        .build()
        .inject(this)
  }

  override fun displayHelloWorldModel(helloWorldModel: HelloWorldModel) {
    helloWorldTextView.text = helloWorldModel.text
  }

  override fun onDestroy() {
    super.onDestroy()
    mainScreenPresenter.viewDestroyed()
  }
}
