package com.sample.demo.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.sample.demo.myapplication.R
import com.sample.demo.myapplication.net.InfoViewModel
import kotlinx.android.synthetic.main.activity_info.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class Userinfo : AppCompatActivity() {
    private val infoViewModel: InfoViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val intent = intent
        var name = intent.getStringExtra("name")
        var img = intent.getStringExtra("img")
        var info = intent.getStringExtra("info")

        Glide
            .with(imageView)
            .load(img)
            .centerCrop()
            .into(imageView);
        textView.text = "name:" + name
        textView2.text = "info:" + info

//        val dialog = ProgressbarFragment.newInstance(getString(R.string.uploading))
//        infoViewModel.userInfoLiveData.observe(this, Observer {
//            Glide
//                .with(imageView)
//                .load(it.avatar_url)
//                .centerCrop()
//                .into(imageView);
//            textView.text = "name:" + it.name
//            textView2.text = "bio:" + it.bio
//            textView3.text = "login:" + it.login
//            textView4.text = "site_admin:" + it.site_admin
//            textView5.text = "location:" + it.location
//            textView6.text = "blog:" + it.blog
//        })
//
//
//        infoViewModel.getusers(message)
//        infoViewModel.loading.observe(this, Observer { loading ->
//            if (loading) {
//                supportFragmentManager.let {
//                    dialog.show(it, "Loading....")
//                }
//            } else {
//                dialog.dismiss()
//            }
//        })
    }


}
