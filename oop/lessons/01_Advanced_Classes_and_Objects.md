# Урок 1: Углубленное изучение классов и объектов в Kotlin

## Введение

В этом уроке мы углубимся в изучение классов и объектов в Kotlin, рассмотрим продвинутые концепции и паттерны, которые помогут вам создавать более гибкий, поддерживаемый и эффективный код.

Мы уже знакомы с основами классов и объектов из базового курса, но Kotlin предлагает множество дополнительных возможностей, которые делают работу с объектно-ориентированным программированием более удобной и выразительной.

## Конструкторы и инициализация

### Первичный конструктор с блоками инициализации

В Kotlin первичный конструктор является частью заголовка класса, а блоки инициализации позволяют выполнять дополнительную логику при создании объекта:

```kotlin
class Person(val name: String, var age: Int) {
    val isAdult: Boolean
    
    init {
        println("Инициализация объекта Person")
        isAdult = age >= 18
    }
    
    init {
        // Можно иметь несколько блоков инициализации
        println("Создан объект: $name, $age лет")
    }
}
```

Блоки `init` выполняются в порядке их объявления и могут обращаться к параметрам первичного конструктора.

### Порядок инициализации

Важно понимать порядок инициализации в Kotlin:

1. Инициализация свойств, объявленных в теле класса
2. Выполнение блоков инициализации в порядке их объявления
3. Выполнение кода вторичных конструкторов

```kotlin
class InitializationOrder(val name: String) {
    val firstProperty = "Первое свойство: $name".also(::println)
    
    init {
        println("Первый блок инициализации: $name")
    }
    
    val secondProperty = "Второе свойство: $name".also(::println)
    
    init {
        println("Второй блок инициализации: $name")
    }
    
    constructor(name: String, age: Int) : this(name) {
        println("Вторичный конструктор: $name, $age")
    }
}

// Вывод при вызове InitializationOrder("Test", 25):
// Первое свойство: Test
// Первый блок инициализации: Test
// Второе свойство: Test
// Второй блок инициализации: Test
// Вторичный конструктор: Test, 25
```

### Фабричные методы

Вместо множества конструкторов часто удобнее использовать фабричные методы в объекте-компаньоне:

```kotlin
class User private constructor(
    val id: Int,
    val name: String,
    val email: String?,
    val isVerified: Boolean
) {
    companion object {
        fun createVerifiedUser(id: Int, name: String, email: String): User {
            return User(id, name, email, true)
        }
        
        fun createUnverifiedUser(id: Int, name: String): User {
            return User(id, name, null, false)
        }
        
        fun fromDatabase(userData: Map<String, Any>): User {
            return User(
                id = userData["id"] as Int,
                name = userData["name"] as String,
                email = userData["email"] as String?,
                isVerified = userData["verified"] as Boolean
            )
        }
    }
}

// Использование
val user1 = User.createVerifiedUser(1, "Алексей", "alex@example.com")
val user2 = User.createUnverifiedUser(2, "Мария")
```

Этот подход имеет несколько преимуществ:
- Более выразительные имена методов, объясняющие их назначение
- Возможность выполнять дополнительную логику перед созданием объекта
- Возможность возвращать кешированные объекты или null
- Возможность возвращать подтипы класса

## Продвинутые свойства

### Ленивая инициализация с lazy

Для свойств, инициализация которых требует значительных ресурсов, можно использовать делегат `lazy`:

```kotlin
class ExpensiveResource {
    val heavyData: List<String> by lazy {
        println("Инициализация heavyData")
        loadDataFromDatabase() // Выполняется только при первом обращении
    }
    
    private fun loadDataFromDatabase(): List<String> {
        // Имитация загрузки данных
        Thread.sleep(1000)
        return listOf("Data1", "Data2", "Data3")
    }
}

val resource = ExpensiveResource()
// heavyData еще не инициализирован
println(resource.heavyData) // Выполняется инициализация
println(resource.heavyData) // Используется уже инициализированное значение
```

Делегат `lazy` по умолчанию является потокобезопасным (synchronized). Если вам не требуется потокобезопасность, можно использовать `LazyThreadSafetyMode.NONE` для повышения производительности:

```kotlin
val nonThreadSafeData by lazy(LazyThreadSafetyMode.NONE) {
    // Инициализация
}
```

### Наблюдаемые свойства с observable

Делегат `observable` позволяет отслеживать изменения свойства:

