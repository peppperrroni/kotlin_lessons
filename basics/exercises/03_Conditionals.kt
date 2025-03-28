/**
 * Задания по теме "Условные выражения в Kotlin"
 */

/**
 * Задача 1: Простое условие
 * 
 * Создайте метод, который принимает возраст человека и возвращает строку:
 * - "Несовершеннолетний", если возраст меньше 18
 * - "Совершеннолетний", если возраст от 18 до 65
 * - "Пенсионер", если возраст больше 65
 */
class Solution1 {
    fun checkAge(age: Int): String {
        // your solution
    }
}

/**
 * Задача 2: Использование when
 * 
 * Создайте метод, который принимает день недели (число от 1 до 7) и возвращает:
 * - Название дня недели на русском языке
 * - "Некорректный день", если число не входит в диапазон от 1 до 7
 */
class Solution2 {
    fun getDayOfWeek(day: Int): String {
        // your solution
    }
}

/**
 * Задача 3: Проверка числа
 * 
 * Создайте метод, который принимает целое число и возвращает строку:
 * - "Положительное", если число больше 0
 * - "Отрицательное", если число меньше 0
 * - "Ноль", если число равно 0
 * 
 * Дополнительно, добавьте к результату " четное" или " нечетное",
 * если число не равно 0.
 */
class Solution3 {
    fun checkNumber(number: Int): String {
        // your solution
    }
}

/**
 * Задача 4: Оценка по баллам
 * 
 * Создайте метод, который принимает количество баллов (от 0 до 100)
 * и возвращает оценку по следующей шкале:
 * - "A": 90-100 баллов
 * - "B": 80-89 баллов
 * - "C": 70-79 баллов
 * - "D": 60-69 баллов
 * - "F": менее 60 баллов
 * - "Некорректный балл", если число не входит в диапазон от 0 до 100
 */
class Solution4 {
    fun getGrade(score: Int): String {
        // your solution
    }
}

/**
 * Задача 5: Проверка строки
 * 
 * Создайте метод, который принимает строку и возвращает:
 * - "Пустая строка", если строка пуста
 * - "Односимвольная строка: X", если строка содержит только один символ X
 * - "Палиндром", если строка читается одинаково слева направо и справа налево (без учета регистра)
 * - "Обычная строка", во всех остальных случаях
 */
class Solution5 {
    fun checkString(input: String): String {
        // your solution
    }
}

/**
 * Задача 6: Безопасная работа с null
 * 
 * Создайте метод, который принимает два nullable целых числа и возвращает:
 * - "Оба значения равны null", если оба аргумента null
 * - "Первое значение равно null", если только первый аргумент null
 * - "Второе значение равно null", если только второй аргумент null
 * - "Сумма: X", где X - сумма двух чисел, если оба аргумента не null
 */
class Solution6 {
    fun safeOperation(a: Int?, b: Int?): String {
        // your solution
    }
}

/**
 * Задача 7: Проверка типа с when и is
 * 
 * Создайте метод, который принимает объект типа Any и возвращает строку,
 * описывающую тип объекта и его значение:
 * - "Целое число: X", если объект типа Int
 * - "Строка длиной X: Y", если объект типа String, где X - длина строки, Y - сама строка
 * - "Логическое значение: X", если объект типа Boolean
 * - "Список размером X", если объект типа List<*>, где X - размер списка
 * - "Неизвестный тип", для всех остальных типов
 */
class Solution7 {
    fun describeType(obj: Any): String {
        // your solution
    }
}

/**
 * Задача 8: Определение времени суток
 * 
 * Создайте метод, который принимает час (от 0 до 23) и возвращает время суток:
 * - "Ночь", если час от 0 до 5
 * - "Утро", если час от 6 до 11
 * - "День", если час от 12 до 17
 * - "Вечер", если час от 18 до 23
 * - "Некорректное время", если час не входит в диапазон от 0 до 23
 */
class Solution8 {
    fun getTimeOfDay(hour: Int): String {
        // your solution
    }
}

/**
 * Задача 9: Проверка пароля
 * 
 * Создайте метод, который проверяет надежность пароля и возвращает:
 * - "Слишком короткий", если длина пароля меньше 8 символов
 * - "Слабый", если пароль содержит только буквы или только цифры
 * - "Средний", если пароль содержит буквы и цифры
 * - "Сильный", если пароль содержит буквы, цифры и специальные символы (не буквы и не цифры)
 */
class Solution9 {
    fun checkPassword(password: String): String {
        // your solution
    }
}

/**
 * Задача 10: Калькулятор
 * 
 * Создайте метод, который принимает два числа и операцию (+, -, *, /) в виде строки,
 * и возвращает результат операции в виде строки.
 * Если операция деления и второе число равно 0, верните "Деление на ноль".
 * Если передана неизвестная операция, верните "Неизвестная операция".
 */
class Solution10 {
    fun calculate(a: Double, b: Double, operation: String): String {
        // your solution
    }
}
