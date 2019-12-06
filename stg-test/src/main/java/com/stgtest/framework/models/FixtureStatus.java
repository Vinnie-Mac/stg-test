package com.stgtest.framework.models;

/**
 * {@link FixtureStatus} class responsible for containing the values of the fixture status information
 * 
 * @author Vinnie-Mac
 */
public class FixtureStatus {
	
	private Boolean displayed;
	private Boolean suspended;
	
	
	/**
	 * Basic constructor to set fixture status information
	 * 
	 * @param displayed
	 * @param suspended
	 */
	public FixtureStatus(Boolean displayed) {
		this.displayed = displayed;
	}
	
	/**
	 * @return the displayed
	 */
	public Boolean getDisplayed() {
		return displayed;
	}
	
	
	/**
	 * @return the suspended
	 */
	public Boolean getSuspended() {
		return suspended;
	}


	/**
	 * @param {@link Boolean} set the displayed value
	 */
	public void setDisplayed(Boolean displayed) {
		this.displayed = displayed;
	}


	/**
	 * @param {@link Boolean} set the suspended value based upon how the displayed value is set
	 */
	public void setSuspended(Boolean suspended) {
		if (this.displayed) {
			this.suspended = false;
		} else {
			this.suspended = true;
		}
		
	}
}
