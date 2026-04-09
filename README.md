# 📱 ConverterTabsJava_lab5

## 📝 Description du projet
**ConverterTabsJava_lab5** est une application Android native développée en Java. Elle propose un outil de conversion pratique divisé en plusieurs catégories. L'interface utilise une navigation moderne et fluide par balayage d'écran (Swipe) et par onglets.

L'application est structurée en deux sections principales :
1. **Thermique** : Interface dédiée aux conversions de températures (ex: Celsius vers Fahrenheit).
2. **Métrologie** : Interface dédiée aux conversions de distances et de mesures.

---

## ✨ Fonctionnalités Principales
* **Navigation par onglets (Tabs) :** Utilisation conjointe de `TabLayout` et `ViewPager2` pour une transition fluide entre les différentes pages de l'application.
* **Architecture par Fragments :** Séparation propre du code et de l'interface utilisateur grâce à l'utilisation de `TempFragment` et `DistanceFragment`.
* **Sécurité de navigation :** Interception intelligente du bouton "Retour" physique du smartphone via `OnBackPressedCallback`, affichant une boîte de dialogue de confirmation (`AlertDialog`) pour éviter de quitter l'application par erreur.
* **Menu contextuel (Action Bar) :** Présence d'un menu d'options en haut de l'écran permettant de se déconnecter/quitter l'application proprement.

---

## 🛠️ Technologies & Outils
* **Langage de programmation :** Java
* **Environnement (IDE) :** Android Studio
* **Configuration SDK :** * Compile SDK : 36
  * Min SDK : 24
  * Target SDK : 36
* **Composants UI (Material Design) :**
  * `androidx.appcompat:appcompat`
  * `com.google.android.material.tabs.TabLayout`
  * `androidx.viewpager2.widget.ViewPager2`

---

## 📂 Structure du Code
* `MainActivity.java` : Activité racine gérant l'initialisation du ViewPager, la liaison avec les onglets et la gestion du bouton de sortie.
* `ViewPagerAdapter.java` : Adaptateur sur-mesure permettant d'injecter les bons fragments dans le ViewPager en fonction de l'onglet sélectionné.
* `TempFragment.java` : Logique interne et gestion des événements pour la page des conversions thermiques.
* `DistanceFragment.java` : Logique interne et gestion des événements pour la page des conversions de métrologie.
* `res/layout/` : Dossier contenant les interfaces graphiques XML (`activity_main.xml`, layouts des fragments).

---
## 📸 Captures d'écran et Démo

### Démo Vidéo


### Captures d'écran
Voici un aperçu des deux onglets de l'application :

<img width="351" height="753" alt="image" src="https://github.com/user-attachments/assets/b40fe513-a443-44d5-90d0-a39ee332df55" />

<img width="176" height="365" alt="image" src="https://github.com/user-attachments/assets/a0e6716f-9d99-4dd1-b05e-73bc79f31e96" />


<img width="359" height="730" alt="image" src="https://github.com/user-attachments/assets/3429c084-8ca0-45e9-8797-2d25565d6d72" />

<img width="368" height="752" alt="image" src="https://github.com/user-attachments/assets/7438dbe3-a810-43c0-8735-270223903ae4" />


## 👤 Auteur

* **École Normale Supérieure de Marrakech**
  
* **Réalisé par :** SALMA LAKHAL
  
* **Filière  :** CLE_INFO_S5

  
* **Encadré par :** Pr. Mohamed LACHGAR

* **Module :** `Programmation Mobile : Android avec Java`
