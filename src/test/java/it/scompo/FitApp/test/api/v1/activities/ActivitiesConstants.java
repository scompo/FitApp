package it.scompo.FitApp.test.api.v1.activities;

import it.scompo.FitApp.api.v1.activities.Activity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivitiesConstants {

	public static final String TEST_NAME_NO_DATE = "no date";
	public static final String TEST_NAME_COMPLETE = "complete";

	public static final Activity ACTIVITY_TO_SAVE_NO_DATE = new Activity(
			TEST_NAME_NO_DATE);

	public static final Activity ACTIVITY_TO_SAVE_COMPLETE = new Activity();

	{
		ACTIVITY_TO_SAVE_COMPLETE.setName(TEST_NAME_COMPLETE);
		ACTIVITY_TO_SAVE_COMPLETE.setStartTime(LocalDateTime.now());
		ACTIVITY_TO_SAVE_COMPLETE.setEndTime(LocalDateTime.now());
	}

	public static final int NUM_TO_CREATE_PAGINATED = 100;

	public static final List<Activity> ACTIVITIES_TO_PAGE = new ArrayList<Activity>() {

		private static final long serialVersionUID = 1L;

		{
			for (int i = 0; i < NUM_TO_CREATE_PAGINATED; i++) {

				Activity e = new Activity("act_" + i);
				add(e);
			}
		}

	};
}
