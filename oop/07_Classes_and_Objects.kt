/**
 * Урок 7: Классы и объекты в Kotlin
 * 
 * В этом уроке мы рассмотрим основы объектно-ориентированного программирования в Kotlin:
 * классы, объекты, конструкторы, свойства и методы.
 */

fun main() {
    println("Урок 7: Классы и объекты в Kotlin")
    println("=================================")
    
    // ======== Создание и использование объектов ========
    
    println("\n=== Создание и использование объектов ===")
    
    // Создание объекта класса Person
    val person1 = Person("Иван", 30)
    println("Создан объект: $person1")
    
    // Доступ к свойствам
    println("Имя: ${person1.name}")
    println("Возраст: ${person1.age}")
    
    // Вызов методов
    person1.sayHello()
    person1.celebrateBirthday()
    println("Возраст после дня рождения: ${person1.age}")
    
    // ======== Конструкторы ========
    
    println("\n=== Конструкторы ===")
    
    // Использование первичного конструктора
    val book1 = Book("1984", "Джордж Оруэлл", 1949)
    println("Книга: ${book1.title} (${book1.author}, ${book1.year})")
    
    // Использование вторичного конструктора
    val book2 = Book("Мастер и Маргарита", "Михаил Булгаков")
    println("Книга: ${book2.title} (${book2.author}, ${book2.year})")
    
    // Использование конструктора с блоком инициализации
    val rectangle = Rectangle(5.0, 3.0)
    println("Прямоугольник: ширина=${rectangle.width}, высота=${rectangle.height}")
    println("Площадь: ${rectangle.area}")
    println("Периметр: ${rectangle.perimeter}")
    
    // ======== Свойства и поля ========
    
    println("\n=== Свойства и поля ===")
    
    // Использование свойств с геттерами и сеттерами
    val user = User("user123", "password123")
    println("Пользователь: ${user.username}")
    println("Пароль (скрытый): ${user.password}")
    
    // Изменение свойств
    user.password = "newPassword456"
    println("Новый пароль (скрытый): ${user.password}")
    
    // Использование свойства с пользовательским геттером
    println("Длина пароля: ${user.passwordLength}")
    
    // Использование позднеинициализируемого свойства
    val student = Student("Мария")
    // println(student.university) // Вызовет UninitializedPropertyAccessException
    
    student.enrollToUniversity("МГУ")
    println("${student.name} учится в ${student.university}")
    
    // ======== Модификаторы доступа ========
    
    println("\n=== Модификаторы доступа ===")
    
    val bankAccount = BankAccount("123456789", 1000.0)
    println("Счет: ${bankAccount.accountNumber}")
    println("Баланс: ${bankAccount.balance}")
    
    bankAccount.deposit(500.0)
    println("Баланс после пополнения: ${bankAccount.balance}")
    
    bankAccount.withdraw(200.0)
    println("Баланс после снятия: ${bankAccount.balance}")
    
    // Нельзя напрямую изменить приватное свойство
    // bankAccount.balance = 5000.0 // Ошибка компиляции
    
    // ======== Классы данных (data classes) ========
    
    println("\n=== Классы данных (data classes) ===")
    
    val product1 = Product("Ноутбук", "Электроника", 75000.0)
    val product2 = Product("Ноутбук", "Электроника", 75000.0)
    val product3 = Product("Смартфон", "Электроника", 45000.0)
    
    // Автоматически сгенерированный метод toString()
    println("Продукт 1: $product1")
    
    // Автоматически сгенерированный метод equals()
    println("product1 == product2: ${product1 == product2}") // true
    println("product1 == product3: ${product1 == product3}") // false
    
    // Автоматически сгенерированный метод hashCode()
    println("product1.hashCode(): ${product1.hashCode()}")
    println("product2.hashCode(): ${product2.hashCode()}")
    
    // Автоматически сгенерированный метод copy()
    val product4 = product1.copy(price = 80000.0)
    println("Копия с новой ценой: $product4")
    
    // Деструктурирование
    val (name, category, price) = product1
    println("Деструктурирование: name=$name, category=$category, price=$price")
    
    // ======== Объекты-компаньоны (companion objects) ========
    
    println("\n=== Объекты-компаньоны (companion objects) ===")
    
    // Использование фабричного метода из объекта-компаньона
    val circle1 = Circle.createWithDiameter(10.0)
    println("Круг с диаметром 10: радиус=${circle1.radius}, площадь=${circle1.area()}")
    
    // Доступ к константам из объекта-компаньона
    println("Число π: ${Circle.PI}")
    
    // Счетчик созданных экземпляров
    println("Создано кругов: ${Circle.createdCount}")
    
    val circle2 = Circle(5.0)
    println("Создано кругов: ${Circle.createdCount}")
    
    // ======== Объекты (object) ========
    
    println("\n=== Объекты (object) ===")
    
    // Использование объекта-синглтона
    println("Текущая конфигурация: ${AppConfig.serverUrl}")
    
    AppConfig.serverUrl = "https://new-api.example.com"
    println("Новая конфигурация: ${AppConfig.serverUrl}")
    
    // Вызов метода объекта
    AppConfig.printConfig()
    
    // Использование анонимного объекта
    val comparator = object : Comparator<String> {
        override fun compare(s1: String, s2: String): Int {
            return s1.length - s2.length
        }
    }
    
    val strings = listOf("aaa", "a", "aa", "aaaa")
    val sorted = strings.sortedWith(comparator)
    println("Отсортированные строки по длине: $sorted")
    
    // ======== Вложенные и внутренние классы ========
    
    println("\n=== Вложенные и внутренние классы ===")
    
    // Использование вложенного класса
    val outer = Outer()
    val nested = Outer.Nested()
    nested.printInfo()
    
    // Использование внутреннего класса
    val inner = outer.Inner()
    inner.printInfo()
    
    // ======== Практические примеры ========
    
    println("\n=== Практические примеры ===")
    
    // Пример 1: Библиотека
    val library = Library()
    
    library.addBook(Book("1984", "Джордж Оруэлл", 1949))
    library.addBook(Book("Преступление и наказание", "Федор Достоевский", 1866))
    library.addBook(Book("Мастер и Маргарита", "Михаил Булгаков", 1967))
    
    println("\nВсе книги в библиотеке:")
    library.printAllBooks()
    
    println("\nПоиск книг по автору 'Булгаков':")
    val bulgarovBooks = library.findBooksByAuthor("Булгаков")
    bulgarovBooks.forEach { println(it) }
    
    // Пример 2: Банковская система
    val bank = Bank("Мой Банк")
    
    val account1 = bank.createAccount("Иван Иванов", 1000.0)
    val account2 = bank.createAccount("Мария Петрова", 2000.0)
    
    println("\nСчета в банке ${bank.name}:")
    bank.printAllAccounts()
    
    bank.transferMoney(account1.accountNumber, account2.accountNumber, 500.0)
    
    println("\nСчета после перевода:")
    bank.printAllAccounts()
}

