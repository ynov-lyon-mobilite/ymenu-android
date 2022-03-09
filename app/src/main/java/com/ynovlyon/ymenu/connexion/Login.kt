package com.ynovlyon.ymenu.connexion


import android.content.Intent
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.ynovlyon.ymenu.R


@Preview(showBackground = true)
@Composable
fun LoginPage(){




    val image = painterResource(id = R.drawable.logo1)
    val description = "logo"
    val adresseMailValue = remember { mutableStateOf("")}
    val passWordValue = remember { mutableStateOf("")}




    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){

        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White),contentAlignment = Alignment.TopCenter)
        {
            Image(painter = image, contentDescription =  description)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.68f)
                // .clip(RoundedCornerShape(topLeft = 38.dp, topRight = 38.dp))
                .padding(18.dp)
        ){

            Spacer(modifier = Modifier.padding(1.dp))
            Text(text = "Adresse mail", modifier = Modifier.fillMaxWidth(8.8f))
            OutlinedTextField(
                value = adresseMailValue.value,
                onValueChange = { adresseMailValue.value = it },
                leadingIcon = { Icon(painter = painterResource(id = R.drawable.mail), contentDescription = "") },
                placeholder = { Text(text = "louis@gmail.com")},
                modifier = Modifier.fillMaxWidth(8.8f)
            )

                Spacer(modifier = Modifier.padding(15.dp))
                Text(text = "Mot de passe",modifier = Modifier.fillMaxWidth(8.8f))
                OutlinedTextField(value = passWordValue.value, 
                    onValueChange = { passWordValue.value  = it},
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.cadenas), contentDescription = "") },
                    placeholder = { Text(text = "Ton mot de passe")},
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(8.8f)
                )


                Spacer(modifier = Modifier.padding(2.dp))
                Text(text = "Mot de passe oublié?",
                    modifier = Modifier
                        .fillMaxWidth(8.8f)
                        .clickable(onClick = {}
                        )
                )

                
                Spacer(modifier = Modifier.padding(18.dp))
                Button(onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(8.8f)
                        .height(58.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFFFDAF5E),
                        contentColor = Color(0xFFFAF4FA)

                    )
                ) {
                    Text(text = "Se connecter")
                    Spacer(modifier = Modifier.padding(2.dp))
                    Icon(painter = painterResource(id = R.drawable.fleche), contentDescription = "")
                }

               // val monIntent = Intent(this, RegisterPage());
                Spacer(modifier = Modifier.padding(28.dp))
                Text(text = "Pas de compte?")
                Text(
                    text = "S'inscrire",
                    color = Color(0xFFFDAF5E),
                    modifier = Modifier.clickable(onClick = {

                       // startActivity(Intent(this, RegisterPage()));
                    }),
                )
                Spacer(modifier = Modifier.padding(28.dp))

            }
        }

    }

    





