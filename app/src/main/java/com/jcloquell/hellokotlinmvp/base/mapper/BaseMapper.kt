package com.jcloquell.hellokotlinmvp.base.mapper

interface BaseMapper<in D, out V> {

  fun mapDataModelToViewModel(dataModel: D): V
}
