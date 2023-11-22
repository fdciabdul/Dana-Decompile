package id.dana.danah5.easteregg;

/* loaded from: classes4.dex */
public class QuickTap {
    private int count;
    private OnQuickTapListener onQuickTapListener;
    private long previousTime;
    private int tapAmount;
    private int tapDuration;

    /* loaded from: classes4.dex */
    public interface OnQuickTapListener {
        void onQuickTap();
    }

    public QuickTap(int i, int i2, OnQuickTapListener onQuickTapListener) {
        this.tapDuration = i;
        this.tapAmount = i2;
        this.onQuickTapListener = onQuickTapListener;
    }

    public void process() {
        if (this.previousTime == 0 || System.currentTimeMillis() - this.previousTime < this.tapDuration) {
            this.previousTime = System.currentTimeMillis();
            this.count++;
        } else {
            clear();
            process();
        }
        if (this.count >= this.tapAmount) {
            this.onQuickTapListener.onQuickTap();
            clear();
        }
    }

    private void clear() {
        this.previousTime = 0L;
        this.count = 0;
    }
}
