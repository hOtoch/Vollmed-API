package med.voll.api.domain.consultas.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consultas.ConsultaRepository;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var validador = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), dados.data().withHour(7), dados.data().withHour(18));
        if(validador){
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
        }
    }
}
