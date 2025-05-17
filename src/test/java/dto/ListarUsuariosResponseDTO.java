package dto;
public class ListarUsuariosResponseDTO {
    private int quantidade;
    private UsuarioResponseDTO[] usuarios;

    public ListarUsuariosResponseDTO() {
    }

    public ListarUsuariosResponseDTO(int quantidade, UsuarioResponseDTO[] usuarios) {
        this.quantidade = quantidade;
        this.usuarios = usuarios;
    }

    public ListarUsuariosResponseDTO(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public UsuarioResponseDTO[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(UsuarioResponseDTO[] usuarios) {
        this.usuarios = usuarios;
    }

}