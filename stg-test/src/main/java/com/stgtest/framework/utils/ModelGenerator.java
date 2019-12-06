package com.stgtest.framework.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.stgtest.framework.components.Period;
import com.stgtest.framework.components.Team;
import com.stgtest.framework.models.footballfullstate.Goals;

/**
 * {@link ModelGenerator} class responsible for generating either a singular instance or list of instances for a given model/class
 * 
 * @author Vinnie-Mac
 *
 */
public class ModelGenerator {
	
	
	/**
	 * Generate a list of Goals objects which will have some pre-determined information and some randomly selected information
	 * 
	 * @param {@link Integer} amountOfGoalsToGenerate how many goals to generate
	 * @param {@link Integer} gameTimeInMinutes current time, in minutes of game-play at the moment the goal was scored
	 * @param {@link Boolean} ownGoal or not
	 * @param {@link Boolean} penalty goal or not
	 * @param {@link Period} period when the goal occurred
	 * @return
	 */
	public static List<Goals> generateAListOfGoalsForAFixture(Integer amountOfGoalsToGenerate, Integer gameTimeInMinutes, Boolean ownGoal, Boolean penalty, Period period) {
		List<Goals> listOfGeneratedGoals = new ArrayList<Goals>();
		List<Team> teamList = Arrays.asList(Team.HOME, Team.AWAY);
		
		for(int i = 0; i < amountOfGoalsToGenerate; i++) {
			listOfGeneratedGoals.add(i, new Goals.GoalsBuilder()
					.withClockTime(
							gameTimeInMinutes, 
							NumberUtils.chooseRandomNumberWithinGivenRange(10, gameTimeInMinutes))
					.withConfirmed(true)
					.withId(NumberUtils.chooseRandomNumberWithinGivenRange(1, 1000))
					.withOwnGoal(ownGoal)
					.withPenalty(penalty)
					.withPeriod(period)
					.withPlayerId(NumberUtils.chooseRandomNumberWithinGivenRange(1, 1000))
					.withTeamId(teamList.get(new Random().nextInt(teamList.size())).getTeam())
					.build());	
		}
		
		return listOfGeneratedGoals;
	}

}
