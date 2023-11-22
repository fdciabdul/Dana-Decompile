package id.dana.requestmoney.bank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.databinding.FragmentRequestMoneyAddBankCardBinding;
import id.dana.requestmoney.RequestMoneyActivity;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005"}, d2 = {"Lid/dana/requestmoney/bank/RequestMoneyAddBankQrCardFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/databinding/FragmentRequestMoneyAddBankCardBinding;", "", "FragmentBottomSheetPaymentSettingBinding", "()V", "lookAheadTest", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestMoneyAddBankQrCardFragment extends BaseViewBindingFragment<FragmentRequestMoneyAddBankCardBinding> {
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.MyBillsEntityDataFactory;
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

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentRequestMoneyAddBankCardBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentRequestMoneyAddBankCardBinding PlaceComponentResult = FragmentRequestMoneyAddBankCardBinding.PlaceComponentResult(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(RequestMoneyAddBankQrCardFragment requestMoneyAddBankQrCardFragment) {
        Intrinsics.checkNotNullParameter(requestMoneyAddBankQrCardFragment, "");
        FragmentActivity activity = requestMoneyAddBankQrCardFragment.getActivity();
        RequestMoneyActivity requestMoneyActivity = activity instanceof RequestMoneyActivity ? (RequestMoneyActivity) activity : null;
        if (requestMoneyActivity != null) {
            requestMoneyActivity.startAddBankAccountActivity();
        }
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(requestMoneyAddBankQrCardFragment.getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.REQUEST_MONEY_QR_BANK_CREATE;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", TrackerKey.SourceType.QR_CARD);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void FragmentBottomSheetPaymentSettingBinding() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentRequestMoneyAddBankCardBinding) vb).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.requestmoney.bank.RequestMoneyAddBankQrCardFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RequestMoneyAddBankQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2(RequestMoneyAddBankQrCardFragment.this);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }
}
