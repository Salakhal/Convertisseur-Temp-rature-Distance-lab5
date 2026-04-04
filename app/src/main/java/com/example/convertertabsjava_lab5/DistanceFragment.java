package com.example.convertertabsjava_lab5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Locale;

public class DistanceFragment extends Fragment {

    // Variables avec nomenclatures uniques
    private RadioButton btnModeK2M, btnModeM2K;
    private EditText champSaisieUtilisateur;
    private Button declencheurCalcul;
    private TextView zoneRendu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater constructeur,
                             @Nullable ViewGroup parent, @Nullable Bundle etatSauvegarde) {

        View structureFragment = constructeur.inflate(R.layout.fragment_distance, parent, false);

        // Mapping rigoureux avec l'interface XML
        btnModeK2M = structureFragment.findViewById(R.id.radio_kilo_vers_mile);
        btnModeM2K = structureFragment.findViewById(R.id.radio_mile_vers_kilo);
        champSaisieUtilisateur = structureFragment.findViewById(R.id.champ_entree_longueur);
        declencheurCalcul = structureFragment.findViewById(R.id.bouton_valider_longueur);
        zoneRendu = structureFragment.findViewById(R.id.texte_sortie_longueur);

        @SuppressLint("SetTextI18n")
        View.OnClickListener moteurMathematique = composant -> {
            String fluxEntrant = champSaisieUtilisateur.getText().toString().trim();

            if (fluxEntrant.isEmpty()) {
                Toast.makeText(getContext(), "Donnée manquante !", Toast.LENGTH_SHORT).show();
                return;
            }

            // AJOUT UNIQUE : Le même bloc sécurisé que pour la température
            try {
                double valeurNum = Double.parseDouble(fluxEntrant);
                double resultatMathematique;

                // On utilise un ratio légèrement plus précis pour se différencier
                final double RATIO_CONVERSION = 1.60934;

                if (btnModeK2M.isChecked()) {
                    resultatMathematique = valeurNum / RATIO_CONVERSION;
                } else {
                    resultatMathematique = valeurNum * RATIO_CONVERSION;
                }

                zoneRendu.setText("Bilan : " + String.format(Locale.US, "%.3f", resultatMathematique));

            } catch (NumberFormatException erreur) {
                Toast.makeText(getContext(), "Format invalide", Toast.LENGTH_LONG).show();
            }
        };

        declencheurCalcul.setOnClickListener(moteurMathematique);

        return structureFragment;
    }
}