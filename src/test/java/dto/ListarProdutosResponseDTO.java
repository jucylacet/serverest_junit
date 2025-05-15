package dto;

public class ListarProdutosResponseDTO {
    private int quantidade;
    private ProdutoResponseDTO [] produtos;

    public ListarProdutosResponseDTO(){}

    public ListarProdutosResponseDTO(int quantidade, ProdutoResponseDTO[] produtos) {
        this.quantidade = quantidade;
        this.produtos = produtos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoResponseDTO[] getProdutos() {
        return produtos;
    }

    public void setProdutos(ProdutoResponseDTO[] produtos) {
        this.produtos = produtos;
    }
}
