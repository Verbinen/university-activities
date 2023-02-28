package br.xpcriativa.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import br.xpcriativa.app.DAO.UserDAO;

public class CreateUserActivity extends Activity {

    private String email;
    private String password;
    private String password2;
    private UserDAO userDAO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        Button createUser = findViewById(R.id.buttonCreateUser);

        createUser.setOnClickListener(v -> {
            email = ((TextView) findViewById(R.id.editTextEmail_CreateUser)).getText().toString();
            password = ((TextView) findViewById(R.id.editTextFirstPassword_CreateUser)).getText().toString();
            password2 = ((TextView) findViewById(R.id.editTextSecondPassword_CreateUser)).getText().toString();

            User user = new User();
            userDAO = new UserDAO(CreateUserActivity.this);

            if (!isPasswordEqual(password, password2))
                Toast.makeText(CreateUserActivity.this, "Senhas não coincidem", Toast.LENGTH_SHORT).show();
            else if (email.isEmpty() || password.isEmpty() || password2.isEmpty())
                Toast.makeText(CreateUserActivity.this, "Peencha todos os campos", Toast.LENGTH_SHORT).show();
            else if(userDAO.hasUser(email))
                Toast.makeText(CreateUserActivity.this, "Email já existe", Toast.LENGTH_SHORT).show();
            else{
                user.setEmail(email);
                user.setPassword(password);
                userDAO.insertUser(user);

                Toast.makeText(CreateUserActivity.this, "Conta criada com Sucesso", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(this, FormActivity.class));
                finish();
            }
        });

        TextView signIn = findViewById(R.id.textViewDoLogin);

        signIn.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });

    }

    private boolean isPasswordEqual(String pwd, String pwd2){
        return pwd.equals(pwd2);
    }
}
