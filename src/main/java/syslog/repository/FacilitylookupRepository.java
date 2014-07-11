/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syslog.repository;

import syslog.bean.Facilitylookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lei
 */
@Repository
public interface FacilitylookupRepository extends JpaRepository<Facilitylookup, Integer>{
    
}
