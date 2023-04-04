package algorythms;

import java.util.Arrays;

public class SieveOfEratosthenes {

    private boolean[] primes;
    private int n;

    public SieveOfEratosthenes(int n) {
        this.n = n;
        primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        sieve();
    }

    private void sieve() {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = i + i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            if (primes[i])
                System.out.print(i + " ");
        }
    }
}
