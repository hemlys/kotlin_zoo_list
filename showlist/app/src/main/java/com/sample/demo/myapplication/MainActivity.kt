@file:Suppress("DEPRECATION")

package com.sample.demo.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.demo.myapplication.adapter.UsersListAdapter
import com.sample.demo.myapplication.bean.ResultsItem
import com.sample.demo.myapplication.bean.UsersList
import com.sample.demo.myapplication.bean.Zoobean
import com.sample.demo.myapplication.fragment.DemoDialogFragment
import com.sample.demo.myapplication.net.InfoViewModel
import com.sample.demo.myapplication.ui.ProgressbarFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val infoViewModel: InfoViewModel by viewModel()
    private lateinit var rv_animal_list: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dialog = ProgressbarFragment.newInstance(getString(R.string.uploading))
        infoViewModel.userListLiveData.observe(this, Observer {
            rv_animal_list.adapter =
                UsersListAdapter(it, { partItem: ResultsItem -> partItemClicked(partItem) })
        })

        rv_animal_list = findViewById(R.id.rv_animal_list)
        rv_animal_list.layoutManager = LinearLayoutManager(this)
        infoViewModel.getAll()
        infoViewModel.loading.observe(this, Observer { loading ->
            if (loading) {
                supportFragmentManager.let {
                    dialog.show(it, "Loading....")
                }
            } else {
                dialog.dismiss()
            }
        })
    }

    private fun partItemClicked(partItem: ResultsItem) {
//        Toast.makeText(this, "Clicked: ${partItem.eName}", Toast.LENGTH_LONG).show()
//        val intent = Intent(applicationContext,Userinfo::class.java).apply {
//            putExtra("name", partItem.eName)
//            putExtra("img", partItem.ePicURL)
//            putExtra("info", partItem.eInfo)
//        }
//        startActivity(intent)
        val demoDialogFragment = DemoDialogFragment()
        val bundle = Bundle()
        bundle.putString("name", partItem.eName)
        bundle.putString("img", partItem.ePicURL)
        bundle.putString("info", partItem.eInfo)
        demoDialogFragment.setArguments(bundle)
        demoDialogFragment.show(supportFragmentManager, "DemoDialogFragment")
    }
}