```kotlin
class User {
    var name: String by Delegates.observable("") { property, oldValue, newValue ->
        println("$property изменено: $oldValue -> $newValue")
    }
    
    var age: Int by Delegates.observable(0) { _, oldValue, newValue ->
        println("Возраст изменен: $oldValue -> $newValue")
    }
}

val user = User()
user.name = "Алексей" // Выведет: name изменено:  -> Алексей
user.age = 30 // Выведет: Возраст изменен: 0 -> 30
```

### Проверяемые свойства с vetoable

Делегат `vetoable` позволяет проверять и отклонять изменения свойства:

```kotlin
class User {
    var age: Int by Delegates.vetoable(0) { _, oldValue, newValue ->
        if (newValue in 0..150) {
            true // Разрешить изменение
        } else {
            println("Недопустимый возраст: $newValue")
            false // Отклонить изменение
        }
    }
}

val user = User()
user.age = 30 // Установит значение 30
user.age = 200 // Выведет: Недопустимый возраст: 200, значение останется 30
println(user.age) // 30
```

### Делегирование свойств в Map

Kotlin позволяет делегировать свойства объекта в Map, что удобно для динамического создания объектов:

```kotlin
class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
    val email: String? by map
}

val userData = mapOf(
    "name" to "Алексей",
    "age" to 30,
    "email" to "alex@example.com"
)

val user = User(userData)
println("${user.name}, ${user.age}, ${user.email}")
```

Для изменяемых свойств можно использовать `MutableMap`:

```kotlin
class MutableUser(val map: MutableMap<String, Any?>) {
    var name: String by map
    var age: Int by map
}

val userMap = mutableMapOf(
    "name" to "Алексей",
    "age" to 30
)

val user = MutableUser(userMap)
user.name = "Александр"
println(userMap["name"]) // Александр
```

## Объекты и объекты-компаньоны

### Расширенное использование объектов-компаньонов

Объекты-компаньоны могут реализовывать интерфейсы, что позволяет использовать их в более сложных сценариях:

```kotlin
interface Factory<T> {
    fun create(): T
}

class MyClass private constructor(val value: String) {
    companion object : Factory<MyClass> {
        override fun create(): MyClass {
            return MyClass("Default")
        }
        
        fun createWithValue(value: String): MyClass {
            return MyClass(value)
        }
    }
}

// Использование
val obj1 = MyClass.create()
val obj2 = MyClass.createWithValue("Custom")

// Использование через интерфейс
fun <T> createInstance(factory: Factory<T>): T {
    return factory.create()
}

val obj3 = createInstance(MyClass)
```

### Объекты для реализации паттерна Singleton

Объекты в Kotlin идеально подходят для реализации паттерна Singleton:

```kotlin
object DatabaseConnection {
    private var connectionString = ""
    private var isConnected = false
    
    fun configure(host: String, port: Int, database: String) {
        connectionString = "jdbc:mysql://$host:$port/$database"
    }
    
    fun connect() {
        if (!isConnected) {
            println("Подключение к $connectionString")
            // Логика подключения
            isConnected = true
        }
    }
    
    fun disconnect() {
        if (isConnected) {
            println("Отключение от базы данных")
            // Логика отключения
            isConnected = false
        }
    }
    
    fun executeQuery(query: String): List<String> {
        if (!isConnected) {
            throw IllegalStateException("Нет подключения к базе данных")
        }
        println("Выполнение запроса: $query")
        return listOf("Результат 1", "Результат 2")
    }
}

// Использование
DatabaseConnection.configure("localhost", 3306, "mydb")
DatabaseConnection.connect()
val results = DatabaseConnection.executeQuery("SELECT * FROM users")
DatabaseConnection.disconnect()
```

### Анонимные объекты для одноразовых реализаций

Анонимные объекты удобны для создания одноразовых реализаций интерфейсов:

```kotlin
interface ClickListener {
    fun onClick(x: Int, y: Int)
    fun onLongClick(x: Int, y: Int)
}

fun registerClickListener(listener: ClickListener) {
    // Регистрация слушателя
}

// Использование анонимного объекта
registerClickListener(object : ClickListener {
    override fun onClick(x: Int, y: Int) {
        println("Клик по координатам ($x, $y)")
    }
    
    override fun onLongClick(x: Int, y: Int) {
        println("Долгий клик по координатам ($x, $y)")
    }
})
```

Анонимные объекты могут также захватывать переменные из окружающего контекста:

```kotlin
fun createLogger(tag: String): (String) -> Unit {
    return { message ->
        val logger = object {
            val timestamp = System.currentTimeMillis()
            
            fun log() {
                println("[$tag][$timestamp] $message")
            }
        }
        logger.log()
    }
}

val appLogger = createLogger("APP")
appLogger("Приложение запущено")
```

## Вложенные и внутренние классы

### Вложенные классы (nested classes)

