# Урок 7: Классы и объекты в Kotlin

## Введение

Объектно-ориентированное программирование (ООП) — это парадигма программирования, основанная на концепции "объектов", которые содержат данные и код для работы с этими данными. Kotlin предоставляет мощную и гибкую систему классов, которая сочетает в себе лучшие практики из различных языков программирования.

В этом уроке мы рассмотрим основы объектно-ориентированного программирования в Kotlin, включая классы, объекты, конструкторы, свойства и методы.

## Основы классов и объектов

### Объявление класса

В Kotlin класс объявляется с использованием ключевого слова `class`:

```kotlin
class Person {
    // Свойства и методы класса
}
```

### Создание объекта (экземпляра класса)

Для создания объекта в Kotlin не используется ключевое слово `new`:

```kotlin
val person = Person()
```

### Свойства класса

Свойства класса — это переменные, объявленные внутри класса:

```kotlin
class Person {
    var name: String = "Неизвестно"
    var age: Int = 0
}

val person = Person()
println(person.name) // Выведет: "Неизвестно"
println(person.age)  // Выведет: 0

// Изменение свойств
person.name = "Иван"
person.age = 30
println(person.name) // Выведет: "Иван"
println(person.age)  // Выведет: 30
```

### Методы класса

Методы класса — это функции, объявленные внутри класса:

```kotlin
class Person {
    var name: String = "Неизвестно"
    var age: Int = 0
    
    fun introduce() {
        println("Привет, меня зовут $name, мне $age лет")
    }
    
    fun celebrateBirthday() {
        age++
        println("С днем рождения! Теперь мне $age лет")
    }
}

val person = Person()
person.name = "Иван"
person.age = 30
person.introduce()       // Выведет: "Привет, меня зовут Иван, мне 30 лет"
person.celebrateBirthday() // Выведет: "С днем рождения! Теперь мне 31 лет"
```

## Конструкторы

### Первичный конструктор

Первичный конструктор является частью заголовка класса:

```kotlin
class Person(val name: String, var age: Int) {
    fun introduce() {
        println("Привет, меня зовут $name, мне $age лет")
    }
}

val person = Person("Иван", 30)
println(person.name) // Выведет: "Иван"
println(person.age)  // Выведет: 30
person.introduce()   // Выведет: "Привет, меня зовут Иван, мне 30 лет"
```

Параметры первичного конструктора могут быть объявлены как свойства с использованием ключевых слов `val` (неизменяемое свойство) или `var` (изменяемое свойство).

### Блок инициализации

Блок инициализации выполняется при создании экземпляра класса:

```kotlin
class Person(val name: String, var age: Int) {
    val isAdult: Boolean
    
    init {
        isAdult = age >= 18
        println("Создан объект Person: $name, $age лет, взрослый: $isAdult")
    }
}

val person = Person("Иван", 30) // Выведет: "Создан объект Person: Иван, 30 лет, взрослый: true"
```

### Вторичные конструкторы

Вторичные конструкторы объявляются с использованием ключевого слова `constructor`:

```kotlin
class Person(val name: String, var age: Int) {
    var email: String = ""
    
    // Вторичный конструктор
    constructor(name: String, age: Int, email: String) : this(name, age) {
        this.email = email
    }
    
    fun getInfo(): String {
        return "Имя: $name, Возраст: $age, Email: ${email.ifEmpty { "не указан" }}"
    }
}

val person1 = Person("Иван", 30)
val person2 = Person("Мария", 25, "maria@example.com")

println(person1.getInfo()) // Выведет: "Имя: Иван, Возраст: 30, Email: не указан"
println(person2.getInfo()) // Выведет: "Имя: Мария, Возраст: 25, Email: maria@example.com"
```

## Свойства и их особенности

### Геттеры и сеттеры

Kotlin автоматически генерирует геттеры и сеттеры для свойств, но вы можете определить их самостоятельно:

```kotlin
class Rectangle(val width: Int, val height: Int) {
    val area: Int
        get() = width * height
    
    val perimeter: Int
        get() = 2 * (width + height)
}

val rectangle = Rectangle(5, 3)
println("Площадь: ${rectangle.area}")       // Выведет: "Площадь: 15"
println("Периметр: ${rectangle.perimeter}") // Выведет: "Периметр: 16"
```

### Пользовательские сеттеры

