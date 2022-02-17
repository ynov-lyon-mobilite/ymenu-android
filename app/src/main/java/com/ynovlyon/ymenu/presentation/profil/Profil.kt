package com.ynovlyon.ymenu.presentation.profil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ynovlyon.ymenu.R

@Preview(showBackground = true)
@Composable
fun ProfilPage() {

    val imageLogo = painterResource(id = R.drawable.p)
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
        val annotatedString = buildAnnotatedString {
            appendInlineContent(id = "imageId")
            append(" Manahel Bouchkara")

        }
        val inlineContentMap = mapOf(
            "imageId" to InlineTextContent(
                Placeholder(30.sp, 30.sp, PlaceholderVerticalAlign.TextCenter)
            ) {
                Image(
                    painter = imageLogo,
                    contentDescription = "",
                    modifier = Modifier.clip(CircleShape)
                )
            }
        )

        Text(annotatedString, inlineContent = inlineContentMap)

    }


    }

