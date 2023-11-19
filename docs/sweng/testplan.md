---
layout: default
title : Woche 6
---
# Testplan

| Version | Projektname | Autor                          | Status | Datum      | Kommentar |
|---------|-------------|--------------------------------| ------ |------------| --------- |
| 1.0     | Chatty      | Severin M., Yash T., Michel R. | in Bearbeitung | 19.11.2023 | |


# 1. Einführung

Bei unserem Feature handelt es sich um eine Erweiterung von JabRef um die ChatGPT API.
Dabei stehen hauptsächlich folgende zwei Funktionen im Fokus:
Die Abstracts sollen, wo vorhanden, via Knopfdruck von ChatGPT zusammengefasst werden können.
Und der Benutzer soll die Möglichkeit haben, über ein integriertes ChatWindow direkt wie gewohnt mit ChatGPT schreiben zu können.

## 1.1 Zweck

Dieses Dokument ist eine Spezifikation aller im Rahmen des Projekts durchzuführenden Tests.
Es richtet sich primär an die Autoren selbst und an die Betreuungspersonen.

## 1.2 Beziehung zu anderen Dokumenten

Dieses Dokument bezieht sich auf unser [Pflichtenheft](https://github.com/smemmishofer/jabref/blob/requirements/docs/sweng/Pflichtenheft.md)
und die [Technische Dokumentation](https://github.com/smemmishofer/jabref/blob/technical-doc/docs/sweng/tech-doc.md).
Diese können zur weiteren Erklärung im Falle von Unklarheiten bezüglich spezifischer Details der Tests beigezogen werden.

## 2. Systemübersicht

Im Rahmen unserer Erweiterung fügen wir drei neue Funktionen zu JabRef hinzu, welche getestet werden sollen.
1. Der User kann über das Menu `Tools -> Set API-key` einen API-key für ChatGPT hinterlegen. Dieser soll beim Schliessen von JabRef gespeichert werden für das nächste Mal. Falls kein gültiger API-key hinterlegt ist, oder keine aktive Internetverbindung besteht, wird bei jedem Versuch, die ChatGPT Funktionalität zu nutzen, eine Fehlermeldung ausgegeben.
2. Sofern ein Abstract im ausgewählten Artikel vorhanden ist, und alle Bedingungen (gültiger API-key; aktive Internetverbindung) erfüllt sind, kann der User mittels Betätigen des `Summarize` Buttons eine Zusammenfassung des Abstracts von ChatGPT anfordern, welche im `Summary`-Tab dargestellt wird.
3. - Sofern alle Bedingungen (gültiger API-key; aktive Internetverbindung) erfüllt sind, kann der Benutzer mittels Drücken des `Chatty`-Buttons ein ChatWindow mit ChatGPT öffnen und darin ChatGPT wie gewohnt verwenden; wobei der Kontext des Gesprächs gespeichert wird, solange das Fenster offen bleibt.
   - Beim Drücken des `Copy`-Buttons im ChatWindow wird die letzte Antwort von ChatGPT in die Zwischenablage kopiert.

Für weitere Informationen, Siehe Dokumente unter Abschnitt `1.2`.

## 3. Merkmale

### 3.1 Zu testende Merkmale (Features / Funktionen)

#### 3.1.1 Funktionale Anforderungen

Es sollen alle im [Pflichtenheft](https://github.com/smemmishofer/jabref/blob/requirements/docs/sweng/Pflichtenheft.md)
spezifizierten funktionalen Anforderungen getestet werden.

### 3.2 Nicht zu testende Merkmale (Features / Funktionen)

Welche Aspekte werden explizit nicht getestet? Bitte begründen weshalb nicht.

## TODO!!!

## 4 Vorgehensweise

### 4.1 Modul und Integrationstests

Unsere Erweiterung werden wir, wo immer möglich, mittels Unit-Tests testen. 
Aufgrund der Natur unserer Erweiterung, die relativ GUI-zentrisch ist, werden wir für die GUI-Funktionen auch manuelle Tests durchführen.
Die Unit-Tests sind im Abschnitt `6` näher beschrieben. Durch die relativ isolierte Natur unserer Erweiterung sollte es bei der Integration in JabRef
keine grösseren Schwierigkeiten geben. Die Integration wird mit den eigenen Tests in Kombination mit den bestehenden JabRef Tests getestet.
Durch unsere Erweiterung sollten keine Tests neu fehlschlagen, die vorher funktioniert haben.

### 4.2 Funktionstest

Die funktionalen Anforderungen werden primär über das GUI manuell getestet. Siehe Abschnitt `6.2`. Wo möglich kommen Unit-Tests zum Einsatz.

### 5 Hardware und Softwareanforderungen

Für das erfolgreiche Durchführen aller Tests sollte eine funktionierende JabRef Umgebung eingerichtet sein.
Ausserdem muss die Testperson über eine aktive Internetverbindung verfügen und einen gültigen API-Key für die ChatGPT API besitzen.

## 6 Testfälle

### 6.1 Modultests

## TODO!!!

Ihre Module sollten wenn immer möglich über automatisierte Unittests getestet werden.
Diese können Sie hier kurz (tabellarisch) auflisten. Es reicht, wenn Sie den Klassennamen und den Namen des Testfalls anschreiben.

| Name der Klasse | Name des Testfalls     |
|-----------------|------------------------|
| APIKeyHandler   | getApiKey              |
| APIKeyHandler | isEqualApiKey          |
| APIKeyHandler | isUpdated              |
| GPTinterface | testAPIconnection      |



Die Klassen `SummaryTab` und `SummaryTabViewModel` im package `org.jabref.gui.entryeditor`, die Klasse `AbstractSummaryAction` im package `org.jabref.gui.menus` 
und die Klassen im package `org.jabref.gui.chatty`
sind primär für das GUI verantwortlich und deshalb schwierig mit Unit-Tests zu testen. Wir werden für beide einerseits einen kleinen
manuellen Test durchführen, um zu schauen, ob die GUI-Elemente wie gewünscht vorhanden sind und andererseits wird deren danach Funktion danach ausgiebig im Zusammenhang mit den Funktiostests getestet,
da diese vom Zusammenspiel mit den Klassen im package `org.jabref.logic.chatgpt` abhängig sind.

##### Testfall: /TM10/
*Testziel:*

*Voraussetzung:*

*Eingabe:*

*Erwartete Ausgabe:*

*Abhängigkeiten:*

##### Testfall: /TM20/
*Testziel:* Es sind alle GUI-Elemente für die Erweiterung `Summary` vorhanden.

*Voraussetzung:* JabRef ist geöffnet via GUI. Es ist mind. 1 Entry in der Bibliothek vorhanden.

*Eingabe:* Auf einen beliebigen Entry in der Bibliothek klicken.

*Erwartete Ausgabe:* Der Button `Summarize` ist vorhanden, an der eingezeichneten Stelle im Mockup, ebenso wie das `Summary`-Tab.

##### Testfall: /TM30/
*Testziel:* Es sind alle GUI-Elemente für die Erweiterung `ChatGPT` vorhanden. (ChatWindow)

*Voraussetzung:* JabRef ist geöffnet via GUI.

*Eingabe:* Auf den Button `Chatty` klicken. (Location Siehe Mockup)

*Erwartete Ausgabe:* Es sind alle relevanten Buttons und Felder aus dem Mockup vorhanden, sprich `Send`- und `Copy`-Buttons und ein Text-Input Feld.

### 6.2 Funktionstests

Die Nummerierung der Testfälle bezieht sich auf die Nummerierung der Einzelanforderungen im Pflichtenheft.

##### Testfall: /TF10/
*Testziel:* Es muss in der oberen Menuleiste unter Tools eine neue Option namens `Set API-key` geben.

*Voraussetzung:* JabRef ist geöffnet. (via GUI)

*Eingabe:* Option `Tools` in der Menüleiste anklicken.

*Erwartete Ausgabe:* Es muss eine Option namens `Set API-key` geben.

##### Testfall: /TF11/
*Testziel:* Bei Tätigung muss ein Fenster aufgehen, mit einem Text-input Feld. Der User kann dort seinen eigenen API-Schlüssel eingeben und mit `OK` bestätigen.

*Voraussetzung:* JabRef ist geöffnet. (via GUI)

*Eingabe:* Option `Tools -> Set API-key` in der Menüleiste auswählen. Im auftauchenden Pop-Up den API-key im Textfeld eintragen und dann auf `OK` klicken.

*Erwartete Ausgabe:* Der Key ist gespeichert und die ChatGPT Funktionalitäten sind nutzbar. (Keine zusätzliche Ausgabe)

*Abhängigkeiten:* Gültiger API-key vorhanden

##### Testfall: /TF12/
*Testziel:* Wenn kein API-Schlüssel angegeben wird, soll bei jedem Nutzungsversuch von den folgenden Funktionen (/F2X/ & /F3X/) eine Fehlernachricht kommen, welche den Benutzer (mit einer Anleitung) bittet, einen API-Schlüssel anzugeben. (Illustriert an `Summarize`-Funktion)

*Voraussetzung:* JabRef ist geöffnet via GUI. Summarize Funktion implementiert und funktionstüchtig. Mindestens 1 Entry in der Bibliothek vorhanden.

*Eingabe:* Auswahl des Eintrags. Klick auf `Summarize`-Button.

*Erwartete Ausgabe:* Pop-Up mit der Meldung, dass kein gültiger API-key vorhanden ist und einer Anleitung, wie man diesen setzt.

*Abhängigkeiten:* Kein gültiger API-key hinterlegt.

##### Testfall: /TF13/
*Testziel:* Wenn keine aktive Interneverbindung vorhanden ist, soll bei jedem Nutzungsversuch von den folgenden Funktionen (/F2X/ & /F3X/) eine Fehlernachricht kommen, welche den Benutzer bittet, die Internetverbindung zu überprüfen. (Illustriert an `Summarize`-Funktion)

*Voraussetzung:* JabRef ist geöffnet via GUI. Summarize Funktion implementiert und funktionstüchtig. Mindestens 1 Entry in der Bibliothek vorhanden.

*Eingabe:* Auswahl des Eintrags. Klick auf `Summarize`-Button.

*Erwartete Ausgabe:* Pop-Up mit der Meldung, dass keine aktive Internetverbindung vorhanden ist und einer Bitte, diese herzustellen.

*Abhängigkeiten:* Keine aktive Internetverbindung.

##### Testfall: /TF14/
*Testziel:* Der API-Schlüssel muss in einer Text-Datei lokal gespeichert werden und erhalten bleiben beim nächsten Start von JabRef.

*Voraussetzung:* JabRef ist geöffnet via GUI. Summarize Funktion implementiert und funktionstüchtig. Mindestens 1 Entry in der Bibliothek vorhanden.

*Eingabe:* Option `Tools -> Set API-key` in der Menüleiste auswählen. Im auftauchenden Pop-Up den API-key im Textfeld eintragen und dann auf `OK` klicken. JabRef beenden und neustarten. Versuchen, eine ChatGPT Funktionalität zu nutzen; z.B. Klick auf `Summarize`-Button, wie im Testfall /TF13/ beschrieben.

*Erwartete Ausgabe:* Funktion sollte funktionieren, wie gewünscht, auch nach dem Neustart, ohne dass eine erneute Eingabe notwendig ist.

*Abhängigkeiten:* Gültiger API-key vorhanden.

##### Testfall: /TF15/

*Testziel:* Der API-Schlüssel muss von einem Benutzer neu gesetzt werden können

*Voraussetzung:* JabRef ist geöffnet via GUI.

*Eingabe:* Option `Tools -> Set API-key` in der Menüleiste auswählen. Im auftauchenden Pop-Up den API-key im Textfeld eintragen und dann auf `OK` klicken. Option `Tools -> Set API-key` in der Menüleiste auswählen. Im auftauchenden Pop-Up einen *anderen* API-key im Textfeld eintragen und dann auf `OK` klicken. 

*Erwartete Ausgabe:* In der lokalen Textdatei namens "api-key.txt" soll der zweite API-key stehen. 

##### Testfall: /TF20/
*Testziel:* Es muss ein Tab rechts von `Abstract` mit dem Namen "Summary" existieren. (Siehe Mockup Pflichtenheft)

*Voraussetzung:* JabRef ist geöffnet via GUI. Mindestens 1 Entry in der Bibliothek vorhanden.

*Eingabe:* Auf einen beliebigen Entry in der Bibliothek klicken.

*Erwartete Ausgabe:* Rechts vom `Abstract`-Tab existiert ein neues Tab namens `Summary`.

##### Testfall: /TF21/
*Testziel:* Links im unteren Feld, oberhalb vom `Change entry type` Button muss ein neuer Button namens "Summarize" erstellt werden. (Siehe Mockup Pflichtenheft)

*Voraussetzung:* JabRef ist geöffnet via GUI. Mindestens 1 Entry in der Bibliothek vorhanden.

*Eingabe:* Auf einen beliebigen Entry in der Bibliothek klicken.

*Erwartete Ausgabe:* Oberhalb vom `Change entry type` Button ist ein neuer Button namens `Summarize`.

##### Testfall: /TF22 & TF23/
*Testziel:* Beim Betätigen des Buttons `Summarize` soll der Abstract über die offizielle OpenAI API an ChatGPT geschickt werden, mit der Aufgabe den Abstract in einem Satz zusammenzufassen. Der Output soll im Tab `Summary` dargestellt werden.

*Voraussetzung:* JabRef ist geöffnet via GUI. Mindestens 1 Entry in der Bibliothek vorhanden, der einen Abstract besitzt. Gültiger API-key ist hinterlegt.

*Eingabe:* Auf den Entry in der Bibliothek klicken, welcher einen Abstract hinterlegt hat. Auf `Summarize`-Button klicken. Auf `Summary`-Tab wechseln/ klicken.

*Erwartete Ausgabe:* Im Textfeld steht eine Zusammenfassung des Abstracts in einem Satz.

*Abhängigkeiten:* Hinterlegter Abstract und funktionierender API-key.

##### Testfall: /TF24/
*Testziel:* Sofern kein Abstract vorhanden ist, soll bei Betätigung des Summarize Buttons im Textfeld des Summary Tabs "No Abstract provided" stehen.

*Voraussetzung:* JabRef ist geöffnet via GUI. Mindestens 1 Entry in der Bibliothek vorhanden, der keinen Abstract besitzt. Gültiger API-key ist hinterlegt.

*Eingabe:* Auf den Entry in der Bibliothek klicken, welcher keinen Abstract hinterlegt hat. Auf `Summarize`-Button klicken. Auf `Summary`-Tab wechseln/ klicken.

*Erwartete Ausgabe:* Im Textfeld steht die Meldung `No Abstract provided`.

*Abhängigkeiten:* Funktionierender API-key.

##### Testfall: /TF30/
*Testziel:* Oben rechts bei JabRef muss ein Button eingebettet werden mit der Aufschrift Chatty. (Siehe Grafik: GUI Mockup; Pflichtenheft)

*Voraussetzung:* JabRef ist geöffnet via GUI

*Eingabe:* - 

*Erwartete Ausgabe:* Oben rechts ist ein Button vorhanden mit der Aufschrift `Chatty`.

##### Testfall: /TF31/
*Testziel:* Beim Klicken auf den Knopf `Chatty` muss sich ein Chat Fenster mit einem Textfeld öffnen.

*Voraussetzung:* JabRef ist geöffnet via GUI. Es existiert eine aktive Internetverbindung. Es ist ein gültiger API-key hinterlegt.

*Eingabe:* Klicken auf `Chatty`-Button.

*Erwartete Ausgabe:* Öffnen eines Chat-Fensters.

##### Testfall: /TF32/
*Testziel:* Man muss im Textfeld schreiben können und beim Klicken des Send-Buttons muss der Inhalt an ChatGPT geschickt werden. Das Textfeld soll nach dem Abschicken der Nachricht wieder leer sein.

*Voraussetzung:* JabRef ist geöffnet via GUI. Es existiert eine aktive Internetverbindung. Es ist ein gültiger API-key hinterlegt.

*Eingabe:* Klicken auf `Chatty`-Button. Schreiben eines Textes ins Textfeld. Klick auf `Send`-Button.

*Erwartete Ausgabe:* Textfeld ist wieder leer. Der eingegebene Text erscheint im Chat-Window als Nachricht.

##### Testfall: /TF33/
*Testziel:* Es soll eine Antwort von ChatGPT als Chat-Nachricht zurückgeschickt und angezeigt werden.

*Voraussetzung:* JabRef ist geöffnet via GUI. Es existiert eine aktive Internetverbindung. Es ist ein gültiger API-key hinterlegt.

*Eingabe:* Klicken auf `Chatty`-Button. Schreiben eines Textes ins Textfeld. Klick auf `Send`-Button.

*Erwartete Ausgabe:* Es erscheint eine Antwort von ChatGPT als Nachricht unter der von einem selbst eingegebenen Nachricht (Siehe /TF32/).

##### Testfall: /TF34/
*Testziel:* ChatGPT soll den Kontext vom aktuellen Gespräch verstehen. Beim Schliessen vom Chat-Fenster geht der Kontext sowie der Chat-Verlauf verloren.

*Voraussetzung:* JabRef ist geöffnet via GUI. Es existiert eine aktive Internetverbindung. Es ist ein gültiger API-key hinterlegt. Es ist bereits ein ChatWindow geöffnet.

*Eingabe:* Schreiben des Textes: "Say Tomato". Klicken auf `Send`-Button. Schreiben des Textes: "What was the last thing you said?". Klicken auf `Send`-Button.

*Erwartete Ausgabe:* Es kommt als erstes die Antwort "Tomato". Und als Antwort auf die zweite Nachricht erscheint eine Antwort, die das Wort "Tomato" enthält.

*Abhängigkeiten:* Die zweite Antwort kann variieren abhängig von der verwendeten ChatGPT Version. Es sollte aber klar ersichtlich sein, dass der Kontext funktioniert.

##### Testfall: /TF35/
*Testziel:* Es soll nur ein Chat-Fenster zum selben Zeitpunkt offen sein können.

*Voraussetzung:* JabRef ist geöffnet via GUI. Es existiert eine aktive Internetverbindung. Es ist ein gültiger API-key hinterlegt. Es ist bereits ein ChatWindow geöffnet.

*Eingabe:* Versuch, ein anderes Fenster zu öffnen.

*Erwartete Ausgabe:* Es soll nicht möglich sein, ein anderes Fenster zu öffnen.

*Abhängigkeiten:* Abhängig von der Implementationsweise des Fensters; Entweder kann man gar nicht auf das Hauptfenster zugreifen; oder der Button ist deaktiviert / es öffnet sich kein neues Fenster bei erneutem Drücken auf den `Chatty`-Button.

##### Testfall: /TF36/
*Testziel:* Oben rechts im Chat-Fenster soll ein Button eingebettet werden: Copy; wenn man diesen drückt soll die letzte Antwort von ChatGPT ins Clipboard kopiert werden.

*Voraussetzung:* JabRef ist geöffnet via GUI. Es existiert eine aktive Internetverbindung. Es ist ein gültiger API-key hinterlegt. Es ist bereits ein ChatWindow geöffnet. Es wurde bereits eine Nachricht an ChatGPT verschickt, und es kam eine Antwort.

*Eingabe:* Klicken auf `Copy`-Button.

*Erwartete Ausgabe:* Letzte Nachricht von ChatGPT sollte im Clipboard sein. Das heisst, wenn man `Ctrl. + V` in einem Textdokument o.ä. drückt, wird der Text eingefügt und stimmt überein mit der letzten Nachricht von ChatGPT im ChatWindow.

*Abhängigkeiten:* Genaue Implementation des Clipboards ist vom Betriebssystem abhängig. Die Tastenkombination kann variieren. Alternativ kann man auch das Menu zum Einfügen vom Clipboard benutzen, je nach Programm.
