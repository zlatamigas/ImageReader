# ImageReader_JavaFX_App
Computer graphics. Lab 2.

Лабораторная работа 2 (срок сдачи: 16 марта для 13 группы; 18
марта для 12 группы).
Чтение информации из графических файлов (80 баллов).
Выполнение настоящей работы имеет целью закрепление теоретического
материала и практическое освоение основных возможностей по:
• работе с различными форматами хранения растровых изображений;
• получению информации об изображении, хранящемся в файле.
Задача
Написать приложение/веб-приложение, считывающее из графического 
файла/файлов (должна быть возможность указать папку, содержащую до 100000
файлов) основную информацию об изображении. Обязательно надо отображать 
следующее (для удобства результат можно представлять в таблице):
имя файла;
размер изображения (в пикселях);
разрешение (dot/inch);
глубина цвета;
сжатие (для тех типов файлов, в которых оно может быть задано).
Желающие (на доп. баллы) могут показывать и прочие данные про файл 
(матрицу квантования в jpeg, кол-во цветов в палитре gif и т.д.). Но при этом 
обязательно пояснить каждую выводимую характеристику (знать, для чего она 
нужна, и откуда берётся!!)
На проверку сдаются:
• exe, который должен работать на любом ПК под Windows /вебприложение, выложенное в общий доступ; исходный код;
• сопроводительная документация (каким способом «доставали» данные, 
какой внешней библиотекой пользовались).
Требования и критерии оценки
• Обрабатываемые форматы: jpg, gif, tif, bmp, png, pcx (проверить 
корректность выводимых данных).
• Проверка проводится на файлах, выложенных в архиве «Для проверки 
Lab#2» а быстродействие - на Вашей папке, содержащей около 600 
файлов jpeg общим объемом около 2Гб.
• Удобная подача считываемой информации