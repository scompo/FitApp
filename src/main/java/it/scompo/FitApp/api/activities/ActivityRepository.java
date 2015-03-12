package it.scompo.FitApp.api.activities;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "activities", path = "activities")
public interface ActivityRepository extends PagingAndSortingRepository<Activity, Long>{

}
