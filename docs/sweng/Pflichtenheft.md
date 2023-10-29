---
layout: default
title : Woche 6
---
# Pflichtenheft
#####  (Nach Lichter & Ludwig, Software Engineering: Grundlagen, Menschen, Prozesse, Techniken)


## 1. Einleitung

### 1.1 Zweck

Beschreibt den Zweck und den Leserkreis der Spezifikation.

### 1.2 Einsatzbereich und Ziele
Gibt an, wo die Software eingesetzt werden soll und welche wesentlichen Funktionen es haben wird. Wo sinnvoll, sollte auch definiert werden, was die Software nicht leisten wird.

Beschreibt die mit der Software verfolgten Ziele.

### 1.3 Definitionen

Dokumentiert alle verwendeten Fachbegriffe und Abkürzungen. Alternativ können Sie auch ein separates Glossar nutzen.

### 1.4 Referenzierte Dokumente

Verzeichnet alle Dokumente, auf die in der Spezifikation verwiesen wird.

Falls ein JabRef Issue bearbeitet wird, bitte diesen hier referenzieren und verlinken.

### 1.5 Überblick

Beschreibt, wie der Rest der Spezifikation aufgebaut ist, insbesondere, wie Kapitel 3 strukturiert ist.

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
???


## 3. Einzelanforderungen

Beschreibt die Anforderung i so genau, dass bei der Verwendung der Spezifikation (im Entwurf usw.) keine Rückfragen dazu notwendig sind.

Identifizieren Sie jede Funktionale Anforderung mit einer Nummer, so dass diese Nachverfolgbar sind. Zusammengehörende Funktionale Anforderungen können durch geeignete Nummerierung angezeigt werden.

Zur Spezifikation der Software sollen Sprachschablonen benutzt werden.

* /F10/ Funktion 1 des Systems
* /F11/ Weitere Detaillierung Funkion 1
* /F20/ Funktion 2 des Systems


Die Funktionalen Anforderungen sollen mithilfe von Use-cases erhoben werden. Die Use-cases sollen in Anhang A detailliert beschrieben werden.

## 4. Abnahmekriterien

Beschreiben Sie hier, wie die Anforderungen bei der Abnahme auf ihre Realisierung überprüft werden können.

Definieren Sie hier mindestens ein Abnahmekriterium
* /A10/ Abnahmekriterium 1
* /A20/ Abnahmekriterium 2


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
    * Chatty klickt auf den "ChatGPT" Button oben rechts und ein Fenster öffnet sich.
    * Chatty schreibt seine Frage in das Fenster und drückt die "Enter"-Taste.
    * Chatty erhält eine Antwort von ChatGPT im Fenster.
* Nachbedingungen Erfolg: Chatty hat die gewünschte Antwort von ChatGPT erhalten.
* Nachbedingung Sonderfall: - ?
