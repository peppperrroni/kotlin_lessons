/**
 * Урок 10: Абстрактные классы в Kotlin
 * 
 * В этом уроке мы рассмотрим абстрактные классы в Kotlin, которые позволяют
 * определять общую функциональность и структуру для группы связанных классов.
 */

fun main() {
    println("Урок 10: Абстрактные классы в Kotlin")
    println("====================================")
    
    // ======== Основы абстрактных классов ========
    
    println("\n=== Основы абстрактных классов ===")
    
    // Нельзя создать экземпляр абстрактного класса
    // val shape = Shape() // Ошибка компиляции
    
    // Создание экземпляров конкретных подклассов
    val circle = Circle("Круг", 5.0)
    val rectangle = Rectangle("Прямоугольник", 4.0, 6.0)
    
    // Вызов методов, определенных в абстрактном классе
    circle.printInfo()
    rectangle.printInfo()
    
    // ======== Абстрактные методы и свойства ========
    
    println("\n=== Абстрактные методы и свойства ===")
    
    // Вызов реализаций абстрактных методов
    println("Площадь круга: ${circle.calculateArea()}")
    println("Периметр круга: ${circle.calculatePerimeter()}")
    
    println("Площадь прямоугольника: ${rectangle.calculateArea()}")
    println("Периметр прямоугольника: ${rectangle.calculatePerimeter()}")
    
    // Доступ к абстрактным свойствам
    println("Тип фигуры: ${circle.shapeType}")
    println("Тип фигуры: ${rectangle.shapeType}")
    
    // ======== Абстрактные классы vs интерфейсы ========
    
    println("\n=== Абстрактные классы vs интерфейсы ===")
    
    // Использование абстрактного класса с состоянием
    val cat = Cat("Мурка", 3)
    val dog = Dog("Барон", 5)
    
    cat.makeSound()
    cat.eat()
    cat.sleep()
    
    dog.makeSound()
    dog.eat()
    dog.sleep()
    
    // ======== Наследование от абстрактных классов ========
    
    println("\n=== Наследование от абстрактных классов ===")
    
    // Создание экземпляра класса, наследующегося от абстрактного
    val square = Square("Квадрат", 5.0)
    square.printInfo()
    println("Площадь квадрата: ${square.calculateArea()}")
    println("Периметр квадрата: ${square.calculatePerimeter()}")
    
    // ======== Абстрактные классы с конструкторами ========
    
    println("\n=== Абстрактные классы с конструкторами ===")
    
    val sedan = Sedan("Toyota Camry", 2020, 4)
    val truck = Truck("Ford F-150", 2019, 1500.0)
    
    sedan.start()
    sedan.drive()
    sedan.stop()
    
    truck.start()
    truck.drive()
    truck.stop()
    
    // ======== Абстрактные классы и полиморфизм ========
    
    println("\n=== Абстрактные классы и полиморфизм ===")
    
    // Создание списка объектов абстрактного типа
    val shapes: List<Shape> = listOf(
        Circle("Маленький круг", 2.0),
        Rectangle("Большой прямоугольник", 10.0, 5.0),
        Square("Средний квадрат", 4.0)
    )
    
    // Полиморфный вызов методов
    println("\nИнформация о всех фигурах:")
    shapes.forEach { shape ->
        shape.printInfo()
        println("Площадь: ${shape.calculateArea()}")
        println("Периметр: ${shape.calculatePerimeter()}")
        println()
    }
    
    // Поиск фигуры с наибольшей площадью
    val largestShape = shapes.maxByOrNull { it.calculateArea() }
    println("Фигура с наибольшей площадью: ${largestShape?.name}")
    
    // ======== Практические примеры ========
    
    println("\n=== Практические примеры ===")
    
    // Пример 1: Система обработки платежей
    val creditCardPayment = CreditCardPayment(1000.0, "1234-5678-9012-3456")
    val paypalPayment = PayPalPayment(500.0, "user@example.com")
    val cryptoPayment = CryptoPayment(250.0, "0x1a2b3c4d5e6f")
    
    println("\nОбработка платежей:")
    processPayment(creditCardPayment)
    processPayment(paypalPayment)
    processPayment(cryptoPayment)
    
    // Пример 2: Система уведомлений
    val emailNotification = EmailNotification("user@example.com", "Важное сообщение", "Детали сообщения...")
    val smsNotification = SMSNotification("+7-123-456-7890", "Срочное уведомление")
    val pushNotification = PushNotification("device-token-123", "Новое обновление", true)
    
    println("\nОтправка уведомлений:")
    sendNotification(emailNotification)
    sendNotification(smsNotification)
    sendNotification(pushNotification)
    
    // Пример 3: Система отчетов
    val pdfReport = PDFReport("Финансовый отчет", "Q1 2023")
    val excelReport = ExcelReport("Статистика продаж", "Январь 2023")
    val jsonReport = JSONReport("Данные пользователей", "API v1")
    
    println("\nГенерация отчетов:")
    val reports = listOf(pdfReport, excelReport, jsonReport)
    
    reports.forEach { report ->
        report.generate()
        report.save("/reports/")
        if (report is Printable) {
            report.print()
        }
        if (report is Shareable) {
            report.share("user@example.com")
        }
        println()
    }
}

