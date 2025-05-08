package test;

import com.github.javafaker.Faker;
import dto.request.LoginRequestDTO;
import dto.response.LoginResponseDTO;
import dto.request.UsuarioRequestDTO;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

// Alt + enter converte o restassured em uma classe estática
import static io.restassured.RestAssured.*;

public class LoginTest {
    @Test
    public void listarUsuarioSucesso(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("usuarios")
                .then().statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void realizarCadastroUsuario(){
        UsuarioRequestDTO usuarioDTO = new UsuarioRequestDTO();
        Faker faker = new Faker();
        usuarioDTO.setAdministrador("true");
        usuarioDTO.setEmail(faker.internet().emailAddress());
        usuarioDTO.setNome(faker.name().fullName());
        usuarioDTO.setPassword("12345");

        given()
                .contentType(ContentType.JSON).log().all()
                .body(usuarioDTO)
                .when()
                .post("usuarios")
                .then().statusCode(201).log().all();


        LoginRequestDTO loginDTO = new LoginRequestDTO(usuarioDTO.getEmail(), usuarioDTO.getPassword());
        LoginResponseDTO loginResponseDto = new LoginResponseDTO();
        loginResponseDto = given().contentType(ContentType.JSON)
                .body(loginDTO)
                .when().post("login")
                .then().statusCode(200).log().all()
                .extract().as(LoginResponseDTO.class);
        Assertions.assertNotNull(loginResponseDto.getAuthorization());
        Assertions.assertEquals("Login realizado com sucesso", loginResponseDto.getMessage());
    }
    // Pra buscar apenas um unico dado
    //.extract().jsonPath().get("authorization")

    @Test
    public void listarUsuarioId(){
        given()
                .contentType(ContentType.JSON)
                .when()
                //Depois que cria o Usuario Utils na classe utilitarios como pre teste
               // .get("usuarios/{id}", UsuarioUtils.getUsuarioValido())
                .then().statusCode(200)
                .log().all();
    }


    //Tanto faz o BeforeAll vir antes ou depois dos testes, o java não lê os Assertions de forma ordenada
    @BeforeAll
    public static void beforAll(){
        baseURI = "https://serverest.dev/";
    }
}
