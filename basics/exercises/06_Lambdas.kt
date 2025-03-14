/**
 * Задания по теме "Лямбды и функциональное программирование в Kotlin"
 */

/**
 * Задача 1: Простая лямбда-функция
 * 
 * Создайте лямбда-функцию, которая принимает два целых числа и возвращает их сумму.
 * Затем используйте эту лямбду для вычисления суммы чисел 5 и 7.
 */
class Solution1 {
    fun sumWithLambda(): Int {
        // your solution
    }
}

/**
 * Задача 2: Функция высшего порядка с лямбдой
 * 
 * Создайте функцию высшего порядка, которая принимает список строк и лямбда-функцию для фильтрации.
 * Функция должна возвращать список строк, для которых лямбда-функция возвращает true.
 * 
 * Используйте эту функцию для фильтрации списка строк, оставив только те, длина которых больше 5 символов.
 */
class Solution2 {
    fun filterStrings(strings: List<String>, predicate: (String) -> Boolean): List<String> {
        // your solution
    }
    
    fun getLongStrings(strings: List<String>): List<String> {
        // your solution
    }
}

/**
 * Задача 3: Использование стандартных функций высшего порядка
 * 
 * Используйте стандартные функции высшего порядка Kotlin (map, filter, reduce)
 * для преобразования списка целых чисел следующим образом:
 * 1. Отфильтруйте только четные числа
 * 2. Умножьте каждое число на 2
 * 3. Найдите сумму всех полученных чисел
 */
class Solution3 {
    fun processNumbers(numbers: List<Int>): Int {
        // your solution
    }
}

/**
 * Задача 4: Лямбда с получателем
 * 
 * Создайте функцию, которая принимает строку и лямбду с получателем типа StringBuilder.
 * Функция должна создать StringBuilder с исходной строкой, применить к нему лямбду
 * и вернуть результат в виде строки.
 * 
 * Используйте эту функцию для добавления префикса "Привет, " и суффикса "!" к имени.
 */
class Solution4 {
    fun buildString(initial: String, builder: StringBuilder.() -> Unit): String {
        // your solution
    }
    
    fun greet(name: String): String {
        // your solution
    }
}

/**
 * Задача 5: Замыкания в лямбдах
 * 
 * Создайте функцию, которая возвращает функцию-счетчик.
 * Каждый вызов возвращенной функции должен увеличивать счетчик на 1 и возвращать его значение.
 */
class Solution5 {
    fun createCounter(): () -> Int {
        // your solution
    }
    
    fun demonstrateCounter(): List<Int> {
        // your solution
    }
}

/**
 * Задача 6: Функция с несколькими лямбдами
 * 
 * Создайте функцию, которая принимает список чисел и две лямбда-функции:
 * - первая лямбда определяет, нужно ли обрабатывать число
 * - вторая лямбда выполняет преобразование числа
 * 
 * Функция должна применить преобразование только к тем числам, которые удовлетворяют условию,
 * и вернуть список результатов.
 */
class Solution6 {
    fun processWithCondition(
        numbers: List<Int>,
        condition: (Int) -> Boolean,
        transform: (Int) -> Int
    ): List<Int> {
        // your solution
    }
    
    fun getSquaresOfEvenNumbers(numbers: List<Int>): List<Int> {
        // your solution
    }
}

/**
 * Задача 7: Композиция функций
 * 
 * Создайте функцию, которая принимает две функции и возвращает их композицию.
 * Композиция функций f и g - это функция h, такая что h(x) = f(g(x)).
 * 
 * Используйте эту функцию для создания композиции, которая удваивает число и затем прибавляет 1.
 */
class Solution7 {
    fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
        // your solution
    }
    
    fun createDoubleAndAddOne(): (Int) -> Int {
        // your solution
    }
    
    fun testComposition(x: Int): Int {
        // your solution
    }
}

/**
 * Задача 8: Функция fold
 * 
 * Используйте функцию fold для реализации следующих операций над списком целых чисел:
 * 1. Найти произведение всех чисел
 * 2. Найти максимальное число
 * 3. Объединить числа в строку через запятую
 */
class Solution8 {
    fun calculateProduct(numbers: List<Int>): Int {
        // your solution
    }
    
    fun findMaximum(numbers: List<Int>): Int {
        // your solution
    }
    
    fun joinToString(numbers: List<Int>): String {
        // your solution
    }
}

/**
 * Задача 9: Функция apply
 * 
 * Используйте функцию apply для создания и настройки объекта Person.
 * Класс Person должен иметь свойства: имя, возраст и список навыков.
 */
class Solution9 {
    data class Person(
        var name: String = "",
        var age: Int = 0,
        val skills: MutableList<String> = mutableListOf()
    )
    
    fun createPerson(): Person {
        // your solution
    }
}

/**
 * Задача 10: Функциональная обработка коллекций
 * 
 * Создайте класс Student с полями: имя, возраст и список оценок.
 * Реализуйте функции для работы со списком студентов:
 * 1. Найти средний балл каждого студента
 * 2. Найти студентов с средним баллом выше заданного порога
 * 3. Сгруппировать студентов по возрасту
 * 4. Найти студента с наивысшим средним баллом
 */
class Solution10 {
    data class Student(
        val name: String,
        val age: Int,
        val grades: List<Int>
    ) {
        fun averageGrade(): Double = // your solution
    }
    
    fun getAverageGrades(students: List<Student>): Map<String, Double> {
        // your solution
    }
    
    fun getTopStudents(students: List<Student>, threshold: Double): List<Student> {
        // your solution
    }
    
    fun groupByAge(students: List<Student>): Map<Int, List<Student>> {
        // your solution
    }
    
    fun findBestStudent(students: List<Student>): Student? {
        // your solution
    }
} 