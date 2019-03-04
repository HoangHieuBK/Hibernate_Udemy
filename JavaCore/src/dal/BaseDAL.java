/**
 * 
 */
package dal;

import java.util.List;


/**
 * Create by: BuiHoangHieu - CMC
 * Create date: Jan 3, 2019
 * Modifier: BuiHoangHieu
 * Modified date: Jan 3, 2019
 * Description: ....
 * Version 1.0
 */
public interface BaseDAL<T> {
        /**
         * Create by: BuiHoangHieu - CMC
         * Create date: Jan 3, 2019
         * Modifier: BuiHoangHieu
         * Modified date: Jan 3, 2019
         * Description: .list all object T
         * Version 1.0
         * @return
         */
        List<T> getAll();
        /**
         * Create by: BuiHoangHieu - CMC
         * Create date: Jan 3, 2019
         * Modifier: BuiHoangHieu
         * Modified date: Jan 3, 2019
         * Description: ....
         * Version 1.0
         * @param object
         * @return
         */
        int insertExperience_Candidate(T object);

        /**
         * Create by: BuiHoangHieu - CMC
         * Create date: Jan 3, 2019
         * Modifier: BuiHoangHieu
         * Modified date: Jan 3, 2019
         * Description: ....
         * Version 1.0
         * @param object
         * @return
         */
        
        /**
         * Create by: BuiHoangHieu - CMC
         * Create date: Jan 3, 2019
         * Modifier: BuiHoangHieu
         * Modified date: Jan 3, 2019
         * Description: ....
         * Version 1.0
         * @param object
         * @return
         */
        int insertFresher_Candidate(T object);
        
        /**
         * Create by: BuiHoangHieu - CMC
         * Create date: Jan 3, 2019
         * Modifier: BuiHoangHieu
         * Modified date: Jan 3, 2019
         * Description: ....
         * Version 1.0
         * @param object
         * @return
         */
        int insertIntern_Candidate(T object);

        
}
