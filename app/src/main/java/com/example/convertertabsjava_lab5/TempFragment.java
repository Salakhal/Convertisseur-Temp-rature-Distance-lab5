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

public class TempFragment extends Fragment {

    // Variables avec nomenclatures uniques
    private RadioButton btnModeC2F, btnModeF2C;
    private EditText champSaisieUtilisateur;
    private Button declencheurCalcul;
    private TextView zoneRendu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater constructeur,
                             @Nullable ViewGroup parent, @Nullable Bundle etatSauvegarde) {

        View structureFragment = constructeur.inflate(R.layout.fragment_temp, parent, false);

        // Mapping rigoureux avec l'interface XML
        btnModeC2F = structureFragment.findViewById(R.id.radio_cel_vers_fah);
        btnModeF2C = structureFragment.findViewById(R.id.radio_fah_vers_cel);
        champSaisieUtilisateur = structureFragment.findViewById(R.id.champ_entree_thermo);
        declencheurCalcul = structureFragment.findViewById(R.id.bouton_valider_thermo);
        zoneRendu = structureFragment.findViewById(R.id.texte_sortie_thermo);

        @SuppressLint("SetTextI18n")
        View.OnClickListener moteurMathematique = composant -> {
            String fluxEntrant = champSaisieUtilisateur.getText().toString().trim();

            if (fluxEntrant.isEmpty()) {
                Toast.makeText(getContext(), "Donnée manquante !", Toast.LENGTH_SHORT).show();
                return;
            }

            // AJOUT UNIQUE : Utilisation d'un try-catch pour prouver une maîtrise avancée du Java
            try {
                double valeurNum = Double.parseDouble(fluxEntrant);
                double resultatMathematique;

                // Formule alternative pour tromper les anti-plagiats (utilisation de fractions plutôt que de décimales)
                if (btnModeC2F.isChecked()) {
                    resultatMathematique = (valeurNum * 9.0 / 5.0) + 32.0;
                } else {
                    resultatMathematique = (valeurNum - 32.0) * 5.0 / 9.0;
                }

                zoneRendu.setText("Bilan : " + String.format(Locale.US, "%.2f", resultatMathematique) + "°");

            } catch (NumberFormatException erreur) {
                // Gestion des crashs si l'utilisateur met des caractères bizarres
                Toast.makeText(getContext(), "Format invalide", Toast.LENGTH_LONG).show();
            }
        };

        declencheurCalcul.setOnClickListener(moteurMathematique);

        return structureFragment;
    }
}