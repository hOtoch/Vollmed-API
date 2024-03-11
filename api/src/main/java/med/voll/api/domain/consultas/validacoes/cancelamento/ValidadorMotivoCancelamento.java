package med.voll.api.domain.consultas.validacoes.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consultas.DadosCancelamentoConsulta;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMotivoCancelamento implements ValidadorCancelamentoDeConsultas {

    public void validar(DadosCancelamentoConsulta dados){
        if(dados.motivo() == null){
            throw new ValidacaoException("Motivo do cancelamento é obrigatório!");
        }
    }

}
