package oop.exercises

/**
 * Упражнения по теме "Дженерики (обобщения) в Kotlin"
 */

/**
 * Упражнение 1: Базовые дженерики
 * 
 * Создайте обобщенный класс Box<T>, который может хранить объект типа T.
 * Реализуйте методы:
 * - setValue(value: T): устанавливает значение
 * - getValue(): T: возвращает значение
 * - getType(): String: возвращает имя типа хранимого объекта
 */
class Exercise1 {
    // your solution
    
    // Демонстрация использования обобщенного класса Box
    fun demonstrateGenericBox() {
        // your solution
    }
}

/**
 * Упражнение 2: Ограничения типов
 * 
 * Создайте обобщенный класс NumberBox<T : Number>, который может хранить только числовые типы.
 * Реализуйте методы:
 * - setValue(value: T): устанавливает значение
 * - getValue(): T: возвращает значение
 * - getDoubleValue(): Double: возвращает значение, преобразованное в Double
 */
class Exercise2 {
    // your solution
    
    // Демонстрация использования класса с ограничениями типов
    fun demonstrateNumberBox() {
        // your solution
    }
}

/**
 * Упражнение 3: Обобщенные функции
 * 
 * Реализуйте следующие обобщенные функции:
 * - <T> firstOrNull(list: List<T>, predicate: (T) -> Boolean): T?: возвращает первый элемент, удовлетворяющий условию, или null
 * - <T> lastOrNull(list: List<T>, predicate: (T) -> Boolean): T?: возвращает последний элемент, удовлетворяющий условию, или null
 * - <T, R> transform(list: List<T>, transformer: (T) -> R): List<R>: преобразует список элементов типа T в список элементов типа R
 */
class Exercise3 {
    // your solution
    
    // Демонстрация использования обобщенных функций
    fun demonstrateGenericFunctions() {
        // your solution
    }
}

/**
 * Упражнение 4: Вариантность
 * 
 * Создайте следующие классы:
 * - Инвариантный класс Container<T>
 * - Ковариантный класс Producer<out T>
 * - Контравариантный класс Consumer<in T>
 * 
 * Продемонстрируйте разницу между ними на примере иерархии классов Animal -> Dog, Cat
 */
class Exercise4 {
    // your solution
    
    // Демонстрация вариантности
    fun demonstrateVariance() {
        // your solution
    }
}

/**
 * Упражнение 5: Звездочная проекция
 * 
 * Реализуйте функцию printContainerInfo, которая принимает Container<*> и выводит информацию о нем.
 * Создайте несколько контейнеров с разными типами и продемонстрируйте использование звездочной проекции.
 */
class Exercise5 {
    // your solution
    
    // Демонстрация звездочной проекции
    fun demonstrateStarProjection() {
        // your solution
    }
}

/**
 * Упражнение 6: Обобщенные расширения
 * 
 * Создайте следующие функции-расширения:
 * - <T> List<T>.filterByType<R>(): List<R>: фильтрует список, оставляя только элементы типа R
 * - <T> List<T>.findByType<R>(): R?: находит первый элемент типа R или возвращает null
 * - <T> T.toBox(): Box<T>: создает Box, содержащий текущий объект
 */
class Exercise6 {
    // your solution
    
    // Демонстрация обобщенных расширений
    fun demonstrateGenericExtensions() {
        // your solution
    }
}

/**
 * Упражнение 7: Обобщенные делегаты свойств
 * 
 * Создайте обобщенный делегат свойства Cached<T>, который кэширует значение и вычисляет его только при первом доступе.
 * Создайте обобщенный делегат свойства Validated<T>, который проверяет значение перед установкой с помощью переданной функции-валидатора.
 */
class Exercise7 {
    // your solution
    
    // Демонстрация обобщенных делегатов свойств
    fun demonstrateGenericPropertyDelegates() {
        // your solution
    }
}

/**
 * Упражнение 8: Обобщенные алгоритмы
 * 
 * Реализуйте следующие обобщенные алгоритмы:
 * - <T : Comparable<T>> List<T>.mergeSort(): List<T>: сортировка слиянием
 * - <T> List<T>.partition(predicate: (T) -> Boolean): Pair<List<T>, List<T>>: разделяет список на две части по условию
 * - <T, K> List<T>.groupBy(keySelector: (T) -> K): Map<K, List<T>>: группирует элементы по ключу
 */
class Exercise8 {
    // your solution
    
    // Демонстрация обобщенных алгоритмов
    fun demonstrateGenericAlgorithms() {
        // your solution
    }
}

/**
 * Упражнение 9: Рекурсивные обобщенные типы
 * 
 * Создайте обобщенный класс TreeNode<T>, представляющий узел дерева.
 * Каждый узел должен иметь значение типа T и список дочерних узлов.
 * Реализуйте методы для добавления дочерних узлов, поиска узла по значению и обхода дерева.
 */
class Exercise9 {
    // your solution
    
    // Демонстрация рекурсивных обобщенных типов
    fun demonstrateGenericTreeNode() {
        // your solution
    }
}

/**
 * Упражнение 10: Комплексное задание
 * 
 * Реализуйте обобщенную структуру данных Graph<T>, представляющую граф.
 * Граф должен поддерживать следующие операции:
 * - addVertex(vertex: T): добавление вершины
 * - addEdge(from: T, to: T, weight: Double = 1.0): добавление ребра
 * - removeVertex(vertex: T): удаление вершины
 * - removeEdge(from: T, to: T): удаление ребра
 * - getNeighbors(vertex: T): List<T>: получение соседей вершины
 * - shortestPath(from: T, to: T): List<T>?: нахождение кратчайшего пути между вершинами
 */
class Exercise10 {
    // your solution
    
    // Демонстрация работы с графом
    fun demonstrateGraph() {
        // your solution
    }
} 