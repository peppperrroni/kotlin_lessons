# Урок 8: Наследование в Kotlin

## Введение

Наследование — один из фундаментальных принципов объектно-ориентированного программирования, который позволяет создавать новые классы на основе существующих. Это мощный механизм для повторного использования кода и построения иерархий классов.

В Kotlin наследование реализовано с некоторыми особенностями, которые делают его более безопасным и предсказуемым по сравнению с другими языками программирования. В этом уроке мы рассмотрим механизм наследования в Kotlin, его особенности и применение.

## Основы наследования

### Базовые и производные классы

В Kotlin все классы по умолчанию являются закрытыми для наследования (final). Чтобы класс можно было наследовать, его нужно объявить с ключевым словом `open`:

```kotlin
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
```

Для создания производного класса используется двоеточие (`:`) после имени класса, за которым следует имя базового класса с аргументами для его конструктора.

### Использование наследования

```kotlin
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
```

## Переопределение методов

Для переопределения метода базового класса в производном классе необходимо:
1. Объявить метод в базовом классе с ключевым словом `open`
2. Переопределить метод в производном классе с ключевым словом `override`

```kotlin
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
```

## Вызов методов суперкласса

Внутри переопределенного метода можно вызвать метод суперкласса с помощью ключевого слова `super`:

```kotlin
// Класс с вызовом методов суперкласса
class Bird(name: String, age: Int, val color: String) : Animal(name, age) {
    // Переопределение с вызовом метода суперкласса
    override fun eat() {
        super.eat()  // Вызов метода суперкласса
        println("$name клюет зерна")
    }
}
```

## Абстрактные классы

Абстрактные классы не могут быть инстанцированы напрямую и часто содержат абстрактные методы, которые должны быть реализованы в подклассах:

```kotlin
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
```

Использование абстрактных классов:

```kotlin
// Нельзя создать экземпляр абстрактного класса
// val shape = Shape() // Ошибка компиляции

val circle = Circle("Круг", 5.0)
println("${circle.name}: площадь = ${circle.area()}, периметр = ${circle.perimeter()}")

val rectangle = Rectangle("Прямоугольник", 4.0, 6.0)
println("${rectangle.name}: площадь = ${rectangle.area()}, периметр = ${rectangle.perimeter()}")
```

## Открытые и закрытые классы

В Kotlin классы по умолчанию являются закрытыми для наследования (final). Чтобы разрешить наследование, класс нужно объявить с ключевым словом `open`:

```kotlin
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

// Нельзя наследоваться от final класса
// class SportsCar : Car("", 4, "") {} // Ошибка компиляции
```

## Интерфейсы и множественное наследование

Kotlin не поддерживает множественное наследование классов, но класс может реализовывать несколько интерфейсов:

```kotlin
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
```

## Делегирование

Делегирование — это шаблон проектирования, который позволяет объекту передавать выполнение некоторых своих методов другому объекту. Kotlin поддерживает делегирование на уровне языка:

```kotlin
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
```

## Sealed классы

Sealed классы (запечатанные классы) представляют собой ограниченную иерархию классов. Все подклассы sealed класса должны быть объявлены в том же файле, что и сам sealed класс:

```kotlin
// Sealed класс (ограниченная иерархия)
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}

// Использование when с sealed классом (не требуется else)
val success = Result.Success("Операция выполнена успешно")
val message = when (success) {
    is Result.Success -> "Успех: ${success.data}"
    is Result.Error -> "Ошибка: ${success.message}" // Здесь будет ошибка компиляции, т.к. success не может быть Error
    Result.Loading -> "Загрузка..."
}
```

Преимущество sealed классов в том, что при использовании их с выражением `when`, компилятор может проверить, что все возможные случаи обработаны, и не требуется ветка `else`.

## Практические примеры

### Пример 1: Иерархия сотрудников

```kotlin
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

// Использование
val employee = Employee("Иван Иванов", "E001", 50000.0)
val manager = Manager("Петр Петров", "M001", 80000.0, 10000.0)
val developer = Developer("Анна Сидорова", "D001", 70000.0, "Kotlin")

println("Информация о сотрудниках:")
employee.displayInfo()
manager.displayInfo()
developer.displayInfo()
```

### Пример 2: Система фигур

```kotlin
// Использование абстрактного класса Shape
val shapes = listOf(
    Circle("Маленький круг", 2.0),
    Rectangle("Большой прямоугольник", 10.0, 5.0),
    Circle("Большой круг", 7.0),
    Rectangle("Квадрат", 4.0, 4.0)
)

println("Информация о фигурах:")
shapes.forEach { shape ->
    println("${shape.name}: площадь = ${shape.area()}, периметр = ${shape.perimeter()}")
}

// Поиск фигуры с наибольшей площадью
val largestShape = shapes.maxByOrNull { it.area() }
println("Фигура с наибольшей площадью: ${largestShape?.name} (${largestShape?.area()})")
```

### Пример 3: Обработка результатов операций

```kotlin
// Использование sealed класса Result
val results = listOf(
    Result.Success("Данные получены"),
    Result.Error("Сетевая ошибка"),
    Result.Loading,
    Result.Success("Файл сохранен")
)

println("Обработка результатов:")
results.forEach { result ->
    val resultMessage = when (result) {
        is Result.Success -> "✓ Успех: ${result.data}"
        is Result.Error -> "✗ Ошибка: ${result.message}"
        Result.Loading -> "⟳ Загрузка..."
    }
    println(resultMessage)
}
```

## Заключение

В этом уроке мы рассмотрели механизм наследования в Kotlin, который позволяет создавать иерархии классов и переиспользовать код.

Ключевые особенности наследования в Kotlin:
- Классы по умолчанию закрыты для наследования (final), для разрешения наследования используется ключевое слово `open`
- Методы также по умолчанию закрыты для переопределения, для разрешения переопределения используется ключевое слово `open`
- Для переопределения метода в подклассе используется ключевое слово `override`
- Абстрактные классы не могут быть инстанцированы и могут содержать абстрактные методы
- Kotlin не поддерживает множественное наследование классов, но класс может реализовывать несколько интерфейсов
- Sealed классы представляют собой ограниченную иерархию классов, что полезно при использовании с выражением `when`

Наследование является мощным инструментом для организации кода и создания гибких, расширяемых систем. Однако следует помнить о принципе "предпочитайте композицию наследованию", который рекомендует использовать композицию объектов вместо наследования, когда это возможно, для создания более гибких и менее связанных систем. 