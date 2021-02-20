package onboarding.dataobjects;

import java.util.Map;
import cucumber.api.DataTable;

public class AddLocationData {

	private String locationType = "";
	private String streetAddress = "";
	private String city = "";
	private String state = "";
	private String zipCode = "";
	private String phone = "";
	private String fax = "";

	Map<String, String> data = null;

	public AddLocationData(DataTable table) {

		this.data = table.asMap(String.class, String.class);
		if (data.containsKey("LocationType")) {
			this.locationType = data.get("LocationType");
		}
		if (data.containsKey("StreetAddress")) {
			this.streetAddress = data.get("StreetAddress");
		}
		if (data.containsKey("City")) {
			this.city = data.get("City");
		}
		if (data.containsKey("State")) {
			this.state = data.get("State");
		}
		if (data.containsKey("ZipCode")) {
			this.zipCode = data.get("ZipCode");
		}
		if (data.containsKey("Phone")) {
			this.phone = data.get("Phone");
		}
		if (data.containsKey("Phone")) {
			this.phone = data.get("Phone");
		}
		if (data.containsKey("Fax")) {
			this.fax = data.get("Fax");
		}
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

}
