package com.zinc.gmcompanion.presenter

import com.zinc.gmcompanion.model.Battletech
import com.zinc.gmcompanion.model.TheWitcher
import com.zinc.gmcompanion.model.Icons
import com.zinc.gmcompanion.model.Mythic
import com.zinc.gmcompanion.view.IView

class Presenter : IPresenter {
    val theWitcher = TheWitcher()
    val battletech = Battletech()
    val mythic = Mythic()
    val icons = Icons()
    lateinit var view: IView
}