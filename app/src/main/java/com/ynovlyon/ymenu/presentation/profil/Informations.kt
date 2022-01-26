package com.ynovlyon.ymenu.presentation.profil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ynovlyon.ymenu.R

@Preview(showBackground = true)
@Composable
fun InformationsPage() {
    val imageLogo = painterResource(id = R.drawable.p)



    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White), contentAlignment = Alignment.TopCenter

        )
        {
            Image(painter = imageLogo, contentDescription = "",modifier = Modifier.clip(CircleShape))

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.68f)
                .padding(18.dp)
        ) {
            Text(
                text = "Mes informations",
                fontSize = 25.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Civilité", modifier = Modifier.fillMaxWidth(8.8f))
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_account),
                            contentDescription = "",

                        )
                    },
                    placeholder = { Text(text = "Madame") },
                    modifier = Modifier.fillMaxWidth(8.8f)
                )

                Spacer(modifier = Modifier.padding(15.dp))
                Text(text = "Nom utilisateur", modifier = Modifier.fillMaxWidth(8.8f))
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_account),
                            contentDescription = ""
                        )
                    },
                    placeholder = { Text(text = "Manahel Bouchkara") },
                    modifier = Modifier.fillMaxWidth(8.8f)
                )


                Spacer(modifier = Modifier.padding(15.dp))
                Text(text = "Prénom", modifier = Modifier.fillMaxWidth(8.8f))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(8.8f),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_account),
                            contentDescription = ""
                        )
                    },
                    placeholder = { Text(text = "Manahel") }
                )


                Spacer(modifier = Modifier.padding(15.dp))
                Text(text = "Nom", modifier = Modifier.fillMaxWidth(8.8f))
                OutlinedTextField(
                    value = "",
                    onValueChange = {  },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_account),
                            contentDescription = ""
                        )
                    },
                    placeholder = { Text(text = "Bouchkara") },
                    modifier = Modifier.fillMaxWidth(8.8f)
                )

                Spacer(modifier = Modifier.padding(15.dp))
                Text(text = "Adresse Mail", modifier = Modifier.fillMaxWidth(8.8f))
                OutlinedTextField(
                    value = "",
                    onValueChange = {  },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_fleche),
                            contentDescription = ""
                        )
                    },
                    placeholder = { Text(text = "mana.bouch@gmail.com") },
                    modifier = Modifier.fillMaxWidth(8.8f)
                )


            }
        }
    }
}
