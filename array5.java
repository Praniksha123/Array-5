//problem1
class Solution {
    public boolean isRobotBounded(String instructions) {
                                    //N, W, S, E
        int[][] dirs = new int[][]{{0, 1}, {-1, 0}, { 0,-1}, {1, 0}};

        int x = 0, y = 0;
        int idx = 0;

        for(char c: instructions.toCharArray()){
            if(c == 'G'){
                x += dirs[idx][0];
                y += dirs[idx][1];
            }else if(c == 'L'){
                idx = (idx + 1 ) % 4;
            }else if( c == 'R'){
                idx = (idx + 3) % 4;
            }
        }

        if((x == 0 && y == 0) || idx != 0) return true;
    
        return false;
    }
}

//problem2
import java.util.*;

class Main {

    public static void main(String[] args) {

        List<List<Double>> levels = new ArrayList<>();

        levels.add(Arrays.asList(10000.0, 0.3));
        levels.add(Arrays.asList(20000.0, 0.2));
        levels.add(Arrays.asList(30000.0, 0.1));
        levels.add(Arrays.asList(null, 0.1));

        double tax = calculateTax(levels, 45000);

        System.out.println(tax);
    }

    public static double calculateTax(List<List<Double>> levels, double salary) {

        double st = 0;
        double res = 0;

        for (int i = 0; i < levels.size(); i++) {

            Double n1 = levels.get(i).get(0);
            double n2 = levels.get(i).get(1);

            if (n1 != null && salary >= n1) {

                res += (n1 - st) * n2;
                st = n1;

            } else if (n1 != null) {

                res += (salary - st) * n2;
                break;

            } else {

                res += (salary - st) * n2;
                break;
            }
        }

        return res;
    }
}
