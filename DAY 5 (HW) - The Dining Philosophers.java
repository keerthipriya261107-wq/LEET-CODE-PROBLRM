import java.util.concurrent.Semaphore;

class DiningPhilosophers {

    private final Semaphore[] forks = new Semaphore[5];
    private final Semaphore eatingLimiter = new Semaphore(4); // at most 4 can try to eat

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 4) % 5; // (philosopher - 1 + 5) % 5

        eatingLimiter.acquire();       // limit concurrent eaters to 4
        forks[left].acquire();
        forks[right].acquire();

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();

        forks[left].release();
        forks[right].release();
        eatingLimiter.release();
    }
}
