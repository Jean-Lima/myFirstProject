package com.example.aula

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.include_toolbar.*

class RegisterActivity : AppCompatActivity() {
    var language: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "CADASTRO"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(getDrawable(R.drawable.background_toolbar))

        initButton()

        initSpinner()

    }

    private fun initButton() {
        registerButton.setOnClickListener {
            ValidateFields()
        }
    }

    private fun ValidateFields() {

        var fullName: String? = fullNameInput.text.toString()
        var gender: String? = if (!maleRadioButton.isChecked) "Masculino" else "Feminino"
        var bday: String? = dateInput.text.toString()
        var user: String? = userInput.text.toString()
        var password: String? = passwordInput.text.toString()
        var confirmPassword: String? = confirmPasswordInput.text.toString()
        var email: String? = emailInput.text.toString()
        var cpf: String? = cpfInput.text.toString()

        if (password != confirmPassword) {
            return errorDialog("As senhas devem combinar")
        }

        if (password.isNullOrEmpty()) {
            return errorDialog("Senha obrigatória")
        }

        if (fullName.isNullOrEmpty()) {
            return errorDialog("Nome obrigatório")
        }

        if (!maleRadioButton.isChecked && !femaleRadioButton.isChecked) {
            return errorDialog("Gênero obrigatório")
        }

        if (bday.isNullOrEmpty()) {
            return errorDialog("Data obrigatória")
        }

        if (user.isNullOrEmpty()) {
            return errorDialog("Usuário obrigatório")
        }

        if (email.isNullOrEmpty()) {
            return errorDialog("Email obrigatório")
        }

        if (cpf.isNullOrEmpty()) {
            return errorDialog("CPF obrigatório")
        }

        createUser(fullName, gender!!, bday, user, password, email, cpf, language)

    }

    private fun createUser(
        fullName: String,
        gender: String,
        bday: String,
        user: String,
        password: String,
        email: String,
        cpf: String,
        language: String?
    ) {
        UserModel(fullName, gender, bday, user, password, email, cpf, language)

        errorDialog("$fullName \n$gender \n$bday \n$user \n$password \n$email \n$cpf \n$language")
    }


    private fun errorDialog(msg: String) {
        AlertDialog.Builder(this)
            .setTitle("Erro")
            .setMessage(msg)
            .setNegativeButton("OK", null)
            .create()
            .show()
    }

    private fun initSpinner(){
        val languages = arrayOf(
            "Portugues",
            "Ingles",
            "Espanhol"
        )

        spinnerLanguage.adapter = ArrayAdapter (
            this,
            android.R.layout.simple_spinner_item,
            languages
        )

        spinnerLanguage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                language = languages[position]
            }

        }

    }

}
