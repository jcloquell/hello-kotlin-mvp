package com.jcloquell.hellokotlinmvp.mainScreen.mapper

import com.jcloquell.hellokotlinmvp.base.mapper.BaseMapper
import com.jcloquell.hellokotlinmvp.mainScreen.model.HelloWorldModel
import javax.inject.Inject

class HelloWorldModelMapper @Inject constructor() : BaseMapper<String, HelloWorldModel> {

  override fun mapDataModelToViewModel(dataModel: String) = HelloWorldModel(dataModel)
}