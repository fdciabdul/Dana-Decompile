package zoloz.ap.com.toolkit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import zoloz.ap.com.toolkit.R;

/* loaded from: classes9.dex */
public class CustomTextView extends TextView {
    static String fontName;
    private int mImgResId;

    public CustomTextView(Context context) {
        super(context);
        init(context, null);
    }

    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public CustomTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(Context context, AttributeSet attributeSet) {
        context.obtainStyledAttributes(attributeSet, R.styleable.CustomTextView).recycle();
        FontUtils.setFont(this, fontName);
    }

    public static void setFontName(String str) {
        fontName = str;
    }

    public void setTextFont() {
        FontUtils.setFont(this, fontName);
    }

    public void setSize() {
        setTextSize(0, getContext().getResources().getDimension(R.dimen.font_x_large));
    }
}
