package com.example.myapplication2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Sent
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main6.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val myMenueInflater=menuInflater
        myMenueInflater.inflate(R.menu.mymenue,menu)
            return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.item1 ->{
                Toast.makeText(this,"clicked",Toast.LENGTH_LONG).show()

            return  true
            }
            R.id.item2 ->{
                Toast.makeText(this,"clicked",Toast.LENGTH_LONG).show()
                return true
            }
            R.id.item3 ->{
                finish()
                return  true
            }
        }

        return super.onOptionsItemSelected(item)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*we have three methods to notify the program when any click event happen
1-give property on click value of function
2-bring object in main activity code then object.setFun
3-use abstract class View.OnClickListener and inside the body identify which object has been clicked
*/
      checkBox.setOnClickListener(this)
        checkBox2.setOnClickListener(this)
        checkBox3.setOnClickListener(this)

        button2.setOnClickListener {
            var intent=Intent(this,MainActivity2::class.java)
            intent.putExtra("val","hello from page 1")
            startActivity(intent)

        }

        button.setOnClickListener {
            var intent=Intent(this,MainActivity6::class.java)
            //var intent=Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener {
            var intent=Intent(this,MainActivity4::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            var intent=Intent(this,MainActivity5::class.java)
            startActivity(intent)
        }
        button6.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("mailto"+"desiretarek@gmail.com"+"?subject="+"message")))
        }
        button5.setOnClickListener {
            val sent=Intent()
              sent.action=Intent.ACTION_SEND
            sent.putExtra(Intent.EXTRA_TEXT,"www.google.com")
            sent.type="text/plain"
            startActivity(Intent.createChooser(sent,"choose"))
        }


    }








    fun calculateWeight(weight:Double,percent:Double)
    {
      var res:Double= weight*percent
        res.roundDecimal(2)
        textView.text=res.toString()
    }

    fun Double.roundDecimal(digit: Int) = "%.${digit}f".format(this)

   /* fun boxChecked(v:View)
    {
        v as CheckBox
        println("button clicked new......................")
        var isCheacked=v.isChecked
        println(isCheacked)
        when(v.id)
        {
            R.id.checkBox -> if(isCheacked){

                checkBox2.isChecked=false;
                checkBox3.isChecked=false;
            }
            R.id.checkBox2 -> if(isCheacked){
                checkBox.isChecked=false;
                checkBox3.isChecked=false;
            }
            R.id.checkBox3 -> if(isCheacked){
                checkBox.isChecked=false;
                checkBox2.isChecked=false;
            }
        }



    }*/

    override fun onClick(v: View?) {
        v as CheckBox
        var  weight=textfield.text.toString().toDouble()
        println("button clicked new......................")
        var isCheacked=v.isChecked
        println(isCheacked)
        when(v.id)
        {
            R.id.checkBox -> if(isCheacked&&!TextUtils.isEmpty(textfield.text)){

                checkBox2.isChecked=false;
                checkBox3.isChecked=false;
                calculateWeight(weight,0.10)
            }
            R.id.checkBox2 -> if(isCheacked&&!TextUtils.isEmpty(textfield.text)){
                checkBox.isChecked=false;
                checkBox3.isChecked=false;
                calculateWeight(weight,0.50)
            }
            R.id.checkBox3 -> if(isCheacked&&!TextUtils.isEmpty(textfield.text)){
                checkBox.isChecked=false;
                checkBox2.isChecked=false;
                calculateWeight(weight,0.20)
            }
        }
    }
}