package com.ynovlyon.ymenu.presentation.onboarding

import com.ynovlyon.ymenu.R

data class SampleOnBoard(
    val image: Int,
    val title: String,
    val desc: String
)

val onBoardItem = listOf(
    SampleOnBoard(
        R.drawable.logo,
        "Bienvenue dans Y'Menu",
        "A travers cette application vous pourrez découvrir les différents menus proposés en réalité augmentée. Voyez votre plat sur votre table"


    ),
    SampleOnBoard(
        R.drawable.logo,
        "Comment ça marche ?",
        "Ouvrez votre caméra grâce à la fonctionnalité QR Code disponible sur l'écran d'accueil, scannez le QR Code et c'est prêt !"
    ),
    SampleOnBoard(
        R.drawable.logo,
        "Bon appétit !",
        "Si vous avez bien comrpis le fonctionnement, il ne vous reste plus qu'a essayer !"
    )
)