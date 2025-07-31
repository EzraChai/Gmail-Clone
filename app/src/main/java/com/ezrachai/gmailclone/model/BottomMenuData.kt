package com.ezrachai.gmailclone.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData(
    val icon: ImageVector,
    val title: String,
) {
    object Mail : BottomMenuData(
        icon = Icons.Outlined.Mail, title = "Mails"
    )

    object Meet : BottomMenuData(
        icon = Icons.Outlined.Videocam, title = "Meet"
    )
}