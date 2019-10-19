import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        HashMap<String, String[]> bigDictionary = new HashMap<>();
        HashMap<String, String[]> dictionary = new HashMap<>();
        dictionary.put("Худой",
                new String[]{"Тощий", "Сухой", "Дрищ", "Доска", "Глиста"});
        dictionary.put("Красивый",
                new String[]{"Прекрасный", "Симпатичный", "Привлекательный", "Милый"});
        dictionary.put("Человек",
                new String[]{"Личность", "Персона", "Индивидум", "Тело"});
        dictionary.put("Дом",
                new String[]{"Хата", "Жилье", "Халупа", "Шалаш"});
        Set<String> keys = dictionary.keySet(); //--- применить в методе для отображения ключей
        bigDictionary.putAll(dictionary);

        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()){
            String key = iter.next().toString();
            String[] values = bigDictionary.get(key);
            bigDictionary.put(key, values);
            for (int i = 0; i<values.length; i++){
                String nextKey = values[i];
                ArrayList<String> arrList = new ArrayList<>(values.length);
                arrList.addAll(Arrays.asList(values));
                arrList.remove(nextKey);
                arrList.add(key);
                String[] nexValues = new String[arrList.size()];
                nexValues = arrList.toArray(nexValues);
                System.out.println(nextKey + " - " + nexValues);
                bigDictionary.put(nextKey, nexValues);
            }
        }


        System.out.println("Введите слово из словаря: Например (Худой) \n");
        String sentences = s.nextLine();
        String[] words = sentences.split(" ");
        for (int i = 0; i < words.length; i++) {

            if (bigDictionary.get(words[i]) == null) {
                System.out.println("Не понял!!!!");
            } else {
                String[] synonims = bigDictionary.get(words[i]);
                int randomNumer = r.nextInt(synonims.length);
                System.out.printf(synonims[randomNumer] + " ");
            }
        }
    }

    /*public static HashMap<String, String[]> createBigDictionary(HashMap<String, String[]> firstDictionary, ){
        HashMap<String, String[]> bigDictionary = new HashMap<>();
        bigDictionary.putAll(firstDictionary);

        return null;
    }*/

}
