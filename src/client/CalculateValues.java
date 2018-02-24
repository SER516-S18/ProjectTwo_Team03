package client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *@SER516 Project2_Team03
 * @Version 1.0
 */
public class CalculateValues {
    static List<Integer> values = new ArrayList<Integer>();
    
    /**
     * Constructor that converts the values received into an integer array
     * @param messageQueue a queue that contains all the values received from the server.
     */
    public CalculateValues(ConcurrentLinkedQueue<String> messageQueue) {
        ConcurrentLinkedQueue<String> newMessageQueue =  new ConcurrentLinkedQueue<String>(messageQueue);
        String message = newMessageQueue.poll();
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
    /**
     * Calculates the highest value from all the received values.
     * @return contains the highest value
     */
    public String HighestValue(){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<values.size(); i++){
            if(values.get(i) > max){
                max = values.get(i);
            }
        }
        if(max == Integer.MIN_VALUE) {    
            return "0";
        }
        return String.valueOf(max);
    }

    /**
     * Calculates the lowest value from all the received values.
     * @return contains the lowest value
     */
    public String LowestValue(){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<values.size(); i++){
            if(values.get(i) < min){
                min = values.get(i);
            }
        }
        if(min == Integer.MAX_VALUE) {
            return "0";
        }
        return String.valueOf(min);
    }
    
    /**
     * Calculates the average value from all the received values.
     * @return contains the average value
     */
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
