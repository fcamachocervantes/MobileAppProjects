package edu.csci448.beatboxcompose.presentation

import androidx.compose.runtime.Composable
import edu.csci448.beatboxcompose.data.Sound
import org.junit.Before
import org.junit.Test


internal class BeatBoxScreenKtTest {

    @Before
    @Composable
    fun setUp() {
        val sounds = mutableListOf<Sound>()
        for(i in 0..36)
            sounds.add( Sound("${i}_test") )

        BeatBoxScreen(
            sounds = sounds,
            onPlaySound = { }
        )
    }

    @Test
    fun buttonHasSoundNameAsLabel(
        Finder: onNode
    ) {

    }
}