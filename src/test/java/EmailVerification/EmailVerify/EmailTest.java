package EmailVerification.EmailVerify;

import javax.mail.Message;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import junit.framework.Assert;

public class EmailTest {


	private static EmailUtils emailUtils;
	public class MyTests { 
	}

	  @SuppressWarnings("deprecation")
	@Before
	  public void connectToEmail() {
	    try {
	      emailUtils = new EmailUtils("email", "password", "smtp.gmail.com", EmailUtils.EmailFolder.INBOX);
	    } catch (Exception e) {
	      e.printStackTrace();
	      Assert.fail(e.getMessage());
	    }
	  }
	  
	  
	  @SuppressWarnings("deprecation")
	@Test
	  public void testTextContained() {
		    try{
//		    	if(emailUtils != null)
//		    		System.out.println(emailUtils);
		    Message email = emailUtils.getMessagesBySubject("Security", false, 5)[0];
		    Assert.assertTrue("Test Result", emailUtils.isTextInMessage(email, "New device"));
		    } catch (Exception e) {
		      e.printStackTrace();
		      Assert.fail(e.getMessage());
		    }
		  }
}
