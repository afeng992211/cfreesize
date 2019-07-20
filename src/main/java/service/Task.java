package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Constant;

import javax.swing.*;
import java.io.File;

public class Task implements Runnable{
    private static final Logger LOGGER = LoggerFactory.getLogger(Task.class);

    @Override
    public void run() {
        File file = new File("c:");
        long freeSpace = file.getFreeSpace();
        freeSpace = freeSpace / Constant.UNIT_VALUE; //KB
        freeSpace = freeSpace / Constant.UNIT_VALUE; //MB
        freeSpace = freeSpace / Constant.UNIT_VALUE; //GB

        LOGGER.info("start...执行任务,检测c盘大小,阈值"+Constant.FREE_THRESHOLD+"G,余量"+freeSpace+"G");
        if (freeSpace <= Constant.FREE_THRESHOLD) {
            LOGGER.warn("hit...检测到c盘不足报警");
            JOptionPane.showMessageDialog(null,"C盘小于"+Constant.FREE_THRESHOLD+"G了, 请处理下","c-free-size",JOptionPane.WARNING_MESSAGE,null);
        }
    }
}
