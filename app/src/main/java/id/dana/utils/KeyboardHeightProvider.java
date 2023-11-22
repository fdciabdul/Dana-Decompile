package id.dana.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

/* loaded from: classes5.dex */
public class KeyboardHeightProvider extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener {
    private Activity BuiltInFictitiousFunctionClassFactory;
    public HeightListener KClassImpl$Data$declaredNonStaticMembers$2;
    private int PlaceComponentResult;
    private View getAuthRequestContext;

    /* loaded from: classes5.dex */
    public interface HeightListener {
        void onHeightChanged(int i);
    }

    public KeyboardHeightProvider(Activity activity) {
        super(activity);
        this.BuiltInFictitiousFunctionClassFactory = activity;
        View view = new View(activity);
        this.getAuthRequestContext = view;
        setContentView(view);
        this.getAuthRequestContext.getViewTreeObserver().addOnGlobalLayoutListener(this);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(0);
        setHeight(-1);
        setSoftInputMode(16);
        setInputMethodMode(1);
    }

    public final KeyboardHeightProvider BuiltInFictitiousFunctionClassFactory() {
        if (!isShowing()) {
            final View decorView = this.BuiltInFictitiousFunctionClassFactory.getWindow().getDecorView();
            decorView.post(new Runnable() { // from class: id.dana.utils.KeyboardHeightProvider$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardHeightProvider.this.showAtLocation(decorView, 0, 0, 0);
                }
            });
        }
        return this;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.getAuthRequestContext.getWindowVisibleDisplayFrame(rect);
        if (rect.bottom > this.PlaceComponentResult) {
            this.PlaceComponentResult = rect.bottom;
        }
        int i = this.PlaceComponentResult;
        int i2 = rect.bottom;
        HeightListener heightListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (heightListener != null) {
            heightListener.onHeightChanged(i - i2);
        }
    }
}
