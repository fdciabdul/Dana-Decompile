package com.alibaba.griver.ui.ant.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.AUImageView;
import com.alibaba.griver.ui.ant.api.IconfontInterface;
import com.alibaba.griver.ui.ant.layout.AUFrameLayout;
import com.alibaba.griver.ui.ant.utils.IconfontConstants;
import com.alibaba.griver.ui.ant.utils.TypefaceCache;
import com.alibaba.griver.ui.ant.utils.UIPropUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class AUIconView extends AUFrameLayout implements IconfontInterface {

    /* renamed from: a  reason: collision with root package name */
    private String f6694a;
    private List<AUTextView> b;
    private AUImageView c;
    private boolean d;
    private float e;
    private int f;
    private boolean g;
    private int h;
    private ColorStateList i;
    private String j;

    public static void __fsTypeCheck_071bbf12e8f756d17a3e22cce18f2382(AUImageView aUImageView, int i) {
        if (aUImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(aUImageView, i);
        } else {
            aUImageView.setImageResource(i);
        }
    }

    @Override // com.alibaba.griver.ui.ant.api.IconfontInterface
    public void destroy() {
    }

    public AUIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6694a = IconfontConstants.DEFAULT_ICONFONT_BUNDLE;
        this.b = new ArrayList();
        this.d = true;
        this.e = -1.0f;
        this.f = 0;
        this.g = true;
        this.i = null;
        this.j = "default";
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.griverIconView);
        if (obtainStyledAttributes.hasValue(R.styleable.griverIconView_iconfontBundle)) {
            setIconfontBundle(obtainStyledAttributes.getString(R.styleable.griverIconView_iconfontBundle));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.griverIconView_iconfontFileName)) {
            setIconfontFileName(obtainStyledAttributes.getString(R.styleable.griverIconView_iconfontFileName));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.griverIconView_iconfontFonts)) {
            try {
                setIconfontFonts(new JSONArray(obtainStyledAttributes.getString(R.styleable.griverIconView_iconfontFonts)));
            } catch (JSONException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("JSONException = ");
                sb.append(e);
                GriverLogger.d("IconView", sb.toString());
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.griverIconView_iconfontUnicode)) {
            setIconfontUnicode(obtainStyledAttributes.getString(R.styleable.griverIconView_iconfontUnicode));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.griverIconView_iconfontSize)) {
            setIconfontSize(obtainStyledAttributes.getDimension(R.styleable.griverIconView_iconfontSize, 24.0f));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.griverIconView_iconfontColor)) {
            setIconfontColorStates(obtainStyledAttributes.getColorStateList(R.styleable.griverIconView_iconfontColor));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.griverIconView_iconImageSize)) {
            this.f = (int) obtainStyledAttributes.getDimension(R.styleable.griverIconView_iconImageSize, 0.0f);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.griverIconView_imageresid)) {
            setImageResource(obtainStyledAttributes.getResourceId(R.styleable.griverIconView_imageresid, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public AUIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AUIconView(Context context) {
        this(context, null);
    }

    public AUIconView(Context context, String str, String str2) {
        this(context, null);
        this.f6694a = str;
        this.j = str2;
    }

    private void a() {
        setIconfontTypeface(TypefaceCache.getTypeface(getContext(), getIconfontBundle(), getTTFFilePath()));
    }

    @Override // com.alibaba.griver.ui.ant.api.IconfontInterface
    public String getIconfontBundle() {
        return this.f6694a;
    }

    public AUIconView setIconfontBundle(String str) {
        this.f6694a = str;
        List<AUTextView> list = this.b;
        if (list != null && !list.isEmpty()) {
            a();
        }
        return this;
    }

    @Override // com.alibaba.griver.ui.ant.api.IconfontInterface
    public Context getIconfontContext() {
        return getContext();
    }

    @Override // com.alibaba.griver.ui.ant.api.IconfontInterface
    public AUIconView setIconfontTypeface(Typeface typeface) {
        if (typeface != null) {
            Iterator<AUTextView> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().setTypeface(typeface);
            }
        }
        return this;
    }

    @Override // com.alibaba.griver.ui.ant.api.IconfontInterface
    public AUIconView setIconfontUnicode(String str) {
        return setText(str, true);
    }

    public AUIconView setText(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        c();
        AUTextView aUTextView = new AUTextView(getContext());
        aUTextView.setGravity(17);
        aUTextView.setText(str);
        setupTextViewCS(aUTextView);
        this.b.add(aUTextView);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(aUTextView, layoutParams);
        if (z) {
            a();
            aUTextView.setContentDescription(" ");
        }
        return this;
    }

    @Override // com.alibaba.griver.ui.ant.api.IconfontInterface
    public AUIconView setImageResource(int i) {
        if (i == 0) {
            return this;
        }
        c();
        b();
        __fsTypeCheck_071bbf12e8f756d17a3e22cce18f2382(this.c, i);
        addView(this.c);
        return this;
    }

    private void b() {
        AUImageView aUImageView = new AUImageView(getContext());
        this.c = aUImageView;
        aUImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.c.setEnabled(this.d);
        setImageViewSize(this.f);
    }

    @Override // com.alibaba.griver.ui.ant.api.IconfontInterface
    public IconfontInterface setImageDrawable(Drawable drawable) {
        c();
        b();
        this.c.setImageDrawable(drawable);
        addView(this.c);
        return this;
    }

    @Override // com.alibaba.griver.ui.ant.api.IconfontInterface
    public AUIconView setIconfontFonts(JSONArray jSONArray) {
        ColorStateList genTextSelector;
        if (jSONArray != null && jSONArray.length() > 0) {
            c();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(IconfontConstants.KEY_ICON_UNICODE);
                    String optString2 = optJSONObject.optString("color");
                    AUTextView aUTextView = new AUTextView(getContext());
                    aUTextView.setGravity(17);
                    aUTextView.setText(optString);
                    setupTextViewCS(aUTextView);
                    if (!TextUtils.isEmpty(optString2)) {
                        try {
                            String[] split = optString2.split(";");
                            if (split != null && split.length == 1) {
                                aUTextView.setTextColor(UIPropUtil.getColorByValue(optString2));
                            } else if (split != null && split.length > 1 && (genTextSelector = UIPropUtil.genTextSelector(getContext(), split)) != null) {
                                aUTextView.setTextColor(genTextSelector);
                            }
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("color parse Exception = ");
                            sb.append(e);
                            GriverLogger.d("IconView", sb.toString());
                        }
                    }
                    this.b.add(aUTextView);
                    addView(aUTextView);
                }
            }
            a();
        }
        return this;
    }

    private void c() {
        removeAllViews();
        this.c = null;
        this.b.clear();
    }

    private void setupTextViewCS(TextView textView) {
        if (textView == null) {
            return;
        }
        boolean z = this.g;
        if (z) {
            textView.setTextColor(this.h);
        } else {
            ColorStateList colorStateList = this.i;
            if (colorStateList != null && !z) {
                textView.setTextColor(colorStateList);
            }
        }
        float f = this.e;
        if (f != -1.0f) {
            textView.setTextSize(0, f);
        }
        textView.setEnabled(this.d);
    }

    @Override // com.alibaba.griver.ui.ant.api.IconfontInterface
    public AUIconView setIconfontColor(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(";");
                if (split != null && split.length == 1) {
                    setIconfontColor(UIPropUtil.getColorByValue(str));
                } else if (split != null && split.length > 1) {
                    setIconfontColorStates(UIPropUtil.genTextSelector(getContext(), split));
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("color parse Exception = ");
                sb.append(e);
                GriverLogger.d("IconView", sb.toString());
            }
        }
        return this;
    }

    public AUIconView setIconfontColor(int i) {
        this.g = true;
        this.h = i;
        for (AUTextView aUTextView : this.b) {
            aUTextView.setTextColor(i);
            aUTextView.setAlpha(Color.alpha(i));
        }
        return this;
    }

    public AUIconView setIconfontColorStates(ColorStateList colorStateList) {
        this.g = false;
        this.i = colorStateList;
        if (colorStateList != null) {
            Iterator<AUTextView> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().setTextColor(colorStateList);
            }
        }
        return this;
    }

    @Override // com.alibaba.griver.ui.ant.api.IconfontInterface
    public AUIconView setIconfontSize(String str) {
        float f = -1.0f;
        try {
            float px = UIPropUtil.getPx(str, getContext());
            if (px != -1.0f) {
                f = px;
            }
        } catch (NumberFormatException unused) {
        }
        setIconfontSize(f);
        return this;
    }

    public AUIconView setIconfontSize(float f) {
        this.e = f;
        if (f != -1.0f) {
            Iterator<AUTextView> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().setTextSize(0, f);
            }
        }
        return this;
    }

    public void setIconTextMinHeight(int i) {
        Iterator<AUTextView> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().setMinHeight(i);
        }
    }

    public void setImageViewSize(int i) {
        if (i == 0) {
            return;
        }
        this.f = i;
        AUImageView aUImageView = this.c;
        if (aUImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aUImageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                layoutParams.width = i;
            } else {
                layoutParams = new FrameLayout.LayoutParams(i, i);
            }
            layoutParams.gravity = 17;
            this.c.setLayoutParams(layoutParams);
        }
    }

    public AUImageView getImageView() {
        if (this.c == null) {
            c();
            b();
            addView(this.c);
        }
        return this.c;
    }

    @Override // com.alibaba.griver.ui.ant.api.IconfontInterface
    public String getIconfontFileName() {
        return this.j;
    }

    @Override // com.alibaba.griver.ui.ant.api.IconfontInterface
    public void setIconfontFileName(String str) {
        this.j = str;
    }

    private String getTTFFilePath() {
        StringBuilder sb = new StringBuilder();
        sb.append(getIconfontBundle());
        sb.append(File.separator);
        sb.append(getIconfontFileName());
        sb.append(".ttf");
        return sb.toString();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.d = z;
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setEnabled(z);
        }
    }

    @Override // android.view.View
    public void setImportantForAccessibility(int i) {
        super.setImportantForAccessibility(i);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).setImportantForAccessibility(i);
        }
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence charSequence) {
        super.setContentDescription(charSequence);
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setContentDescription(charSequence);
        }
    }
}
