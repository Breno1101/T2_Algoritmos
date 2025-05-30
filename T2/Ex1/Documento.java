import java.time.LocalDateTime;

public class Documento {
    private String nomeArquivo;
    private String usuario;
    private LocalDateTime horaSolicitacao;
    private LocalDateTime horaImpressao;

    public Documento(String nomeArquivo, String usuario) {
        this.nomeArquivo = nomeArquivo;
        this.usuario = usuario;
        this.horaSolicitacao = LocalDateTime.now();
    }

    public void registrarImpressao() {
        this.horaImpressao = LocalDateTime.now();
    }

    public long tempoEsperaSegundos() {
        return java.time.Duration.between(horaSolicitacao, horaImpressao).getSeconds();
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public LocalDateTime getHoraSolicitacao() {
        return horaSolicitacao;
    }

    @Override
    public String toString() {
        return "Arquivo: " + nomeArquivo + ", Usuário: " + usuario + ", Solicitado: " + horaSolicitacao;
    }
}
