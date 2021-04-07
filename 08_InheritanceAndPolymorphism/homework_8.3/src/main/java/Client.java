public abstract class Client {

    protected double sum;

    public double getAmount() {
        System.out.println(sum);
        return sum;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0){ sum = sum + amountToPut;}
    }

    public void take(double amountToTake) {
        if (amountToTake <= sum){ sum = sum - amountToTake;}
    }

}
