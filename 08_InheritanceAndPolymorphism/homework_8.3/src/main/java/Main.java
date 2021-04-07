public class Main {
    public static void main(String[] args) {
        Client physicalPerson = new PhysicalPerson();
        physicalPerson.put(2.0);
        physicalPerson.getAmount();
        physicalPerson.take(3.0);
        physicalPerson.getAmount();

        Client legalPerson = new LegalPerson();
        legalPerson.put(100);
        legalPerson.getAmount();
        legalPerson.take(90);
        legalPerson.getAmount();

        Client individualBusinessman = new IndividualBusinessman();
        individualBusinessman.put(1001);
        individualBusinessman.getAmount();
        individualBusinessman.take(90);
        individualBusinessman.getAmount();
    }
}
