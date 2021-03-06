package com.example.hz.testframelayoutmargintop;

/**
 * Created by lenovo on 17/8/6.
 */

import java.io.File;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;

public class DataCleanOtherApp {
//    private ClearUserDataObserver mClearDataObserver;
//
//    class ClearUserDataObserver extends IPackageDataObserver.Stub {
//        public void onRemoveCompleted(final String packageName, final boolean succeeded) {
//            /*final Message msg = mHandler.obtainMessage(CLEAR_USER_DATA);
//            msg.arg1 = succeeded?OP_SUCCESSFUL:OP_FAILED;
//            mHandler.sendMessage(msg);*/
//        }
//    }
//
//    private Context getOtherAppContext(Context context, String packageName) {
//        Context c = null;
//        try {
//            c = context.createPackageContext(packageName, Context.CONTEXT_INCLUDE_CODE | Context.CONTEXT_IGNORE_SECURITY);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        return c;
//    }
//
//    /*
//     * Private method to initiate clearing user data when the user clicks the clear data
//     * button for a system package
//     */
//    private void initiateClearUserData(Context context,String packageName) {
//        // Invoke uninstall or clear user data based on sysPackage
//        Log.i("type1", "Clearing user data for package : " + packageName);
//        if (mClearDataObserver == null) {
//            mClearDataObserver = new ClearUserDataObserver();
//        }
//        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
//        boolean res = am.clearApplicationUserData(packageName, mClearDataObserver);
//        if (!res) {
//            // Clearing data failed for some obscure reason. Just log error for now
//            Log.i("type1", "Couldnt clear application user data for package:" + packageName);
//
//        } else {
//            // success
//            Log.i("type1", "success");
//        }
//    }


    /**---------------------------------------------------------------------------
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
            if (directory.listFiles() != null && directory.listFiles().length != 0) {
                Log.d("hz-", "directory.listFiles().length=" + directory.listFiles().length);
                for (File item : directory.listFiles()) {
                    item.delete();
                }
            }
        }
    }
}

