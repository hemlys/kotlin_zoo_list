package com.sample.demo.myapplication.net


import io.reactivex.Single
import retrofit2.http.GET
import com.sample.demo.myapplication.bean.UsersDetails
import com.sample.demo.myapplication.bean.UsersList
import com.sample.demo.myapplication.bean.Zoobean
import com.sample.demo.myapplication.bean.detail.ZooDetails
import retrofit2.http.Path

interface ApiService {


    @GET("/api/v1/dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
    fun getAll(): Single<Zoobean>

    @GET("/api/v1/dataset/f18de02f-b6c9-47c0-8cda-50efad621c14?scope=resourceAquire")
    fun getUsersDetail(): Single<ZooDetails>
}
