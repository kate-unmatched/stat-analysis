# 25. Критерий Манна-Уитни-Уилкоксона

Критерий Манна-Уитни-Уилкоксона (также известный как U-критерий Манна-Уитни) — это непараметрический тест, используемый для сравнения двух независимых выборок. Он определяет, различаются ли медианы двух популяций.

## Параметры критерия Манна-Уитни-Уилкоксона:

1. **n₁** - количество наблюдений в первой выборке.
2. **n₂** - количество наблюдений во второй выборке.
3. **U** - статистика Манна-Уитни, рассчитываемая как сумма рангов первой выборки или вторая сумма рангов второй выборки, в зависимости от теста.
4. **R₁** - сумма рангов первой выборки.
5. **R₂** - сумма рангов второй выборки.

## Условия для проведения проверки:

1. **Независимость наблюдений**: Наблюдения в обеих выборках должны быть независимыми.
2. **Сравнение распределений**: Оценка различий в центральных тенденциях (обычно медианах) двух выборок.
3. **Ранжирование данных**: Все наблюдения из обеих выборок объединяются и ранжируются.

## Ход проверки:

1. **Объединение и ранжирование данных**:
   - Объединяем данные из обеих выборок.
   - Присваиваем ранги всем объединенным наблюдениям.

2. **Вычисление суммы рангов для каждой выборки**:
   - Рассчитываем сумму рангов первой выборки $R₁$.
   - Рассчитываем сумму рангов второй выборки $R₂$.

3. **Вычисление статистики Манна-Уитни (U)**:
   Статистика $U$ определяется как:

   $$U₁ = R₁ - \frac{n₁ (n₁ + 1)}{2}$$

   $$U₂ = R₂ - \frac{n₂ (n₂ + 1)}{2}$$

   Итоговая статистика $U$:

   $$U = \min(U₁, U₂)$$

4. **Определение критического значения**:
   - Для малых выборок (обычно $n₁, n₂ \leq 20$) используются таблицы критических значений.
   - Для больших выборок применяется нормальное приближение:
   
   $$Z = \frac{U - \mu_U}{\sigma_U}$$
   
   где $\mu_U = \frac{n₁ n₂}{2}$ и $\sigma_U = \sqrt{\frac{n₁ n₂ (n₁ + n₂ + 1)}{12}}$.

5. **Интерпретация результатов**:
   - Сравниваем статистику $U$ или $Z$ с критическим значением.
   - Если $U$ или $Z$ меньше критического значения, отвергаем нулевую гипотезу.

## Пример

![alt text](Pictures/image-62.png)

Сотрудник налоговой службы хочет сравнить средние значения в двух выборках заявленных трат на компенсацию командировочных расходов в одной и той же компании в двух разных периодах (расходы скорректированы на инфляцию).

### Формулировка гипотез:

- Нулевая гипотеза ($H_0$): Средние расходы равны.
- Альтернативная гипотеза ($H_1$): Средние расходы не равны.

### Ход решения задачи:

1. **Вычисление U-статистики:**
   - Упорядочим все наблюдения из обеих выборок и присвоим ранги. Если есть совпадающие значения, ранги считаются как среднее арифметическое рангов, которые они занимают.
   - Вычислим сумму рангов $U_1$ для выборки X1 и $U_2$ для выборки X2.
   - $U_1$ и $U_2$ должны быть вычислены таким образом, чтобы $U_1 + U_2 = n_1 n_2$, где $n_1$ и $n_2$ — размеры выборок X1 и X2 соответственно.

2. **Расчет статистики U:**
   - В данном случае $U_1 = 40$ (получен по вычислениям рангов) для X1 и $U_2 = 60$ для X2.
   - Проверка гипотезы осуществляется через сравнение полученной статистики с критическим значением.

3. **Принятие решения:**
   - Сравним значение статистики U с критическим значением из таблицы критических значений для U-критерия при заданном уровне значимости (обычно 5%).
   - Если значение статистики U попадает в критическую область, то нулевая гипотеза отвергается в пользу альтернативной. В противном случае нулевая гипотеза не отвергается.

### Результаты:

- Значение p = 0.3072.
- 95% доверительный интервал для медианной разности: [-9, 4].

В данной задаче значение p равно 0.3072, что означает, что на уровне значимости 5% нет достаточных оснований отвергнуть нулевую гипотезу о равенстве средних расходов. Таким образом, на основе имеющихся данных нет оснований считать, что средние значения расходов на компенсацию командировочных расходов значимо различаются между двумя периодами.

### [Вернуться к критериям](../Navigation_criteria.md)

### [Вернуться к оглавлению](../../README.md)