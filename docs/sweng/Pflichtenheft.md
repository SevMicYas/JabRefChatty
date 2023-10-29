---
## layout: default title : Woche 6
---
# Pflichtenheft: ChatGPT Einbindung
#####  (Nach Lichter & Ludwig, Software Engineering: Grundlagen, Menschen, Prozesse, Techniken)


## 1. Einleitung

### 1.1 Zweck

JabRef kann den Abstract von Artikeln speichern. Beim Arbeiten mit vielen Artikeln kann es schwierig werden, die Übersicht zu behalten. Neu soll der Abstract von ChatGPT in einem Satz zusammengefasst werden können, um eine schnelle Idee vom Inhalt des Artikels zu kriegen, ohne den ganzen Abstract lesen zu müssen. 
Eine Chat-Option mit ChatGPT soll auch eingebunden werden, um für Unterhaltung zu sorgen und schnelle Nachschlagehilfe zu leisten.

### 1.2 Einsatzbereich und Ziele

Die Modifikation richtet sich an JabRef-User, die mit vielen Einträgen arbeiten und die Übersicht schnell verlieren. Die Modifikation richtet sich auch an diejenigen, die mit ChatGPT schreiben möchten, oder eine Frage schnell beantwortet haben möchten. Potenzielles Einsatzgebiet sind also alle User von JabRef.

Neue Funktionen:

* Abstracts werden auf Knopfdruck in einem Satz zusammengefasst.
* Integrierter Zugang zu ChatGPT über ein Chat-Window.

### 1.3 Definitionen

| Begriff  	 | Bedeutung 	|
|------------|-----------	|
| API      	 |   Eine API ist eine Schnittstelle, die es unabhängigen Anwendungen ermöglicht, miteinander zu kommunizieren und Daten auszutauschen         	|
| Abstract 	 |   Unter dem englischen Begriff Abstract versteht man eine prägnante Zusammenfassung bzw. Inhaltsangabe, einen Abriss ohne Interpretation und Wertung einer wissenschaftlichen Arbeit|
| ChatGPT  	 |   ChatGPT ist ein Chatbot, der künstliche Intelligenz einsetzt, um mit Nutzern über textbasierte Nachrichten zu kommunizieren         |

### 1.4 Überblick

Im folgenden Kapitel 2 wird die Spezifikation und ihre Einbettung ausführlicher beschrieben. In Kapitel 3 werden alle
funktionalen Anforderungen an die Erweiterung detailliert ausgeführt und in Kapitel 4 wird definiert was die Abnahmekriterien sind.

## 2. Allgemeine Beschreibung

### 2.1 Einbettung

ChatGPT 3.5-Turbo soll mittels API in Jabref eingebaut werden. 

### 2.2 Funktionen

Die Nutzer greifen auf die Funktionalität von Chat-GPT via GUI zu. 
Es kann mittels eines Buttons ein Chat-Window geöffnet werden, welches unterhaltsame Gespräche mit ChatGPT ermöglicht. 
Beim Hinzüfügen eines Artikels soll ChatGPT via Knopfdruck den Abstract in einem Satz zusammenfassen.

### 2.3 Benutzerprofile

Alle Jabref Benutzer unabhänging vom Erfahrungslevel. 
Benutzer müssen sich mit der Englischen Sprache auskennen, da ChatGPT primär auf Englisch trainiert wurde, und andere Sprachen bisher nur als Vorschau verfügbar sind.

### 2.4 Einschränkungen
Für die Entwicklung verwenden wir JDK 19.
- Die Erweiterung soll keine zusätzlichen Anforderungen an die Hardwarespezifikation erzeugen.
- Die Erweiterung ist abhängig von der verwendeten ChatGPT API und der aktuellen ChatGPT Version. 
Ausserdem ist sie abhängig vom gegebenen Abstract der einzelnen Einträge.

### 2.5 Abhängigkeiten
Abhängigkeiten: 
* Java 19.0.2+7
* ChatGPT 3.5-Turbo API


## 3. Einzelanforderungen

