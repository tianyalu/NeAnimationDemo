package animationdemo.ne.sty.com.animlib;

/**
 * 插值器，控制进度
 * Created by tian on 2019/10/17.
 */

public class MyLinearInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolator(float input) {
//        return 0.5f * input;
        return input;
    }
}
