package com.stgtest.framework.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.stgtest.framework.components.Period;
import com.stgtest.framework.components.Team;
import com.stgtest.framework.components.TeamNames;
import com.stgtest.framework.models.Fixture;
import com.stgtest.framework.models.FixtureStatus;
import com.stgtest.framework.models.footballfullstate.FootballFullState;
import com.stgtest.framework.models.footballfullstate.Goals;
import com.stgtest.framework.models.footballfullstate.Teams;

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
					.withClockTime(NumberUtils.chooseRandomNumberWithinGivenRange(10, gameTimeInMinutes), gameTimeInMinutes)
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
	
	
	/**
	 * Generate a list of two teams with HOME and AWAY associations
	 * 
	 * @return {@link List<Teams>} list of teams with HOME and AWAY associations 
	 */
	public static List<Teams> generateAListOfTwoTeamsAtRandom() {
		List<String> teamList = new LinkedList<>(
				Arrays.asList(
						TeamNames.OSTERREICH.getTeamName(),
						TeamNames.DAGENHAM_AND_REDBRIDGE.getTeamName(),
						TeamNames.MANCHESTER_UNITED.getTeamName(),
						TeamNames.GARFORTH_FC.getTeamName(),
						TeamNames.LEEDS_UNITED.getTeamName(),
						TeamNames.YORK_FC.getTeamName(),
						TeamNames.SWANSEA.getTeamName(),
						TeamNames.CARDIFF.getTeamName())
				);
		
		return pickHomeAndAwayTeams(teamList);	
	}
	
	
	/**
	 * Select two teams from a list of team names. One being a home team and the other being an away team
	 * 
	 * @param {@link List<String>} teamList list of teams to choose from
	 * @return {@link List<Teams>} two teams that are associated with HOME and AWAY
	 */
	private static List<Teams> pickHomeAndAwayTeams(List<String> teamList) {
		List<Teams> listOfTeams = new ArrayList<Teams>();
		
		String homeTeam = teamList.get(new Random().nextInt((teamList.size())));
		listOfTeams.add(new Teams(Team.HOME.getTeam(), homeTeam, Team.HOME.getTeam()));
		teamList.remove(homeTeam);
		
		String awayTeam = teamList.get(new Random().nextInt((teamList.size())));
		listOfTeams.add(new Teams(Team.AWAY.getTeam(), awayTeam, Team.AWAY.getTeam()));
		
		return listOfTeams;
		
	}

}
