package com.ynovlyon.ymenu.presentation.dish_list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ynovlyon.ymenu.ApiInterface
import com.ynovlyon.ymenu.data.model.DishModel
import kotlinx.coroutines.launch

class DishListViewModel : ViewModel() {
    private val _dishList = mutableStateListOf<DishModel>()
    val dishList: List<DishModel>
        get() = _dishList

    fun getDishList(id: String) {
        viewModelScope.launch {
            val apiService = ApiInterface.create()
            try {
                _dishList.clear()
                _dishList.addAll(apiService.getDishesListById(id))
            } catch (e: Exception) {
                Log.d("error", e.message.toString())
            }
        }
    }
}