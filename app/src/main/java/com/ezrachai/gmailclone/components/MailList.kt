package com.ezrachai.gmailclone.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ezrachai.gmailclone.emailList
import com.ezrachai.gmailclone.model.MailData


@Composable
fun MailList(paddingValues: PaddingValues, lazyListState: LazyListState) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .padding(top = 16.dp)
    ) {
        LazyColumn(
            state = lazyListState,
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(emailList) { mailData ->
                MailItem(mailData = mailData)
            }
        }
    }
}


@Composable
fun MailItem(mailData: MailData, modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(end = 8.dp)
                .size(40.dp)
                .clip(CircleShape)
                .background(color = Color.Gray),
        ) {
            Text(
                text = mailData.userName[0].toString(),
            )
        }
        Column(modifier.weight(2.0f)) {
            Text(text = mailData.userName, fontWeight = FontWeight.Medium, fontSize = 16.sp)
            Text(text = mailData.subject, fontWeight = FontWeight.Medium)
            Text(
                text = mailData.body,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                maxLines = 1
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = mailData.timeStamp,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
            IconButton(
                onClick = {}, modifier = modifier
                    .size(32.dp)
                    .padding(top = 8.dp)
            ) {

                Icon(imageVector = Icons.Outlined.StarOutline, contentDescription = "")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMail() {
    MailItem(
        mailData = MailData(
            mailId = 4,
            userName = "John Doe",
            body = "Nice to meet you. See you again next week", subject = "Hi",
            timeStamp = "20:11"
        )
    )
}