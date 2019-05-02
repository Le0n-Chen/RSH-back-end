package com.leoncf.video;

import com.leoncf.network.scan.PingTester;

public class Main {
    public static void main(String[] args) {
        PingTester tester = new PingTester();
        tester.startPing();
    }
}
