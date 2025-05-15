package test;

import com.github.javafaker.Faker;
import dto.ListarUsuariosResponseDTO;
import dto.LoginRequestDTO;
import dto.LoginResponseDTO;
import dto.UsuarioRequestDTO;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.base.BaseTest;

// Alt + enter converte o restassured em uma classe estática
import static io.restassured.RestAssured.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginOk() {
        LoginRequestDTO login = new LoginRequestDTO("pnpc@emailteste.com", "1234");

        LoginResponseDTO response = given()
                .contentType(ContentType.JSON).log().all()
                .body(login)
                .when()
                .post("login")
                .then().statusCode(200).log().all()
                .extract().as(LoginResponseDTO.class);

        Assertions.assertEquals( "Login realizado com sucesso", response.getMessage());
    }
    @Test
    public void loginInvalido() {
        LoginRequestDTO login = new LoginRequestDTO("pnpc@emailteste.com", "1235");

        LoginResponseDTO response = given()
                .contentType(ContentType.JSON).log().all()
                .body(login)
                .when()
                .post("login")
                .then().statusCode(401).log().all()
                .extract().as(LoginResponseDTO.class);

        Assertions.assertEquals( "Email e/ou senha inválidos", response.getMessage());
    }
}