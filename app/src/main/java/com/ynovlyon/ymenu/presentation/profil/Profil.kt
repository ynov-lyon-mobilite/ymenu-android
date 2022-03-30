package com.ynovlyon.ymenu.presentation.profil

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ynovlyon.ymenu.R


@Preview(showBackground = true)
@Composable
fun ProfilPage() {

    val imageLogo = painterResource(id = R.drawable.p)
    val scrollState = rememberScrollState()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White), contentAlignment = Alignment.TopCenter

        ){
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp))
            {
                Image(painter = painterResource(id = R.drawable.p), contentDescription = "",
                    modifier = Modifier.size(80.dp) . clip ( CircleShape ),
                )

            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp))
            {
                Text("Manahel Bouchkara")
                Text("+33 6 51 89 71 50")
            }
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.68f)
                .verticalScroll(scrollState)
        ) {


            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(8.8f)
                    .height(58.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFAF4FA),
                    contentColor = Color(0xFF0A0A0A)

                ) )
                {

                Icon(painter = painterResource(id = R.drawable.informations),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    tint = Color(color =0xFF0A0A0A )

                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "Mes informations")
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Icon(painter = painterResource(id = R.drawable.fleche_droite), contentDescription = "")
            }


            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(8.8f)
                    .height(58.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFAF4FA),
                    contentColor = Color(0xFF0A0A0A)

                ) )
            {

                Icon(painter = painterResource(id = R.drawable.historic),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    tint = Color(color =0xFF0A0A0A )

                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "Historique des visites")
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Icon(painter = painterResource(id = R.drawable.fleche_droite), contentDescription = "")
            }


            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(8.8f)
                    .height(58.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFAF4FA),
                    contentColor = Color(0xFF0A0A0A)

                ) )
            {

                Icon(painter = painterResource(id = R.drawable.chat_bubble),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    tint = Color(color =0xFF0A0A0A )

                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "Donner son avis")
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Icon(painter = painterResource(id = R.drawable.fleche_droite), contentDescription = "")
            }


            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(8.8f)
                    .height(58.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFAF4FA),
                    contentColor = Color(0xFF0A0A0A)

                ) )
            {

                Icon(painter = painterResource(id = R.drawable.info),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    tint = Color(color =0xFF0A0A0A )

                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "Informations légales")
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Icon(painter = painterResource(id = R.drawable.fleche_droite), contentDescription = "")
            }

            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(8.8f)
                    .height(58.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFAF4FA),
                    contentColor = Color(0xFF0A0A0A)

                ) )
            {

                Icon(painter = painterResource(id = R.drawable.language),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    tint = Color(color =0xFF0A0A0A )

                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "Language")
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Icon(painter = painterResource(id = R.drawable.fleche_droite), contentDescription = "")
            }

            Spacer(modifier = Modifier.padding(25.dp))
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
                Text(text = "Déconnexion")
                Spacer(modifier = Modifier.padding(2.dp))

            }












           }






    }


    }
