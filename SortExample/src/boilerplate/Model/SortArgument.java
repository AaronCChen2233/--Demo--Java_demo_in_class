package boilerplate.Model;

import java.util.ArrayList;
import java.util.Arrays;

import static boilerplate.View.BaseView.log;

public class SortArgument extends Argument {
    public SortArgument(ArrayList<String> argument, boolean hasParamaters, boolean requiresParamaters, String description, ArrayList<String> paramaters) {
        super(argument, hasParamaters, requiresParamaters, description, paramaters);
    }

    @Override
    public void DoFunction() {

    }

    public void SelectionSort(){

        // string conver to numbersArray
        int[] numbersArray = getIntArrayFromParamaters();

        int theLeastNumber;
        int l = numbersArray.length;

        for(int i=0; i < l; i++)
        {
            theLeastNumber = numbersArray[i];

            //o is the original position
            int o = i;

            //only compare number which are left, so "j=i+1"
            for(int j = i+1; j<l; j++)
            {
                //here will compare and find the least number
                if(numbersArray[j] < theLeastNumber){
                    theLeastNumber = numbersArray[j];

                    //keep the least number position
                    o = j;
                }
            }
            if(o!=i){
                swap(numbersArray, o, i);
            }
        }
        log(1,"Selection sorted: "+ Arrays.toString(numbersArray));
    }

    public void QuickSort() {
        int l = paramaters.size();
        int startPosition = 0;
        int[] numbersArray;
        /*corvert to int array*/

        numbersArray = getIntArrayFromParamaters();

        //Do quick Sort here
        recursiveQuickSort(numbersArray, startPosition, l - 1);

        log(1,"Quick sorted: "+ Arrays.toString(numbersArray));
    }

    private int[] getIntArrayFromParamaters() {
        int[] numbersArray;
        String[] itemsArray = new String[paramaters.size()];
        itemsArray = paramaters.toArray(itemsArray);
        numbersArray = new int[paramaters.size()];

        for (int i = 0; i < itemsArray.length; i++) {
            numbersArray[i] = Integer.parseInt(itemsArray[i]);
        }
        return numbersArray;
    }

    public void recursiveQuickSort(int[] array, int start, int pivot) {
        int o = start;

        //for loop will scan from positon start to pivot(because we use last number as pivot so now pivot is the end)
        for (int i = start; i < pivot; i++) {
            //compare positon i number is smaller than pivot or not if so swap to position o
            if (array[i] < array[pivot]) {

                if (i != o) {
                    swap(array, o, i);
                }

                // then position o go to next
                o++;
            }
        }

        if (o != pivot) {
            //after scan then swap pivot to position o
            swap(array, o, pivot);
        }

        //if (o-start) more than 1 which mean before it already do some swap.
        // the number before "pivot" may haven't sort yet
        if ((o - start) > 1) {
            //so call this function again put same array but change the pivot
            recursiveQuickSort(array, start, o - 1);
        }

        //if (pivot - o) bigger than 1 which mean the greater part haven't sort
        if ((pivot - o) > 1) {
            //so call this function again put same array but change the position start
            recursiveQuickSort(array, o + 1, pivot);
        }
    }

    private void swap(int[] array, int o, int i) {
        //swap position o and position i
        int oNumber = array[o];
        array[o] = array[i];
        array[i] = oNumber;
    }
}
