package id.dana.core.ui.util;

import android.graphics.Color;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import id.dana.core.ui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/core/ui/util/ViewUtil;", "", "Landroid/view/View;", "p0", "Landroid/graphics/RectF;", "MyBillsEntityDataFactory", "(Landroid/view/View;)Landroid/graphics/RectF;", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ViewUtil {
    public static final ViewUtil INSTANCE = new ViewUtil();

    private ViewUtil() {
    }

    public static RectF PlaceComponentResult(View p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int[] iArr = new int[2];
        p0.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], r1 + p0.getMeasuredWidth(), iArr[1] + p0.getMeasuredHeight());
    }

    public static RectF MyBillsEntityDataFactory(View p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int[] iArr = new int[2];
        p0.getLocationInWindow(iArr);
        return new RectF(iArr[0], iArr[1], r1 + p0.getMeasuredWidth(), iArr[1] + p0.getMeasuredHeight());
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(View view, String str) {
        int BuiltInFictitiousFunctionClassFactory;
        int i = R.color.MyBillsEntityDataFactory;
        if (view != null) {
            if (TextUtils.isEmpty(str)) {
                BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(view.getContext(), i);
            } else {
                try {
                    BuiltInFictitiousFunctionClassFactory = Color.parseColor(str);
                } catch (Exception unused) {
                    BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(view.getContext(), i);
                }
            }
            view.setBackgroundColor(BuiltInFictitiousFunctionClassFactory);
        }
    }
}
