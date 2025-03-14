# Урок 2: Наследование и интерфейсы в Kotlin

## Введение

Наследование и интерфейсы - фундаментальные концепции объектно-ориентированного программирования, которые позволяют создавать гибкие и расширяемые иерархии классов. В Kotlin эти концепции реализованы с некоторыми особенностями, которые делают код более безопасным и выразительным.

## Наследование в Kotlin

В Kotlin все классы по умолчанию являются **final** (запечатанными), что означает, что они не могут быть унаследованы, если явно не помечены модификатором `open`.

### Базовое наследование

```kotlin
// Базовый класс должен быть помечен как open
open class Animal(val name: String) {
    open fun makeSound() {
        println("Животное издает звук")
    }
}

// Класс-наследник
class Dog(name: String, val breed: String) : Animal(name) {
    override fun makeSound() {
        println("Гав-гав!")
    }
}
```

### Переопределение свойств

В Kotlin можно переопределять не только методы, но и свойства:

```kotlin
open class Shape {
    open val vertexCount: Int = 0
}

class Rectangle : Shape() {
    override val vertexCount: Int = 4
}
```

### Порядок вызова конструкторов

При наследовании конструктор базового класса вызывается первым:

```kotlin
open class Base(val x: Int) {
    init {
        println("Инициализация Base с x = $x")
    }
}

class Derived(x: Int, val y: Int) : Base(x) {
    init {
        println("Инициализация Derived с y = $y")
    }
}

// При создании Derived(10, 20) вывод будет:
// Инициализация Base с x = 10
// Инициализация Derived с y = 20
```

### Вызов методов и свойств суперкласса

Для вызова методов и доступа к свойствам суперкласса используется ключевое слово `super`:

```kotlin
open class Animal {
    open fun makeSound() {
        println("Животное издает звук")
    }
}

class Dog : Animal() {
    override fun makeSound() {
        super.makeSound() // Вызов метода суперкласса
        println("Гав-гав!")
    }
}
```

## Абстрактные классы

Абстрактные классы не могут быть инстанцированы и могут содержать абстрактные методы и свойства:

```kotlin
abstract class Shape {
    abstract val vertexCount: Int
    abstract fun area(): Double
    abstract fun perimeter(): Double
    
    // Абстрактные классы могут содержать и обычные методы
    fun printInfo() {
        println("Фигура с $vertexCount вершинами")
        println("Площадь: ${area()}")
        println("Периметр: ${perimeter()}")
    }
}

class Circle(val radius: Double) : Shape() {
    override val vertexCount: Int = 0
    override fun area(): Double = Math.PI * radius * radius
    override fun perimeter(): Double = 2 * Math.PI * radius
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override val vertexCount: Int = 4
    override fun area(): Double = width * height
    override fun perimeter(): Double = 2 * (width + height)
}
```

## Интерфейсы

Интерфейсы в Kotlin могут содержать абстрактные методы, а также методы с реализацией по умолчанию и свойства:

```kotlin
interface Drawable {
    fun draw() // Абстрактный метод
    
    // Метод с реализацией по умолчанию
    fun drawWithColor(color: String) {
        println("Рисуем с цветом $color")
        draw()
    }
    
    // Свойство без инициализатора (абстрактное)
    val drawingTool: String
}

class Circle(val radius: Double) : Drawable {
    override fun draw() {
        println("Рисуем круг с радиусом $radius")
    }
    
    override val drawingTool: String = "Циркуль"
}
```

### Множественные интерфейсы

Класс может реализовывать несколько интерфейсов:

```kotlin
interface Drawable {
    fun draw()
}

interface Clickable {
    fun click()
}

class Button : Drawable, Clickable {
    override fun draw() {
        println("Рисуем кнопку")
    }
    
    override fun click() {
        println("Кнопка нажата")
    }
}
```

### Разрешение конфликтов при множественном наследовании

Если класс реализует несколько интерфейсов с одинаковыми методами, необходимо явно переопределить этот метод:

```kotlin
interface A {
    fun foo() {
        println("A.foo")
    }
}

interface B {
    fun foo() {
        println("B.foo")
    }
}

class C : A, B {
    override fun foo() {
        // Явно указываем, какую реализацию вызывать
        super<A>.foo()
        super<B>.foo()
        println("C.foo")
    }
}
```

## Делегирование интерфейсов

Kotlin поддерживает шаблон проектирования "Делегирование" на уровне языка:

```kotlin
interface Base {
    fun print()
}

class BaseImpl : Base {
    override fun print() {
        println("BaseImpl: print")
    }
}

// Класс Derived делегирует реализацию интерфейса Base объекту b
class Derived(b: Base) : Base by b {
    // Можно переопределить некоторые методы
    override fun print() {
        println("Derived: print")
    }
}

fun main() {
    val b = BaseImpl()
    val d = Derived(b)
    d.print() // Выведет "Derived: print"
}
```

## Запечатанные классы

Запечатанные классы (sealed classes) используются для представления ограниченных иерархий классов:

```kotlin
sealed class Result {
    class Success(val data: Any) : Result()
    class Error(val message: String) : Result()
    object Loading : Result()
}

fun handleResult(result: Result) {
    when (result) {
        is Result.Success -> println("Успех: ${result.data}")
        is Result.Error -> println("Ошибка: ${result.message}")
        is Result.Loading -> println("Загрузка...")
        // Не нужен else, так как все подклассы Result уже обработаны
    }
}
```

## Практические рекомендации

1. **Предпочитайте композицию наследованию**: Наследование создает сильную связь между классами. Часто лучше использовать композицию или делегирование.

2. **Используйте интерфейсы для определения контрактов**: Интерфейсы позволяют определить, что класс должен делать, не указывая, как он должен это делать.

3. **Применяйте запечатанные классы для представления ограниченных иерархий**: Когда вы знаете все возможные подклассы заранее, используйте sealed classes.

4. **Не злоупотребляйте наследованием**: Глубокие иерархии наследования могут сделать код сложным для понимания и поддержки.

5. **Используйте делегирование для реализации шаблона "Декоратор"**: Делегирование интерфейсов в Kotlin - элегантный способ реализации шаблона "Декоратор".

## Заключение

Наследование и интерфейсы в Kotlin предоставляют мощные инструменты для создания гибких и расширяемых иерархий классов. Особенности Kotlin, такие как явное указание открытости классов, делегирование интерфейсов и запечатанные классы, делают код более безопасным и выразительным.

В следующем уроке мы рассмотрим дженерики (обобщения) в Kotlin, которые позволяют создавать типобезопасные классы и функции, работающие с разными типами данных. 