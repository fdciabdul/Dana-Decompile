package id.dana.savings.withdrawal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.component.dividercomponent.DanaDividerView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B'\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013B+\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0015J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/savings/withdrawal/SavingWithdrawalDestinationView;", "Lid/dana/base/BaseRichView;", "", "enable", "bankOptionExist", "", "enableBankAccountWithdrawal", "(ZZ)V", "", "getLayout", "()I", "setup", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingWithdrawalDestinationView extends BaseRichView {
    public static final String DEFAULT_CURRENY = "Rp";
    public static final String MINIMUM_TARGET_AMOUNT = "10000";
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SavingWithdrawalDestinationView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SavingWithdrawalDestinationView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_destination_withdrawal_saving;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavingWithdrawalDestinationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ SavingWithdrawalDestinationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavingWithdrawalDestinationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void enableBankAccountWithdrawal(boolean enable, boolean bankOptionExist) {
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.cl_second_option);
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(enable ? 0 : 8);
        }
        DanaDividerView danaDividerView = (DanaDividerView) _$_findCachedViewById(R.id.getMaxAppJavaHeapMemoryKb_res_0x7f0a0600);
        if (danaDividerView != null) {
            danaDividerView.setVisibility(enable ? 0 : 8);
        }
        ConstraintLayout constraintLayout3 = (ConstraintLayout) _$_findCachedViewById(R.id.cl_second_option_disable);
        if (constraintLayout3 != null) {
            constraintLayout3.setVisibility(enable ^ true ? 0 : 8);
        }
        if (bankOptionExist || (constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_second_option_disable)) == null) {
            return;
        }
        constraintLayout.setVisibility(8);
    }
}
