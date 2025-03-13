# Урок 10: Наследование и интерфейсы в Kotlin

## Введение

Наследование и интерфейсы являются фундаментальными концепциями объектно-ориентированного программирования, которые позволяют создавать гибкие и расширяемые иерархии классов. В Kotlin эти концепции реализованы с некоторыми особенностями, которые делают код более безопасным и выразительным.

В этом уроке мы рассмотрим, как работает наследование в Kotlin, как использовать интерфейсы, и как эти механизмы помогают в создании хорошо структурированного кода.

## Наследование в Kotlin

### Особенности наследования в Kotlin

В отличие от многих других языков программирования, в Kotlin классы по умолчанию являются **final** (финальными), что означает, что они не могут быть унаследованы. Это сделано для обеспечения безопасности типов и предотвращения непреднамеренного наследования.

Чтобы разрешить наследование, необходимо использовать модификатор `open`:

```kotlin
open class Animal {
    // Этот класс может быть унаследован
}

class Dog : Animal() {
    // Dog наследуется от Animal
}
```

### Наследование и конструкторы

При наследовании необходимо вызвать конструктор базового класса:

```kotlin
open class Animal(val name: String) {
    // Базовый класс с параметром
}

class Dog(name: String, val breed: String) : Animal(name) {
    // Вызов конструктора базового класса
}
```

### Переопределение методов

Методы в Kotlin также по умолчанию являются final. Чтобы разрешить переопределение метода, необходимо использовать модификатор `open`:

```kotlin
open class Animal {
    open fun makeSound() {
        println("Какой-то звук животного")
    }
    
    fun sleep() {
        println("Животное спит")
    }
}

class Dog : Animal() {
    override fun makeSound() {
        println("Гав-гав!")
    }
    
    // Нельзя переопределить метод sleep, так как он не помечен как open
}
```

При переопределении метода необходимо использовать ключевое слово `override`. Это помогает избежать случайного переопределения методов и делает код более понятным.

### Переопределение свойств

Свойства также могут быть переопределены, если они помечены как `open`:

```kotlin
open class Animal {
    open val sound: String = "Какой-то звук"
}

class Dog : Animal() {
    override val sound: String = "Гав-гав!"
}
```

Вы можете переопределить свойство `val` свойством `var`, но не наоборот:

```kotlin
open class Animal {
    open val sound: String = "Какой-то звук"
}

class Dog : Animal() {
    override var sound: String = "Гав-гав!"
}
```

### Вызов реализации суперкласса

Для вызова реализации метода из суперкласса используется ключевое слово `super`:

```kotlin
open class Animal {
    open fun makeSound() {
        println("Какой-то звук животного")
    }
}

class Dog : Animal() {
    override fun makeSound() {
        super.makeSound() // Вызов реализации из Animal
        println("Гав-гав!")
    }
}
```

### Абстрактные классы

Абстрактные классы в Kotlin объявляются с использованием ключевого слова `abstract`. Они не могут быть инстанцированы и могут содержать абстрактные методы и свойства:

```kotlin
abstract class Animal {
    abstract val sound: String
    
    abstract fun makeSound()
    
    fun sleep() {
        println("Животное спит")
    }
}

class Dog : Animal() {
    override val sound: String = "Гав-гав!"
    
    override fun makeSound() {
        println(sound)
    }
}
```

Абстрактные методы и свойства не имеют реализации в абстрактном классе и должны быть переопределены в подклассах. Абстрактные методы и свойства автоматически являются `open`, поэтому не требуют явного указания этого модификатора.

## Интерфейсы в Kotlin

### Объявление интерфейсов

Интерфейсы в Kotlin объявляются с использованием ключевого слова `interface`:

```kotlin
interface Soundable {
    fun makeSound()
}
```

### Реализация интерфейсов

Классы могут реализовывать один или несколько интерфейсов:

```kotlin
class Dog : Soundable {
    override fun makeSound() {
        println("Гав-гав!")
    }
}

// Реализация нескольких интерфейсов
interface Runnable {
    fun run()
}

class Dog : Soundable, Runnable {
    override fun makeSound() {
        println("Гав-гав!")
    }
    
    override fun run() {
        println("Собака бежит")
    }
}
```

### Свойства в интерфейсах

Интерфейсы в Kotlin могут содержать абстрактные свойства:

```kotlin
interface Soundable {
    val sound: String
    
    fun makeSound() {
        println(sound)
    }
}

class Dog : Soundable {
    override val sound: String = "Гав-гав!"
}
```

### Методы с реализацией по умолчанию

В отличие от Java до версии 8, интерфейсы в Kotlin могут содержать методы с реализацией по умолчанию:

```kotlin
interface Soundable {
    val sound: String
    
    fun makeSound() {
        println(sound)
    }
}

class Dog : Soundable {
    override val sound: String = "Гав-гав!"
    // Не обязательно переопределять makeSound, так как он имеет реализацию по умолчанию
}
```

### Разрешение конфликтов при множественном наследовании

Когда класс реализует несколько интерфейсов с методами, имеющими одинаковые сигнатуры, возникает конфликт, который необходимо разрешить явно:

```kotlin
interface A {
    fun foo() {
        println("A")
    }
}

interface B {
    fun foo() {
        println("B")
    }
}

class C : A, B {
    override fun foo() {
        super<A>.foo() // Вызов реализации из A
        super<B>.foo() // Вызов реализации из B
        println("C")
    }
}
```

## Делегирование интерфейсов

Kotlin предоставляет механизм делегирования интерфейсов, который позволяет реализовать паттерн "Делегирование" без лишнего шаблонного кода:

