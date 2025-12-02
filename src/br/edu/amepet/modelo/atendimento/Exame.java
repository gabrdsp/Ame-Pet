package br.edu.amepet.modelo.atendimento;

import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pet.Pet;

public class Exame extends Atendimento {
    private String tipoExame;

    public Exame(String codigo, double preco, Cliente cliente, Pet pet, String data, String tipoExame) {
        super(codigo, "Exame", preco, cliente, pet, data);
        this.tipoExame = tipoExame;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    @Override
    public String exibirInformacoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔════════════════════════════════════════════════╗\n");
        sb.append("║                     EXAME                        ║\n");
        sb.append("╠════════════════════════════════════════════════╣\n");
        sb.append(informacoesBase()).append("\n");
        sb.append(String.format("  Tipo de exame: %s\n", tipoExame));
        sb.append("╚════════════════════════════════════════════════╝\n");
        return sb.toString();
    }
}
