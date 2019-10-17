package animationdemo.ne.sty.com.animlib;

import android.view.View;

import java.lang.reflect.Method;

/**
 * 工头 动画任务属性管理类
 * Created by tian on 2019/10/17.
 */

public class MyFloatPropertyValuesHolder {
    //属性名
    String mPropertyName;
    //设置的属性类型 float
    Class mValueType;
    //反射
    Method mSetter = null;
    //关键帧集合管理类
    MyKeyframeSet myKeyframeSet;

    public MyFloatPropertyValuesHolder(String propertyName, float... values) {
        this.mPropertyName = propertyName;
        mValueType = float.class;
        //交给关键帧管理类初始化
        myKeyframeSet = MyKeyframeSet.ofFloat(values);
    }

    //通过反射获取控件对应的方法
    public void setupSetter() {
        Character.toUpperCase(mPropertyName.charAt(0));
    }

    public void setAnimatedValue(View view, float fraction) {

    }
}
