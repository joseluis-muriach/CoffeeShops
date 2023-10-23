package com.example.coffeeshops

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Comments(
    var comment: String
)

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun MainComments() {
    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "TEXTO")
        }

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            content = {
                items(getComment().size) { indice ->
                    var comments = getComment()
                    Card(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(10.dp)
                    ) {
                        Text(text = comments[indice].comment,
                            modifier = Modifier.padding(10.dp))
                    }
                }
            }
        )
    }
}

fun getComment(): List<Comments> {
    return listOf(
        Comments("Servicio algo flojo, aún así lo recomiendo"),
        Comments("Céntrica y acogedora. Volveremos seguro"),
        Comments("La ambientacion muy buena, pero en la planta de arriba un poco escasa."),
        Comments(
            "La comida estaba deliciosa y bastante bien de precio, mucha variedad de platos.\n" +
                    "El personal muy amable, nos permitieron ver todo el establecimiento.\n"
        ),
        Comments("Muy bueno"),
        Comments("Excelente. Destacable la extensa carta de cafés."),
        Comments("Buen ambiente y buen servicio. Lo recomiendo."),
        Comments("En días festivos demasiado tiempo de espera."),
        Comments("Los camareros/as no dan abasto."),
        Comments("No lo recomiendo."),
        Comments("No volveré."),
        Comments("Repetiremos."),
        Comments("Gran selección de tartas y cafés."),
        Comments(
            "La vajilla muy bonita todo de diseño que en el entorno del bar queda ideal." + "\n" +
                    "Puntos negativos: el servicio es muy lento y los precios son un poco elevados.",),
        Comments("Todo lo que he probado en la cafetería está riquísimo, dulce o salado.")
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun itemComments() {

}