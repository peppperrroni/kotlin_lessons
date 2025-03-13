/**
 * Задания по теме "Коллекции в Kotlin"
 */

/**
 * Задача 1: Списки (List)
 * 
 * Создайте функцию, которая принимает список целых чисел и возвращает новый список,
 * содержащий только четные числа из исходного списка.
 */
class Solution1 {
    fun filterEvenNumbers(numbers: List<Int>): List<Int> {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateFilterEvenNumbers(): List<Int> {
        // your solution
    }
}

/**
 * Задача 2: Множества (Set)
 * 
 * Создайте функцию, которая принимает два множества строк и возвращает:
 * - объединение множеств
 * - пересечение множеств
 * - разность множеств (первое минус второе)
 */
class Solution2 {
    fun setOperations(set1: Set<String>, set2: Set<String>): Map<String, Set<String>> {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateSetOperations(): Map<String, Set<String>> {
        // your solution
    }
}

/**
 * Задача 3: Словари (Map)
 * 
 * Создайте функцию, которая принимает список строк и возвращает Map,
 * где ключами являются строки, а значениями - количество их повторений в списке.
 */
class Solution3 {
    fun countOccurrences(words: List<String>): Map<String, Int> {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateCountOccurrences(): Map<String, Int> {
        // your solution
    }
}

/**
 * Задача 4: Преобразование коллекций
 * 
 * Создайте функцию, которая принимает список строк и возвращает новый список,
 * содержащий длины каждой строки из исходного списка.
 */
class Solution4 {
    fun getStringLengths(strings: List<String>): List<Int> {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateGetStringLengths(): List<Int> {
        // your solution
    }
}

/**
 * Задача 5: Фильтрация и преобразование
 * 
 * Создайте функцию, которая принимает список целых чисел и возвращает сумму
 * квадратов всех чисел, которые больше 10.
 */
class Solution5 {
    fun sumOfSquaresGreaterThanTen(numbers: List<Int>): Int {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateSumOfSquares(): Int {
        // your solution
    }
}

/**
 * Задача 6: Группировка
 * 
 * Создайте класс Student с свойствами name (String) и grade (Int).
 * Создайте функцию, которая принимает список студентов и группирует их по оценкам.
 */
class Solution6 {
    data class Student(val name: String, val grade: Int)
    
    fun groupStudentsByGrade(students: List<Student>): Map<Int, List<Student>> {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateGrouping(): Map<Int, List<String>> {
        // your solution
    }
}

/**
 * Задача 7: Сортировка
 * 
 * Создайте класс Product с свойствами name (String) и price (Double).
 * Создайте функцию, которая принимает список продуктов и возвращает новый список,
 * отсортированный по цене (по возрастанию).
 */
class Solution7 {
    data class Product(val name: String, val price: Double)
    
    fun sortProductsByPrice(products: List<Product>): List<Product> {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateSorting(): List<String> {
        // your solution
    }
}

/**
 * Задача 8: Агрегация
 * 
 * Создайте функцию, которая принимает список целых чисел и возвращает:
 * - минимальное значение
 * - максимальное значение
 * - среднее значение
 * - сумму всех значений
 */
class Solution8 {
    fun aggregateStatistics(numbers: List<Int>): Map<String, Double> {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateAggregation(): Map<String, Double> {
        // your solution
    }
}

/**
 * Задача 9: Последовательности (Sequence)
 * 
 * Создайте функцию, которая генерирует последовательность чисел Фибоначчи
 * и возвращает список первых n чисел.
 */
class Solution9 {
    fun fibonacciSequence(n: Int): List<Int> {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateFibonacciSequence(): List<Int> {
        // your solution
    }
}

/**
 * Задача 10: Комбинирование операций
 * 
 * Создайте класс Order с свойствами id (Int), customerName (String) и amount (Double).
 * Создайте функцию, которая принимает список заказов и возвращает:
 * - общую сумму всех заказов
 * - среднюю сумму заказа
 * - список имен клиентов, сделавших заказы на сумму больше 1000
 * - Map, где ключ - имя клиента, значение - сумма всех его заказов
 */
class Solution10 {
    data class Order(val id: Int, val customerName: String, val amount: Double)
    
    fun analyzeOrders(orders: List<Order>): Map<String, Any> {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateOrderAnalysis(): Map<String, Any> {
        // your solution
    }
} 