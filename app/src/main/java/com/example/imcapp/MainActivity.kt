package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 70
    private var currentAge: Int = 30
    private var currentHeight: Int = 120


    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button

    private lateinit var gender: String

    companion object{
        const val IMC_KEY = "IMC_RESULT"
        const val GENDER_KEY = "SELECTED_GENDER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
        gender = getString(R.string.male)  // Asignamos el string de 'Hombre' a la variable gender
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            if (!isMaleSelected) {
                changeGender()
                gender = getString(R.string.male)
                setGenderColor()
            }
        }

        viewFemale.setOnClickListener {
            if (!isFemaleSelected) {
                changeGender()
                gender = getString(R.string.female)
                setGenderColor()
            }
        }

        rsHeight.addOnChangeListener { _, value, _ ->
            currentHeight = value.toInt()
            setHeight(currentHeight.toString())
        }

        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }

        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }

        btnPlusAge.setOnClickListener {
            currentAge +=1
            setAge()
        }

        btnSubtractAge.setOnClickListener {
            currentAge -=1
            setAge()
        }

        btnCalculate.setOnClickListener {
            navigateResult(calculateIMC(), gender)
        }
    }

    private fun navigateResult(result: Double, gender: String) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        intent.putExtra(GENDER_KEY, gender)
        startActivity(intent)
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setHeight(result: String) {
        tvHeight.text = getString(R.string.centimeters, result)
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
        setHeight("120")
        setWeight()
        setAge()
    }
}