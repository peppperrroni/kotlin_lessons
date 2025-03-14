# Урок 4: Расширения и функциональное программирование в Kotlin

## Введение

Kotlin предлагает мощные инструменты для функционального программирования и расширения существующих классов без наследования. Эти возможности делают код более выразительным, лаконичным и удобным для чтения.

## Расширения

Расширения позволяют добавлять новую функциональность к существующим классам без изменения их исходного кода и без наследования.

### Функции-расширения

Функции-расширения позволяют "добавлять" методы к существующим классам:

```kotlin
fun String.isEmail(): Boolean {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    return matches(emailRegex.toRegex())
}

// Использование
val email = "user@example.com"
println(email.isEmail()) // true
```

### Свойства-расширения

Свойства-расширения позволяют "добавлять" свойства к существующим классам:

```kotlin
val String.lastChar: Char
    get() = this[length - 1]

val String.firstChar: Char
    get() = this[0]

// Использование
val text = "Kotlin"
println(text.lastChar) // n
println(text.firstChar) // K
```

### Расширения для nullable типов

Можно создавать расширения для nullable типов:

```kotlin
fun String?.isNullOrEmpty(): Boolean {
    return this == null || this.isEmpty()
}

// Использование
val text: String? = null
println(text.isNullOrEmpty()) // true
```

### Расширения с приемником

Можно создавать функции с приемником, которые работают как расширения:

```kotlin
fun buildString(action: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.action()
    return sb.toString()
}

// Использование
val result = buildString {
    append("Hello, ")
    append("World!")
}
println(result) // Hello, World!
```

## Функциональное программирование

Kotlin поддерживает функциональное программирование, предоставляя функции как объекты первого класса, лямбда-выражения и множество функций высшего порядка.

### Функции высшего порядка

Функции высшего порядка - это функции, которые принимают другие функции в качестве параметров или возвращают функции:

```kotlin
fun operation(x: Int, y: Int, op: (Int, Int) -> Int): Int {
    return op(x, y)
}

// Использование
val sum = operation(10, 5) { a, b -> a + b } // 15
val multiply = operation(10, 5) { a, b -> a * b } // 50
```

### Лямбда-выражения

Лямбда-выражения - это "анонимные функции", которые можно передавать как значения:

```kotlin
val sum = { x: Int, y: Int -> x + y }
println(sum(10, 5)) // 15

// Лямбда с одним параметром может использовать неявный параметр it
val square = { it * it }
println(square(5)) // 25
```

### Функции-ссылки

Функции-ссылки позволяют передавать существующие функции как значения:

```kotlin
fun isEven(n: Int): Boolean = n % 2 == 0

// Использование функции-ссылки
val numbers = listOf(1, 2, 3, 4, 5)
val evenNumbers = numbers.filter(::isEven) // [2, 4]
```

### Ссылки на конструкторы

Можно использовать ссылки на конструкторы:

```kotlin
data class Person(val name: String, val age: Int)

// Использование ссылки на конструктор
val createPerson = ::Person
val person = createPerson("John", 30)
```

### Встроенные функции высшего порядка

Kotlin предоставляет множество встроенных функций высшего порядка для работы с коллекциями:

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)

// filter - фильтрует элементы по условию
val evenNumbers = numbers.filter { it % 2 == 0 } // [2, 4]

// map - преобразует каждый элемент
val squared = numbers.map { it * it } // [1, 4, 9, 16, 25]

// reduce - сворачивает коллекцию в одно значение
val sum = numbers.reduce { acc, n -> acc + n } // 15

// forEach - выполняет действие для каждого элемента
numbers.forEach { println(it) }

// any - проверяет, удовлетворяет ли хотя бы один элемент условию
val hasEven = numbers.any { it % 2 == 0 } // true

// all - проверяет, удовлетворяют ли все элементы условию
val allEven = numbers.all { it % 2 == 0 } // false

// find - находит первый элемент, удовлетворяющий условию
val firstEven = numbers.find { it % 2 == 0 } // 2

// groupBy - группирует элементы по ключу
val grouped = numbers.groupBy { if (it % 2 == 0) "even" else "odd" }
// {odd=[1, 3, 5], even=[2, 4]}
```

### Последовательности и ленивые вычисления

Последовательности (Sequence) в Kotlin позволяют выполнять операции лениво, что может быть более эффективно для больших коллекций:

```kotlin
val numbers = (1..1000000).asSequence()

// Операции выполняются лениво, только когда вызывается терминальная операция
val result = numbers
    .filter { it % 2 == 0 }
    .map { it * it }
    .take(5)
    .toList() // Терминальная операция, запускающая вычисления

println(result) // [4, 16, 36, 64, 100]
```

### Функциональные интерфейсы и SAM-преобразования

Kotlin поддерживает функциональные интерфейсы (SAM - Single Abstract Method) и автоматические преобразования лямбда-выражений в экземпляры этих интерфейсов:

```kotlin
// Функциональный интерфейс
fun interface Predicate<T> {
    fun test(value: T): Boolean
}