// ======== Определения классов ========

// Простой класс с первичным конструктором
class Person(val name: String, var age: Int) {
    // Метод
    fun sayHello() {
        println("Привет, меня зовут $name!")
    }
    
    // Метод, изменяющий состояние объекта
    fun celebrateBirthday() {
        age++
        println("С днем рождения, $name! Теперь тебе $age лет.")
    }
    
    // Переопределение метода toString()
    override fun toString(): String {
        return "Person(name=$name, age=$age)"
    }
}

// Класс с первичным и вторичным конструкторами
class Book(val title: String, val author: String, val year: Int) {
    // Вторичный конструктор
    constructor(title: String, author: String) : this(title, author, 0) {
        println("Создана книга без указания года: $title")
    }
    
    override fun toString(): String {
        return "Book(title=$title, author=$author, year=$year)"
    }
}

// Класс с блоком инициализации
class Rectangle(val width: Double, val height: Double) {
    val area: Double
    val perimeter: Double
    
    // Блок инициализации выполняется при создании объекта
    init {
        area = width * height
        perimeter = 2 * (width + height)
        println("Создан прямоугольник с площадью $area")
    }
}

// Класс с пользовательскими геттерами и сеттерами
class User(val username: String, password: String) {
    // Приватное поле для хранения пароля
    private var _password: String = password
    
    // Свойство с пользовательским геттером и сеттером
    var password: String
        get() = "*".repeat(_password.length) // Возвращаем звездочки вместо реального пароля
        set(value) {
            if (value.length < 6) {
                println("Пароль слишком короткий!")
            } else {
                _password = value
                println("Пароль успешно изменен")
            }
        }
    
    // Свойство только для чтения с пользовательским геттером
    val passwordLength: Int
        get() = _password.length
}