```kotlin
class User {
    var name: String = ""
    
    var password: String = ""
        set(value) {
            if (value.length < 6) {
                println("Ошибка: пароль должен содержать не менее 6 символов")
            } else {
                field = value // field - это специальный идентификатор для доступа к свойству
                println("Пароль успешно изменен")
            }
        }
}

val user = User()
user.name = "Иван"
user.password = "123"     // Выведет: "Ошибка: пароль должен содержать не менее 6 символов"
user.password = "secret123" // Выведет: "Пароль успешно изменен"
```

### Поздняя инициализация (lateinit)

Ключевое слово `lateinit` позволяет объявить свойство, которое будет инициализировано позже:

```kotlin
class Student {
    lateinit var university: String
    
    fun enrollToUniversity(universityName: String) {
        university = universityName
        println("Зачислен в университет: $university")
    }
    
    fun getUniversityInfo(): String {
        return if (::university.isInitialized) {
            "Учится в университете: $university"
        } else {
            "Не зачислен в университет"
        }
    }
}

val student = Student()
println(student.getUniversityInfo()) // Выведет: "Не зачислен в университет"
student.enrollToUniversity("МГУ")    // Выведет: "Зачислен в университет: МГУ"
println(student.getUniversityInfo()) // Выведет: "Учится в университете: МГУ"
```

## Модификаторы доступа

Kotlin предоставляет четыре модификатора доступа:

- `public` (по умолчанию): доступно отовсюду
- `private`: доступно только внутри класса
- `protected`: доступно внутри класса и его подклассов
- `internal`: доступно внутри модуля

```kotlin
class BankAccount(private val accountNumber: String, initialBalance: Double) {
    private var balance: Double = initialBalance
    
    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Внесено: $amount. Новый баланс: $balance")
        } else {
            println("Ошибка: сумма должна быть положительной")
        }
    }
    
    fun withdraw(amount: Double) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount
                println("Снято: $amount. Новый баланс: $balance")
            } else {
                println("Ошибка: недостаточно средств")
            }
        } else {
            println("Ошибка: сумма должна быть положительной")
        }
    }
    
    fun getAccountInfo(): String {
        return "Счет: ${accountNumber.takeLast(4)}, Баланс: $balance"
    }
}

val account = BankAccount("1234567890", 1000.0)
// account.accountNumber // Ошибка: accountNumber - приватное свойство
// account.balance       // Ошибка: balance - приватное свойство
account.deposit(500.0)   // Выведет: "Внесено: 500.0. Новый баланс: 1500.0"
account.withdraw(200.0)  // Выведет: "Снято: 200.0. Новый баланс: 1300.0"
println(account.getAccountInfo()) // Выведет: "Счет: 7890, Баланс: 1300.0"
```

## Классы данных (data classes)

Классы данных предназначены для хранения данных и автоматически реализуют методы `equals()`, `hashCode()`, `toString()` и другие:

```kotlin
data class Product(val id: Int, val name: String, val price: Double)

val product1 = Product(1, "Ноутбук", 1200.0)
val product2 = Product(1, "Ноутбук", 1200.0)
val product3 = Product(2, "Смартфон", 800.0)

println(product1)                // Выведет: "Product(id=1, name=Ноутбук, price=1200.0)"
println(product1 == product2)    // Выведет: true (сравнение по содержимому)
println(product1 == product3)    // Выведет: false

// Копирование с изменением некоторых свойств
val discountedProduct = product1.copy(price = 1000.0)
println(discountedProduct)       // Выведет: "Product(id=1, name=Ноутбук, price=1000.0)"

// Деструктуризация
val (id, name, price) = product1
println("ID: $id, Название: $name, Цена: $price") // Выведет: "ID: 1, Название: Ноутбук, Цена: 1200.0"
```

## Объекты-компаньоны (companion objects)

Объекты-компаньоны позволяют определять статические члены класса:

```kotlin
class Circle(val radius: Double) {
    companion object {
        const val PI = 3.14159
        
        fun createUnitCircle(): Circle {
            return Circle(1.0)
        }
        
        fun calculateArea(radius: Double): Double {
            return PI * radius * radius
        }
    }
    
    fun area(): Double {
        return PI * radius * radius
    }
    
    fun circumference(): Double {
        return 2 * PI * radius
    }
}

val unitCircle = Circle.createUnitCircle()
println("Площадь единичной окружности: ${unitCircle.area()}") // Выведет: "Площадь единичной окружности: 3.14159"

val area = Circle.calculateArea(2.0)
println("Площадь окружности с радиусом 2: $area") // Выведет: "Площадь окружности с радиусом 2: 12.56636"

println("Значение PI: ${Circle.PI}") // Выведет: "Значение PI: 3.14159"
```

