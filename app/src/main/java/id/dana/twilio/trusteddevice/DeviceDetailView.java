package id.dana.twilio.trusteddevice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.griver.api.constants.GriverEvents;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.R;
import id.dana.base.BaseRichView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eB+\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\tJ\u0015\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\t"}, d2 = {"Lid/dana/twilio/trusteddevice/DeviceDetailView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "isShortRight", "", "setBottomDividerShortRight", "(Z)V", "", RVParams.LONG_SUB_TITLE, "contentDesc", "setSubTitle", "(Ljava/lang/String;Ljava/lang/String;)V", "title", GriverEvents.EVENT_SET_TITLE, "(Ljava/lang/String;)V", "setup", "()V", ContainerUIProvider.KEY_SHOW, "showBottomDivider", "isShow", "showTopDivider", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceDetailView extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeviceDetailView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeviceDetailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
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

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.item_menu_device_detail;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceDetailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ DeviceDetailView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceDetailView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.setDrawValueAboveBar);
        if (textView != null) {
            textView.setText(title);
        }
    }

    public static /* synthetic */ void setSubTitle$default(DeviceDetailView deviceDetailView, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        deviceDetailView.setSubTitle(str, str2);
    }

    public final void setSubTitle(String subTitle, String contentDesc) {
        TextView textView;
        Intrinsics.checkNotNullParameter(subTitle, "");
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.paramsForAnalyticsIntent);
        if (textView2 != null) {
            textView2.setText(subTitle);
        }
        if (contentDesc == null || (textView = (TextView) _$_findCachedViewById(R.id.paramsForAnalyticsIntent)) == null) {
            return;
        }
        textView.setContentDescription(contentDesc);
    }

    public final void showTopDivider(boolean isShow) {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.v_line_top);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(isShow ? 0 : 8);
        }
    }

    public final void setBottomDividerShortRight(boolean isShortRight) {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.v_line_bottom_right);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(isShortRight ? 0 : 8);
        }
        View _$_findCachedViewById2 = _$_findCachedViewById(R.id.DanaQuickActionWidgetProvider_MembersInjector);
        if (_$_findCachedViewById2 != null) {
            _$_findCachedViewById2.setVisibility(isShortRight ^ true ? 0 : 8);
        }
    }

    public final void showBottomDivider(boolean show) {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.DanaQuickActionWidgetProvider_MembersInjector);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(show ? 0 : 8);
        }
        View _$_findCachedViewById2 = _$_findCachedViewById(R.id.v_line_bottom_right);
        if (_$_findCachedViewById2 != null) {
            _$_findCachedViewById2.setVisibility(show ? 0 : 8);
        }
    }

    static /* synthetic */ void setContentDesc$default(DeviceDetailView deviceDetailView, String str, int i, Object obj) {
        TextView textView;
        if ((i & 1) != 0) {
            str = null;
        }
        if (str == null || (textView = (TextView) deviceDetailView._$_findCachedViewById(R.id.paramsForAnalyticsIntent)) == null) {
            return;
        }
        textView.setContentDescription(str);
    }
}
