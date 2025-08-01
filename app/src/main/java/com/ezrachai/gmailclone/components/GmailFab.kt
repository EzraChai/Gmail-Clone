package com.ezrachai.gmailclone.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember


@Composable
fun GmailFab(lazyListState: LazyListState) {
    val isCollapsed by remember {
        derivedStateOf {
            lazyListState.firstVisibleItemIndex > 0 ||
                    lazyListState.firstVisibleItemScrollOffset > 100
        }
    }

    if (!isCollapsed) {
        ExtendedFloatingActionButton(
            text = {
                Text(text = "Compose")
            },
            icon = {
                Icon(Icons.Filled.Edit, "Extended floating action button.")
            },
            onClick = {})
    } else {
        FloatingActionButton(onClick = { }) {
            Icon(imageVector = Icons.Filled.Edit, contentDescription = "Compose")
        }
    }
}