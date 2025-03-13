/**
 * Задания по теме "Переменные и типы данных в Kotlin"
 */

/**
 * Задача 1: Объявление переменных
 * 
 * Создайте метод, который объявляет две переменные: 
 * - неизменяемую переменную name типа String со значением "Kotlin"
 * - изменяемую переменную version типа Double со значением 1.5
 * 
 * Метод должен вернуть строку в формате "Язык: name, Версия: version"
 */
class Solution1 {
    fun declareVariables(): String {
        // your solution
    }
}

/**
 * Задача 2: Преобразование типов
 * 
 * Создайте метод, который принимает строку, содержащую число,
 * преобразует её в целое число (Int), умножает на 2 и возвращает результат.
 * Если строка не может быть преобразована в число, метод должен вернуть -1.
 */
class Solution2 {
    fun convertAndDouble(input: String): Int {
        // your solution
    }
}

/**
 * Задача 3: Работа со строками
 * 
 * Создайте метод, который принимает имя и возраст пользователя,
 * а затем возвращает приветственное сообщение в формате:
 * "Привет, {имя}! Через 10 лет тебе будет {возраст + 10} лет."
 */
class Solution3 {
    fun createGreeting(name: String, age: Int): String {
        // your solution
    }
}

/**
 * Задача 4: Nullable типы
 * 
 * Создайте метод, который принимает nullable строку и возвращает:
 * - длину строки, если строка не null
 * - 0, если строка null
 */
class Solution4 {
    fun getStringLength(input: String?): Int {
        // your solution
    }
}

/**
 * Задача 5: Работа с массивами
 * 
 * Создайте метод, который принимает массив целых чисел и возвращает
 * новый массив, содержащий только четные числа из исходного массива.
 */
class Solution5 {
    fun filterEvenNumbers(numbers: IntArray): IntArray {
        // your solution
    }
}

/**
 * Задача 6: Многострочные строки
 * 
 * Создайте метод, который принимает имя, адрес и телефон пользователя,
 * а затем возвращает многострочную строку с этой информацией в формате:
 * 
 * Имя: {имя}
 * Адрес: {адрес}
 * Телефон: {телефон}
 */
class Solution6 {
    fun formatUserInfo(name: String, address: String, phone: String): String {
        // your solution
    }
}

/**
 * Задача 7: Безопасная работа с nullable типами
 * 
 * Создайте метод, который принимает два nullable целых числа и возвращает:
 * - их сумму, если оба числа не null
 * - первое число, если второе число null
 * - второе число, если первое число null
 * - 0, если оба числа null
 */
class Solution7 {
    fun safeSum(a: Int?, b: Int?): Int {
        // your solution
    }
}

/**
 * Задача 8: Преобразование типов в коллекциях
 * 
 * Создайте метод, который принимает список строк, содержащих числа,
 * и возвращает сумму всех чисел. Если какая-то строка не может быть
 * преобразована в число, она должна быть проигнорирована.
 */
class Solution8 {
    fun sumOfStringNumbers(strings: List<String>): Int {
        // your solution
    }
}

/**
 * Задача 9: Работа с символами
 * 
 * Создайте метод, который принимает строку и возвращает новую строку,
 * в которой каждый символ заменен на его код Unicode.
 * Например, "abc" должно превратиться в "979899".
 */
class Solution9 {
    fun convertToUnicode(input: String): String {
        // your solution
    }
}

/**
 * Задача 10: Комплексная задача
 * 
 * Создайте метод, который принимает информацию о студенте:
 * - имя (String)
 * - возраст (Int)
 * - оценки (IntArray)
 * - адрес (String, может быть null)
 * 
 * Метод должен вернуть строку с информацией о студенте в формате:
 * "Студент: {имя}, Возраст: {возраст}, Средний балл: {средний балл}, Адрес: {адрес или "не указан"}"
 */
class Solution10 {
    fun formatStudentInfo(name: String, age: Int, grades: IntArray, address: String?): String {
        // your solution
    }
} 