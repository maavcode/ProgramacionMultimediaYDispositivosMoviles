package com.example.playground_kotlin_pizzatime.ui.screens

import android.ranging.DataNotificationConfig
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.playground_kotlin_pizzatime.R
import com.example.playground_kotlin_pizzatime.data.Data
import com.example.playground_kotlin_pizzatime.models.Person

@Composable
fun IndexScreen(
    onListOrderButton: () -> Unit,
    onPlaceOrderButton: () -> Unit
) {
    val person = Data().updatePersons()[0]
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(
            text = stringResource(R.string.welcome_to_pizzatime),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )


        PersonalInformation(
            modifier = Modifier,
            person = person
        )

        HorizontalDivider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(20.dp)
        )

        IndexOptions(
            onPlaceOrderButton = onPlaceOrderButton,
            onListOrderButton = onListOrderButton
        )
    }
}

@Composable
fun PersonalInformation(
    modifier: Modifier = Modifier,
    person : Person
){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ){
        Image(
            painter = painterResource(person.imageResourceId),
            contentDescription = person.name,
            Modifier
                .border(
                    width = 5.dp,
                    brush = SolidColor(Color.LightGray),
                    shape = CircleShape
                )
                .clip(CircleShape)


        )
        Text(
            text = person.name,
            fontSize = 20.sp
        )
        Text(
            text = person.email
        )
        Text(
            text = person.mobile
        )
    }

}

@Composable
fun IndexOptions(
    modifier: Modifier = Modifier,
    onListOrderButton: () -> Unit,
    onPlaceOrderButton: () -> Unit
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Text(
            text = stringResource(R.string.what_are_you_going_to_do),
            fontSize = 24.sp,
            modifier = Modifier
        )
        // Options
        Row (
            modifier = Modifier.padding(top = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(50.dp)
        ){
            Button(
                onClick = onPlaceOrderButton,
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(R.string.place_order)
                )
            }

            Button(
                onClick = onListOrderButton,
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(R.string.order_list)
                )
            }
        }
    }
}