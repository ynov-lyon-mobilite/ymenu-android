package com.ynovlyon.ymenu.presentation.onboarding

import com.ynovlyon.ymenu.R

data class SampleOnBoard(
    val image: Int,
    val title: String,
    val desc: String
)

val onBoardItem = listOf(
    SampleOnBoard(
        R.mipmap.ic_launcher_foreground,
        "Bienvenue dans Y'Menu",
        "A travers cette application vous pourrez découvrir les différents menus proposés en réalité augmentée. Voyez votre plat sur votre table"


    ),
    SampleOnBoard(
        R.mipmap.ic_launcher_foreground,
        "Comment ça marche ?",
        "Ouvrez votre caméra grâce à la fonctionnalité QR Code disponible sur l'écran d'accueil, scannez le QR Code et c'est prêt !"
    ),
    SampleOnBoard(
        R.mipmap.ic_launcher_foreground,
        "Bon appétit !",
        "Si vous avez bien comrpis le fonctionnement, il ne vous reste plus qu'a essayer !"
    )
)