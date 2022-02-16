package com.ynovlyon.ymenu.connexion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ynovlyon.ymenu.R

@Preview(showBackground = true)
@Composable
fun RegisterPage() {

    val imageLogo = painterResource(id = R.drawable.logo1)
    val description = "logo"




    val nomValue = remember { mutableStateOf("") }
    val adresseMailValue = remember { mutableStateOf("") }
    val passWordValue = remember { mutableStateOf("") }
    val confirmPWValue = remember { mutableStateOf("") }



    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Spacer(modifier = Modifier.padding(3.dp))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White), contentAlignment = Alignment.TopCenter
        )
        {
            Image(painter = imageLogo, contentDescription = description)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.68f)
                .padding(18.dp)
        ) {

            Spacer(modifier = Modifier.padding(1.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Nom utilisateur", modifier = Modifier.fillMaxWidth(8.8f))
                OutlinedTextField(
                    value = nomValue.value,
                    onValueChange = { nomValue.value = it },
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.ic_account), contentDescription = "") },
                    placeholder = { Text(text = "Ton nom d'utilisateur")},
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(8.8f)
                )

                Spacer(modifier = Modifier.padding(15.dp))
                Text(text = "Adresse mail", modifier = Modifier.fillMaxWidth(8.8f))
                OutlinedTextField(
                    value = adresseMailValue.value,
                    onValueChange = { adresseMailValue.value = it },
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.mail), contentDescription = "") },
                    placeholder = { Text(text = "louis@gmail.com")},
                    modifier = Modifier.fillMaxWidth(8.8f)
                )

            // gerer page oubli de mot de passe
                Spacer(modifier = Modifier.padding(15.dp))
                Text(text = "Mot de passe", modifier = Modifier.fillMaxWidth(8.8f))
                OutlinedTextField(
                    value = passWordValue.value,
                    onValueChange = { passWordValue.value = it },
                    modifier = Modifier.fillMaxWidth(8.8f),
                    visualTransformation = PasswordVisualTransformation(),
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.cadenas), contentDescription = "") },
                    placeholder = { Text(text = "Ton mot de passe")}
                )


                Spacer(modifier = Modifier.padding(15.dp))
                Text(text = "Confirmer votre mot de passe", modifier = Modifier.fillMaxWidth(8.8f))
                OutlinedTextField(
                    value = confirmPWValue.value,
                    onValueChange = { confirmPWValue.value = it },
                    visualTransformation = PasswordVisualTransformation(),
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.cadenas), contentDescription = "")},
                    placeholder = { Text(text = "Confirmer votre mot de passe")},
                    modifier = Modifier.fillMaxWidth(8.8f)
                )



                Spacer(modifier = Modifier.padding(12.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(8.8f)
                        .height(58.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFFFDAF5E),
                        contentColor = Color(0xFFFAF4FA)

                    )
                ) {
                    Text(text = "S'inscrire")
                    Spacer(modifier = Modifier.padding(2.dp))
                    Icon(painter = painterResource(id =R.drawable.fleche ), contentDescription = "")
                }


                Spacer(modifier = Modifier.padding(13.dp))
                Text(text = "Vous avez déjà un  compte?")
                Text(
                    text = "Connectez vous",
                    color = Color(0xFFFDAF5E),
                    modifier = Modifier.clickable(onClick = {}),

                    )
                Spacer(modifier = Modifier.padding(28.dp))

            }
        }

    }
}