package com.jcloquell.hellokotlinmvp.base.view

import androidx.appcompat.app.AppCompatActivity
import com.jcloquell.hellokotlinmvp.base.MyApplication
import com.jcloquell.hellokotlinmvp.base.dagger.ApplicationComponent

abstract class BaseActivity : AppCompatActivity() {

  protected val applicationComponent: ApplicationComponent
    get() = (application as MyApplication).applicationComponent
}