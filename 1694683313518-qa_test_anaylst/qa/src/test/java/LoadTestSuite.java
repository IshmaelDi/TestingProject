import org.apache.jmeter.config.ThreadGroup;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.reporters.ViewResultsTree;
import org.apache.jmeter.threads.SimpleThreads;

public class LoadTestSuite {

    public static void main(String[] args) {
        // Create a new Thread Group
        ThreadGroup threadGroup = new SimpleThreads(50, 100);

        // Create a new HTTP Request sampler
        HTTPSampler httpSampler = new HTTPSampler();
        httpSampler.setDomain("localhost");
        httpSampler.setPort(8080);
        httpSampler.setPath("/loan");
        httpSampler.setMethod("POST");
        httpSampler.setBody("{\n" +
                "  \"idNumber\": \"9810058384689\",\n" +
                "  \"dateOfBirth\": \"1998-10-05\",\n" +
                "  \"name\": \"Ishmael Direro\",\n" +
                "  \"surname\": \"Green\",\n" +
                "  \"bank\": \"Direro Bank\",\n" +
                "  \"bankAccountNumber\": \"1931797841\"\n" +
                "}");

        // Add the HTTP Request sampler to the Thread Group
        threadGroup.addChildElement(httpSampler);

        // Create a new View Results Tree listener
        ViewResultsTree viewResultsTree = new ViewResultsTree();

        // Add the View Results Tree listener to the Thread Group
        threadGroup.addChildElement(viewResultsTree);

        // Start the Test Plan
        threadGroup.start();
    }
}
