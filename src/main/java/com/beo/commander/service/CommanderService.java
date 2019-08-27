package com.beo.commander.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CommanderService {

    @Autowired
    public CommanderService() {
    }

    public int launchChromium() {
        return launchCommand("systemctl --user start launch-chromium");
    }

    public int stopChromium() {
        return launchCommand("systemctl --user stop launch-chromium");
    }

    private int launchCommand(String command) {

        try {
            Runtime.getRuntime().exec(command);
            System.out.println(command);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

//        ProcessBuilder builder = new ProcessBuilder();
//        builder.command(command);
//        builder.directory(new File(""));
//        Process process = null;
//        try {
//            process = builder.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return -1;
//        }
//        StreamGobbler streamGobbler =
//                new StreamGobbler(process.getInputStream(), System.out::println);
//        Executors.newSingleThreadExecutor().submit(streamGobbler);
//        return process.exitValue();
    }

//    private static class StreamGobbler implements Runnable {
//        private InputStream inputStream;
//        private Consumer<String> consumer;
//
//        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
//            this.inputStream = inputStream;
//            this.consumer = consumer;
//        }
//
//        @Override
//        public void run() {
//            new BufferedReader(new InputStreamReader(inputStream)).lines()
//                    .forEach(consumer);
//        }
//    }
}
