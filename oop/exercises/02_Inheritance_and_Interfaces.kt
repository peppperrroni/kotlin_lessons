package oop.exercises

/**
 * Упражнения по теме "Наследование и интерфейсы в Kotlin"
 */

/**
 * Упражнение 1: Базовое наследование
 * 
 * Создайте базовый класс Vehicle с свойствами brand (String) и year (Int).
 * Добавьте метод getInfo(), который возвращает информацию о транспортном средстве.
 * Создайте подкласс Car, который наследуется от Vehicle и добавляет свойство model (String).
 * Переопределите метод getInfo() в Car, чтобы он включал информацию о модели.
 */
class Exercise1 {
    // your solution
    
    // Демонстрация базового наследования
    fun demonstrateBasicInheritance(): Pair<String, String> {
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
class Exercise2 {
    // your solution
    
    // Демонстрация переопределения свойств
    fun demonstratePropertyOverriding(): Pair<Double, Double> {
        // your solution
    }
}

/**
 * Упражнение 3: Абстрактные классы
 * 
 * Создайте абстрактный класс Shape с абстрактными методами area() и perimeter().
 * Реализуйте подклассы Circle и Rectangle, которые наследуются от Shape.
 */
class Exercise3 {
    // your solution
    
    // Демонстрация работы с абстрактными классами
    fun demonstrateAbstractClasses(): Triple<Double, Double, Double> {
        // your solution
    }
}

/**
 * Упражнение 4: Базовый интерфейс
 * 
 * Создайте интерфейс Drawable с методом draw().
 * Реализуйте классы Circle и Square, которые реализуют этот интерфейс.
 */
class Exercise4 {
    // your solution
    
    // Демонстрация работы с интерфейсами
    fun demonstrateInterfaces(): Pair<String, String> {
        // your solution
    }
}

/**
 * Упражнение 5: Множественные интерфейсы
 * 
 * Создайте интерфейсы Playable и Recordable с методами play() и record() соответственно.
 * Реализуйте класс MediaPlayer, который реализует оба интерфейса.
 */
class Exercise5 {
    // your solution
    
    // Демонстрация работы с множественными интерфейсами
    fun demonstrateMultipleInterfaces(): Pair<String, String> {
        // your solution
    }
}

/**
 * Упражнение 6: Интерфейсы с реализацией по умолчанию
 * 
 * Создайте интерфейс Logger с методом log(message: String) и методом по умолчанию logInfo(message: String).
 * Реализуйте классы ConsoleLogger и FileLogger, которые реализуют этот интерфейс.
 */
class Exercise6 {
    // your solution
    
    // Демонстрация работы с интерфейсами с реализацией по умолчанию
    fun demonstrateDefaultImplementation(): Triple<String, String, String> {
        // your solution
    }
}

/**
 * Упражнение 7: Разрешение конфликтов при множественном наследовании
 * 
 * Создайте два интерфейса A и B с одинаковым методом foo().
 * Реализуйте класс C, который реализует оба интерфейса и разрешает конфликт.
 */
class Exercise7 {
    // your solution
    
    // Демонстрация разрешения конфликтов
    fun demonstrateConflictResolution(): String {
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
class Exercise8 {
    // your solution
    
    // Демонстрация делегирования интерфейсов
    fun demonstrateInterfaceDelegation(): Triple<String, String, String> {
        // your solution
    }
}

/**
 * Упражнение 9: Запечатанные классы
 * 
 * Создайте запечатанный класс Result с подклассами Success, Error и Loading.
 * Реализуйте функцию handleResult, которая обрабатывает результат в зависимости от его типа.
 */
class Exercise9 {
    // your solution
    
    // Демонстрация работы с запечатанными классами
    fun demonstrateSealedClasses(): Triple<String, String, String> {
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
class Exercise10 {
    // your solution
    
    // Демонстрация комбинирования наследования и интерфейсов
    fun demonstrateInheritanceWithInterfaces(): List<String> {
        // your solution
    }
} 