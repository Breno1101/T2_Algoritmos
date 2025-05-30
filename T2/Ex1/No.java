class No {
    private Documento info;
    private No proximo;

    public No(Documento info) {
        this.info = info;
        proximo = null;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public Documento getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "[" + info.getNomeArquivo() + "]";
    }
}
