package onboarding.dataobjects;

import java.util.Map;

import cucumber.api.DataTable;
import procraft.core.utilities.automationbase.AutomationBase;

public class LoginData {
    private String optumIDorEmailAddress = "";
    private String passWord = "";
    public static String userType = "";
    Map<String, String> data = null;

    public LoginData(DataTable table) {
        data = table.asMap(String.class, String.class);
        this.optumIDorEmailAddress = data.get("OptumIDoremailaddress");
        if (optumIDorEmailAddress.toLowerCase().trim().equals("internal")) {
            optumIDorEmailAddress = AutomationBase.Environment("internalUserId");
            userType = "INTERNAL";
        } else if (optumIDorEmailAddress.toLowerCase().trim().equals("external")) {
            optumIDorEmailAddress = AutomationBase.Environment("externalUserId");
            userType = "EXTERNAL";
        } else if (optumIDorEmailAddress.toLowerCase().trim().equals("invalid")) {
            optumIDorEmailAddress = AutomationBase.Environment("invalidUserId");
            userType = "INVALID";
        }

        this.passWord = data.get("Password");

        if (passWord.toLowerCase().trim().equals("internal")) {
            passWord = AutomationBase.Environment("internalPassWord");
        } else if (passWord.toLowerCase().trim().equals("external")) {
            passWord = AutomationBase.Environment("externalPassWord");
        } else if (passWord.toLowerCase().trim().equals("invalid")) {
            passWord = AutomationBase.Environment("invalidPassWord");
        }
    }

    public String getOptumIDorEmailAddress() {
        return optumIDorEmailAddress;
    }

    public String getPassWord() {
        return passWord;
    }
}
