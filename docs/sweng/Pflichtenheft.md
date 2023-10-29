---
layout: default
title : Woche 6
---
# Pflichtenheft
#####  (Nach Lichter & Ludwig, Software Engineering: Grundlagen, Menschen, Prozesse, Techniken)


## 1. Einleitung

### 1.1 Zweck

JabRef kann den Abstract von Artikeln halten. Bei vielen Artikeln kann es schwierig werden, Übersicht zu behalten. Neu soll der Abstract in einem Satz zusammengefasst werden. 
Da man sich einsam fühlen kann, während dem man mit JabRef arbeitet, soll eine Chat-option für unterhaltung sorgen. 

### 1.2 Einsatzbereich und Ziele

Die Modifikation richtet sich an JabRef-User, die mit vielen Einträgen arbeiten und die Übersicht schnell verlieren. Die Modifikation richtet sich auch an diejenigen, die mit ChatGPT schrei

Neue Funktionen:

* Abstracts werden automatisch in einem Satz zusammengefasst.
* Integrierter zugang zu ChatGPT über ein Chat-Window.

### 1.3 Definitionen

| Begriff  	 | Bedeutung 	|
|------------|-----------	|
| API      	 |   Eine API ist eine Schnittstelle, die es unabhängigen Anwendungen ermöglicht, miteinander zu kommunizieren und Daten auszutauschen         	|
| Abstract 	 |   Unter dem englischen Begriff Abstract versteht man eine prägnante Zusammenfassung bzw. Inhaltsangabe, einen Abriss ohne Interpretation und Wertung einer wissenschaftlichen Arbeit|
| ChatGPT  	 |   ChatGPT ist ein Chatbot, der künstliche Intelligenz einsetzt, um mit Nutzern über textbasierte Nachrichten und Bilder zu kommunizieren         |

### 1.4 Referenzierte Dokumente

Verzeichnet alle Dokumente, auf die in der Spezifikation verwiesen wird.

Falls ein JabRef Issue bearbeitet wird, bitte diesen hier referenzieren und verlinken.

### 1.5 Überblick

Im folgenden Kapitel 2 wird die Spezifikation und ihre Einbettung ausführlicher Beschrieben. In Kapitel 3 werden alle
Anforderungen und die Erweiterung detailliert ausgeführt und in Kapitel 4 wird definiert was die Abnahmekriterien sind.

## 2. Allgemeine Beschreibung

### 2.1 Einbettung

ChatGPT 3.5-Turbo soll mittels API in Jabref eingebaut werden. 

### 2.2 Funktionen

Die Nutzer greifen auf die Funktionalität von Chat-GPT via GUI zu. 
Es kann mittels eines Buttons ein Chat-window geöffnet werden, welches unterhaltsame gespräche mit ChatGPT ermöglicht. 
Beim hinzüfügen eines Artikels soll ChatGPT automatisch den Abstract in einem Satz zusammenfassen.

### 2.3 Benutzerprofile

Alle Jabref Benutzer unabhänging vom Erfahrungslevel. 
Benutzer müssen sich mit der Englischen Sprache umgehen können

### 2.4 Einschränkungen
ür die Entwicklung ist JDK 18 und usere Erweiterung wird auf Englisch sein.
- Die Erweiterung soll keine zusätzlichen Anforderungen an die Hardwarespezifikation erzeugen.
- Die Erweiterung ist abhängig von der verwendeten ChatGPT API und der aktuellen ChatGPT Version. 
Ausserdem ist sie abhängig vom gegebenen Abstract der einzelnen Einträge

### 2.5 Annahmen und Abhängigkeiten
Abhängigkeiten: 
* Java 19.0.2+7
* ChatGPT 3.5-Turbo API

Die vorliegende Erweiterung soll keine zusätzlichen Anforderungen an die Hardwarespezifikation erzeugen.


## 3. Einzelanforderungen

Beschreibt die Anforderung i so genau, dass bei der Verwendung der Spezifikation (im Entwurf usw.) keine Rückfragen dazu notwendig sind.

Identifizieren Sie jede funktionale Anforderung mit einer Nummer, so dass diese Nachverfolgbar sind. Zusammengehörende Funktionale Anforderungen können durch geeignete Nummerierung angezeigt werden.

Zur Spezifikation der Software sollen Sprachschablonen benutzt werden.

* /F10/ Tab rechts von "Abstract" mit dem Namen "Summary" das ein neues Feld in JabRef öffnet.
* /F11/ Das Feld hat ein Text-feld in dem entweder nichts, oder ein einzelner Satz steht, der den Abstract zusammenfasst.
* /F12/ Rechts im unteren Feld, oberhalb vom "Change entry type" ist ein Button namens "Summarize".
* /F13/ Beim Betätigen des Buttons "summarize" wird der Abstract über die offizielle OpenAI API an ChatGPT geschickt, mit der Aufgabe den Abstract in einem Satz zusammenfassen. 
* /F14/ Der Output des API-calls von /F13/ wird im Feld von /F11/ dargestellt.
* /F20/ Oben rechts bei JabRef soll ein Button eingebettet werden mit der Aufschrift "Chatty".
* /F21/ Beim Klicken auf diesen Knopf öffnet sich ein Chat Fenster mit einem Textfeld.
* /F22/ Man kann im Textfeld schreiben und bei Klicken der "Enter"-Taste wird der Inhalt an ChatGPT geschickt.
* /F23/ Es kommt eine Antwort von ChatGPT als Chat-Nachricht zurück.

## 4. Abnahmekriterien

Definieren Sie hier mindestens ein Abnahmekriterium
* /A10/ Beim Klicken auf den "summarize" Button erscheint eine Zusammenfassung des Abstracts in einem Satz im "Summary" Tab.
* /A20/ Beim Klicken auf den Button "Chatty", öffnet sich ein Chat-window, indem man mit ChatGPT kommunizieren kann.ß

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
    * O.N. klickt auf den "summarize" Button (unten links, beim "Change entry type" Button)
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
* Vorbedingungen: Chatty benutzt JabRef. Beim Browsen seiner Bibliothek fällt ihm eine Frage ein, die er gerne von ChatGPT beantwortet hätte. Dafür möchte er nicht auf seinen Internetbrowser wechseln, sondern das in JabRef integrierte ChatWindow nutzen.
* Standardablauf
    * Chatty startet JabRef
    * Chatty fällt eine Frage ein und möchte diese von ChatGPT beantwortet kriegen.
    * Chatty klickt auf den "Chatty" Button oben rechts und ein Fenster öffnet sich.
    * Chatty schreibt seine Frage in das Fenster und drückt die "Enter"-Taste.
    * Chatty erhält eine Antwort von ChatGPT im Fenster.
* Nachbedingungen Erfolg: Chatty hat die gewünschte Antwort von ChatGPT erhalten.
