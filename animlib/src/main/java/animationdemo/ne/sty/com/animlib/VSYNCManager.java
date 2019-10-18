package animationdemo.ne.sty.com.animlib;

import java.util.ArrayList;
import java.util.List;

/**
 * VSync信号模拟器 模拟刷新信号
 * Created by tian on 2019/10/17.
 */

public class VSYNCManager {
    private static final VSYNCManager instance = new VSYNCManager();
    private List<AnimationFrameCallback> list = new ArrayList<>();

    private VSYNCManager(){
        new Thread(runnable).start();
    }

    public static VSYNCManager getInstance() {
        return instance;
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(16);
                    for (AnimationFrameCallback animationFrameCallback : list) {
                        animationFrameCallback.doAnimationFrame(System.currentTimeMillis());
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };

    //可以多个动画同时执行
    interface AnimationFrameCallback{
        boolean doAnimationFrame(long currentTime);
    }

    //添加回调
    public void add(AnimationFrameCallback animationFrameCallback) {
        list.add(animationFrameCallback);
    }
}
