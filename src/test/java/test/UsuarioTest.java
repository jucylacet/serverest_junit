package test;

import com.github.javafaker.Faker;
import dto.*;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.base.BaseTest;

import static io.restassured.RestAssured.given;

public class UsuarioTest extends BaseTest {
    @Test
    public void listarUsuarioSucesso(){
        ListarUsuariosResponseDTO usuarios = given()
                .contentType(ContentType.JSON)
                .when()
                .get("usuarios")
                .then().statusCode(HttpStatus.SC_OK).log().all()
                .extract().as(ListarUsuariosResponseDTO.class);
        System.out.println(usuarios);
        Assertions.assertTrue(usuarios.getQuantidade() > 0);
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
                .post("/usuarios")
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
    @Test
    public void listarUsuarioIdOK(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("usuarios/0uxuPY0cbmQhpEz1")
                .then().statusCode(200)
                .log().all();
    }
    @Test
    public void listarUsuarioIdNaoExiste(){
        MensagemErroDTO msg=  given()
                .contentType(ContentType.JSON)
                .when()
                .get("usuarios/0uxuPY0cbmQhpEz2")
                .then().statusCode(400)
                .log().all()
                .extract().as(MensagemErroDTO.class);
        Assertions.assertEquals("Usuário não encontrado", msg.message());
    }
    @Test
    public void listarUsuarioIdInvalido(){
        MensagemErroDTO msg=  given()
                .contentType(ContentType.JSON)
                .when()
                .get("usuarios/0uxuPY0cbmQhpEz")// id com menos de 16 caracteres
                .then().statusCode(400)
                .log().all()
                .extract().as(MensagemErroDTO.class);
        Assertions.assertEquals( "id deve ter exatamente 16 caracteres alfanuméricos", msg.id());
    }

}