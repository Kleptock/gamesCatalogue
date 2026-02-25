import java.util.HashMap;
import java.util.Map;

import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class VideoGameLibrary {

    private Map<String, Game> games;

    private static class Game {
        String title;
        String developer;
        String genre;
        int year;
        boolean completed;

        Game(String title, String developer, String genre, int year) {
            this.title = title;
            this.developer = developer;
            this.genre = genre;
            this.year = year;
            this.completed = false;
        }

        @Override
        public String toString() {
            return this.title + " (" + this.developer + ", " + this.genre + ", "
                    + this.year + ") Completed: " + this.completed;
        }
    }

    /**
     * Kernel Methods.
     */

    public VideoGameLibrary() {
        this.games = new HashMap<>();
    }

    public void addGame(String title, String developer, String genre,
            int year) {
        this.games.put(title, new Game(title, developer, genre, year));
    }

    public Game removeGame(String title) {
        return this.games.remove(title);
    }

    public boolean containsGame(String title) {
        return this.games.containsKey(title);
    }

    public int size() {
        return this.games.size();
    }

    /**
     * Secondary Methods.
     */

    public void markAsComplete(String title) {
        if (this.games.containsKey(title)) {
            this.games.get(title).completed = true;
        }
    }

    public Sequence<Game> getGameByDeveloper(String developer) {
        Sequence<Game> result = new Sequence1L<>();
        for (Game g : this.games.values()) {
            if (g.developer.equals(developer)) {
                result.add(result.length(), g);
            }
        }
        return result;
    }

    public Sequence<Game> getCompletedGames() {
        Sequence<Game> result = new Sequence1L<>();
        for (Game g : this.games.values()) {
            if (g.completed) {
                result.add(result.length(), g);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        VideoGameLibrary library = new VideoGameLibrary();

        library.addGame("Elden Ring", "FromSoftware", "RPG", 2022);
        library.addGame("Sekiro", "FromSoftware", "Action", 2019);
        library.addGame("The Last of Us", "Naughty Dog", "Adventure", 2013);
        library.addGame("Sid Meier's Civilization Six", "Firaxis", "Strategy",
                2016);

        library.markAsComplete("Elden Ring");

        out.println("Library Size: " + library.size());
        out.println();

        out.println("Games by FromSoftware: ");
        Sequence<Game> fromSoft = library.getGameByDeveloper("FromSoftware");
        for (int i = 0; i < fromSoft.length(); i++) {
            out.println(fromSoft.entry(i));
        }

        out.println("Completed Games: ");
        Sequence<Game> completed = library.getCompletedGames();
        for (int h = 0; h < completed.length(); h++) {
            out.println(completed.entry(h));
        }

        in.close();
        out.close();
    }
}