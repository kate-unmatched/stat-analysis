
/*
 * Как Java-разработчик я часто участвую в релизах приложений. В целях обеспечения 
 * качества обычно я проверяю, отличается ли среднее время отклика новой версии приложения 
 * от старой версии. Допустим, что в среднем, время отклика старой версии приложения составляет 250 мс. 
 * Для новой версии я собираю данные о времени отклика за последние 100 запросов.
 */

 import java.util.Random;

 public class ZTestWithSamples {
     public static void main(String[] args) {
         // Данные для старой версии приложения
         double populationMean = 250; // Среднее время отклика старой версии
 
         // Создание выборки данных для новой версии приложения
         double[] sampleData = generateSampleData(100, 240, 30);
 
         // Вычисление среднего и стандартного отклонения выборки
         double sampleMean = calculateMean(sampleData);
         double sampleStandardDeviation = calculateStandardDeviation(sampleData, sampleMean);
 
         // Размер выборки
         int sampleSize = sampleData.length;
 
         // Вычисление Z-статистики
         double zScore = calculateZScore(sampleMean, populationMean, sampleStandardDeviation, sampleSize);
 
         // Вывод результата
         System.out.println("Среднее время отклика новой версии: " + sampleMean + " мс");
         System.out.println("Стандартное отклонение выборки: " + sampleStandardDeviation + " мс");
         System.out.println("Z-статистика: " + zScore);
         
         // Критическое значение для двухстороннего теста на уровне значимости 0.05
         double zCritical = 1.96; // Для уровня значимости 0.05, критическое значение Z примерно равно 1.96
         
         // Проверка гипотезы
         if (Math.abs(zScore) > zCritical) {
             System.out.println("Отвергаем нулевую гипотезу. Среднее время отклика новой версии отличается от 250 мс.");
         } else {
             System.out.println("Не отвергаем нулевую гипотезу. Нет статистически значимых доказательств того, что среднее время отклика новой версии отличается от 250 мс.");
         }
     }
 
     // Метод для генерации выборки данных
     public static double[] generateSampleData(int sampleSize, double mean, double stdDev) {
         Random random = new Random();
         double[] data = new double[sampleSize];
         for (int i = 0; i < sampleSize; i++) {
             data[i] = mean + stdDev * random.nextGaussian();
         }
         return data;
     }
 
     // Метод для вычисления среднего значения выборки
     public static double calculateMean(double[] data) {
         double sum = 0;
         for (double value : data) {
             sum += value;
         }
         return sum / data.length;
     }
 
     // Метод для вычисления стандартного отклонения выборки
     public static double calculateStandardDeviation(double[] data, double mean) {
         double sumSquaredDifferences = 0;
         for (double value : data) {
             sumSquaredDifferences += Math.pow(value - mean, 2);
         }
         return Math.sqrt(sumSquaredDifferences / data.length);
     }
 
     // Метод для вычисления Z-статистики
     public static double calculateZScore(double sampleMean, double populationMean, double standardDeviation, int sampleSize) {
         return (sampleMean - populationMean) / (standardDeviation / Math.sqrt(sampleSize));
     }
 }
 
