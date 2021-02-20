package onboarding.dataobjects;

import java.io.File;
import java.util.Map;

import cucumber.api.DataTable;
import procraft.core.utilities.automationbase.AutomationBase;

public class AttachmentsData {

	private String attachmentsmessage = "";
	private String limiterrorMessage = "";
	private String typeerrormessage = "";
	private String viruserrormessage = "";
	private String upload = "";
	private String uploaded = "";
	private String uploadedfile = "";
	private String uploadedfilesize = "";
	Map<String, String> data = null;

	public AttachmentsData(DataTable table) {

		this.data = table.asMap(String.class, String.class);
		if (data.containsKey("AttachmentsMessage")) {
			this.attachmentsmessage = data.get("AttachmentsMessage");
		}
		if (data.containsKey("LimitErrorMessage")) {
			this.limiterrorMessage = data.get("LimitErrorMessage");
		}
		if (data.containsKey("TypeErrorMessage")) {
			this.typeerrormessage = data.get("TypeErrorMessage");
		}
		if (data.containsKey("VirusErrorMessage")) {
			this.viruserrormessage = data.get("VirusErrorMessage");
		}
		if (data.containsKey("Upload")) {
			this.upload = data.get("Upload");
		}
		if (data.containsKey("UploadedFile")) {
			this.uploadedfile = data.get("UploadedFile");
		}
		if (data.containsKey("UploadedFileSize")) {
			this.uploadedfilesize = data.get("UploadedFileSize");
		}
	}

	public String getLimitErrorMessage() {
		return limiterrorMessage;
	}

	public String getTypeErrorMessage() {
		return typeerrormessage;
	}

	public String getVirusErrorMessage() {
		return viruserrormessage;
	}

	public String getattachmentsMessage() {
		return attachmentsmessage;
	}

	public String getUploaded() {
		return uploaded;
	}

	public String getUpload() {
		return upload;
	}

	public String getUploadedFile() {
		return uploadedfile;
	}

	public String getUploadedFileSize() {
		return uploadedfilesize;
	}

	public void setUpload(String filetobeUploaded) {
		if (AutomationBase.getOSName().toLowerCase().contains("mac")) {
			uploaded = File.separator + AutomationBase.getAbsoulteFilePath(AutomationBase
					.getFile(AutomationBase.Environment("attachMentsPath") + File.separator + filetobeUploaded));
		} else {
			uploaded = AutomationBase.getAbsoulteFilePath(AutomationBase
					.getFile(AutomationBase.Environment("attachMentsPath") + File.separator + filetobeUploaded));
		}
	}
}
