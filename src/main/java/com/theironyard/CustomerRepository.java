package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by noellemachin on 3/9/16.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> { // <type of object stored, type of ID>

}
