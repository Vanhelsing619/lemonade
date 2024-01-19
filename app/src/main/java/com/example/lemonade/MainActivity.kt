package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                lemonadetreeapp()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun lemonadetreeapp(){
    lemonade()
}


@Composable
fun lemonade(modifier: Modifier= Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)

){
    var result by remember { mutableStateOf(1) }
    var ImageResource=0
    var TextResource=0
    if (result==1)
    {
        ImageResource=R.drawable.lemon_tree
        TextResource=R.string.lemon_select
    }
    else if (result==2)
    {
        ImageResource=R.drawable.lemon_squeeze
        TextResource=R.string.lemon_squeeze
    }
    else if(result==3)
    {
        ImageResource=R.drawable.lemon_drink
        TextResource=R.string.lemon_drink
    }
    else
    {
        ImageResource=R.drawable.lemon_restart
        TextResource=R.string.lemon_empty_glass
        result=0
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(painter = painterResource(id = ImageResource), contentDescription = result.toString(),
            modifier = Modifier.clickable { result++ })
        Spacer(modifier = Modifier.height(16.dp))
        Text(stringResource(id = TextResource), fontWeight = FontWeight.Bold)

    }
}