// ======== Определения абстрактных классов и их реализаций ========

// Абстрактный класс Shape
abstract class Shape(val name: String) {
    // Абстрактное свойство (должно быть реализовано в подклассах)
    abstract val shapeType: String
    
    // Абстрактные методы (должны быть реализованы в подклассах)
    abstract fun calculateArea(): Double
    abstract fun calculatePerimeter(): Double
    
    // Обычный метод с реализацией
    fun printInfo() {
        println("Фигура: $name (тип: $shapeType)")
    }
}

// Конкретный подкласс Circle
class Circle(name: String, val radius: Double) : Shape(name) {
    // Реализация абстрактного свойства
    override val shapeType = "Круг"
    
    // Реализация абстрактных методов
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
    
    override fun calculatePerimeter(): Double {
        return 2 * Math.PI * radius
    }
}

// Конкретный подкласс Rectangle
class Rectangle(name: String, val width: Double, val height: Double) : Shape(name) {
    // Реализация абстрактного свойства
    override val shapeType = "Прямоугольник"
    
    // Реализация абстрактных методов
    override fun calculateArea(): Double {
        return width * height
    }
    
    override fun calculatePerimeter(): Double {
        return 2 * (width + height)
    }
}

// Подкласс Square, наследующийся от Rectangle
class Square(name: String, val side: Double) : Shape(name) {
    // Реализация абстрактного свойства
    override val shapeType = "Квадрат"
    
    // Реализация абстрактных методов
    override fun calculateArea(): Double {
        return side * side
    }
    
    override fun calculatePerimeter(): Double {
        return 4 * side
    }
}

// Абстрактный класс с состоянием и поведением
abstract class Animal(val name: String, val age: Int) {
    // Абстрактный метод без реализации
    abstract fun makeSound()
    
    // Методы с реализацией
    open fun eat() {
        println("$name ест")
    }
    
    fun sleep() {
        println("$name спит")
    }
}

// Конкретные подклассы Animal
class Cat(name: String, age: Int) : Animal(name, age) {
    override fun makeSound() {
        println("$name мяукает: Мяу!")
    }
    
    // Переопределение метода с реализацией
    override fun eat() {
        println("$name ест рыбу")
    }
}

class Dog(name: String, age: Int) : Animal(name, age) {
    override fun makeSound() {
        println("$name лает: Гав-гав!")
    }
    
    // Переопределение метода с реализацией
    override fun eat() {
        println("$name ест мясо")
    }
}

// Абстрактный класс с конструктором и инициализацией
abstract class Vehicle(val model: String, val year: Int) {
    init {
        println("Создан транспорт: $model ($year)")
    }
    
    // Абстрактные методы
    abstract fun start()
    abstract fun drive()
    
    // Метод с реализацией
    open fun stop() {
        println("$model останавливается")
    }
}

// Конкретные подклассы Vehicle
class Sedan(model: String, year: Int, val doors: Int) : Vehicle(model, year) {
    override fun start() {
        println("Седан $model заводит двигатель")
    }
    
    override fun drive() {
        println("Седан $model едет по дороге")
    }
    
    override fun stop() {
        super.stop()
        println("Седан $model паркуется")
    }
}

class Truck(model: String, year: Int, val cargoCapacity: Double) : Vehicle(model, year) {
    override fun start() {
        println("Грузовик $model заводит дизельный двигатель")
    }
    
    override fun drive() {
        println("Грузовик $model едет, перевозя груз весом $cargoCapacity кг")
    }
    
    override fun stop() {
        super.stop()
        println("Грузовик $model останавливается на стоянке")
    }
}

// Абстрактный класс для примера с платежами
abstract class Payment(val amount: Double) {
    abstract fun process()
    
    fun validate(): Boolean {
        return amount > 0
    }
    
