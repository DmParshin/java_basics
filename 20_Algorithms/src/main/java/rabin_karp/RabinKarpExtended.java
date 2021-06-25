package rabin_karp;

import java.security.Key;
import java.util.*;

public class RabinKarpExtended
{
    private String text;
    private TreeMap<Integer, Integer> number2position = new TreeMap<>();

    public RabinKarpExtended(String text)
    {
        this.text = text;
        createIndex();
    }

    public List<Integer> search(String query)
    {
        ArrayList<Integer> indices = new ArrayList<>();
        //TODO: implement search alogorithm

        for(int i = 0; i < number2position.size(); i++){
            if(number2position.get(i) == (int)query.charAt(0)) {
                for(int j = 0; j < query.length() && i + j < number2position.size(); j++){
                    if(number2position.get(i + j) == (int)query.charAt(j)){
                        indices.add(i + j);
                    }
                }
            }
            if (indices.size() == query.length()) {
                break; }
            else indices.clear();
        }

        if(indices.size() != query.length()){
            indices.clear();
            return indices;}
        return indices;
    }

    private void createIndex() {
        //TODO: implement text indexing
        for (int i = 0; i < text.length(); i++) {
            number2position.put(i, (int) text.charAt(i));
        }

        HashSet<Integer>hashSet = new HashSet<>();
        for(int key : number2position.keySet()){ hashSet.add(number2position.get(key));}

        if (hashSet.size() > 9) {
            throw new IllegalArgumentException("Алфавит больше 9 символов");
        }
    }

    public static void main(String[] args) {
        RabinKarpExtended rabinKarpExtended = new RabinKarpExtended("zxcvbnASDFGHJKLASDDSADFAAFASFASFASSDASASDASDASFASFASFASFDASFAFGDSAGFADAFDSFA");
        List<Integer> list = rabinKarpExtended.search("AFASFASFAS");
        System.out.println(list);
    }
}