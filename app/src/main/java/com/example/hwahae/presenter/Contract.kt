package com.example.hwahae.presenter

import com.example.hwahae.base.BasePresenter
import com.example.hwahae.base.BaseView
import com.example.hwahae.model.CosmeticsList

interface Contract {

    interface View : BaseView {
        fun showCosmeticsList(cosmeticsList : CosmeticsList)
    }

    interface Presenter : BasePresenter<View> {
        fun getCosmeticsList(skinType : String)
        fun searchCosmeticsList(keyword: String, skinType : String)
    }

}