package basics.excersizes

/**
 * Упражнение 1: Создание простого класса
 * 
 * Создайте класс Person с двумя свойствами: name (String) и age (Int).
 * Добавьте метод introduceYourself(), который возвращает строку с представлением человека.
 */
class Solution1 {
    // your solution
    
    fun createAndIntroducePerson(name: String, age: Int): String {
        // your solution
    }
}

/**
 * Упражнение 2: Работа с конструкторами
 * 
 * Создайте класс Book с первичным конструктором, принимающим title (String) и author (String).
 * Добавьте вторичный конструктор, который также принимает year (Int).
 * Реализуйте метод getInfo(), возвращающий информацию о книге.
 */
class Solution2 {
    // your solution
    
    fun createBookWithYear(title: String, author: String, year: Int): String {
        // your solution
    }
    
    fun createBookWithoutYear(title: String, author: String): String {
        // your solution
    }
}

/**
 * Упражнение 3: Свойства и методы
 * 
 * Создайте класс BankAccount с приватным свойством _balance (Double).
 * Добавьте публичное свойство balance только для чтения.
 * Реализуйте методы deposit(amount: Double) и withdraw(amount: Double).
 */
class Solution3 {
    // your solution
    
    fun testBankAccount(): String {
        // your solution
    }
}

/**
 * Упражнение 4: Классы данных
 * 
 * Создайте класс данных User с свойствами id (Int), name (String) и email (String).
 * Реализуйте функцию, которая создает копию пользователя с измененным email.
 */
class Solution4 {
    // your solution
    
    fun changeUserEmail(user: User, newEmail: String): User {
        // your solution
    }
    
    fun compareUsers(user1: User, user2: User): Boolean {
        // your solution
    }
}

/**
 * Упражнение 5: Перечисления
 * 
 * Создайте перечисление DayOfWeek с днями недели.
 * Добавьте метод isWeekend(), который возвращает true для выходных дней.
 * Реализуйте функцию, которая принимает день недели и возвращает сообщение о том, 
 * рабочий это день или выходной.
 */
class Solution5 {
    // your solution
    
    fun getDayType(day: DayOfWeek): String {
        // your solution
    }
}

/**
 * Упражнение 6: Вложенные и внутренние классы
 * 
 * Создайте класс Computer с вложенным классом Processor и внутренним классом Memory.
 * Processor должен иметь свойства model (String) и cores (Int).
 * Memory должен иметь свойство sizeGB (Int) и метод, использующий свойство из внешнего класса.
 */
class Solution6 {
    // your solution
    
    fun describeComputer(brand: String, processorModel: String, cores: Int, memorySizeGB: Int): String {
        // your solution
    }
}

/**
 * Упражнение 7: Объекты-синглтоны
 * 
 * Создайте объект-синглтон Logger с методами log(message: String) и getLogHistory(): List<String>.
 * Метод log должен добавлять сообщение в историю логов с временной меткой.
 */
class Solution7 {
    // your solution
    
    fun testLogger(): List<String> {
        // your solution
    }
}

/**
 * Упражнение 8: Объекты-компаньоны
 * 
 * Создайте класс MathUtils с объектом-компаньоном, содержащим константы PI и E,
 * а также методы для вычисления площади и длины окружности.
 */
class Solution8 {
    // your solution
    
    fun calculateCircleProperties(radius: Double): Pair<Double, Double> {
        // your solution
    }
}

/**
 * Упражнение 9: Наследование
 * 
 * Создайте базовый класс Shape с абстрактным методом area(): Double.
 * Реализуйте подклассы Circle и Rectangle, которые наследуются от Shape.
 */
class Solution9 {
    // your solution
    
    fun calculateAreas(radius: Double, width: Double, height: Double): Pair<Double, Double> {
        // your solution
    }
}

/**
 * Упражнение 10: Интерфейсы
 * 
 * Создайте интерфейс Drawable с методом draw(): String.
 * Реализуйте классы Triangle и Square, которые реализуют этот интерфейс.
 * Создайте функцию drawShapes, которая принимает список Drawable объектов и возвращает их отрисовку.
 */
class Solution10 {
    // your solution
    
    fun drawShapes(shapes: List<Drawable>): List<String> {
        // your solution
    }
} 