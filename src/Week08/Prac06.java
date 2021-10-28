package Week08;

import java.util.*;

class Location {
    private String name;
    private int longitude, latitude;

    public Location(String name, int longitude, int latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public int getLongitute() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }
}

public class Prac06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Location> info = new HashMap<String, Location>();

        System.out.println("도시, 경도, 위도를 입력하세요.");

        for (int i = 0; i < 4; i++) 
        {
            System.out.print(">> ");
            String text = sc.nextLine();

            StringTokenizer st = new StringTokenizer(text, ",");
            String name = st.nextToken().trim();

            int longitude = Integer.parseInt(st.nextToken().trim());
            int latitude = Integer.parseInt(st.nextToken().trim());

            Location location = new Location(name, longitude, latitude);
            info.put(name, location);
        }

        Set<String> key = info.keySet();
        Iterator<String> it = key.iterator();
        System.out.println("---------------------------");

        while (it.hasNext()) 
        {
            String name = it.next();
            Location location = info.get(name);

            System.out.print(location.getName() + " ");
            System.out.print(location.getLongitute() + " ");
            System.out.println(location.getLatitude() + " ");
        }

        System.out.println("---------------------------");

        while (true) 
        {
            System.out.print("도시 이름 >> ");
            String name = sc.nextLine();

            if (name.equals("그만"))
                break;

            Location location = info.get(name);
            
            if (location == null)
                System.out.println(name + "는 없습니다.");
            else 
            { 
                System.out.print(location.getName() + " ");
                System.out.print(location.getLongitute() + " ");
                System.out.println(location.getLatitude());
            }
        }
        sc.close();
    }
}
