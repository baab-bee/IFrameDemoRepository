package com.baabbee.iframex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.baabbee.iframex.beans.UserRequest;

public interface UserRequestRepository extends CrudRepository<UserRequest, Long> {

}