* /F10/ Es muss ein Tab rechts von "Abstract" mit dem Namen "Summary" existieren.
* /F11/ Links im unteren Feld, oberhalb vom "Change entry type" Button muss ein neuer Button namens "Summarize" erstellt werden.
* /F12/ Beim Betätigen des Buttons "Summarize" soll der Abstract über die offizielle OpenAI API an ChatGPT geschickt werden, mit der Aufgabe den Abstract in einem Satz zusammenfassen. 
* /F13/ Der Output des API-calls soll im Tab "Summary" dargestellt werden.
* /F20/ Oben rechts bei JabRef muss ein Button eingebettet werden mit der Aufschrift "Chatty".
* /F21/ Beim Klicken auf diesen Knopf muss sich ein Chat Fenster mit einem Textfeld öffnen.
* /F22/ Man muss im Textfeld schreiben können und bei Klicken der "Enter"-Taste soll der Inhalt an ChatGPT geschickt werden.
* /F23/ Es soll eine Antwort von ChatGPT als Chat-Nachricht zurückgeschickt und angezeigt werden.

## 4. Abnahmekriterien

* /A10/ Beim Klicken auf den "Summarize" Button erscheint eine Zusammenfassung des Abstracts in einem Satz im "Summary" Tab, sofern der Abstract existiert.
* /A20/ Beim Klicken auf den Button "Chatty", öffnet sich ein Chat-window, in dem man mit ChatGPT kommunizieren kann.

# Anhang

## Anhang A. Use-cases

### Use Case 1:
* Name: Durchschnittlicher User
* Akteure: Otto Normal (O.N.)
* Vorbedingungen: Otto Normal benutzt JabRef. Er hat kein Interesse daran, ChatGPT zu nutzen, sondern will JabRef 'normal' benutzen. Er möchte jedoch nicht jedes Mal den kompletten Abstract lesen müssen, um eine Vorstellung vom Inhalt des Artikels zu kriegen, aber trotzdem etwas mehr Informationen dazu erhalten, um einen Kurzüberblick über die Thematik des Artikels zu erlangen.
* Standardablauf
    * O.N. startet JabRef
    * O.N. wählt einen Eintrag in seiner Bibliothek aus
    * O.N. klickt auf das "Summary" Tab (neben "Abstract" Tab)
    * O.N. klickt auf den "Summarize" Button (unten links, beim "Change entry type" Button)
* Nachbedingungen Erfolg: O.N. liest die Zusammenfassung des Abstracts in einem Satz.
* Nachbedingung Sonderfall 1a: Das Feld ist leer.
* Nachbedingung Sonderfall 1b: O.N. liest die Zusammenfassung des Abstracts in einem Satz.


#### Sonderfall 1a: Ausnahme 1
Wenn der Artikel keinen Abstract hat; beziehungsweise ein Eintrag ohne Abstract hinzugefügt wurde, bleibt das Feld leer (Analog zum "Abstract" Feld).
#### Sonderfall 1b: Ausnahme 2
Falls O.N. die Schritte (3) und (4) im obigen Ablauf vertauscht, also zuerst auf den "Refresh" Button und danach auf das "Summary" Tab klickt, erscheint ebenfalls die Zusammenfassung.

### Use Case 2:
* Name: ChatGPT User
* Akteure: Chatty
* Vorbedingungen: Chatty benutzt JabRef. Beim Browsen seiner Bibliothek fällt ihm eine Frage ein, die er gerne von ChatGPT beantwortet hätte. Dafür möchte er nicht auf seinen Internetbrowser wechseln, sondern das in JabRef integrierte Chat-Window nutzen.
* Standardablauf
    * Chatty startet JabRef
    * Chatty fällt eine Frage ein und möchte diese von ChatGPT beantwortet kriegen.
    * Chatty klickt auf den "Chatty" Button oben rechts und ein Fenster öffnet sich.
    * Chatty schreibt seine Frage in das Fenster und sendet seine Frage an ChatGPT.
    * Chatty erhält eine Antwort von ChatGPT im Fenster.
* Nachbedingungen Erfolg: Chatty hat die gewünschte Antwort von ChatGPT erhalten.
