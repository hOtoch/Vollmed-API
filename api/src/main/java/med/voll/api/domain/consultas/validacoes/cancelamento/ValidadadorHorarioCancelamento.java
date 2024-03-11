package med.voll.api.domain.consultas.validacoes.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consultas.ConsultaRepository;
import med.voll.api.domain.consultas.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadadorHorarioCancelamento implements ValidadorCancelamentoDeConsultas {

    @Autowired
    private ConsultaRepository repository;


    public void validar(DadosCancelamentoConsulta dados){
        var consulta = repository.getReferenceById(dados.idConsulta());
        var dateTimeConsulta = consulta.getData();
        var dateTimeAtual = LocalDateTime.now();

        var duracao = Duration.between(dateTimeAtual,dateTimeConsulta).toHours();

        if(duracao < 24){
            throw new ValidacaoException("Uma consulta só pode ser cancelada com 24 horas de antecedência.");
        }

    }
}
