package com.alipay.mobile.verifyidentity.business.securitycommon.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.material.timepicker.TimeModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class WheelView extends View {
    private static final int ACTION_CLICK = 1;
    private static final int ACTION_DRAG = 3;
    private static final int ACTION_FLING = 2;
    public static final int DIVIDER_ALPHA = 220;
    public static final int DIVIDER_COLOR = -8139290;
    public static final float DIVIDER_THICK = 2.0f;
    public static final int ITEM_OFF_SET = 3;
    private static final float ITEM_PADDING = 13.0f;
    public static final float LINE_SPACE_MULTIPLIER = 2.0f;
    private static final float SCALE_CONTENT = 0.8f;
    public static final int TEXT_COLOR_FOCUS = -16611122;
    public static final int TEXT_COLOR_NORMAL = -4473925;
    public static final int TEXT_PADDING = -1;
    public static final int TEXT_SIZE = 16;
    private static final int VELOCITY_FLING = 5;
    private float centerContentOffset;
    private DividerConfig dividerConfig;
    private int drawCenterContentStart;
    private int drawOutContentStart;
    private float firstLineY;
    private GestureDetector gestureDetector;
    private int gravity;
    private MessageHandler handler;
    private int initPosition;
    private boolean isLoop;
    private float itemHeight;
    private List<WheelItem> items;
    private String label;
    private float lineSpaceMultiplier;
    private ScheduledFuture<?> mFuture;
    private int maxTextHeight;
    private int maxTextWidth;
    private int measuredHeight;
    private int measuredWidth;
    private int offset;
    private OnItemSelectListener onItemSelectListener;
    private OnWheelListener onWheelListener;
    private boolean onlyShowCenterLabel;
    private Paint paintCenterText;
    private Paint paintIndicator;
    private Paint paintOuterText;
    private Paint paintShadow;
    private int preCurrentIndex;
    private float previousY;
    private int radius;
    private float secondLineY;
    private int selectedIndex;
    private long startTime;
    private int textColorCenter;
    private int textColorOuter;
    private int textPadding;
    private int textSize;
    private boolean textSizeAutoFit;
    private int textSkewXOffset;
    private float totalScrollY;
    private Typeface typeface;
    private boolean useWeight;
    private int visibleItemCount;
    private int widthMeasureSpec;

    @Deprecated
    /* loaded from: classes7.dex */
    public static class LineConfig extends DividerConfig {
    }

    /* loaded from: classes7.dex */
    public interface OnItemSelectListener {
        void onSelected(int i);
    }

    @Deprecated
    /* loaded from: classes7.dex */
    public interface OnWheelListener {
        void onSelected(boolean z, int i, String str);
    }

    @Deprecated
    /* loaded from: classes7.dex */
    public interface OnWheelViewListener extends OnWheelListener {
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onlyShowCenterLabel = true;
        this.items = new ArrayList();
        this.textSkewXOffset = 0;
        this.textSize = 16;
        this.typeface = Typeface.DEFAULT;
        this.textColorOuter = -4473925;
        this.textColorCenter = -16611122;
        this.dividerConfig = new DividerConfig();
        this.lineSpaceMultiplier = 2.0f;
        this.textPadding = -1;
        this.isLoop = true;
        this.totalScrollY = 0.0f;
        this.initPosition = -1;
        this.visibleItemCount = 7;
        this.offset = 0;
        this.previousY = 0.0f;
        this.startTime = 0L;
        this.gravity = 17;
        this.drawCenterContentStart = 0;
        this.drawOutContentStart = 0;
        this.useWeight = false;
        this.textSizeAutoFit = true;
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.centerContentOffset = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.centerContentOffset = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.centerContentOffset = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.centerContentOffset = 6.0f;
        } else if (f >= 3.0f) {
            this.centerContentOffset = f * 2.5f;
        }
        judgeLineSpace();
        initView(context);
    }

    public final void setVisibleItemCount(int i) {
        if (i % 2 == 0) {
            throw new IllegalArgumentException("must be odd");
        }
        if (i != this.visibleItemCount) {
            this.visibleItemCount = i;
        }
    }

    public final void setCycleDisable(boolean z) {
        this.isLoop = !z;
    }

    public final void setOffset(int i) {
        if (i <= 0 || i > 5) {
            throw new IllegalArgumentException("must between 1 and 5");
        }
        setVisibleItemCount((i * 2) + 1 + (i % 2 == 0 ? i : i - 1));
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final void setSelectedIndex(int i) {
        List<WheelItem> list = this.items;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.items.size();
        if (i == 0 || (i > 0 && i < size && i != this.selectedIndex)) {
            this.initPosition = i;
            this.totalScrollY = 0.0f;
            this.offset = 0;
            invalidate();
        }
    }

    public final void setOnItemSelectListener(OnItemSelectListener onItemSelectListener) {
        this.onItemSelectListener = onItemSelectListener;
    }

    @Deprecated
    public final void setOnWheelListener(OnWheelListener onWheelListener) {
        this.onWheelListener = onWheelListener;
    }

    public final void setItems(List<?> list) {
        this.items.clear();
        for (Object obj : list) {
            if (obj instanceof WheelItem) {
                this.items.add((WheelItem) obj);
            } else if ((obj instanceof CharSequence) || (obj instanceof Number)) {
                this.items.add(new StringItem(obj.toString()));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("please implements ");
                sb.append(WheelItem.class.getName());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        remeasure();
        invalidate();
    }

    public final void setItems(List<?> list, int i) {
        setItems(list);
        setSelectedIndex(i);
    }

    public final void setItems(String[] strArr) {
        setItems(Arrays.asList(strArr));
    }

    public final void setItems(List<String> list, String str) {
        int indexOf = list.indexOf(str);
        if (indexOf == -1) {
            indexOf = 0;
        }
        setItems(list, indexOf);
    }

    public final void setItems(String[] strArr, int i) {
        setItems(Arrays.asList(strArr), i);
    }

    public final void setItems(String[] strArr, String str) {
        setItems(Arrays.asList(strArr), str);
    }

    public final void setLabel(String str, boolean z) {
        this.label = str;
        this.onlyShowCenterLabel = z;
    }

    public final void setLabel(String str) {
        setLabel(str, true);
    }

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public void setTextColor(int i, int i2) {
        this.textColorOuter = i;
        this.textColorCenter = i2;
        this.paintOuterText.setColor(i);
        this.paintCenterText.setColor(i2);
    }

    public void setTextColor(int i) {
        this.textColorOuter = i;
        this.textColorCenter = i;
        this.paintOuterText.setColor(i);
        this.paintCenterText.setColor(i);
    }

    public final void setTypeface(Typeface typeface) {
        this.typeface = typeface;
        this.paintOuterText.setTypeface(typeface);
        this.paintCenterText.setTypeface(this.typeface);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int i = (int) (getContext().getResources().getDisplayMetrics().density * f);
            this.textSize = i;
            this.paintOuterText.setTextSize(i);
            this.paintCenterText.setTextSize(this.textSize);
        }
    }

    public void setTextSkewXOffset(int i) {
        this.textSkewXOffset = i;
        if (i != 0) {
            this.paintCenterText.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.dividerConfig.setColor(i);
        this.paintIndicator.setColor(i);
    }

    @Deprecated
    public void setLineConfig(DividerConfig dividerConfig) {
        setDividerConfig(dividerConfig);
    }

    public void setDividerConfig(DividerConfig dividerConfig) {
        if (dividerConfig == null) {
            this.dividerConfig.setVisible(false);
            this.dividerConfig.setShadowVisible(false);
            return;
        }
        this.dividerConfig = dividerConfig;
        this.paintIndicator.setColor(dividerConfig.color);
        this.paintIndicator.setStrokeWidth(dividerConfig.thick);
        this.paintIndicator.setAlpha(dividerConfig.alpha);
        this.paintShadow.setColor(dividerConfig.shadowColor);
        this.paintShadow.setAlpha(dividerConfig.shadowAlpha);
    }

    public final void setLineSpaceMultiplier(float f) {
        this.lineSpaceMultiplier = f;
        judgeLineSpace();
    }

    @Deprecated
    public void setPadding(int i) {
        setTextPadding(i);
    }

    public void setTextPadding(int i) {
        this.textPadding = ConvertUtils.toPx(getContext(), i);
    }

    public void setUseWeight(boolean z) {
        this.useWeight = z;
    }

    public void setTextSizeAutoFit(boolean z) {
        this.textSizeAutoFit = z;
    }

    private void judgeLineSpace() {
        float f = this.lineSpaceMultiplier;
        if (f < 1.5f) {
            this.lineSpaceMultiplier = 1.5f;
        } else if (f > 4.0f) {
            this.lineSpaceMultiplier = 4.0f;
        }
    }

    private void initView(Context context) {
        this.handler = new MessageHandler(this);
        GestureDetector gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                WheelView.this.scrollBy(f2);
                return true;
            }
        });
        this.gestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        initPaints();
        initDataForIDE();
    }

    private void initPaints() {
        Paint paint = new Paint();
        this.paintOuterText = paint;
        paint.setAntiAlias(true);
        this.paintOuterText.setColor(this.textColorOuter);
        this.paintOuterText.setTypeface(this.typeface);
        this.paintOuterText.setTextSize(this.textSize);
        Paint paint2 = new Paint();
        this.paintCenterText = paint2;
        paint2.setAntiAlias(true);
        this.paintCenterText.setColor(Color.parseColor("#000000"));
        this.paintCenterText.setTextScaleX(1.0f);
        this.paintCenterText.setTypeface(this.typeface);
        this.paintCenterText.setTextSize(this.textSize);
        Paint paint3 = new Paint();
        this.paintIndicator = paint3;
        paint3.setAntiAlias(true);
        this.paintIndicator.setColor(this.dividerConfig.color);
        this.paintIndicator.setStrokeWidth(this.dividerConfig.thick);
        this.paintIndicator.setAlpha(this.dividerConfig.alpha);
        Paint paint4 = new Paint();
        this.paintShadow = paint4;
        paint4.setAntiAlias(true);
        this.paintShadow.setColor(this.dividerConfig.shadowColor);
        this.paintShadow.setAlpha(this.dividerConfig.shadowAlpha);
        setLayerType(1, null);
    }

    private void initDataForIDE() {
        if (isInEditMode()) {
            setItems(new String[]{"李玉江", "男", "贵州", "穿青人"});
        }
    }

    private void remeasure() {
        if (this.items == null) {
            return;
        }
        measureTextWidthHeight();
        int i = (int) (this.itemHeight * ((float) (this.visibleItemCount - 1)));
        double d = i * 2;
        Double.isNaN(d);
        this.measuredHeight = (int) (d / 3.141592653589793d);
        double d2 = i;
        Double.isNaN(d2);
        this.radius = (int) (d2 / 3.141592653589793d);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.useWeight) {
            this.measuredWidth = View.MeasureSpec.getSize(this.widthMeasureSpec);
        } else if (layoutParams != null && layoutParams.width > 0) {
            this.measuredWidth = layoutParams.width;
        } else {
            this.measuredWidth = this.maxTextWidth;
            if (this.textPadding < 0) {
                this.textPadding = ConvertUtils.toPx(getContext(), 13.0f);
            }
            this.measuredWidth += this.textPadding * 2;
            if (!TextUtils.isEmpty(this.label)) {
                this.measuredWidth += obtainTextWidth(this.paintCenterText, this.label);
            }
        }
        float f = this.measuredHeight;
        float f2 = this.itemHeight;
        this.firstLineY = (f - f2) / 2.0f;
        this.secondLineY = (f + f2) / 2.0f;
        if (this.initPosition == -1) {
            if (this.isLoop) {
                this.initPosition = (this.items.size() + 1) / 2;
            } else {
                this.initPosition = 0;
            }
        }
        this.preCurrentIndex = this.initPosition;
    }

    private void measureTextWidthHeight() {
        Rect rect = new Rect();
        for (int i = 0; i < this.items.size(); i++) {
            String obtainContentText = obtainContentText(this.items.get(i));
            this.paintCenterText.getTextBounds(obtainContentText, 0, obtainContentText.length(), rect);
            int width = rect.width();
            if (width > this.maxTextWidth) {
                this.maxTextWidth = width;
            }
            this.paintCenterText.getTextBounds("测试", 0, 2, rect);
            this.maxTextHeight = rect.height() + 2;
        }
        this.itemHeight = this.lineSpaceMultiplier * this.maxTextHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScroll(int i) {
        cancelFuture();
        if (i == 2 || i == 3) {
            float f = this.totalScrollY;
            float f2 = this.itemHeight;
            int i2 = (int) (((f % f2) + f2) % f2);
            this.offset = i2;
            float f3 = i2;
            if (f3 > f2 / 2.0f) {
                this.offset = (int) (f2 - f3);
            } else {
                this.offset = -i2;
            }
        }
        this.mFuture = Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.offset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollBy(float f) {
        cancelFuture();
        this.mFuture = Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new InertiaTimerTask(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.mFuture;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.mFuture.cancel(true);
        this.mFuture = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void itemSelectedCallback() {
        if (this.onItemSelectListener == null && this.onWheelListener == null) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView.2
            @Override // java.lang.Runnable
            public void run() {
                if (WheelView.this.onItemSelectListener != null) {
                    WheelView.this.onItemSelectListener.onSelected(WheelView.this.selectedIndex);
                }
                if (WheelView.this.onWheelListener != null) {
                    WheelView.this.onWheelListener.onSelected(true, WheelView.this.selectedIndex, ((WheelItem) WheelView.this.items.get(WheelView.this.selectedIndex)).getName());
                }
            }
        }, 200L);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        String str;
        List<WheelItem> list = this.items;
        if (list == null || list.size() == 0) {
            return;
        }
        String[] strArr = new String[this.visibleItemCount];
        int size = this.initPosition + (((int) (this.totalScrollY / this.itemHeight)) % this.items.size());
        this.preCurrentIndex = size;
        if (!this.isLoop) {
            if (size < 0) {
                this.preCurrentIndex = 0;
            }
            if (this.preCurrentIndex > this.items.size() - 1) {
                this.preCurrentIndex = this.items.size() - 1;
            }
        } else {
            if (size < 0) {
                this.preCurrentIndex = this.items.size() + this.preCurrentIndex;
            }
            if (this.preCurrentIndex > this.items.size() - 1) {
                this.preCurrentIndex -= this.items.size();
            }
        }
        float f2 = this.totalScrollY;
        float f3 = this.itemHeight;
        int i = 0;
        while (true) {
            int i2 = this.visibleItemCount;
            if (i >= i2) {
                break;
            }
            int i3 = this.preCurrentIndex - ((i2 / 2) - i);
            if (this.isLoop) {
                i3 = getLoopMappingIndex(i3);
            } else {
                if (i3 < 0) {
                    strArr[i] = "";
                } else if (i3 > this.items.size() - 1) {
                    strArr[i] = "";
                }
                i++;
            }
            strArr[i] = this.items.get(i3).getName();
            i++;
        }
        if (this.dividerConfig.visible) {
            float f4 = this.dividerConfig.ratio;
            float f5 = this.measuredWidth;
            float f6 = this.firstLineY;
            float f7 = 1.0f - f4;
            canvas.drawLine(f5 * f4, f6, f5 * f7, f6, this.paintIndicator);
            float f8 = this.measuredWidth;
            float f9 = this.secondLineY;
            canvas.drawLine(f8 * f4, f9, f8 * f7, f9, this.paintIndicator);
        }
        if (this.dividerConfig.shadowVisible) {
            this.paintShadow.setColor(this.dividerConfig.shadowColor);
            this.paintShadow.setAlpha(this.dividerConfig.shadowAlpha);
            canvas.drawRect(0.0f, this.firstLineY, this.measuredWidth, this.secondLineY, this.paintShadow);
        }
        int i4 = 0;
        while (i4 < this.visibleItemCount) {
            canvas.save();
            double d = ((this.itemHeight * i4) - (f2 % f3)) / this.radius;
            Double.isNaN(d);
            float f10 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
            if (f10 >= 90.0f || f10 <= -90.0f) {
                f = f2;
                canvas.restore();
            } else {
                String obtainContentText = obtainContentText(strArr[i4]);
                if (this.onlyShowCenterLabel || TextUtils.isEmpty(this.label) || TextUtils.isEmpty(obtainContentText)) {
                    str = obtainContentText;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(obtainContentText);
                    sb.append(this.label);
                    str = sb.toString();
                }
                if (this.textSizeAutoFit) {
                    remeasureTextSize(str);
                    this.gravity = 17;
                } else {
                    this.gravity = 8388611;
                }
                measuredCenterContentStart(str);
                measuredOutContentStart(str);
                f = f2;
                double d2 = this.radius;
                double cos = Math.cos(d);
                String str2 = obtainContentText;
                double d3 = this.radius;
                double sin = Math.sin(d);
                String str3 = str;
                double d4 = this.maxTextHeight;
                Double.isNaN(d3);
                Double.isNaN(d2);
                Double.isNaN(d4);
                float f11 = (float) ((d2 - (cos * d3)) - ((sin * d4) / 2.0d));
                canvas.translate(0.0f, f11);
                float f12 = this.firstLineY;
                if (f11 <= f12 && this.maxTextHeight + f11 >= f12) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.firstLineY - f11);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * SCALE_CONTENT);
                    canvas.drawText(str3, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.firstLineY - f11, this.measuredWidth, (int) this.itemHeight);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                    canvas.drawText(str3, this.drawCenterContentStart, this.maxTextHeight - this.centerContentOffset, this.paintCenterText);
                    canvas.restore();
                } else {
                    String str4 = str3;
                    float f13 = this.secondLineY;
                    if (f11 <= f13 && this.maxTextHeight + f11 >= f13) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.secondLineY - f11);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(str4, this.drawCenterContentStart, this.maxTextHeight - this.centerContentOffset, this.paintCenterText);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.secondLineY - f11, this.measuredWidth, (int) this.itemHeight);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * SCALE_CONTENT);
                        canvas.drawText(str4, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    } else {
                        if (f11 >= f12) {
                            int i5 = this.maxTextHeight;
                            if (i5 + f11 <= f13) {
                                canvas.clipRect(0, 0, this.measuredWidth, i5);
                                float f14 = this.maxTextHeight;
                                float f15 = this.centerContentOffset;
                                Iterator<WheelItem> it = this.items.iterator();
                                int i6 = 0;
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    String str5 = str2;
                                    if (it.next().getName().equals(str5)) {
                                        this.selectedIndex = i6;
                                        break;
                                    } else {
                                        i6++;
                                        str2 = str5;
                                    }
                                }
                                if (this.onlyShowCenterLabel && !TextUtils.isEmpty(this.label)) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(str4);
                                    sb2.append(this.label);
                                    str4 = sb2.toString();
                                }
                                canvas.drawText(str4, this.drawCenterContentStart, f14 - f15, this.paintCenterText);
                                canvas.restore();
                                this.paintCenterText.setTextSize(this.textSize);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.itemHeight);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * SCALE_CONTENT);
                        float pow = (float) Math.pow(Math.abs(f10) / 90.0f, 2.2d);
                        int i7 = this.textSkewXOffset;
                        if (i7 != 0) {
                            this.paintOuterText.setTextSkewX((i7 > 0 ? 1 : -1) * (f10 <= 0.0f ? 1 : -1) * 0.5f * pow);
                            this.paintOuterText.setAlpha((int) ((1.0f - pow) * 255.0f));
                        }
                        canvas.drawText(str4, this.drawOutContentStart + (this.textSkewXOffset * pow), this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                        canvas.restore();
                        this.paintCenterText.setTextSize(this.textSize);
                    }
                }
                canvas.restore();
                this.paintCenterText.setTextSize(this.textSize);
            }
            i4++;
            f2 = f;
        }
    }

    private void remeasureTextSize(String str) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.measuredWidth; width = rect.width()) {
            i--;
            this.paintCenterText.setTextSize(i);
            this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        }
        this.paintOuterText.setTextSize(i);
    }

    private int getLoopMappingIndex(int i) {
        if (i < 0) {
            return getLoopMappingIndex(i + this.items.size());
        }
        return i > this.items.size() + (-1) ? getLoopMappingIndex(i - this.items.size()) : i;
    }

    private String obtainContentText(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof WheelItem) {
            return ((WheelItem) obj).getName();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void measuredCenterContentStart(String str) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.gravity;
        if (i == 3) {
            this.drawCenterContentStart = ConvertUtils.toPx(getContext(), 8.0f);
        } else if (i == 5) {
            this.drawCenterContentStart = (this.measuredWidth - rect.width()) - ((int) this.centerContentOffset);
        } else if (i == 17) {
            double width = this.measuredWidth - rect.width();
            Double.isNaN(width);
            this.drawCenterContentStart = (int) (width * 0.5d);
        }
    }

    private void measuredOutContentStart(String str) {
        Rect rect = new Rect();
        this.paintOuterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.gravity;
        if (i == 3) {
            this.drawOutContentStart = ConvertUtils.toPx(getContext(), 8.0f);
        } else if (i == 5) {
            this.drawOutContentStart = (this.measuredWidth - rect.width()) - ((int) this.centerContentOffset);
        } else if (i == 17) {
            double width = this.measuredWidth - rect.width();
            Double.isNaN(width);
            this.drawOutContentStart = (int) (width * 0.5d);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.widthMeasureSpec = i;
        remeasure();
        setMeasuredDimension(this.measuredWidth, this.measuredHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        ViewParent parent = getParent();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startTime = System.currentTimeMillis();
            cancelFuture();
            this.previousY = motionEvent.getRawY();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        } else if (action != 2) {
            if (!onTouchEvent) {
                float y = motionEvent.getY();
                float f = this.radius;
                double acos = Math.acos((f - y) / f);
                double d = this.radius;
                float f2 = this.itemHeight;
                Double.isNaN(d);
                Double.isNaN(f2 / 2.0f);
                Double.isNaN(f2);
                this.offset = (int) (((((int) (((acos * d) + r9) / r11)) - (this.visibleItemCount / 2)) * f2) - (((this.totalScrollY % f2) + f2) % f2));
                if (System.currentTimeMillis() - this.startTime > 120) {
                    smoothScroll(3);
                } else {
                    smoothScroll(1);
                }
            }
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        } else {
            float rawY = this.previousY - motionEvent.getRawY();
            this.previousY = motionEvent.getRawY();
            this.totalScrollY += rawY;
            if (!this.isLoop) {
                float f3 = (-this.initPosition) * this.itemHeight;
                float size = (this.items.size() - 1) - this.initPosition;
                float f4 = this.itemHeight;
                float f5 = size * f4;
                float f6 = this.totalScrollY;
                double d2 = f6;
                double d3 = f4;
                Double.isNaN(d3);
                double d4 = d3 * 0.25d;
                Double.isNaN(d2);
                if (d2 - d4 < f3) {
                    f3 = f6 - rawY;
                } else {
                    Double.isNaN(d2);
                    if (d2 + d4 > f5) {
                        f5 = f6 - rawY;
                    }
                }
                if (f6 < f3) {
                    this.totalScrollY = (int) f3;
                } else if (f6 > f5) {
                    this.totalScrollY = (int) f5;
                }
            }
        }
        if (motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    protected int getItemCount() {
        List<WheelItem> list = this.items;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    private int obtainTextWidth(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (int) Math.ceil(r2[i2]);
        }
        return i;
    }

    /* loaded from: classes7.dex */
    public static class DividerConfig {
        public static final float FILL = 0.0f;
        public static final float WRAP = 1.0f;
        protected int alpha;
        protected int color;
        protected float ratio;
        protected int shadowAlpha;
        protected int shadowColor;
        protected boolean shadowVisible;
        protected float thick;
        protected boolean visible;

        public DividerConfig() {
            this.visible = true;
            this.shadowVisible = false;
            this.color = -8139290;
            this.shadowColor = -4473925;
            this.shadowAlpha = 100;
            this.alpha = WheelView.DIVIDER_ALPHA;
            this.ratio = 0.1f;
            this.thick = 2.0f;
        }

        public DividerConfig(float f) {
            this.visible = true;
            this.shadowVisible = false;
            this.color = -8139290;
            this.shadowColor = -4473925;
            this.shadowAlpha = 100;
            this.alpha = WheelView.DIVIDER_ALPHA;
            this.thick = 2.0f;
            this.ratio = f;
        }

        public DividerConfig setVisible(boolean z) {
            this.visible = z;
            return this;
        }

        public DividerConfig setShadowVisible(boolean z) {
            this.shadowVisible = z;
            if (z && this.color == -8139290) {
                this.color = this.shadowColor;
                this.alpha = 255;
            }
            return this;
        }

        public DividerConfig setShadowColor(int i) {
            this.shadowVisible = true;
            this.shadowColor = i;
            return this;
        }

        public DividerConfig setShadowAlpha(int i) {
            this.shadowAlpha = i;
            return this;
        }

        public DividerConfig setColor(int i) {
            this.color = i;
            return this;
        }

        public DividerConfig setAlpha(int i) {
            this.alpha = i;
            return this;
        }

        public DividerConfig setRatio(float f) {
            this.ratio = f;
            return this;
        }

        public DividerConfig setThick(float f) {
            this.thick = f;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("visible=");
            sb.append(this.visible);
            sb.append(",color=");
            sb.append(this.color);
            sb.append(",alpha=");
            sb.append(this.alpha);
            sb.append(",thick=");
            sb.append(this.thick);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class StringItem implements WheelItem {
        private String name;

        private StringItem(String str) {
            this.name = str;
        }

        @Override // com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelItem
        public String getName() {
            return this.name;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class MessageHandler extends Handler {
        static final int WHAT_INVALIDATE = 1000;
        static final int WHAT_ITEM_SELECTED = 3000;
        static final int WHAT_SMOOTH_SCROLL = 2000;
        final WheelView view;

        MessageHandler(WheelView wheelView) {
            this.view = wheelView;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1000) {
                this.view.invalidate();
            } else if (i == 2000) {
                this.view.smoothScroll(2);
            } else if (i == 3000) {
                this.view.itemSelectedCallback();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class SmoothScrollTimerTask extends TimerTask {
        int offset;
        final WheelView view;
        int realTotalOffset = Integer.MAX_VALUE;
        int realOffset = 0;

        SmoothScrollTimerTask(WheelView wheelView, int i) {
            this.view = wheelView;
            this.offset = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.realTotalOffset == Integer.MAX_VALUE) {
                this.realTotalOffset = this.offset;
            }
            int i = this.realTotalOffset;
            int i2 = (int) (i * 0.1f);
            this.realOffset = i2;
            if (i2 == 0) {
                if (i < 0) {
                    this.realOffset = -1;
                } else {
                    this.realOffset = 1;
                }
            }
            if (Math.abs(i) <= 1) {
                this.view.cancelFuture();
                this.view.handler.sendEmptyMessage(3000);
                return;
            }
            this.view.totalScrollY += this.realOffset;
            if (!this.view.isLoop) {
                float f = this.view.itemHeight;
                float f2 = -this.view.initPosition;
                float itemCount = (this.view.getItemCount() - 1) - this.view.initPosition;
                if (this.view.totalScrollY <= f2 * f || this.view.totalScrollY >= itemCount * f) {
                    this.view.totalScrollY -= this.realOffset;
                    this.view.cancelFuture();
                    this.view.handler.sendEmptyMessage(3000);
                    return;
                }
            }
            this.view.handler.sendEmptyMessage(1000);
            this.realTotalOffset -= this.realOffset;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class InertiaTimerTask extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        float f7312a = 2.14748365E9f;
        final float velocityY;
        final WheelView view;

        InertiaTimerTask(WheelView wheelView, float f) {
            this.view = wheelView;
            this.velocityY = f;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            if (this.f7312a == 2.14748365E9f) {
                if (Math.abs(this.velocityY) <= 2000.0f) {
                    this.f7312a = this.velocityY;
                } else if (this.velocityY > 0.0f) {
                    this.f7312a = 2000.0f;
                } else {
                    this.f7312a = -2000.0f;
                }
            }
            if (Math.abs(this.f7312a) >= 0.0f && Math.abs(this.f7312a) <= 20.0f) {
                this.view.cancelFuture();
                this.view.handler.sendEmptyMessage(2000);
                return;
            }
            int i = (int) ((this.f7312a * 10.0f) / 1000.0f);
            float f = i;
            this.view.totalScrollY -= f;
            if (!this.view.isLoop) {
                float f2 = this.view.itemHeight;
                float f3 = (-this.view.initPosition) * f2;
                float itemCount = ((this.view.getItemCount() - 1) - this.view.initPosition) * f2;
                double d = this.view.totalScrollY;
                double d2 = f2;
                Double.isNaN(d2);
                double d3 = d2 * 0.25d;
                Double.isNaN(d);
                if (d - d3 < f3) {
                    f3 = this.view.totalScrollY + f;
                } else {
                    double d4 = this.view.totalScrollY;
                    Double.isNaN(d4);
                    if (d4 + d3 > itemCount) {
                        itemCount = this.view.totalScrollY + f;
                    }
                }
                if (this.view.totalScrollY <= f3) {
                    this.f7312a = 40.0f;
                    this.view.totalScrollY = (int) f3;
                } else if (this.view.totalScrollY >= itemCount) {
                    this.view.totalScrollY = (int) itemCount;
                    this.f7312a = -40.0f;
                }
            }
            float f4 = this.f7312a;
            if (f4 < 0.0f) {
                this.f7312a = f4 + 20.0f;
            } else {
                this.f7312a = f4 - 20.0f;
            }
            this.view.handler.sendEmptyMessage(1000);
        }
    }
}
