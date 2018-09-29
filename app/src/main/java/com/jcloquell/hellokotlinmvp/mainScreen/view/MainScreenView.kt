package com.jcloquell.hellokotlinmvp.mainScreen.view

import com.jcloquell.hellokotlinmvp.mainScreen.model.HelloWorldModel

interface MainScreenView {

  fun displayHelloWorldModel(helloWorldModel: HelloWorldModel)
}