package br.edu.ifrs.restinga.trabprog3.demo.controle;

import br.edu.ifrs.restinga.trabprog3.demo.erro.RNinvalida;
import br.edu.ifrs.restinga.trabprog3.demo.erro.naoencontrado;
import br.edu.ifrs.restinga.trabprog3.demo.modelo.DAO.MusicaDao;

import br.edu.ifrs.restinga.trabprog3.demo.modelo.DAO.UsuarioDAO;
import br.edu.ifrs.restinga.trabprog3.demo.modelo.RN.MusicaRN;
import br.edu.ifrs.restinga.trabprog3.demo.modelo.entidade.Musica;
import br.edu.ifrs.restinga.trabprog3.demo.modelo.entidade.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cadastrarUsuario", method = RequestMethod.POST)
@ResponseStatus(HttpStatus.CREATED)
public class UsuarioController {

    @Autowired
    UsuarioDAO usuariodao;
    @Autowired
    MusicaDao musicadao;
    @Autowired
    MusicaRN musicarn;

    public Usuario cadastrar(@RequestBody Usuario user) {
        if (user.getNome().trim().isEmpty() || user.getNomeartistico().trim().isEmpty() || user.getEmail().trim().isEmpty() || user.getGenero_musical().trim().isEmpty() || user.getAlbum().isEmpty()) {
            throw new RNinvalida("Todos Os campos são obrigatorios");
        } else {
            if (user.getAlbum() != null) {

                List<Musica> album = user.getAlbum();

                ArrayList<Musica> musicabanco = new ArrayList<>();

                for (Musica musica : album) {
                    if (musica.getNome().equals(album.lastIndexOf(musica))) {
                    }
                    musicarn.validamusica(musica);

                    musicabanco.add(musicadao.save(musica));
                }
                user.setAlbum(musicabanco);
            }
            Usuario userbanco = usuariodao.save(user);
            return userbanco;
        }

    }

    @RequestMapping(path = "/mostrarusuarios", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Usuario> listarusuarios() {
        return usuariodao.findAllByOrderByIdAsc();
    }

    @RequestMapping(path = "/recuperarUsuario", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscar(@RequestParam int id) {
        final Optional<Usuario> findById = usuariodao.findById(id);
        if (findById.isPresent()) {
            return findById.get();
        } else {
            throw new naoencontrado("ID não encontrada!");
        }
    }

    @RequestMapping(path = "/apagarUsuario", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagar(@RequestParam int id) {
        if (usuariodao.existsById(id)) {
            usuariodao.deleteById(id);
        } else {
            throw new naoencontrado("ID não encontrada!");
        }

    }
}
