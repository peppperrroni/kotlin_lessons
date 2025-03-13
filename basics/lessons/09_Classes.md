# Урок 9: Классы и объекты в Kotlin

## Введение

Классы и объекты являются фундаментальными концепциями объектно-ориентированного программирования (ООП). Kotlin предоставляет мощные и гибкие средства для работы с классами, которые делают код более лаконичным, выразительным и безопасным по сравнению с другими языками программирования.

В этом уроке мы рассмотрим основы создания и использования классов и объектов в Kotlin, а также различные специальные типы классов, которые предлагает язык.

## Объявление классов

### Базовый синтаксис

В Kotlin класс объявляется с использованием ключевого слова `class`:

```kotlin
class Person {
    // Свойства и методы класса
}
```

### Конструкторы

#### Первичный конструктор

Первичный конструктор является частью заголовка класса:

```kotlin
class Person(val name: String, var age: Int) {
    // Тело класса
}
```

В этом примере:
- `val name: String` - неизменяемое свойство (только для чтения)
- `var age: Int` - изменяемое свойство (для чтения и записи)

#### Блок инициализации

Блок инициализации выполняется при создании экземпляра класса:

```kotlin
class Person(val name: String, var age: Int) {
    init {
        println("Создан новый объект Person: $name, $age лет")
        
        // Проверка входных данных
        require(age >= 0) { "Возраст не может быть отрицательным" }
    }
}
```

#### Вторичные конструкторы

Вторичные конструкторы объявляются с использованием ключевого слова `constructor`:

```kotlin
class Person(val name: String, var age: Int) {
    var email: String = ""
    
    // Вторичный конструктор
    constructor(name: String, age: Int, email: String) : this(name, age) {
        this.email = email
    }
}
```

Вторичный конструктор должен вызывать первичный конструктор (прямо или косвенно) с помощью ключевого слова `this`.

### Создание экземпляров класса

В Kotlin для создания экземпляра класса не требуется ключевое слово `new`:

```kotlin
val person1 = Person("Алексей", 30)
val person2 = Person("Мария", 25, "maria@example.com")
```

## Свойства

### Объявление свойств

Свойства в Kotlin могут быть объявлены как изменяемые (`var`) или неизменяемые (`val`):

```kotlin
class Person {
    val name: String = "Неизвестно" // Неизменяемое свойство
    var age: Int = 0 // Изменяемое свойство
}
```

### Геттеры и сеттеры

Kotlin автоматически генерирует геттеры и сеттеры для свойств, но вы можете определить их самостоятельно:

```kotlin
class Person {
    var name: String = "Неизвестно"
        get() = field.uppercase() // Пользовательский геттер
        set(value) {
            if (value.isNotBlank()) {
                field = value // field - это специальный идентификатор для доступа к свойству
            }
        }
}
```

### Свойства с поздней инициализацией

Для свойств, которые будут инициализированы после создания объекта, можно использовать модификатор `lateinit`:

```kotlin
class Person {
    lateinit var job: String
    
    fun setJob(newJob: String) {
        job = newJob
    }
    
    fun displayJob() {
        if (::job.isInitialized) {
            println("Работа: $job")
        } else {
            println("Работа еще не установлена")
        }
    }
}
```

### Ленивая инициализация

Для свойств, которые требуют дорогостоящей инициализации, можно использовать делегат `lazy`:

```kotlin
class Person(val name: String) {
    val profile: String by lazy {
        // Дорогостоящая операция, выполняется только при первом обращении к свойству
        println("Загрузка профиля для $name...")
        "Профиль для $name"
    }
}
```

## Методы

### Объявление методов

Методы в Kotlin объявляются с использованием ключевого слова `fun`:

```kotlin
class Person(val name: String, var age: Int) {
    fun greet(): String {
        return "Привет, меня зовут $name, мне $age лет"
    }
    
    fun celebrateBirthday() {
        age++
        println("С днем рождения, $name! Теперь тебе $age лет")
    }
}
```

### Методы-выражения

Если метод состоит из одного выражения, его можно записать в сокращенной форме:

```kotlin
class Person(val name: String, var age: Int) {
    fun greet() = "Привет, меня зовут $name, мне $age лет"
}
```

## Видимость и модификаторы доступа

Kotlin предоставляет следующие модификаторы видимости:

