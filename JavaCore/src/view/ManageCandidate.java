package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bll.CandidateBLL;
import bll.Experience_CandidateBLL;
import bll.Fresher_CandidateBLL;
import bll.Intern_CandidateBLL;
import bll.RecruitmentBLL;
import entity.Candidate;
import entity.Experience_Candidate;
import entity.Fresher_Candidate;
import entity.Intern_Candidate;
import entity.Recruitment;
import utils.CheckValidate;

/**
 * @author User
 *
 */
public class ManageCandidate {
    
    private static final String BẠN_MUỐN_TIẾP_TỤC_KHÔNG_Y_N = "Bạn muốn tiếp tục không?(y/n): ";


    public static void main(String[] args) {
        
        System.out.println("HỆ THỐNG QUẢN LÍ ỨNG VIÊN");
        System.out.println("==========================");
        boolean continueAction = false;
        do {
            // hiển thị menu
            showMenu();
            System.out.println(BẠN_MUỐN_TIẾP_TỤC_KHÔNG_Y_N);
            Scanner scannerYN = new Scanner(System.in);
            String checkYesNo = scannerYN.nextLine();
            if ("Y".equals(checkYesNo.toUpperCase())) {
                    continueAction = false;
            } else {
                    continueAction = true;
            }
        } while (!continueAction);

    }


    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 4, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 4, 2019
     * Description: show menu lựa chọn
     * Version 1.0
     */
    private static void showMenu() {
        int chooseFunction = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Menu:");
            System.out.println("1. Nhập thông tin cho Experience_Candidate");
            System.out.println("2. Nhập thông tin cho Fresher_Candidate");
            System.out.println("3. Nhập thông tin cho Intern_Candidate");
            System.out.println("4. Xuất thông tin cho Experience_Candidate");
            System.out.println("5. Xuất thông tin cho Fresher_Candidate");
            System.out.println("6. Xuất thông tin cho Intern_Candidate");
            System.out.println("7. Nhập thông tin cho Recruitment");
            System.out.println("8. Submit thông tin cho Recruitment");
            System.out.println("9. Thoát!");

            chooseFunction = scanner.nextInt();
        } while (chooseFunction < 1 || chooseFunction > 8);

