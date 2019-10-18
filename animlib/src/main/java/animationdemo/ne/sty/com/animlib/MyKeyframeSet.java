package animationdemo.ne.sty.com.animlib;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

import java.util.Arrays;
import java.util.List;

/**
 * 工人 关键帧集合 初始化关键帧信息（返回对应的属性值）
 * Created by tian on 2019/10/17.
 */

public class MyKeyframeSet {
    //类型估值器
    TypeEvaluator mEvaluator;
    List<MyFloatKeyFrame> mKeyFrames;

    public MyKeyframeSet(MyFloatKeyFrame... keyFrame) {
        this.mEvaluator = new FloatEvaluator();
        mKeyFrames = Arrays.asList(keyFrame);
    }

    //关键帧初始化
    public static MyKeyframeSet ofFloat(float[] values) {
        if(values.length <= 0) {
            return null;
        }
        int numKeyframes = values.length;
        MyFloatKeyFrame keyFrame[] = new MyFloatKeyFrame[numKeyframes];
        keyFrame[0] = new MyFloatKeyFrame(0, values[0]);
        //循环赋值
        for (int i = 1; i < numKeyframes; i++) {
            keyFrame[i] = new MyFloatKeyFrame((float) i/(numKeyframes - 1), values[i]);
        }
        return new MyKeyframeSet(keyFrame);
    }

    //获取当前百分比对应得到具体属性值
    public Object getValue(float fraction) {
        MyFloatKeyFrame prevKeyFrame = mKeyFrames.get(0);
        for (int i = 0; i < mKeyFrames.size(); i++) {
            MyFloatKeyFrame nextKeyFrame = mKeyFrames.get(i);
            if(fraction < nextKeyFrame.getFraction()) {
                //当前百分比在此之前
                //计算间隔百分比
                float intervalFraction = (fraction - prevKeyFrame.getFraction())
                        / (nextKeyFrame.getFraction() - prevKeyFrame.getFraction());
                //通过估值器返回对应的值
                return mEvaluator == null ?
                        prevKeyFrame.getmValue() + intervalFraction * (nextKeyFrame.getmValue() - prevKeyFrame.getmValue()) :
                        ((Number)(mEvaluator.evaluate(intervalFraction, prevKeyFrame.getmValue(), nextKeyFrame.getmValue()))).floatValue();
            }
            prevKeyFrame = nextKeyFrame;
        }
        return mKeyFrames.get(mKeyFrames.size() - 1).getmValue();
    }
}
