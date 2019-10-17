package animationdemo.ne.sty.com.animlib;


import android.view.View;

import java.lang.ref.WeakReference;

/**
 * 包工头
 */
public class MyObjectAnimator implements VSYNCManager.AnimationFrameCallback{
    private long mDuration = 0;
    //需要执行动画的对象
    private WeakReference<View> mTarget;
    //属性值管理类
    private MyFloatPropertyValuesHolder myFloatPropertyValuesHolder;
    private int index = 0;
    private TimeInterpolator interpolator;

    public MyObjectAnimator(View target, String propertyName, float... values) {
        mTarget = new WeakReference<View>(target);
        myFloatPropertyValuesHolder = new MyFloatPropertyValuesHolder(propertyName, values);
    }

    public static MyObjectAnimator ofFloat(View target, String propertyName, float... values) {
        MyObjectAnimator anim = new MyObjectAnimator(target, propertyName);
        return anim;
    }

    //每隔16ms执行一次
    @Override
    public boolean doAnimationFrame(long currentTime) {
        //后续的效果渲染
        //动画的总帧数
        float total = mDuration / 16;
        //拿到执行百分比（index / total）
        float fraction = (index++) / total;
        //通过插值器去改变对应的执行百分比
        if(interpolator != null) {
            fraction = this.interpolator.getInterpolator(fraction);
        }
        //循环 repeat
        if(index >= total) {
            index = 0;
        }
        //交给mFloatPropertyValuesHolder,改变对应的属性值
        myFloatPropertyValuesHolder.setAnimatedValue(mTarget.get(), fraction);
        return false;
    }

    //开启动画
    public void start() {
        //交给mFloatPropertyValuesHolder改变对应的属性值
        myFloatPropertyValuesHolder.setupSetter();
        VSYNCManager.getInstance().add(this);
    }

    public long getmDuration() {
        return mDuration;
    }

    public void setmDuration(long mDuration) {
        this.mDuration = mDuration;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public TimeInterpolator getInterpolator() {
        return interpolator;
    }

    public void setInterpolator(TimeInterpolator interpolator) {
        this.interpolator = interpolator;
    }


}
