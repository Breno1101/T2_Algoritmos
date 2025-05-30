public class Main {
    public static void main(String[] args) throws InterruptedException {
        PilhaReimpressao pilha = new PilhaReimpressao(5);

        pilha.push("Relatorio1.pdf", "joao");
        Thread.sleep(1000);
        pilha.push("Contrato.docx", "maria");
        Thread.sleep(2000);
        pilha.push("NotaFiscal.xlsx", "carlos");

        pilha.consultarDocumento("Contrato.docx");
        pilha.exibirPilha();

        pilha.pop(); // remove NotaFiscal
        pilha.pop(); // remove Contrato
        pilha.exibirPilha();
    }
}
