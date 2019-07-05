package br.edu.ifrs.restinga.trabprog3.demo.modelo.DAO;

import br.edu.ifrs.restinga.trabprog3.demo.modelo.entidade.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

    public List<Usuario> findAllByOrderByIdAsc();
}
