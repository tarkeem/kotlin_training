package com.example.myapplication2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main4.*
import kotlinx.android.synthetic.main.mylistwid.view.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

    val myArray= arrayOf("mai","tarek","sara","alaa","walaa","mai","tarek","sara","alaa","walaa","mai","tarek","sara","alaa","walaa")
        val  myPicArray= arrayOf(R.drawable.ic_launcher_background, com.google.android.material.R.drawable.abc_ab_share_pack_mtrl_alpha,
            com.google.android.material.R.drawable.abc_btn_borderless_material,
            androidx.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha,
            com.google.android.material.R.drawable.abc_btn_check_to_on_mtrl_015,R.drawable.ic_launcher_background, com.google.android.material.R.drawable.abc_ab_share_pack_mtrl_alpha,
            com.google.android.material.R.drawable.abc_btn_borderless_material,
            androidx.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha,
            com.google.android.material.R.drawable.abc_btn_check_to_on_mtrl_015,R.drawable.ic_launcher_background, com.google.android.material.R.drawable.abc_ab_share_pack_mtrl_alpha,
            com.google.android.material.R.drawable.abc_btn_borderless_material,
            androidx.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha,
            com.google.android.material.R.drawable.abc_btn_check_to_on_mtrl_015)
        /*val arrayAdabter=ArrayAdapter(this,android.R.layout.select_dialog_item,myArray)*/
        mylistView .adapter=MyCustomAdabter(this,myArray,myPicArray)
        mylistView.setOnItemClickListener { adapterView, view, i, l ->Toast.makeText(this,"this elemet $l.",Toast.LENGTH_LONG).show()  }

    }
}

private  class MyCustomAdabter(context: Context,arr:Array<String>,arr2:Array<Int>) :BaseAdapter()
{

    val myContext:Context
    val  names:Array<String>
    val  pics:Array<Int>
    init {
        this.myContext=context
        this.names=arr
        this.pics=arr2
    }
    override fun getCount(): Int {

        return  10
    }

    override fun getItem(p0: Int): Any {

        return ""
    }

    override fun getItemId(p0: Int): Long {

        return 1
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val myInflate=LayoutInflater.from(myContext).inflate(R.layout.mylistwid,p2,false)
        myInflate.mytextView.text=names[p0]
        myInflate.myimageView.setImageResource(pics[p0])
        return  myInflate

    }

}