import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
    //ATRIBUTOS
    private String titular;
    private double depositoInicial; //futuramente trocar pra bigDecimal todos os doble usado em valores em reais...
    private double chequeEspecial;
    private double saldo; //feito

    private List<String> historico = new ArrayList<>();
    //CONSTRUTOR
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.depositoInicial = saldoInicial;
        this.saldo = saldoInicial;
        historico.add("Conta aberta com depósito inicial de R$" + saldoInicial);
        if (depositoInicial <= 500.00) {
            chequeEspecial = 50.00;
        } else {
            chequeEspecial = depositoInicial / 2;
        }
    };

    // ATENÇÃO: Se alterar a lógica aqui, alterar também em pagarBoleto()
    public void sacar(double saque) {
        var taxa = (saque - saldo) * 0.20;
        if (saque > (saldo + (chequeEspecial - taxa))) {
            System.out.println("Saldo não disponivel");
        } else if ( saldo < saque) {
            saldo = saldo - saque - taxa;
            System.out.println("você entrou no cheque especial seu saldo atual e de " + saldo);
            historico.add("Saque de R$" + saque + " | Saldo: " + saldo);
        } else {
            saldo = saldo - saque;
            System.out.println("Saque realizado com sucesso seu saldo atual e de " + saldo);
            historico.add("Saque de R$" + saque + " | Saldo: " + saldo);
        }
    };

    public void depositar(double deposito) {
        saldo = deposito + saldo;
        historico.add("Depósito de R$" + deposito + " | Saldo: " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void verExtato() {
        System.out.println("Seu saldo atual e de: " + getSaldo());
        double chequeDisp = chequeEspecial + saldo;
        if (getSaldo() > 0) {
            chequeDisp = getChequeEspecial();
        };
        System.out.println("Cheque especial disponivel: " + chequeDisp);

        int inicio = Math.max(0, historico.size() - 10);
        for (int i = inicio; i < historico.size(); i++) {
            System.out.println(historico.get(i));
        }
    };

    public void pagarBoleto(double valorBoleto) {
        var taxa = (valorBoleto - saldo) * 0.20;
        if (valorBoleto > (saldo + (chequeEspecial - taxa))) {
            System.out.println("Saldo não disponivel");
        } else if ( saldo < valorBoleto) {
            saldo = saldo - valorBoleto - taxa;
            System.out.println("Boleto pago, mas você entrou no cheque especial! saldo atual:" + saldo);
            historico.add("Boleto pago de R$" + valorBoleto + " | Saldo: " + saldo);
        } else {
            saldo = saldo - valorBoleto;
            System.out.println("Boleto pago com sucesso seu saldo atual e de " + saldo);
            historico.add("Boleto pago de R$" + valorBoleto + " | Saldo: " + saldo);
        }
    }
}
