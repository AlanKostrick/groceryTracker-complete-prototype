package io.codelaborators.serverside.repositories;

import io.codelaborators.serverside.models.Perishable;
import org.springframework.data.repository.CrudRepository;

public interface PerishableRepository extends CrudRepository<Perishable, Long> {

}
