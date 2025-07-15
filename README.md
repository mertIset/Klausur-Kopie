[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/fK60bGKS)
# Klausur Webtechnologien SoSe 2025

Die Klausur besteht aus zwei Teilen: einem praktischen und einem theoretischen Teil. Für 100% (also Note 1,0) müssen Sie 120 Punkte erreichen.
Sie haben insgesamt 90 Minuten Zeit für die Bearbeitung, massgeblich ist der Zeitstempel des entsprechenden Commits.
Sie müssen Ihre Abgabe auf mindestens vier Commits aufteilen (z.B. 1x zu Beginn, 1x nach 30min, 1x nach 60min, 1x nach 90min), ansonsten gibt es Punktabzug von bis zu 20 Punkten.
Es handelt sich um eine Open-Book-Klausur, Sie müssen jedoch nicht offensichtliche Quellen ausreichend kennzeichnen und dürfen keine fremde Leistung als Ihre eigene darstellen.
Füllen Sie daher bitte zuerst die Datei [ERKLAERUNG.md](ERKLAERUNG.md) aus, bevor Sie mit der Bearbeitung der Klausur beginnen.
Bei der Verwendung von ChatGPT o.Ä. müssen Sie dies dokumentieren, am besten, indem Sie am Ende den gesamten Chatverlauf in die Datei [KI-CHATVERLAUF.md](KI-CHATVERLAUF.md) kopieren.
Bei der Verwendung von Co-Pilot etc. müssen Sie dokumentieren, wo Ihnen welche Code-Zeilen vorgeschlagen wurden.

## Theoretischer Teil (60 Punkte)

Beantworten Sie die Fragen, die Sie in der Datei [QUESTIONS.md](QUESTIONS.md) finden. 
Die Fragen beziehen sich größtenteils auf den Code in diesem Repository.
Schreiben Sie Ihre Antworten direkt in diese Datei unter die jeweilige Frage.
Wenn sinnvoll, schreiben Sie Freitext, jedoch höchstens drei Sätze pro Frage (in der Regel weniger).
Bei manchen Fragen ist eine Beantwortung als Auflistung sinnvoller, aber achten Sie hier darauf, dass es unmissverständlich ist, was Sie auflisten.
Reichen Sie das Ergebnis per Git Commit & Push ein. 

## Praktischer Teil (60 Punkte)

Im praktischen Teil geht es darum eine Admin-Seite für die Chuck-Norris App zu weiterzuentwickeln, mit der man Sprüche hinzufügen, bearbeiten, und sortieren kann.

### Voraussetzungen und Setup

Zur Bearbeitung dieser Aufgabe wird folgende Software benötigt:

- Java 21
- gradle 8.x
- node 22.x
- npm 11.x

#### Backend und Frontend starten

- Starten Sie die Spring Boot Anwendung, z.B. in IntelliJ durch Rechtsklick auf `ChucknorrisQuotesApplication` und dann `Run ...`

- Starten Sie die Vue App. Führen Sie dazu im Terminal, ausgehend vom Projektverzeichnis, folgende Befehle sequentiell aus:

```shell
cd frontend
npm install
npm run dev
```

