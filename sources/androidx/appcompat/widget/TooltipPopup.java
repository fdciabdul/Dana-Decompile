package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R;

/* loaded from: classes.dex */
class TooltipPopup {
    final View BuiltInFictitiousFunctionClassFactory;
    final WindowManager.LayoutParams KClassImpl$Data$declaredNonStaticMembers$2;
    final Context MyBillsEntityDataFactory;
    final TextView PlaceComponentResult;
    final int[] getAuthRequestContext;
    final int[] lookAheadTest;
    final Rect scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TooltipPopup(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = layoutParams;
        this.scheduleImpl = new Rect();
        this.getAuthRequestContext = new int[2];
        this.lookAheadTest = new int[2];
        this.MyBillsEntityDataFactory = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.NetworkUserEntityData$$ExternalSyntheticLambda3, (ViewGroup) null);
        this.BuiltInFictitiousFunctionClassFactory = inflate;
        this.PlaceComponentResult = (TextView) inflate.findViewById(R.id.NetworkUserEntityData$$ExternalSyntheticLambda6);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.PlaceComponentResult;
        layoutParams.flags = 24;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View PlaceComponentResult(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
