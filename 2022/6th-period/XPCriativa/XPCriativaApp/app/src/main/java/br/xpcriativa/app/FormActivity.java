package br.xpcriativa.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.beardedhen.androidbootstrap.BootstrapProgressBar;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;

public class FormActivity extends Activity {
    private Boolean[] checkedArray;
    private BootstrapProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        TypefaceProvider.registerDefaultIconSets();
        
        

        checkedArray = new Boolean[10];

        progressBar = findViewById(R.id.progressBar);

        RadioGroup radioGroup = findViewById(R.id.rdgroup_FirstQ);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedArray[0] == null) {
                progressBar.setProgress(progressBar.getProgress() + 10);
                checkedArray[0] = true;
                changeProgressBarColor();
            }
        });

        RadioGroup radioGroup2 = findViewById(R.id.rdgroup_SecondQ);
        radioGroup2.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedArray[1] == null) {
                progressBar.setProgress(progressBar.getProgress() + 10);
                checkedArray[1] = true;
                changeProgressBarColor();
            }
        });

        RadioGroup radioGroup3 = findViewById(R.id.rdgroup_ThirdQ);
        radioGroup3.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedArray[2] == null) {
                progressBar.setProgress(progressBar.getProgress() + 10);
                checkedArray[2] = true;
                changeProgressBarColor();
            }
        });

        RadioGroup radioGroup4 = findViewById(R.id.rdgroup_FourthQ);
        radioGroup4.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedArray[3] == null) {
                progressBar.setProgress(progressBar.getProgress() + 10);
                checkedArray[3] = true;
                changeProgressBarColor();
            }
        });

        RadioGroup radioGroup5 = findViewById(R.id.rdgroup_FifthQ);
        radioGroup5.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedArray[4] == null) {
                progressBar.setProgress(progressBar.getProgress() + 10);
                checkedArray[4] = true;
                changeProgressBarColor();
            }
        });

        RadioGroup radioGroup6 = findViewById(R.id.rdgroup_SixthQ);
        radioGroup6.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedArray[5] == null) {
                progressBar.setProgress(progressBar.getProgress() + 10);
                checkedArray[5] = true;
                changeProgressBarColor();
            }
        });

        RadioGroup radioGroup7 = findViewById(R.id.rdgroup_SeventhQ);
        radioGroup7.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedArray[6] == null) {
                progressBar.setProgress(progressBar.getProgress() + 10);
                checkedArray[6] = true;
                changeProgressBarColor();
            }
        });

        RadioGroup radioGroup8 = findViewById(R.id.rdgroup_EighthQ);
        radioGroup8.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedArray[7] == null) {
                progressBar.setProgress(progressBar.getProgress() + 10);
                checkedArray[7] = true;
                changeProgressBarColor();
            }
        });

        RadioGroup radioGroup9 = findViewById(R.id.rdgroup_NinethQ);
        radioGroup9.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedArray[8] == null) {
                progressBar.setProgress(progressBar.getProgress() + 10);
                checkedArray[8] = true;
                changeProgressBarColor();
            }
        });

        RadioGroup radioGroup10 = findViewById(R.id.rdgroup_TenthQ);
        radioGroup10.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedArray[9] == null) {
                progressBar.setProgress(progressBar.getProgress() + 10);
                checkedArray[9] = true;
                changeProgressBarColor();
            }
        });

        Button button = findViewById(R.id.buttonForm);

        button.setOnClickListener(v -> {
            if(isProgressBarComplete()){
                startActivity(new Intent(this, HomeActivity.class));
                finish();
            }
            else
                Toast.makeText(this, "Calma lá, você deve responder todas as perguntas primeiro!", Toast.LENGTH_LONG).show();
        });
    }

    public void changeProgressBarColor(){
        if(isProgressBarComplete())
            progressBar.setBootstrapBrand(DefaultBootstrapBrand.SUCCESS);
    }

    public boolean isProgressBarComplete(){
        return progressBar.getProgress() == 100;
    }

    public void isRadioButtonCLicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_First_yes:
                if (checked)

                    break;
            case R.id.radio_First_no:
                if (checked)

                    break;
        }
    }

}
