package onboarding.pages;

import org.openqa.selenium.WebElement;

import onboarding.dataobjects.DeleteAffiliatedHospData;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.ui.SeleniumHelper;

public class DeleteAffiliatedHospitalPage extends BasePage
{
	private String currentScreenName;

	public DeleteAffiliatedHospitalPage() {
		currentScreenName = getClassName(this.getClass());
	}
	
	public WebElement we_DEL_HSPTL_DLG_Title() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "CONFRM-DLG-TITLE")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_DEL_HSPTL_DLG_Text() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "CONFRM-DLG-Text")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_DEL_HSPTL_DLG_Cancel() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "CONFRM-DLG-Cancel-Btn")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_DEL_HSPTL_DLG_Confirm() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "CONFRM-DLG-Confirm-Btn")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	/**
	 * @param {DeleteAffiliatedHospData
	 *            data} 
	 * @return {boolean} returns True to
	 *         false
	 * @function
	 * @description The below function
	 *              is used to delete affiliated hospital record
	 * @name deleteRecord
	 */
	public boolean deleteRecord(DeleteAffiliatedHospData data)
	{
		if(!SeleniumHelper.getText(we_DEL_HSPTL_DLG_Text()).equals(data.getDeleteConfirmationText()))
		{
			return false;
		}
		if(!SeleniumHelper.clickElement(we_DEL_HSPTL_DLG_Confirm()))
		{
			return false;
		}
		return true;
	}
	
	/**
	 * @param {DeleteAffiliatedHospData
	 *            data} 
	 * @return {boolean} returns True to
	 *         false
	 * @function
	 * @description The below function
	 *              is used to canceling delete affiliated hospital record
	 * @name dontDeleteRecord
	 */
	public boolean dontDeleteRecord(DeleteAffiliatedHospData data)
	{
		if(!SeleniumHelper.getText(we_DEL_HSPTL_DLG_Text()).equals(data.getDeleteConfirmationText()))
		{
			return false;
		}
		if(!SeleniumHelper.clickElement(we_DEL_HSPTL_DLG_Cancel()))
		{
			return false;
		}
		return true;
	}
}
