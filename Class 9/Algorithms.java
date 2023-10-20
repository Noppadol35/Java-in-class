import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Algorithms {
    
    private static class ParticleExperiment {
        private List<Integer> particles;
        
        public ParticleExperiment(List<Integer> particles) {
            this.particles = particles;
        }
        
        public int getTotalEnergyFromCollisions() {
            int totalEnergy = 0;
            
            while (particles.size() > 1) {
                int maxEnergy = Integer.MIN_VALUE;
                int maxIdx = -1;

                for (int i = 0; i < particles.size() - 1; i++) {
                    int energyReleased = Math.abs(particles.get(i) - particles.get(i + 1));
                    if (energyReleased > maxEnergy) {
                        maxEnergy = energyReleased;
                        maxIdx = i;
                    }
                }

                totalEnergy += maxEnergy;
                particles.remove(maxIdx);
                particles.remove(maxIdx);
            }

            return totalEnergy;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> particles = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            particles.add(scanner.nextInt());
        }
        scanner.close();

        ParticleExperiment experiment = new ParticleExperiment(particles);
        System.out.println(experiment.getTotalEnergyFromCollisions());
    }
}
