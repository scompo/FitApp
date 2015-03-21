package it.scompo.FitApp.api.v1.activities.repositories;

import it.scompo.FitApp.api.v1.activities.Activity;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitiesRepository extends PagingAndSortingRepository<Activity, Long>{

}
