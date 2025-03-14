package oop.exercises

/**
 * Упражнения по теме "Расширения и функциональное программирование в Kotlin"
 */

/**
 * Упражнение 1: Функции-расширения для стандартных типов
 * 
 * Создайте следующие функции-расширения:
 * - String.isValidEmail(): Boolean - проверяет, является ли строка корректным email-адресом
 * - String.isValidPhoneNumber(): Boolean - проверяет, является ли строка корректным номером телефона
 * - Int.isEven(): Boolean - проверяет, является ли число четным
 * - Int.isOdd(): Boolean - проверяет, является ли число нечетным
 * - List<Int>.sum(): Int - возвращает сумму всех элементов списка
 * - List<Int>.average(): Double - возвращает среднее арифметическое всех элементов списка
 */
class Exercise1 {
    // your solution
    
    // Демонстрация использования функций-расширений
    fun demonstrateExtensionFunctions() {
        // your solution
    }
}

/**
 * Упражнение 2: Свойства-расширения
 * 
 * Создайте следующие свойства-расширения:
 * - String.wordCount: Int - возвращает количество слов в строке
 * - String.firstWord: String - возвращает первое слово в строке
 * - String.lastWord: String - возвращает последнее слово в строке
 * - List<T>.firstOrNull: T? - возвращает первый элемент списка или null, если список пуст
 * - List<T>.lastOrNull: T? - возвращает последний элемент списка или null, если список пуст
 */
class Exercise2 {
    // your solution
    
    // Демонстрация использования свойств-расширений
    fun demonstrateExtensionProperties() {
        // your solution
    }
}

/**
 * Упражнение 3: Расширения для собственных классов
 * 
 * Создайте класс Person с полями name: String, age: Int, email: String.
 * Затем создайте следующие расширения для этого класса:
 * - Person.isAdult(): Boolean - возвращает true, если возраст >= 18
 * - Person.canVote(): Boolean - возвращает true, если возраст >= 18 и email не пустой
 * - Person.formatInfo(): String - возвращает отформатированную информацию о человеке
 * - List<Person>.averageAge(): Double - возвращает средний возраст всех людей в списке
 * - List<Person>.findByName(name: String): Person? - находит человека по имени
 */
class Exercise3 {
    // your solution
    
    // Демонстрация использования расширений для собственных классов
    fun demonstrateCustomClassExtensions() {
        // your solution
    }
}

/**
 * Упражнение 4: Функции высшего порядка
 * 
 * Реализуйте следующие функции высшего порядка:
 * - repeat(times: Int, action: () -> Unit): выполняет действие указанное количество раз
 * - measureTime(action: () -> Unit): Long: измеряет время выполнения действия в миллисекундах
 * - retry(times: Int, action: () -> Boolean): Boolean: повторяет действие, пока оно не вернет true или не будет достигнуто максимальное количество попыток
 * - withLogging(tag: String, action: () -> Unit): выполняет действие, логируя его начало и завершение
 */
class Exercise4 {
    // your solution
    
    // Демонстрация использования функций высшего порядка
    fun demonstrateHigherOrderFunctions() {
        // your solution
    }
}

/**
 * Упражнение 5: Лямбда-выражения и анонимные функции
 * 
 * Реализуйте следующие функции, используя лямбда-выражения и анонимные функции:
 * - List<Int>.customFilter(predicate: (Int) -> Boolean): List<Int>: фильтрует список по условию
 * - List<Int>.customMap(transform: (Int) -> String): List<String>: преобразует элементы списка
 * - List<Int>.customReduce(initial: Int, operation: (Int, Int) -> Int): Int: сворачивает список в одно значение
 * - List<Int>.customForEach(action: (Int) -> Unit): выполняет действие для каждого элемента списка
 */
class Exercise5 {
    // your solution
    
    // Демонстрация использования лямбда-выражений и анонимных функций
    fun demonstrateLambdasAndAnonymousFunctions() {
        // your solution
    }
}

