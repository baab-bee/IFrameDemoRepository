package com.baabbee.iframex.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.baabbee.iframex.beans.Frame;
import com.baabbee.iframex.beans.FrameRequest;
import com.baabbee.iframex.beans.UserRequest;

public interface AdminRepository extends Repository<UserRequest,String>{

	public List<UserRequest> findByStatus(String status);

	public List<UserRequest> findByStatusIn(Collection<String> statuslist);
	
}
