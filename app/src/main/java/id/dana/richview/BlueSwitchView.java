package id.dana.richview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/richview/BlueSwitchView;", "Landroidx/appcompat/widget/SwitchCompat;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BlueSwitchView extends SwitchCompat {
    public Map<Integer, View> _$_findViewCache;

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlueSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
        KClassImpl$Data$declaredNonStaticMembers$2 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(context.getResources(), 17170443, context.getTheme());
        setThumbTintList(KClassImpl$Data$declaredNonStaticMembers$2);
        setTrackTintList(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{-16842912}, new int[]{16842912}}, new int[]{ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f27012131100470), ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f27012131100470), ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.azure)}));
    }
}
