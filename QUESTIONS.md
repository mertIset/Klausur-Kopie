# Klausurfragen

### Name und Matrikelnummer 
^-- Bitte eintragen und 1. Commit pushen, 2. Commit spätestens nach 30 Minuten pushen, sonst Punktabzug!

## Fragen zum Code (je 6 Punkte)

[1] Listen Sie alle Vue-Komponenten im Projekt auf, die Props definieren und/oder Vue-Lifecycle-Funktionen (lifecycle hooks) implementieren.
    Welche Komponente definiert welche Props und welchen Lifecycle Hook?

[2] Wie wird realisiert, dass man auf der `Admin Console`-Seite den Text eines neuen Spruchs eingeben kann und dieser im Backend gespeichert wird?
    Nennen Sie mindestens drei Code-Stellen in unterschiedlichen Dateien.

[3] Wenn man auf der Hauptseite (die mit Chuck Norris) auf den Link `Admin Console` klickt, wird die Seite gewechselt und oben der Titel "Hier kannst Du Sprüche hinzufügen, bearbeiten ..." angezeigt.
    Nennen Sie Stellen in mindestens drei Dateien, die diesen Seitenwechsel und dann die Darstellung dieses Titels implementieren.

[4] Wie wird in der `AdminTable.vue` sichergestellt, dass Edit-Buttons deaktiviert werden bzw. der angeklickte Button verschwindet, sobald für einen Spruch "Edit" gewählt wurde? 
    Nennen Sie die drei dafür zuständigen Mechanismen.

[5] Was müssten Sie in diesem Projekt hinzufügen, um mittels JPA eine Verbindung mit einer Postgres-Datenbank herzustellen und Objekte der Klasse `QuoteResponse` darin speichern zu können?
    Nennen Sie Änderungen an mindestens drei Dateien.

[6] Wo im Projekt wird definiert, auf welchem Port das Frontend im Entwicklungsmodus geserved wird? 
    Wo wird definiert, dass das Frontend auf das Backend zugreifen darf, obwohl es von einem anderen 'Ort' ausgeliefert wurde als das Backend? 
    Wie nennt man die Technik für eine solche Erlaubnis?

[7] Wie könnten Sie die Bibliothek Bootstrap zu diesem Projekt hinzufügen? Was müssten Sie wo in welche Datei hinzufügen?
    Wie könnten Sie die Bibliothek Okta Spring Boot Starter zu diesem Projekt hinzufügen? Was müssten Sie wo in welche Datei hinzufügen?
    In welcher Datei müssten Sie welche Änderungen vornehmen, um zu verhindern, dass IDE-Konfigurationen (z.B. IntelliJ) in das Git-Repository gelangen?

## Theoretische Fragen (je 3 Punkte) - maximal DREI Sätze pro Antwort, sonst Punktabzug!

[1] Wo schauen Sie zuerst nach, wenn in Ihrem Projekt ein HTTP-Fehler der 5xx-Kategorie auftritt und wo, wenn ein Fehler der 4xx-Kategorie auftritt?

[2] Definieren Sie in JavaScript ein Objekt, welches ein Attribut `name` mit dem Wert `test` und ein Attribut `price` mit dem Wert `42` beinhaltet.

[3] Illustrieren Sie den Unterschied zwischen Path-Parameter und Query-Parameter (auch Request-Parameter genannt): 
    Wie sieht jeweils (also einmal als Path-Parameter und einmal als Query-Parameter) die Request-URL aus, wenn an 
    die Route `example.com/route` eine Anfrage mit einem Attribut `id` und einem dazugehörigen Wert `123` gesendet werden soll?

[4] Wie können Sie verhindern, dass in Konfigurationsdateien sensible Daten wie Passwörter im Klartext bei GitHub/GitLab gespeichert werden?

[5] Warum ist es sinnvoll, beim Testen einer Methode abhängige Objekte, wie bspw. eine Datenbankanbindung, zu mocken?

[6] Bei einer Anwendung mit dem Stack Vue.js, Spring Boot und PostgreSQL: In welchen Formaten wird eine Entität auf den einzelnen Schichten repräsentiert?