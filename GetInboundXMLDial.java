// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package avayacpaas.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;

/**
 * This method will create and return a URL hosting InboundXML for <Dial> tag.
 * 
 * It will add the following HTTP Parameters:
 * -- Number: Number to dial
 * -- CallbackURL: URL requested when the dialed call connects and ends
 * -- Method: Method used to request the action URL.
 * -- Confirm Sound: Boolean value specifying if a sound should play when dial is successful. 
 * -- Record: Specifies if this call should be recorded.
 * -- Record Direction: Specifies which stream of call audio to record.
 */
public class GetInboundXMLDial extends CustomJavaAction<java.lang.String>
{
	private java.lang.String defaultUrl;
	private java.lang.String number;
	private java.lang.String callbackURL;
	private avayacpaas.proxies.HttpMethod method;
	private java.lang.Boolean confirmSound;

	public GetInboundXMLDial(IContext context, java.lang.String defaultUrl, java.lang.String number, java.lang.String callbackURL, java.lang.String method, java.lang.Boolean confirmSound)
	{
		super(context);
		this.defaultUrl = defaultUrl;
		this.number = number;
		this.callbackURL = callbackURL;
		this.method = method == null ? null : avayacpaas.proxies.HttpMethod.valueOf(method);
		this.confirmSound = confirmSound;
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE

		// Return default URL if already exists
		if (this.defaultUrl != null && this.defaultUrl.length() > 0) {
			return this.defaultUrl;
		}

		// Generate new URL if empty
		StringBuilder urlDial = new StringBuilder(avayacpaas.proxies.constants.Constants.getINBOUND_XML_BASE_URL_DIAL());

		urlDial.append("?Number=" + this.number);

		if (this.callbackURL != null && this.callbackURL.length() > 0) {
			urlDial.append("&CallbackUrl=" + this.callbackURL);
		}
		if (this.method != null) {
			urlDial.append("&Method=" + this.method.name());
		}
		if (this.confirmSound != null) {
			urlDial.append("&ConfirmSound=" + this.confirmSound);
		}

		return urlDial.toString();
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GetInboundXMLDial";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}