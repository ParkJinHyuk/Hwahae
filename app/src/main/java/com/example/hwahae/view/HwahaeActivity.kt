package com.example.hwahae.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hwahae.R
import com.example.hwahae.base.BaseActivity
import com.example.hwahae.model.Cosmetics
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
        buttonTest.setOnClickListener {
            
        }


        hwahaePresenter.getCosmeticsList()


    }

    override fun initPresenter() {
        hwahaePresenter = HwahaePresenter()
    }

    override fun showCosmeticsList(cosmeticsList: List<Cosmetics>) {
        //
    }

    override fun showError(error: String) {

    }
}
