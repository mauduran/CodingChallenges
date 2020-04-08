public class MonteCarloPi{

    // Unitary circle. Diameter = 1 Radius=0.5 Area = π/4
    public static double estimatePi(int N){
        int pointsInside = 0;
        int pointsOutside = 0;

        double x, y;
        for(int i=0; i<N;i++){
            x= Math.random();
            y = Math.random();

            if(x*x+y*y<1){
                pointsInside++;
            } else{
                pointsOutside++;
            }
        }


        return 4.0*pointsInside/(pointsInside+pointsOutside);
    }


    public static void main(String[] args) {
        System.out.println(String.format("%.3f",estimatePi(1500000)));
    }

}