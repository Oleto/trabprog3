package br.edu.ifrs.restinga.trabprog3.demo.modelo.RN;

import br.edu.ifrs.restinga.trabprog3.demo.erro.RNinvalida;
import br.edu.ifrs.restinga.trabprog3.demo.modelo.entidade.Musica;
import java.util.Locale;

public class MusicaRN {

    public void validamusica(Musica musica) {
        if (musica.getDuracao() > 60 || musica.getDuracao() < 0) {
            throw new RNinvalida("Musica com mais de 60 min ou menos de 0");
        }
        switch (musica.getGenero_musical().toLowerCase(Locale.ITALY)) {
            case "axé":
                break;
            case "blues":
                break;
            case "country":
                break;
            case "eletrônica":
                break;
            case "forró":
                break;
            case "funk":
                break;
            case "gospel":
                break;
            case "hip hop":
                break;
            case "jazz":
                break;
            case " mpb":
                break;
            case " música clássica":
                break;
            case "pagode":
                break;
            case "pop":
                break;
            case "rap":
                break;
            case "reggae":
                break;
            case "rock":
                break;
            case "samba":
                break;
            case "Sertanejo":
                break;
            default:
                throw new RNinvalida("genero musical invalido");

        }

    }

}
