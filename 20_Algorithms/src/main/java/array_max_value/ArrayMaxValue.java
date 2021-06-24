package array_max_value;

public class ArrayMaxValue
{
    public static Object getMaxValue(int[] values)
    {
        try {
            int maxValue = values[0];
            for(int value : values)
            {
                if (value > maxValue) {
                    maxValue = value;
                }
            }
            return maxValue;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        int[]array = new int[]{4,5,1,2,-8,7};
        System.out.println(getMaxValue(array));
        System.out.println(getMaxValue(new int[0]));
    }
}