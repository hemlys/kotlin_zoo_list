package com.sample.demo.myapplication.bean

import com.google.gson.annotations.SerializedName

data class ResultsItem(@SerializedName("E_Pic_URL")
                       val ePicURL: String = "",
                       @SerializedName("E_Info")
                       val eInfo: String = "",
                       @SerializedName("E_Category")
                       val eCategory: String = "",
                       @SerializedName("E_Memo")
                       val eMemo: String = "",
                       @SerializedName("E_no")
                       val eNo: String = "",
                       @SerializedName("E_Name")
                       val eName: String = "",
                       @SerializedName("_id")
                       val Id: Int = 0,
                       @SerializedName("E_URL")
                       val eUrl: String = "",
                       @SerializedName("E_Geo")
                       val eGeo: String = "")