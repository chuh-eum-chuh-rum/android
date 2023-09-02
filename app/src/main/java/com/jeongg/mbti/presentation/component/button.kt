package com.jeongg.mbti.presentation.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeongg.mbti.presentation.style.MbtiBody5
import com.jeongg.mbti.presentation.style.MbtiColor
import com.jeongg.mbti.presentation.util.mbtiClickable

@Composable
fun LargePrimaryButton(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    val backgroundColor =
        animateColorAsState(
            targetValue = if (enabled) MbtiColor.Green2 else MbtiColor.Green2,
            label = "",
        )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(
                color = backgroundColor.value,
                shape = RoundedCornerShape(8.dp),
            )
            .mbtiClickable(
                rippleEnabled = enabled,
                rippleColor = MbtiColor.Green1,
                onClick = onClick,
            ),
        contentAlignment = Alignment.Center
    ) {
        MbtiBody5(
            text = text,
            color = MbtiColor.Gray100,
        )
    }
}

@Composable
fun LargePrimaryOutlineButton(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    val backgroundColor =
        animateColorAsState(
            targetValue = if (enabled) MbtiColor.Green2 else MbtiColor.Green2,
            label = "",
        )

    val textColor =
        animateColorAsState(
            targetValue = if (enabled) MbtiColor.Green2 else MbtiColor.Green3,
            label = "",
        )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = backgroundColor.value,
                shape = RoundedCornerShape(8.dp),
            )
            .mbtiClickable(
                rippleEnabled = enabled,
                rippleColor = MbtiColor.Green1,
                onClick = onClick,
            ),
        contentAlignment = Alignment.Center,
    ) {
        MbtiBody5(
            text = text,
            color = textColor.value,
        )
    }
}

@Preview
@Composable
fun PreviewButton() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        LargePrimaryButton(text = "button", enabled = true) {

        }
        LargePrimaryButton(text = "button", enabled = false) {

        }
        LargePrimaryOutlineButton(text = "button", enabled = true) {

        }
        LargePrimaryOutlineButton(text = "button", enabled = false) {

        }
    }
}