package demo2.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo2.demo2.entity.roles;


public interface RoleRespository extends JpaRepository<roles,Integer> {
    
}
