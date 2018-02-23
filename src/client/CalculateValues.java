package Client;

import java.util.List;

public class CalculateValues {
    
    private List<Integer> values;
    /*
     * Accepts the list of integers to be plotted.
     */
    public int HighestValue(List<Integer> values){
        this.values = values;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<values.size(); i++){
            if(values.get(i) > max){
                max = values.get(i);
            }
        }
        return max;
    }
    
    public int LowestValue(List<Integer> values){
        this.values = values;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<values.size(); i++){
            if(values.get(i) < min){
                min = values.get(i);
            }
        }
        return min;
    }
           
    public int AverageValue(List<Integer> values){
        this.values = values;
        int avg = 0;
        for(int i=0; i<values.size(); i++){
            avg+= values.get(i);
        }
        avg=avg/values.size();
        return avg;
   }
}
