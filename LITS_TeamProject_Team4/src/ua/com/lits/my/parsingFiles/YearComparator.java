package ua.com.lits.my.parsingFiles;

import java.util.Comparator;
import org.apache.commons.lang3.builder.CompareToBuilder;

/**
 * Created by olesia on 13.09.15.
 */

public class YearComparator implements Comparator<MapJSON> {


    @Override
    public int compare(MapJSON year1, MapJSON year2) {
        return new CompareToBuilder()
        		.append(year1.getFounded(), year2.getFounded())
        		.append(year1.getTeam_name(), year2.getTeam_name())
        		.append(year1.getCity_based(), year2.getCity_based())
        		.toComparison();
    }

}