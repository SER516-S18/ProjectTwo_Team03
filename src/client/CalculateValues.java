package client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CalculateValues {

    /**
     * Accepts the list of integers to be plotted.
     * @param values
     */


    static List<Integer> values = new ArrayList<Integer>();

    public CalculateValues(ConcurrentLinkedQueue<String> messageQueue) {
        String message = messageQueue.poll();
        String[] messages = message.split(" ");
        for (int i = 0; i < messages.length; i++) {
            try {
                values.add(Integer.parseInt(messages[i]));
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }

    }

    public CalculateValues() {

    }

    public String HighestValue(){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<values.size(); i++){
            if(values.get(i) > max){
                max = values.get(i);
            }
        } 
        System.out.println(max);
        return String.valueOf(max);
    }


    public String LowestValue(){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<values.size(); i++){
            if(values.get(i) < min){
                min = values.get(i);
            }
        }
        return String.valueOf(min);
    }

    public String AverageValue(){
        int avg = 0;
        if(values.size() != 0) {
            for(int i=0; i<values.size(); i++){
                avg+= values.get(i);
            }
            avg=avg/values.size();
            return String.valueOf(avg);
        }
        return "0";
    }
}
