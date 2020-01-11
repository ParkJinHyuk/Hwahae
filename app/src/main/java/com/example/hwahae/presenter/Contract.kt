package com.example.hwahae.presenter

import com.example.hwahae.base.BasePresenter
import com.example.hwahae.base.BaseView
import com.example.hwahae.model.Cosmetics

interface Contract {

    interface View : BaseView {
        fun showCosmeticsList(cosmeticsList : List<Cosmetics>)
    }

    interface Presenter : BasePresenter<View> {
        fun getCosmeticsList()
    }

}