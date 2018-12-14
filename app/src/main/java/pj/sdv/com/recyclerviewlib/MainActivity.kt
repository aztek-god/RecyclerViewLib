package pj.sdv.com.recyclerviewlib

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import pj.sdv.com.recyclerviewlib.list.ObservableArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val list: ObservableArrayList<String> =
//            ObservableArrayList(object : ObservableArrayList.OnChangeListener<String> {
//                override fun onChange(oldList: Collection<String>, newList: Collection<String>) {
//                    Log.d("sdvStark2", "oldList = $oldList, newList = $newList")
//                }
//            })

    }
}