## Объекты-синглтоны (object)

Объекты-синглтоны в Kotlin создаются с использованием ключевого слова `object`:

```kotlin
object AppConfig {
    const val APP_NAME = "MyApp"
    const val APP_VERSION = "1.0.0"
    
    var isDarkTheme = false
    
    fun toggleTheme() {
        isDarkTheme = !isDarkTheme
        println("Тема изменена на: ${if (isDarkTheme) "темную" else "светлую"}")
    }
    
    fun getAppInfo(): String {
        return "$APP_NAME v$APP_VERSION"
    }
}

println(AppConfig.getAppInfo())  // Выведет: "MyApp v1.0.0"
println("Текущая тема: ${if (AppConfig.isDarkTheme) "темная" else "светлая"}") // Выведет: "Текущая тема: светлая"
AppConfig.toggleTheme()          // Выведет: "Тема изменена на: темную"
```

## Вложенные и внутренние классы

### Вложенные классы (nested classes)

Вложенные классы не имеют доступа к членам внешнего класса:

```kotlin
class Outer {
    private val outerProperty = "Внешнее свойство"
    
    class Nested {
        fun getInfo(): String {
            // Нет доступа к outerProperty
            return "Это вложенный класс"
        }
    }
}

val nested = Outer.Nested()
println(nested.getInfo()) // Выведет: "Это вложенный класс"
```

### Внутренние классы (inner classes)

Внутренние классы имеют доступ к членам внешнего класса:

```kotlin
class Outer {
    private val outerProperty = "Внешнее свойство"
    
    inner class Inner {
        fun getInfo(): String {
            // Есть доступ к outerProperty
            return "Это внутренний класс, имеющий доступ к $outerProperty"
        }
    }
}

val outer = Outer()
val inner = outer.Inner()
println(inner.getInfo()) // Выведет: "Это внутренний класс, имеющий доступ к Внешнее свойство"
```

## Практические примеры

### Пример 1: Библиотека

```kotlin
class Book(val title: String, val author: String, val year: Int, var available: Boolean = true) {
    fun checkout(): Boolean {
        if (available) {
            available = false
            return true
        }
        return false
    }
    
    fun returnBook() {
        available = true
    }
    
    fun getInfo(): String {
        return "$title ($year) by $author - ${if (available) "доступна" else "выдана"}"
    }
}

class Library {
    private val books = mutableListOf<Book>()
    
    fun addBook(book: Book) {
        books.add(book)
        println("Книга добавлена: ${book.getInfo()}")
    }
    
    fun findBooksByAuthor(author: String): List<Book> {
        return books.filter { it.author == author }
    }
    
    fun checkoutBook(title: String): Boolean {
        val book = books.find { it.title == title && it.available }
        return if (book != null) {
            book.checkout()
            println("Книга выдана: ${book.getInfo()}")
            true
        } else {
            println("Книга не найдена или уже выдана")
            false
        }
    }
    
    fun returnBook(title: String): Boolean {
        val book = books.find { it.title == title && !it.available }
        return if (book != null) {
            book.returnBook()
            println("Книга возвращена: ${book.getInfo()}")
            true
        } else {
            println("Книга не найдена или уже доступна")
            false
        }
    }
    
    fun listAllBooks() {
        println("Список всех книг:")
        books.forEachIndexed { index, book ->
            println("${index + 1}. ${book.getInfo()}")
        }
    }
}

// Использование
val library = Library()

library.addBook(Book("1984", "Джордж Оруэлл", 1949))
library.addBook(Book("Преступление и наказание", "Федор Достоевский", 1866))
library.addBook(Book("Мастер и Маргарита", "Михаил Булгаков", 1967))
library.addBook(Book("Война и мир", "Лев Толстой", 1869))

library.listAllBooks()

library.checkoutBook("1984")
library.checkoutBook("Война и мир")

library.listAllBooks()

val dostoevskyBooks = library.findBooksByAuthor("Федор Достоевский")
println("Книги Достоевского:")
dostoevskyBooks.forEach { println(it.getInfo()) }

library.returnBook("1984")
library.listAllBooks()
```

### Пример 2: Банк

