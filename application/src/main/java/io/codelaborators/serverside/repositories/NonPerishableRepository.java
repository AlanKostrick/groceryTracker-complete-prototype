package io.codelaborators.serverside.repositories;

import io.codelaborators.serverside.models.NonPerishable;
import org.springframework.data.repository.CrudRepository;

public interface NonPerishableRepository extends CrudRepository<NonPerishable, Long> {
}