/**
 * Упражнение 6: Функции-ссылки и ссылки на конструкторы
 * 
 * Создайте класс User с полями name: String, age: Int и конструктором User(name: String, age: Int).
 * Реализуйте следующие функции, используя функции-ссылки и ссылки на конструкторы:
 * - createUsers(names: List<String>, ages: List<Int>, creator: (String, Int) -> User): List<User>
 * - processUsers(users: List<User>, processor: (User) -> Unit)
 * - filterUsersByPredicate(users: List<User>, predicate: (User) -> Boolean): List<User>
 * - mapUsersToStrings(users: List<User>, mapper: (User) -> String): List<String>
 */
class Exercise6 {
    // your solution
    
    // Демонстрация использования функций-ссылок и ссылок на конструкторы
    fun demonstrateFunctionReferences() {
        // your solution
    }
}

/**
 * Упражнение 7: Встроенные функции высшего порядка
 * 
 * Используйте встроенные функции высшего порядка (filter, map, reduce, forEach, etc.) для решения следующих задач:
 * - Найти сумму четных чисел в списке
 * - Преобразовать список строк в список их длин
 * - Найти самое длинное слово в списке
 * - Проверить, все ли числа в списке положительные
 * - Сгруппировать слова по их первой букве
 */
class Exercise7 {
    // your solution
    
    // Демонстрация использования встроенных функций высшего порядка
    fun demonstrateBuiltInHigherOrderFunctions() {
        // your solution
    }
}

/**
 * Упражнение 8: Последовательности и ленивые вычисления
 * 
 * Реализуйте следующие функции, используя последовательности и ленивые вычисления:
 * - generateFibonacci(n: Int): List<Int>: генерирует список из n чисел Фибоначчи
 * - generatePrimes(n: Int): List<Int>: генерирует список из n простых чисел
 * - findFirstMatchingElement(list: List<Int>, predicate: (Int) -> Boolean): Int?: находит первый элемент, удовлетворяющий условию
 * - processLargeData(data: List<String>, processor: (String) -> String): List<String>: обрабатывает большой объем данных эффективно
 */
class Exercise8 {
    // your solution
    
    // Демонстрация использования последовательностей и ленивых вычислений
    fun demonstrateSequencesAndLazyEvaluation() {
        // your solution
    }
}

/**
 * Упражнение 9: Функциональные интерфейсы и SAM-преобразования
 * 
 * Создайте следующие функциональные интерфейсы:
 * - Transformer<T, R>: преобразует объект типа T в объект типа R
 * - Predicate<T>: проверяет, удовлетворяет ли объект типа T некоторому условию
 * - Consumer<T>: выполняет действие над объектом типа T
 * - Supplier<T>: поставляет объект типа T
 * 
 * Реализуйте функции, принимающие эти интерфейсы, и продемонстрируйте SAM-преобразования.
 */
class Exercise9 {
    // your solution
    
    // Демонстрация использования функциональных интерфейсов и SAM-преобразований
    fun demonstrateFunctionalInterfacesAndSAMConversions() {
        // your solution
    }
}

/**
 * Упражнение 10: Комбинирование функциональных подходов
 * 
 * Реализуйте систему обработки данных, которая:
 * - Загружает данные из "источника" (можно имитировать, возвращая фиксированный список)
 * - Фильтрует данные по нескольким критериям
 * - Преобразует данные в другой формат
 * - Группирует данные по определенному признаку
 * - Выполняет агрегацию (например, подсчет статистики)
 * - Форматирует результат в удобочитаемом виде
 * 
 * Используйте функциональные подходы, расширения и другие возможности Kotlin для создания элегантного решения.
 */
class Exercise10 {
    // your solution
    
    // Демонстрация комбинирования функциональных подходов
    fun demonstrateCombinedFunctionalApproaches() {
        // your solution
    }
} 