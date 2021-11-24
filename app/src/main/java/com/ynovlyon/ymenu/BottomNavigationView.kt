package com.ynovlyon.ymenu

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

@ExperimentalFoundationApi
@Composable
fun BottomNavigationView() {

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                { SearchBar() },
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp
            )
        }, bottomBar = { BottomNavigationBar(navController) }
    ) {
        NavigationHost(navController)
    }
}

@Composable
fun SearchBar() {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 4.dp, end = 16.dp)
            .height(56.dp)
            .background(
                color = MaterialTheme.colors.surface,
                RoundedCornerShape(8.dp)
            )
    ) {

        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Icon",
            tint = Color.Gray,
            modifier = Modifier.padding(start = 4.dp).weight(1.5f)
        )

        Text(
            text = "Search contacts",
            color = Color.Gray,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.weight(7f).padding(start = 16.dp)
        )

        Icon(
            painterResource(id = android.R.drawable.ic_menu_save),
            contentDescription = "Search with speech",
            tint = Color.Gray,
            modifier = Modifier.size(24.dp).weight(1.5f)
        )
    }
}