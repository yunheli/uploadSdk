package fir.im.utils;

import fir.im.model.Binary;

import javax.swing.*;
import java.util.Date;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: will
 * Date: 15/9/19
 * Time: 下午11:12
 * To change this template use File | Settings | File Templates.
 */
public class TimerScanTask extends TimerTask {

    @Override
    public void run() {
        Date date = new Date(this.scheduledExecutionTime());
        System.out.println("本次执行该线程的时间为：" + date);


        String path = null;

        if(Binary.getInstance().filePath == null || Binary.getInstance().filePath.isEmpty()){
            System.out.println("本次执行该线程的时间为：1" + date);
            return;
        }
        path = Binary.getInstance().filePath;
        System.out.println("本次执行该线程的时间为：2" + date);
        String md5 = OsUtil.getMd5(path);
        if(!md5.equals(KeyManager.getInstance().getMd5())) {
            if("open".equals(KeyManager.getInstance().getAutoUpload())){
                System.out.println("自动检测上传");
                //FIXME: 上传添加锁
                //自动检测上传
                return;
            }
        }
    }
}
