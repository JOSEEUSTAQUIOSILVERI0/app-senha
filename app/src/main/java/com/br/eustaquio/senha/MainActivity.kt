package com.br.eustaquio.senha

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.content.ClipboardManager
import android.content.Context
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var generatedPassword: TextView
    lateinit var seekBarLength: SeekBar
    lateinit var passwordLength: TextView
    lateinit var checkUppercase: CheckBox
    lateinit var checkLowercase: CheckBox
    lateinit var checkNumbers: CheckBox
    lateinit var checkSpecial: CheckBox
    lateinit var checkExcludeSimilar: CheckBox
    lateinit var btnGenerate: Button
    lateinit var btnCopy: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando os elementos da interface
        generatedPassword = findViewById(R.id.generatedPassword)
        seekBarLength = findViewById(R.id.seekBarLength)
        passwordLength = findViewById(R.id.passwordLength)
        checkUppercase = findViewById(R.id.checkUppercase)
        checkLowercase = findViewById(R.id.checkLowercase)
        checkNumbers = findViewById(R.id.checkNumbers)
        checkSpecial = findViewById(R.id.checkSpecial)
        checkExcludeSimilar = findViewById(R.id.checkExcludeSimilar)
        btnGenerate = findViewById(R.id.btnGenerate)
        btnCopy = findViewById(R.id.btnCopy)

        // Atualizando o comprimento da senha conforme o SeekBar é ajustado
        seekBarLength.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                passwordLength.text = "Password Length: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Configurando o botão de geração de senha
        btnGenerate.setOnClickListener {
            val password = generatePassword(
                seekBarLength.progress,
                checkUppercase.isChecked,
                checkLowercase.isChecked,
                checkNumbers.isChecked,
                checkSpecial.isChecked,
                checkExcludeSimilar.isChecked
            )
            generatedPassword.text = password
        }

        // Configurando o botão de cópia
        btnCopy.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = android.content.ClipData.newPlainText("Generated Password", generatedPassword.text)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_SHORT).show()
        }
    }

    // Função para gerar a senha aleatória
    private fun generatePassword(length: Int, useUppercase: Boolean, useLowercase: Boolean, useNumbers: Boolean, useSpecial: Boolean, excludeSimilar: Boolean): String {
        val uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val lowercaseChars = "abcdefghijklmnopqrstuvwxyz"
        val numberChars = "0123456789"
        val specialChars = "!@#\$%^&*()-_+=<>?"
        var allowedChars = ""
        if (useUppercase) allowedChars += uppercaseChars
        if (useLowercase) allowedChars += lowercaseChars
        if (useNumbers) allowedChars += numberChars
        if (useSpecial) allowedChars += specialChars
        if (excludeSimilar) {
            allowedChars = allowedChars.replace(Regex("[Oo0Il1]"), "")
        }
        return (1..length)
            .map { allowedChars[Random.nextInt(allowedChars.length)] }
            .joinToString("")
    }
}
