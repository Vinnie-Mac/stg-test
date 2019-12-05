package com.stgtest.framework.models.footballfullstate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stgtest.framework.models.Fixture;

/**
 * 
 * @author Vinnie Mac
 * 
 * {@link FootballFullState} POJO for the 'footballFullState' JSON object which resides within the {@link Fixture} JSON object
 */
public class FootballFullState {
	private String homeTeam;
	private String awayTeam;
	private Boolean finished;
	private Double gameTimeInSeconds;
	private Goals[] goals;
	private String period;
	private Possibles[] possibles;
	private Corners[] corners;
	private RedCards[] redCards;
	private YellowCards[] yellowCards;
	private String startDateTime;
	private Boolean started;
	private Teams[] teams;
}
