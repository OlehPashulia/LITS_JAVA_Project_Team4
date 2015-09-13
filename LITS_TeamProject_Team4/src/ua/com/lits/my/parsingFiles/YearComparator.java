package ua.com.lits.my.parsingFiles;

import java.util.Comparator;

/**
 * Created by olesia on 13.09.15.
 */

public class YearComparator implements Comparator<MapJSON> {


    @Override
    public int compare(MapJSON year1, MapJSON year2) {
        return year1.getFounded().compareTo(year2.getFounded());
    }

}
