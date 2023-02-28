package br.xpcriativa.app;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ForgotPasswordActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        EditText inputField = findViewById(R.id.cellphoneFieldForgotPassword);
        inputField.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        Button recoverPassword = findViewById(R.id.buttonRecoverPassword);

        recoverPassword.setOnClickListener(v ->
                Toast.makeText(ForgotPasswordActivity.this, "Código de recuperação enviado", Toast.LENGTH_SHORT).show());
    }
}
