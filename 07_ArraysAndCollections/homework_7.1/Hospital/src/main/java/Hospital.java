//        Напишите код метода generatePatientsTemperatures(), который должен сгенерировать массив float, содержащий значения
//        температур пациентов от 32 до 40 градусов.

//        В методе getReport()вам требуется составить строку с отчётом по значениям температур в массиве с пациентами:
//        - Соберите в строку список температур пациентов.
//
//        - Рассчитайте среднее арифметическое значение температуры.
//
//        - Посчитайте количество здоровых пациентов с температурой от 36,2 до 36,9 градусов.

public class Hospital {

    final static float MIN_TEMP = 32; // Начальное значение диапазона - "от"
    final static float MAX_TEMP = 40; // Конечное значение диапазона - "до"
    final static float HEALTHYMAN_TEMP_MIN = 35.5f;
    final static float HEALTHYMAN_TEMP_MAX = 37.2f;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        if (patientsCount > 0) {


            float[] patientsTemperature = new float[patientsCount];

            for (int i = 0; i < patientsTemperature.length; i++){
                patientsTemperature[i] = MIN_TEMP + (float) Math.round((Math.random() * (MAX_TEMP - MIN_TEMP) * 10)) / 10;
            }

            return patientsTemperature;
        }
        else {return new float[0];}
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        String strTemp = "";
        float summTemp = 0;
        int healthyMan =0;

        for (int i = 0; i < temperatureData.length; i++){
            strTemp = strTemp + temperatureData[i] + " ";
            summTemp = summTemp + temperatureData[i];
            if (temperatureData[i] >= HEALTHYMAN_TEMP_MIN && temperatureData[i] <= HEALTHYMAN_TEMP_MAX){
                healthyMan++;
            }
        }

        float averageTemp = summTemp / temperatureData.length;

        String report =
                "Температуры пациентов: " + strTemp +
                        "\nСредняя температура: " + averageTemp +
                        "\nКоличество здоровых: " + healthyMan;

        return report;
    }
}
