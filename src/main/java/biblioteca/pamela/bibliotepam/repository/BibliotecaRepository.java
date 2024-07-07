package biblioteca.pamela.bibliotepam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import biblioteca.pamela.bibliotepam.dominio.BibliotecaModel;

public interface BibliotecaRepository extends JpaRepository<BibliotecaModel, Long>{

}
