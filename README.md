

Password Generator App
This Android application generates secure passwords based on user-defined criteria. Users can customize the length and complexity of the generated password by selecting various options such as including uppercase letters, lowercase letters, numbers, and special characters.

Features
Customizable Password Length: Use a SeekBar to select the desired password length (1-20 characters).
Character Options: Choose to include:
Uppercase letters
Lowercase letters
Numbers
Special characters
Option to exclude similar characters (e.g., 'O', '0', 'I', '1')
Copy to Clipboard: Easily copy the generated password to the clipboard for use in other applications.
Screenshots
(You can add screenshots of your app here)

Requirements
Android Studio
Minimum SDK version: 21 (Lollipop)
Installation
Clone the repository:

https://github.com/JOSEEUSTAQUIOSILVERI0/app-senha.git

![image](https://github.com/user-attachments/assets/b7ea3584-4443-42af-8fba-76c8620ac8d6)

Open the project in Android Studio.

Build and run the application on an Android device or emulator.

Usage
Adjust the password length using the SeekBar.
Select the desired character options by checking the corresponding checkboxes.
Tap the "Gerar Senha" button to generate a password.
Tap the "Copia Senha" button to copy the generated password to your clipboard.
Code Overview
MainActivity.kt
The main activity contains the UI logic for generating passwords.
Uses Random to generate characters from user-selected sets.
Layout XML
Uses a LinearLayout to arrange the UI components vertically.
Includes TextView, SeekBar, CheckBox, and Button elements for user interaction.
