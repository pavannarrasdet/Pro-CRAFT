package onboarding.dataobjects;

import java.util.Map;

import cucumber.api.DataTable;

public class WelcomeData {
    private String selectCorporateName = "";
    private String selectTaxId = "";
    private String enterMpin = "";
    Map<String, String> data = null;

    public WelcomeData(DataTable table) {
        data = table.asMap(String.class, String.class);
        if (data.containsKey("SELECTCORPORATENAME")) {
            this.selectCorporateName = data.get("SELECTCORPORATENAME");
        } else if (data.containsKey("ENTERMPIN")) {
            this.enterMpin = data.get("ENTERMPIN");
        }
        this.selectTaxId = data.get("SELECTTAXID");
    }

    public String getSelectCorporateName() {
        return selectCorporateName;
    }

    public String getEnterMPIN() {
        return enterMpin;
    }

    public String getSelectTaxId() {
        if (selectTaxId.equals("383501775")) {
            selectTaxId = "XXX-XX-1775";
        } else if (selectTaxId.equals("223546665")) {
            selectTaxId = "XXX-XX-6665";
        }
        return selectTaxId;
    }
}
