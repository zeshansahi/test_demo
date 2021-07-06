package dev.zeshan.demoapp.utils

import android.os.Bundle
import androidx.navigation.NavAction
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import dev.zeshan.demoapp.R

class Navigator {

    private val TAG = "Navigator"

    companion object {
        fun getCurrentDestinationId(): Int? {

            return AppDataConfig.getInstance()?.navigationManager?.getNavController()?.currentDestination?.id
        }

        fun navigateToDetail(args: Bundle?) {
            val navAction = NavAction(R.id.FragMovieDetail)
            val navOptions = NavOptions.Builder()
                    .setLaunchSingleTop(true)
                    .build()
            navAction.navOptions = navOptions
            val destination: NavDestination? = AppDataConfig.getInstance()?.navigationManager
                    ?.getNavController()
                    ?.getGraph()
                    ?.findNode(getCurrentDestinationId()!!)
            if (destination != null) {
                destination.putAction(R.id.action_FragMovieDetail, navAction)
                AppDataConfig.getInstance()?.navigationManager?.getNavController()?.navigate(R.id.action_FragMovieDetail, args)
            }
        }
    }
}

