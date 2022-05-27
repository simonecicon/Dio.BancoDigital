import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		List<Conta> listaConta = new ArrayList<Conta>();
		Banco banco = new Banco();
		int quantidadeContas;
		String entrada = "";
		quantidadeContas = Integer.parseInt(JOptionPane.showInputDialog("Quantas contas tem cadastro?"));

		for (int i = 0; i < quantidadeContas; i++) {
			String nome = JOptionPane.showInputDialog("Entre com o seu nome: ");
			String saldo = JOptionPane.showInputDialog("Informe o saldo: ");
			String transf = JOptionPane.showInputDialog("Informe a transf: ");

			entrada = entrada + nome + "_" + saldo + "_" + transf + " ";

		}
		String[] arrNomes = entrada.split(" ");
		for (String nome : arrNomes) {
			String[] arrValores = nome.split("_");
			Cliente cliente = new Cliente();
			cliente.setNome(arrValores[0]);

			Conta cc = new ContaCorrente(cliente);
			Conta poupanca = new ContaPoupanca(cliente);
			cc.depositar(Double.parseDouble(arrValores[1]));
			cc.transferir(Double.parseDouble(arrValores[2]), poupanca);
			listaConta.add(cc);
			listaConta.add(poupanca);
			cc.imprimirExtrato();
			poupanca.imprimirExtrato();
		}
		banco.setConta(listaConta);

		Set<Cliente> clientesDoBanco = banco.getCliente();
		for (Cliente item : clientesDoBanco) {
			System.out.println("Nome cliente: " + item.getNome());
		}

		System.out.println("O banco tem " + clientesDoBanco.size() + " cliente(s)");

	}

}
