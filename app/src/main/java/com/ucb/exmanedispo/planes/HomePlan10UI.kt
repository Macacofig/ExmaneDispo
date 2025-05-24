package com.ucb.exmanedispo.planes

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ucb.exmanedispo.R

@Composable
fun HomePlan10UI(onDereClick: () -> Unit, onIzqClick: () -> Unit, onMapaClick: () -> Unit)
{
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Nuestros planes móviles",
            fontSize = 24.sp, // aumentado de 24.sp a 32.sp
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFFB561FF),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp)) // un poco más de espacio

        Text(
            text = "La mejor cobertura, increíbles beneficios y un\ncompromiso con el planeta.",
            fontSize = 15.sp, // aumentado de 16.sp a 20.sp
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                //.weight(1f)  // quitamos para que no tome todo el espacio vertical
                .padding(bottom = 40.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
                .background(Color.White, RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp), // para dar un poco de padding vertical
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = onIzqClick,
                    modifier = Modifier.size(40.dp) // iconos un poco más grandes
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Izquierda",
                        tint = Color(0xFFB561FF),
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Plan FLEX 10",
                        fontSize = 30.sp, // de 30.sp a 36.sp
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFB561FF),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = buildAnnotatedString {
                            append("Antes ")
                            withStyle(SpanStyle(textDecoration = TextDecoration.LineThrough, color = Color.Gray)) {
                                append("$470")
                            }
                            append(" /mes")
                        },
                        fontSize = 18.sp // de 16.sp a 18.sp
                    )

                    Text(
                        text = "$399 /mes",
                        fontSize = 28.sp, // de 24.sp a 28.sp
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "10GB",
                        fontSize = 24.sp, // de 20.sp a 24.sp
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    val beneficios = listOf(
                        "Llamadas y SMS ilimitados",
                        "Hotspot. Comparte tus datos",
                        "Redes Sociales ilimitadas incluidas",
                        "Arma tu plan con más apps ilimitadas",
                        "CO2 Negativo"
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(6.dp), // un poco más espacio
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        beneficios.forEach {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("✔", color = Color(0xFF4CAF50), fontSize = 16.sp) // iconos más grandes
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(it, fontSize = 15.sp) // texto beneficios más grande
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Image(
                        painter = painterResource(id = R.drawable.rrss),
                        contentDescription = null,
                        modifier = Modifier
                            .height(70.dp) // más alto
                            .fillMaxWidth()
                            .padding(vertical = 1.dp),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(top = 8.dp)
                    ) {
                        Button(
                            onClick = onMapaClick,
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB561FF)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp) // botón más alto
                                .align(Alignment.Center)
                        ) {
                            Text(
                                text = "Quiero este plan",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        IconButton(
                            onClick = {
                                val intent = Intent(Intent.ACTION_VIEW)
                                //mensaje a mi teléfono:
                                val url = "https://api.whatsapp.com/send?phone=+59160399110&text=" + Uri.encode("Hola, UCB mobile, preciso su ayuda")
                                intent.data = Uri.parse(url)
                                context.startActivity(intent)
                            },
                            modifier = Modifier
                                .size(25.dp)
                                .align(Alignment.TopEnd)
                                .offset(x = 6.dp, y = (-10).dp)
                                .background(Color.White, CircleShape)
                                .border(1.dp, Color.LightGray, CircleShape)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.whatsapp),
                                contentDescription = "WhatsApp",
                                tint = Color.Unspecified
                            )
                        }
                    }
                }

                IconButton(
                    onClick = onDereClick,
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Derecha",
                        tint = Color(0xFFB561FF),
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}