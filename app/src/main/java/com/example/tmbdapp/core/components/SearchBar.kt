package com.example.tmbdapp.core.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmbdapp.ui.theme.Gray
import com.example.tmbdapp.ui.theme.LightGray
import com.example.tmbdapp.ui.theme.TMBDAppTheme
import com.example.tmbdapp.ui.theme.White
import com.example.tmbdapp.R

@Composable
fun SearchBar(
    value : String,
    placeholder : String,
    isError : Boolean,
    onTextChanged : (text : String) -> Unit,
    onSearchClick : () -> Unit
) {
    OutlinedTextField(
        modifier = Modifier
            .width(327.dp)
            .height(42.dp),
        value = value,
        singleLine = true,
        isError = isError,
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = { onSearchClick }
        ),
        placeholder = {Text(text = placeholder, color = LightGray, fontSize = 10.sp)},
        trailingIcon = {
            IconButton(onClick = { onSearchClick() }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = LightGray
                )
            }
        },
        onValueChange = {onTextChanged(it)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = White,
            backgroundColor = Gray,
            focusedBorderColor = Gray,
            unfocusedBorderColor = Gray,
            cursorColor = LightGray
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview(){
    TMBDAppTheme{
        SearchBar(
            value = "",
            placeholder = stringResource(id = R.string.placeholder),
            isError = false,
            onTextChanged = {},
            onSearchClick = {}
        )
    }
}