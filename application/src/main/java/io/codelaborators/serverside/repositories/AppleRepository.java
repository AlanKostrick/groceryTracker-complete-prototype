package io.codelaborators.serverside.repositories;

import io.codelaborators.serverside.models.Apple;
import org.springframework.data.repository.CrudRepository;

public interface AppleRepository extends CrudRepository<Apple, Long> {
}
