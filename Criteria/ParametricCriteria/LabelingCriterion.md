# Критерий меток

Критерий меток (labeling criterion) используется в задачах классификации для оценки качества модели на основе сопоставления предсказанных и фактических меток классов.

## Пример оценки критерия меток:

Предположим, у нас есть следующие предсказанные классы и фактические метки:

| Истинная метка | Предсказанная метка |
|----------------|---------------------|
| 0              | 0                   |
| 1              | 1                   |
| 1              | 0                   |
| 0              | 0                   |
| 1              | 1                   |

Для оценки качества модели по критерию меток мы можем вычислить процент совпадения меток между предсказанными и истинными значениями.

1. **Вычисление совпадений:**
   - В данном примере, из 5 наблюдений, 4 из них имеют совпадающие метки (0, 1, 1, 0, 1), что составляет 80% совпадений.

2. **Интерпретация:**
   - 80% точности означает, что модель правильно классифицировала 80% объектов с точки зрения их меток.

Критерий меток является простым способом оценки точности модели в задачах классификации на основе совпадения предсказанных и фактических меток классов.

### [Вернуться к критериям](../Navigation_criteria.md)

### [Вернуться к оглавлению](../../README.md)