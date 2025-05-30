import java.time.Duration;
import java.time.LocalDateTime;

public class PilhaReimpressao {
    private No topo;
    private int tamanho;
    private final int capacidadeMaxima;

    public PilhaReimpressao(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.tamanho = 0;
    }

    public void push(String nomeArquivo, String nomeUsuario) {
        if (tamanho >= capacidadeMaxima) {
            throw new RuntimeException("Capacidade máxima atingida. Não é possível adicionar mais documentos.");
        }
        Documento doc = new Documento(nomeArquivo, nomeUsuario, LocalDateTime.now());
        No novo = new No(doc);
        if (!pilhaVazia()) {
            novo.setProximo(topo);
        }
        topo = novo;
        tamanho++;

        System.out.println("Solicitação registrada: " + doc);
        System.out.println("Documento adicionado ao topo da pilha.\n");
    }

    public Documento pop() {
        if (pilhaVazia())
            throw new RuntimeException("Pilha vazia, não há documento para reimprimir.");

        Documento doc = topo.getDocumento();
        LocalDateTime horarioReimpressao = LocalDateTime.now();
        Duration duracao = Duration.between(doc.getHorarioSolicitacao(), horarioReimpressao);

        System.out.println("Documento reimpresso: " + doc.getNomeArquivo());
        System.out.println("Usuário: " + doc.getNomeUsuario());
        System.out.println("Tempo desde solicitação: " + duracao.toSeconds() + " segundos.");

        topo = topo.getProximo();
        tamanho--;
        System.out.println("Documento removido do topo da pilha.\n");

        return doc;
    }

    public boolean pilhaVazia() {
        return topo == null;
    }

    public void consultarDocumento(String nomeArquivo) {
        No atual = topo;
        int posicao = 0;
        while (atual != null) {
            if (atual.getDocumento().getNomeArquivo().equals(nomeArquivo)) {
                System.out.println("Documento encontrado na posição " + posicao + " a partir do topo.");
                System.out.println("Horário da solicitação: " + atual.getDocumento().getHorarioSolicitacao());
                System.out.println("Usuário que solicitou: " + atual.getDocumento().getNomeUsuario());
                System.out.println("Detalhes: " + atual.getDocumento() + "\n");
                return;
            }
            atual = atual.getProximo();
            posicao++;
        }
        System.out.println("Documento não encontrado na pilha.");
    }

    public void exibirPilha() {
        System.out.println("Estado atual da pilha de reimpressão:");
        No atual = topo;
        int pos = 0;
        while (atual != null) {
            Documento doc = atual.getDocumento();
            System.out.println(pos + " - " + doc);
            atual = atual.getProximo();
            pos++;
        }
        System.out.println();
    }
}
