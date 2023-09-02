package com.jeongg.mbti.presentation.style

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.jeongg.mbti.R
import com.jeongg.mbti.presentation.util.mbtiClickable
import com.jeongg.mbti.presentation.util.runIf

internal val pretendardFamily = FontFamily(
    Font(R.font.pretendard_black, FontWeight.Black),
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_extra_light, FontWeight.ExtraLight),
    Font(R.font.pretendard_light, FontWeight.Light),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_regular, FontWeight.Normal),
    Font(R.font.pretendard_semi_bold, FontWeight.SemiBold),
    Font(R.font.pretendard_thin, FontWeight.Thin),
    Font(R.font.pretendrad_extra_bold, FontWeight.ExtraBold),
)

internal object MbtiTextStyle {
    val Title1 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Title2 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
    val Body1 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body2 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
    val Body3 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body4 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
    val Body5 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body6 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
    val Body7 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body8 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
    val Body9 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 10.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body10 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
}

@Composable
fun MbtiTitle1(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .mbtiClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = MbtiTextStyle.Title1.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}
@Composable
fun MbtiTitle2(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .mbtiClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = MbtiTextStyle.Title2.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun MbtiBody1(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .mbtiClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = MbtiTextStyle.Body1.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun MbtiBody2(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .mbtiClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = MbtiTextStyle.Body2.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun MbtiBody3(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .mbtiClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = MbtiTextStyle.Body3.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun MbtiBody4(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .mbtiClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = MbtiTextStyle.Body4.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun MbtiBody5(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .mbtiClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = MbtiTextStyle.Body5.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun MbtiBody6(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .mbtiClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = MbtiTextStyle.Body6.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun MbtiBody7(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .mbtiClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = MbtiTextStyle.Body7.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun MbtiBody8(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .mbtiClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = MbtiTextStyle.Body8.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun MbtiBody9(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .mbtiClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = MbtiTextStyle.Body9.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun MbtiBody10(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .mbtiClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = MbtiTextStyle.Body10.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}