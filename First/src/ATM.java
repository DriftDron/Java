import java.io.InputStream;
import java.util.*;

public class ATM {

    Long sum;
    int n;
    Long[] nominals;
    ArrayList<ArrayList<Long>> combinations;

    public ATM(Long sum, int n, Long[] nominals) {
        this.sum = sum;
        this.n = n;
        this.nominals = nominals;
    }

    public ATM(InputStream inputStream) {

        try {
            Scanner sc = new Scanner(inputStream);
            System.out.println("Enter a sum to be exchanged");
            sum = sc.nextLong();
            System.out.println("Enter number of banknotes");
            n = sc.nextInt();
            nominals = new Long[n];
            System.out.println("Enter banknote values");
            for (int i = 0; i < n; i++) {
                nominals[i] = sc.nextLong();
            }
            Arrays.sort(nominals);
        } catch (InputMismatchException e) {
            System.out.println("Incorrect format of data input.\n " + e.getMessage());
            throw e;
        }

        if (sum < 0) {
            throw new RuntimeException("Input value is negative");
        }

        Set<Long> set = new HashSet<>(Arrays.asList(nominals));

        if (set.size() != n) {
            throw new RuntimeException("Incorrect banknote values entered: there are duplicate nominals");
        }
    }

    public void getCombinations() throws RuntimeException {

        combinations = new ArrayList<>();
        getCombinations(new int[n], sum, 0);
        if (combinations.size() == 0) {
            throw new RuntimeException("It is impossible to exchange this amount with the presented bills");
        }
    }

    public void getCombinations(int[] counts, long amount, int index) {
        if (amount == 0) {
            ArrayList<Long> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < counts[i]; j++) {
                    list.add(nominals[i]);
                }
            }
            combinations.add(list);

        } else if (amount > 0) {
            getCombinationsLoop(counts, amount, index);
        }
    }

    public void getCombinationsLoop(int[] counts, long amount, int index) {
        counts[index]++;
        getCombinations(counts, amount - nominals[index], index);
        counts[index]--;
        if (index + 1 < n && nominals[index + 1] <= amount) {
            getCombinationsLoop(counts, amount, index + 1);
        }
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        ATM machine = new ATM(inputStream);
        machine.getCombinations();
        System.out.println("Combination options:");
        for (ArrayList<Long> x : machine.combinations) {
            System.out.println(Arrays.toString(x.toArray()));
        }
        System.out.println('\n' + "Number of combinations " + machine.combinations.size());
    }

}