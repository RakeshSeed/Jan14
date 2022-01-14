package gstcalcstepdef;

import org.testng.Assert;

import io.cucumber.java.en.*;


public class Calc_TC_1 {
	Integer a,b, c;

	@Given("two number {int}  and {int}")
	public void two_number_and(Integer int1, Integer int2) {
	    a=int1;
	    b=int2;
	}

	@When("we perform addition")
	public void we_perform_addition() {
	   c=a+b;
	}

	@Then("answer should be {int}")
	public void answer_should_be(Integer int1) {
	 Assert.assertEquals(int1, c);
	}

	@When("we perform multiplication")
	public void we_perform_multiplication() {
		c=a*b;
	}

	@When("we perform division")
	public void we_perform_division() {
		c=a/b;
	}
}
