package com.onigo.onigoapp.coreui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onigo.onigoapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextHint(
    modifier: Modifier = Modifier,
    text: String,
    onTextChanged: (String) -> Unit,
    textHintId: Int,
    keyboardType: KeyboardType,
    maxLength: Int = Int.MAX_VALUE,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    val focusRequester = remember { FocusRequester() }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
            .clickable { focusRequester.requestFocus() },
        shape = RoundedCornerShape(size = 8.dp),
        elevation = cardZeroElevation
    ) {
        Box(
            modifier = Modifier
                .background(AppColors.light_grey)
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                value = text,
                onValueChange = {
                    if (it.length <= maxLength) {
                        onTextChanged(it.replace("\n", ""))
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                visualTransformation = visualTransformation,
                decorationBox = @Composable { innerTextField ->
                    TextFieldDefaults.DecorationBox(
                        value = text,
                        innerTextField = innerTextField,
                        enabled = true,
                        singleLine = true,
                        visualTransformation = VisualTransformation.None,
                        interactionSource = remember { MutableInteractionSource() },
                        placeholder = {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Text(
                                    textAlign = TextAlign.Center,
                                    text = stringResource(id = textHintId),
                                    fontSize = 20.sp,
                                    color = AppColors.grey,
                                    fontWeight = FontWeight.Normal,
                                )
                            }
                        },
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            focusedContainerColor = AppColors.light_grey,
                            disabledContainerColor = AppColors.light_grey,
                            unfocusedContainerColor = AppColors.light_grey
                        ),
                        contentPadding = PaddingValues(all = 0.dp),
                    )
                },
                cursorBrush = SolidColor(AppColors.orange),
                textStyle = TextStyle(
                    color = AppColors.black,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp
                )
            )
        }
    }
}

@Preview
@Composable
fun EditTextPreview() {
    EditTextHint(
        text = "",
        onTextChanged = {},
        textHintId = R.string.phone_number_hint,
        keyboardType = KeyboardType.Number
    )
}