// Класс с позднеинициализируемым свойством
class Student(val name: String) {
    // Свойство, которое будет инициализировано позже
    lateinit var university: String
    
    fun enrollToUniversity(universityName: String) {
        university = universityName
        println("$name зачислен(а) в $university")
    }
    
    fun isEnrolled(): Boolean {
        return ::university.isInitialized
    }
}

// Класс с приватными свойствами и публичными методами
class BankAccount(val accountNumber: String, initialBalance: Double) {
    // Приватное свойство, доступное только внутри класса
    private var _balance: Double = initialBalance
    
    // Публичное свойство только для чтения
    val balance: Double
        get() = _balance
    
    // Публичные методы для работы с приватным свойством
    fun deposit(amount: Double) {
        if (amount > 0) {
            _balance += amount
            println("Внесено $amount на счет $accountNumber")
        } else {
            println("Сумма пополнения должна быть положительной")
        }
    }
    
    fun withdraw(amount: Double) {
        if (amount > 0) {
            if (_balance >= amount) {
                _balance -= amount
                println("Снято $amount со счета $accountNumber")
            } else {
                println("Недостаточно средств на счете")
            }
        } else {
            println("Сумма снятия должна быть положительной")
        }
    }
}

// Класс данных (data class)
data class Product(val name: String, val category: String, val price: Double)

// Класс с объектом-компаньоном
class Circle(val radius: Double) {
    // Объект-компаньон
    companion object {
        // Константа
        const val PI = 3.14159
        
        // Счетчик созданных экземпляров
        var createdCount = 0
            private set
        
        // Фабричный метод
        fun createWithDiameter(diameter: Double): Circle {
            return Circle(diameter / 2)
        }
    }
    
    // Блок инициализации
    init {
        createdCount++
    }
    
    // Метод экземпляра
    fun area(): Double {
        return PI * radius * radius
    }
}

// Объект (синглтон)
object AppConfig {
    var serverUrl = "https://api.example.com"
    var timeout = 30
    var maxRetries = 3
    
    fun printConfig() {
        println("Конфигурация:")
        println("- URL: $serverUrl")
        println("- Таймаут: $timeout сек.")
        println("- Макс. попыток: $maxRetries")
    }
}

// Класс с вложенным и внутренним классами
class Outer {
    private val outerProperty = "Внешнее свойство"
    
    // Вложенный класс (не имеет доступа к членам внешнего класса)
    class Nested {
        fun printInfo() {
            println("Это вложенный класс")
            // Нет доступа к outerProperty
        }
    }
    
    // Внутренний класс (имеет доступ к членам внешнего класса)
    inner class Inner {
        fun printInfo() {
            println("Это внутренний класс")
            println("Он имеет доступ к $outerProperty")
        }
    }
}

// Класс для примера с библиотекой
class Library {
    private val books = mutableListOf<Book>()
    
    fun addBook(book: Book) {
        books.add(book)
    }
    
    fun findBooksByAuthor(author: String): List<Book> {
        return books.filter { it.author.contains(author, ignoreCase = true) }
    }
    
    fun printAllBooks() {
        books.forEachIndexed { index, book ->
            println("${index + 1}. ${book.title} (${book.author}, ${book.year})")
        }
    }
}

// Классы для примера с банковской системой
class Bank(val name: String) {
    private val accounts = mutableMapOf<String, BankAccount>()
    
    fun createAccount(ownerName: String, initialBalance: Double): BankAccount {
        val accountNumber = generateAccountNumber()
        val account = BankAccount(accountNumber, initialBalance)
        accounts[accountNumber] = account
        println("Создан счет $accountNumber для $ownerName с балансом $initialBalance")
        return account
    }
    
    fun transferMoney(fromAccount: String, toAccount: String, amount: Double) {
        val from = accounts[fromAccount]
        val to = accounts[toAccount]
        
        if (from == null || to == null) {
            println("Один из счетов не найден")
            return
        }
        
        if (from.balance < amount) {
            println("Недостаточно средств на счете $fromAccount")
            return
        }
        
        from.withdraw(amount)
        to.deposit(amount)
        println("Перевод $amount со счета $fromAccount на счет $toAccount выполнен успешно")
    }
    
    fun printAllAccounts() {
        accounts.forEach { (accountNumber, account) ->
            println("Счет $accountNumber: баланс ${account.balance}")
        }
    }
    
    private fun generateAccountNumber(): String {
        return "ACC" + (10000..99999).random()
    }
} 