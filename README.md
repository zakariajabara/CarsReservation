# CarsReservation
develop a java Application witch manage rent cars

Die Nizar Travell Agency ist ein klein Unternehmen, welches Autos zu seinen Kunden vermietet. Die Kunden kommen ausshliesslich aus den Golfstaaten.

Die Abhol- und Rückgabe der gemieteten Autos findet statt nicht nur in München, sondern auch in anderen Europpesche staaten wie Frankreich, Italien, Östereich oder die Schweiz.
In spitzen Zeiten kann es sein, dass es vieel Autos glaichzeitig unterwegs sind, verliert man den Überblick welches Auto im welchem Tag zu welchem Standort abgegen oder abgeholt wird.

Darum benötigt der Inhaber eiene Applikation (Web basiert) umd seine Kunden, die Mietwagens und seien Aufträge zu verwalten. 

Die Applikation soll nur intern angewandet werden. Der Kunde soll keinen Zugriff drauf haben (!?Aussnahme ?!: einen Blick auf die zu mietenen Autos zu haben).

Die Applikation soll sowohl auf Handygeräte als auch dem Rechner abrufbar sein.

Relevant für den Inhaber sind 
- Die Kundendaten (Vorname, Name, tel Nr, Herkunftland).
- Verfügbaren autos
- aktuelle Aufträge (Abgabe, Rückgabedatum Rückgabeort)

Ferner:
Der Inhaber hat keine Garage, wo er seine Autos parkt, oft stehen sie verschiedenen Plätzen in München. Darum möchte der Inhaber eien geolocalisation Funktion in der Applikation definieren, 
die im Zeigt welches Auto udn wo sie geparkt ist.


Use Cases:
Inhaber fügt die Daten eines neuen Kunden im System, benötigt sind hier name mit Vorname, Tel. Nr und Herkunftsland.
Inhaber fügt die Daten eines neuen Mietwagen im System (Marke, Model, Getriebe, Kraftstoff, Anzahl Sitzplätze)
Inhaber fügt einen Auftrag (Welches Auto, zu welchen Munden, Abgabedatum und Dauer, Ort: Abgabe udn Rückgabe, Preis) 
