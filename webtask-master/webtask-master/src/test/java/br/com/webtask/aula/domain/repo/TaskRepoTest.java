/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webtask.aula.domain.repo;

import br.com.webtask.aula.domain.model.Task;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author danig
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class TaskRepoTest {
    
    @Autowired
    private TaskRepo tasks;
    
    public TaskRepoTest() {
    }
    
    Task t1,t2;
    
    @BeforeEach
    public void init(){
        System.out.println("### Criando Base ###");
        t1 = new Task(1l,"estudar", LocalDate.now().minusDays(2),null, null);
        t2 = new Task(2l,"dormir", LocalDate.now().plusDays(5),null, null);
        
        tasks.save(t1);
        tasks.save(t2);
    }
    
    @AfterEach
    public void destroy(){
         System.out.println("### Destruindo Base ###");
        tasks.deleteAll();
    }

    @Test
    @DisplayName("Test1")
    public void testSomeMethod1() {
        //Execucar
        List<Task> tLista = tasks.findByTaskDescription("estudar");
        
        //Verificar
        Assertions.assertEquals(1, tLista.size());
    }
    
    @Test
    @DisplayName("Test2")
    public void testSomeMethod2() {
        //Execucar
        List<Task> tLista = tasks.findByTaskDescription("dormir");
        Task t = tLista.get(0);
         
        //Verificar
        Assertions.assertEquals("dormir", t.getTaskDescription());
    }
    
}
