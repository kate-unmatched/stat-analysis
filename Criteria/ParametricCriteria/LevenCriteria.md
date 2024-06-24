### Критерий Левена

**Определение:**
Критерий Левена используется для проверки гипотезы о равенстве дисперсий нескольких групп данных.

**Формулы:**

1. **Мера центральной тенденции в каждой группе:**

  $$\bar{X}_i = \frac{1}{n_i} \sum_{j=1}^{n_i} X_{ij}$$

   где $\bar{X}_i$- среднее значение в группе $i$ , $n_i$- количество наблюдений в группе $i$, $X_{ij}$ - $j$ - е наблюдение в группе $i$.

2. **Абсолютные отклонения от среднего:**
  $$|X_{ij} - \bar{X}_i|$$

   где $X_{ij}$ - $j$ -е наблюдение в группе $i$ , $\bar{X}_i$ - среднее значение в группе $i$.

3. **Медиана абсолютных отклонений:**
  $$M_i = \text{median}(|X_{ij} - \bar{X}_i|)$$

4. **Среднее значение медиан:**
  $$\bar{M} = \frac{1}{k} \sum_{i=1}^{k} M_i$$

5. **Статистика критерия Левена:**
  $$
   W = \frac{(N-k)}{(k-1)} \cdot \frac{\sum_{i=1}^{k} n_i (\bar{M} - M_i)^2}{\sum_{i=1}^{k} \sum_{j=1}^{n_i} (X_{ij} - \bar{X}_i)^2}
  $$

   где $N = \sum_{i=1}^{k} n_i$ - общее количество наблюдений, $k$- количество групп данных, $n_i$- количество наблюдений в группе $i$ , $\bar{M}$ - среднее значение медиан абсолютных отклонений,$M_i$- медиана абсолютных отклонений для группы $i$ , $\bar{X}_i$ - среднее значение в группе $i$ , $X_{ij}$ - $j$ -е наблюдение в группе $i$.

**Пример использования в Python:**

```python
from scipy.stats import levene

# Пример данных
group1 = [1.2, 2.5, 3.7, 2.1, 2.8]
group2 = [1.8, 2.9, 3.2, 2.5, 3.0]
group3 = [1.5, 2.0, 3.0, 2.3, 2.6]

# Рассчитываем статистику и p-значение
statistic, p_value = levene(group1, group2, group3)
print(f"Statistic: {statistic}, p-value: {p_value}")
```

### [Вернуться к критериям](../Navigation_criteria.md)

### [Вернуться к оглавлению](../../README.md)