- Navigieren Sie in Ihrem Browser zur Adresse [`http://localhost:3000`](http://localhost:3000) um die Startseite aufzurufen und schauen Sie sich dann die Seite "Admin Console" an.

### Aufgabe 1: Server-seitige Speicher-Funktionalität fertigstellen (16 Punkte)

1. Fügen Sie in der Test-Klasse `QuotesServiceImplTest` zwei Testfälle hinzu, welche die bereits existierende Methode `addQuote(index, quote)` in der Klasse `QuotesServiceImpl` testen:
   - Ein Testfall sollte u.a. sicherstellen, dass sich die Gesamtzahl der Sprüche sich erhöht, wenn ein neuer Spruch hinzugefügt wurde.
   - Ein Testfall sollte u.a. sicherstellen, dass man keinen Spruch an einer unerlaubten Position (z.B. negativ) einfügen kann.

2. Fügen Sie im `QuoteController` eine neue Route zum Speichern von neuen Sprüchen hinzu. 
   - Der Endpunkt soll unter `/api/v1/quote` und via `POST` erreichbar sein (so wie in `AdminTable.vue` in der Methode `save` aufgerufen).
   - Der zu speichernde Spruch soll als `RequestBody` im JSON-Format übermittelt werden, die Indexposition muss als Pfadparameter (`PathVariable`) übermittelt werden.
   - Die Struktur des übermittelten JSON-Objekts entspricht dabei der Backend-Klasse `QuoteResponse`.
   - Der Controller nutzt die zuvor getestete Service-Methode `addQuote` - dadurch sollte der Testfall `testPostRoute` im `QuoteControllerTest` grün werden.

### Aufgabe 2: Bearbeitungsfunktionalität implementieren (32 Punkte)

1. Implementieren Sie in der Klasse `QuotesServiceImpl` die Methode `updateQuote` so wie im JavaDoc im dazu passenden Interface `QuotesService` beschrieben. Dadurch sollte der entsprechende Testfall im `QuotesServiceImplTest` grün werden.

2. Fügen Sie im `QuoteController` eine neue Route zum Bearbeiten von Sprüchen hinzu.
   - Der Endpunkt soll unter `/api/v1/quote` und via `PUT` erreichbar sein.
   - Der Index des zu bearbeitenden Spruchs soll als Request-Parameter (`RequestParam`) namens `index`, also z.B. `/api/v1/quote?index=53`, übermittelt werden; der Text als `RequestBody` im JSON-Format.
   - Die Struktur des übermittelten JSON-Objekts entspricht dabei der Backend-Klasse `UpdatableQuote`.
   - Der Controller nutzt die zuvor implementierte Service-Methode `updateQuote` - dadurch sollte der Testfall `testUpdateRoute` im `QuoteControllerTest` grün werden.

3. Fügen Sie in der Vue-Komponente `AdminTable.vue` eine Methode `updateQuote(index, newText)` hinzu, welche die zuvor definierte PUT-Route aufruft (mit `index` Query-Parameter und einem JSON-Body mit dem neuen Text) und bei Erfolg den Wert von `editQuoteIndex` auf `-1` setzt.

4. Nach dem Klicken auf "Edit" verschwindet der Button beim jeweiligen Spruch und alle anderen Buttons werden deaktiviert. Fügen Sie in der Tabelle in der Vue-Komponente `AdminTable.vue` einen Button "Update" hinzu, der dann angezeigt wird, wenn der jeweilige Spruch in Bearbeitung ist.
   - Ein Klick auf diese Buttons ruft die Methode `updateQuote` mit dem jeweiligen Index und dem Text des zu bearbeitenden Spruchs auf.
   - Der neue Button muss eine ID `save-edit` haben.
   - Stellen Sie sicher, dass das generierte Button-Element nur dann angezeigt wird, wenn der aktuelle `editQuoteIndex` dem Index des Spruchs entspricht - dadurch sollte der Testfall `should update a quote in the backend` in `AdminTable.spec.js` grün werden.

### Aufgabe 3: Client-seitige Sortierfunktionalität implementieren (12 Punkte)

1. Machen Sie in der Komponente `AdminTable.vue` die Überschriften `Index` und `Quote` klickbar (z.B. als Buttons), sodass ein Klick auf die jeweilige Überschrift die Tabelle anhand dieses Kriteriums sortiert (Index: Sortierung nach Zahl, Quote: alphabetische Sortierung).

2. Fügen Sie dafür eine Methode `sortQuotesBy(index oder quote)` hinzu, die dafür sorgt, dass die Sprüche anhand des gewählten Kriteriums sortiert und angezeigt werden. Hinweis: eine Sortierfunktion ist in JavaScript bereits eingebaut: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/sort#sorting_array_of_objects
