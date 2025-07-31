package com.ezrachai.gmailclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ezrachai.gmailclone.model.DrawerMenuData

@Composable
fun GmailDrawerMenu(scrollState: ScrollState) {

    val menuList = listOf(
        DrawerMenuData.Divider,
        DrawerMenuData.Allinboxes,
        DrawerMenuData.Divider,
        DrawerMenuData.Primary,
        DrawerMenuData.Promotions,
        DrawerMenuData.Social,

        DrawerMenuData.AllLabels,
        DrawerMenuData.Starred,
        DrawerMenuData.Snoozed,
        DrawerMenuData.Sent,
        DrawerMenuData.Scheduled,
        DrawerMenuData.Outbox,
        DrawerMenuData.Draft,
        DrawerMenuData.Bin,

        DrawerMenuData.GoogleApps,
        DrawerMenuData.Calendar,
        DrawerMenuData.Contacts,
        DrawerMenuData.Divider,

        DrawerMenuData.Settings,
        DrawerMenuData.HelpAndFeedback,
    )

    Column(Modifier.verticalScroll(scrollState)) {
        Text(
            "Gmail",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 6.dp, top = 16.dp, start = 16.dp)
        )
        menuList.forEach { item ->
            when {
                item.isDivider -> {
                    HorizontalDivider(modifier = Modifier.padding(top = 10.dp))
                }

                item.isHeader -> {
                    Text(
                        text = item.title!!,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 20.dp, bottom = 14.dp, start = 30.dp)
                    )
                }

                else -> {
                    MailDrawerItem(item)

                }
            }
        }
    }
}

@Composable
fun MailDrawerItem(item: DrawerMenuData) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(top = 16.dp)
    ) {
        Image(
            imageVector = item.icon!!,
            contentDescription = item.title,
            modifier = Modifier.weight(0.5f)
        )
        Text(
            text = item.title!!,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(2.0f)
        )
    }
}