// Использование
val isEven = Predicate<Int> { it % 2 == 0 }
println(isEven.test(4)) // true
println(isEven.test(5)) // false
```

## Комбинирование расширений и функционального программирования

Расширения и функциональное программирование часто используются вместе для создания выразительного и лаконичного кода:

```kotlin
// Расширение, принимающее функцию
fun <T> List<T>.filterAndMap(
    predicate: (T) -> Boolean,
    transform: (T) -> String
): List<String> {
    return this.filter(predicate).map(transform)
}

// Использование
val numbers = listOf(1, 2, 3, 4, 5)
val result = numbers.filterAndMap(
    { it % 2 == 0 },
    { "Number: $it" }
)
println(result) // [Number: 2, Number: 4]
```

## Практические примеры

### Пример 1: Создание DSL для построения HTML

```kotlin
class HTML {
    private val content = StringBuilder()
    
    fun head(action: Head.() -> Unit) {
        content.append("<head>")
        val head = Head()
        head.action()
        content.append(head.content)
        content.append("</head>")
    }
    
    fun body(action: Body.() -> Unit) {
        content.append("<body>")
        val body = Body()
        body.action()
        content.append(body.content)
        content.append("</body>")
    }
    
    override fun toString(): String {
        return "<html>$content</html>"
    }
}

class Head {
    val content = StringBuilder()
    
    fun title(text: String) {
        content.append("<title>$text</title>")
    }
}

class Body {
    val content = StringBuilder()
    
    fun h1(text: String) {
        content.append("<h1>$text</h1>")
    }
    
    fun p(text: String) {
        content.append("<p>$text</p>")
    }
    
    fun a(href: String, text: String) {
        content.append("<a href=\"$href\">$text</a>")
    }
}

fun html(action: HTML.() -> Unit): HTML {
    val html = HTML()
    html.action()
    return html
}

// Использование
val htmlContent = html {
    head {
        title("Моя страница")
    }
    body {
        h1("Привет, мир!")
        p("Это пример DSL в Kotlin")
        a("https://kotlinlang.org", "Kotlin")
    }
}

println(htmlContent)
```

### Пример 2: Обработка данных с использованием функционального подхода

```kotlin
data class User(val id: Int, val name: String, val age: Int, val email: String)

val users = listOf(
    User(1, "Alice", 25, "alice@example.com"),
    User(2, "Bob", 30, "bob@example.com"),
    User(3, "Charlie", 35, "charlie@example.com"),
    User(4, "Dave", 40, "dave@example.com"),
    User(5, "Eve", 45, "eve@example.com")
)

// Расширение для фильтрации пользователей по возрасту
fun List<User>.olderThan(age: Int): List<User> {
    return filter { it.age > age }
}

// Расширение для получения email-адресов
val List<User>.emails: List<String>
    get() = map { it.email }

// Расширение для группировки пользователей по возрастной группе
fun List<User>.groupByAgeRange(rangeSize: Int): Map<String, List<User>> {
    return groupBy { user ->
        val start = (user.age / rangeSize) * rangeSize
        val end = start + rangeSize - 1
        "$start-$end"
    }
}

// Использование
val olderUsers = users.olderThan(30)
println(olderUsers)

val emailAddresses = users.emails
println(emailAddresses)

val usersByAgeGroup = users.groupByAgeRange(10)
usersByAgeGroup.forEach { (ageRange, usersInRange) ->
    println("$ageRange: ${usersInRange.map { it.name }}")
}
```

## Лучшие практики

1. **Используйте расширения для добавления функциональности к существующим классам**: Это делает код более читаемым и организованным.

2. **Предпочитайте функции высшего порядка для повторяющихся шаблонов**: Они позволяют абстрагировать общую логику и сделать код более декларативным.

3. **Используйте последовательности для больших коллекций**: Они могут значительно улучшить производительность за счет ленивых вычислений.

4. **Создавайте DSL для сложных структур данных**: Это делает код более читаемым и понятным.

5. **Избегайте чрезмерного использования расширений**: Слишком много расширений может сделать код трудным для понимания.

6. **Используйте говорящие имена для лямбда-параметров**: Вместо `it` используйте более описательные имена, когда лямбда становится сложной.

## Заключение

Расширения и функциональное программирование в Kotlin предоставляют мощные инструменты для создания выразительного, лаконичного и удобного для чтения кода. Они позволяют добавлять функциональность к существующим классам без наследования и писать более декларативный код, фокусируясь на "что" нужно сделать, а не на "как" это сделать.

В следующем уроке мы рассмотрим корутины и асинхронное программирование в Kotlin, которые позволяют писать асинхронный код в последовательном стиле, делая его более читаемым и поддерживаемым. 