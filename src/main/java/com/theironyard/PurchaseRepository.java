package com.theironyard;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by noellemachin on 3/9/16.
 */
public interface PurchaseRepository extends CrudRepository<Purchase, Integer> { // <type of object stored, ID type>
    List<Purchase> findByCategory(String category);
}
