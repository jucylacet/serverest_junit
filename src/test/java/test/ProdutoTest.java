package test;

import dto.ListarProdutosResponseDTO;
import dto.ListarUsuariosResponseDTO;
import dto.MensagemErroDTO;
import dto.ProdutoResponseDTO;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.base.BaseTest;

import static io.restassured.RestAssured.given;

public class ProdutoTest extends BaseTest {
    @Test
    public void listarProdutoTeste(){
        ListarProdutosResponseDTO produtos = given()
                .contentType(ContentType.JSON)
                .when()
                .get("produtos")
                .then().statusCode(HttpStatus.SC_OK).log().all()
                .extract().as(ListarProdutosResponseDTO.class);
        System.out.println(produtos);
        Assertions.assertTrue(produtos.getQuantidade() > 0);
    }
    @Test
    public void listarProdutoIdOk(){
        ProdutoResponseDTO produtos = given()
                .contentType(ContentType.JSON)
                .when()
                .get("produtos/K6leHdftCeOJj8BJ")
                .then().statusCode(HttpStatus.SC_OK).log().all()
                .extract().as(ProdutoResponseDTO.class);

    }
    @Test
    public void listarProdutoIdNaoExiste(){
        MensagemErroDTO produtos = given()
                .contentType(ContentType.JSON)
                .when()
                .get("produtos/K6leHdftCeOJj8Ba")
                .then().statusCode(HttpStatus.SC_BAD_REQUEST).log().all()
                .extract().as(MensagemErroDTO.class);
        Assertions.assertEquals("Produto não encontrado", produtos.message());

    }
    @Test
    public void listarProdutoIdInvalido(){
        MensagemErroDTO msgErro = given()
                .contentType(ContentType.JSON)
                .when()
                .get("produtos/K6leHdftCeOJj8B")
                .then().statusCode(HttpStatus.SC_BAD_REQUEST).log().all()
                .extract().as(MensagemErroDTO.class);
        Assertions.assertEquals("id deve ter exatamente 16 caracteres alfanuméricos", msgErro.id());

    }

}
