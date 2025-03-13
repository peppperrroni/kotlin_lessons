# Урок 3: Условные выражения в Kotlin

## Введение

Условные выражения являются фундаментальной частью любого языка программирования, позволяя выполнять различные блоки кода в зависимости от определенных условий. Kotlin предлагает мощные и гибкие механизмы для работы с условиями, которые делают код более читаемым и выразительным.

В этом уроке мы рассмотрим различные способы использования условных выражений в Kotlin, включая операторы `if-else`, выражение `when`, а также особенности работы с nullable типами.

## Оператор if-else

### Базовое использование if-else

Оператор `if-else` в Kotlin используется для выполнения кода на основе логического условия:

```kotlin
val temperature = 25

if (temperature > 30) {
    println("Жарко")
} else if (temperature > 20) {
    println("Тепло")
} else if (temperature > 10) {
    println("Прохладно")
} else {
    println("Холодно")
}
```

### if как выражение

Одной из особенностей Kotlin является то, что `if` является выражением, а не оператором. Это означает, что он возвращает значение, которое можно присвоить переменной:

```kotlin
val temperature = 25
val description = if (temperature > 30) {
    "Жарко"
} else if (temperature > 20) {
    "Тепло"
} else if (temperature > 10) {
    "Прохладно"
} else {
    "Холодно"
}

println("Сейчас $description") // Выведет: "Сейчас Тепло"
```

Это делает код более лаконичным и устраняет необходимость в тернарном операторе, который присутствует в других языках (например, `condition ? valueIfTrue : valueIfFalse` в Java).

### Однострочный if

Для простых условий можно использовать однострочную форму `if`:

```kotlin
val age = 20
val canVote = if (age >= 18) "Да" else "Нет"
println("Может голосовать: $canVote") // Выведет: "Может голосовать: Да"
```

## Выражение when

Выражение `when` в Kotlin является мощной заменой оператора `switch` из других языков, но с гораздо большей гибкостью.

### Базовое использование when

```kotlin
val dayOfWeek = 3

when (dayOfWeek) {
    1 -> println("Понедельник")
    2 -> println("Вторник")
    3 -> println("Среда")
    4 -> println("Четверг")
    5 -> println("Пятница")
    6, 7 -> println("Выходной")
    else -> println("Некорректный день")
}
```

### when как выражение

Как и `if`, выражение `when` может возвращать значение:

```kotlin
val dayOfWeek = 3
val dayName = when (dayOfWeek) {
    1 -> "Понедельник"
    2 -> "Вторник"
    3 -> "Среда"
    4 -> "Четверг"
    5 -> "Пятница"
    6, 7 -> "Выходной"
    else -> "Некорректный день"
}

println("Сегодня $dayName") // Выведет: "Сегодня Среда"
```

### Использование диапазонов и условий в when

`when` может использовать диапазоны и произвольные условия:

```kotlin
val score = 85

val grade = when (score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    in 70..79 -> "C"
    in 60..69 -> "D"
    in 0..59 -> "F"
    else -> "Некорректный балл"
}

println("Оценка: $grade") // Выведет: "Оценка: B"
```

### when без аргумента

`when` может использоваться без аргумента, что делает его альтернативой цепочке `if-else if-else`:

```kotlin
val temperature = 25

val feeling = when {
    temperature > 35 -> "Очень жарко"
    temperature > 25 -> "Жарко"
    temperature > 15 -> "Тепло"
    temperature > 5 -> "Прохладно"
    temperature > -5 -> "Холодно"
    else -> "Очень холодно"
}

println("Ощущается как: $feeling") // Выведет: "Ощущается как: Тепло"
```

### Проверка типа с when и is

`when` в сочетании с оператором `is` позволяет проверять тип объекта:

```kotlin
fun describe(obj: Any): String {
    return when (obj) {
        is Int -> "Целое число: $obj"
        is String -> "Строка длиной ${obj.length}"
        is Boolean -> if (obj) "Истина" else "Ложь"
        is Array<*> -> "Массив размером ${obj.size}"
        else -> "Неизвестный тип"
    }
}

println(describe(42))        // Выведет: "Целое число: 42"
println(describe("Привет"))  // Выведет: "Строка длиной 6"
println(describe(true))      // Выведет: "Истина"
println(describe(arrayOf(1, 2, 3))) // Выведет: "Массив размером 3"
```

## Безопасная работа с null

Kotlin предоставляет несколько механизмов для безопасной работы с nullable типами в условных выражениях.

### Оператор безопасного вызова (?.)

Оператор `?.` позволяет безопасно вызывать методы и свойства объекта, который может быть `null`:

```kotlin
val name: String? = "Kotlin"
val length = name?.length // Если name не null, вернет длину, иначе вернет null
println("Длина: $length") // Выведет: "Длина: 6"

val nullName: String? = null
val nullLength = nullName?.length // Вернет null
println("Длина: $nullLength") // Выведет: "Длина: null"
```

