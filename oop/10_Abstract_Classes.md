# Урок 10: Абстрактные классы в Kotlin

## Введение

Абстрактные классы в Kotlin представляют собой важный инструмент объектно-ориентированного программирования, который позволяет определять общую функциональность и структуру для группы связанных классов. В отличие от обычных классов, абстрактные классы не могут быть инстанцированы напрямую — они предназначены для наследования другими классами.

В этом уроке мы рассмотрим, как создавать и использовать абстрактные классы в Kotlin, их особенности и отличия от интерфейсов, а также практические примеры их применения.

## Основы абстрактных классов

### Объявление абстрактного класса

Абстрактный класс объявляется с использованием ключевого слова `abstract`:

```kotlin
abstract class Shape(val name: String) {
    // Абстрактный метод (без реализации)
    abstract fun calculateArea(): Double
    
    // Абстрактный метод (без реализации)
    abstract fun calculatePerimeter(): Double
    
    // Обычный метод с реализацией
    fun printInfo() {
        println("Фигура: $name")
        println("Площадь: ${calculateArea()}")
        println("Периметр: ${calculatePerimeter()}")
    }
}
```

### Наследование от абстрактного класса

Для создания класса, наследующегося от абстрактного класса, необходимо реализовать все его абстрактные методы:

```kotlin
class Circle(name: String, val radius: Double) : Shape(name) {
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
    
    override fun calculatePerimeter(): Double {
        return 2 * Math.PI * radius
    }
}

class Rectangle(name: String, val width: Double, val height: Double) : Shape(name) {
    override fun calculateArea(): Double {
        return width * height
    }
    
    override fun calculatePerimeter(): Double {
        return 2 * (width + height)
    }
}
```

### Использование абстрактных классов

```kotlin
// Нельзя создать экземпляр абстрактного класса
// val shape = Shape("Абстрактная фигура") // Ошибка компиляции

// Создание экземпляров конкретных подклассов
val circle = Circle("Круг", 5.0)
val rectangle = Rectangle("Прямоугольник", 4.0, 6.0)

// Вызов методов
circle.printInfo()
rectangle.printInfo()
```

## Абстрактные методы и свойства

### Абстрактные методы

Абстрактные методы объявляются с ключевым словом `abstract` и не имеют реализации:

```kotlin
abstract class Animal(val name: String) {
    // Абстрактные методы
    abstract fun makeSound()
    abstract fun move()
}

class Cat(name: String) : Animal(name) {
    override fun makeSound() {
        println("$name мяукает: Мяу!")
    }
    
    override fun move() {
        println("$name крадется")
    }
}

class Dog(name: String) : Animal(name) {
    override fun makeSound() {
        println("$name лает: Гав-гав!")
    }
    
    override fun move() {
        println("$name бежит")
    }
}
```

### Абстрактные свойства

Абстрактные свойства также объявляются с ключевым словом `abstract` и должны быть реализованы в подклассах:

```kotlin
abstract class Vehicle {
    // Абстрактное свойство
    abstract val maxSpeed: Int
    
    // Абстрактное свойство с геттером
    abstract val fuelType: String
    
    fun displaySpecs() {
        println("Максимальная скорость: $maxSpeed км/ч")
        println("Тип топлива: $fuelType")
    }
}

class Car : Vehicle() {
    // Реализация абстрактных свойств
    override val maxSpeed: Int = 200
    override val fuelType: String = "Бензин"
}

class ElectricCar : Vehicle() {
    // Реализация абстрактных свойств
    override val maxSpeed: Int = 180
    override val fuelType: String = "Электричество"
}
```

## Сравнение абстрактных классов и интерфейсов

Абстрактные классы и интерфейсы имеют схожие черты, но также и важные различия:

### Абстрактные классы с состоянием

В отличие от интерфейсов, абстрактные классы могут иметь состояние (свойства с инициализацией):

