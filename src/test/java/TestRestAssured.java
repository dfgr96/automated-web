import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRestAssured {

    @Test
    public void testApi() {
        RestAssured.baseURI = "https://api-staging.bancodebogota.co";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.contentType(ContentType.JSON);
        httpRequest.header("content-type", "application/json");
        httpRequest.body("{\n" +
                "    \"specificProductInfo\": {\n" +
                "        \"age\": 25,\n" +
                "        \"firstName\": \"DAVID\",\n" +
                "        \"firstLastName\": \"GOMEZ\",\n" +
                "        \"identificationNumber\": \"1018445501\",\n" +
                "        \"identificationType\": \"C\",\n" +
                "        \"idRequest\": 162828,\n" +
                "        \"databaseId\": 44119,\n" +
                "        \"jobId\": 1,\n" +
                "        \"codCiiu\": \"0010\",\n" +
                "        \"income\": 3900000,\n" +
                "        \"birthDate\": \"1996-12-19\",\n" +
                "        \"estrategiaMarcaTC\": 1,\n" +
                "        \"prodSoliTarjeta1Convenio\": 14,\n" +
                "        \"disableCaptcha\": true,\n" +
                "        \"requestUuid\": \"caa9cf9b-0e8f-4995-a98b-51122417938d\",\n" +
                "        \"redirect-pilot\": true,\n" +
                "        \"Journey\": \"TC_Bines_Digital\",\n" +
                "        \"AppName\": \"TarjetaDeCredito\",\n" +
                "        \"originId\": \"12\",\n" +
                "        \"convenio\": \"digital\",\n" +
                "        \"sellerId\": \"1033738937\",\n" +
                "        \"mediumType\": \"1\",\n" +
                "        \"selfManagement\": null,\n" +
                "        \"ipFromLauncher\": \"10.59.36.62\",\n" +
                "        \"channel\": \"Aliado\"\n" +
                "    },\n" +
                "    \"utmInfo\": {}\n" +
                "}");
        Response response = httpRequest.post("/api/authentication/dispatcher");
        JsonPath jsonPathEvaluator = response.jsonPath();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
        System.out.println("StatusCode: " + statusCode);
        String uuid = jsonPathEvaluator.get("uuid");
        System.out.println(uuid);
    }
}
