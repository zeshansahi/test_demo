package dev.zeshan.demoapp.utils

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDirections

class NavigationManager(navController: NavController) {
    private var navController: NavController? = navController

    fun NavigationManager(navController: NavController?) {
        this.navController = navController
    }

    fun navigateNext(resId: Int) {
        try {
            navController!!.navigate(resId)
        } catch (ex: Exception) {
            // TODO : ignore
        }
    }

    fun navigateNext(directions: NavDirections?) {
        try {
            navController!!.navigate(directions!!)
        } catch (ex: Exception) {
            // TODO : ignore
        }
    }

    fun navigateNextWithData(resId: Int, data: Bundle?) {
        try {
            navController!!.navigate(resId, data)
        } catch (ex: Exception) {
            // TODO : ignore
        }
    }

    fun navigateUp(): Boolean {
        return navController!!.navigateUp()
    }

    fun getNavController(): NavController? {
        return navController
    }
}