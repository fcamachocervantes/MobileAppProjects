package com.csci448.fcamachocervantes_A2.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.csci448.fcamachocervantes_A2.data.History

class GameViewModel(
    private var mHistory: List<History>,
    initialPlayerScore: Int = 0,
    initialComputerScore: Int = 0,
    initialTieScore: Int = 0,
    initialOnePlayerGame: Boolean = false,
    initialAILevelHard: Boolean = false,
    initialXGoesFirst: Boolean = false,
) : ViewModel() {

    private val mCurrentPlayerScore = mutableStateOf(initialPlayerScore)
    private val mCurrentComputerScore = mutableStateOf(initialComputerScore)
    private val mCurrentTiesScore = mutableStateOf(initialTieScore)
    private val mOnePlayerGame = mutableStateOf(initialOnePlayerGame)
    private val mAILevelHard = mutableStateOf(initialAILevelHard)
    private val mXGoesFirst = mutableStateOf(initialXGoesFirst)

    val playerScoreState: State<Int>
        get() = mCurrentPlayerScore

    val computerScoreState: State<Int>
        get() = mCurrentComputerScore

    val tieScoreState: State<Int>
        get() = mCurrentTiesScore

    val onePlayerGame: State<Boolean>
        get() = mOnePlayerGame

    val aiLevelHard: State<Boolean>
        get() = mAILevelHard

    val xGoesFirst: State<Boolean>
        get() = mXGoesFirst

    val historyList: List<History>
        get() = mHistory

    fun updateOnePlayerGame(){
        mOnePlayerGame.value = !(mOnePlayerGame.value)
    }

    fun updateAILevelHard(){
        mAILevelHard.value = !(mAILevelHard.value)
    }

    fun updateXGoesFirst(){
        mXGoesFirst.value = !(mXGoesFirst.value)
    }

    fun deleteHistory(){
        mHistory = emptyList()
    }

}