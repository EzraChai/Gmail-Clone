package com.ezrachai.gmailclone.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ezrachai.gmailclone.model.BottomMenuData

@Composable
fun HomeBottomBar() {
    val items = listOf(
        BottomMenuData.Mail,
        BottomMenuData.Meet
    )

    NavigationBar(modifier = Modifier.height(80.dp)) {
        items.forEach {
            NavigationBarItem(selected = false, onClick = {}, icon = {
                Icon(imageVector = it.icon, contentDescription = it.title)
            })
        }

    }
}