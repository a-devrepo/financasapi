package br.com.nca.financasapi.infrastructure.runners;

import br.com.nca.financasapi.domain.entities.Tipo;
import br.com.nca.financasapi.infrastructure.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //verificar se a tabela de tipos no banco esta vazia
        if(tipoRepository.count() == 0) {

            var tipo1 = new Tipo();
            tipo1.setNome("Contas a receber");

            var tipo2 = new Tipo();
            tipo2.setNome("Contas a pagar");

            var tipo3 = new Tipo();
            tipo3.setNome("Investimentos");

            tipoRepository.save(tipo1);
            tipoRepository.save(tipo2);
            tipoRepository.save(tipo3);
        }
    }
}