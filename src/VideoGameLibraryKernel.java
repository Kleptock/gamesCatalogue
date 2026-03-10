//package components.videogamelibrary;

import components.standard.Standard;

/**
 * Video game library kernel components with primary methods. Library stores
 * video games with information including title, developer, genre, release year,
 * and completion status.
 */
public interface VideoGameLibraryKernel extends Standard<VideoGameLibrary> {

    /**
     * Adds a new game to the library.
     *
     * @param title
     *            the title of the game.
     * @param developer
     *            the developer of the game.
     * @param genre
     *            the genre of the game.
     * @param year
     *            the release year of the game.
     */
    void addGame(String title, String developer, String genre, int year);

    /**
     * Removes and returns the game with the given title from this library.
     *
     * @param title
     *            the title of the game to remove.
     * @return the game entry that was removed
     */
    GameEntry removeGame(String title);

    /**
     * Reports whether the library contains a game with a given title.
     *
     * @param title
     *            the title to check for.
     * @return true if a game with the given title is in the library.
     */
    boolean containsGame(String title);

    /**
     * Reports the number of games in the library.
     *
     * @return the number of games in the library.
     */
    int size();

    /**
     * Game entry interface for representing individual games.
     */
    interface GameEntry {

        /**
         * Returns the title of the game.
         *
         * @return the title.
         */
        String getTitle();

        /**
         * Returns the developer of the game.
         *
         * @return the developer.
         */
        String getDeveloper();

        /**
         * Returns the genre of the game.
         *
         * @return the genre.
         */
        String getGenre();

        /**
         * Returns the release year the game.
         *
         * @return the release year.
         */
        int getYear();

        /**
         * Reports whether the game is completed.
         *
         * @return true if the game is completed.
         */
        boolean isCompleted();
    }
}
