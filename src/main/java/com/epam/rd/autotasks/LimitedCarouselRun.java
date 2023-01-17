package com.epam.rd.autotasks;

public class LimitedCarouselRun extends CarouselRun{
    int runs = DecrementingCarouselWithLimitedRun.actionLimit +1;
    @Override
    public int next() {
        int count = 0;
        runs--;
        while (count < array.length && array[position %= array.length] <= 0) {
            position++;
            count++;
        }
        if (count == array.length || runs <= 0) return -1;
        return array[position++] --;
    }

    @Override
    public boolean isFinished() {
        int sum = 0;
        for (int val: array){
            sum += val;
        }
        return sum == 0 || runs <= 1;
    }
}