```kotlin
class BankAccount(
    val accountNumber: String,
    val owner: String,
    initialBalance: Double = 0.0
) {
    private var _balance: Double = initialBalance
    val balance: Double
        get() = _balance
    
    fun deposit(amount: Double): Boolean {
        if (amount <= 0) return false
        
        _balance += amount
        return true
    }
    
    fun withdraw(amount: Double): Boolean {
        if (amount <= 0 || amount > _balance) return false
        
        _balance -= amount
        return true
    }
    
    fun getInfo(): String {
        return "Счет #$accountNumber (владелец: $owner), баланс: $_balance"
    }
}

class Bank(val name: String) {
    private val accounts = mutableMapOf<String, BankAccount>()
    
    fun createAccount(owner: String, initialBalance: Double = 0.0): String {
        val accountNumber = generateAccountNumber()
        val account = BankAccount(accountNumber, owner, initialBalance)
        accounts[accountNumber] = account
        println("Создан новый счет: ${account.getInfo()}")
        return accountNumber
    }
    
    fun getAccount(accountNumber: String): BankAccount? {
        return accounts[accountNumber]
    }
    
    fun deposit(accountNumber: String, amount: Double): Boolean {
        val account = accounts[accountNumber] ?: return false
        
        val success = account.deposit(amount)
        if (success) {
            println("Внесено $amount на счет #$accountNumber. Новый баланс: ${account.balance}")
        } else {
            println("Ошибка: некорректная сумма для внесения")
        }
        
        return success
    }
    
    fun withdraw(accountNumber: String, amount: Double): Boolean {
        val account = accounts[accountNumber] ?: return false
        
        val success = account.withdraw(amount)
        if (success) {
            println("Снято $amount со счета #$accountNumber. Новый баланс: ${account.balance}")
        } else {
            println("Ошибка: некорректная сумма или недостаточно средств")
        }
        
        return success
    }
    
    fun transfer(fromAccountNumber: String, toAccountNumber: String, amount: Double): Boolean {
        val fromAccount = accounts[fromAccountNumber]
        val toAccount = accounts[toAccountNumber]
        
        if (fromAccount == null || toAccount == null || amount <= 0 || fromAccount.balance < amount) {
            println("Ошибка: невозможно выполнить перевод")
            return false
        }
        
        fromAccount.withdraw(amount)
        toAccount.deposit(amount)
        
        println("Перевод $amount со счета #$fromAccountNumber на счет #$toAccountNumber выполнен успешно")
        println("Баланс отправителя: ${fromAccount.balance}")
        println("Баланс получателя: ${toAccount.balance}")
        
        return true
    }
    
    fun listAllAccounts() {
        println("Список всех счетов в банке $name:")
        accounts.values.forEach { println(it.getInfo()) }
    }
    
    private fun generateAccountNumber(): String {
        // Простая генерация номера счета
        return (1000000 + accounts.size + 1).toString()
    }
}

// Использование
val bank = Bank("МойБанк")

val account1 = bank.createAccount("Иван Иванов", 1000.0)
val account2 = bank.createAccount("Мария Петрова", 500.0)

bank.listAllAccounts()

bank.deposit(account1, 500.0)
bank.withdraw(account2, 200.0)

bank.transfer(account1, account2, 300.0)

bank.listAllAccounts()
```

## Заключение

В этом уроке мы рассмотрели основы объектно-ориентированного программирования в Kotlin, включая классы, объекты, конструкторы, свойства и методы.

Ключевые особенности классов и объектов в Kotlin:
- Классы объявляются с использованием ключевого слова `class`
- Для создания объектов не используется ключевое слово `new`
- Первичный конструктор является частью заголовка класса
- Параметры первичного конструктора могут быть объявлены как свойства с использованием `val` или `var`
- Блоки инициализации (`init`) выполняются при создании объекта
- Вторичные конструкторы объявляются с использованием ключевого слова `constructor`
- Kotlin автоматически генерирует геттеры и сеттеры для свойств
- Классы данных (`data class`) автоматически реализуют методы `equals()`, `hashCode()`, `toString()` и другие
- Объекты-компаньоны (`companion object`) позволяют определять статические члены класса
- Объекты-синглтоны (`object`) создаются с использованием ключевого слова `object`
- Вложенные классы (`nested class`) не имеют доступа к членам внешнего класса
- Внутренние классы (`inner class`) имеют доступ к членам внешнего класса

Понимание классов и объектов является фундаментальным для эффективного программирования на Kotlin и создания хорошо структурированных, поддерживаемых приложений. 