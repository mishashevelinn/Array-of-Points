package com.company;

import java.awt.Point;
import java.util.Arrays;

public class ArrayPointList implements PointList {
    private Point[] points;
    private int size;
    private int cursor;

    public ArrayPointList() {
        points = new Point[MAX_SIZE];
        size = 0;
        cursor =0;
    }

    public ArrayPointList(int maxSize) {
        points = new Point[maxSize];
        size = 0;
        cursor = 0;
    }

    @Override
    public void append(Point newPoint) throws Exception {
        int points_len = points.length;
        if (size >= points_len) {
            throw new Exception("array is full");
        }

        points[size] = newPoint;
        size++;
        if (cursor != size) {
            cursor = size - 1;
        }
    }

    @Override
    public void clear() {
        size = 0;
        cursor = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == points.length;
    }

    @Override
    public boolean goToBeginning() {
        if(isEmpty()){return false;}
        cursor = 0;
        return true;
        }

    @Override
    public boolean goToEnd() {
        if (!isEmpty()) {
            cursor = size - 1;
            return true;
        }
        return false;
    }

    @Override
    public boolean goToNext() {
        if (cursor < size - 1) {
            cursor++;
            return true;
        }
        return false;
    }


    @Override
    public boolean goToPrior() {
        if(cursor != 0){
            cursor--;
            return true;
        }
        return false;

    }

    @Override
    public Point getCursor() {
        if(isEmpty())
            return null;
        return new Point(points[cursor].x, points[cursor].y );
    }

    @Override
    public String toString() {
        if (size == 0)
            return "List is Empty";
        return Arrays.toString(points);

    }

}
