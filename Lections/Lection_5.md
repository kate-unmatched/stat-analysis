# Прикладной статистический анализ данных. Регрессионный анализ

Содержание:

1. [**Первое появление**](#первое-появление)
2. [**Другие работы Гальтона**](#другие-работы-гальтона)
3. [**Постановка задачи линейной регрессии**](#постановка-задачи-линейной-регрессии)
4. [**Метод наименьших квадратов (MHK)**](#метод-наименьших-квадратов-mhk)
5. [**Инверсия задачи регрессии**](#инверсия-задачи-регрессии)
6. [**Goodness-of-fit**](#goodness-of-fit)
7. [**Приведённый коэффициент детерминации**](#приведённый-коэффициент-детерминации)
8. [**Предположения модели**](#предположения-модели)
9. [**Неправильное определение модели**](#неправильное-определение-модели)
10. [**Дисперсия**](#дисперсия)
11. [**Бинарные признаки**](#бинарные-признаки)
12. [**Категориальные признаки**](#категориальные-признаки)
13. [**Фиктивные переменные**](#фиктивные-переменные)
14. [**Доверительные и предсказательные интервалы**](#доверительные-и-предсказательные-интервалы)
15. [**t-критерий Стьюдента**](#t-критерий-стьюдента)
16. [**Критерий Фишера**](#критерий-фишера)
17. [**Связь между критериями Фишера и Стьюдента**](#связь-между-критериями-фишера-и-стьюдента)
18. [**Сравнение невложенных моделей**](#сравнение-невложенных-моделей)
19. [**Критерий Давидсона-Маккиннона**](#критерий-давидсона-маккиннона)
20. [**Пошаговая регрессия**](#пошаговая-регрессия)
21. [**Эксперимент Фридмана**](#эксперимент-фридмана)
22. [**Отбор признаков с учётом эффекта множественной проверки гипотез**](#отбор-признаков-с-учётом-эффекта-множественной-проверки-гипотез)
23. [**Значимость категориальных предикторов**](#значимость-категориальных-предикторов)
24. [**Проверка предположений Гаусса-Маркова**](#проверка-предположений-гаусса-маркова)
25. [**Визуальный анализ**](#визуальный-анализ)
26. [**Формальные критерии**](#формальные-критерии)
27. [**Критерий Бройша-Пагана**](#критерий-бройша-пагана)
28. [**Гетероскедастичность**](#гетероскедастичность)
29. [**Преобразование Бокса-Кокса**](#преобразование-бокса-кокса)
30. [**Метод Бокса-Кокса**](#метод-бокса-кокса)
31. [**Другие устойчивые оценки дисперсии**](#другие-устойчивые-оценки-дисперсии)
32. [**Расстояние Кука**](#расстояние-кука)

----
### [Вернуться ко всем лекциям](Navigation_lections.md)
----

## Первое появление

Впервые такая постановка появляется в работе Гальтона 1885 г. «Регрессия к середине в наследственности роста».

![](https://cdn.mathpix.com/cropped/2024_04_20_8fcc09bfa7b0b3408dacg-02.jpg?height=510&width=621&top_left_y=205&top_left_x=475)

$y-\bar{y} \approx \frac{2}{3}(x-\bar{x})$.

## Другие работы Гальтона

![](https://cdn.mathpix.com/cropped/2024_04_20_8fcc09bfa7b0b3408dacg-03.jpg?height=800&width=1204&top_left_y=60&top_left_x=192)

## Постановка задачи линейной регрессии

$1, \ldots, n-$ объекты;

$x_{1}, \ldots, x_{k}, y$ - признаки, значения которых измеряются на объектах;

$x_{1}, \ldots, x_{k}$ - объясняющие переменные (предикторы, регрессоры, факторы, признаки);

$y$ - зависимая переменная, отклик.

Хотим найти такую функцию $f$, что $y \approx f\left(x_{1}, \ldots, x_{k}\right)$;

$$
\underset{f}{\operatorname{argmin}} \mathbb{E}\left(y-f\left(x_{1}, \ldots, x_{k}\right)\right)^{2}=\mathbb{E}\left(y \mid x_{1}, \ldots, x_{k}\right)
$$

$\mathbb{E}\left(y \mid x_{1}, \ldots, x_{k}\right)=f\left(x_{1}, \ldots, x_{k}\right)$ - модель регрессии;

$\mathbb{E}\left(y \mid x_{1}, \ldots, x_{k}\right)=\beta_{0}+\sum_{j=1}^{k} \beta_{j} x_{j}-$ модель линейной регрессии.

Здесь и далее $n>k(n \gg k)$.

## Метод наименьших квадратов (MHK)

Матричные обозначения:

$$
X=\left(\begin{array}{cccc}
x_{10}=1 & x_{11} & \ldots & x_{1 k} \\
\vdots & \vdots & \ddots & \vdots \\
x_{n 0}=1 & x_{n 1} & \ldots & x_{n k}
\end{array}\right) ; \quad y=\left(\begin{array}{c}
y_{1} \\
\vdots \\
y_{n}
\end{array}\right) ; \quad \beta=\left(\begin{array}{c}
\beta_{0} \\
\beta_{1} \\
\vdots \\
\beta_{k}
\end{array}\right)
$$

Метод наименьших квадратов:

$$
\begin{aligned}
& \sum_{i=1}^{n}\left(y_{i}-\sum_{j=0}^{k} \beta_{j} x_{i j}\right)^{2} \rightarrow \min _{\beta} \\
& \|y-X \beta\|_{2}^{2} \rightarrow \min _{\beta} \\
& 2 X^{T}(y-X \beta)=0 \\
& \hat{\beta}=\left(X^{T} X\right)^{-1} X^{T} y \\
& \hat{y}=X\left(X^{T} X\right)^{-1} X^{T} y
\end{aligned}
$$

MHK в линейной регрессии даёт выборочную оценку линейной аппроксимации условного матожидания $\mathbb{E}(y \mid x)$

Кроме $\|\cdot\|_{2}^{2}$ это делает любая дивергенция Брегмана:

$$
D(y, X \beta)=\sum_{i=1}^{n}\left(\phi\left(y_{i}\right)-\phi\left(x_{i} \beta\right)-\phi^{\prime}\left(x_{i} \beta\right)\left(y_{i}-x_{i} \beta\right)\right)
$$

где $\phi$ - произвольная непрерывно дифференцируемая выпуклая функция.
![](https://cdn.mathpix.com/cropped/2024_04_20_8fcc09bfa7b0b3408dacg-06.jpg?height=364&width=1058&top_left_y=433&top_left_x=256)

## Инверсия задачи регрессии

**Avenhaus et al.**

Требуется оценить распределение доходов семей, живущих в одном городском квартале по открытым данным.

Доход семьи - закрытый показатель, достать который достаточно трудно, согласились огласить доход лишь несколько семей.

Известно, что доход сильно коррелирует со стоимостью недвижимости $\rightarrow$ можем построить регрессию и предсказывать независимую переменную по зависимой.


![](https://cdn.mathpix.com/cropped/2024_04_20_8fcc09bfa7b0b3408dacg-08.jpg?height=606&width=621&top_left_y=143&top_left_x=475)


![](https://cdn.mathpix.com/cropped/2024_04_20_8fcc09bfa7b0b3408dacg-09.jpg?height=606&width=621&top_left_y=143&top_left_x=477)


![](https://cdn.mathpix.com/cropped/2024_04_20_8fcc09bfa7b0b3408dacg-10.jpg?height=607&width=623&top_left_y=142&top_left_x=474)



![](https://cdn.mathpix.com/cropped/2024_04_20_f52b0217b88e37d9f271g-11.jpg?height=606&width=619&top_left_y=143&top_left_x=476)


![](https://cdn.mathpix.com/cropped/2024_04_20_f52b0217b88e37d9f271g-12.jpg?height=231&width=245&top_left_y=142&top_left_x=669)

- Две прямые пересекаются в точке $(\bar{x}, \bar{y})$.
- Выборочный коэффициент корреляции между $x$ и $y$ - среднее геометрическое $\hat{\theta}_{1}$ и $\hat{\phi}_{1}$ :

$$
\begin{gathered}
\hat{\theta}_{1}=\frac{n \sum x y-\sum x \sum y}{n \sum x^{2}-\left(\sum x\right)^{2}}, \quad \hat{\phi}_{1}=\frac{n \sum x y-\sum x \sum y}{n \sum y^{2}-\left(\sum y\right)^{2}} \\
\hat{r}_{x y}=\frac{n \sum x y-\sum x \sum y}{\sqrt{\left(n \sum x^{2}-\left(\sum x\right)^{2}\right)\left(n \sum y^{2}-\left(\sum y\right)^{2}\right)}}
\end{gathered}
$$

## Goodness-of-fit

$$
\begin{aligned}
& T S S=\sum_{i=1}^{n}\left(y_{i}-\bar{y}\right)^{2} \quad(\text { Total Sum of Squares }) \\
& E S S=\sum_{i=1}^{n}\left(\hat{y}_{i}-\bar{y}\right)^{2} \quad(\text { Explained Sum of Squares }) \\
& \left.R S S=\sum_{i=1}^{n}\left(y_{i}-\hat{y}_{i}\right)^{2} \quad \text { (Residual Sum of Squares }\right) \\
& T S S=E S S+R S S
\end{aligned}
$$

Коэффициент детерминации:

$$
R^{2}=\frac{E S S}{T S S}=1-\frac{R S S}{T S S}
$$

$R^{2}=r_{y \hat{y}}^{2}-$ квадрат коэффициента множественной корреляции $y$ с $X$.

## Приведённый коэффициент детерминации

Стандартный коэффициент детерминации всегда увеличивается при добавлении регрессоров в модель, поэтому для отбора признаков его использовать нельзя.

Для сравнения моделей, содержащих разное число признаков, можно использовать приведённый коэффициент детерминации:

$$
R_{a}^{2}=\frac{E S S /(n-k-1)}{T S S /(n-1)}=1-\left(1-R^{2}\right) \frac{n-1}{n-k-1}
$$

## Предположения модели

(1) Линейность отклика: $y=X \beta+\varepsilon$.

(2) Случайность выборки: наблюдения $\left(x_{i}, y_{i}\right), i=1, \ldots, n$ независимы.

(3) Полнота ранга: ни один из признаков не является константой или линейной комбинацией других признаков ни в популяции, ни в выборке ( $\operatorname{rank} X=k+1)$.

(4) Случайность ошибок: $\mathbb{E}(\varepsilon \mid X)=0$.

В предположениях (1-4) MHK-оценки коэффициентов $\beta$ являются несмещёнными:

$$
\mathbb{E} \hat{\beta}_{j}=\beta_{j}, j=0, \ldots, k
$$

и состоятельными:

$$
\forall \gamma>0 \quad \lim _{n \rightarrow \infty} P\left(\left|\beta_{j}-\hat{\beta}_{j}\right|<\gamma\right)=1, j=0, \ldots, k
$$

(1) Линейность отклика: $y=X \beta+\varepsilon$.

(2) Случайность выборки: наблюдения $\left(x_{i}, y_{i}\right), i=1, \ldots, n$ независимы.

(3) Полнота ранга: ни один из признаков не является константой или линейной комбинацией других признаков ни в популяции, ни в выборке ( $\operatorname{rank} X=k+1)$.

(4) Случайность ошибок: $\mathbb{E}(\varepsilon \mid X)=0$.

(5) Гомоскедастичность ошибок: дисперсия ошибки не зависит от значений признаков: $\mathbb{D}(\varepsilon \mid X)=\sigma^{2}$. (предположения Гаусса-Маркова).

Теорема Гаусса-Маркова: в предположениях (1-5) MHK-оценки имеют наименьшую дисперсию в классе оценок $\beta$, линейных по $y$.

## Неправильное определение модели

Недоопределение: если зависимая переменная определяется моделью

$$
y=\beta_{0}+\beta_{1} x_{1}+\cdots+\beta_{j-1} x_{j-1}+\beta_{j} x_{j}+\beta_{j+1} x_{j+1}+\cdots+\beta_{k} x_{k}+\varepsilon
$$

а вместо этого используется модель

$$
y=\beta_{0}+\beta_{1} x_{1}+\cdots+\beta_{j-1} x_{j-1}+\beta_{j+1} x_{j+1}+\cdots+\beta_{k} x_{k}+\varepsilon
$$

то MHK-оценки $\hat{\beta}_{0}, \ldots, \hat{\beta}_{j-1}, \hat{\beta}_{j+1}, \ldots, \hat{\beta}_{k}$ являются смещёнными и несостоятельными оценками $\beta_{0}, \ldots, \beta_{j-1}, \beta_{j+1}, \ldots, \beta_{k}$.

Переопределение: если признак $x_{j}$ не влияет на $y$, т. е. $\beta_{j}=0$, то MHK-оценка $\hat{\beta}$ остаётся несмещённой состоятельной оценкой $\beta$, но дисперсия её возрастает.

## Дисперсия $\hat{\beta}_{j}$

В предположениях (1-5) дисперсии MHK-оценок коэффициентов $\beta$ задаются следующим образом:

$$
\mathbb{D}\left(\hat{\beta}_{j} \mid X\right)=\frac{\sigma^{2}}{T S S_{j}\left(1-R_{j}^{2}\right)}
$$

где $T S S_{j}=\sum_{i=1}^{n}\left(x_{i j}-\bar{x}_{j}\right)^{2}, R_{j}^{2}$ - коэффициент детерминации при регрессии $x_{j}$ на все остальные признаки из $X$.

- Чем больше дисперсия ошибки $\sigma^{2}$, тем больше дисперсия оценки $\hat{\beta}_{j}$.
- Чем больше вариация значений признака $x_{j}$ в выборке, тем меньше дисперсия оценки $\hat{\beta}_{j}$.
- Чем лучше признак $x_{j}$ объясняется линейной комбинацией оставшихся признаков, тем больше дисперсия оценки $\hat{\beta}_{j}$.

$R_{j}^{2}<1$ по предположению (3); тем не менее, может быть $R_{j}^{2} \approx 1$.

В матричном виде:

$$
\mathbb{D}(\hat{\beta} \mid X)=\sigma^{2}\left(X^{T} X\right)^{-1}
$$

Если столбцы $X$ почти линейно зависимы, то матрица $X^{T} X$ плохо обусловлена, и дисперсия оценок $\hat{\beta}_{j}$ велика.

Близкая к линейной зависимость между двумя или более признаками $x_{j}$ называется мультиколлинеарностью.

Проблема мультиколлинеарности решается с помощью отбора признаков или использования регуляризаторов.

## Бинарные признаки

Если $x_{j}$ принимает только два значения, то они кодируются нулём и единицей. Например, если $x_{j}$ - пол испытуемого, то можно задать $x_{j}=$ [пол $=$ мужской] .

Механизм построения регрессии не меняется.


## Категориальные признаки

Как кодировать дискретные признаки $x_{j}$, принимающие более двух значений?

Пусть $y$ - средний уровень заработной платы, $x$ - тип должности (рабочий / инженер / управляющий).

Допустим, мы закодировали эти должности следующим образом:

| Тип должности | $x$ |
| :--- | :--- |
| рабочий | 1 |
| инженер | 2 |
| управляющий | 3 |

и построили регрессию $y=\beta_{0}+\beta_{1} x$. Тогда для рабочего, инженера и управляющего ожидаемые средние уровни заработной платы определяются следующим образом:

$$
\begin{aligned}
y_{b c} & =\beta_{0}+\beta_{1} \\
y_{p r} & =\beta_{0}+2 \beta_{1} \\
y_{w c} & =\beta_{0}+3 \beta_{1}
\end{aligned}
$$

Согласно построенной модели, разница в средних уровнях заработной платы рабочего и инженера в точности равна разнице между зарплатами инженера и управляющего.

## Фиктивные переменные

Верный способ использования категориальных признаков в регрессии - введение бинарных фиктивных переменных (dummy variables).

Пусть признак $x_{j}$ принимает $m$ различных значений, тогда для его кодирования необходима $m-1$ фиктивная переменная.

Способы кодирования:

|  | Dummy |  | Deviation |  |
| :--- | :---: | :---: | :---: | :---: |
| Тип должности | $x_{1}$ | $x_{2}$ | $x_{1}$ | $x_{2}$ |
| рабочий | 0 | 0 | 1 | 0 |
| инженер | 1 | 0 | 0 | 1 |
| управляющий | 0 | 1 | -1 | -1 |

$$
y=\beta_{0}+\beta_{1} x_{1}+\beta_{2} x_{2}
$$

- При dummу-кодировании коэффициенты $\beta_{1}, \beta_{2}$ оценивают среднюю разницу в уровнях зарплат инженера и управляющего с рабочим.
- При deviation-кодировании коэффициенты $\beta_{1}, \beta_{2}$ оценивают среднюю разницу в уровнях зарплат рабочего и инженера со средним по всем должностям.

## Вопросы

(1) Как найти доверительные интервалы для $\beta_{j}$ и проверить гипотезу $H_{0}: \beta_{j}=0$ ?

(2) Как найти доверительный интервал для значений отклика на новом объекте $y\left(x_{0}\right)$ ?

(3) Как проверить адекватность построенной модели?

## Предположение о нормальности ошибок

(6) Нормальность ошибок: $\varepsilon \mid X \sim N\left(0, \sigma^{2}\right)$.

Эквивалентная запись: $y \mid X \sim N\left(X \beta, \sigma^{2}\right)$.

- В предположениях (1-6) MHK-оценки совпадают с оценками максимального правдоподобия. ММП:

$$
\begin{aligned}
& p\left(\varepsilon_{i}\right)=\frac{1}{\sqrt{2 \pi} \sigma} e^{-\frac{1}{2 \sigma} \varepsilon_{i}^{2}} \\
& \ln \prod_{i=1}^{n} p\left(\varepsilon_{i}\right) \rightarrow \max _{\beta} \\
& \sum_{i=1}^{n}\left(-\frac{1}{2} \ln (2 \pi \sigma)-\frac{1}{2 \sigma} \varepsilon_{i}^{2}\right) \rightarrow \max _{\beta} \\
& \sum_{i=1}^{n} \varepsilon_{i}^{2}=\sum_{i=1}^{n}\left(y_{i}-\sum_{j=0}^{k} \beta_{j} x_{i j}\right)^{2} \rightarrow \min _{\beta}
\end{aligned}
$$

- MHK-оценки $\hat{\beta}$ имеют наименьшую дисперсию среди всех несмещённых оценок $\beta$.
- MHK-оценки $\hat{\beta}$ имеют нормальное распределение $N\left(\beta, \sigma^{2}\left(X^{T} X\right)^{-1}\right)$.
- Несмещённой оценкой $\sigma^{2}$ является

$$
\hat{\sigma}^{2}=\frac{1}{n-k-1} R S S
$$

кроме того, $\frac{1}{\sigma^{2}} R S S \sim \chi_{n-k-1}^{2}$.

- $\forall c \in \mathbb{R}^{k+1}$

$$
\frac{c^{T}(\beta-\hat{\beta})}{\hat{\sigma} \sqrt{c^{T}\left(X^{T} X\right)^{-1} c}} \sim S t(n-k-1)
$$

## Доверительные и предсказательные интервалы

$100(1-\alpha) \%$ доверительный интервал для $\sigma$ :

$$
\sqrt{\frac{R S S}{\chi_{n-k-1,1-\alpha / 2}^{2}}} \leqslant \sigma \leqslant \sqrt{\frac{R S S}{\chi_{n-k-1, \alpha / 2}^{2}}}
$$

Возьмём $c=(0 \ldots 010 \ldots 0) ; \quad 100(1-\alpha) \%$ доверительный интервал для $\beta_{j}$ :

$$
\hat{\beta}_{j} \pm t_{n-k-1,1-\alpha / 2} \hat{\sigma} \sqrt{\left(X^{T} X\right)_{j j}^{-1}}
$$

Для нового объекта $x_{0}$ возьмём $c=x_{0} ; \quad 100(1-\alpha) \%$ доверительный интервал для $\mathbb{E}\left(y \mid x=x_{0}\right)=x_{0}^{T} \beta$ :

$$
x_{0}^{T} \hat{\beta} \pm t_{n-k-1,1-\alpha / 2} \hat{\sigma} \sqrt{x_{0}^{T}\left(X^{T} X\right)^{-1} x_{0}}
$$

Чтобы построить предсказательный интервал для $y\left(x_{0}\right)=x_{0}^{T} \beta+\varepsilon\left(x_{0}\right)$, учтём ещё дисперсию ошибки:

$$
x_{0}^{T} \hat{\beta} \pm t_{n-k-1,1-\alpha / 2} \hat{\sigma} \sqrt{1+x_{0}^{T}\left(X^{T} X\right)^{-1} x_{0}}
$$

## t-критерий Стьюдента

$$
\begin{aligned}
\text { нулевая гипотеза: } & H_{0}: \beta_{j}=0 \\
\text { альтернатива: } & H_{1}: \beta_{j}<\neq>0 \\
\text { статистика: } & T=\frac{\hat{\beta}_{j}}{\sqrt{\frac{R S S}{n-k-1}\left(X^{T} X\right)_{j j}^{-1}}} \\
\text { нулевое распределение: } & S t(n-k-1)
\end{aligned}
$$

![](https://cdn.mathpix.com/cropped/2024_04_20_f803fcdfa3ef9d9edf1bg-27.jpg?height=349&width=1065&top_left_y=368&top_left_x=253)

**Пример:** имеется 12 испытуемых, $x$ - результат прохождения испытуемым составного теста скорости реакции, $y$ - результат его теста на симулятора транспортного средства. Проведение составного теста значительно проще и требует меньших затрат, поэтому ставится задача предсказания $y$ по $x$, для чего строится линейная регрессия согласно модели
$$
y=\beta_{0}+\beta_{1} x+\varepsilon
$$

Значима ли переменная $x$ для предсказания $y$ ?

$H_{0}: \beta_{1}=0$.

$H_{1}: \beta_{1} \neq 0 \Rightarrow p=2.2021 \times 10^{-5}$.

$$
\begin{aligned}
\text { нулевая гипотеза: } & H_{0}: \beta_{j}=a \\
\text { альтернатива: } & H_{1}: \beta_{j}<\neq>a \\
\text { статистика: } & T=\frac{\hat{\beta}_{j}-a}{\sqrt{\frac{R S S}{n-k-1}\left(X^{T} X\right)_{j j}^{-1}}} \\
\text { нулевое распределение: } & S t(n-k-1)
\end{aligned}
$$

![](https://cdn.mathpix.com/cropped/2024_04_20_f803fcdfa3ef9d9edf1bg-29.jpg?height=351&width=1065&top_left_y=367&top_left_x=253)

Пример: по выборке из 506 жилых районов, расположенных в пригородах Бостона, строится модель средней цены на жильё следующего вида:

$$
\ln \text { price }=\beta_{0}+\beta_{1} \ln n o x+\beta_{2} \ln \text { dist }+\beta_{3} \text { rooms }+\beta_{4} \text { stratio }+\varepsilon
$$

где $n o x$ - содержание в воздухе двуокиси азота, dis - взвешенное среднее расстояние от жилого района до пяти основных мест трудоустройства, rooms - среднее число комнат в доме жилого района, stratio среднее отношения числа студентов к числу учителей в школах района.

Коэффициент $\beta_{1}$ имеет смысл эластичности цены по признаку пох. По экономическим соображениям интерес представляет гипотеза о том, что эластичность равна -1 .

$H_{0}: \beta_{1}=-1$.

$H_{1}: \beta_{1} \neq-1 \Rightarrow p=0.6945$.

## Критерий Фишера

$$
\underset{n \times(k+1)}{X}=\left(\begin{array}{cc}
X_{1} & , \underset{2}{X_{2}} \\
n \times\left(k+1-k_{1}\right)
\end{array}\right) ; \quad \underset{n \times k_{1}}{\beta^{T}}=\left(\begin{array}{cc}
\beta_{1}^{T} & , \beta_{2}^{T} \\
(k+1) \times 1
\end{array}\right)^{T}
$$

нулевая гипотеза: $H_{0}: \beta_{2}=0$

альтернатива: $H_{1}: H_{0}$ неверна

статистика: $\quad R S S_{r}=\left\|y-X_{1} \beta_{1}\right\|_{2}^{2}, \quad R S S_{u r}=\|y-X \beta\|_{2}^{2}$,

$$
F=\frac{\left(R S S_{r}-R S S_{u r}\right) / k_{1}}{R S S_{u r} /(n-k-1)}
$$

нулевое распределение: $\quad F\left(k_{1}, n-k-1\right)$

![](https://cdn.mathpix.com/cropped/2024_04_20_41f5c3a6463f8960817dg-31.jpg?height=350&width=1061&top_left_y=464&top_left_x=257)

Пример: для веса ребёнка при рождении имеется следующая модель:

$$
\text { weight }=\beta_{0}+\beta_{1} \text { cigs }+\beta_{2} \text { parity }+\beta_{3} i n c+\beta_{4} m e d+\beta_{5} f e d+\varepsilon
$$

где cigs - среднее число сигарет, выкуривавшихся матерью за один день беременности, parity - номер ребёнка у матери, inc - среднемесячный доход семьи, $m e d$ - длительность в годах получения образования матерью, fed - отцом. Данные имеются для 1191 детей.

Зависит ли вес ребёнка при рождении от уровня образования родителей?

$H_{0}: \beta_{4}=\beta_{5}=0$.

$H_{1}: H_{0}$ неверна $\Rightarrow p=0.2421$.

## Связь между критериями Фишера и Стьюдента

Если $k_{1}=1$, критерий Фишера эквивалентен критерию Стьюдента для двусторонней альтернативы.

Иногда критерий Фишера отвергает гипотезу о незначимости признаков $X_{2}$, а критерий Стьюдента не признаёт значимым ни один из них. Возможные объяснения:

- отдельные признаки из $X_{2}$ недостаточно хорошо объясняют $y$, но совокупный эффект значим;
- признаки в $X_{2}$ мультиколлинеарны.

Иногда критерия Фишера не отвергает гипотезу о незначимости признаков $X_{2}$, а критерий Стьюдента признаёт значимыми некоторые из них. Возможные объяснения:

- незначимые признаки в $X_{2}$ маскируют влияние значимых;
- значимость отдельных признаков в $X_{2}$ - результат множественной проверки гипотез.



нулевая гипотеза: $H_{0}: \beta_{1}=\cdots=\beta_{k}=0$

альтернатива: $H_{1}: H_{0}$ неверна

статистика: $\quad F=\frac{R^{2} / k}{\left(1-R^{2}\right) /(n-k-1)}$

нулевое распределение: $\quad F(k, n-k-1)$

![](https://cdn.mathpix.com/cropped/2024_04_20_41f5c3a6463f8960817dg-34.jpg?height=351&width=1063&top_left_y=351&top_left_x=256)

Пример: имеет ли вообще смысл модель веса ребёнка при рождении, рассмотренная выше?

$H_{0}: \beta_{1}=\cdots=\beta_{5}=0$.

$H_{1}: H_{0}$ неверна $\Rightarrow p=6.0331 \times 10^{-9}$.

## Сравнение невложенных моделей

Пример: имеются две модели:

$$
\begin{aligned}
& y=\beta_{0}+\beta_{1} x_{1}+\beta_{2} x_{2}+\varepsilon \\
& y=\gamma_{0}+\gamma_{1} \log x_{1}+\gamma_{2} \log x_{2}+\varepsilon
\end{aligned}
$$

Как понять, какая из них лучше?

## Критерий Давидсона-Маккиннона

Пусть $\hat{y}$ - оценка отклика по первой модели, $\hat{\hat{y}}$ - по второй.

Подставим эти оценки как признаки в чужие модели:

$$
\begin{aligned}
& y=\beta_{0}+\beta_{1} x_{1}+\beta_{2} x_{2}+\beta_{3} \hat{\hat{y}}+\varepsilon \\
& y=\gamma_{0}+\gamma_{1} \log x_{1}+\gamma_{2} \log x_{2}+\gamma_{3} \hat{y}+\varepsilon
\end{aligned}
$$

При помощи критерия Стьюдента проверим

$$
\begin{aligned}
& H_{01}: \beta_{3}=0, \quad H_{11}: \beta_{3} \neq 0 \\
& H_{02}: \gamma_{3}=0, \quad H_{12}: \gamma_{3} \neq 0
\end{aligned}
$$

| $H_{01}$ \ $H_{02}$ | Принята | Отвергнута |
| :---: | :--- | :--- |
| Принята | Обе модели хороши | Модель (1) значимо <br> лучше |
| Отвергнута | Модель (2) значимо <br> лучше | Обе модели плохи |

## Пошаговая регрессия

- Шаг 0. Настраивается модель с одной только константой, а также все модели с одной переменной. Рассчитывается $F$-статистика каждой модели и достигаемый уровень значимости. Выбирается модель с наименьшим достигаемым уровнем значимости. Соответствующая переменная $X_{e 1}$ включается в модель, если этот достигаемый уровень значимости меньше порогового значения $p_{E}=0.05$.
- Шаг 1. Рассчитывается $F$-статистика и достигаемый уровень значимости для всех моделей, содержащих две переменные, одна из которых $X_{e 1}$. Аналогично принимается решение о включении $X_{e 2}$.
- Шаг 2. Если была добавлена переменная $X_{e 2}$, возможно, $X_{e 1}$ уже не нужна. В общем случае просчитываются все возможные варианты исключения одной переменной, рассматривается вариант с наибольшим достигаемым уровнем значимости, соответствующая переменная исключается, если он превосходит пороговое значение $p_{R}=0.1$.
- ...

## Эксперимент Фридмана

Сгенерируем полноранговую матрицу $\mathbf{X}$ размера $n \times m$ и вектор $\mathbf{y}$.

При $n \rightarrow \infty, \frac{n}{m} \rightarrow \rho: R^{2} \rightarrow \rho$.

(Freedman, 1983): пошаговая регрессия несовместима с проверкой гипотез о значимости коэффициентов: критерии Фишера и Стьюдента антиконсервативны, если вычисляются на той же самой выборке, на которой настраивалась модель.

## Отбор признаков с учётом эффекта множественной проверки гипотез

$\forall c_{1}, \ldots, c_{k_{1}} \in \mathbb{R}^{k+1}$

$$
t_{j}=\frac{c_{j}^{T}(\beta-\hat{\beta})}{\hat{\sigma} \sqrt{c_{j}^{T}\left(X^{T} X\right)^{-1} c_{j}}}, j=1, \ldots, k_{1}
$$

имеют совместное распределение Стьюдента с числом степеней свободы $n-k-1$ и корреляционной матрицей

$$
\begin{aligned}
& R=D C^{T}\left(X^{T} X\right)^{-1} C D \\
& C=\left(c_{1}, \ldots, c_{k_{1}}\right) \\
& D=\operatorname{diag}\left(c_{j}^{T}\left(X^{T} X\right)^{-1} c_{j}\right)^{-\frac{1}{2}}
\end{aligned}
$$

Для одновременной проверки значимости всех коэффициентов регрессии достаточно взять в качестве $C$ единичную матрицу.


## Значимость категориальных предикторов

Категориальный предиктор, кодируемый несколькими фиктивными переменными, необходимо включать или исключать целиком. Значимость соответствующих фиктивных переменных лучше проверять в совокупности.

В случае, когда по отдельности какие-то фиктивные переменные не значимы, допустимо объединять уровни категориального предиктора, основываясь на интерпретации.

## Проверка предположений Гаусса-Маркова

(1) Линейность отклика: $y=X \beta+\varepsilon$.

(2) Случайность выборки: наблюдения ( $\left.x_{i}, y_{i}\right), i=1, \ldots, n$ независимы.

- Предположения (1-2) проверить нельзя.

(3) Полнота ранга: ни один из признаков не является константой или линейной комбинацией других признаков ни в популяции, ни в выборке ( $\operatorname{rank} X=k+1)$.

- Предположение (3) легко проверяется, без его выполнения построить модель вообще невозможно.

(4) Случайность ошибок: $\mathbb{E}(\varepsilon \mid X)=0$.

(5) Гомоскедастичность ошибок: дисперсия ошибки не зависит от значений признаков: $\mathbb{D}(\varepsilon \mid X)=\sigma^{2}$.

(6) Нормальность ошибок: $\varepsilon \mid X \sim N\left(0, \sigma^{2}\right)$.

- Предположения (4-6) об ошибке $\varepsilon$ необходимо проверять.

Оценивать ошибку $\varepsilon$ будем при помощи остатков:

$$
\hat{\varepsilon}_{i}=y_{i}-\hat{y}_{i}, i=1, \ldots, n
$$

Стандартизированные остатки:

$$
\tilde{\varepsilon}_{i}=\frac{\hat{\varepsilon}_{i}}{\hat{\sigma}}, i=1, \ldots, n
$$

## Визуальный анализ

Строятся графики зависимости $\tilde{\varepsilon}_{i}$ от $\hat{y}_{i}, x_{i j}, j=1, \ldots, k, \quad i$.

![](https://cdn.mathpix.com/cropped/2024_04_20_5107fd7586ac00c2f9ccg-43.jpg?height=615&width=1093&top_left_y=175&top_left_x=225)

![](https://cdn.mathpix.com/cropped/2024_04_20_5107fd7586ac00c2f9ccg-44.jpg?height=606&width=1085&top_left_y=117&top_left_x=235)

Возможно, присутствуют выбросы

![](https://cdn.mathpix.com/cropped/2024_04_20_5107fd7586ac00c2f9ccg-45.jpg?height=609&width=1085&top_left_y=109&top_left_x=235)

В данных имеется тренд

![](https://cdn.mathpix.com/cropped/2024_04_20_5107fd7586ac00c2f9ccg-46.jpg?height=610&width=1093&top_left_y=113&top_left_x=225)

Гетероскедастичность


![](https://cdn.mathpix.com/cropped/2024_04_20_5107fd7586ac00c2f9ccg-47.jpg?height=611&width=1095&top_left_y=110&top_left_x=224)

Стоит добавить квадрат признака $x_{j}$

## Формальные критерии

- Проверка нормальности - занятие 2.
- Проверка несмещённости: если остатки нормальны - критерий Стьюдента (занятие 2), нет непараметрический критерий (занятие 3).
- Проверка гомоскедастичности: критерий Бройша-Пагана.


## Критерий Бройша-Пагана

нулевая гипотеза: $\quad H_{0}: \mathbb{D} \varepsilon_{i}=\sigma^{2}$

альтернатива: $H_{1}: H_{0}$ неверна

статистика: $\quad L M=n R_{\hat{\varepsilon}^{2}}^{2}, R_{\hat{\varepsilon}^{2}}^{2}$ - коэффициент детерминации при регрессии квадратов остатков на признаки

нулевое распределение: $\chi_{k}^{2}$

![](https://cdn.mathpix.com/cropped/2024_04_20_5107fd7586ac00c2f9ccg-49.jpg?height=353&width=1069&top_left_y=364&top_left_x=251)

## Гетероскедастичность

Гетероскедастичность может быть следствием недоопределения модели.

Последствия гетероскедастичности:

- MНK-оценки $\beta$ и $R^{2}$ остаются несмещёнными и состоятельными
- нарушаются предположения критериев Стьюдента и Фишера и методов построения доверительных интервалов для $\sigma$ и $\beta$ (независимо от объёма выборки)

Варианты:

- переопределить модель, добавить признаки, преобразовать отклик
- использовать модифицированные оценки дисперсии коэффициентов

## Преобразование Бокса-Кокса

Пусть значения отклика $y_{1}, \ldots, y_{n}$ положительны. Если $\frac{\max y_{i}}{\min y_{i}}>10$, стоит рассмотреть возможность преобразования $y$. В каком виде его искать?

Часто полезно рассмотреть преобразования вида $y^{\lambda}$, но оно не имеет смысла при $\lambda=0$.

Вместо него можно рассмотреть семейство преобразований

$$
W= \begin{cases}\left(y^{\lambda}-1\right) / \lambda, & \lambda \neq 0 \\ \ln y, & \lambda=0\end{cases}
$$

но оно сильно варьируется по $\lambda$.

Вместо него можно рассмотреть семейство преобразований

$$
V= \begin{cases}\left(y^{\lambda}-1\right) /\left(\lambda \dot{y}^{\lambda-1}\right), & \lambda \neq 0 \\ \dot{y} \ln y, & \lambda=0\end{cases}
$$

где $\dot{y}=\left(y_{1} y_{2} \ldots y_{n}\right)^{1 / n}$ - среднее геометрическое наблюдений отклика.

## Метод Бокса-Кокса

Процесс подбора $\lambda:$

(1) выбирается набор значений $\lambda$ в некотором интервале, например, $(-2,2)$;

(2) для каждого значения $\lambda$ выполняется преобразование отклика $V$ или $W$, строится регрессия $V$ на $X$, вычисляется остаточная приведенная сумма квадратов:

- для преобразования $W$ :

$$
R S S(\lambda)+\log |\boldsymbol{J}|, \quad|\boldsymbol{J}|=\prod_{i} y_{i}^{\lambda-1}
$$

- для преобразования $V$ : обычный $R S S$.

(3) строится график зависимости приведенной суммы от $\lambda$, по нему выбирается оптимальное значение $\lambda$;

(4) выбирается ближайшее к оптимальному удобное значение $\lambda$ (например, целое или полуцелое);

(5) строится окончательная регрессионная модель с откликом $y^{\lambda}$ или $\ln y$.

Доверительный интервал для $\lambda$ определяется как пересечение кривой $R S S(\lambda)$ с линией уровня $\min _{\lambda} R S S(\lambda) \cdot e^{\chi_{1,1-\alpha}^{2} / n}$. Если он содержит единицу, возможно, не стоит выполнять преобразование.

## Устойчивая оценка дисперсии Уайта

Если не удаётся избавиться от гетероскедастичности, при анализе моделей (дальше) можно использовать устойчивые оценки дисперсии.

White's heteroscedasticity-consistent estimator (HCE):

$$
\mathbb{D}(\hat{\beta} \mid X)=\left(X^{T} X\right)^{-1}\left(X^{T} \operatorname{diag}\left(\hat{\varepsilon}_{1}^{2}, \ldots, \hat{\varepsilon}_{n}^{2}\right) X\right)\left(X^{T} X\right)^{-1}
$$

Асимптотика устойчивой оценки:

$$
\begin{gathered}
\sqrt{n}(\beta-\hat{\beta}) \xrightarrow{d} N(0, \Omega) \\
\hat{\Omega}=n\left(X^{T} X\right)^{-1}\left(X^{T} \operatorname{diag}\left(\hat{\varepsilon}_{1}^{2}, \ldots, \hat{\varepsilon}_{n}^{2}\right) X\right)\left(X^{T} X\right)^{-1}
\end{gathered}
$$

## Другие устойчивые оценки дисперсии

Элементы диагональной матрицы могут задаваться разными способами:

![](https://cdn.mathpix.com/cropped/2024_04_20_a701a68ebd6273a5c057g-54.jpg?height=323&width=355&top_left_y=224&top_left_x=606)

const - случай гомоскедастичной ошибки,

НСО - оценка Уайта,

НС1-НС3 - модификации МакКиннона-Уайта,

НС4 - модификация Крибари-Нето.

## Расстояние Кука

Регрессия сильно подстраивается под далеко стоящие наблюдения.
![](https://cdn.mathpix.com/cropped/2024_04_20_a701a68ebd6273a5c057g-55.jpg?height=694&width=682&top_left_y=124&top_left_x=444)

Расстояние Кука - мера воздействия $i$-го наблюдения на регрессионное уравнение:

$$
D_{i}=\frac{\sum_{j=1}^{n}\left(\hat{y}_{j}-\hat{y}_{j(i)}\right)^{2}}{R S S(k+1)}=\frac{\hat{\varepsilon}_{i}^{2}}{R S S(k+1)} \frac{h_{i}}{\left(1-h_{i}\right)^{2}}
$$

$\hat{y}_{j(i)}$ - предсказания модели, настроенной по наблюдениям $1, \ldots, i-1, i+1, \ldots, n$, для наблюдения $j$;

$h_{i}$ - диагональный элемент матрицы $H=X\left(X^{T} X\right)^{-1} X^{T}$ (hat matrix).

Варианты порога на $D_{i}$ :

- $D_{i}=1 ;$
- $D_{i}=4 / n$;
- $D_{i}=3 \bar{D}$;
- визуально по графику зависимости $D_{i}$ от $\hat{y}_{i}$.






