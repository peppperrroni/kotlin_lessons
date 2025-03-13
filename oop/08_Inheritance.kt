/**
 * Урок 8: Наследование в Kotlin
 * 
 * В этом уроке мы рассмотрим механизм наследования в Kotlin, который позволяет
 * создавать иерархии классов и переиспользовать код.
 */

fun main() {
    println("Урок 8: Наследование в Kotlin")
    println("=============================")
    
    // ======== Основы наследования ========
    
    println("\n=== Основы наследования ===")
    
    // Создание объекта базового класса
    val animal = Animal("Животное", 5)
    animal.eat()
    animal.sleep()
    
    // Создание объекта производного класса
    val dog = Dog("Барон", 3, "Овчарка")
    dog.eat()  // Унаследованный метод
    dog.sleep()  // Унаследованный метод
    dog.bark()  // Собственный метод
    
    // Доступ к свойствам
    println("Имя: ${dog.name}, Возраст: ${dog.age}, Порода: ${dog.breed}")
    
    // ======== Переопределение методов ========
    
    println("\n=== Переопределение методов ===")
    
    // Создание объекта класса с переопределенными методами
    val cat = Cat("Мурка", 2, 7)
    cat.eat()  // Переопределенный метод
    cat.sleep()  // Переопределенный метод
    cat.purr()  // Собственный метод
    
    // ======== Вызов методов суперкласса ========
    
    println("\n=== Вызов методов суперкласса ===")
    
    val bird = Bird("Чижик", 1, "Желтый")
    bird.eat()  // Метод вызывает super.eat() и добавляет свою функциональность
    
    // ======== Абстрактные классы ========
    
    println("\n=== Абстрактные классы ===")
    
    // Нельзя создать экземпляр абстрактного класса
    // val shape = Shape() // Ошибка компиляции
    
    val circle = Circle("Круг", 5.0)
    println("${circle.name}: площадь = ${circle.area()}, периметр = ${circle.perimeter()}")
    
    val rectangle = Rectangle("Прямоугольник", 4.0, 6.0)
    println("${rectangle.name}: площадь = ${rectangle.area()}, периметр = ${rectangle.perimeter()}")
    
    // ======== Открытые и закрытые классы ========
    
    println("\n=== Открытые и закрытые классы ===")
    
    val vehicle = Vehicle("Транспортное средство", 0)
    val car = Car("Автомобиль", 4, "Toyota")
    
    vehicle.move()
    car.move()
    
    // Нельзя наследоваться от final класса
    // class SportsCar : Car("", 4, "") {} // Ошибка компиляции
    
    // ======== Интерфейсы и множественное наследование ========
    
    println("\n=== Интерфейсы и множественное наследование ===")
    
    val duck = Duck("Дональд", 2)
    duck.swim()  // Метод из интерфейса Swimmable
    duck.fly()   // Метод из интерфейса Flyable
    
    // ======== Делегирование ========
    
    println("\n=== Делегирование ===")
    
    val fileLogger = FileLogger()
    val consoleLogger = ConsoleLogger()
    
    // Класс, использующий делегирование
    val combinedLogger = CombinedLogger(fileLogger, consoleLogger)
    combinedLogger.log("Это сообщение будет записано в файл и выведено в консоль")
    
    // ======== Sealed классы ========
    
    println("\n=== Sealed классы ===")
    
    val success = Result.Success("Операция выполнена успешно")
    val error = Result.Error("Произошла ошибка")
    val loading = Result.Loading
    
    // Использование when с sealed классом (не требуется else)
    val message = when (success) {
        is Result.Success -> "Успех: ${success.data}"
        is Result.Error -> "Ошибка: ${error.message}"
        Result.Loading -> "Загрузка..."
    }
    println(message)
    
    // ======== Практические примеры ========
    
    println("\n=== Практические примеры ===")
    
    // Пример 1: Иерархия сотрудников
    val employee = Employee("Иван Иванов", "E001", 50000.0)
    val manager = Manager("Петр Петров", "M001", 80000.0, 10000.0)
    val developer = Developer("Анна Сидорова", "D001", 70000.0, "Kotlin")
    
    println("\nИнформация о сотрудниках:")
    employee.displayInfo()
    manager.displayInfo()
    developer.displayInfo()
    
    // Пример 2: Система фигур
    val shapes = listOf(
        Circle("Маленький круг", 2.0),
        Rectangle("Большой прямоугольник", 10.0, 5.0),
        Circle("Большой круг", 7.0),
        Rectangle("Квадрат", 4.0, 4.0)
    )
    
    println("\nИнформация о фигурах:")
    shapes.forEach { shape ->
        println("${shape.name}: площадь = ${shape.area()}, периметр = ${shape.perimeter()}")
    }
    
    // Поиск фигуры с наибольшей площадью
    val largestShape = shapes.maxByOrNull { it.area() }
    println("\nФигура с наибольшей площадью: ${largestShape?.name} (${largestShape?.area()})")
    
    // Пример 3: Обработка результатов операций
    val results = listOf(
        Result.Success("Данные получены"),
        Result.Error("Сетевая ошибка"),
        Result.Loading,
        Result.Success("Файл сохранен")
    )
    
    println("\nОбработка результатов:")
    results.forEach { result ->
        val resultMessage = when (result) {
            is Result.Success -> "✓ Успех: ${result.data}"
            is Result.Error -> "✗ Ошибка: ${result.message}"
            Result.Loading -> "⟳ Загрузка..."
        }
        println(resultMessage)
    }
}

