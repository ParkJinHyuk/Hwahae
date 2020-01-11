package com.example.hwahae.presenter

import com.example.hwahae.model.CosmeticsListData

class HwahaePresenter : Contract.Presenter {

    private var hwahaeView : Contract.View? = null

    override fun takeView(view: Contract.View) {
        hwahaeView = view
    }

    override fun getCosmeticsList() {
        val cosmeticsList = CosmeticsListData.getCosmeticslistData()
        // 모델로부터 데이터를 받음, 여기서 로직 및 처리?





        hwahaeView?.showCosmeticsList(cosmeticsList)
        // 받은 데이터를 View에게 전달
    }

    override fun dropView() {
        hwahaeView = null
    }
}