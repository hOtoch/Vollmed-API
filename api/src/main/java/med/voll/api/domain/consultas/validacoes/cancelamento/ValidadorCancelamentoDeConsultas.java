package med.voll.api.domain.consultas.validacoes.cancelamento;

import med.voll.api.domain.consultas.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsultas {

    void validar(DadosCancelamentoConsulta dados);
}
