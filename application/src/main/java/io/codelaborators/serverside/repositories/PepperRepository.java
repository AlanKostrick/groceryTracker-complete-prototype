package io.codelaborators.serverside.repositories;

import io.codelaborators.serverside.models.Pepper;
import org.springframework.data.repository.CrudRepository;

public interface PepperRepository extends CrudRepository<Pepper, Long> {
}
