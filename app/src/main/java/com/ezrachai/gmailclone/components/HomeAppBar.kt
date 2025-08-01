package com.ezrachai.gmailclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezrachai.gmailclone.GmailApp
import com.ezrachai.gmailclone.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeAppBar(drawerState: DrawerState, scope: CoroutineScope, openDialog: MutableState<Boolean>) {
    Box(modifier = Modifier.padding(top = 32.dp, start = 10.dp, end = 10.dp)) {
        Card(
            modifier = Modifier.requiredHeight(50.dp),
            shape = CircleShape,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                IconButton(
                    onClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                ) {
                    Icon(Icons.Default.Menu, "Menu")
                }
                Text(
                    "Search in emails", modifier = Modifier
                        .weight(2.0f)
                        .padding(start = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.elon_musk_royal_society),
                    contentDescription = "Profile",

                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(color = Color.DarkGray)
                        .clickable {
                            openDialog.value = true
                        }
                )
                if (openDialog.value) {
                    AccountsDialog(openDialog)
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    GmailApp()
}