package jeff.code.jm23899gpt.service;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;

@Service
public class GPTTestService {

    //calculate the duration of two dates
    public int calculateDuration() {
        //now time
        LocalDate now = LocalDate.now();
        //start time
        LocalDate start = LocalDate.of(2020, 1, 1);
        //calculate the duration
        Duration duration = Duration.between(start.atStartOfDay(), now.atStartOfDay());
        //return the duration in days
        return (int) duration.toDays();
    }

    //sort an array of integers by ascending order with quick sort
    public void quickSort(int[] arr, int low, int high) {
        //check if the array is empty
        if (arr == null || arr.length == 0) {
            return;
        }
        //check if the low index is less than the high index
        if (low >= high) {
            return;
        }
        //pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        //make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            //check if the left element is less than the pivot
            while (arr[i] < pivot) {
                i++;
            }
            //check if the right element is greater than the pivot
            while (arr[j] > pivot) {
                j--;
            }
            //swap the elements
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        //recursively sort two sub parts
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }



}
