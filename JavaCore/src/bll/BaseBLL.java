/**
 * 
 */
package bll;

import java.util.List;

/**
 * Create by: BuiHoangHieu - CMC
 * Create date: Jan 3, 2019
 * Modifier: BuiHoangHieu
 * Modified date: Jan 3, 2019
 * Description: ....
 * Version 1.0
 */
public interface BaseBLL<T> {
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
        int insert(T object);


}
