package com.example.hwahae.base

interface BasePresenter<T> {
    fun takeView(view: T)
    fun dropView()
}