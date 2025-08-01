package com.ezrachai.gmailclone.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.PersonAddAlt
import androidx.compose.material.icons.outlined.PersonSearch
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ezrachai.gmailclone.R
import com.ezrachai.gmailclone.personalEmail

@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = {
        openDialog.value = false
    }) {
        AccountDialogUI(modifier = Modifier, openDialog)
    }
}

@Composable
fun AccountDialogUI(modifier: Modifier = Modifier, openDialog: MutableState<Boolean>) {

    Card {
        Column {
            Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {
                    openDialog.value = false
                }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "close")
                }
            }
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.elon_musk_royal_society),
                    contentDescription = "Profile",

                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(color = Color.DarkGray)
                )
                Column(
                    modifier
                        .weight(2.0f)
                        .padding(start = 16.dp)
                ) {

                    Text("Ezra Chai", fontWeight = FontWeight.SemiBold)
                    Text("elonmusk@x.com", fontWeight = FontWeight.SemiBold)
                }
                Text("99+")
            }
            Row(
                modifier
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier.requiredWidth(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = Color.Gray)
                ) {
                    Box(modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text("Google Account", modifier.padding(8.dp))
                    }
                }
            }
            HorizontalDivider(modifier.padding(top = 16.dp))
            personalEmail.forEach { it ->
                Row(
                    modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Box(

                        modifier
                            .padding()
                            .width(30.dp)
                            .height(30.dp)
                            .clip(CircleShape)
                            .background(Color.Gray),

                        contentAlignment = Alignment.Center
                    ) {
                        Text(it.userName[0].toString())
                    }
                    Column(
                        modifier
                            .weight(2.0f)
                            .padding(start = 16.dp)
                    ) {
                        Text(it.userName, fontWeight = FontWeight.SemiBold)
                        Text(it.email, fontWeight = FontWeight.SemiBold)
                    }
                    if (it.notificationCount > 99) {
                        Text("99+")
                    } else {
                        Text(it.notificationCount.toString())
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Icon(
                    Icons.Outlined.PersonAddAlt,
                    contentDescription = "Add new Email",
                    modifier = modifier.width(30.dp)
                )
                Text(
                    "Add Another Account",
                    fontWeight = FontWeight.SemiBold,
                    modifier = modifier.padding(start = 16.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Icon(
                    Icons.Outlined.PersonSearch,
                    contentDescription = "Add new Email",
                    modifier = modifier.width(30.dp)
                )
                Text(
                    "Manage Account On This Device",
                    fontWeight = FontWeight.SemiBold,
                    modifier = modifier.padding(start = 16.dp)
                )
            }
            HorizontalDivider(modifier.padding(top = 16.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(onClick = {}) {
                    Text("Privacy Policy")
                }

                Text("⋅", fontWeight = FontWeight.Bold)
                TextButton(onClick = {}) {
                    Text("Terms of Service")
                }
            }
        }
    }
}