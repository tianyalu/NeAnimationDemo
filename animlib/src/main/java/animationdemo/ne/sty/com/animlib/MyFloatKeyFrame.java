package animationdemo.ne.sty.com.animlib;

/**
 * 产品 关键帧
 * Created by tian on 2019/10/17.
 */

public class MyFloatKeyFrame {
    //当前的百分比
    float fraction;
    //当前帧对应的属性值
    float mValue;
    //当前帧对应的值的类型
    Class mValueType;

    public MyFloatKeyFrame(float fraction, float mValue) {
        this.fraction = fraction;
        this.mValue = mValue;
        mValueType = float.class;
    }

    public float getFraction() {
        return fraction;
    }

    public void setFraction(float fraction) {
        this.fraction = fraction;
    }

    public float getmValue() {
        return mValue;
    }

    public void setmValue(float mValue) {
        this.mValue = mValue;
    }
}
