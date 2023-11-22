package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.browser.R;

@Deprecated
/* loaded from: classes6.dex */
public class BrowserActionsFallbackMenuView extends LinearLayout {
    private final int KClassImpl$Data$declaredNonStaticMembers$2;
    private final int MyBillsEntityDataFactory;

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getResources().getDimensionPixelOffset(R.dimen.BuiltInFictitiousFunctionClassFactory_res_0x7f07007e);
        this.MyBillsEntityDataFactory = getResources().getDimensionPixelOffset(R.dimen.MyBillsEntityDataFactory_res_0x7f07007d);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.KClassImpl$Data$declaredNonStaticMembers$2 * 2), this.MyBillsEntityDataFactory), 1073741824), i2);
    }
}
