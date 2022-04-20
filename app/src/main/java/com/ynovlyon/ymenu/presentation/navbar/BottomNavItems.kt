package com.ynovlyon.ymenu.presentation.navbar

import com.ynovlyon.ymenu.R

sealed class BottomNavItems(
    val route: String,
    val name: String,
    val icon: Int
) {
    object Menu : BottomNavItems("menu/{id}", "-", R.drawable.ic_menu_restau)
    object QrCode : BottomNavItems("qrCode", "-", R.drawable.ic_qrcode)
    object Account : BottomNavItems("account", "-", R.drawable.ic_account)
}

val navItems = listOf(
    BottomNavItems.Menu,
    BottomNavItems.QrCode,
    BottomNavItems.Account
)