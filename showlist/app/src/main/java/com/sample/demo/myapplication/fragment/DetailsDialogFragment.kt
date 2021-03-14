package com.sample.demo.myapplication.fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.demo.myapplication.R
import com.sample.demo.myapplication.adapter.DetailsListAdapter
import com.sample.demo.myapplication.adapter.UsersListAdapter
import com.sample.demo.myapplication.bean.detail.ResultsItem
import com.sample.demo.myapplication.net.InfoViewModel
import com.sample.demo.myapplication.ui.ProgressbarFragment
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.activity_info.imageView
import kotlinx.android.synthetic.main.activity_info.textView
import kotlinx.android.synthetic.main.demo_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsDialogFragment : androidx.fragment.app.DialogFragment() {

    private val infoViewModel: InfoViewModel by viewModel()
    private lateinit var rv_list: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        var dialog = super.onCreateDialog(savedInstanceState)
        val window = dialog.window
        window?.requestFeature(Window.FEATURE_NO_TITLE)
        window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_NoTitleBar_Fullscreen)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.detail_fragment, container)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

  fun initView(){
      toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
      toolbar.setNavigationOnClickListener { dismiss() }
      toolbar.setTitleTextColor(Color.BLACK)
      val bundle = getArguments()
      if (bundle != null) {
          val name = bundle.getString("name")
          val img = bundle.getString("img")
          val info = bundle.getString("info")
          val fNameLatin = bundle.getString("fNameLatin")
          val fBrief = bundle.getString("fBrief")


          toolbar.title = name
          activity?.let {
              Glide
                  .with(it)
                  .load(img)
                  .centerCrop()
                  .into(imageViewse)
          }
          textViews.text = name+"\n"+fNameLatin+"\n"+"\n"+fBrief+"\n"+"\n"+info
      }


    }



}