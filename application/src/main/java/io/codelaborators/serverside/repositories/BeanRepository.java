package io.codelaborators.serverside.repositories;

import io.codelaborators.serverside.models.Beans;
import org.springframework.data.repository.CrudRepository;

public interface BeanRepository extends CrudRepository<Beans, Long> {
}
