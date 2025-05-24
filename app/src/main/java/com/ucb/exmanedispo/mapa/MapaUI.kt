package com.ucb.exmanedispo.mapa


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.CameraPosition
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import com.google.android.gms.maps.model.MapStyleOptions

@Composable
fun MapaUI (
    onBackClick: () -> Unit,
    plan: String,
    mapaViewModel: MapaViewModel = viewModel()
){
    var showMap by remember { mutableStateOf(false) }
    val contentButton = if (showMap) "Ocultar Mapa" else "Mostrar Mapa"
    val context = LocalContext.current
    val cochabambaLatLng = LatLng(-17.3895, -66.1568)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(cochabambaLatLng, 13f)
    }
    val mapStyleJson = """
    [
      {
        "elementType": "geometry",
        "stylers": [{"color": "#212121"}]
      },
      {
        "elementType": "labels.icon",
        "stylers": [{"visibility": "off"}]
      },
      {
        "elementType": "labels.text.fill",
        "stylers": [{"color": "#757575"}]
      },
      {
        "elementType": "labels.text.stroke",
        "stylers": [{"color": "#212121"}]
      },
      {
        "featureType": "administrative",
        "elementType": "geometry",
        "stylers": [{"color": "#757575"}]
      },
      {
        "featureType": "poi",
        "elementType": "labels.text.fill",
        "stylers": [{"color": "#757575"}]
      },
      {
        "featureType": "poi.park",
        "elementType": "geometry",
        "stylers": [{"color": "#181818"}]
      },
      {
        "featureType": "road",
        "elementType": "geometry.fill",
        "stylers": [{"color": "#2c2c2c"}]
      },
      {
        "featureType": "road",
        "elementType": "labels.text.fill",
        "stylers": [{"color": "#8a8a8a"}]
      },
      {
        "featureType": "transit",
        "elementType": "geometry",
        "stylers": [{"color": "#2f3948"}]
      },
      {
        "featureType": "water",
        "elementType": "geometry",
        "stylers": [{"color": "#000000"}]
      }
    ]
    """.trimIndent()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF1E1E1E), Color(0xFF3E3E3E))
                )
            )
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Botón de retroceso superior
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = "Planes",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 18.sp
                    )
                }
            }

            item {
                Text(
                    text = "¿Dónde enviaremos tu SIM?",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp
                )
            }

            item {
                Text(
                    text = "Seleccionado: $plan",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.LightGray,
                    fontSize = 18.sp
                )
            }

            item {
                OutlinedTextField(
                    value = mapaViewModel.phone.value,
                    onValueChange = { mapaViewModel.actualizarTelefono(it) },
                    label = { Text("Teléfono celular", color = Color.White) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
                )
            }

            // Mostrar latitud y longitud en tarjetas
            item {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Latitud: ${mapaViewModel.latitud.value ?: "No seleccionada"}",
                        modifier = Modifier.padding(8.dp),
                        color = Color.Black
                    )
                }
            }

            item {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Longitud: ${mapaViewModel.longitud.value ?: "No seleccionada"}",
                        modifier = Modifier.padding(8.dp),
                        color = Color.Black
                    )
                }
            }

            item {
                Button(
                    onClick = { showMap = !showMap },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB561FF)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = contentButton)
                }
            }

            if (showMap) {
                item {
                    Box(
                        modifier = Modifier
                            .height(320.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.DarkGray)
                    ) {
                        GoogleMap(
                            modifier = Modifier.fillMaxSize(),
                            cameraPositionState = cameraPositionState,
                            onMapClick = { latLng ->
                                mapaViewModel.actualizarUbicacion(latLng.latitude, latLng.longitude)
                            },
                            properties = com.google.maps.android.compose.MapProperties(
                                mapStyleOptions = MapStyleOptions(mapStyleJson)
                            )
                        ) {
                            mapaViewModel.latitud.value?.let { lat ->
                                mapaViewModel.longitud.value?.let { lng ->
                                    Marker(
                                        state = MarkerState(position = LatLng(lat, lng)),
                                        title = "Tu ubicación"
                                        // Puedes añadir un ícono personalizado si quieres:
                                        // icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            item {
                Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Enviando SIM a:\nlat=${mapaViewModel.latitud.value}, lng=${mapaViewModel.longitud.value}, tel=${mapaViewModel.phone.value}",
                            Toast.LENGTH_LONG
                        ).show()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB561FF)),
                    enabled = mapaViewModel.esNumValido(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text("Enviar SIM")
                }
            }
        }
    }
}