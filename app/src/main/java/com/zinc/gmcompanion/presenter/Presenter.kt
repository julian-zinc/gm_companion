package com.zinc.gmcompanion.presenter

import com.zinc.gmcompanion.model.*
import com.zinc.gmcompanion.view.IView

class Presenter : IPresenter {
    val theWitcher = TheWitcher()
    val battletechAI = BattletechAI()
    val battletechLance = BattletechLance()
    val mythic = Mythic()
    val icons = Icons()
    lateinit var view: IView
}