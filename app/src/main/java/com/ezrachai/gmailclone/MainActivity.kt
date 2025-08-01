package com.ezrachai.gmailclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.ezrachai.gmailclone.components.GmailDrawerMenu
import com.ezrachai.gmailclone.components.GmailFab
import com.ezrachai.gmailclone.components.HomeAppBar
import com.ezrachai.gmailclone.components.HomeBottomBar
import com.ezrachai.gmailclone.components.MailList
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
    val listState = rememberLazyListState()


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
            floatingActionButton = { GmailFab(listState) },
            topBar = { HomeAppBar(drawerState, coroutineScope) },
        ) {

            MailList(it, listState)
        }
    }

}