- `public` (по умолчанию): видимость везде
- `private`: видимость только внутри класса
- `protected`: видимость внутри класса и его подклассов
- `internal`: видимость внутри модуля

```kotlin
class Person {
    public val name: String = "Публичное свойство"
    private val ssn: String = "123-45-6789" // Только внутри класса
    protected val birthDate: String = "01.01.1990" // Внутри класса и подклассов
    internal val address: String = "Москва" // Внутри модуля
    
    private fun privateMethod() {
        // Только внутри класса
    }
    
    protected fun protectedMethod() {
        // Внутри класса и подклассов
    }
}
```

## Наследование

### Базовый класс и подкласс

В Kotlin все классы по умолчанию являются `final` (не могут быть унаследованы). Чтобы разрешить наследование, нужно использовать модификатор `open`:

```kotlin
open class Person(val name: String, var age: Int) {
    open fun greet() = "Привет, меня зовут $name"
}

class Employee(name: String, age: Int, val position: String) : Person(name, age) {
    override fun greet() = "${super.greet()}, я работаю как $position"
}
```

### Абстрактные классы

Абстрактные классы не могут быть инстанцированы и могут содержать абстрактные методы:

```kotlin
abstract class Shape {
    abstract fun area(): Double
    abstract fun perimeter(): Double
    
    fun printInfo() {
        println("Площадь: ${area()}, Периметр: ${perimeter()}")
    }
}

class Circle(val radius: Double) : Shape() {
    override fun area() = Math.PI * radius * radius
    override fun perimeter() = 2 * Math.PI * radius
}
```

## Интерфейсы

Интерфейсы в Kotlin могут содержать абстрактные методы, а также методы с реализацией по умолчанию:

```kotlin
interface Clickable {
    fun click() // Абстрактный метод
    
    fun showOff() = println("Я кликабельный!") // Метод с реализацией по умолчанию
}

class Button : Clickable {
    override fun click() {
        println("Кнопка была нажата")
    }
}
```

### Множественное наследование интерфейсов

Класс может реализовывать несколько интерфейсов:

```kotlin
interface Clickable {
    fun click()
    fun showOff() = println("Я кликабельный!")
}

interface Focusable {
    fun setFocus(focus: Boolean)
    fun showOff() = println("Я в фокусе!")
}

class Button : Clickable, Focusable {
    override fun click() {
        println("Кнопка была нажата")
    }
    
    override fun setFocus(focus: Boolean) {
        println("Кнопка ${if (focus) "получила" else "потеряла"} фокус")
    }
    
    // При конфликте методов с реализацией по умолчанию необходимо явно переопределить метод
    override fun showOff() {
        super<Clickable>.showOff() // Вызов реализации из Clickable
        super<Focusable>.showOff() // Вызов реализации из Focusable
    }
}
```

## Специальные типы классов

### Классы данных (data classes)

Классы данных предназначены для хранения данных и автоматически реализуют методы `equals()`, `hashCode()`, `toString()` и `copy()`:

```kotlin
data class User(val name: String, val age: Int, val email: String)

val user1 = User("Алексей", 30, "alex@example.com")
val user2 = User("Алексей", 30, "alex@example.com")

println(user1 == user2) // true, благодаря автоматической реализации equals()
println(user1) // User(name=Алексей, age=30, email=alex@example.com), благодаря toString()

val user3 = user1.copy(age = 31) // Создание копии с изменением одного свойства
```

### Перечисления (enum classes)

Перечисления представляют набор констант:

```kotlin
enum class Color {
    RED, GREEN, BLUE
}

// Перечисления с свойствами и методами
enum class Direction(val degrees: Int) {
    NORTH(0), EAST(90), SOUTH(180), WEST(270);
    
    fun opposite(): Direction {
        return when (this) {
            NORTH -> SOUTH
            EAST -> WEST
            SOUTH -> NORTH
            WEST -> EAST
        }
    }
}
```

### Запечатанные классы (sealed classes)

Запечатанные классы ограничивают иерархию наследования и полезны для представления ограниченного набора типов:

```kotlin
sealed class Result {
    data class Success(val data: Any) : Result()
    data class Error(val message: String, val exception: Exception? = null) : Result()
    object Loading : Result()
}

fun handleResult(result: Result) {
    when (result) {
        is Result.Success -> println("Успех: ${result.data}")
        is Result.Error -> println("Ошибка: ${result.message}")
        is Result.Loading -> println("Загрузка...")
        // Не требуется ветка else, так как все возможные подклассы известны
    }
}
```

