package com.example.hwahae.presenter

import com.example.hwahae.model.CosmeticsList
import com.example.hwahae.model.SearchRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HwahaePresenter : Contract.Presenter {

    private var hwahaeView : Contract.View? = null

    override fun takeView(view: Contract.View) {
        hwahaeView = view
    }

    override fun dropView() {
        hwahaeView = null
    }

    override fun getCosmeticsList() {
        // 모델로부터 데이터를 받음
        SearchRetrofit.getService().getCosmetics(skin_type = "oily", page = 1).enqueue(object : Callback<CosmeticsList> {
            override fun onResponse(call: Call<CosmeticsList>, response: Response<CosmeticsList>) {
                val data = response.body()
                if (data != null) {
                    hwahaeView?.showCosmeticsList(data)
                }
            }
            override fun onFailure(call: Call<CosmeticsList>, t: Throwable) {
            }
        })
    }

    override fun searchCosmeticsList(keyword: String) {
        SearchRetrofit.getService().searchCosmetics(skin_type = "oily", page = 1, search = keyword).enqueue(object : Callback<CosmeticsList> {
            override fun onResponse(call: Call<CosmeticsList>, response: Response<CosmeticsList>) {
                val data = response.body()
                if (data != null) {
                    hwahaeView?.showCosmeticsList(data)
                }
            }
            override fun onFailure(call: Call<CosmeticsList>, t: Throwable) {
            }
        })
    }
}