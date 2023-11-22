package com.alibaba.griver.ui.ant.badge;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.core.jsapi.actionsheet.ActionSheetItem;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.text.AUTextView;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class AUBadgeView extends FrameLayout {
    public static final String KEY_BADGE_CONTENT = "badgeText";
    public static final String KEY_BADGE_STYLE = "badgeType";
    protected static final int MAX_MSG_COUNT = 100;

    /* renamed from: a  reason: collision with root package name */
    private boolean f6660a;
    private OnContentChangedListener b;
    protected boolean isCenterLocate;
    protected Context mContext;
    protected volatile boolean mInited;
    protected int mLocateX;
    protected int mLocateY;
    int mTextMaxEms;
    int mTextMaxLength;
    int mTextMaxWidth;
    protected int msgCount;
    protected String msgText;
    protected ImageView pointImageView;
    protected int redHeight;
    protected int redWidth;
    protected Style style;
    protected AUTextView txtTextView;

    /* loaded from: classes6.dex */
    public interface OnContentChangedListener {
        void onChange(Style style, String str);
    }

    @Deprecated
    protected Drawable getBgDrawable(Style style, int i) {
        return null;
    }

    protected float getTextDpSize() {
        return -1.0f;
    }

    public AUBadgeView(Context context) {
        super(context);
        this.style = Style.NONE;
        this.msgCount = 0;
        this.mLocateX = -1;
        this.mLocateY = -1;
        this.redWidth = 0;
        this.redHeight = 0;
        this.mInited = false;
        this.isCenterLocate = false;
        this.mTextMaxEms = -1;
        this.mTextMaxLength = -1;
        this.mTextMaxWidth = -1;
        a(context, (AttributeSet) null);
    }

    public AUBadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.style = Style.NONE;
        this.msgCount = 0;
        this.mLocateX = -1;
        this.mLocateY = -1;
        this.redWidth = 0;
        this.redHeight = 0;
        this.mInited = false;
        this.isCenterLocate = false;
        this.mTextMaxEms = -1;
        this.mTextMaxLength = -1;
        this.mTextMaxWidth = -1;
        a(context, attributeSet);
    }

    public AUBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.style = Style.NONE;
        this.msgCount = 0;
        this.mLocateX = -1;
        this.mLocateY = -1;
        this.redWidth = 0;
        this.redHeight = 0;
        this.mInited = false;
        this.isCenterLocate = false;
        this.mTextMaxEms = -1;
        this.mTextMaxLength = -1;
        this.mTextMaxWidth = -1;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.griver_AUBadgeView);
            this.f6660a = obtainStyledAttributes.getBoolean(R.styleable.griver_AUBadgeView_isSmallTextSize, false);
            this.mTextMaxEms = obtainStyledAttributes.getInt(R.styleable.griver_AUBadgeView_textMaxEms, -1);
            this.mTextMaxLength = obtainStyledAttributes.getInt(R.styleable.griver_AUBadgeView_textMaxLength, -1);
            this.mTextMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.griver_AUBadgeView_textMaxWidth, -1);
            obtainStyledAttributes.recycle();
        }
    }

    protected void lazyInit() {
        synchronized (this) {
            if (this.mInited) {
                return;
            }
            LayoutInflater.from(getContext()).inflate(R.layout.griver_ui_badge_layout, (ViewGroup) this, true);
            this.pointImageView = (ImageView) findViewById(R.id.redPoint);
            AUTextView aUTextView = (AUTextView) findViewById(R.id.msgText);
            this.txtTextView = aUTextView;
            if (this.mTextMaxLength != -1) {
                aUTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.mTextMaxLength)});
            }
            int i = this.mTextMaxWidth;
            if (i != -1) {
                this.txtTextView.setMaxWidth(i);
            }
            this.mInited = true;
        }
    }

    private void a(Style style, String str) {
        if (this.isCenterLocate) {
            if (style == Style.POINT) {
                this.redWidth = DensityUtil.dip2px(this.mContext, 10.0f);
                this.redHeight = DensityUtil.dip2px(this.mContext, 10.0f);
            } else if (style == Style.MORE) {
                this.redWidth = DensityUtil.dip2px(this.mContext, 24.0f);
                this.redHeight = DensityUtil.dip2px(this.mContext, 16.0f);
            } else {
                this.redHeight = DensityUtil.dip2px(this.mContext, 16.0f);
                this.redWidth = (int) this.txtTextView.getPaint().measureText(str);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("measureRedPoint redWidth = ");
            sb.append(this.redWidth);
            sb.append(" redHeight");
            sb.append(this.redHeight);
            sb.append(" x = ");
            sb.append(getX());
            RVLogger.debug("AUBadgeView", sb.toString());
        }
    }

    private void a(Drawable drawable) {
        if (this.isCenterLocate) {
            if (drawable == null) {
                this.redWidth = 35;
                this.redHeight = 35;
                return;
            }
            this.redWidth = drawable.getIntrinsicWidth();
            this.redHeight = drawable.getIntrinsicHeight();
            StringBuilder sb = new StringBuilder();
            sb.append("measureRedPoint redWidth = ");
            sb.append(this.redWidth);
            sb.append(" redHeight");
            sb.append(this.redHeight);
            sb.append(" x = ");
            sb.append(getX());
            RVLogger.debug("AUBadgeView", sb.toString());
        }
    }

    protected void locate() {
        ViewParent parent;
        if (!this.isCenterLocate || this.mLocateX == -1 || this.mLocateY == -1 || (parent = getParent()) == null) {
            return;
        }
        int i = this.mLocateY - (this.redHeight / 2);
        int i2 = this.mLocateX - (this.redWidth / 2);
        StringBuilder sb = new StringBuilder();
        sb.append("locate right = ");
        sb.append(i2);
        sb.append(" top = ");
        sb.append(i);
        sb.append(" redWidth = ");
        sb.append(this.redWidth);
        RVLogger.debug("AUBadgeView", sb.toString());
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (parent instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.setMargins(0, i, i2, 0);
            setLayoutParams(layoutParams);
        } else if (parent instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams2.gravity = 53;
            layoutParams2.setMargins(0, i, i2, 0);
            setLayoutParams(layoutParams2);
        }
    }

    public void setMsgCount(int i, boolean z) {
        this.msgCount = i;
        if (i <= 0) {
            setStyleAndContent(Style.NONE, "");
        } else {
            setStyleAndContent(z ? Style.NUM_WITH_BOARD : Style.NUM, String.valueOf(i));
        }
    }

    public void setRedPoint(boolean z) {
        setStyleAndMsgText(Style.POINT, z ? "1" : "0");
    }

    public void dismiss() {
        setStyleAndContent(Style.NONE, "");
    }

    public void setStyleAndContent(Style style, String str) {
        if (this.b != null && (this.style != style || !TextUtils.equals(this.msgText, str))) {
            this.b.onChange(style, str);
        }
        this.style = style;
        this.msgText = str;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a();
        } else {
            post(new Runnable() { // from class: com.alibaba.griver.ui.ant.badge.AUBadgeView.1
                @Override // java.lang.Runnable
                public void run() {
                    AUBadgeView.this.a();
                }
            });
        }
    }

    public void setOnContentChangedListener(OnContentChangedListener onContentChangedListener) {
        this.b = onContentChangedListener;
    }

    @Deprecated
    public void setStyleAndMsgText(Style style, String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "0") || style == null) {
            style = Style.NONE;
            if (TextUtils.equals(str, "0")) {
                this.msgCount = 0;
            }
        }
        setStyleAndContent(style, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        lazyInit();
        if (this.txtTextView == null || this.pointImageView == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("doRefresh view == null ");
            sb.append(this.txtTextView);
            sb.append(" ");
            sb.append(this.pointImageView);
            RVLogger.e("AUBadgeView", sb.toString());
            return;
        }
        if (this.style == Style.NONE) {
            setVisibility(8);
        } else if (Style.POINT == this.style) {
            a(Style.POINT, R.drawable.griver_ui_shock_point_small);
        } else if (Style.NUM == this.style || Style.NUM_WITH_BOARD == this.style) {
            try {
                int parseInt = Integer.parseInt(this.msgText);
                this.msgCount = parseInt;
                if (parseInt > 0 && parseInt < 100) {
                    b(this.style, this.msgText);
                } else if (parseInt >= 100) {
                    a(Style.MORE, R.drawable.griver_ui_shock_point_more);
                } else {
                    setStyleAndContent(Style.NONE, "");
                }
            } catch (NumberFormatException unused) {
                if (TextUtils.isEmpty(this.msgText)) {
                    RVLogger.debug("AUBadgeView", "Style.NUM with illegal params : msgText is empty");
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Style.NUM with illegal params : msgText = ");
                sb2.append(this.msgText);
                RVLogger.e("AUBadgeView", sb2.toString());
                return;
            }
        } else if (Style.MORE == this.style) {
            a(Style.MORE, R.drawable.griver_ui_shock_point_more);
        } else if (Style.TEXT != this.style && Style.TEXT_WITH_BOARD != this.style) {
            return;
        } else {
            b(this.style, this.msgText);
        }
        locate();
    }

    private void b(Style style, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setVisibility(0);
        this.pointImageView.setVisibility(8);
        this.txtTextView.setVisibility(0);
        float textDpSize = getTextDpSize();
        if (textDpSize > 0.0f) {
            this.txtTextView.setTextSize(1, textDpSize);
        } else if (style == Style.NUM || style == Style.NUM_WITH_BOARD) {
            this.txtTextView.setTextSize(1, 10.0f);
        } else if (this.f6660a && str.length() >= 3 && !a(str)) {
            this.txtTextView.setTextSize(1, 9.0f);
        } else {
            this.txtTextView.setTextSize(1, 11.0f);
        }
        if (this.mTextMaxEms > 0) {
            int length = str.length();
            int i = this.mTextMaxEms;
            if (length > i) {
                AUTextView aUTextView = this.txtTextView;
                double d = i;
                double lineHeight = aUTextView.getLineHeight();
                Double.isNaN(d);
                Double.isNaN(lineHeight);
                aUTextView.setMaxWidth((int) ((d + 0.2d) * lineHeight));
            }
        }
        this.txtTextView.setText(str);
        Drawable bgDrawable = getBgDrawable(style);
        if (bgDrawable != null) {
            this.txtTextView.setBackgroundDrawable(bgDrawable);
            a(bgDrawable);
        } else if (style.getDes().contains("_with_board")) {
            this.txtTextView.setBackgroundResource(R.drawable.griver_ui_shock_point_board_large);
            a(style, str);
        } else {
            this.txtTextView.setBackgroundResource(R.drawable.griver_ui_shock_point_large);
            a(style, str);
        }
    }

    private boolean a(String str) {
        return Pattern.compile("[a-zA-Z]").matcher(str).find();
    }

    private void a(Style style, int i) {
        setVisibility(0);
        this.pointImageView.setVisibility(0);
        this.txtTextView.setVisibility(8);
        Drawable bgDrawable = getBgDrawable(style);
        if (bgDrawable != null) {
            this.pointImageView.setImageDrawable(bgDrawable);
            a(bgDrawable);
            return;
        }
        InstrumentInjector.Resources_setImageResource(this.pointImageView, i);
        a(style, "");
    }

    @Deprecated
    public int getMsgCount() {
        return this.msgCount;
    }

    public void setMaxLines(int i) {
        this.txtTextView.setMaxLines(i);
    }

    protected Drawable getBgDrawable(Style style) {
        return getBgDrawable(style, this.msgCount);
    }

    /* loaded from: classes6.dex */
    public enum Style {
        NONE("none"),
        POINT("point"),
        NUM(ActionSheetItem.BadgeInfo.TYPE_NUM),
        TEXT("text"),
        MORE(ActionSheetItem.BadgeInfo.TYPE_MORE),
        NUM_WITH_BOARD("num_with_board"),
        TEXT_WITH_BOARD("text_with_board");

        private static final Map<String, Style> sStringToEnum = new HashMap();
        private String desc;

        static {
            for (Style style : values()) {
                sStringToEnum.put(style.desc, style);
            }
        }

        Style(String str) {
            this.desc = str;
        }

        public static Style fromString(String str) {
            return sStringToEnum.get(str);
        }

        public final String getDes() {
            return this.desc;
        }
    }
}
