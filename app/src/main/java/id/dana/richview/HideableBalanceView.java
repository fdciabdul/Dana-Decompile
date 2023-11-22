package id.dana.richview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import id.dana.extension.view.ViewExtKt;
import id.dana.utils.BalanceUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 B+\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u001d\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/richview/HideableBalanceView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "amount", "", "setAmount", "(Ljava/lang/String;)V", "", MaintenanceBroadcastResult.KEY_VISIBLE, "setBalanceVisibility", "(Z)V", "resId", "setTextAppearance", "(I)V", "color", "setTextColor", OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT, "", GriverMonitorConstants.KEY_SIZE, "setTextSize", "(IF)V", "setup", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HideableBalanceView extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HideableBalanceView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HideableBalanceView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_hideable_balance;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HideableBalanceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ HideableBalanceView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HideableBalanceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void setTextAppearance(int resId) {
        if (Build.VERSION.SDK_INT >= 23) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1618_snapshotcontroller_1);
            if (textView != null) {
                textView.setTextAppearance(resId);
            }
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1618_snapshotcontroller_1);
            if (textView2 != null) {
                textView2.setTextAppearance(getContext(), resId);
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.tv_amount_hide);
            if (textView3 != null) {
                textView3.setTextAppearance(resId);
            }
        } else {
            TextView textView4 = (TextView) _$_findCachedViewById(R.id.tv_amount_hide);
            if (textView4 != null) {
                textView4.setTextAppearance(getContext(), resId);
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            TextView textView5 = (TextView) _$_findCachedViewById(R.id.tv_currency);
            if (textView5 != null) {
                textView5.setTextAppearance(resId);
                return;
            }
            return;
        }
        TextView textView6 = (TextView) _$_findCachedViewById(R.id.tv_currency);
        if (textView6 != null) {
            textView6.setTextAppearance(getContext(), resId);
        }
    }

    public final void setTextColor(int color) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1618_snapshotcontroller_1);
        if (textView != null) {
            textView.setTextColor(color);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_amount_hide);
        if (textView2 != null) {
            textView2.setTextColor(color);
        }
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.tv_currency);
        if (textView3 != null) {
            textView3.setTextColor(color);
        }
    }

    public final void setTextSize(int unit, float size) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1618_snapshotcontroller_1);
        if (textView != null) {
            textView.setTextSize(unit, size);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_amount_hide);
        if (textView2 != null) {
            textView2.setTextSize(unit, size);
        }
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.tv_currency);
        if (textView3 != null) {
            textView3.setTextSize(unit, size);
        }
    }

    public final void setBalanceVisibility(boolean visible) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1618_snapshotcontroller_1);
        if (textView != null) {
            ViewExtKt.MyBillsEntityDataFactory(textView, visible, 8);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_amount_hide);
        if (textView2 != null) {
            ViewExtKt.MyBillsEntityDataFactory(textView2, !visible, 8);
        }
    }

    public final void setAmount(String amount) {
        Intrinsics.checkNotNullParameter(amount, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1618_snapshotcontroller_1);
        if (textView != null) {
            textView.setText(BalanceUtil.BuiltInFictitiousFunctionClassFactory(amount));
        }
    }
}
