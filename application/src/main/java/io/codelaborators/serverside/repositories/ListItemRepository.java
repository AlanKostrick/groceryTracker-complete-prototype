package io.codelaborators.serverside.repositories;

import io.codelaborators.serverside.models.ListItem;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ListItemRepository extends CrudRepository<ListItem, Long> {
    Optional<ListItem> findByName(String itemName);
}