### Объекты (object)

#### Объект-синглтон

Объект-синглтон - это класс, у которого существует только один экземпляр:

```kotlin
object DatabaseConnection {
    private var connected = false
    
    fun connect() {
        connected = true
        println("Подключение к базе данных установлено")
    }
    
    fun disconnect() {
        connected = false
        println("Подключение к базе данных закрыто")
    }
    
    fun isConnected() = connected
}

// Использование
DatabaseConnection.connect()
println("Подключено: ${DatabaseConnection.isConnected()}")
```

#### Объект-компаньон (companion object)

Объект-компаньон - это объект, связанный с классом, аналог статических членов в других языках:

```kotlin
class User(val name: String) {
    companion object {
        const val MAX_NAME_LENGTH = 50
        
        fun validateName(name: String): Boolean {
            return name.isNotBlank() && name.length <= MAX_NAME_LENGTH
        }
        
        fun createUser(name: String): User? {
            return if (validateName(name)) User(name) else null
        }
    }
}

// Использование
val isValid = User.validateName("Алексей")
val user = User.createUser("Алексей")
```

#### Анонимные объекты

Анонимные объекты используются для создания одноразовых объектов, реализующих интерфейсы:

```kotlin
interface ClickListener {
    fun onClick()
}

fun setClickListener(listener: ClickListener) {
    // Обработка клика
    listener.onClick()
}

// Использование анонимного объекта
setClickListener(object : ClickListener {
    override fun onClick() {
        println("Клик обработан")
    }
})
```

## Вложенные и внутренние классы

### Вложенные классы (nested classes)

Вложенные классы объявляются внутри другого класса и не имеют доступа к внешнему классу:

```kotlin
class Outer {
    private val outerProperty = "Внешнее свойство"
    
    class Nested {
        fun nestedMethod() = "Метод вложенного класса"
        // Нет доступа к outerProperty
    }
}

// Использование
val nested = Outer.Nested()
println(nested.nestedMethod())
```

### Внутренние классы (inner classes)

Внутренние классы объявляются с ключевым словом `inner` и имеют доступ к внешнему классу:

```kotlin
class Outer {
    private val outerProperty = "Внешнее свойство"
    
    inner class Inner {
        fun innerMethod() = "Внутренний метод, доступ к $outerProperty"
    }
}

// Использование
val outer = Outer()
val inner = outer.Inner()
println(inner.innerMethod())
```

## Делегирование

Kotlin поддерживает делегирование на уровне языка, что позволяет реализовать паттерн "Делегирование" без лишнего шаблонного кода:

```kotlin
interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        println(x)
    }
}

class Derived(b: Base) : Base by b {
    // Класс Derived делегирует реализацию интерфейса Base объекту b
}

// Использование
val base = BaseImpl(10)
val derived = Derived(base)
derived.print() // Выведет: 10
```

### Делегирование свойств

Kotlin также поддерживает делегирование свойств:

```kotlin
class User {
    // Делегирование свойства стандартному делегату lazy
    val email: String by lazy {
        println("Вычисление email...")
        "user@example.com"
    }
    
    // Делегирование свойства карте
    val properties = mapOf("name" to "Алексей", "age" to 30)
    val name: String by properties
    val age: Int by properties
}

// Использование
val user = User()
println(user.name) // Алексей
println(user.age) // 30
println(user.email) // Вычисление email... user@example.com
```

## Практические примеры

### Пример 1: Банковский счет

```kotlin
class BankAccount(val accountNumber: String, val owner: String) {
    private var _balance: Double = 0.0
    
    val balance: Double
        get() = _balance
    
    fun deposit(amount: Double) {
        require(amount > 0) { "Сумма депозита должна быть положительной" }
        _balance += amount
        println("Депозит: $amount. Новый баланс: $_balance")
    }
    
    fun withdraw(amount: Double): Boolean {
        require(amount > 0) { "Сумма снятия должна быть положительной" }
        
        if (_balance >= amount) {
            _balance -= amount
            println("Снятие: $amount. Новый баланс: $_balance")
            return true
        }
        
        println("Недостаточно средств для снятия $amount. Текущий баланс: $_balance")
        return false
    }
    
    override fun toString(): String {
        return "BankAccount(accountNumber='$accountNumber', owner='$owner', balance=$_balance)"
    }
}

// Использование
val account = BankAccount("123456789", "Алексей Петров")
account.deposit(1000.0)
account.withdraw(500.0)
account.withdraw(700.0) // Недостаточно средств
println(account)
```

