package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features=".//Features//Arthimetic.feature",
glue= {"gstcalcstepdef"} ,
tags="@add",    
dryRun=false
,monochrome=true,
publish=true,
plugin={"pretty","html:.//target//calc.html"})
public class Calc_Runner {
//i have changed code 
}
