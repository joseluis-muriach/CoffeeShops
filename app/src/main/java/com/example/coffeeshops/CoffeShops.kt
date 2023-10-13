package com.example.coffeeshops

import android.graphics.Color
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshops.ui.theme.FontTittle

data class Picture(
    @DrawableRes var photo: Int,
    var nameShop: String,
    var nickName: String
)

@Composable
fun MenuShop() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getPicture()) { superPicture ->
            ItemPicture(picture = superPicture) {

            }
        }
    }
}

fun getPicture(): List<Picture> {
    return listOf(
        Picture(
            R.drawable.images,
            "Antico Caffe Greco",
            "St. Italy, Rome"
        ),
        Picture(
            R.drawable.images1,
            "Coffee Room",
            "St. Germany, Berlin"
        ),
        Picture(
            R.drawable.images2,
            "Coffe Ibiza",
            "St. Colon, Madrid"
        ),
        Picture(
            R.drawable.images3,
            "Pudding Coffe shop",
            "St. Diagonal Barcelona"
        ),
        Picture(
            R.drawable.images4,
            "LÉxpress",
            "St. Picadilly Circus, London"
        ),
        Picture(
            R.drawable.images5,
            "Coffe Corner",
            "St. Angel Guimera, Valencia"
        ),
        Picture(
            R.drawable.images6,
            "Sweet Cup",
            "St. Kinkerstraat, Amsterdam"
        )
    )
}

@Composable
fun ItemPicture(picture: Picture, onItemSelected: (Picture) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(id = picture.photo),
            contentDescription = "",
            contentScale = ContentScale.Crop,

        )
        Row(Modifier.fillMaxWidth()) {
            Text(text = picture.nameShop,
                fontSize = 30.sp,
                fontFamily = FontTittle,
                modifier = Modifier.padding(10.dp))
        }
        Row {
            IconRow()
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Row {
            Text(text = picture.nickName,
                modifier = Modifier.padding(10.dp))
        }
        Divider()
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "REVERSE")
        }
    }
}

@Composable
fun IconRow() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ClickableIcon(icon = Icons.Default.Star) { }
        ClickableIcon(icon = Icons.Default.Star) { }
        ClickableIcon(icon = Icons.Default.Star) { }
        ClickableIcon(icon = Icons.Default.Star) { }
        ClickableIcon(icon = Icons.Default.Star) { }
    }
}

@Composable
fun ClickableIcon(icon: ImageVector, onClick: () -> Unit) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        modifier = Modifier
            .padding(10.dp)
            .size(25.dp)
            .clickable(onClick = onClick)
    )
}
