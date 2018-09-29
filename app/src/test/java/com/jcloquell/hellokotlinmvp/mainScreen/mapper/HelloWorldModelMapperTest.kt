package com.jcloquell.hellokotlinmvp.mainScreen.mapper

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class HelloWorldModelMapperTest {

  private lateinit var helloWorldModelMapper: HelloWorldModelMapper

  @Before
  fun setUp() {
    helloWorldModelMapper = HelloWorldModelMapper()
  }

  @Test
  fun `should map String to HelloWorldModel`() {
    //given
    val helloWorldString = "Hello World!"

    //when
    val helloWorldModel = helloWorldModelMapper.mapDataModelToViewModel(helloWorldString)

    //then
    assertThat(helloWorldModel.text).isEqualTo(helloWorldString)
  }
}