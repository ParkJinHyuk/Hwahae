package com.example.hwahae.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.hwahae.R
import com.example.hwahae.base.BaseActivity
import com.example.hwahae.model.CosmeticsDetail
import com.example.hwahae.model.CosmeticsDetailList
import com.example.hwahae.model.CosmeticsList
import com.example.hwahae.presenter.Contract
import com.example.hwahae.presenter.HwahaePresenter
import kotlinx.android.synthetic.main.detail.*

class DetailActivity : BaseActivity(), Contract.View {

    private lateinit var detailPresenter : HwahaePresenter

    override fun showError(error: String) {}

    override fun initPresenter() {
        detailPresenter = HwahaePresenter()
    }

    override fun showCosmeticsList(cosmeticsList: CosmeticsList) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail)

        detailPresenter.takeView(this)

        var id = intent.getStringExtra("KEY")
        if(id != null)
            detailPresenter.getCosmeticsDetail(id)
    }

    override fun showCosmeticsDetail(cosmeticsDetailList: CosmeticsDetailList) {
        Glide.with(this)
            .asBitmap().load(cosmeticsDetailList.body.full_size_image)
            .into(iv_detail_image)

        tv_detail_title.text = cosmeticsDetailList.body.title
        tv_detail_description.text = cosmeticsDetailList.body.description
        tv_detail_price.text = cosmeticsDetailList.body.price
    }
}
