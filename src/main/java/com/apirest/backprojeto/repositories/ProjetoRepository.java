package com.apirest.backprojeto.repositories;


import java.util.List;

import com.apirest.backprojeto.models.Projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer>{

    /*@Query("SELECT obj FROM Projeto obj WHERE obj.titulo = %titulo%")
    Page<Projeto> search(@Param("titulo") String titulo,@Param("projetos") List<Projeto> projetos, Pageable pageRequest);
    */
    List<Projeto> findByTitulo(String titulo);

    List<Projeto> findByCliente(String cliente);

} 