# Лабораторна робота №2 - Gradle та Java Collections Framework

## Опис проєкту
Клас `WordCounter` (пакет `ua.kpi.comsys.collections`) - частотний аналізатор тексту:

- `Map<String, Integer> countWords(List<String> textLines)` - слово → кількість входжень;
- `Set<String> getUniqueWords(List<String> textLines)` - множина унікальних слів.

Правила: словом вважається послідовність латинських літер і цифр (`[a-zA-Z0-9]+`),
усі слова приводяться до нижнього регістру, порожні токени ігноруються.
Якщо `textLines == null`, кидається `IllegalArgumentException`.

Збірка - Gradle (Kotlin DSL), залежності керуються через Version Catalog
(`gradle/libs.versions.toml`). Використовується лише стандартний `java.util.*`.

## Розрахунок варіанта
Варіант: **V = 14 mod 3 = 2** 

## Збірка та запуск тестів
Потрібно: JDK 17+.

```bash
./gradlew build   
./gradlew test    
```
