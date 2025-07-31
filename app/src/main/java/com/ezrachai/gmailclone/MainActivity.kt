package com.ezrachai.gmailclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.ezrachai.gmailclone.components.GmailDrawerMenu
import com.ezrachai.gmailclone.components.HomeAppBar
import com.ezrachai.gmailclone.components.HomeBottomBar
import com.ezrachai.gmailclone.ui.theme.GmailCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GmailCloneTheme {
                GmailApp(Modifier)
            }
        }
    }
}

@Composable
fun GmailApp(modifier: Modifier) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    ModalNavigationDrawer(
        drawerState = drawerState,

        drawerContent = {
            ModalDrawerSheet {
                GmailDrawerMenu(scrollState)
            }
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { HomeBottomBar() },
            topBar = { HomeAppBar(drawerState, coroutineScope) },
            contentWindowInsets = WindowInsets.safeContent
        ) { innerPadding ->

            LazyColumn(Modifier.padding(innerPadding)) {
                items(50) { index: Int ->
                    Text("Hello $index")
                }

            }
        }
    }

}