package com.example.hamburgueriaz

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hamburgueriaz.ui.theme.HamburgueriaZTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HamburgueriaZTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    "HamburgueriaZ",
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.Black
                            ),
                            actions = {
                                IconButton(onClick = { }) {
                                    Image(
                                        painter = painterResource(id = R.drawable.hamburgueriaz_icon),
                                        contentDescription = "Ícone Hamburguer",
                                        modifier = Modifier.size(32.dp)
                                    )
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            // Exibir o banner promocional
                            Image(
                                painter = painterResource(id = R.drawable.banner_promocao),
                                contentDescription = "Promoção 25% off",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(220.dp)
                            )

                            // Conteúdo do cardápio abaixo do banner
                            Cardapio()
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun Cardapio() {
    // Estados para os checkboxes
    var gokuSelected by remember { mutableStateOf(false) }
    var vegetaSelected by remember { mutableStateOf(false) }
    var piccoloSelected by remember { mutableStateOf(false) }

    // Quantidades e valores de cada lanche
    var gokuQuantity by remember { mutableIntStateOf(0) }
    var vegetaQuantity by remember { mutableIntStateOf(0) }
    var piccoloQuantity by remember { mutableIntStateOf(0) }

    val gokuPrice = 25.99
    val vegetaPrice = 28.99
    val piccoloPrice = 30.99

    // Ingredientes de cada lanche
    val gokuIngredients = listOf("Pão de nuvem", "Carne de Sayajin", "Queijo Kaio", "Molho Kamehameha", "Alface Namekuseijin")
    val vegetaIngredients = listOf("Pão de orgulho", "Carne de Príncipe Saiyajin", "Queijo Majin", "Cebola do poder", "Molho Final Flash")
    val piccoloIngredients = listOf("Pão verde", "Carne vegetal de Namekuseijin", "Queijo do Dragão", "Couve-flor especial", "Molho Makankosappo")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0)),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Cardápio de Lanches",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            HorizontalDivider(
                modifier = Modifier.padding(bottom = 16.dp),
                thickness = 2.dp,
                color = Color.Gray
            )

            // Card para Goku
            LancheItem(
                name = "Goku",
                isSelected = gokuSelected,
                onCheckedChange = { gokuSelected = it },
                ingredientes = gokuIngredients,
                price = gokuPrice,
                quantity = gokuQuantity,
                onIncrement = { gokuQuantity++ },
                onDecrement = { if (gokuQuantity > 0) gokuQuantity-- },
                onResetQuantity = { gokuQuantity = 0 }
            )

            // Card para Vegeta
            LancheItem(
                name = "Vegeta",
                isSelected = vegetaSelected,
                onCheckedChange = { vegetaSelected = it },
                ingredientes = vegetaIngredients,
                price = vegetaPrice,
                quantity = vegetaQuantity,
                onIncrement = { vegetaQuantity++ },
                onDecrement = { if (vegetaQuantity > 0) vegetaQuantity-- },
                onResetQuantity = { vegetaQuantity = 0 }
            )

            // Card para Piccolo
            LancheItem(
                name = "Piccolo",
                isSelected = piccoloSelected,
                onCheckedChange = { piccoloSelected = it },
                ingredientes = piccoloIngredients,
                price = piccoloPrice,
                quantity = piccoloQuantity,
                onIncrement = { piccoloQuantity++ },
                onDecrement = { if (piccoloQuantity > 0) piccoloQuantity-- },
                onResetQuantity = { piccoloQuantity = 0 }
            )

            // Resumo do pedido
            ResumoPedido(
                gokuQuantity = gokuQuantity,
                vegetaQuantity = vegetaQuantity,
                piccoloQuantity = piccoloQuantity,
                gokuPrice = gokuPrice,
                vegetaPrice = vegetaPrice,
                piccoloPrice = piccoloPrice
            )
        }
    }
}



@Composable
fun LancheItem(
    name: String,
    isSelected: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    ingredientes: List<String>,
    price: Double,
    quantity: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onResetQuantity: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Checkbox e nome do lanche
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isSelected,
                onCheckedChange = {
                    onCheckedChange(it)
                    if (!it) {
                        onResetQuantity()
                    }
                }
            )
            Text(text = name, modifier = Modifier.padding(start = 8.dp))
        }

        // Exibir o card de ingredientes e de quantidade/valor, se o lanche estiver selecionado
        if (isSelected) {
            IngredientesCard(ingredientes = ingredientes)
            QuantidadeCard(price = price, quantity = quantity, onIncrement = onIncrement, onDecrement = onDecrement)
        }
    }
}


