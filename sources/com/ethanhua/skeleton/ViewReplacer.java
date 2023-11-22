package com.ethanhua.skeleton;

import android.view.View;
import android.view.ViewGroup;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public class ViewReplacer {
    private static final String moveToNextValue = "com.ethanhua.skeleton.ViewReplacer";
    ViewGroup BuiltInFictitiousFunctionClassFactory;
    final View KClassImpl$Data$declaredNonStaticMembers$2;
    View PlaceComponentResult;
    final int getAuthRequestContext;
    final ViewGroup.LayoutParams lookAheadTest;
    View scheduleImpl;
    int getErrorConfigVersion = -1;
    int MyBillsEntityDataFactory = 0;

    public ViewReplacer(View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.lookAheadTest = view.getLayoutParams();
        this.PlaceComponentResult = view;
        this.getAuthRequestContext = view.getId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult() {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            ViewGroup viewGroup = (ViewGroup) this.KClassImpl$Data$declaredNonStaticMembers$2.getParent();
            this.BuiltInFictitiousFunctionClassFactory = viewGroup;
            if (viewGroup == null) {
                InstrumentInjector.log_e(moveToNextValue, "the source view have not attach to any view");
                return false;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 == this.BuiltInFictitiousFunctionClassFactory.getChildAt(i)) {
                    this.MyBillsEntityDataFactory = i;
                    return true;
                }
            }
            return true;
        }
        return true;
    }
}
