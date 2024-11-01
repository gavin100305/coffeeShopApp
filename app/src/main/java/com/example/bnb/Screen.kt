package com.example.bnb


import androidx.annotation.DrawableRes

sealed class Screen(
    val title : String,
    val route :String
) {
    object EventDetail : Screen(
        "event_detail",
        "event_detail"
    )

    sealed class DrawerScreen(val dTitle: String,
                              val dRoute: String,
                              @DrawableRes val icon:Int) : Screen(dTitle,dRoute) {

        object Chef : DrawerScreen(
            "Chef",
            "chef",
            R.drawable.baseline_restaurant_24,
        )
        object Menu : DrawerScreen(
            "Menu",
            "menu",
            R.drawable.baseline_menu_book_24,
        )
    }


        sealed class BottomScreen(val bTitle: String,
                                  val bRoute: String,
                                  @DrawableRes val icon:Int) : Screen(bTitle,bRoute){
            object Booking : BottomScreen(
                "Booking",
                "booking",
                R.drawable.baseline_home_24,
            )
            object Event : BottomScreen(
                "Event",
                "event",
                R.drawable.baseline_event_seat_24,
            )
            object Chef : BottomScreen(
                "Chef",
                "chef",
                R.drawable.baseline_restaurant_24,
            )
            object Menu : BottomScreen(
                "Menu",
                "menu",
                R.drawable.baseline_menu_book_24,
            )

            object Chat : BottomScreen(
                "Chat",
                "chat",
                R.drawable.baseline_coffee_24
            )

            object Review : BottomScreen(
                "Review",
                "review",
                R.drawable.baseline_rate_review_24
                )
            object Home : BottomScreen(
                "Home",
                "home",
                R.drawable.baseline_home_24
            )



        }

    }
val screenInBottom = listOf(
    Screen.BottomScreen.Home,
    Screen.BottomScreen.Chat,
    Screen.BottomScreen.Event,
    Screen.BottomScreen.Review
)

val screenInDrawer = listOf(
    Screen.DrawerScreen.Menu,
    Screen.DrawerScreen.Chef,
)
