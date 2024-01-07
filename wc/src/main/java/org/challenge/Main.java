package org.challenge;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            calcRes(args[0], "");
        } else {
            calcRes(args[0], args[1]);
        }
    }

    public static void calcRes(String path, String op) throws IOException {
        int data;
        char curr;
        int wc = 0;
        int cc = 0;
        int lc = 0;
        StringBuilder res = new StringBuilder();

        FileInputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);

        while ((data = bis.read()) != -1) {
            curr = (char) data;
            if (curr == ' ') {
                wc += 1;
            } else if (curr == '\n') {
                lc += 1;
            } else {
                cc += 1;
            }
        }
        bis.close();

        switch (op) {
            case "-c": {
                res.append(cc).append(" ").append(path);
                break;
            }
            case "-l": {
                res.append(lc).append(" ").append(path);
                break;
            }
            case "-w": {
                res.append(wc).append(" ").append(path);
            }
            default: {
                res.append(lc).append(" ").append(wc).append(" ").append(cc).append(" ").append(path);
            }
        }

        System.out.println(res.toString());
    }
}