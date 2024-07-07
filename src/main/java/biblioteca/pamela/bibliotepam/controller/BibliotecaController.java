package biblioteca.pamela.bibliotepam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biblioteca.pamela.bibliotepam.dominio.BibliotecaModel;
import biblioteca.pamela.bibliotepam.service.BibliotecaService;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @GetMapping
    public ResponseEntity<List<BibliotecaModel>> getAll(){
        return ResponseEntity.ok().body(bibliotecaService.listaLivros());
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody BibliotecaModel bibliotecaModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecaService.salvarLivro(bibliotecaModel));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        return ResponseEntity.ok().body(bibliotecaService.deletarLivro(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody BibliotecaModel novaBibliotecaModel) {
        return ResponseEntity.ok().body(bibliotecaService.atualizarLivro(id, novaBibliotecaModel));
    }
}
