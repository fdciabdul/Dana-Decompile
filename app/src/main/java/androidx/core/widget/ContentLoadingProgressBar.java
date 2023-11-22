package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes6.dex */
public class ContentLoadingProgressBar extends ProgressBar {
    private final Runnable BuiltInFictitiousFunctionClassFactory;
    private final Runnable getAuthRequestContext;
    boolean mDismissed;
    boolean mPostedHide;
    boolean mPostedShow;
    long mStartTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$androidx-core-widget-ContentLoadingProgressBar  reason: not valid java name */
    public /* synthetic */ void m10lambda$new$0$androidxcorewidgetContentLoadingProgressBar() {
        this.mPostedHide = false;
        this.mStartTime = -1L;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$androidx-core-widget-ContentLoadingProgressBar  reason: not valid java name */
    public /* synthetic */ void m11lambda$new$1$androidxcorewidgetContentLoadingProgressBar() {
        this.mPostedShow = false;
        if (this.mDismissed) {
            return;
        }
        this.mStartTime = System.currentTimeMillis();
        setVisibility(0);
    }

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mStartTime = -1L;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.getAuthRequestContext = new Runnable() { // from class: androidx.core.widget.ContentLoadingProgressBar$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.m10lambda$new$0$androidxcorewidgetContentLoadingProgressBar();
            }
        };
        this.BuiltInFictitiousFunctionClassFactory = new Runnable() { // from class: androidx.core.widget.ContentLoadingProgressBar$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.m11lambda$new$1$androidxcorewidgetContentLoadingProgressBar();
            }
        };
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.getAuthRequestContext);
        removeCallbacks(this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.getAuthRequestContext);
        removeCallbacks(this.BuiltInFictitiousFunctionClassFactory);
    }

    public void hide() {
        post(new Runnable() { // from class: androidx.core.widget.ContentLoadingProgressBar$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.$r8$lambda$Ije3417V0uZgdBrD9pbxQ2_AHiI(ContentLoadingProgressBar.this);
            }
        });
    }

    public void show() {
        post(new Runnable() { // from class: androidx.core.widget.ContentLoadingProgressBar$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.m9$r8$lambda$tmknj5M20Tn8TaJxR587u39ZDQ(ContentLoadingProgressBar.this);
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$Ije3417V0uZgdBrD9pbxQ2_AHiI(ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.mDismissed = true;
        contentLoadingProgressBar.removeCallbacks(contentLoadingProgressBar.BuiltInFictitiousFunctionClassFactory);
        contentLoadingProgressBar.mPostedShow = false;
        long currentTimeMillis = System.currentTimeMillis();
        long j = contentLoadingProgressBar.mStartTime;
        long j2 = currentTimeMillis - j;
        if (j2 >= 500 || j == -1) {
            contentLoadingProgressBar.setVisibility(8);
        } else if (contentLoadingProgressBar.mPostedHide) {
        } else {
            contentLoadingProgressBar.postDelayed(contentLoadingProgressBar.getAuthRequestContext, 500 - j2);
            contentLoadingProgressBar.mPostedHide = true;
        }
    }

    /* renamed from: $r8$lambda$tmknj5M20Tn8TaJxR587u-39ZDQ  reason: not valid java name */
    public static /* synthetic */ void m9$r8$lambda$tmknj5M20Tn8TaJxR587u39ZDQ(ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.mStartTime = -1L;
        contentLoadingProgressBar.mDismissed = false;
        contentLoadingProgressBar.removeCallbacks(contentLoadingProgressBar.getAuthRequestContext);
        contentLoadingProgressBar.mPostedHide = false;
        if (contentLoadingProgressBar.mPostedShow) {
            return;
        }
        contentLoadingProgressBar.postDelayed(contentLoadingProgressBar.BuiltInFictitiousFunctionClassFactory, 500L);
        contentLoadingProgressBar.mPostedShow = true;
    }
}
