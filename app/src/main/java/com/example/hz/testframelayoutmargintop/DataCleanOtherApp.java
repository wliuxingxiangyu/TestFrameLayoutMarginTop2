package com.example.hz.testframelayoutmargintop;

/**
 * Created by lenovo on 17/8/6.
 */
import java.io.File;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class DataCleanOtherApp {

    /**
     * 清除本应用所有数据库(/data/data/com.xxx.xxx/databases)
     *
     * @param context
     */
    public static void cleanDatabases(Context context) {
        deleteFilesByDirectory(new File("/data/data/com.miui.weather2"));
    }

    /**
     * 清除本应用所有的数据
     *
     * @param context
     * @param filepath
     */
    public static void cleanApplicationData(Context context, String... filepath) {
        cleanDatabases(context);
    }

    /**
     * 删除方法 这里只会删除某个文件夹下的文件，如果传入的directory是个文件，将不做处理
     *
     * @param directory
     */
    private static void deleteFilesByDirectory(File directory) {
        if (directory != null && directory.exists() && directory.isDirectory()) {
            if(directory.listFiles() != null && directory.listFiles().length != 0){
                Log.d("hz-","directory.listFiles().length="+directory.listFiles().length);
                for (File item : directory.listFiles()) {
                    item.delete();
                }
            }
        }
    }
}