Вложенные классы не имеют доступа к внешнему классу и часто используются для группировки связанных классов:

```kotlin
class Outer {
    private val outerValue = "Внешнее значение"
    
    class Nested {
        fun nestedMethod() {
            // Нет доступа к outerValue
            println("Метод вложенного класса")
        }
    }
}

// Использование
val nested = Outer.Nested()
nested.nestedMethod()
```

### Внутренние классы (inner classes)

Внутренние классы имеют доступ к внешнему классу и часто используются для создания вспомогательных классов, тесно связанных с внешним классом:

```kotlin
class Outer {
    private val outerValue = "Внешнее значение"
    
    inner class Inner {
        fun innerMethod() {
            // Имеет доступ к outerValue
            println("Внутренний метод, доступ к $outerValue")
        }
    }
    
    fun createInner(): Inner {
        return Inner()
    }
}

// Использование
val outer = Outer()
val inner = outer.Inner()
inner.innerMethod()

// Или
val inner2 = outer.createInner()
```

### Локальные классы

Классы могут быть объявлены внутри функций:

```kotlin
fun processData(data: List<String>): List<String> {
    // Локальный класс, видимый только внутри функции
    class Processor {
        fun process(item: String): String {
            return item.uppercase()
        }
    }
    
    val processor = Processor()
    return data.map { processor.process(it) }
}
```

## Продвинутые техники

### Инлайн-классы (value classes)

Инлайн-классы (ранее называвшиеся value classes) позволяют создавать обертки над примитивными типами без дополнительных затрат на выделение памяти:

```kotlin
@JvmInline
value class UserId(val id: Int)

@JvmInline
value class EmailAddress(val email: String) {
    init {
        require(email.contains("@")) { "Неверный формат email" }
    }
    
    val domain: String
        get() = email.substringAfter("@")
}

// Использование
fun getUserById(userId: UserId): User {
    // Реализация
}

val userId = UserId(1001)
val user = getUserById(userId)

val email = EmailAddress("user@example.com")
println(email.domain) // example.com
```

Инлайн-классы компилируются в базовый тип, но предоставляют типобезопасность на уровне компиляции.

### Деструктурирующие объявления

Деструктурирующие объявления позволяют извлекать несколько значений из объекта в одном выражении:

```kotlin
data class Person(val name: String, val age: Int, val email: String)

val person = Person("Алексей", 30, "alex@example.com")
val (name, age, email) = person

println("$name, $age, $email")
```

Для не-data классов можно реализовать функции `componentN()`:

```kotlin
class Point(val x: Int, val y: Int) {
    operator fun component1() = x
    operator fun component2() = y
}

val point = Point(10, 20)
val (x, y) = point
```

### Делегирование классов

Делегирование классов позволяет реализовать паттерн "Декоратор" без лишнего шаблонного кода:

```kotlin
interface Printer {
    fun print(message: String)
}

class ConsolePrinter : Printer {
    override fun print(message: String) {
        println(message)
    }
}

class LoggingPrinter(private val printer: Printer) : Printer by printer {
    override fun print(message: String) {
        println("[LOG] Печать сообщения: $message")
        printer.print(message)
    }
}

class FormattingPrinter(private val printer: Printer) : Printer by printer {
    override fun print(message: String) {
        printer.print("=== $message ===")
    }
}

// Использование
val consolePrinter = ConsolePrinter()
val loggingPrinter = LoggingPrinter(consolePrinter)
val formattingLoggingPrinter = FormattingPrinter(loggingPrinter)

formattingLoggingPrinter.print("Привет, мир!")
// Вывод:
// [LOG] Печать сообщения: === Привет, мир! ===
// === Привет, мир! ===
```

### Типобезопасные строители (DSL)

Kotlin позволяет создавать предметно-ориентированные языки (DSL) с помощью лямбд с получателем:

```kotlin
class HTMLBuilder {
    private val content = StringBuilder()
    
    fun h1(text: String) {
        content.append("<h1>$text</h1>")
    }
    
    fun p(text: String) {
        content.append("<p>$text</p>")
    }
    
    fun div(init: DIVBuilder.() -> Unit) {
        val div = DIVBuilder()
        div.init()
        content.append(div.build())
    }
    
    fun build(): String = content.toString()
}

class DIVBuilder {
    private val content = StringBuilder()
    
    fun p(text: String) {
        content.append("<p>$text</p>")
    }
    
    fun span(text: String) {
        content.append("<span>$text</span>")
    }
    
    fun build(): String = "<div>${content.toString()}</div>"
}

fun html(init: HTMLBuilder.() -> Unit): String {
    val builder = HTMLBuilder()
    builder.init()
    return builder.build()
}

// Использование
val htmlContent = html {
    h1("Заголовок страницы")
    p("Параграф текста")
    div {
        p("Текст внутри div")
        span("Span внутри div")
    }
}

println(htmlContent)
```

