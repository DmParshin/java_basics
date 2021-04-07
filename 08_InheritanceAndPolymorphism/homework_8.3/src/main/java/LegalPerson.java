public class LegalPerson extends Client {
    @Override
    public void take(double amountToTake) {
        if (amountToTake + (amountToTake /100) <= sum){
            super.take(amountToTake + (amountToTake / 100));
        }
    }
}
