package br.xpcriativa.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import br.xpcriativa.app.databinding.ActivityHomeBinding;
import br.xpcriativa.app.fragments.HomeFragment;
import br.xpcriativa.app.fragments.NewsFragment;
import br.xpcriativa.app.fragments.ProfileFragment;
import br.xpcriativa.app.fragments.SettingsFragment;

public class HomeActivity extends AppCompatActivity {
    private boolean isBackPressed = false;
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavView.setOnItemSelectedListener(item -> {

            switch(item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.news:
                    replaceFragment(new NewsFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.settings:
                    replaceFragment(new SettingsFragment());

            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if(isBackPressed){
            super.onBackPressed();
            finish();
        }
        Toast.makeText(this, "Pressione novamente para sair", Toast.LENGTH_SHORT).show();
        isBackPressed = true;

        new Handler(Looper.getMainLooper()).postDelayed(() -> isBackPressed = false, 3000);
    }
}