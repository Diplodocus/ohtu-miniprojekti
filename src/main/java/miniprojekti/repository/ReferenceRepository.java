package miniprojekti.repository;

import miniprojekti.reference.AbstractReference;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jani on 9.4.2015.
 */
public interface ReferenceRepository extends JpaRepository<AbstractReference, Long> {


}
