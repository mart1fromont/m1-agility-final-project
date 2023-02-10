package com.adaptionsoft.games.trivia;


import com.adaptionsoft.games.IGame;
import com.adaptionsoft.games.goodTrivia.game.ConsoleLogGame;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeTest {

    private final static int GOLDEN_TESTS = 500;

    @Test
    public void caracterizationTest() throws IOException {
        for (int seed = 1; seed < GOLDEN_TESTS; seed++) {
            testSeed(seed);
        }
    }

    private void testSeed(int seed) throws IOException {
        String expectedOutput = extractOutput(new Random(seed), new ConsoleLogGame());

        final String filepath = "src\\test\\java\\com\\adaptionsoft\\games\\trivia\\results\\" + seed + ".txt";
        final File file = new File(filepath);

        if (!file.exists()) {
            final FileWriter writer = new FileWriter(filepath);
            writer.write(expectedOutput);
            writer.close();
            assert (true);
        } else {
            // Check if the content from the original code is still the same
            final FileReader reader = new FileReader(filepath);
            final BufferedReader bufferedReader = new BufferedReader(reader);
            assertEquals(Files.readString(file.toPath()), expectedOutput);
            bufferedReader.close();
        }
    }

    private String extractOutput(Random rand, IGame aGame) {
        aGame.addPlayer("Chet");
        aGame.addPlayer("Pat");
        aGame.addPlayer("Sue");

        PrintStream old = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (PrintStream inmemory = new PrintStream(baos)) {
            // WARNING: System.out.println() doesn't work in this try {} as the sysout is captured and recorded in memory.
            System.setOut(inmemory);
            boolean notAWinner;
            do {
                aGame.roll(rand.nextInt(5) + 1);

                if (rand.nextInt(9) == 7) {
                    aGame.wrongAnswer();
                    notAWinner = true;
                } else {
                    notAWinner = aGame.correctAnswer();
                }

            } while (notAWinner);
        } finally {
            System.setOut(old);
        }

        return baos.toString();
    }
}
