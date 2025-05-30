import java.time.LocalDateTime;

public class Documento {
    private String nomeArquivo;
    private String nomeUsuario;
    private LocalDateTime horarioSolicitacao;

    public Documento(String nomeArquivo, String nomeUsuario, LocalDateTime horarioSolicitacao) {
        this.nomeArquivo = nomeArquivo;
        this.nomeUsuario = nomeUsuario;
        this.horarioSolicitacao = horarioSolicitacao;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public LocalDateTime getHorarioSolicitacao() {
        return horarioSolicitacao;
    }

    @Override
    public String toString() {
        return "Arquivo: " + nomeArquivo + ", Usuário: " + nomeUsuario + ", Solicitado em: " + horarioSolicitacao;
    }
}
