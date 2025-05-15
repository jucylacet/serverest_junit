package dto;

public class ListarUsuariosResponseDTO {
    public ListarUsuariosResponseDTO(int quantidade, UsuarioRequestDTO[] usuarios) {
        this.quantidade = quantidade;
        this.usuarios = usuarios;
    }

    public ListarUsuariosResponseDTO(int quantidade) {
        this.quantidade = quantidade;
    }

    public ListarUsuariosResponseDTO() {
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public UsuarioRequestDTO[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(UsuarioRequestDTO[] usuarios) {
        this.usuarios = usuarios;
    }

    private int quantidade;
    private UsuarioRequestDTO [] usuarios;
}