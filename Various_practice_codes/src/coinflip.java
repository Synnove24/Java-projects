public class coinflip {
    public static void main(String[] args) {
        int flips = Integer.parseInt(args[0]); // Flip coin n times
        int num_person = Integer.parseInt(args[1]);
        // Variables to keep track of worst ratio and corresponding person
        double worst_ratio = 1;
        int worst_person = -1;

        for (int j = 0; j < num_person; j++) { // Loop through each person
            int i = 0;
            int heads = 0;
            while (i < flips) { // Simulate flips for each person
                double flip = Math.random();
                if (flip >= 0.5) {
                    heads++;
                }
                i++;
            }
            // Calculate ratio of heads to total flips for current person
            double ratio = (double) heads / flips;
            if (ratio < worst_ratio) { // Update worst ratio and person if necessary
                worst_ratio = ratio;
                worst_person = j;
            }
        }
        System.out.println("Congratulations, person " + worst_person + " has the worst ratio of " + worst_ratio);
    }
}