```kotlin
abstract class Animal(val name: String, var age: Int) {
    // Свойство с состоянием
    var isHungry: Boolean = true
    
    // Абстрактный метод
    abstract fun makeSound()
    
    // Обычный метод с реализацией
    fun feed() {
        isHungry = false
        println("$name больше не голоден")
    }
}

class Cat(name: String, age: Int) : Animal(name, age) {
    override fun makeSound() {
        println("$name мяукает: Мяу!")
    }
}

class Dog(name: String, age: Int) : Animal(name, age) {
    override fun makeSound() {
        println("$name лает: Гав-гав!")
    }
}
```

### Наследование от абстрактных классов

Класс может наследоваться только от одного абстрактного класса, но может реализовывать несколько интерфейсов:

```kotlin
// Наследование от абстрактного класса
class Square(name: String, val side: Double) : Rectangle(name, side, side) {
    // Square наследуется от Rectangle, который наследуется от Shape
    // Нет необходимости переопределять методы, так как они уже реализованы в Rectangle
}
```

## Абстрактные классы с конструкторами

Абстрактные классы могут иметь конструкторы, которые вызываются при создании экземпляров подклассов:

```kotlin
abstract class Vehicle(val brand: String, val model: String) {
    init {
        println("Инициализация транспортного средства: $brand $model")
    }
    
    abstract fun start()
    abstract fun drive()
    abstract fun stop()
}

class Sedan(brand: String, model: String, val color: String) : Vehicle(brand, model) {
    override fun start() {
        println("$brand $model заводится")
    }
    
    override fun drive() {
        println("$brand $model едет по дороге")
    }
    
    override fun stop() {
        println("$brand $model останавливается")
    }
}

class Truck(brand: String, model: String, val loadCapacity: Double) : Vehicle(brand, model) {
    override fun start() {
        println("$brand $model заводится с громким шумом")
    }
    
    override fun drive() {
        println("$brand $model медленно движется по дороге")
    }
    
    override fun stop() {
        println("$brand $model медленно останавливается")
    }
}
```

## Полиморфизм с абстрактными классами

Абстрактные классы позволяют использовать полиморфизм, обрабатывая объекты разных подклассов через ссылку на абстрактный класс:

```kotlin
// Создание списка фигур разных типов
val shapes = listOf(
    Circle("Маленький круг", 3.0),
    Rectangle("Большой прямоугольник", 10.0, 5.0),
    Circle("Большой круг", 7.0),
    Rectangle("Квадрат", 4.0, 4.0)
)

// Полиморфный вызов методов
println("Информация о фигурах:")
shapes.forEach { shape ->
    shape.printInfo()
    println()
}

// Поиск фигуры с наибольшей площадью
val largestShape = shapes.maxByOrNull { it.calculateArea() }
println("Фигура с наибольшей площадью: ${largestShape?.name} (${largestShape?.calculateArea()})")
```

## Практические примеры

### Пример 1: Система обработки платежей

```kotlin
// Абстрактный класс для обработки платежей
abstract class PaymentProcessor(val name: String) {
    // Общие свойства
    var isConnected: Boolean = false
    
    // Общие методы
    fun connect() {
        isConnected = true
        println("Подключение к платежной системе $name")
    }
    
    fun disconnect() {
        isConnected = false
        println("Отключение от платежной системы $name")
    }
    
    // Абстрактные методы
    abstract fun processPayment(amount: Double): Boolean
    abstract fun refundPayment(transactionId: String): Boolean
}

// Конкретные реализации
class CreditCardPayment : PaymentProcessor("Кредитная карта") {
    override fun processPayment(amount: Double): Boolean {
        if (!isConnected) {
            println("Ошибка: нет подключения к платежной системе")
            return false
        }
        
        println("Обработка платежа по кредитной карте на сумму $amount руб.")
        return true
    }
    
    override fun refundPayment(transactionId: String): Boolean {
        if (!isConnected) {
            println("Ошибка: нет подключения к платежной системе")
            return false
        }
        
        println("Возврат платежа по кредитной карте, транзакция: $transactionId")
        return true
    }
}

class PayPalPayment : PaymentProcessor("PayPal") {
    override fun processPayment(amount: Double): Boolean {
        if (!isConnected) {
            println("Ошибка: нет подключения к платежной системе")
            return false
        }
        
        println("Обработка платежа через PayPal на сумму $amount руб.")
        return true
    }
    
    override fun refundPayment(transactionId: String): Boolean {
        if (!isConnected) {
            println("Ошибка: нет подключения к платежной системе")
            return false
        }
        
        println("Возврат платежа через PayPal, транзакция: $transactionId")
        return true
    }
}

class CryptoPayment : PaymentProcessor("Криптовалюта") {
    override fun processPayment(amount: Double): Boolean {
        if (!isConnected) {
            println("Ошибка: нет подключения к платежной системе")
            return false
        }
        
        println("Обработка платежа в криптовалюте на сумму $amount руб.")
        return true
    }
    
    override fun refundPayment(transactionId: String): Boolean {
        if (!isConnected) {
            println("Ошибка: нет подключения к платежной системе")
            return false
        }
        
        println("Возврат платежа в криптовалюте, транзакция: $transactionId")
        return true
    }
}

// Использование
val paymentProcessors = listOf(
    CreditCardPayment(),
    PayPalPayment(),
    CryptoPayment()
)

// Обработка платежей через разные системы
paymentProcessors.forEach { processor ->
    processor.connect()
    processor.processPayment(100.0)
    processor.refundPayment("TX12345")
    processor.disconnect()
    println()
}
```

