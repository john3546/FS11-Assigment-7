import java.util.*;

class WeatherData {
    private double temperature;
    private double humidity;

    public WeatherData(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }
}

public class WeatherAnalyzer {
    public static void main(String[] args) {
        List<WeatherData> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherData(5, 60));
        weatherDataList.add(new WeatherData(15, 55));
        weatherDataList.add(new WeatherData(-2, 70));
        weatherDataList.add(new WeatherData(20, 45));
        weatherDataList.add(new WeatherData(8, 75));
        weatherDataList.add(new WeatherData(12, 50));
        weatherDataList.add(new WeatherData(25, 40));
        weatherDataList.add(new WeatherData(-5, 80));
        double[] temperatureRanges = {-10, 0, 10, 20, 30, 40};
        int numRanges = temperatureRanges.length - 1;
        int[] daysCount = new int[numRanges];
        double[] humidityTotal = new double[numRanges];
        for (WeatherData data : weatherDataList) {
            double temperature = data.getTemperature();
            double humidity = data.getHumidity();
            for (int i = 0; i < numRanges; i++) {
                if (temperature >= temperatureRanges[i] && temperature < temperatureRanges[i + 1]) {
                    daysCount[i]++;
                    humidityTotal[i] += humidity;
                    break;
                }
            }
        }
        System.out.println("Temperature Range\t\tDays Count\t\tAverage Humidity");
        for (int i = 0; i < numRanges; i++) {
            double averageHumidity = daysCount[i] > 0 ? humidityTotal[i] / daysCount[i] : 0;
            System.out.printf("%.0f°C - %.0f°C\t\t\t\t%d\t\t\t\t%.2f%%\n",
                    temperatureRanges[i], temperatureRanges[i + 1], daysCount[i], averageHumidity);
        }
    }
}