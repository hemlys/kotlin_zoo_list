package com.sample.demo.myapplication.bean

import com.google.gson.annotations.SerializedName

data class Zoobean(@SerializedName("result")
                   val result: Result)