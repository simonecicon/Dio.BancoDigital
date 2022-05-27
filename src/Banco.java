import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Banco {
	private String nome;
	private List<Conta> contas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getConta() {
		return contas;
	}

	public void setConta(List<Conta> contas) {
		this.contas = contas;
	}

	

	public Set<Cliente> getCliente() {
		Set<Cliente> listaCliente = new HashSet<Cliente>();

		if (this.contas != null) {       
			for (int i = 0; i < this.contas.size(); i++) {
				//System.out.println(i + 1 + " de " + this.contas.size());
				Conta conta = this.contas.get(i);
				Cliente cliente = conta.getCliente();
				listaCliente.add(cliente);
			}
		}
		return listaCliente;
	}

}
