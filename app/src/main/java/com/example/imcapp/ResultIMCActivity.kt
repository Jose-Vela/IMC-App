package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.imcapp.MainActivity.Companion.GENDER_KEY
import com.example.imcapp.MainActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnReCalculate: Button
    private lateinit var imgBodyType: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        val gender:String = intent.extras?.getString(GENDER_KEY) ?: ""
        initComponents()
        initUI(result, gender)
        initListeners()
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun initUI(result: Double, gender: String) {
        tvIMC.text = result.toString()
        when(result){
            in 0.00..18.50 -> { // Bajo peso
                tvResult.text = getString(R.string.titleUnderWeight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.under_weight))
                tvDescription.text = getString(R.string.descriptionUnderWeight)
                if (gender == getString(R.string.male)) imgBodyType.setImageResource(R.drawable.img_male_underweight) else imgBodyType.setImageResource(R.drawable.img_female_underweight)
                imgBodyType.setColorFilter(ContextCompat.getColor(this, R.color.under_weight))
            }

            in 18.51..24.99 -> { // Saludable (Peso normal)
                tvResult.text = getString(R.string.titleNormalWeight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
                tvDescription.text = getString(R.string.descriptionNormalWeight)
                if (gender == getString(R.string.male)) imgBodyType.setImageResource(R.drawable.img_male_normal_weight) else imgBodyType.setImageResource(R.drawable.img_female_normal_weight)
                imgBodyType.setColorFilter(ContextCompat.getColor(this, R.color.normal_weight))
            }

            in 25.00..29.99 -> { // Sobrepeso
                tvResult.text = getString(R.string.titleOverWeight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.over_weight))
                tvDescription.text = getString(R.string.descriptionOverWeight)
                if (gender == getString(R.string.male)) imgBodyType.setImageResource(R.drawable.img_male_overweight) else imgBodyType.setImageResource(R.drawable.img_female_overweight)
                imgBodyType.setColorFilter(ContextCompat.getColor(this, R.color.over_weight))
            }

            in 30.00..39.99 -> { // Obecidad
                tvResult.text = getString(R.string.titleObesity)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesity))
                tvDescription.text = getString(R.string.descriptionObesity)
                if (gender == getString(R.string.male)) imgBodyType.setImageResource(R.drawable.img_male_obesity) else imgBodyType.setImageResource(R.drawable.img_female_obesity)
                imgBodyType.setColorFilter(ContextCompat.getColor(this, R.color.obesity))
            }

            in 40.00..99.99 -> { // Obecidad Severa
                tvResult.text = getString(R.string.titleExtremeObesity)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.extreme_obesity))
                tvDescription.text = getString(R.string.descriptionExtremeObesity)
                if (gender == getString(R.string.male)) imgBodyType.setImageResource(R.drawable.img_male_extreme_obesity) else imgBodyType.setImageResource(R.drawable.img_female_extreme_obesity)
                imgBodyType.setColorFilter(ContextCompat.getColor(this, R.color.extreme_obesity))
            }

            else -> { // Error
                tvResult.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.error))
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnReCalculate)
        imgBodyType =  findViewById(R.id.imgBodyType)
    }
}