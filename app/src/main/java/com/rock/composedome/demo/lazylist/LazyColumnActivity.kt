package com.rock.composedome.demo.lazylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

private const val TAG = "LazyColumnActivity"
class LazyColumnActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataItems = mutableListOf<String>().also {
            it.add("ab")
            it.add("abb")
            it.add("acb")
            it.add("acb")
            it.add("bb")
            it.add("bbb")
            it.add("bbbb")
            it.add("cc")
            it.add("ccv")
            it.add("ccvd")
            it.add("dd")
            it.add("dddd")
        }
        val groupData = dataItems.groupBy { it[0] }
        setContent {
            LazyColumnGrouped(groupData)
        }
    }
}

@Composable
fun LazyColumnBasic(){
    val dataItems = mutableListOf<Int>()
    for (i in 0..100){
        dataItems.add(i)
    }

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(
            modifier=Modifier.fillMaxWidth(),
            state = listState,//state 用来控制滑动， 获取 list 当前滑动信息等
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp),//内容距List的间距
            verticalArrangement = Arrangement.spacedBy(4.dp),//Item Item之间的间距
        ){
            //单个 item
            item {
                Box(modifier = Modifier.fillMaxWidth().height(20.dp)){
                    Text("Header",modifier = Modifier.align(Alignment.Center))
                }
            }
            //多个 item , lambda 中单个 Item 的 Composable
            items(
                items = dataItems,//数据集
                //key 为每个 Item 设置一个与 dataItem 对应的 key ，防止数据集发生变化后 List 滚动位置丢失
                //key 必须是可以保存到 Bundle 中的数据类型
                key = {dataItem -> dataItem}
            ){
                Text(text = "item:$it",modifier = Modifier.background(Color.LightGray)
                    .fillMaxWidth(), color = Color.White)
            }
            //带索引
//            itemsIndexed(dataItems){ index, item ->
//                Text(text = "item:$index $item",modifier = Modifier
//                    .background(Color.LightGray)
//                    .fillMaxWidth(), color = Color.White)
//            }
        }
        Button(onClick = {
            Log.e(TAG, "LazyColumnBasic LazyListState:\n " +
                    "第一个可见 Item 的 Index -> ${listState.firstVisibleItemIndex} \n " +
                    "第一个可见 Item 滚动的 Offset -> ${listState.firstVisibleItemScrollOffset} \n " +
                    "当前是否在滚动 -> ${listState.isScrollInProgress} \n " +
                    "List 中 Item 总数 -> ${listState.layoutInfo.totalItemsCount}")
            if (listState.isScrollInProgress) return@Button
            if (listState.firstVisibleItemIndex > 5){
                //直接跳到指定 Index 的 Item
                scope.launch { listState.scrollToItem(0) }
            }else{
                //动画滚动到指定 Index 的 Item
                scope.launch { listState.animateScrollToItem(listState.layoutInfo.totalItemsCount - 1) }
            }
        }, modifier = Modifier.align(Alignment.BottomEnd)) { Text(text = "LazyListState")}
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnGrouped(groupData:Map<Char,List<String>>){
    LazyColumn(verticalArrangement = Arrangement.spacedBy(80.dp)){
        groupData.forEach { (groupKey, groupedItem) ->
            //粘性标题
            stickyHeader {
                Text(text = "Title $groupKey")
            }
            items(groupedItem){
                Text(text = "item:$it",modifier = Modifier.background(Color.LightGray).fillMaxWidth(),
                    color = Color.White)
            }
        }
    }
}
//fixme 分页
