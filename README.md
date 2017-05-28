# Rekin biznesu


## Opis:
Aplikacja ma za zadanie policzyć rachunek zysków i strat przedsiębiorstwa w podziale na wariant kalkulacyjny i porównawczy, w zależności od sposobu księgowania kosztów w przedsiębiorstwie.

Obliczone wyniki rachunku zysków i strat będą przechowywane w bazie danych, co umożliwi ich późniejsze wykorzystanie.

## Wykaz dostęnych funkcjonalności:

<p align="center">
  <img src="https://github.com/trycja/RachunekZS/blob/master/Screenshots/Screenshot_1496005020.png" width="350"/>
</p>


Rachunek zysków i strat jest obowiązkowym elementem sprawozdania finansowego. Ujmuje on przychody i odpowiadające im koszty, zyski i straty, a takżę podatek dochodowy i inne obowiązkowe obciążenia wyniku finansowego za bieżący i poprzedni rok obrotowy. Ustawa o rachunkowości dopuszcza dwa warianty rachuku zysków i strat: 
1. Wariant porównawczy - Umożliwia obliczenie zysku lub straty na podstawie ewidencji przychodów i kosztów rodzajowych.
2. Wariant kalkulacyjny - Umożliwia obliczenie zysku lub straty na podstawie ewidencji przychodów i kosztów układu kalkulacyjnego.
Wybór wariantu rachuku zysków i start zależy głównie od potrzeb specyfiki i złożoności prowadzonej działalności gospodarczej. Warianty te różnią się między sobą sposobem ujęcia kosztów sprzedanych produktw i usług.
 
 
<p align="center">
  <img src="https://github.com/trycja/RachunekZS/blob/master/Screenshots/Screenshot_1496005150.png" width="350"/>
</p>

3. Baza danych - Umożliwia wgląd w dane dotyczące zysków i strat z wybranego przez użytkownika roku.

## Dokumentacja

### Wykorzystane pojęcia/klasy oraz ich opis. 
W programie użyto 5 klas. Każda z klas dziedziczy z AppCompatActivity  oraz posiada implementację metody onCreate() oraz metody odpowiedzialne za przejścia pomiędzy poszczególnymi layoutami.

Aplikacja zawiera następujące klasy:
# Kalkulacyjny i Porownawczy:
obie klasy pozwalają obliczyć rachunek zysku i strat dla wybranego wariantu, na podstawie podanych przez użytkowników danych.
	
```
//ciało metody pozwalającej na pobranie wszystkich danych przekazanych przez użytkownika w danym layoucie i zapisannych do odpowiedniej zmiennej, w zależności od roku
	int[] ids1 = new int[]{R.id.b13, R.id.b23, R.id.b33, R.id.b43, R.id.b53, R.id.b63, R.id.b73, R.id.b83};
    int[] ids2 = new int[]{R.id.b14, R.id.b24, R.id.b34, R.id.b44, R.id.b54, R.id.b64, R.id.b74, R.id.b84};

        for (int id : ids1) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                B1 += value;
            } catch (NumberFormatException e) {
            }
            //  values.add(value);
        }

        for (int id : ids2) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                B2 += value;
            } catch (NumberFormatException e) {
            }
            //  values.add(value);
        }

```		

# Baza:
klasa zapewniająca obsługę bazy danych, pozwala na dodanie nowych rekordów do bazy znajdującej się na serwerze v-ie.uek.krakow.pl.

```		
 public void dalej(View view) {
 //metoda ta pozwala na wstawienie obliczonego wyniku rachunku zysków i strat do bazy danych
	...
	parameters.put("nazwa", identyfikator);
	parameters.put("rokPoprzedni", String.valueOf(rokPoprzedni));
	parameters.put("rokObrotowy", String.valueOf(rok));
	parameters.put("wariant", MainActivity.wariant);
	parameters.put("zyskPoprzedni", String.valueOf(MainActivity.zyskPoprzedni));
	parameters.put("zyskObecny", String.valueOf(MainActivity.zyskObrotowy));
	...
}
```		

<p align="center">
  <img src="https://github.com/trycja/RachunekZS/blob/master/Screenshots/Screenshot_1496005329.png" width="350"/>
</p>


# MainActivity:
klasa uruchamiana na początku działania aplikacji, pozwala na wybór jednej z trzech funkcjonalności.
# Rezultaty:
klasa pozwalająca na pobranie danych z bazy danych na podstawie zadeklarowanego przez użytkownika identyfikatora, wariantu oraz roku. 

Posiada dwie metody odpowiedzialne za pobranie danych w zalżności od zadanych parametrów wywołania:

```	
 public void pobierz(final String identyfikator, final  String wariant, final int rok) { ... };
 public void pobierz2(final String identyfikator, final String wariant) {... };
```	

<p align="center">
  <img src="https://github.com/trycja/RachunekZS/blob/master/Screenshots/Screenshot_1496005746.png" width="350"/>
</p>


## Autor

Grupa: **KrDZIs3011Io**

**Patrycja Czubienko**: 186156

## Informacje

Projekt przygotowany w ramach przedmiotu "Programowanie systemów mobilnych." 
Uniwersytet Ekonomiczny w Krakowie, maj 2017r.

