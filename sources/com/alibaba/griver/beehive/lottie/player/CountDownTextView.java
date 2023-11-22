package com.alibaba.griver.beehive.lottie.player;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.griver.beehive.lottie.adapter.impl.HtmlUtilsAdapter;
import com.alibaba.griver.beehive.lottie.util.CommonUtils;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes6.dex */
public class CountDownTextView extends TextView {
    private static final String TAG = "CountDownTextView";
    private static final int TIMER_WHAT = 1;
    private float aimDnsity;
    private float density;
    private Handler handler;
    private boolean hasDay;
    private boolean hasHour;
    private boolean hasMinute;
    private boolean hasPause;
    private boolean hasSecond;
    private long leftMs;
    private String originRichText;
    private int realWidth;
    private boolean showOver;
    private String timeUpRichLabalText;
    private Timer timer;
    private TimerTask timerTask;

    public CountDownTextView(Context context) {
        super(context);
        init();
    }

    public CountDownTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CountDownTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public CountDownTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        setSingleLine(true);
        setGravity(16);
        this.density = getContext().getResources().getDisplayMetrics().density;
        this.aimDnsity = 3.0f;
        this.timer = new Timer();
        this.timerTask = new TimerTask() { // from class: com.alibaba.griver.beehive.lottie.player.CountDownTextView.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                CountDownTextView.this.handler.sendEmptyMessage(1);
            }
        };
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.alibaba.griver.beehive.lottie.player.CountDownTextView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    if (CountDownTextView.this.leftMs - TimeUtils.getServerTime() <= 0) {
                        if (CountDownTextView.this.timer != null) {
                            CountDownTextView.this.timer.cancel();
                            CountDownTextView.this.timer = null;
                            CountDownTextView.this.timerTask = null;
                        }
                        if (!TextUtils.isEmpty(CountDownTextView.this.timeUpRichLabalText)) {
                            CountDownTextView.this.showOver = true;
                            CountDownTextView countDownTextView = CountDownTextView.this;
                            countDownTextView.setText(HtmlUtilsAdapter.fromHtml(countDownTextView.getContext(), CountDownTextView.this.density, CountDownTextView.this.timeUpRichLabalText));
                            return;
                        }
                        CountDownTextView.this.setRichTextTimer(new int[]{0, 0, 0, 0});
                        return;
                    }
                    CountDownTextView.this.setRichTextTimer(TimeUtils.getDHMS((CountDownTextView.this.leftMs - TimeUtils.getServerTime()) / 1000));
                }
            }
        };
        this.hasPause = false;
    }

    public void setTimerLayerModel(TimerLayerModel timerLayerModel) {
        if (timerLayerModel == null || TextUtils.isEmpty(timerLayerModel.richLabelText)) {
            return;
        }
        this.originRichText = CommonUtils.resetSizeByDesnity(timerLayerModel.richLabelText, this.aimDnsity);
        this.timeUpRichLabalText = CommonUtils.resetSizeByDesnity(timerLayerModel.timeUpRichLabalText, this.aimDnsity);
        this.leftMs = timerLayerModel.countDownLeftMs;
        this.hasDay = this.originRichText.contains(TimeUtils.DAY_TAG);
        this.hasHour = this.originRichText.contains(TimeUtils.HOUR_TAG);
        this.hasMinute = this.originRichText.contains(TimeUtils.MINUTE_TAG);
        this.hasSecond = this.originRichText.contains(TimeUtils.SECOND_TAG);
    }

    public void addToParentView(FrameLayout frameLayout, RectF rectF) {
        String str;
        if (frameLayout == null || rectF == null) {
            return;
        }
        long j = this.leftMs;
        if (j > 0) {
            str = replaceRichTextTime(TimeUtils.getDHMS((j - TimeUtils.getServerTime()) / 1000));
        } else {
            str = this.originRichText;
        }
        setText(HtmlUtilsAdapter.fromHtml(getContext(), this.density, str));
        this.realWidth = (int) ((((int) (rectF.right - rectF.left)) * this.density) / this.aimDnsity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = (int) rectF.left;
        layoutParams.topMargin = (int) rectF.top;
        frameLayout.addView(this, layoutParams);
        if (this.leftMs > 0 && needTimer()) {
            long[] intervalAndDelay = getIntervalAndDelay(TimeUtils.getDHMS((this.leftMs - TimeUtils.getServerTime()) / 1000));
            if (this.timer == null) {
                this.timer = new Timer();
            }
            this.timer.schedule(this.timerTask, intervalAndDelay[1], intervalAndDelay[0]);
        } else if (TextUtils.isEmpty(this.timeUpRichLabalText)) {
        } else {
            this.showOver = true;
            setText(HtmlUtilsAdapter.fromHtml(getContext(), this.density, this.timeUpRichLabalText));
        }
    }

    private String replaceRichTextTime(int[] iArr) {
        String longToString2;
        CharSequence charSequence;
        String str = this.originRichText;
        if (this.hasSecond) {
            if (this.hasMinute) {
                str = str.replace(TimeUtils.SECOND_TAG, longToString(iArr[3]));
            } else if (this.hasHour) {
                str = str.replace(TimeUtils.SECOND_TAG, longToString(iArr[3] + (iArr[2] * 60)));
            } else if (this.hasDay) {
                str = str.replace(TimeUtils.SECOND_TAG, longToString(iArr[3] + (iArr[2] * 60) + (iArr[1] * 3600)));
            } else {
                str = str.replace(TimeUtils.SECOND_TAG, longToString((iArr[0] * TimeUtils.DAY_TO_SECOND) + (iArr[1] * 3600) + (iArr[2] * 60) + iArr[3]));
            }
        }
        if (this.hasMinute) {
            if (this.hasHour) {
                str = str.replace(TimeUtils.MINUTE_TAG, this.hasSecond ? longToString(iArr[2]) : longToString2(iArr[2]));
            } else if (this.hasDay) {
                str = str.replace(TimeUtils.MINUTE_TAG, this.hasSecond ? longToString(iArr[2] + (iArr[1] * 60)) : longToString2(iArr[2] + (iArr[1] * 60)));
            } else {
                if (this.hasSecond) {
                    longToString2 = longToString(iArr[2] + (iArr[1] * 60) + (iArr[0] * TimeUtils.DAY_TO_MIN));
                    charSequence = TimeUtils.MINUTE_TAG;
                } else {
                    longToString2 = longToString2(iArr[2] + (iArr[1] * 60) + (iArr[0] * TimeUtils.DAY_TO_MIN));
                    charSequence = TimeUtils.MINUTE_TAG;
                }
                str = str.replace(charSequence, longToString2);
            }
        }
        if (this.hasHour) {
            if (this.hasDay) {
                str = str.replace(TimeUtils.HOUR_TAG, (this.hasSecond || this.hasMinute) ? longToString(iArr[1]) : longToString2(iArr[1]));
            } else {
                str = str.replace(TimeUtils.HOUR_TAG, (this.hasSecond || this.hasMinute) ? longToString(iArr[1] + (iArr[0] * 24)) : longToString2(iArr[1] + (iArr[0] * 24)));
            }
        }
        if (this.hasDay) {
            return str.replace(TimeUtils.DAY_TAG, (this.hasSecond || this.hasMinute || this.hasHour) ? longToString(iArr[0]) : longToString2(iArr[0]));
        }
        return str;
    }

    private String longToString(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(j < 10 ? "0" : "");
        sb.append(j);
        return sb.toString();
    }

    private String longToString2(long j) {
        if (j == 0) {
            return "01";
        }
        if (j < 10) {
            StringBuilder sb = new StringBuilder();
            sb.append("0");
            sb.append(j);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j);
        return sb2.toString();
    }

    private boolean needTimer() {
        return this.hasDay || this.hasHour || this.hasMinute || this.hasSecond;
    }

    private long[] getIntervalAndDelay(int[] iArr) {
        long[] jArr = new long[2];
        boolean z = this.hasSecond;
        if (z) {
            jArr[0] = 1000;
            jArr[1] = 0;
        } else if (!z && this.hasMinute) {
            jArr[0] = 60000;
            jArr[1] = (iArr[3] * 1000) + 1;
        } else if (!z && !this.hasMinute && this.hasHour) {
            jArr[0] = 3600000;
            jArr[1] = (iArr[3] * 1000) + (iArr[2] * 60000) + 1;
        } else if (!z && !this.hasMinute && !this.hasHour && this.hasDay) {
            jArr[0] = 86400000;
            jArr[1] = (iArr[3] * 1000) + (iArr[2] * 60000) + (iArr[1] * 3600000) + 1;
        }
        return jArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRichTextTimer(int[] iArr) {
        setText(HtmlUtilsAdapter.fromHtml(getContext(), this.density, replaceRichTextTime(iArr)));
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pauseTimer();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        resumeTimer();
    }

    public void pauseTimer() {
        if (this.hasPause) {
            return;
        }
        this.hasPause = true;
        stopTimer();
    }

    public void stopTimer() {
        Timer timer;
        if (this.hasPause) {
            return;
        }
        this.hasPause = true;
        if (this.leftMs <= 0 || !needTimer() || (timer = this.timer) == null) {
            return;
        }
        timer.cancel();
        this.timer = null;
        this.timerTask = null;
    }

    public void resumeTimer() {
        if (this.hasPause) {
            this.showOver = false;
            this.hasPause = false;
            if (this.leftMs > 0 && needTimer()) {
                long[] intervalAndDelay = getIntervalAndDelay(TimeUtils.getDHMS((this.leftMs - TimeUtils.getServerTime()) / 1000));
                if (this.timer == null) {
                    this.timer = new Timer();
                }
                createNewTimerTask();
                this.timer.schedule(this.timerTask, intervalAndDelay[1], intervalAndDelay[0]);
            } else if (TextUtils.isEmpty(this.timeUpRichLabalText)) {
            } else {
                this.showOver = true;
                setText(HtmlUtilsAdapter.fromHtml(getContext(), this.density, this.timeUpRichLabalText));
            }
        }
    }

    public boolean hasPause() {
        return this.hasPause;
    }

    private void createNewTimerTask() {
        this.timerTask = new TimerTask() { // from class: com.alibaba.griver.beehive.lottie.player.CountDownTextView.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                CountDownTextView.this.handler.sendEmptyMessage(1);
            }
        };
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        refitText(getText().toString(), getWidth());
    }

    private void refitText(String str, int i) {
        if (str == null || i <= 0) {
            return;
        }
        getTextSize();
        int i2 = this.realWidth;
        if (i > i2) {
            float f = i / i2;
            if (!this.showOver) {
                this.originRichText = CommonUtils.resetSize(this.originRichText, f);
                setRichTextTimer(TimeUtils.getDHMS((this.leftMs - TimeUtils.getServerTime()) / 1000));
                return;
            }
            this.timeUpRichLabalText = CommonUtils.resetSize(this.originRichText, f);
            setText(HtmlUtilsAdapter.fromHtml(getContext(), this.density, this.timeUpRichLabalText));
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
