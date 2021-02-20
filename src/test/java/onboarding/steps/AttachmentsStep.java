package onboarding.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import onboarding.dataobjects.AttachmentsData;
import procraft.core.utilities.automationbase.Assertions;

public class AttachmentsStep extends MasterSteps {

	@Then("^I can see the below attachment information$")
	public void verify_Attachment_Info(DataTable arg1) {
		attachmentsdata = new AttachmentsData(arg1);
		Assertions.assertTrue("Attachments Header Elements not seen", getRFPPage().verifyAttachmentsElements(attachmentsdata));
	} 
	@Then("^I can upload a document$")
	public void verify_Upload(DataTable arg1) {
		attachmentsdata = new AttachmentsData(arg1);
		Assertions.assertTrue("Documents cannot be uploaded", getRFPPage().verifyUpload(attachmentsdata));
	}
	@And("^I can see the name of the document, type, and size of the attachment RFP page$")
	public void verify_UploadedFile(DataTable arg1) {
		attachmentsdata = new AttachmentsData(arg1);
		Assertions.assertTrue("Documents uploaded are not visible", getRFPPage().verifyUploadedFileDetails(attachmentsdata));
	}
	@And("^I upload a document which exceeds limit$")
	public void upload_ErrorFile(DataTable arg1) {
		attachmentsdata = new AttachmentsData(arg1);
		Assertions.assertTrue("Documents exceeding file size cannot be uploaded", getRFPPage().verifyUpload(attachmentsdata));
	}
	@Then("^I can see file size error message$")
	public void file_Error_Message(DataTable arg1) {
		attachmentsdata = new AttachmentsData(arg1);
		Assertions.assertTrue("Documents exceeding file size error message not seen", getRFPPage().verifyLimitErrorFileMessage(attachmentsdata));
	}
	@And("^I upload a document which is not the correct type$")
	public void upload_TypeErrorFile(DataTable arg1) {
		attachmentsdata = new AttachmentsData(arg1);
		Assertions.assertTrue("Documents of incorrect file type cannot be uploaded", getRFPPage().verifyUpload(attachmentsdata));
	}
	@Then("^I can see incorrect file type error message$")
	public void file_Type_Error_Message(DataTable arg1) {
		attachmentsdata = new AttachmentsData(arg1);
		Assertions.assertTrue("Documents of incorrect file type error message not seen", getRFPPage().verifyLimitErrorFileMessage(attachmentsdata));
	}
	@And("^I upload a document which contains virus$")
	public void upload_VirusErrorFile(DataTable arg1) {
		attachmentsdata = new AttachmentsData(arg1);
		Assertions.assertTrue("Documents with virus cannot be uploaded", getRFPPage().verifyUpload(attachmentsdata));
	}
	@Then("^I can see virus file error message$")
	public void file_Virus_Error_Message(DataTable arg1) {
		attachmentsdata = new AttachmentsData(arg1);
		Assertions.assertTrue("Documents with virus error message not seen", getRFPPage().verifyVirusErrorFileMessage(attachmentsdata));
	}
}
