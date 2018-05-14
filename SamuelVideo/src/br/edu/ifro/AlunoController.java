/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import br.edu.ifro.modelo.Aluno;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author 01139500201
 */
public class AlunoController implements Initializable {

    @FXML
    private TextField txtNome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void salvar(ActionEvent event) {
        EntityManagerFactory ent = Persistence.createEntityManagerFactory("aula");
        EntityManager en = ent.createEntityManager();
        
        Aluno aluno1 = new Aluno();
        aluno1.setNome(txtNome.getText());
        
        en.getTransaction().begin();
        
        en.persist(aluno1);
        
        en.getTransaction().commit();
    }

    @FXML
    private void fechar(ActionEvent event) {
        Stage stage = (Stage) txtNome.getScene().getWindow();
    stage.close();
    }
    
}