### Оператор Elvis (?:)

Оператор Elvis `?:` позволяет предоставить значение по умолчанию, если выражение слева равно `null`:

```kotlin
val name: String? = "Kotlin"
val length = name?.length ?: 0 // Если name?.length вернет null, используется 0
println("Длина: $length") // Выведет: "Длина: 6"

val nullName: String? = null
val nullLength = nullName?.length ?: 0 // Вернет 0
println("Длина: $nullLength") // Выведет: "Длина: 0"
```

### Оператор !! (Not-null assertion)

Оператор `!!` утверждает, что выражение не равно `null`, и выбрасывает `NullPointerException`, если это не так:

```kotlin
val name: String? = "Kotlin"
val length = name!!.length // Безопасно, так как name не null
println("Длина: $length") // Выведет: "Длина: 6"

val nullName: String? = null
// val nullLength = nullName!!.length // Выбросит NullPointerException
```

> **Важно**: Оператор `!!` следует использовать с осторожностью, только когда вы абсолютно уверены, что значение не может быть `null`. В большинстве случаев лучше использовать безопасные операторы `?.` и `?:`.

## Практические примеры

### Проверка возраста

```kotlin
fun checkAge(age: Int): String {
    return when {
        age < 0 -> "Некорректный возраст"
        age < 18 -> "Несовершеннолетний"
        age < 65 -> "Взрослый"
        else -> "Пенсионер"
    }
}

val age1 = 15
val age2 = 30
val age3 = 70

println("Возраст $age1: ${checkAge(age1)}") // "Возраст 15: Несовершеннолетний"
println("Возраст $age2: ${checkAge(age2)}") // "Возраст 30: Взрослый"
println("Возраст $age3: ${checkAge(age3)}") // "Возраст 70: Пенсионер"
```

### Определение времени суток

```kotlin
fun getTimeOfDay(hour: Int): String {
    return when (hour) {
        in 0..5 -> "Ночь"
        in 6..11 -> "Утро"
        in 12..17 -> "День"
        in 18..23 -> "Вечер"
        else -> "Некорректное время"
    }
}

val hour1 = 3
val hour2 = 10
val hour3 = 15
val hour4 = 20

println("Время $hour1:00: ${getTimeOfDay(hour1)}") // "Время 3:00: Ночь"
println("Время $hour2:00: ${getTimeOfDay(hour2)}") // "Время 10:00: Утро"
println("Время $hour3:00: ${getTimeOfDay(hour3)}") // "Время 15:00: День"
println("Время $hour4:00: ${getTimeOfDay(hour4)}") // "Время 20:00: Вечер"
```

### Проверка строки

```kotlin
fun checkString(str: String?): String {
    return when {
        str == null -> "Строка равна null"
        str.isEmpty() -> "Строка пуста"
        str.length == 1 -> "Строка содержит один символ: $str"
        str.length <= 5 -> "Короткая строка: $str"
        str.length <= 10 -> "Средняя строка: $str"
        else -> "Длинная строка: ${str.take(10)}..."
    }
}

println(checkString(null))                // "Строка равна null"
println(checkString(""))                  // "Строка пуста"
println(checkString("A"))                 // "Строка содержит один символ: A"
println(checkString("Привет"))            // "Короткая строка: Привет"
println(checkString("Привет, мир"))       // "Средняя строка: Привет, мир"
println(checkString("Привет, мир! Как дела?")) // "Длинная строка: Привет, ми..."
```

### Комбинирование условий

```kotlin
fun checkNumber(num: Int): String {
    return when {
        num == 0 -> "Ноль"
        num > 0 && num % 2 == 0 -> "Положительное четное число"
        num > 0 -> "Положительное нечетное число"
        num % 2 == 0 -> "Отрицательное четное число"
        else -> "Отрицательное нечетное число"
    }
}

println(checkNumber(0))   // "Ноль"
println(checkNumber(4))   // "Положительное четное число"
println(checkNumber(7))   // "Положительное нечетное число"
println(checkNumber(-6))  // "Отрицательное четное число"
println(checkNumber(-3))  // "Отрицательное нечетное число"
```

## Заключение

В этом уроке мы рассмотрели условные выражения в Kotlin, включая операторы `if-else`, выражение `when`, а также механизмы для безопасной работы с nullable типами.

Ключевые особенности условных выражений в Kotlin:
- `if` и `when` являются выражениями и могут возвращать значения
- Выражение `when` предоставляет гибкую замену оператору `switch` из других языков
- Kotlin предлагает безопасные способы работы с nullable типами через операторы `?.`, `?:` и `!!`

Эти возможности делают код на Kotlin более читаемым, выразительным и безопасным, позволяя избежать многих распространенных ошибок, связанных с условными выражениями и обработкой null. 