### Пример 2: Система управления задачами

```kotlin
enum class TaskPriority { LOW, MEDIUM, HIGH }
enum class TaskStatus { TODO, IN_PROGRESS, DONE }

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    var priority: TaskPriority = TaskPriority.MEDIUM,
    var status: TaskStatus = TaskStatus.TODO,
    val createdAt: Long = System.currentTimeMillis()
)

class TaskManager {
    private val tasks = mutableListOf<Task>()
    
    fun addTask(task: Task) {
        tasks.add(task)
    }
    
    fun removeTask(id: Int): Boolean {
        return tasks.removeIf { it.id == id }
    }
    
    fun updateTaskStatus(id: Int, status: TaskStatus): Boolean {
        val task = tasks.find { it.id == id } ?: return false
        task.status = status
        return true
    }
    
    fun getTasksByStatus(status: TaskStatus): List<Task> {
        return tasks.filter { it.status == status }
    }
    
    fun getTasksByPriority(priority: TaskPriority): List<Task> {
        return tasks.filter { it.priority == priority }
    }
    
    fun getAllTasks(): List<Task> {
        return tasks.toList()
    }
}

// Использование
val taskManager = TaskManager()

taskManager.addTask(Task(1, "Изучить Kotlin", "Изучить основы языка Kotlin", TaskPriority.HIGH))
taskManager.addTask(Task(2, "Написать приложение", "Создать простое приложение на Kotlin"))
taskManager.addTask(Task(3, "Опубликовать приложение", "Опубликовать приложение в магазине", TaskPriority.LOW))

taskManager.updateTaskStatus(1, TaskStatus.IN_PROGRESS)
taskManager.updateTaskStatus(2, TaskStatus.TODO)

val inProgressTasks = taskManager.getTasksByStatus(TaskStatus.IN_PROGRESS)
println("Задачи в процессе: ${inProgressTasks.map { it.title }}")

val highPriorityTasks = taskManager.getTasksByPriority(TaskPriority.HIGH)
println("Высокоприоритетные задачи: ${highPriorityTasks.map { it.title }}")
```

### Пример 3: Обработка результатов операций

```kotlin
sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val message: String, val exception: Exception? = null) : Result<Nothing>()
    object Loading : Result<Nothing>()
    
    fun isSuccess() = this is Success
    fun isError() = this is Error
    fun isLoading() = this is Loading
    
    fun getOrNull(): T? = when (this) {
        is Success -> data
        else -> null
    }
    
    fun getOrDefault(defaultValue: @UnsafeVariance T): T = when (this) {
        is Success -> data
        else -> defaultValue
    }
}

class UserRepository {
    private val users = mapOf(
        1 to "Алексей",
        2 to "Мария",
        3 to "Иван"
    )
    
    fun getUser(id: Int): Result<String> {
        return try {
            Thread.sleep(1000) // Имитация сетевого запроса
            
            val user = users[id]
            if (user != null) {
                Result.Success(user)
            } else {
                Result.Error("Пользователь с ID $id не найден")
            }
        } catch (e: Exception) {
            Result.Error("Ошибка при получении пользователя", e)
        }
    }
}

// Использование
val repository = UserRepository()

fun displayUser(id: Int) {
    println("Загрузка пользователя...")
    
    when (val result = repository.getUser(id)) {
        is Result.Success -> println("Пользователь: ${result.data}")
        is Result.Error -> println("Ошибка: ${result.message}")
        is Result.Loading -> println("Загрузка...")
    }
}

displayUser(1) // Пользователь: Алексей
displayUser(5) // Ошибка: Пользователь с ID 5 не найден
```

## Заключение

В этом уроке мы рассмотрели основы работы с классами и объектами в Kotlin, включая:

- Объявление классов и конструкторов
- Свойства и методы
- Видимость и модификаторы доступа
- Наследование и интерфейсы
- Специальные типы классов (data classes, enum classes, sealed classes)
- Объекты и объекты-компаньоны
- Вложенные и внутренние классы
- Делегирование

Kotlin предоставляет мощные и гибкие средства для работы с классами, которые делают код более лаконичным, выразительным и безопасным. Понимание этих концепций является важной частью эффективного программирования на Kotlin. 