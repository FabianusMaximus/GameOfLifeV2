package Version_2.src;

import java.util.Arrays;

public final class GenerationSerializer
{
    public static String serialize(final int[][] generation) {
        final StringBuilder output = new StringBuilder();

        for (int[] row : generation)
            output.append(String.join(", ", Arrays.toString(row)));

        return output.toString().replace("]", "");
    }

    public static int[][] deserialize(final String serialized) {
        final int size = (int)serialized.chars().filter(c -> c == '[').count();
        final int[][] output = new int[size][size];
        final String[] rows = serialized.split("\\[");
        int i = 0;

        for (String row : Arrays.copyOfRange(rows, 1, rows.length)) {
            output[i] = Arrays.stream(row.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
            i++;
        }

        return output;
    }
}
