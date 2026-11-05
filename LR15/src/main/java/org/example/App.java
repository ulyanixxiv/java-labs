package org.example;

public class App {
    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("    ЛАБОРАТОРНАЯ РАБОТА № 15: СИСТЕМА УПРАВЛЕНИЯ ВЕРСИЯМИ GIT И GITHUB");
        System.out.println("================================================================================\n");

        System.out.println("1. Ключевые концепции Git:");
        System.out.println("   • Распределенная архитектура (DVCS): каждый клиент имеет полную копию репозитория.");
        System.out.println("   • Хранение данных: снимки (snapshots) состояния проекта, а не дельты различий.");
        System.out.println("   • Три состояния файлов:");
        System.out.println("       - Modified (изменен в рабочей директории)");
        System.out.println("       - Staged (подготовлен к коммиту через git add)");
        System.out.println("       - Committed (зафиксирован в локальной базе данных Git)");

        System.out.println("\n2. Основные команды рабочего процесса:");
        System.out.println("   git init                      # Создание нового репозитория");
        System.out.println("   git checkout -b <ветка>       # Создание и переключение на новую ветку");
        System.out.println("   git add .                     # Добавление всех изменений в индекс");
        System.out.println("   git commit -m \"сообщение\"     # Фиксация изменений");
        System.out.println("   git checkout main             # Возврат в главную ветку");
        System.out.println("   git merge --no-ff <ветка>     # Слияние с созданием merge-коммита");
        System.out.println("   git push -u origin main       # Публикация на GitHub\n");

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("3. Выполнение задания: последовательный перенос ЛР № 1–15 в репозиторий:");
        System.out.println("--------------------------------------------------------------------------------\n");

        GitWorkflowManager workflow = new GitWorkflowManager("java-labs-repository");

        String[][] labs = {
                {"lab1", "Базовый синтаксис, типы данных и операторы"},
                {"lab2", "Линейные и разветвляющиеся алгоритмы"},
                {"lab3", "Циклические конструкции и массивы"},
                {"lab4", "Классы, объекты и методы"},
                {"lab5", "Конструкторы и инкапсуляция"},
                {"lab6", "Массивы объектов и работа со строками"},
                {"lab7", "Пакеты и статические члены классов"},
                {"lab8", "Наследование и полиморфизм"},
                {"lab9", "Абстрактные классы и интерфейсы"},
                {"lab10", "Вложенные и анонимные классы"},
                {"lab11", "Перегрузка и переопределение методов"},
                {"lab12", "Обобщенные типы (Generics) и коллекции JCF"},
                {"lab13", "Обработка исключительных ситуаций (Exceptions)"},
                {"lab14", "Файловый ввод и вывод (I/O Streams)"},
                {"lab15", "Система контроля версий Git и работа с GitHub"}
        };

        for (String[] lab : labs) {
            workflow.processLabWork(lab[0], lab[1]);
        }

        System.out.println("Список созданных и успешно объединенных веток:");
        for (GitBranch b : workflow.getBranches()) {
            System.out.println("  ✓ " + b);
        }

        System.out.println();
        workflow.printCommitLogGraph();

        System.out.println("\n================================================================================");
        System.out.println("               ЛАБОРАТОРНАЯ РАБОТА № 15 УСПЕШНО ЗАВЕРШЕНА!");
        System.out.println("================================================================================");
    }
}
