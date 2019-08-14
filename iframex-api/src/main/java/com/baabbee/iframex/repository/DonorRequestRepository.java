package com.baabbee.iframex.repository;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.baabbee.iframex.beans.DonorRequest;

@Repository
public interface DonorRequestRepository extends CrudRepository<DonorRequest, Long>{
	public List<DonorRequest> findByStatus(String status);

	public List<DonorRequest> findByStatusIn(List<String> statuslist);

	
	/*@Transactional
	@Modifying
	@Query(value="UPDATE DonorRequest t SET t.status=?1 where t.id =?2",nativeQuery=true)
	public void updateAllStatus(String status,Long id);	*/
}