```kotlin
interface Engine {
    fun start()
    fun stop()
}

class ElectricEngine : Engine {
    override fun start() {
        println("Электрический двигатель запущен")
    }
    
    override fun stop() {
        println("Электрический двигатель остановлен")
    }
}

// Делегирование реализации интерфейса Engine объекту engine
class Car(private val engine: Engine) : Engine by engine {
    // Дополнительные методы и свойства
}

// Использование
val electricEngine = ElectricEngine()
val car = Car(electricEngine)
car.start() // Вызывает start() из ElectricEngine
```

В этом примере класс `Car` делегирует реализацию интерфейса `Engine` объекту `engine`. Это означает, что все методы интерфейса `Engine` будут автоматически реализованы в классе `Car` путем вызова соответствующих методов объекта `engine`.

## Запечатанные классы (sealed classes)

Запечатанные классы в Kotlin представляют собой особый вид абстрактных классов, которые ограничивают иерархию наследования. Подклассы запечатанного класса должны быть объявлены в том же файле, что и сам запечатанный класс:

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

Запечатанные классы особенно полезны при работе с выражением `when`, так как компилятор может проверить, что все возможные случаи обработаны, и не требуется ветка `else`.

## Практические примеры

### Пример 1: Иерархия геометрических фигур

```kotlin
abstract class Shape {
    abstract fun area(): Double
    abstract fun perimeter(): Double
    
    fun printInfo() {
        println("Площадь: ${area()}, Периметр: ${perimeter()}")
    }
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double = Math.PI * radius * radius
    
    override fun perimeter(): Double = 2 * Math.PI * radius
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun area(): Double = width * height
    
    override fun perimeter(): Double = 2 * (width + height)
}

class Square(val side: Double) : Shape() {
    override fun area(): Double = side * side
    
    override fun perimeter(): Double = 4 * side
}

// Использование
val circle = Circle(5.0)
val rectangle = Rectangle(4.0, 6.0)
val square = Square(3.0)

circle.printInfo()
rectangle.printInfo()
square.printInfo()
```

### Пример 2: Система уведомлений

```kotlin
interface NotificationSender {
    fun send(message: String, recipient: String)
}

class EmailSender : NotificationSender {
    override fun send(message: String, recipient: String) {
        println("Отправка email: '$message' на адрес $recipient")
    }
}

class SMSSender : NotificationSender {
    override fun send(message: String, recipient: String) {
        println("Отправка SMS: '$message' на номер $recipient")
    }
}

class PushSender : NotificationSender {
    override fun send(message: String, recipient: String) {
        println("Отправка Push-уведомления: '$message' пользователю $recipient")
    }
}

class NotificationService(private val senders: List<NotificationSender>) {
    fun notify(message: String, recipient: String) {
        senders.forEach { it.send(message, recipient) }
    }
}

// Использование
val emailSender = EmailSender()
val smsSender = SMSSender()
val pushSender = PushSender()

val service = NotificationService(listOf(emailSender, smsSender, pushSender))
service.notify("Важное сообщение", "user123")
```

### Пример 3: Обработка платежей

```kotlin
interface PaymentProcessor {
    fun process(amount: Double): Boolean
}

class CreditCardProcessor : PaymentProcessor {
    override fun process(amount: Double): Boolean {
        println("Обработка платежа кредитной картой на сумму $amount")
        // Логика обработки платежа
        return true
    }
}

class PayPalProcessor : PaymentProcessor {
    override fun process(amount: Double): Boolean {
        println("Обработка платежа через PayPal на сумму $amount")
        // Логика обработки платежа
        return true
    }
}

class BankTransferProcessor : PaymentProcessor {
    override fun process(amount: Double): Boolean {
        println("Обработка банковского перевода на сумму $amount")
        // Логика обработки платежа
        return true
    }
}

sealed class PaymentResult {
    data class Success(val transactionId: String) : PaymentResult()
    data class Failure(val errorCode: Int, val message: String) : PaymentResult()
    object Processing : PaymentResult()
}

class PaymentService(private val processor: PaymentProcessor) {
    fun makePayment(amount: Double): PaymentResult {
        return try {
            val success = processor.process(amount)
            if (success) {
                PaymentResult.Success("TX-${System.currentTimeMillis()}")
            } else {
                PaymentResult.Failure(1001, "Платеж не удался")
            }
        } catch (e: Exception) {
            PaymentResult.Failure(1002, "Ошибка при обработке платежа: ${e.message}")
        }
    }
}

// Использование
val creditCardProcessor = CreditCardProcessor()
val paymentService = PaymentService(creditCardProcessor)

val result = paymentService.makePayment(100.0)
when (result) {
    is PaymentResult.Success -> println("Платеж успешно обработан. ID транзакции: ${result.transactionId}")
    is PaymentResult.Failure -> println("Ошибка платежа: ${result.message} (код: ${result.errorCode})")
    is PaymentResult.Processing -> println("Платеж в обработке")
}
```

## Заключение

В этом уроке мы рассмотрели основы наследования и интерфейсов в Kotlin:

- Особенности наследования в Kotlin, включая модификатор `open`
- Переопределение методов и свойств с использованием ключевого слова `override`
- Абстрактные классы и их применение
- Интерфейсы и их реализация
- Методы с реализацией по умолчанию в интерфейсах
- Разрешение конфликтов при множественном наследовании
- Делегирование интерфейсов
- Запечатанные классы и их преимущества

Наследование и интерфейсы являются мощными инструментами объектно-ориентированного программирования, которые позволяют создавать гибкие и расширяемые иерархии классов. Kotlin предоставляет дополнительные возможности и гарантии безопасности, которые делают использование этих механизмов более удобным и надежным. 