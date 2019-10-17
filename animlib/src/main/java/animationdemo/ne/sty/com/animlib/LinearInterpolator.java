package animationdemo.ne.sty.com.animlib;

/**
 * Created by tian on 2019/10/17.
 */

public class LinearInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolator(float input) {
        return input;
    }
}
