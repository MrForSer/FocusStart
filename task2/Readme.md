Программа считывает тип фигуры и её параметры из файла, рассчитывает вычисляемые характеристики фигуры и выводит результаты в консоль или файл, в зависимости от аргументов командной строки.

Аргументы командной строки (указываются без кавычек, 2 аргумента через пробел, в нижеуказанном порядке):
1. Название файла, например "input.txt";
2. Тип вывода:
 "inFile" - вывод в файл (results.txt, создается в корне проекта);
 "inConsole" - вывод в консоль;

Поддерживаемые типы фигур:
 - RECTANGLE
 - TRIANGLE
 - CIRCLE

Структура входного файла с параметрами:
Первой строкой в файле идет код типа фигуры. Второй строкой – параметры фигуры через пробел.
Можно вводить десятичные значения (десятичный разделитель - точка).
Результаты записываются в файл results.txt.