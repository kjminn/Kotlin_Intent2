package kr.ssu.dongyang.minn.kotlin_intent2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kr.ssu.dongyang.minn.kotlin_intent2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val message = it.data?.getStringExtra("returnValue")
                Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
            }
        }

        val intent = Intent(this, SecondActivity::class.java)
        binding.btn1.setOnClickListener {
            activityResult.launch(intent)
        }
    }
}