        switch (chooseFunction) {
        case 1:
            nhapThongTinExperience_Candidate();
            break;
        case 2:
            nhapThongTinFresher_Candidate();
            break;
        case 3:
            nhapThongTinIntern_Candidate();
            break;
        case 4:
            xuatThongTinExperience_Candidate();
            break;
        case 5:
            xuatThongTinFresher_Candidate();
            break;
        case 6:
            xuatThongTinIntern_Candidate();
            break;
        case 7:
            showAllRecruitment();
            break;
        case 8:
            submitCandidateToRecruitment();
            break;
        case 9:
            System.exit(0);
            break;

        default:
            break;
        }
    }


    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 4, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 4, 2019
     * Description: submit candidate to recruitment
     * Version 1.0
     */
    private static void submitCandidateToRecruitment() {
        RecruitmentBLL recruitmentBLL = new RecruitmentBLL();
        CandidateBLL candidateBLL = new CandidateBLL();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter candidateCode you want to apply");
        String candidateCode = sc.nextLine();
        System.out.println("Enter id recruitment you want  to apply");
        int recruitmentCode = Integer.parseInt(sc.nextLine());
        Candidate candidate = candidateBLL.findCandidateByID(candidateCode);
        Recruitment recruitment = recruitmentBLL.findRecruitmentByID(recruitmentCode);
        recruitmentBLL.submitCandidateToRecruitment(candidate, recruitment);
        System.out.println("------------------");
    }


    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 4, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 4, 2019
     * Description: hiển thị tất cả recruitment
     * Version 1.0
     */
    private static void showAllRecruitment() {
        RecruitmentBLL recruitmentBLL = new RecruitmentBLL();
        List<Recruitment> listRecruitments = recruitmentBLL.getAllRecruitment();
        System.out.println("All recruitment");
        for (Recruitment recruitment : listRecruitments) {
                System.out.println(recruitment.toString());
        }
        System.out.println("------------------------");
    }


    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 4, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 4, 2019
     * Description: xuất thông tin cho Intern_Candidate
     * Version 1.0
     */
    private static void xuatThongTinIntern_Candidate() {
        Intern_CandidateBLL candidateBLL = new Intern_CandidateBLL();
        List<Intern_Candidate> listInternCan = new ArrayList<Intern_Candidate>();
        listInternCan = candidateBLL.getAll();
        for(Intern_Candidate intern : listInternCan) {
            System.out.println(intern);
        }
        
    }


    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 4, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 4, 2019
     * Description: xuất thông tin cho Fresher_Candidate
     * Version 1.0
     */
    private static void xuatThongTinFresher_Candidate() {
        Fresher_CandidateBLL candidateBLL = new Fresher_CandidateBLL();
        List<Fresher_Candidate> listFreshCan = new ArrayList<Fresher_Candidate>();
        listFreshCan = candidateBLL.getAll();
        for(Fresher_Candidate fresh : listFreshCan) {
            System.out.println(fresh);
        }
        
    }


    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 4, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 4, 2019
     * Description: nhập thông tin cho Intern_Candidate
     * Version 1.0
     */
    private static void nhapThongTinIntern_Candidate() {
        Intern_Candidate intern_can = new Intern_Candidate();
        Intern_CandidateBLL interncandidateBLL = new Intern_CandidateBLL();
        CandidateBLL candidatebll = new CandidateBLL();
        
        String candidateCode;
        String FirstName;
        String LastName;
        int BirthDate;
        String Address;
        String Email;
        String Phone;
        String Candidate_type;
        String Majors;
        String Semester;
        String University_name;
        
        Scanner scannerExpCan = new Scanner(System.in);
        
        // nhập mã 
        do {
            System.out.println("candidateCode: ");
            candidateCode = scannerExpCan.nextLine();
            if(!candidatebll.checkID(candidateCode))
            {
                System.out.println("candidateCode đã có trong CSDL, mời nhập lại!");
            }
        } while (!candidatebll.checkID(candidateCode));

        
        // nhập tên đầu 
        System.out.println("FirstName: ");
        FirstName = scannerExpCan.nextLine();
        
        // nhập tên cuối
        System.out.println("LastName: ");
        LastName = scannerExpCan.nextLine();
        
        // nhập năm sinh
        do {
            System.out.println("BirthDate: ");
            Scanner scanBirth = new Scanner(System.in);
            BirthDate = scanBirth.nextInt();
            boolean kiemtra = CheckValidate.validBirthDate(BirthDate);
            if (!kiemtra) {
                System.out.println("Bạn đã nhập sai, mời nhập lại!");
            }
        } while (!CheckValidate.validBirthDate(BirthDate));

        // nhập địa chỉ
        System.out.println("Address: ");
        Address = scannerExpCan.nextLine();
        
        // nhập email
        do {
            System.out.println("Email: ");
            Email = scannerExpCan.nextLine();
            if(!CheckValidate.validEmail(Email))
            {
                System.out.println("Bạn đã nhập sai, mời nhập lại!");
            }
        } while (!CheckValidate.validEmail(Email));

        // nhập phone 
        do {
            System.out.println("Phone: ");
            Phone = scannerExpCan.nextLine();
            if(!CheckValidate.validPhone(Phone))
            {
                System.out.println("Bạn đã nhập sai, mời nhập lại!");
            }
        } while (!CheckValidate.validPhone(Phone));

        // nhập loại ứng viên 
        System.out.println("Candidate_type: ");
        Candidate_type = scannerExpCan.nextLine();
        
        // nhập chuyên ngành
        System.out.println("Majors: ");
        Majors = scannerExpCan.nextLine();

        // nhập tên kì học
        System.out.println("Semester: ");
        Semester = scannerExpCan.nextLine();

        // nhập tên trường đang học
        System.out.println("University_name: ");
        University_name = scannerExpCan.nextLine();
        
        
        // set thông tin cho ứng viên
        intern_can.setCandidateCode(candidateCode);
        intern_can.setFirstName(FirstName);
        intern_can.setLastName(LastName);
        intern_can.setBirthDate(BirthDate);
        intern_can.setAddress(Address);
        intern_can.setEmail(Email);
        intern_can.setPhone(Phone);
        intern_can.setCandidate_type(Candidate_type);
        intern_can.setMajors(Majors);
        intern_can.setSemester(Semester);
        intern_can.setUniversity_name(University_name);
        interncandidateBLL.insert(intern_can);
        
        System.out.println("Nhập thành công!");
        
    }


    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 4, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 4, 2019
     * Description: nhập thông tin cho Fresher_Candidate
     * Version 1.0
     */
    private static void nhapThongTinFresher_Candidate() {
        Fresher_Candidate fresh_can = new Fresher_Candidate();
        Fresher_CandidateBLL freshcandidateBLL = new Fresher_CandidateBLL();
        CandidateBLL candidatebll = new CandidateBLL();
        
        String candidateCode;
        String FirstName;
        String LastName;
        int BirthDate;
        String Address;
        String Email;
        String Phone;
        String Candidate_type;
        String Graduration_date;
        String Graduation_rank;
        String Education;
        
        Scanner scannerExpCan = new Scanner(System.in);
        
        // nhập mã 
        do {
            System.out.println("candidateCode: ");
            candidateCode = scannerExpCan.nextLine();
            if(!candidatebll.checkID(candidateCode))
            {
                System.out.println("candidateCode đã có trong CSDL, mời nhập lại!");
            }
        } while (!candidatebll.checkID(candidateCode));
        
        // nhập tên đầu 
        System.out.println("FirstName: ");
        FirstName = scannerExpCan.nextLine();
        
        // nhập tên cuối
        System.out.println("LastName: ");
        LastName = scannerExpCan.nextLine();
        
        do {
            System.out.println("BirthDate: ");
            Scanner scanBirth = new Scanner(System.in);
            BirthDate = scanBirth.nextInt();
            boolean kiemtra = CheckValidate.validBirthDate(BirthDate);
            if (!kiemtra) {
                System.out.println("Bạn đã nhập sai, mời nhập lại!");
            }
        } while (!CheckValidate.validBirthDate(BirthDate));

        // nhập địa chỉ
        System.out.println("Address: ");
        Address = scannerExpCan.nextLine();
        
        // nhập email
        do {
            System.out.println("Email: ");
            Email = scannerExpCan.nextLine();
            if(!CheckValidate.validEmail(Email))
            {
                System.out.println("Bạn đã nhập sai, mời nhập lại!");
            }
        } while (!CheckValidate.validEmail(Email));

        // nhập phone 
        do {
            System.out.println("Phone: ");
            Phone = scannerExpCan.nextLine();
            if(!CheckValidate.validPhone(Phone))
            {
                System.out.println("Bạn đã nhập sai, mời nhập lại!");
            }
        } while (!CheckValidate.validPhone(Phone));

        // nhập loại ứng viên 
        System.out.println("Candidate_type: ");
        Candidate_type = scannerExpCan.nextLine();
        
        // nhập thời gian tốt nghiệp
        System.out.println("Graduration_date: ");
        Graduration_date = scannerExpCan.nextLine();

         // nhập xếp hạng
        do {
            System.out.println("Graduation_rank: ");
            Graduation_rank = scannerExpCan.nextLine();
            if (!CheckValidate.validGraduationRank(Graduation_rank)) {
                System.out.println("Bạn đã nhập sai, mời nhập lại!");
            }
        } while (!CheckValidate.validGraduationRank(Graduation_rank));
        
        // nhập tên trương tốt nghiệp
        System.out.println("Education: ");
        Education = scannerExpCan.nextLine();

        
        // set thông tin cho ứng viên
        fresh_can.setCandidateCode(candidateCode);
        fresh_can.setFirstName(FirstName);
        fresh_can.setLastName(LastName);
        fresh_can.setBirthDate(BirthDate);
        fresh_can.setAddress(Address);
        fresh_can.setEmail(Email);
        fresh_can.setPhone(Phone);
        fresh_can.setCandidate_type(Candidate_type);
        fresh_can.setGraduration_date(Graduration_date);
        fresh_can.setGraduation_rank(Graduation_rank);
        fresh_can.setEducation(Education);
        freshcandidateBLL.insert(fresh_can);
        
        System.out.println("Nhập thành công!");
        
    }


    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 4, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 4, 2019
     * Description: xuât thông tin cho Experience_Candidate
     * Version 1.0
     */
    private static void xuatThongTinExperience_Candidate() {
        Experience_CandidateBLL candidateBLL = new Experience_CandidateBLL();
        List<Experience_Candidate> listExpCan = new ArrayList<Experience_Candidate>();
        listExpCan = candidateBLL.getAll();
        for(Experience_Candidate exp : listExpCan) {
            System.out.println(exp);
        }
    }


    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 4, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 4, 2019
     * Description: nhập thông tin cho Experience_Candidate
     * Version 1.0
     */
    private static void nhapThongTinExperience_Candidate() {
        Experience_Candidate exper_can = new Experience_Candidate();
        Experience_CandidateBLL candidateBLL = new Experience_CandidateBLL();
        CandidateBLL candidatebll = new CandidateBLL();
        
        String candidateCode;
        String FirstName;
        String LastName;
        int BirthDate;
        String Address;
        String Email;
        String Phone;
        String Candidate_type;
        int ExpInYear;
        String ProSkill;
        
        Scanner scannerExpCan = new Scanner(System.in);
        
        // nhập mã 
        do {
            System.out.println("candidateCode: ");
            candidateCode = scannerExpCan.nextLine();
            if(!candidatebll.checkID(candidateCode))
            {
                System.out.println("candidateCode đã có trong CSDL, mời nhập lại!");
            }
        } while (!candidatebll.checkID(candidateCode));
        
        // nhập tên đầu 
        System.out.println("FirstName: ");
        FirstName = scannerExpCan.nextLine();
        
        // nhập tên cuối
        System.out.println("LastName: ");
        LastName = scannerExpCan.nextLine();
        
        do {
            System.out.println("BirthDate: ");
            Scanner scanBirth = new Scanner(System.in);
            BirthDate = scanBirth.nextInt();
            boolean kiemtra = CheckValidate.validBirthDate(BirthDate);
            if (!kiemtra) {
                System.out.println("Bạn đã nhập sai, mời nhập lại!");
            }
        } while (!CheckValidate.validBirthDate(BirthDate));

        // nhập địa chỉ
        System.out.println("Address: ");
        Address = scannerExpCan.nextLine();
        
        // nhập email
        do {
            System.out.println("Email: ");
            Email = scannerExpCan.nextLine();
            if(!CheckValidate.validEmail(Email))
            {
                System.out.println("Bạn đã nhập sai, mời nhập lại!");
            }
        } while (!CheckValidate.validEmail(Email));

        // nhập phone 
        do {
            System.out.println("Phone: ");
            Phone = scannerExpCan.nextLine();
            if(!CheckValidate.validPhone(Phone))
            {
                System.out.println("Bạn đã nhập sai, mời nhập lại!");
            }
        } while (!CheckValidate.validPhone(Phone));

        // nhập loại ứng viên 
        System.out.println("Candidate_type: ");
        Candidate_type = scannerExpCan.nextLine();
        
        // nhập năm kinh nghiệm
        do {
            Scanner scanExpYear = new Scanner(System.in);
            System.out.println("ExpInYear: ");
            ExpInYear = scanExpYear.nextInt();
            if(!CheckValidate.validExpInYear(ExpInYear))
            {
                System.out.println("Bạn đã nhập sai, mời nhập lại!");
            }
        } while (!CheckValidate.validExpInYear(ExpInYear));

        // nhập kĩ năng
        System.out.println("ProSkill: ");
        ProSkill = scannerExpCan.nextLine();
        
        // set thông tin cho ứng viên
        exper_can.setCandidateCode(candidateCode);
        exper_can.setFirstName(FirstName);
        exper_can.setLastName(LastName);
        exper_can.setBirthDate(BirthDate);
        exper_can.setAddress(Address);
        exper_can.setEmail(Email);
        exper_can.setPhone(Phone);
        exper_can.setCandidate_type(Candidate_type);
        exper_can.setExpInYear(ExpInYear);
        exper_can.setProSkill(ProSkill);
        candidateBLL.insert(exper_can);
        
        System.out.println("Nhập thành công!");
    }

}