    open fun getDescription(): String {
        return "Платеж на сумму $amount"
    }
}

class CreditCardPayment(amount: Double, val cardNumber: String) : Payment(amount) {
    override fun process() {
        println("Обработка платежа по кредитной карте $cardNumber на сумму $amount")
    }
    
    override fun getDescription(): String {
        return "Платеж картой ${cardNumber.takeLast(4)} на сумму $amount"
    }
}

class PayPalPayment(amount: Double, val email: String) : Payment(amount) {
    override fun process() {
        println("Обработка платежа через PayPal ($email) на сумму $amount")
    }
    
    override fun getDescription(): String {
        return "Платеж через PayPal ($email) на сумму $amount"
    }
}

class CryptoPayment(amount: Double, val walletAddress: String) : Payment(amount) {
    override fun process() {
        println("Обработка криптовалютного платежа на кошелек $walletAddress на сумму $amount")
    }
    
    override fun getDescription(): String {
        return "Криптовалютный платеж на кошелек ${walletAddress.take(8)}... на сумму $amount"
    }
}

// Функция для обработки платежей
fun processPayment(payment: Payment) {
    if (payment.validate()) {
        println("Платеж валиден: ${payment.getDescription()}")
        payment.process()
        println("Платеж успешно обработан")
    } else {
        println("Ошибка: недопустимая сумма платежа")
    }
}

// Абстрактный класс для примера с уведомлениями
abstract class Notification {
    abstract fun send()
    abstract fun getRecipient(): String
    
    open fun logSending() {
        println("Отправка уведомления получателю ${getRecipient()}")
    }
}

class EmailNotification(
    private val email: String,
    private val subject: String,
    private val body: String
) : Notification() {
    override fun send() {
        println("Отправка email на $email с темой '$subject'")
    }
    
    override fun getRecipient(): String {
        return email
    }
}

class SMSNotification(
    private val phoneNumber: String,
    private val message: String
) : Notification() {
    override fun send() {
        println("Отправка SMS на $phoneNumber с сообщением: $message")
    }
    
    override fun getRecipient(): String {
        return phoneNumber
    }
}

class PushNotification(
    private val deviceToken: String,
    private val message: String,
    private val isUrgent: Boolean
) : Notification() {
    override fun send() {
        val priority = if (isUrgent) "высоким" else "обычным"
        println("Отправка Push-уведомления на устройство $deviceToken с $priority приоритетом: $message")
    }
    
    override fun getRecipient(): String {
        return "Устройство $deviceToken"
    }
    
    override fun logSending() {
        super.logSending()
        if (isUrgent) {
            println("Отправка срочного уведомления!")
        }
    }
}

// Функция для отправки уведомлений
fun sendNotification(notification: Notification) {
    notification.logSending()
    notification.send()
    println("Уведомление отправлено получателю ${notification.getRecipient()}")
}

// Интерфейсы для примера с отчетами
interface Printable {
    fun print()
}

interface Shareable {
    fun share(recipient: String)
}

// Абстрактный класс для примера с отчетами
abstract class Report(val title: String, val period: String) {
    abstract fun generate()
    abstract fun save(path: String)
    
    fun getFileName(): String {
        return "${title.replace(" ", "_")}_${period.replace(" ", "_")}"
    }
}

class PDFReport(title: String, period: String) : Report(title, period), Printable {
    override fun generate() {
        println("Генерация PDF-отчета '$title' за период $period")
    }
    
    override fun save(path: String) {
        println("Сохранение PDF-отчета в ${path}${getFileName()}.pdf")
    }
    
    override fun print() {
        println("Печать PDF-отчета '$title'")
    }
}

class ExcelReport(title: String, period: String) : Report(title, period), Printable, Shareable {
    override fun generate() {
        println("Генерация Excel-отчета '$title' за период $period")
    }
    
    override fun save(path: String) {
        println("Сохранение Excel-отчета в ${path}${getFileName()}.xlsx")
    }
    
    override fun print() {
        println("Печать Excel-отчета '$title'")
    }
    
    override fun share(recipient: String) {
        println("Отправка Excel-отчета '$title' по email: $recipient")
    }
}

class JSONReport(title: String, period: String) : Report(title, period), Shareable {
    override fun generate() {
        println("Генерация JSON-отчета '$title' за период $period")
    }
    
    override fun save(path: String) {
        println("Сохранение JSON-отчета в ${path}${getFileName()}.json")
    }
    
    override fun share(recipient: String) {
        println("Отправка JSON-отчета '$title' через API получателю: $recipient")
    }
} 