// ======== Определения классов ========

// Базовый класс (суперкласс)
open class Animal(val name: String, var age: Int) {
    // Открытый метод, который можно переопределить
    open fun eat() {
        println("$name ест")
    }
    
    // Открытый метод, который можно переопределить
    open fun sleep() {
        println("$name спит")
    }
}

// Производный класс (подкласс), наследующийся от Animal
class Dog(name: String, age: Int, val breed: String) : Animal(name, age) {
    // Собственный метод подкласса
    fun bark() {
        println("$name лает: Гав-гав!")
    }
}

// Еще один производный класс с переопределенными методами
class Cat(name: String, age: Int, val lives: Int) : Animal(name, age) {
    // Переопределение метода суперкласса
    override fun eat() {
        println("$name ест рыбу")
    }
    
    // Переопределение метода суперкласса
    override fun sleep() {
        println("$name спит на подушке")
    }
    
    // Собственный метод подкласса
    fun purr() {
        println("$name мурлычет: Мррр...")
    }
}

// Класс с вызовом методов суперкласса
class Bird(name: String, age: Int, val color: String) : Animal(name, age) {
    // Переопределение с вызовом метода суперкласса
    override fun eat() {
        super.eat()  // Вызов метода суперкласса
        println("$name клюет зерна")
    }
}

// Абстрактный класс
abstract class Shape(val name: String) {
    // Абстрактные методы (без реализации)
    abstract fun area(): Double
    abstract fun perimeter(): Double
    
    // Обычный метод с реализацией
    fun displayInfo() {
        println("Фигура: $name, Площадь: ${area()}, Периметр: ${perimeter()}")
    }
}

// Конкретный класс, наследующийся от абстрактного
class Circle(name: String, val radius: Double) : Shape(name) {
    // Реализация абстрактных методов
    override fun area(): Double {
        return Math.PI * radius * radius
    }
    
    override fun perimeter(): Double {
        return 2 * Math.PI * radius
    }
}

// Еще один конкретный класс, наследующийся от абстрактного
class Rectangle(name: String, val width: Double, val height: Double) : Shape(name) {
    // Реализация абстрактных методов
    override fun area(): Double {
        return width * height
    }
    
    override fun perimeter(): Double {
        return 2 * (width + height)
    }
}

// Открытый класс (можно наследоваться)
open class Vehicle(val name: String, val wheels: Int) {
    open fun move() {
        println("$name движется")
    }
}

// Закрытый класс (нельзя наследоваться дальше)
final class Car(name: String, wheels: Int, val brand: String) : Vehicle(name, wheels) {
    override fun move() {
        println("$name марки $brand едет по дороге")
    }
}

// Интерфейсы для множественного наследования
interface Swimmable {
    fun swim() {
        println("Плавает в воде")
    }
}

interface Flyable {
    fun fly() {
        println("Летает в воздухе")
    }
}

// Класс, реализующий несколько интерфейсов
class Duck(name: String, age: Int) : Animal(name, age), Swimmable, Flyable {
    override fun swim() {
        println("$name плавает в пруду")
    }
    
    override fun fly() {
        println("$name летает над водой")
    }
}

// Интерфейс для делегирования
interface Logger {
    fun log(message: String)
}

// Реализации интерфейса
class FileLogger : Logger {
    override fun log(message: String) {
        println("Запись в файл: $message")
    }
}

class ConsoleLogger : Logger {
    override fun log(message: String) {
        println("Вывод в консоль: $message")
    }
}

// Класс, использующий делегирование
class CombinedLogger(
    private val fileLogger: Logger,
    private val consoleLogger: Logger
) : Logger {
    override fun log(message: String) {
        fileLogger.log(message)
        consoleLogger.log(message)
    }
}

// Sealed класс (ограниченная иерархия)
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}

// Классы для примера с сотрудниками
open class Employee(val name: String, val id: String, var salary: Double) {
    open fun displayInfo() {
        println("Сотрудник: $name (ID: $id), Зарплата: $salary руб.")
    }
}

class Manager(name: String, id: String, salary: Double, val bonus: Double) : Employee(name, id, salary) {
    override fun displayInfo() {
        println("Менеджер: $name (ID: $id), Зарплата: $salary руб., Бонус: $bonus руб.")
    }
}

class Developer(name: String, id: String, salary: Double, val language: String) : Employee(name, id, salary) {
    override fun displayInfo() {
        println("Разработчик: $name (ID: $id), Зарплата: $salary руб., Язык: $language")
    }
} 