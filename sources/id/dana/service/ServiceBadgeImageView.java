package id.dana.service;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R0\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0007@GX\u0086\u000e¢\u0006\u0018\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/service/ServiceBadgeImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "value", "getAuthRequestContext", "I", "getEditState", "()I", "setEditState", "(I)V", "getEditState$annotations", "()V", "editState", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceBadgeImageView extends AppCompatImageView {
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int editState;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ServiceBadgeImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ServiceBadgeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_4d289e9df82d246ad1598f7da1cfa936(ServiceBadgeImageView serviceBadgeImageView, int i) {
        if (serviceBadgeImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(serviceBadgeImageView, i);
        } else {
            serviceBadgeImageView.setImageResource(i);
        }
    }

    public static /* synthetic */ void getEditState$annotations() {
    }

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
    public ServiceBadgeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.editState = 1;
    }

    public /* synthetic */ ServiceBadgeImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getEditState")
    public final int getEditState() {
        return this.editState;
    }

    @JvmName(name = "setEditState")
    public final void setEditState(int i) {
        this.editState = i;
        if (i == 1) {
            setVisibility(0);
            __fsTypeCheck_4d289e9df82d246ad1598f7da1cfa936(this, R.drawable.ic_service_badge_add);
        } else if (i == 2) {
            setVisibility(0);
            __fsTypeCheck_4d289e9df82d246ad1598f7da1cfa936(this, R.drawable.ic_service_badge_remove);
        } else if (i == 3) {
            setVisibility(0);
            __fsTypeCheck_4d289e9df82d246ad1598f7da1cfa936(this, R.drawable.ic_service_badge_swap);
        } else {
            setVisibility(8);
        }
    }
}
