package id.dana.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/richview/FriendshipHomeWidgetBase;", "Lid/dana/richview/HomeWidgetBase;", "", "getLayout", "()I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class FriendshipHomeWidgetBase extends HomeWidgetBase {
    public Map<Integer, View> _$_findViewCache;

    @Override // id.dana.richview.HomeWidgetBase
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.richview.HomeWidgetBase
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

    @Override // id.dana.richview.HomeWidgetBase, id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_friendship_home_widget_base;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendshipHomeWidgetBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
    }
}
