package com.stgtest.framework.models;

/**
 * {@link Fixture} class containing the Fixture object values and the FixtureBuilder used to construct a new fixture if
 * needing to create one in the system/database
 */
public class Fixture {

    //is this string or integer from json though?
    Integer fixtureid;
    private String name;
    private String stuff;
    private String moreStuff;


    /**
     * Get the value of {@link #fixtureid}
     *
     * @return {@link Integer}
     */
    public Integer getId()
    {
        return fixtureid;
    }


    /**
     * Get the value of {@link #name}
     *
     * @return {@link String}
     */
    public String getName()
    {
        return name;
    }


    /**
     * Get the value of {@link #stuff}
     *
     * @return {@link String}
     */
    public String getstuff()
    {
        return stuff;
    }


    /**
     * Get the value of {@link #moreStuff}
     *
     * @return {@link String}
     */
    public String getMoreStuff()
    {
        return moreStuff;
    }


    /**
     * {@link FixtureBuilder} builder pattern to create a Fixture instance more easily - use with POSt request and place
     * into the body parameter
     */
    public static class FixtureBuilder {
        //TODO Do the builder and make sure you have all the other fields here also pal!
        private String name;
        private String stuff;
        private String moreStuff;


        /**
         * FixtureBuilder constructor with mandatory field set of adding the 'name' otherwise the API will not allows a
         * fixture to be create without this value being set
         *
         * @param name {@link String} value of the fixture name
         */
        public FixtureBuilder(String name) {
            this.name = name.toLowerCase();//is this right? what about spaces?
        }


        /**
         * Apply STUFF value
         *
         * @param stuff {@link String}
         * @return {@link FixtureBuilder}
         */
        public FixtureBuilder withSTUFF(String stuff) {
            this.stuff = stuff;
            return this;
        }

        /**
         * Apply MORESTUFF value
         *
         * @param moreStuff {@link String}
         * @return {@link FixtureBuilder}
         */
        public FixtureBuilder withMORESTUFF(String moreStuff) {
            this.moreStuff = moreStuff;
            return this;
        }


        /**
         * Build the Fixture instance after setting all needed values to the fixture fields that are called upon
         *
         * @return {@link Fixture}
         */
        public Fixture build() {
            Fixture fixture = new Fixture();

            fixture.name = this.name;
            fixture.stuff = this.stuff;
            fixture.moreStuff = this.moreStuff;

            return fixture;
        }
    }
}
