package src;

public class Conta {
    public int numConta;
    protected int tipo;
    private String dono;
    private double saldo;
    private boolean status;

    private Conta(int numConta, int tipo, String dono, double saldo, boolean status) {
        this.numConta = numConta;
        this.tipo = tipo;
        this.dono = dono;
        this.saldo = saldo;
        this.status = status;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public static Conta abrirConta(int tipo, String dono ,double valor) {
        if(tipo == 2 && valor < 50) {
            System.out.println("Valor insuficiente para abrir uma conta corrente");
            return null;
        }

        if(tipo == 1 && valor < 50) {
            System.out.println("Valor insuficiente para abrir uma conta poupança");
            return null;
        }

        int numConta = (int) Math.random() * 100;

        Conta conta = new Conta(numConta, tipo, dono, valor, true);
        System.out.println("\n Conta criada com sucesso!");

        return conta;
    }

    public void fecharConta(Conta conta) {
        if (this.getStatus() == false) {
            System.out.println("Resolva suas dívidas antes de fechar a conta!");
            return;
        }

        if (this.getSaldo() > 0) {
            System.out.println("Saque seu dinheiro antes de fechar a conta");
            return;
        }

        conta.status = false;
        System.out.println("Conta fechada com sucesso!");
    }

    public double depositar(double valor) {
        if(getStatus() == false) {
            System.out.println("Você precisa ter uma conta no banco!");
            return this.saldo;
        }

        this.saldo += valor;

        System.out.println("Depósito realizado com sucesso!");

        return this.saldo;
    }

    public double sacar(double valor) {
        if(getStatus() == false) {
            System.out.println("Você precisa ter uma conta no banco!");
            return this.saldo;
        }

        if(this.getSaldo() < valor) {
            System.out.println("Saldo insuficiente");
            return this.saldo;
        }

        this.saldo -= valor;

        System.out.println("Saque realizado com sucesso!");

        return this.saldo;
    }

    public void pagarMesal() {
        if (getStatus() == false) {
            System.out.println("Você precisa ter uma conta no banco!");
        }

        if(this.tipo == 1) {
            this.saldo -= 20;
            return;
        } else {
            this.saldo -= 12;
            return;
        }
    }
}
