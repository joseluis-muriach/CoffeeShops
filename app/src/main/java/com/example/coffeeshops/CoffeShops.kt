package com.example.coffeeshops

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.ColorFilter
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
            .padding(10.dp)
            .clickable {},
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
    var isClicked by remember { mutableStateOf(false) }

    val iconTint = if (isClicked) {
        Color.YELLOW
    } else {
        Color.GRAY
    }

    Icon(
        imageVector = icon,
        contentDescription = null,
        modifier = Modifier
            .padding(10.dp)
            .size(25.dp)
            .clickable {
                isClicked = !isClicked
                onClick()
            }
            .tint(iconTint)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    var showMenu by remember { mutableStateOf(false) }
    TopAppBar(
        title= { Text(text = "CoffeShops") },
        /*colors = TopAppBarDefaults.topAppBarColors(
            background = Color.White, // Establece el color de fondo a blanco
        ),*/
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(imageVector = Icons.Filled.MoreVert , contentDescription = "Menú")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                Modifier.width(150.dp)
            ) {
                DropdownMenuItem(
                    text = { Text(text = "Compartir") },
                    onClick = { /*TODO*/ },
                    leadingIcon = { Icon(imageVector = Icons.Filled.Share, contentDescription = "Compartir") }
                )
                DropdownMenuItem(
                    text = { Text(text = "Album") },
                    onClick = { /*TODO*/ },
                    leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock") }
                )
            }
        }
    )
}

