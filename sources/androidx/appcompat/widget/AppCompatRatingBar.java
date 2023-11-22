package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R;

/* loaded from: classes3.dex */
public class AppCompatRatingBar extends RatingBar {
    private final AppCompatProgressBarHelper BuiltInFictitiousFunctionClassFactory;

    public AppCompatRatingBar(Context context) {
        this(context, null);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.D);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ThemeUtils.getAuthRequestContext(this, getContext());
        AppCompatProgressBarHelper appCompatProgressBarHelper = new AppCompatProgressBarHelper(this);
        this.BuiltInFictitiousFunctionClassFactory = appCompatProgressBarHelper;
        appCompatProgressBarHelper.KClassImpl$Data$declaredNonStaticMembers$2(attributeSet, i);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onMeasure(int i, int i2) {
        synchronized (this) {
            super.onMeasure(i, i2);
            Bitmap authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
            if (authRequestContext != null) {
                setMeasuredDimension(View.resolveSizeAndState(authRequestContext.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
            }
        }
    }
}
