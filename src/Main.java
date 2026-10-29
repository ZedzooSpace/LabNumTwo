import classes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public void pressEnterToContinue(Scanner scanner) {
        System.out.print("\n\u001B[90m[ Нажмите Enter, чтобы продолжить... ]\u001B[0m");
        scanner.nextLine();
        System.out.println();
    }

    public int chooseInputMode(Scanner scanner) {
        System.out.println("\n  Способ задания данных:");
        System.out.println("    1. Ввод с клавиатуры");
        System.out.println("    2. Предустановленные значения");
        System.out.print("  ➔ Выбор: ");

        while (!scanner.hasNextInt()) {
            System.out.print("  Пожалуйста, введите 1 или 2: ");
            scanner.next();
        }
        int mode = scanner.nextInt();
        scanner.nextLine();
        return mode == 1 ? 1 : 2;
    }

    void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n");
            System.out.println("  ┌────────────────────────────────────────┐");
            System.out.println("  │     ЛАБОРАТОРНАЯ РАБОТА • ВАРИАНТ 5    │");
            System.out.println("  └────────────────────────────────────────┘");
            System.out.println("    [1] Точка координат");
            System.out.println("    [2] Имена");
            System.out.println("    [3] Прямая");
            System.out.println("    [4] Города (Схема)");
            System.out.println("    [5] Создаем Города");
            System.out.println("    [6] Дроби");
            System.out.println("    [0] Выход");
            System.out.println("  ──────────────────────────────────────────");
            System.out.print("  ➔ Выберите номер задачи: ");

            if (!scanner.hasNextInt()) {
                System.out.println("  [Ошибка] Введите целое число.");
                scanner.next();
                try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            if (choice == 0) {
                System.out.println("  Завершение программы. До свидания!");
                scanner.close();
                return;
            }

            try {
                switch (choice) {
                    case 1: {
                        System.out.println("  ── ЗАДАЧА 1: Точка координат ──");
                        int mode = chooseInputMode(scanner);

                        Point p1, p2, p3;

                        if (mode == 1) {
                            System.out.println();
                            System.out.print("  • Точка 1 (X Y): ");
                            p1 = new Point(scanner.nextDouble(), scanner.nextDouble());

                            System.out.print("  • Точка 2 (X Y): ");
                            p2 = new Point(scanner.nextDouble(), scanner.nextDouble());

                            System.out.print("  • Точка 3 (X Y): ");
                            p3 = new Point(scanner.nextDouble(), scanner.nextDouble());
                            scanner.nextLine();
                        } else {
                            System.out.println("\n  [ Используются предустановленные значения ]");
                            p1 = new Point(1, 3);
                            p2 = new Point(23, 8);
                            p3 = new Point(5, 10);
                        }

                        System.out.println("\n  Результат:");
                        System.out.println("    Точка 1: " + p1);
                        System.out.println("    Точка 2: " + p2);
                        System.out.println("    Точка 3: " + p3);
                        break;
                    }

                    case 2: {
                        System.out.println("  ── ЗАДАЧА 2: Имена ──");
                        int mode = chooseInputMode(scanner);

                        Name name1, name2, name3;

                        if (mode == 1) {
                            System.out.println("\n  [ Ввод Имени 1 (только личное имя) ]");
                            System.out.print("  • Личное имя: ");
                            String f1 = scanner.nextLine().trim();
                            name1 = new Name(f1.isEmpty() ? null : f1);

                            System.out.println("\n  [ Ввод Имени 2 (Фамилия Имя Отчество) ]");
                            System.out.print("  • Фамилия: ");
                            String l2 = scanner.nextLine().trim();
                            System.out.print("  • Личное имя: ");
                            String f2 = scanner.nextLine().trim();
                            System.out.print("  • Отчество: ");
                            String p2 = scanner.nextLine().trim();
                            name2 = new Name(
                                    l2.isEmpty() ? null : l2,
                                    f2.isEmpty() ? null : f2,
                                    p2.isEmpty() ? null : p2
                            );

                            System.out.println("\n  [ Ввод Имени 3 (без отчества) ]");
                            System.out.print("  • Фамилия: ");
                            String l3 = scanner.nextLine().trim();
                            System.out.print("  • Личное имя: ");
                            String f3 = scanner.nextLine().trim();
                            name3 = new Name(
                                    l3.isEmpty() ? null : l3,
                                    f3.isEmpty() ? null : f3
                            );
                        } else {
                            System.out.println("\n  [ Используются предустановленные имена ]");
                            name1 = new Name(null, "Клеопатра", null);
                            name2 = new Name("Пушкин", "Александр", "Сергеевич");
                            name3 = new Name("Маяковский", "Владимир", null);
                        }

                        System.out.println("\n  Результат:");
                        System.out.println("    Имя 1: " + name1);
                        System.out.println("    Имя 2: " + name2);
                        System.out.println("    Имя 3: " + name3);
                        break;
                    }

                    case 3: {
                        System.out.println("  ── ЗАДАЧА 3: Прямая ──");
                        int mode = chooseInputMode(scanner);

                        Point p1Start, p1End, p2Start, p2End;

                        if (mode == 1) {
                            System.out.print("  • Начало Линии 1 (X1 Y1): ");
                            p1Start = new Point(scanner.nextDouble(), scanner.nextDouble());
                            System.out.print("  • Конец Линии 1 (X2 Y2): ");
                            p1End = new Point(scanner.nextDouble(), scanner.nextDouble());

                            System.out.print("  • Начало Линии 2 (X1 Y1): ");
                            p2Start = new Point(scanner.nextDouble(), scanner.nextDouble());
                            System.out.print("  • Конец Линии 2 (X2 Y2): ");
                            p2End = new Point(scanner.nextDouble(), scanner.nextDouble());
                            scanner.nextLine();
                        } else {
                            System.out.println("\n  [ Используются предустановленные координаты ]");
                            p1Start = new Point(1, 3);
                            p1End = new Point(23, 8);
                            p2Start = new Point(5, 10);
                            p2End = new Point(25, 10);
                        }

                        Line line1 = new Line(p1Start, p1End);
                        Line line2 = new Line(p2Start, p2End);
                        Line line3 = new Line(line1.getStart(), line2.getEnd());

                        System.out.println("\n  [ Шаги 1–3: Созданные линии ]");
                        System.out.println("    Линия 1: " + line1);
                        System.out.println("    Линия 2: " + line2);
                        System.out.println("    Линия 3: " + line3);

                        System.out.println("\n  [ Шаг 4: Изменение координат Линии 1 и 2 ]");
                        p1Start.setX(p1Start.getX() + 5);
                        p1Start.setY(p1Start.getY() + 5);
                        p2End.setX(p2End.getX() + 10);
                        System.out.println("    Линия 1 (нов.): " + line1);
                        System.out.println("    Линия 2 (нов.): " + line2);
                        System.out.println("    Линия 3 (авто): " + line3);

                        System.out.println("\n  [ Шаг 5: Изменение начала Линии 1 без изменения Линии 3 ]");
                        line1.setStart(new Point(99, 99));
                        System.out.println("    Линия 1 (изменена): " + line1);
                        System.out.println("    Линия 3 (без изменений): " + line3);
                        break;
                    }

                    case 4: {
                        System.out.println("  ── ЗАДАЧА 4: Города (Схема) ──");
                        int mode = chooseInputMode(scanner);

                        if (mode == 1) {
                            System.out.print("  • Сколько городов ввести? ");
                            int count = scanner.nextInt();
                            scanner.nextLine();

                            List<City> cityList = new ArrayList<>();
                            for (int i = 0; i < count; i++) {
                                System.out.print("    Город №" + (i + 1) + ": ");
                                cityList.add(new City(scanner.nextLine().trim()));
                            }

                            System.out.print("\n  • Добавить путь? (1 - да, 0 - нет): ");
                            while (scanner.nextInt() == 1) {
                                scanner.nextLine();
                                System.out.print("    Индекс исходного (0.." + (count - 1) + "): ");
                                int fromIdx = scanner.nextInt();
                                System.out.print("    Индекс целевого (0.." + (count - 1) + "): ");
                                int toIdx = scanner.nextInt();
                                System.out.print("    Стоимость: ");
                                int cost = scanner.nextInt();

                                cityList.get(fromIdx).addPath(cityList.get(toIdx), cost);
                                System.out.print("    Добавить еще путь? (1 - да, 0 - нет): ");
                            }
                            scanner.nextLine();

                            System.out.println("\n  Созданные города:");
                            for (City c : cityList) {
                                System.out.println("    " + c);
                            }
                        } else {
                            System.out.println("\n  [ Используется предустановленная схема ]");
                            City a = new City("A");
                            City b = new City("B");
                            City c = new City("C");
                            City d = new City("D");
                            City e = new City("E");
                            City f = new City("F");

                            a.addPath(f, 1);
                            a.addPath(d, 6);

                            b.addPath(a, 5);
                            b.addPath(c, 3);

                            d.addPath(c, 4);
                            d.addPath(e, 2);

                            e.addPath(f, 2);

                            f.addPath(b, 1);

                            for (City city : new City[]{a, b, c, d, e, f}) {
                                System.out.println("    " + city);
                            }
                        }
                        break;
                    }

                    case 5: {
                        System.out.println("  ── ЗАДАЧА 5: Создаем Города ──");
                        int mode = chooseInputMode(scanner);

                        if (mode == 1) {
                            System.out.print("  • Название Города 1 (только имя): ");
                            String nameOnly = scanner.nextLine().trim();
                            City c1 = new City(nameOnly);

                            System.out.print("  • Название Города 2 (с путем): ");
                            String nameWithPaths = scanner.nextLine().trim();

                            System.out.print("  • Целевой город пути: ");
                            String targetName = scanner.nextLine().trim();
                            System.out.print("  • Стоимость пути: ");
                            int cost = scanner.nextInt();
                            scanner.nextLine();

                            List<Path> pList = new ArrayList<>();
                            pList.add(new Path(new City(targetName), cost));

                            City c2 = new City(nameWithPaths, pList);

                            System.out.println("\n  Результат:");
                            System.out.println("    1. " + c1);
                            System.out.println("    2. " + c2);
                        } else {
                            System.out.println("\n  [ Используются предустановленные данные ]");
                            City city1 = new City("Москва");
                            System.out.println("    1. " + city1);

                            List<Path> paths = new ArrayList<>();
                            paths.add(new Path(new City("Санкт-Петербург"), 700));
                            paths.add(new Path(new City("Казань"), 800));

                            City city2 = new City("Москва", paths);
                            System.out.println("    2. " + city2);
                        }
                        break;
                    }

                    case 6: {
                        System.out.println("  ── ЗАДАЧА 6: Дроби ──");
                        int mode = chooseInputMode(scanner);

                        Fraction f1, f2, f3;

                        if (mode == 1) {
                            System.out.print("  • Дробь 1 (числитель знаменатель): ");
                            f1 = new Fraction(scanner.nextInt(), scanner.nextInt());

                            System.out.print("  • Дробь 2 (числитель знаменатель): ");
                            f2 = new Fraction(scanner.nextInt(), scanner.nextInt());

                            System.out.print("  • Целое число для операций: ");
                            int num = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("\n  Результаты вычислений:");
                            System.out.println("    f1 = " + f1 + ", f2 = " + f2);
                            System.out.println("    f1 + f2 = " + f1.sum(f2));
                            System.out.println("    f1 - f2 = " + f1.minus(f2));
                            System.out.println("    f1 * f2 = " + f1.multiply(f2));
                            System.out.println("    f1 / f2 = " + f1.div(f2));
                            System.out.println("    f1 + " + num + " = " + f1.sum(num));
                        } else {
                            System.out.println("\n  [ Используются предустановленные дроби ]");
                            f1 = new Fraction(1, 3);
                            f2 = new Fraction(2, 3);
                            f3 = new Fraction(3, 4);

                            System.out.println("    Исходные: f1 = " + f1 + ", f2 = " + f2 + ", f3 = " + f3);
                            System.out.println("    1. Сложение:    " + f1 + " + " + f2 + " = " + f1.sum(f2));
                            System.out.println("    2. Вычитание:   " + f1 + " - " + f2 + " = " + f1.minus(f2));
                            System.out.println("    3. Умножение:   " + f1 + " * " + f2 + " = " + f1.multiply(f2));
                            System.out.println("    4. Деление:     " + f1 + " / " + f3 + " = " + f1.div(f3));
                            System.out.println("    5. С числом:    " + f1 + " + 5 = " + f1.sum(5));
                            System.out.println("    6. Цепочка:     f1.sum(f2).div(f3).minus(5) = " + f1.sum(f2).div(f3).minus(5));
                        }
                        break;
                    }

                    default:
                        System.out.println("  [Ошибка] Неверный пункт меню.");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("\n  [Ошибка] Ошибка ввода");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }

            pressEnterToContinue(scanner);
        }
    }
}