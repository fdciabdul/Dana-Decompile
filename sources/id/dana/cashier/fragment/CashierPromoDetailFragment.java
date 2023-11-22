package id.dana.cashier.fragment;

import android.os.Bundle;
import android.view.View;
import id.dana.R;
import id.dana.cashier.model.VoucherCashierModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/cashier/fragment/CashierPromoDetailFragment;", "Lid/dana/cashier/fragment/BaseCashierFragment;", "", "getAuthRequestContext", "()V", "", "getLayout", "()I", "getErrorConfigVersion", "moveToNextValue", "Lid/dana/cashier/model/VoucherCashierModel;", "PlaceComponentResult", "Lid/dana/cashier/model/VoucherCashierModel;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPromoDetailFragment extends BaseCashierFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private VoucherCashierModel getAuthRequestContext;

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final View BuiltInFictitiousFunctionClassFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_cashier_promo_detail;
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void getAuthRequestContext() {
        String string = getString(R.string.promo_detail);
        Intrinsics.checkNotNullExpressionValue(string, "");
        getAuthRequestContext(string);
    }

    /* JADX WARN: Code restructure failed: missing block: B:158:0x0154, code lost:
    
        if ((r1.length() > 0) == true) goto L161;
     */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getErrorConfigVersion() {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.CashierPromoDetailFragment.getErrorConfigVersion():void");
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void moveToNextValue() {
        Bundle arguments = getArguments();
        this.getAuthRequestContext = arguments != null ? (VoucherCashierModel) arguments.getParcelable("cashier_promo") : null;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/fragment/CashierPromoDetailFragment$Companion;", "", "Lid/dana/cashier/model/VoucherCashierModel;", "p0", "Lid/dana/cashier/fragment/CashierPromoDetailFragment;", "getAuthRequestContext", "(Lid/dana/cashier/model/VoucherCashierModel;)Lid/dana/cashier/fragment/CashierPromoDetailFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static CashierPromoDetailFragment getAuthRequestContext(VoucherCashierModel p0) {
            CashierPromoDetailFragment cashierPromoDetailFragment = new CashierPromoDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("cashier_promo", p0);
            cashierPromoDetailFragment.setArguments(bundle);
            return cashierPromoDetailFragment;
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
