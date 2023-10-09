package za.co.loans;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoanRestAssuredTest {

    private static final String LOAN_API_ENDPOINT = "http://localhost:8080/loan";

    @Test
    public void testSuccessfulLoanApplication() {
        // Create a new loan application request
        LoanApplicationRequest loanApplicationRequest = new LoanApplicationRequest();
        loanApplicationRequest.setIdNumber("9810057157326");
        loanApplicationRequest.setDateOfBirth("1998-10-05");
        loanApplicationRequest.setName("Ishmael Direro");
        loanApplicationRequest.setName("Green");
        loanApplicationRequest.setBank("Scrum Bank");
        loanApplicationRequest.setBankAccountNumber("153455780");

        // Send the loan application request to the REST API
        Response response = given()
                .contentType("application/json")
                .body(loanApplicationRequest)
                .post(LOAN_API_ENDPOINT);

        // Assert that the loan application was successful
        response.then()
                .assertThat()
                .statusCode(200)
                .body("message", equalTo("Loan application successful"));
    }

    @Test
    public void testFailedLoanApplicationInvalidIDNumber() {
        // Create a new loan application request with an invalid ID number
        LoanApplicationRequest loanApplicationRequest = new LoanApplicationRequest();
        loanApplicationRequest.setIdNumber("19360128919");
        loanApplicationRequest.setDateOfBirth("1936-01-28");
        loanApplicationRequest.setName("John");
        loanApplicationRequest.setName("Smith");
        loanApplicationRequest.setBank("Scrum Bank");
        loanApplicationRequest.setBankAccountNumber("1931197892");

        // Send the loan application request to the REST API
        Response response = given()
                .contentType("application/json")
                .body(loanApplicationRequest)
                .post(LOAN_API_ENDPOINT);

        // Assert that the loan application failed
        response.then()
                .assertThat()
                .statusCode(400)
                .body("message", equalTo("Invalid ID number"));
    }
}






