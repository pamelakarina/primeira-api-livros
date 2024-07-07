package biblioteca.pamela.bibliotepam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.pamela.bibliotepam.dominio.BibliotecaModel;
import biblioteca.pamela.bibliotepam.repository.BibliotecaRepository;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public List<BibliotecaModel> listaLivros(){
        List<BibliotecaModel> listalivros = bibliotecaRepository.findAll();
        return listalivros;
    }

    public String salvarLivro(BibliotecaModel bibliotecaModel){
        bibliotecaRepository.save(bibliotecaModel);
        return "Livro cadastrado: " + bibliotecaModel.getNomeDoLivro() + " com sucesso";
    }

    public String deletarLivro(Long id){
        bibliotecaRepository.deleteById(id);
        return "Livro deletado com sucesso";
    }    

    public String atualizarLivro(Long id, BibliotecaModel novoBibliotecaModel) {
        BibliotecaModel livroAntigo = bibliotecaRepository.findById(id).get();
        livroAntigo.setGenero(novoBibliotecaModel.getGenero());
        livroAntigo.setNomeDoLivro(novoBibliotecaModel.getNomeDoLivro());
        livroAntigo.setPreco(novoBibliotecaModel.getPreco());
        bibliotecaRepository.save(livroAntigo);
        return "Livro: " + livroAntigo.getNomeDoLivro() + " atualizado com sucesso";
    }
}
