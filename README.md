Serwis służy do zarządzania treścią blogów.
W domyślnym widoku http://localhost:4200/ możemy zobaczyć wszystkie zapisane dotychczas blogi.
W pasku nawigacji po lewej stronie możemy przejść do formularza tworzenia nowego bloga, w którym wypełniamy pola tytuł, treść oraz autora. Treść dodatkowo może być modyfikowana przez pogrubienie oraz podkreślenie tekstu, która jest zapisywana do bazy danych wraz z odpowiednimi znakami typu HTML, aby była możliwość wyświetlania danych zwrotnych w tym samym formacie co zostały wprowadzone.
Na liście każdy z "blogów" ma odnośnik zarówno do widoku edycji jak i widoku szczegółów bez edycji.

Testowane na: 
-Node v10.13.0
-Java 11.0.2

Aplikacja składająca się z części frontendowej(Angular 7) oraz backendowej(Java 11).

Aby uruchomić część frontendową należy:
-w terminalu przejść do katalogu "client"
-komenda "npm install" w celu zainstalowania odpowiednich bibliotek
-komenda "npm start" lub "ng serve" w celu włączenia aplikacji
-aplikacja domyślnie jest odpalana pod adresem: http://localhost:4200/

Aby uruchomić część backendową:
-w temrinalu przejść do katalogu "blogmanagement"
-komenda "mvn clean install"
-komenda "mvn spring-boot:run"
-API domyślnie wystawiane jest pod adresem: http://localhost:8080/

# Przed uruchomieniem części backendowej należy skonfigurować bazę danych.
Plik do konfiguracji znajduje się w katalogu: "/blogmanagement/src/main/resources/application.properties"
Domyślnie jest ustawiona lokalna baza danych MySql (localhost:3306) z bazą danych o nazwie "blog_db"
Pełny dostęp do tej bazy ma użytkownik: "username" z hasłem: "password"
