package com.ezrachai.gmailclone.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.automirrored.outlined.InsertDriveFile
import androidx.compose.material.icons.automirrored.outlined.ScheduleSend
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AllInbox
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Inbox
import androidx.compose.material.icons.outlined.Outbox
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.Tag
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenuData(
    val icon: ImageVector? = null,
    val title: String? = null,
    val isDivider: Boolean = false,
    val isHeader: Boolean = false,
) {
    object Allinboxes : DrawerMenuData(
        icon = Icons.Outlined.AllInbox,
        title = "All inboxes"
    )

    object Primary : DrawerMenuData(
        icon = Icons.Outlined.Inbox,
        title = "Primary"
    )

    object Promotions : DrawerMenuData(
        icon = Icons.Outlined.Tag,
        title = "Promotions"
    )

    object Social : DrawerMenuData(
        icon = Icons.Outlined.Person,
        title = "Social"
    )

    object Starred : DrawerMenuData(
        icon = Icons.Outlined.Star,
        title = "Starred"
    )

    object Snoozed : DrawerMenuData(
        icon = Icons.Outlined.AccessTime,
        title = "Snoozed"
    )

    object Sent : DrawerMenuData(
        icon = Icons.AutoMirrored.Outlined.Send,
        title = "Sent"
    )

    object Scheduled : DrawerMenuData(
        icon = Icons.AutoMirrored.Outlined.ScheduleSend,
        title = "Scheduled"
    )

    object Outbox : DrawerMenuData(
        icon = Icons.Outlined.Outbox,
        title = "Outbox"
    )

    object Draft : DrawerMenuData(
        icon = Icons.AutoMirrored.Outlined.InsertDriveFile,
        title = "Draft"
    )

    object Bin : DrawerMenuData(
        icon = Icons.Outlined.Delete,
        title = "Bin"
    )

    object Settings : DrawerMenuData(
        icon = Icons.Outlined.Settings,
        title = "Settings"
    )

    object HelpAndFeedback : DrawerMenuData(
        icon = Icons.AutoMirrored.Outlined.Help,
        title = "Help and Feedback"
    )

    object Divider : DrawerMenuData(
        isDivider = true
    )

    object AllLabels : DrawerMenuData(
        isHeader = true,
        title = "All labels"
    )

    object GoogleApps : DrawerMenuData(
        isHeader = true,
        title = "Google Apps"
    )

    object Calendar : DrawerMenuData(
        icon = Icons.Outlined.CalendarToday,
        title = "Calendar"
    )

    object Contacts : DrawerMenuData(
        icon = Icons.Outlined.AccountCircle,
        title = "Contacts"
    )


}