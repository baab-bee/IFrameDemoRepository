package com.baabbee.iframex.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.baabbee.iframex.beans.Frame;

public interface FrameRepository extends CrudRepository<Frame, Long> {

	List<Frame> findBySizeAndColorAndMaterial(String size, String color, String material);

}