### Пример 2: Система уведомлений

```kotlin
// Абстрактный класс для уведомлений
abstract class Notification(val title: String, val message: String) {
    // Общие свойства
    var isSent: Boolean = false
    
    // Общие методы
    fun markAsSent() {
        isSent = true
    }
    
    // Абстрактные методы
    abstract fun send(): Boolean
    abstract fun getDeliveryInfo(): String
}

// Конкретные реализации
class EmailNotification(
    title: String,
    message: String,
    val recipient: String
) : Notification(title, message) {
    override fun send(): Boolean {
        println("Отправка email на адрес $recipient")
        println("Тема: $title")
        println("Сообщение: $message")
        markAsSent()
        return true
    }
    
    override fun getDeliveryInfo(): String {
        return if (isSent) {
            "Email отправлен на адрес $recipient"
        } else {
            "Email не отправлен"
        }
    }
}

class SMSNotification(
    title: String,
    message: String,
    val phoneNumber: String
) : Notification(title, message) {
    override fun send(): Boolean {
        println("Отправка SMS на номер $phoneNumber")
        println("Сообщение: $message")
        markAsSent()
        return true
    }
    
    override fun getDeliveryInfo(): String {
        return if (isSent) {
            "SMS отправлено на номер $phoneNumber"
        } else {
            "SMS не отправлено"
        }
    }
}

class PushNotification(
    title: String,
    message: String,
    val deviceId: String
) : Notification(title, message) {
    override fun send(): Boolean {
        println("Отправка Push-уведомления на устройство $deviceId")
        println("Заголовок: $title")
        println("Сообщение: $message")
        markAsSent()
        return true
    }
    
    override fun getDeliveryInfo(): String {
        return if (isSent) {
            "Push-уведомление отправлено на устройство $deviceId"
        } else {
            "Push-уведомление не отправлено"
        }
    }
}

// Использование
val notifications = listOf(
    EmailNotification("Важное сообщение", "Ваш заказ готов", "user@example.com"),
    SMSNotification("Код подтверждения", "Ваш код: 1234", "+7-123-456-7890"),
    PushNotification("Новое сообщение", "У вас новое сообщение от Анны", "device-123")
)

// Отправка уведомлений
notifications.forEach { notification ->
    notification.send()
    println(notification.getDeliveryInfo())
    println()
}
```

### Пример 3: Система генерации отчетов

