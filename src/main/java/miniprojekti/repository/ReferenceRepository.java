package miniprojekti.repository;

import miniprojekti.reference.entity.AbstractReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jani on 9.4.2015.
 */

@Repository
public interface ReferenceRepository extends JpaRepository<AbstractReference, Long> {


}
