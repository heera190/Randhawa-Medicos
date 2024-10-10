package com.example.randhawamedicos.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.randhawamedicos.R
import com.example.randhawamedicos.ui.theme.Custom1


@Composable
fun Banner(

) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
            .height(150.dp)
            .background(
                color = Custom1,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        // Create references for the elements
        val (img, titleText, subtitleText) = createRefs()

        // Image section
        Image(
            painter = painterResource(R.drawable.nurse),
            contentDescription = "nurse",
            modifier = Modifier
                .padding(start = 10.dp)
                .height(80.dp)
                .constrainAs(img) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )

        // Title text section
        Text(
            text = "Randhawa Pharma Solutions",
            fontSize = 26.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(start = 16.dp, end = 10.dp)
                .constrainAs(titleText) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(img.end)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )

        // Subtitle text section
        Text(
            text = "Your Trusted Partner in Healthcare Distribution",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            modifier = Modifier
                .padding(start = 16.dp, end = 10.dp, top = 4.dp)
                .constrainAs(subtitleText) {
                    top.linkTo(titleText.bottom)
                    start.linkTo(img.end)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
        )
    }


}