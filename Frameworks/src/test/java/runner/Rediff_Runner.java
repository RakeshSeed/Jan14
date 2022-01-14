package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features=".//Features//RediffParameter.feature",
glue= {"rediffstepdef"} ,
dryRun=false
,monochrome=true,
publish=true,
plugin={"pretty","html:.//target//rediff.html"})
public class Rediff_Runner {

}
