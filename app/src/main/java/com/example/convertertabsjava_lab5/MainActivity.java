package com.example.convertertabsjava_lab5;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    // Déclaration des composants principaux de l'architecture
    private TabLayout systemeOnglets;
    private ViewPager2 visionneurFragments;
    private ViewPagerAdapter gestionnaireDeVues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciation via les nouveaux IDs uniques
        systemeOnglets = findViewById(R.id.bandeau_onglets_principal);
        visionneurFragments = findViewById(R.id.conteneur_pages_glissantes);

        // Application de notre adaptateur personnalisé
        gestionnaireDeVues = new ViewPagerAdapter(this);
        visionneurFragments.setAdapter(gestionnaireDeVues);

        // Mécanisme de liaison dynamique des titres
        new TabLayoutMediator(systemeOnglets, visionneurFragments,
                (cible, indexCourant) -> cible.setText(indexCourant == 0 ? "Thermique" : "Métrologie")
        ).attach();

        // Protection de la navigation physique du téléphone
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                genererAlerteFermeture();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 99, 0, "Quitter le programme");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 99) {
            genererAlerteFermeture();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Encapsulation de la logique de la boîte de dialogue
    private void genererAlerteFermeture() {
        new AlertDialog.Builder(this)
                .setTitle("Déconnexion")
                .setMessage("Voulez-vous clôturer cette session ?")
                .setPositiveButton("Affirmatif", (fenetre, action) -> finish())
                .setNegativeButton("Négatif", null)
                .show();
    }
}