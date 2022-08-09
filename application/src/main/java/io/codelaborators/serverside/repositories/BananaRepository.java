package io.codelaborators.serverside.repositories;

import io.codelaborators.serverside.models.Banana;
import org.springframework.data.repository.CrudRepository;

public interface BananaRepository extends CrudRepository<Banana, Long> {
}
