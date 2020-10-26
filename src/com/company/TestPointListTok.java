package com.company;
import javax.xml.transform.Templates;
import java.io.*;
import java.awt.Point;

public class TestPointListTok {
    InputStreamReader reader; // = new InputStreamReader(System.in);
    StreamTokenizer tokens; // = new StreamTokenizer(reader);
    ArrayPointList list;

    TestPointListTok(ArrayPointList arr){
        list = arr;
        reader = new InputStreamReader(System.in);
        tokens = new StreamTokenizer(reader);
    }

    void run() throws Exception {
        Point p = new Point();
        label:
        while (true) {
            if((tokens.nextToken()) == StreamTokenizer.TT_WORD){
                switch (tokens.sval) {
                    case "quit":
                        break label;
                    case "add":
                        tokens.nextToken();
                        p.x = (int) tokens.nval;
                        tokens.nextToken();
                        p.y = (int) tokens.nval;
                        list.append(p);
                        break;
                    case "curr":
                        System.out.println(list.getCursor());
                        break;
                    case "next":
                        System.out.println(list.goToNext());
                        break;
                    case "start":
                        System.out.println(list.goToBeginning());
                        break;
                }
            }   else if(tokens.sval.equals("clear")){
                list.clear();

            }
        }
    }
}

