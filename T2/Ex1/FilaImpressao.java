public class FilaImpressao {
    private No primeiro;
    private No ultimo;
    private int capacidadeMaxima;
    private int tamanhoAtual;

    public FilaImpressao(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.tamanhoAtual = 0;
    }

    public boolean filaVazia() {
        return primeiro == null;
    }

    public boolean filaCheia() {
        return tamanhoAtual >= capacidadeMaxima;
    }

    public void enfileira(Documento doc) {
        if (filaCheia()) {
            System.out.println("Fila cheia! Documento '" + doc.getNomeArquivo() + "' não pode ser adicionado.");
            return;
        }

        No novo = new No(doc);
        if (filaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProximo(novo);
        }
        ultimo = novo;
        tamanhoAtual++;
        System.out.println("Documento '" + doc.getNomeArquivo() + "' adicionado à fila.");
    }

    public void imprimirDocumento() {
        if (filaVazia()) {
            System.out.println("Fila vazia! Nenhum documento para imprimir.");
        }
        else {
            Documento doc = primeiro.getInfo();
            doc.registrarImpressao();
            System.out.println("Imprimindo: " + doc.getNomeArquivo());
            System.out.println("Tempo de espera: " + doc.tempoEsperaSegundos() + " segundos");

            primeiro = primeiro.getProximo();
            if (primeiro == null) ultimo = null;
            tamanhoAtual--;
        }
    }

    public void consultarDocumento(String nomeArquivo) {
        No runner = primeiro;
        boolean encontrado = false;
        int pos = 1;
        while (runner != null && !encontrado) {
            if (runner.getInfo().getNomeArquivo().equals(nomeArquivo)) {
                System.out.println("Documento encontrado na posição " + pos + ": " + runner.getInfo());
                encontrado = true;
            }
            else {
                runner = runner.getProximo();
                pos++;
            }
        }
        if (!encontrado) {
            System.out.println("Documento '" + nomeArquivo + "' não encontrado na fila.");
        }
    }

    public void relatorioFila() {
        System.out.println("\n--- Relatório Atual da Fila ---");
        if (filaVazia()) {
            System.out.println("Fila está vazia.");
        } else {
            No runner = primeiro;
            int pos = 1;
            while (runner != null) {
                System.out.println(pos + ". " + runner.getInfo());
                runner = runner.getProximo();
                pos++;
            }
        }
        System.out.println("Capacidade: " + tamanhoAtual + "/" + capacidadeMaxima);
        System.out.println("--------------------------------");
    }
}
