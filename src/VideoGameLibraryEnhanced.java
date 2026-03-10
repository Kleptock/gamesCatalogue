//package components.videogamelibrary;

import components.sequence.Sequence;

/**
 * {@code VideoGameLibraryKernel} enhanced by secondary methods.
 */
public interface VideoGameLibraryEnhanced extends VideoGameLibraryKernel {
    /**
     * Marks the game with the given title as complete.
     *
     * @param title
     *            the title of the game to mark as complete.
     */
    void markAsComplete(String title);

    /**
     * Marks the game with the given title as incomplete.
     *
     * @param title
     *            the title of the game to mark as incomplete.
     */
    void markAsIncomplete(String title);

    /**
     * Returns a sequence of all games developed by a given developer.
     *
     * @param developer
     *            the developer name to search for.
     * @return a sequence of games by the given developer.
     */
    Sequence<GameEntry> getGamesByDeveloper(String developer);

    /**
     * Returns a sequence of all games in a genre.
     *
     * @param genre
     *            the genre to search for.
     * @return a sequence of games of the given genre.
     */
    Sequence<GameEntry> getGamesByGenre(String genre);

    /**
     * Returns a sequence of all completed games in the library.
     *
     * @return a sequence of completed games.
     */
    Sequence<GameEntry> getCompletedGames();

    /**
     * Returns a sequence of all incompleted games in the library.
     *
     * @return a sequence of incompleted games.
     */
    Sequence<GameEntry> getIncompletedGames();

    /**
     * Returns a sequence if all games released in a given year.
     *
     * @param year
     *            The release year to search for.
     * @return a sequence of games released in the given year.
     */
    Sequence<GameEntry> getGamesByYear(int year);

    /**
     * Reports the number of completed games in the library.
     *
     * @return the number of completed games.
     */
    int numberOfCompletedGames();

    /**
     * Reports the percentage of games that have been completed.
     *
     * @return the completion percentage (from 0.0 to 100.0).
     */
    double completionPercentage();

    /**
     * Returns the game entry for the game with the given title.
     *
     * @param title
     *            The title of the game.
     * @return the game entry with the given title.
     */
    GameEntry getGame(String title);

    /**
     * Removes all completed games from the library.
     */
    void removeAllCompletedGames();

    /**
     * Removes all games by a given developer.
     */
    void removeGamesByDeveloper();

}
