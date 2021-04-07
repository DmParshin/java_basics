public abstract class Client {

    protected double sum;

    public double getAmount() {
        System.out.println(sum);
        return 0;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0){ sum = sum + amountToPut;}
    }

    public void take(double amountToTake) {
        if (amountToTake <= sum){ sum = sum - amountToTake;}
    }

}
