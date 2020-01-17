package com.example.hwahae.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hwahae.R
import com.example.hwahae.base.BaseActivity
import com.example.hwahae.model.*
import com.example.hwahae.presenter.Contract
import com.example.hwahae.presenter.HwahaePresenter
import kotlinx.android.synthetic.main.hwahae.*

class HwahaeActivity : BaseActivity(), Contract.View {

    private lateinit var hwahaePresenter: HwahaePresenter
    private var skin = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hwahae)

        hwahaePresenter.takeView(this)
        //hwahaePresenter.getCosmeticsList()

        val skinType = resources.getStringArray(R.array.skin_type)
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, skinType)
        spinner.adapter = spinnerAdapter


        //스피너 이벤트
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {
                        //
                    }
                    1 -> {
                        skin = "oily"
                    }
                    2 -> {
                        skin = "dry"
                    }
                    3 -> {
                        skin = "sensitive"
                    }
                }
                hwahaePresenter.getCosmeticsList(skin)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }


        //검색 이벤트
        button5.setOnClickListener {
            val keyword = search.text.toString()
            hwahaePresenter.searchCosmeticsList(keyword, skin)
        }
    }

    override fun initPresenter() {
        hwahaePresenter = HwahaePresenter()
    }

    override fun showCosmeticsList(cosmeticsList: CosmeticsList) {
        val mAdapter = MainAdapter(this, cosmeticsList) {cosmetics ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("KEY", cosmetics.id.toString())
            startActivity(intent)
        }
        recyclerView.adapter = mAdapter

        val lm = GridLayoutManager(this, 2)
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)
    }


    override fun showError(error: String) {}

    override fun showCosmeticsDetail(cosmeticsDetailList: CosmeticsDetailList) {}
}
