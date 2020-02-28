import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.restapi.executor.Executor;

import com.restapi.response.ResponseCapture;
import com.restapi.validator.ResponseValidation;

public class RestAPIGetTest {

	@Test
	public void test() 
	{
		
		Executor e = new Executor();
		e.loadproperties();
		
		ResponseCapture response = e.makeGETCall("baseURI");
		System.out.println(response.getResponseBody());

		ResponseValidation validate = new ResponseValidation();
		Assert.assertEquals(200, response.getResponseCode());
		
         
	//	Assert.assertTrue(validate.validateResponseCode(200, response.getResponseCode()));
		Assert.assertTrue(validate.validateResponseBody(response, "baseURI"));
	}

}
