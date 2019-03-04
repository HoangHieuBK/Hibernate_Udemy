/**
 * 
 */
package entity;


/**
 * @author User
 *
 */
public class Recruitment {
        private int recruimentCode;
        private String position;
        private String recruitmentPackage;
        private int amount;
        
        /**
         * 
         */
        public Recruitment() {
        }
        
        /**
         * @param recruimentCode
         * @param position
         * @param recruimentPackage
         * @param amount
         */
        public Recruitment(int recruimentCode, String position, String recruimentPackage, int amount) {
                super();
                this.recruimentCode = recruimentCode;
                this.position = position;
                this.recruitmentPackage = recruimentPackage;
                this.amount = amount;
        }
        public int getRecruimentCode() {
                return recruimentCode;
        }
        public void setRecruimentCode(int recruimentCode) {
                this.recruimentCode = recruimentCode;
        }
        public String getPosition() {
                return position;
        }
        public void setPosition(String position) {
                this.position = position;
        }
        public String getRecruimentPackage() {
                return recruitmentPackage;
        }
        public void setRecruimentPackage(String recruimentPackage) {
                this.recruitmentPackage = recruimentPackage;
        }
        public int getAmount() {
                return amount;
        }
        public void setAmount(int amount) {
                this.amount = amount;
        }
        @Override
        public String toString() {
                return "Recruitment [recruimentCode=" + recruimentCode + ", position=" + position
                                + ", recruitmentPackage=" + recruitmentPackage + ", amount=" + amount + "]";
        }
        
        
}
