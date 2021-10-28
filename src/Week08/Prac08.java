package Week08;

import java.util.*;

public class Prac08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> info = new HashMap<String, Integer>();
        
        System.out.println("** 포인트 관리 프로그램입니다. **");
        
        while (true) 
        {
            System.out.print("이름과 포인트 입력>>");
            String name = sc.next();

            if (name.equals("그만"))
                break;

            int point = sc.nextInt();

            if (info.containsKey(name)) 
            {
                int value = info.get(name);
                value += point;
                info.put(name, value);
            }
            else
                info.put(name, point);

            Set<String> keys = info.keySet();
            Iterator<String> it = keys.iterator();

            while (it.hasNext()) 
            {
                String key = it.next();
                int value = info.get(key);
                System.out.println("(" + key + ", " + value + ") ");
            }

        }
        
        sc.close();
    }
}
