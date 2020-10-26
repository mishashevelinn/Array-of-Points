package com.company;

import org.junit.Test;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayPointList points = new ArrayPointList(12);
        for (int i = 0; i < 10; i++) {
            points.append(new Point(i, i+1));
        }
        TestPointListTok test = new TestPointListTok(points);
        test.run();
    }
}
