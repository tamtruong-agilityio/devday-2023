package runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "rerun:target/serenity-reports/rerun.txt"},
        features = "src/test/resources/features",
        glue = "steps",
        snippets = CucumberOptions.SnippetType.UNDERSCORE,
        stepNotifications = true,
        dryRun = false,
        tags = "@111"
)
public class Runner {
}
