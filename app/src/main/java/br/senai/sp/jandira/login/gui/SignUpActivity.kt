package br.senai.sp.jandira.login.gui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.rememberScrollState
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login.R
import br.senai.sp.jandira.login.model.User
import br.senai.sp.jandira.login.repository.UserRepository
import br.senai.sp.jandira.login.ui.theme.LoginTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContent {
            LoginTheme {

                var photUri by remember {
                    mutableStateOf<Uri?>(null)
                }

                var scrollState = rememberScrollState()

                var userNameState by rememberSaveable {
                    mutableStateOf("")
                }

                var phoneState by remember {
                    mutableStateOf("")
                }

                var passwordState by remember {
                    mutableStateOf("")
                }

                var emailState by remember {
                    mutableStateOf("")
                }

                var over18State by remember {
                    mutableStateOf(false)
                }

                val context = LocalContext.current



                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                    ) {

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.End
                        ) {
                            Card(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(50.dp),
                                shape = RoundedCornerShape(bottomStart = 28.dp),
                                backgroundColor = Color(207, 6, 240)
                            ) {}
                        }
                        Spacer(modifier = Modifier.height(21.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = stringResource(id = R.string.title_sing_up),
                                fontSize = 40.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(207, 6, 240)
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {

                            Text(
                                text = stringResource(id = R.string.create_account),
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Light,
                                color = Color(160, 156, 156)
                            )
                        }

                        Spacer(modifier = Modifier.height(21.dp))


                        Box(
                            modifier = Modifier.size(100.dp)
                            //contentAlignment = Alignment.BottomStart
                        ) {
                            Card(
                                modifier = Modifier.size(100.dp),
                                shape = CircleShape,
                                backgroundColor = Color.Yellow
                            ) {

                            }
                            Icon(
                                imageVector = Icons.Default.Place,
                                contentDescription = null,
                                modifier = Modifier.align(Alignment.BottomEnd)
                            )
                        }

                        Spacer(modifier = Modifier.height(35.dp))

                        Column(
                            modifier = Modifier
                                .height(height = 330.dp)
                                .verticalScroll(rememberScrollState())
                        )
                        {
                            OutlinedTextField(
                                value = userNameState,
                                onValueChange = { userNameState = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 17.dp, end = 17.dp),
                                shape = RoundedCornerShape(16.dp),
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(id = R.drawable.user),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .padding(start = 5.dp)
                                    )
                                },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Color(207, 6, 240),
                                    unfocusedBorderColor = Color(207, 6, 240)
                                )
                            )
                            OutlinedTextField(
                                value = phoneState,
                                onValueChange = { phoneState = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 20.dp, start = 17.dp, end = 17.dp),
                                shape = RoundedCornerShape(16.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(id = R.drawable.phone),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .padding(start = 5.dp)
                                    )
                                },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Color(207, 6, 240),
                                    unfocusedBorderColor = Color(207, 6, 240)
                                )
                            )
                            OutlinedTextField(
                                value = emailState,
                                onValueChange = { emailState = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 20.dp, start = 17.dp, end = 17.dp),
                                shape = RoundedCornerShape(16.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(id = R.drawable.email),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .padding(start = 5.dp)
                                    )
                                },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Color(207, 6, 240),
                                    unfocusedBorderColor = Color(207, 6, 240)
                                )
                            )
                            OutlinedTextField(
                                value = passwordState,
                                onValueChange = { passwordState = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 20.dp, start = 17.dp, end = 17.dp),
                                shape = RoundedCornerShape(16.dp),
                                visualTransformation = PasswordVisualTransformation(),
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(id = R.drawable.password),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .padding(start = 5.dp)
                                    )
                                },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Color(207, 6, 240),
                                    unfocusedBorderColor = Color(207, 6, 240)
                                )
                            )
                            Spacer(modifier = Modifier.height(21.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = over18State,
                                    onCheckedChange = { checked ->
                                        over18State = checked
                                    },
                                    modifier = Modifier
                                        .width(27.dp)
                                        .height(27.dp)
                                        .padding(start = 34.dp)
                                )
                                Text(
                                    text = stringResource(id = R.string.your_age),
                                    modifier = Modifier.padding(start = 29.dp),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Light
                                )
                            }

                            Spacer(modifier = Modifier.height(26.dp))



                            Spacer(modifier = Modifier.height(26.dp))

                            // ------------------

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Button(
                                    onClick = {
                                        saveUser(
                                            userNameState,
                                            phoneState,
                                            emailState,
                                            passwordState,
                                            over18State,
                                            context

                                            )
                                    },
                                    modifier = Modifier
                                        .height(48.dp)
                                        .width(327.dp),
                                    colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                                    shape = RoundedCornerShape(16.dp)
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.button_new_account),
                                        color = Color.White, fontSize = 15.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                }
                            }


                            Spacer(modifier = Modifier.height(21.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Text(
                                    text = stringResource(id = R.string.existing_account),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Light,
                                    color = Color(160, 156, 156)
                                )
                                Text(
                                    text = stringResource(id = R.string.button_login),
                                    Modifier
                                        .padding(end = 20.dp, start = 10.dp)
                                        .clickable {
                                            val intent = Intent(context, HomeActivity::class.java)
                                            context.startActivity(intent)
                                        },
                                    fontSize = 14.sp, color = Color(207, 6, 240)
                                )
                            }
                        }



                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.Bottom

                        ) {
                            Card(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(50.dp),
                                shape = RoundedCornerShape(topEnd = 28.dp),
                                backgroundColor = Color(207, 6, 240),
                            ) {

                            }
                        }
                    }
                }
            }
        }
    }

    private fun saveUser(
        userName: String,
        phone: String,
        email: String,
        password: String,
        isOver18: Boolean,
        context: Context
    ) {

        // Criando um objeto User
        val newUser = User(
            id = 0,
            userName = userName,
            phone = phone,
            email = email,
            password = password,
            isOver18 = isOver18
        )

        // Criando uma instância do repositório
        val userRepository = UserRepository(context)

        // Verificar se o usuário já existe
        val user = userRepository.findUserByEmail(email)
        Log.i("ds3m", "${user.toString()}")

//
        // Salvar o usúario
        if (user == null) {
            val id = userRepository.save(newUser)
            Toast.makeText(context, "Created User #$id", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "User already exists!", Toast.LENGTH_SHORT).show()

        }


    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    LoginTheme {
        Greeting2("Android")
    }
}
