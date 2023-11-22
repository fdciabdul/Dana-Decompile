package zoloz.ap.com.toolkit.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.ref.WeakReference;

/* loaded from: classes9.dex */
public class CustomImgSpan extends DynamicDrawableSpan {
    private final Context mContext;
    private Drawable mDrawable;
    private WeakReference<Drawable> mDrawableRef;
    private int mHeight;
    private int mResourceId;
    private String mResourcePath;
    private final int mSize;
    private final int mTextSize;
    private int mTop;
    private int mWidth;
    private final int maxHeight;
    private final int maxWidth;

    public CustomImgSpan(Context context, int i, int i2, int i3) {
        super(1);
        this.mResourcePath = null;
        this.maxWidth = 300;
        this.maxHeight = 300;
        this.mContext = context;
        this.mResourceId = i;
        this.mSize = i2;
        this.mHeight = i2;
        this.mWidth = i2;
        this.mTextSize = i3;
    }

    public CustomImgSpan(Context context, String str, int i, int i2) {
        super(1);
        this.mResourceId = -1;
        this.maxWidth = 300;
        this.maxHeight = 300;
        this.mContext = context;
        this.mResourcePath = str;
        this.mSize = i;
        this.mTextSize = i2;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.mDrawable == null) {
            try {
                if (this.mResourceId <= 0) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(this.mResourcePath, options);
                    int min = Math.min(Math.round((options.outWidth * 1.0f) / 300.0f), Math.round((options.outHeight * 1.0f) / 300.0f));
                    options.inSampleSize = min > 0 ? min : 1;
                    options.inJustDecodeBounds = false;
                    Bitmap decodeFile = BitmapFactory.decodeFile(this.mResourcePath, options);
                    intrinsicWidth = decodeFile.getWidth();
                    intrinsicHeight = decodeFile.getHeight();
                    this.mDrawable = new BitmapDrawable(decodeFile);
                } else {
                    Drawable Resources_getDrawable = InstrumentInjector.Resources_getDrawable(this.mContext.getResources(), this.mResourceId);
                    this.mDrawable = Resources_getDrawable;
                    intrinsicWidth = Resources_getDrawable.getIntrinsicWidth();
                    intrinsicHeight = this.mDrawable.getIntrinsicHeight();
                }
                if (intrinsicWidth < intrinsicHeight) {
                    int i = this.mSize;
                    this.mHeight = i;
                    this.mWidth = (i * intrinsicWidth) / intrinsicHeight;
                } else {
                    int i2 = this.mSize;
                    this.mWidth = i2;
                    this.mHeight = (i2 * intrinsicHeight) / intrinsicWidth;
                }
                int i3 = this.mTextSize;
                int i4 = this.mHeight;
                int i5 = (i3 - i4) / 2;
                this.mTop = i5;
                this.mDrawable.setBounds(0, i5, this.mWidth, i4 + i5);
            } catch (Exception unused) {
            }
        }
        return this.mDrawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable cachedDrawable = getCachedDrawable();
        canvas.save();
        int i6 = i5 - cachedDrawable.getBounds().bottom;
        if (this.mVerticalAlignment == 1) {
            i6 = ((i3 + ((i5 - i3) / 2)) - ((cachedDrawable.getBounds().bottom - cachedDrawable.getBounds().top) / 2)) - this.mTop;
        }
        canvas.translate(f, i6);
        cachedDrawable.draw(canvas);
        canvas.restore();
    }

    private Drawable getCachedDrawable() {
        WeakReference<Drawable> weakReference = this.mDrawableRef;
        if (weakReference == null || weakReference.get() == null) {
            this.mDrawableRef = new WeakReference<>(getDrawable());
        }
        return this.mDrawableRef.get();
    }
}
