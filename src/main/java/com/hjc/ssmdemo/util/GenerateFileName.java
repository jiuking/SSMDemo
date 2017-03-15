package com.hjc.ssmdemo.util;

import java.util.UUID;

/**
 * Created by Bravowhale on 2017/3/15.
 */
public class GenerateFileName {
    public static String generateFileName(String fileName) {
        String mainName = UUID.randomUUID().toString();
        String extensionName = "";

        if (fileName != null) {
            int index = fileName.indexOf('.');
            if (index >= 0) {
                extensionName = fileName.substring(index);
            }
        }

        return mainName + extensionName;
    }
}
