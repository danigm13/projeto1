/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webtask.aula.domain.model;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author danig
 */
public class TaskTest {
    
    public TaskTest() {
    }
        @Test
        @DisplayName("Verifica Projeto Atrasado")
        public void verificarTaskAtrasada(){
            //Cenario
            Task t = new Task(1l,"estudar", LocalDate.now().minusDays(2),null, null);
            
            //Executar
            EStatus status = t.getStatus();
            
            //Verificar
            Assertions.assertEquals(EStatus.ATRASADO, status);            
        }    
}
