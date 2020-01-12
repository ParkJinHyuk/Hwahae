package com.example.hwahae.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hwahae.R
import com.example.hwahae.base.BaseActivity
import com.example.hwahae.model.Cosmetics
import com.example.hwahae.model.CosmeticsList
import com.example.hwahae.presenter.Contract
import com.example.hwahae.presenter.HwahaePresenter
import kotlinx.android.synthetic.main.hwahae.*

class HwahaeActivity : BaseActivity(), Contract.View {

    private lateinit var hwahaePresenter: HwahaePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hwahae)

        hwahaePresenter.takeView(this)

        // 클릭 이벤트 추가 (presenter에게 notify)
        // ex) click -> presenter.getCosmeticList

        //목록 가져오기
        hwahaePresenter.getCosmeticsList()

        //검색 이벤트
        buttonTest.setOnClickListener {
            val keyword = search.text.toString()
            hwahaePresenter.searchCosmeticsList(keyword)
        }
    }

    override fun initPresenter() {
        hwahaePresenter = HwahaePresenter()
    }

    override fun showCosmeticsList(cosmeticsList: CosmeticsList) {
        val title = cosmeticsList.body[0].title
        textView4.setText("제목 : $title")
    }

    override fun showError(error: String) {

    }
}
