package com.ynovlyon.ymenu

sealed class BottomNavItems(
    val route: String,
    val name: String,
    val icon: Int
) {
    object View1 : BottomNavItems("contacts", "Contacts", android.R.drawable.ic_menu_save)
    object View2 : BottomNavItems("recent", "Recent", android.R.drawable.ic_menu_save)
    object View3 : BottomNavItems("account", "Favorites", android.R.drawable.ic_menu_save)
}

val navItems = listOf(
    BottomNavItems.View1,
    BottomNavItems.View2,
    BottomNavItems.View3
)