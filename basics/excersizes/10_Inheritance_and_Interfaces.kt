package basics.excersizes

/**
 * Упражнение 1: Базовое наследование
 * 
 * Создайте базовый класс Vehicle с свойствами brand (String) и year (Int).
 * Добавьте метод getInfo(), который возвращает информацию о транспортном средстве.
 * Создайте подкласс Car, который наследуется от Vehicle и добавляет свойство model (String).
 * Переопределите метод getInfo() в Car, чтобы он включал информацию о модели.
 */
class Solution1 {
    open class Vehicle(val brand: String, val year: Int) {
        // your solution
    }
    
    class Car(brand: String, year: Int, val model: String) : Vehicle(brand, year) {
        // your solution
    }
    
    fun testVehicleAndCar(): Pair<String, String> {
        // your solution
    }
}

/**
 * Упражнение 2: Переопределение свойств
 * 
 * Создайте базовый класс Product с открытым свойством price (Double).
 * Создайте подкласс DiscountedProduct, который переопределяет свойство price,
 * применяя скидку к базовой цене.
 */
class Solution2 {
    open class Product(val name: String, open val price: Double) {
        // your solution
    }
    
    class DiscountedProduct(name: String, basePrice: Double, val discountPercent: Double) : Product(name, basePrice) {
        // your solution
    }
    
    fun testProducts(): Pair<Double, Double> {
        // your solution
    }
}

/**
 * Упражнение 3: Абстрактные классы
 * 
 * Создайте абстрактный класс Shape с абстрактными методами area() и perimeter().
 * Реализуйте подклассы Circle и Rectangle, которые наследуются от Shape.
 */
class Solution3 {
    abstract class Shape {
        // your solution
    }
    
    class Circle(val radius: Double) : Shape() {
        // your solution
    }
    
    class Rectangle(val width: Double, val height: Double) : Shape() {
        // your solution
    }
    
    fun testShapes(): Triple<Double, Double, Double> {
        // your solution
    }
}

/**
 * Упражнение 4: Базовый интерфейс
 * 
 * Создайте интерфейс Drawable с методом draw().
 * Реализуйте классы Circle и Square, которые реализуют этот интерфейс.
 */
class Solution4 {
    interface Drawable {
        // your solution
    }
    
    class Circle(val radius: Double) : Drawable {
        // your solution
    }
    
    class Square(val side: Double) : Drawable {
        // your solution
    }
    
    fun testDrawables(): Pair<String, String> {
        // your solution
    }
}

/**
 * Упражнение 5: Множественные интерфейсы
 * 
 * Создайте интерфейсы Playable и Recordable с методами play() и record() соответственно.
 * Реализуйте класс MediaPlayer, который реализует оба интерфейса.
 */
class Solution5 {
    interface Playable {
        // your solution
    }
    
    interface Recordable {
        // your solution
    }
    
    class MediaPlayer : Playable, Recordable {
        // your solution
    }
    
    fun testMediaPlayer(): Pair<String, String> {
        // your solution
    }
}

/**
 * Упражнение 6: Интерфейсы с реализацией по умолчанию
 * 
 * Создайте интерфейс Logger с методом log(message: String) и методом по умолчанию logInfo(message: String).
 * Реализуйте классы ConsoleLogger и FileLogger, которые реализуют этот интерфейс.
 */
class Solution6 {
    interface Logger {
        // your solution
    }
    
    class ConsoleLogger : Logger {
        // your solution
    }
    
    class FileLogger(val fileName: String) : Logger {
        // your solution
    }
    
    fun testLoggers(): Triple<String, String, String> {
        // your solution
    }
}

/**
 * Упражнение 7: Разрешение конфликтов при множественном наследовании
 * 
 * Создайте два интерфейса A и B с одинаковым методом foo().
 * Реализуйте класс C, который реализует оба интерфейса и разрешает конфликт.
 */
class Solution7 {
    interface A {
        // your solution
    }
    
    interface B {
        // your solution
    }
    
    class C : A, B {
        // your solution
    }
    
    fun testConflictResolution(): String {
        // your solution
    }
}

/**
 * Упражнение 8: Делегирование интерфейсов
 * 
 * Создайте интерфейс Repository с методами save(data: String) и load(): String.
 * Реализуйте класс DatabaseRepository, который реализует этот интерфейс.
 * Создайте класс CachedRepository, который делегирует реализацию Repository объекту repository,
 * но добавляет кэширование.
 */
class Solution8 {
    interface Repository {
        // your solution
    }
    
    class DatabaseRepository : Repository {
        // your solution
    }
    
    class CachedRepository(private val repository: Repository) : Repository by repository {
        // your solution
    }
    
    fun testRepositories(): Triple<String, String, String> {
        // your solution
    }
}

/**
 * Упражнение 9: Запечатанные классы
 * 
 * Создайте запечатанный класс Result с подклассами Success, Error и Loading.
 * Реализуйте функцию handleResult, которая обрабатывает результат в зависимости от его типа.
 */
class Solution9 {
    // your solution
    
    fun handleResult(result: Result): String {
        // your solution
    }
    
    fun testResults(): Triple<String, String, String> {
        // your solution
    }
}

/**
 * Упражнение 10: Комбинирование наследования и интерфейсов
 * 
 * Создайте абстрактный класс Animal с свойством name и методом makeSound().
 * Создайте интерфейс Pet с методами play() и groom().
 * Реализуйте классы Dog и Cat, которые наследуются от Animal и реализуют интерфейс Pet.
 */
class Solution10 {
    abstract class Animal(val name: String) {
        // your solution
    }
    
    interface Pet {
        // your solution
    }
    
    class Dog(name: String) : Animal(name), Pet {
        // your solution
    }
    
    class Cat(name: String) : Animal(name), Pet {
        // your solution
    }
    
    fun testAnimals(): List<String> {
        // your solution
    }
} 