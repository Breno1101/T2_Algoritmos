public class Main {
    public static void main(String[] args) throws InterruptedException {
        FilaImpressao fila = new FilaImpressao(3);

        fila.enfileira(new Documento("relatorio.pdf", "Alice"));
        Thread.sleep(1000);
        fila.enfileira(new Documento("tese.txt", "Bob"));
        Thread.sleep(1000);
        fila.enfileira(new Documento("projeto.docx", "Carol"));
        fila.enfileira(new Documento("extra.txt", "Dan")); // Deve falhar

        fila.relatorioFila();
        fila.consultarDocumento("tese.txt");

        fila.imprimirDocumento();
        fila.relatorioFila();
    }
}