```kotlin
// Абстрактный класс для генерации отчетов
abstract class Report(val title: String, val data: List<String>) {
    // Общие свойства
    val creationDate = java.time.LocalDateTime.now()
    
    // Общие методы
    fun getHeader(): String {
        return """
            Отчет: $title
            Дата создания: $creationDate
            Количество записей: ${data.size}
        """.trimIndent()
    }
    
    // Абстрактные методы
    abstract fun generate(): String
    abstract fun save(filePath: String): Boolean
}

// Конкретные реализации
class PDFReport(title: String, data: List<String>) : Report(title, data) {
    override fun generate(): String {
        val content = StringBuilder()
        content.append("PDF ОТЧЕТ\n")
        content.append(getHeader())
        content.append("\n\nСОДЕРЖИМОЕ:\n")
        
        data.forEachIndexed { index, item ->
            content.append("${index + 1}. $item\n")
        }
        
        return content.toString()
    }
    
    override fun save(filePath: String): Boolean {
        println("Сохранение PDF отчета в файл: $filePath")
        // Здесь был бы код для сохранения PDF
        return true
    }
}

class ExcelReport(title: String, data: List<String>) : Report(title, data) {
    override fun generate(): String {
        val content = StringBuilder()
        content.append("EXCEL ОТЧЕТ\n")
        content.append(getHeader())
        content.append("\n\nДАННЫЕ:\n")
        
        content.append("A\tB\tC\n")
        data.forEachIndexed { index, item ->
            content.append("${index + 1}\t$item\tЗначение\n")
        }
        
        return content.toString()
    }
    
    override fun save(filePath: String): Boolean {
        println("Сохранение Excel отчета в файл: $filePath")
        // Здесь был бы код для сохранения Excel
        return true
    }
}

class JSONReport(title: String, data: List<String>) : Report(title, data) {
    override fun generate(): String {
        val content = StringBuilder()
        content.append("{\n")
        content.append("  \"title\": \"$title\",\n")
        content.append("  \"creationDate\": \"$creationDate\",\n")
        content.append("  \"recordCount\": ${data.size},\n")
        content.append("  \"data\": [\n")
        
        data.forEachIndexed { index, item ->
            content.append("    \"$item\"")
            if (index < data.size - 1) {
                content.append(",")
            }
            content.append("\n")
        }
        
        content.append("  ]\n")
        content.append("}")
        
        return content.toString()
    }
    
    override fun save(filePath: String): Boolean {
        println("Сохранение JSON отчета в файл: $filePath")
        // Здесь был бы код для сохранения JSON
        return true
    }
}

// Использование
val reportData = listOf(
    "Продажи в январе: 150000 руб.",
    "Продажи в феврале: 180000 руб.",
    "Продажи в марте: 210000 руб."
)

val reports = listOf(
    PDFReport("Квартальный отчет о продажах", reportData),
    ExcelReport("Квартальный отчет о продажах", reportData),
    JSONReport("Квартальный отчет о продажах", reportData)
)

// Генерация и сохранение отчетов
reports.forEachIndexed { index, report ->
    val content = report.generate()
    println("Отчет #${index + 1}:")
    println(content)
    
    val filePath = "report_${index + 1}.${when(report) {
        is PDFReport -> "pdf"
        is ExcelReport -> "xlsx"
        is JSONReport -> "json"
        else -> "txt"
    }}"
    
    report.save(filePath)
    println()
}
```

## Заключение

Абстрактные классы в Kotlin представляют собой мощный инструмент для создания иерархий классов с общей функциональностью и структурой. Они позволяют определить общий интерфейс и реализацию для группы связанных классов, обеспечивая при этом возможность специализации в подклассах.

Ключевые особенности абстрактных классов в Kotlin:
- Абстрактные классы не могут быть инстанцированы напрямую
- Они могут содержать абстрактные методы и свойства, которые должны быть реализованы в подклассах
- Абстрактные классы могут иметь состояние (свойства с инициализацией) и конструкторы
- Класс может наследоваться только от одного абстрактного класса
- Абстрактные классы поддерживают полиморфизм, позволяя обрабатывать объекты разных подклассов через ссылку на абстрактный класс

При выборе между абстрактными классами и интерфейсами следует руководствоваться следующими принципами:
- Используйте абстрактные классы, когда вам нужно определить общее состояние и поведение для группы связанных классов
- Используйте интерфейсы, когда вам нужно определить контракт, который могут реализовывать несвязанные классы
- Если вам нужно множественное наследование, используйте интерфейсы

Абстрактные классы являются важным инструментом в арсенале разработчика Kotlin, позволяющим создавать гибкие, расширяемые и хорошо структурированные системы. 