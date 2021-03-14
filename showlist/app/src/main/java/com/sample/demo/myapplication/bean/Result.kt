package com.sample.demo.myapplication.bean

import com.google.gson.annotations.SerializedName

data class Result(@SerializedName("offset")
                  val offset: Int = 0,
                  @SerializedName("limit")
                  val limit: Int = 0,
                  @SerializedName("count")
                  val count: Int = 0,
                  @SerializedName("sort")
                  val sort: String = "",
                  @SerializedName("results")
                  val results: List<ResultsItem>?)