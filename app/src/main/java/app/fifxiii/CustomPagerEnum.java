package app.fifxiii;

public enum CustomPagerEnum {

    RED(R.string.support, R.layout.day01),
    BLUE(R.string.romulo, R.layout.day02),
    ORANGE(R.string.nicolas, R.layout.day03),
    RED1(R.string.support, R.layout.day04),
    BLUE1(R.string.romulo, R.layout.day05),
    ORANGE1(R.string.nicolas, R.layout.day06),
    RED2(R.string.support, R.layout.day07),
    BLUE2(R.string.romulo, R.layout.day08),
    ORANGE3(R.string.nicolas, R.layout.day09);


    private int mTitleResId;
    private int mLayoutResId;

    CustomPagerEnum(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}