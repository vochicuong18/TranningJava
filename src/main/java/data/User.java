package data;

public class User {
    private String userName;
    private String passWord;
    private String nameCustomerPO;

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getNameCustomerPO() {
        return nameCustomerPO;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nameCustomerPO='" + nameCustomerPO + '\'' +
                '}';
    }
}
