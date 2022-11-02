package kr.ssu.dongyang.minn.kotlin_intent2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ssu.dongyang.minn.kotlin_intent2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnFinish.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("returnValue", binding.edit1.text.toString())
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }
}