@Composable
fun IngredientesCard(ingredientes: List<String>) {
    // Card para exibir os ingredientes
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E0E0))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ingredientes:", style = MaterialTheme.typography.titleMedium, color = Color.Black)

            ingredientes.forEach { ingrediente ->
                Text(text = ingrediente, color = Color.DarkGray)
            }
        }
    }
}

@Composable
fun QuantidadeCard(price: Double, quantity: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {
    // Card para exibir o valor e controle de quantidade
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E0E0))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Exibir o preço
            Text(text = "R$ $price", style = MaterialTheme.typography.titleMedium)

            // Botões de controle de quantidade
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { onDecrement() }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Diminuir quantidade")
                }

                Text(text = "$quantity", modifier = Modifier.padding(horizontal = 16.dp))

                IconButton(onClick = { onIncrement() }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "Aumentar quantidade")
                }
            }
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun ResumoPedido(
    gokuQuantity: Int,
    vegetaQuantity: Int,
    piccoloQuantity: Int,
    gokuPrice: Double,
    vegetaPrice: Double,
    piccoloPrice: Double
) {
    val context = LocalContext.current

    val gokuTotal = gokuQuantity * gokuPrice
    val vegetaTotal = vegetaQuantity * vegetaPrice
    val piccoloTotal = piccoloQuantity * piccoloPrice
    val totalSemDesconto = gokuTotal + vegetaTotal + piccoloTotal
    val totalItens = gokuQuantity + vegetaQuantity + piccoloQuantity

    val isPedidoValido = totalItens > 0

    // Calcular o desconto de 25% se 2 ou mais lanches forem selecionados
    val desconto = if (totalItens >= 2) {
        totalSemDesconto * 0.25
    } else {
        0.0
    }

    // Calcular o total final a pagar
    val totalAPagar = totalSemDesconto - desconto

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0)),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Resumo do Pedido",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            HorizontalDivider(
                modifier = Modifier.padding(bottom = 16.dp),
                thickness = 2.dp,
                color = Color.Gray
            )

            // Exibir o resumo dos lanches selecionados
            if (gokuQuantity > 0) {
                Text(text = "Goku: $gokuQuantity x R$ ${String.format("%.2f", gokuPrice)} = R$ ${String.format("%.2f", gokuTotal)}")
            }
            if (vegetaQuantity > 0) {
                Text(text = "Vegeta: $vegetaQuantity x R$ ${String.format("%.2f", vegetaPrice)} = R$ ${String.format("%.2f", vegetaTotal)}")
            }
            if (piccoloQuantity > 0) {
                Text(text = "Piccolo: $piccoloQuantity x R$ ${String.format("%.2f", piccoloPrice)} = R$ ${String.format("%.2f", piccoloTotal)}")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Exibir o valor total sem desconto, o desconto aplicado e o total final a pagar
            Text(
                text = """
                    Total de Itens: $totalItens
                    Valor do Pedido: R$ ${String.format("%.2f", totalSemDesconto)}
                    Desconto Aplicado: R$ ${String.format("%.2f", desconto)}
                    Total a Pagar: R$ ${String.format("%.2f", totalAPagar)}
                """.trimIndent(),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão "Enviar Pedido" abaixo do total de itens e valor total
            Button(
                onClick = { enviarMensagemWhatsApp(context) },
                modifier = Modifier.fillMaxWidth(),
                enabled = isPedidoValido
            ) {
                Text(
                    text = "Enviar Pedido",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HamburgueriaZTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "HamburgueriaZ",
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Black
                    ),
                    actions = {
                        IconButton(onClick = {  }) {
                            Image(
                                painter = painterResource(id = R.drawable.hamburgueriaz_icon),
                                contentDescription = "Ícone Hamburguer",
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                )
            }
        ) {
            Surface {
                Cardapio()
            }
        }
    }
}

fun enviarMensagemWhatsApp(context: Context) {
    val numeroTelefone = "5511999999999" // Número do WhatsApp no formato internacional (com DDI e DDD)
    val mensagem = "Olá! Estou fazendo um pedido na HamburgueriaZ." // Mensagem a ser enviada

    val uri = Uri.parse("https://wa.me/$numeroTelefone?text=${Uri.encode(mensagem)}")
    val intent = Intent(Intent.ACTION_VIEW, uri)

    try {
        context.startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}


