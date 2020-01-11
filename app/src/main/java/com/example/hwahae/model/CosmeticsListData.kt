package com.example.hwahae.model

import android.util.Log
import java.net.URL
import java.util.concurrent.Executors

object CosmeticsListData {

    fun getCosmeticslistData(): List<Cosmetics> {


            val result =
                URL("https://6uqljnm1pb.execute-api.ap-northeast-2.amazonaws.com/prod/products?skin_type=oily&page=10").readText()


        return listOf(
            Cosmetics("토너", 1000),
            Cosmetics("샴푸", 2000)
        )
    }
}