package com.example.bnb.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.musicapp.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bnb.Chatbot.ChatPage
import com.example.bnb.ChefView
import com.example.bnb.Event
import com.example.bnb.EventDetailScreen
import com.example.bnb.EventView
import com.example.bnb.FeedBackView
import com.example.bnb.HomeView
import com.example.bnb.MenuView
import com.example.bnb.R
import com.example.bnb.Screen
import com.example.bnb.chefList
import com.example.bnb.menulist
import com.example.bnb.screenInBottom
import com.example.bnb.screenInDrawer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {


    val viewModel : MainViewModel = viewModel()
    val currentScreen = remember {
        viewModel.currentState.value
    }
    val title = remember{

        mutableStateOf(currentScreen.title) }

    val controller : NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomBar: @Composable () -> Unit = {
        if(currentScreen == Screen.BottomScreen.Booking){
            NavigationBar(
                containerColor = orange11,
                modifier = Modifier.clip(RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp))

            ) {
                screenInBottom.forEach{ item ->
                    NavigationBarItem(selected = currentRoute == item.bRoute,
                        onClick = {
                            controller.navigate(item.bRoute)

                        },
                        icon = {
                           Icon(painterResource(id = item.icon),contentDescription = item.bTitle)
                        },
                        label = {
                            Text(text = item.bTitle)
                        },
                    )

                }
            }
        }
    }


    val scope : CoroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(

        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = orange6
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(modifier = Modifier
                        .padding(16.dp)){
                        items(screenInDrawer){
                                item->
                            DrawerItem(selected = currentRoute == item.dRoute, item = item) {
                                scope.launch {
                                    drawerState.close()
                                }
                                if(item.dRoute == "add_account"){
                                    //open Dialog
                                }
                                else{
                                    controller.navigate(item.dRoute)
                                    title.value = item.dTitle
                                }
                            }

                        }
                    }
                }
            }


        },
        drawerState = drawerState

    ) {

        Scaffold(
            bottomBar = bottomBar,
            topBar = {
                TopAppBar(modifier = Modifier.clip(RoundedCornerShape(bottomStart = 5.dp, bottomEnd = 5.dp)),
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = orange11
                    ),
                    title = { Text(text = "Ettarra",color = Color.White)},
                    navigationIcon = {
                        IconButton(onClick =
                        {
                            /*TODO Open Drawer*/
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }



                ) }
        ) {
            Navigation(navController = controller, viewModel = viewModel, pd = it)
        }

    }

}

@Composable
fun DrawerItem(
    selected : Boolean,
    item : Screen.DrawerScreen,
    onDrawerItemClicked : () -> Unit
){
    val background = if(selected) Purple80 else Color.White

    Row(modifier = Modifier
//            fillMaxWidth()
//            .background(background)
        .padding(horizontal = 8.dp, vertical = 16.dp)
        .clickable {
            onDrawerItemClicked()
        })
    {

        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.dTitle,
            modifier = Modifier.padding(end = 8.dp, top = 4.dp)
        )

        Text(
            text = item.dTitle,
            style = MaterialTheme.typography.bodyMedium,
            color = if (selected) Color.DarkGray else Color.Black
        )
    }

}

@Composable
fun Navigation(navController: NavController,viewModel: MainViewModel,pd: PaddingValues) {

    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.BottomScreen.Home.bRoute,
        modifier = Modifier.padding(pd)
    ) {

        composable(Screen.BottomScreen.Chat.bRoute) {
            ChatPage(viewModel = MainViewModel())
        }

        composable(Screen.BottomScreen.Event.bRoute) {
            EventView(navController = navController)
        }
        composable(Screen.BottomScreen.Chef.bRoute) {
            ChefView(chefs = chefList)
        }
        composable(Screen.BottomScreen.Menu.bRoute) {
            MenuView(menuitems = menulist)
        }

        composable(
            Screen.EventDetail.route + "/{title}/{painter}/{date}/{time}"
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val painterString =
                backStackEntry.arguments?.getString("painter") ?: R.drawable.halloween.toString()
            val painter = painterString.toIntOrNull()
                ?: R.drawable.halloween // Convert to Int or use default image
            val date = backStackEntry.arguments?.getString("date") ?: ""
            val time = backStackEntry.arguments?.getString("time") ?: ""

            EventDetailScreen(
                event = Event(painter, title, date, time), viewModel
            )

        }

        composable(
            Screen.BottomScreen.Review.bRoute
        ){
            FeedBackView()
        }

        composable(
            Screen.BottomScreen.Home.bRoute
        ){
            HomeView(navController = navController)
        }

    }
}