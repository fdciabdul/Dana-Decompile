package id.dana.component.navigationcomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.tabs.TabLayout;
import id.dana.component.R;
import id.dana.component.utils.SizeUtil;

/* loaded from: classes4.dex */
public class DanaNavigationTabLayoutView extends TabLayout {
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    public DanaNavigationTabLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.n, 0, 0);
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getInt(R.styleable.t, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i == 0) {
            setTabIndicatorFullWidth(true);
            setSelectedTabIndicatorColor(getResources().getColor(R.color.PlaceComponentResult));
            setBackgroundColor(getResources().getColor(R.color.scheduleImpl));
            setTabTextColors(getResources().getColor(R.color.BuiltInFictitiousFunctionClassFactory), getResources().getColor(R.color.PlaceComponentResult));
        } else if (i == 1) {
            setSelectedTabIndicator(InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.ic_icon_active_tab));
            setTabIndicatorFullWidth(false);
            setSelectedTabIndicatorColor(getResources().getColor(R.color.scheduleImpl));
            setBackgroundColor(getResources().getColor(R.color.PlaceComponentResult));
            setSelectedTabIndicatorHeight(SizeUtil.PlaceComponentResult(8));
        }
    }
}
