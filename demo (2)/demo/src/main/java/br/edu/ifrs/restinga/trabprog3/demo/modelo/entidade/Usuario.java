
package br.edu.ifrs.restinga.trabprog3.demo.modelo.entidade;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Usuario {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   private String nome;
    private String nomeartistico;
    private String email;
    private String genero_musical;
    private List<Musica> album;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeartistico() {
        return nomeartistico;
    }

    public void setNomeartistico(String nomeartistico) {
        this.nomeartistico = nomeartistico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero_musical() {
        return genero_musical;
    }

    public void setGenero_musical(String genero_musical) {
        this.genero_musical = genero_musical;
    }

    public List<Musica> getAlbum() {
        return album;
    }

    public void setAlbum(List<Musica> album) {
        this.album = album;
    }
   
}
