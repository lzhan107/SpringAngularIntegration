/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syslog.repository;

import syslog.bean.Prioritylookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lei
 */
@Repository
public interface PrioritylookupRepository extends JpaRepository<Prioritylookup, Integer>{
    
}