## Практические примеры

### Пример 1: Создание билдера для сложного объекта

```kotlin
class Person private constructor(
    val name: String,
    val age: Int,
    val address: String?,
    val email: String?,
    val phone: String?
) {
    class Builder {
        private var name: String = ""
        private var age: Int = 0
        private var address: String? = null
        private var email: String? = null
        private var phone: String? = null
        
        fun name(name: String) = apply { this.name = name }
        fun age(age: Int) = apply { this.age = age }
        fun address(address: String?) = apply { this.address = address }
        fun email(email: String?) = apply { this.email = email }
        fun phone(phone: String?) = apply { this.phone = phone }
        
        fun build(): Person {
            require(name.isNotBlank()) { "Имя не может быть пустым" }
            require(age >= 0) { "Возраст не может быть отрицательным" }
            
            return Person(name, age, address, email, phone)
        }
    }
    
    override fun toString(): String {
        return "Person(name='$name', age=$age, address=$address, email=$email, phone=$phone)"
    }
}

// Использование
val person = Person.Builder()
    .name("Алексей")
    .age(30)
    .email("alex@example.com")
    .build()

println(person)
```

### Пример 2: Реализация паттерна "Наблюдатель"

```kotlin
interface Observer {
    fun update(data: Any)
}

class Subject {
    private val observers = mutableListOf<Observer>()
    
    fun addObserver(observer: Observer) {
        observers.add(observer)
    }
    
    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }
    
    fun notifyObservers(data: Any) {
        observers.forEach { it.update(data) }
    }
}

class DataSource : Subject() {
    var data: String = ""
        set(value) {
            field = value
            notifyObservers(value)
        }
}

class Display : Observer {
    override fun update(data: Any) {
        println("Дисплей обновлен: $data")
    }
}

class Logger : Observer {
    override fun update(data: Any) {
        println("Запись в лог: $data в ${System.currentTimeMillis()}")
    }
}

// Использование
val dataSource = DataSource()
val display = Display()
val logger = Logger()

dataSource.addObserver(display)
dataSource.addObserver(logger)

dataSource.data = "Новые данные"
```

### Пример 3: Реализация паттерна "Стратегия"

```kotlin
interface PaymentStrategy {
    fun pay(amount: Double): Boolean
}

class CreditCardPayment(
    private val cardNumber: String,
    private val cvv: String,
    private val expiryDate: String
) : PaymentStrategy {
    override fun pay(amount: Double): Boolean {
        println("Оплата $amount через кредитную карту $cardNumber")
        // Логика обработки платежа
        return true
    }
}

class PayPalPayment(
    private val email: String,
    private val password: String
) : PaymentStrategy {
    override fun pay(amount: Double): Boolean {
        println("Оплата $amount через PayPal аккаунт $email")
        // Логика обработки платежа
        return true
    }
}

class ShoppingCart {
    private val items = mutableListOf<Pair<String, Double>>()
    
    fun addItem(name: String, price: Double) {
        items.add(name to price)
    }
    
    fun calculateTotal(): Double {
        return items.sumOf { it.second }
    }
    
    fun checkout(paymentStrategy: PaymentStrategy): Boolean {
        val amount = calculateTotal()
        return paymentStrategy.pay(amount)
    }
}

// Использование
val cart = ShoppingCart()
cart.addItem("Ноутбук", 1200.0)
cart.addItem("Мышь", 25.0)

val creditCardPayment = CreditCardPayment("1234-5678-9012-3456", "123", "12/25")
val payPalPayment = PayPalPayment("user@example.com", "password")

// Выбор стратегии оплаты
val success = cart.checkout(creditCardPayment)
println("Платеж ${if (success) "успешен" else "не удался"}")
```

## Заключение

В этом уроке мы рассмотрели продвинутые концепции и техники работы с классами и объектами в Kotlin:

- Углубленное понимание конструкторов и порядка инициализации
- Продвинутые свойства с делегатами (lazy, observable, vetoable)
- Расширенное использование объектов и объектов-компаньонов
- Вложенные, внутренние и локальные классы
- Инлайн-классы для эффективных оберток
- Деструктурирующие объявления
- Делегирование классов
- Типобезопасные строители (DSL)
- Практические примеры реализации паттернов проектирования

Эти концепции и техники позволяют создавать более гибкий, поддерживаемый и эффективный код на Kotlin, используя все преимущества объектно-ориентированного программирования. 