package com.sample.demo.myapplication.net

import io.reactivex.Single
import com.sample.demo.myapplication.bean.UsersDetails
import com.sample.demo.myapplication.bean.UsersList
import com.sample.demo.myapplication.bean.Zoobean
import com.sample.demo.myapplication.bean.detail.ZooDetails


class InfoRepository {
    private val apiService = AppClientManager.retrofit.create(ApiService::class.java)

    fun getAll(): Single<Zoobean> {
        return apiService.getAll()
    }
    fun getUsers(): Single<ZooDetails> {
        return apiService.getUsersDetail()
    }
}