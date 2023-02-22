Основное задание:
1. 	Реализовать фреймворк согласно индивидуальному заданию
2. 	Создать public Git репозиторий содержащий финальный результат дипломной работы
3. 	Реализовать следующий набор UI тестов
      a. 	6 позитивных тестов
      i. 	1 тест на проверку поля для ввода на граничные значения
      ii. 	1 тест на проверку всплывающего сообщения
      iii. 	1 тест на создание сущности
      iv. 	1 тест на удаление сущности
      v. 	1 тест отображения диалогового окна
      vi. 	1 тест на загрузку файла
      b. 	3 негативных теста
      i. 	1 тест на использование некорректных данных
      ii. 	1 тест на ввод данных превышающих допустимые
      iii. 	1 тест воспроизводящий любой дефект
4. 	Реализовать следующий набор API тестов
      a. 	Get - 3 теста - NFE + 2 AFE
      b. 	Post
5. 	Подключить Allure для формирования отчета
6.  Подключить Logger
7. 	Настроить CI/CD систему для запуска теста и отображения отчета
8. 	Подготовить презентацию и защитить дипломную работу (2 человека одновременно):
      a. 	Рассказать преимущества выбранного фреймворка
      b. 	Рассказать об особенностях реализации
      c. 	Запуск тестов на CI/CD
      d. 	Презентовать отчет о выполнении

Дополнительное задание:
1. 	Подготовить презентацию архитектуры
2. 	Описание тестов и видов тестирования
3. 	Подготовить различные планы прогона
      a. 	Кросс-браузерный
      b. 	Параллельный
4. 	Использовать BDD подход
5. 	Использовать Selenide
6. 	Создать данные для тестов используя API
7. Использовать онлайн DB для хранения данных для тестов

GIT STRATEGY
·      master — main branch
·      develop — the main development branch. Each commit to the develop branch is a result of a feature development completion. 
Each commit should be a result of a merge of merge request from a feature branch.
·      feature — each new feature should reside in its own branch, which is created off of the latest develop version.
When a feature is complete, it gets merged back into develop via merge request. After the feature branch is deleted.

Группа №1:
Мышко Анастасия, Лавренчук Станислав - TestRail
PageObject + Lombok + Builder + Selenium WD + TestNG + Wrappers  c параллельным запуском (Smoke and Regression)
Основное задание
Jenkins
Доп задание “Создать данные для тестов используя API, которые взять из подготовленных JSON файлов”


