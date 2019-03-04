package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author User
 *
 */
public class CheckValidate {
    
    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 3, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 3, 2019
     * Description: ....
     * Version 1.0
     * @param BirthDate
     * @return
     */
    public static boolean validBirthDate(int BirthDate) {
        try {
                if (BirthDate > 1900 && BirthDate < 2020) {
                        return true;
                } else {
                        System.out.println("Enter birth date between 1900 and 2019");
                        return false;
                }
        } catch (Exception e) {
                System.out.println("Enter birth date is a number! Enter again please!");
                return false;
        }
}


/**
 * Create by: BuiHoangHieu - CMC
 * Create date: Jan 3, 2019
 * Modifier: BuiHoangHieu
 * Modified date: Jan 3, 2019
 * Description: ....
 * Version 1.0
 * @param expInYear
 * @return
 */
public static boolean validExpInYear(int expInYear) {
        return (expInYear < 100 && expInYear > 0);
}


/**
 * Create by: BuiHoangHieu - CMC
 * Create date: Jan 3, 2019
 * Modifier: BuiHoangHieu
 * Modified date: Jan 3, 2019
 * Description: ....
 * Version 1.0
 * @param phone
 * @return
 */
public static boolean validPhone(String phone) {
        Pattern pattern = Pattern.compile("(03/09)?[0-9]{7}");
        Matcher matcher = pattern.matcher(phone);
        return (matcher.find() && matcher.group().equals(phone));
}


/**
 * Create by: BuiHoangHieu - CMC
 * Create date: Jan 3, 2019
 * Modifier: BuiHoangHieu
 * Modified date: Jan 3, 2019
 * Description: ....
 * Version 1.0
 * @param email
 * @return
 */
public static boolean validEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                        + "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null)
                return false;
        return pattern.matcher(email).matches();
}

/**
 * Create by: BuiHoangHieu - CMC
 * Create date: Jan 3, 2019
 * Modifier: BuiHoangHieu
 * Modified date: Jan 3, 2019
 * Description: ....
 * Version 1.0
 * @param graduationRank
 * @return
 */
public static boolean validGraduationRank(String graduationRank) {
        List<String> list = new ArrayList<>();
        list.add("Excellent");
        list.add("Good");
        list.add("Fair");
        list.add("Poor");
        return list.contains(graduationRank);
}

}
