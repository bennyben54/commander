package com.beo.commander.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@Service
public class CommanderService {

    @Autowired
    public CommanderService() {
    }

    public int launchChromium() {
        return launchCommand("/home/pirate/launch-chromium &");
    }

    public int stopChromium() {
        return launchCommand("/home/pirate/stop-chromium");
    }

    private int launchCommand(String command) {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command(command);
        builder.directory(new File("/home/pirate/"));
        Process process = null;
        try {
            process = builder.start();
            System.out.println(command);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
//        StreamGobbler streamGobbler =
//                new StreamGobbler(process.getInputStream(), System.out::println);
//        Executors.newSingleThreadExecutor().submit(streamGobbler);
//        int exitCode;
//        try {
//            exitCode = process.exitValue();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            return -1;
//        }
//        return exitCode;
    }

    private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(consumer);
        }
    }
}
