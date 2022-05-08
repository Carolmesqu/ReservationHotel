
public class Hotel {
	int classificacao;
	float taxa_normal;
	float taxa_fidelidade;
	float taxa_fds_normal;
	float taxa_fds_fidelidade;
	String nome;
	
	public void inserirDados(int classificacao, float taxa_normal, float taxa_fidelidade, float taxa_fds_normal, float taxa_fds_fidelidade, String nome) {
		
		this.classificacao=classificacao;
		this.taxa_normal=taxa_normal;
		this.taxa_fidelidade=taxa_fidelidade;
		this.taxa_fds_normal=taxa_fds_normal;
		this.taxa_fds_fidelidade=taxa_fds_fidelidade;
		this.nome=nome;
			
		}
	
	

}

	