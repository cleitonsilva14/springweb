package br.com.springweb.repositorio;


import br.com.springweb.models.Administrador;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdministradoresRepo extends CrudRepository<Administrador, Integer> {

    // SELECT CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END FROM administradores WHERE id = :id
    @Query(value = "SELECT CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END FROM administradores WHERE id = :id", nativeQuery = true)
    boolean exist(int id);


    @Query(value = "SELECT * FROM administradores WHERE email = :email AND senha = :senha", nativeQuery = true)
    Administrador Login(String email, String senha);

}
