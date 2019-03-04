/**
 * 
 */
package utils;

/**
 * Create by: HQTrung - CMC
 * Create date: Dec 28, 2018
 * Modifier: HQTrung
 * Modified date: Dec 28, 2018
 * Description: ....
 * Version 1.0
 */
public interface Constants {
        // constant for Student
        interface Student {
                public static final String STUDENT_CODE = "MaSV";
        }

        interface Course {
                // query string select all
                public static final String SELECT_ALL = "select * from khoahoc";
                public static final String SELECT_ByID = "select * from khoahoc where maKhoaHoc=?";
                // column name
                public static final String COURSE_CODE = "maKhoaHoc";
                public static final String COURSE_NAME = "tenKhoaHoc";

        }

        // constant for HeDT
        //

}
