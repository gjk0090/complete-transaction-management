package com.gjk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gjk.domain.App;

@Repository
//no need to implement this DAO
//CrudRepository will auto implement boilerplate methods
public interface AppRepository extends CrudRepository<App, String>{
	
	// these methods will be auto created according to Spring convention
	public App findAppByAppId(@Param("appId") int appId);
	public Iterable<App> findAppsByParentAppId(@Param("appId") int appId);
}
