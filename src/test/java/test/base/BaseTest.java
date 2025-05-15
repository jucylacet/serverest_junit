package test.base;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class BaseTest {
    //Tanto faz o BeforeAll vir antes ou depois dos testes, o java não lê os Assertions de forma ordenada
    @BeforeAll
    public static void beforAll(){
        baseURI = "https://serverest.dev/";
    }
}
