import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.lang.Math;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class World
{

    protected ArrayList<Aeroport> list;

    World(String fileName)
    {
        list = new ArrayList<Aeroport>();
        try
        {
            BufferedReader buf = new BufferedReader(new FileReader(fileName));
            String s = buf.readLine();
            while (s != null)
            {
                s = s.replaceAll("\"", "");
                String fields[] = s.split(",");
                if (fields[1].equals("large_airport"))
                {
                    list.add(new Aeroport( fields[9], fields[2], fields[5], Double.parseDouble(fields[11]), Double.parseDouble(fields[12]) ) );
                                          /*IATA*/  /*name*/  /*Country*/         /*latirude*/                    /* longitude */
                }
                s = buf.readLine();
            }
        } catch (Exception e)
        {
            System.out.println("maybe the file isn't there?");
            System.out.println(list.get(list.size() - 1));
            e.printStackTrace();
        }
    }

    protected double distance(double longitude, double latitude, Aeroport ap)
    {
        double apLat = ap.getLatitude();
        double apLong = ap.getLongitude();

        return Math.pow((apLat - latitude), 2) + Math.pow(((apLong - longitude) * Math.cos((apLat + latitude) / 2)), 2);

    }

    public Aeroport findNearestAirport(double longitude, double latitude)
    {
        int idx_min = 0;

        double distance_min = distance(latitude, longitude, list.get(0));

        for (int a = 1;a < list.size();a++)
        {
            if (distance(latitude, longitude, list.get(a)) < distance_min)
            {
                distance_min = distance(latitude, longitude, list.get(a));
                idx_min = a;
            }
        }
        return list.get(idx_min);
    }

    public Aeroport findByCode(String iata_code)
    {
        Aeroport aeroport;
        int index = 0;
        for (int a = 0;a < list.size();a++)
        {
            if (list.get(a).getIATA().equals(iata_code))
            {
                System.out.println(list.get(a).getIATA());
                index = a;
            }
        }
        aeroport = list.get(index);
        return aeroport;
    }

    public ArrayList<Aeroport> getList()
    {
        return list;
    }
}
