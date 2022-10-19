package com.example.savetextviewbunbleapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val EDIT_TEXT_KEY = "EDIT_TEXT_KEY";
//    companion object{
//        var count_save:Int;
//    }
    private var count_save = 0;

    private fun render(count: Int, textView: TextView){
        textView.text = count.toString();
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(EDIT_TEXT_KEY,this.count_save)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_plus = findViewById<Button>(R.id.button);
        val button_minus = findViewById<Button>(R.id.button2);
        val textView = findViewById<TextView>(R.id.textView);
        if (savedInstanceState != null) {
            count_save = savedInstanceState.getInt(EDIT_TEXT_KEY)
            textView.text = count_save.toString()
        }

        button_minus.setOnClickListener{
            this.count_save++;
            render(this.count_save, textView);
        }

        button_plus.setOnClickListener {
            this.count_save--;
            render(this.count_save, textView);
        }



    }
//


}