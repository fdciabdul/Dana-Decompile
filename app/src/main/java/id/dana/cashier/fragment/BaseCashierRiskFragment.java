package id.dana.cashier.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.cashier.CashierPinOtpLimiterDialog;
import id.dana.cashier.helper.CashierVariables;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.TopUpVerifyRequestModel;
import id.dana.constants.ErrorCode;
import id.dana.pay.PayActivity;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ImageResize;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b=\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0015H\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0018\u0010\u0006J\u000f\u0010\u0019\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0019\u0010\u0006J'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001aH\u0004¢\u0006\u0004\b\u000b\u0010\u001cR\"\u0010\t\u001a\u00020\u001d8\u0015@\u0015X\u0094\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\u000b\u0010\"R*\u0010\u000b\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u001d8\u0005@EX\u0085\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!\"\u0004\b\u0016\u0010\"R\u0018\u0010\u0005\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010'R&\u0010\u0016\u001a\u0004\u0018\u00010(2\b\u0010\b\u001a\u0004\u0018\u00010(@UX\u0095\n¢\u0006\f\n\u0004\b\u0005\u0010)\"\u0004\b\t\u0010*R*\u00100\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010+8\u0005@\u0005X\u0085\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b\u0016\u0010.\"\u0004\b\u0016\u0010/R\u0014\u0010\f\u001a\u0004\u0018\u000101X\u0085\u0002¢\u0006\u0006\n\u0004\b\t\u00102R\u0014\u0010 \u001a\u0004\u0018\u00010\u0007X\u0085\u0002¢\u0006\u0006\n\u0004\b \u00103R\u0018\u0010$\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010\u0018\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b7\u00106R\u0018\u0010\r\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b8\u00106R\u0012\u0010&\u001a\u000209X\u0085\u0002¢\u0006\u0006\n\u0004\b$\u0010:R\u001a\u0010\u0019\u001a\u0002098\u0005X\u0085\u0006¢\u0006\f\n\u0004\b;\u0010:\u001a\u0004\b\t\u0010<"}, d2 = {"Lid/dana/cashier/fragment/BaseCashierRiskFragment;", "Landroidx/viewbinding/ViewBinding;", "VB", "Lid/dana/cashier/fragment/BaseVBCashierFragment;", "", "PlaceComponentResult", "()V", "Lid/dana/cashier/model/TopUpVerifyRequestModel;", "p0", "MyBillsEntityDataFactory", "(Lid/dana/cashier/model/TopUpVerifyRequestModel;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "onDestroy", "onResume", "Landroid/view/View;", "Landroid/os/Bundle;", "p1", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "getErrorConfigVersion", "DatabaseTableConfigUtil", "", "p2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Z", "moveToNextValue", "()Z", "(Z)V", "GetContactSyncConfig", "scheduleImpl", "Landroid/widget/ImageView;", "initRecordTimeStamp", "Landroid/widget/ImageView;", "Lid/dana/cashier/model/PayResultModel;", "Lid/dana/cashier/model/PayResultModel;", "(Lid/dana/cashier/model/PayResultModel;)V", "", "isLayoutRequested", "Ljava/util/List;", "()Ljava/util/List;", "(Ljava/util/List;)V", "getAuthRequestContext", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/cashier/model/TopUpVerifyRequestModel;", "Landroid/widget/TextView;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Landroid/widget/TextView;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda3", "", "J", "FragmentBottomSheetPaymentSettingBinding", "()J", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseCashierRiskFragment<VB extends ViewBinding> extends BaseVBCashierFragment<VB> {

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private long DatabaseTableConfigUtil;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    CashierPayMethodModel NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private TextView lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private TextView getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private TextView scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private ImageView PlaceComponentResult;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private List<String> getAuthRequestContext;
    TopUpVerifyRequestModel moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    protected long initRecordTimeStamp;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    PayResultModel BuiltInFictitiousFunctionClassFactory = new PayResultModel(null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, -1, 524287, null);

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public View getAuthRequestContext(int i) {
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

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final List<String> BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final void BuiltInFictitiousFunctionClassFactory(List<String> list) {
        this.getAuthRequestContext = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "MyBillsEntityDataFactory")
    public final void MyBillsEntityDataFactory(PayResultModel payResultModel) {
        BaseCashierRiskFragment<VB> baseCashierRiskFragment;
        PayResultModel payResultModel2;
        if (payResultModel == null) {
            payResultModel2 = new PayResultModel(null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, -1, 524287, null);
            baseCashierRiskFragment = this;
        } else {
            baseCashierRiskFragment = this;
            payResultModel2 = payResultModel;
        }
        baseCashierRiskFragment.BuiltInFictitiousFunctionClassFactory = payResultModel2;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    protected void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.MyBillsEntityDataFactory = z;
    }

    @JvmName(name = "moveToNextValue")
    /* renamed from: moveToNextValue  reason: from getter */
    protected boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "scheduleImpl")
    /* renamed from: scheduleImpl  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        PayResultModel payResultModel = this.BuiltInFictitiousFunctionClassFactory;
        if (payResultModel != null) {
            payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final long getDatabaseTableConfigUtil() {
        return this.DatabaseTableConfigUtil;
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getErrorConfigVersion = (TextView) p0.findViewById(R.id.f4286res_0x7f0a14d0_amountformuistate_onsuccesstransfersubmit);
        this.lookAheadTest = (TextView) p0.findViewById(R.id.f4288tvMerchantType);
        this.scheduleImpl = (TextView) p0.findViewById(R.id.tvAmount);
        this.PlaceComponentResult = (ImageView) p0.findViewById(R.id.standardListIterator);
        super.onViewCreated(p0, p1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        TextView textView = this.getErrorConfigVersion;
        if (textView != null) {
            CashierVariables cashierVariables = CashierVariables.INSTANCE;
            textView.setText(CashierVariables.getAuthRequestContext());
        }
        ImageView imageView = this.PlaceComponentResult;
        if (imageView != null) {
            PayResultModel payResultModel = this.BuiltInFictitiousFunctionClassFactory;
            Object obj = payResultModel != null ? payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda5 : null;
            String NetworkUserEntityData$$ExternalSyntheticLambda8 = NetworkUserEntityData$$ExternalSyntheticLambda8();
            Intrinsics.checkNotNullParameter(imageView, "");
            if (Intrinsics.areEqual(NetworkUserEntityData$$ExternalSyntheticLambda8, "Send Money")) {
                obj = Integer.valueOf((int) R.drawable.ic_send_money);
            }
            Context context = imageView.getContext();
            if (context != null) {
                Glide.KClassImpl$Data$declaredNonStaticMembers$2(context).PlaceComponentResult().MyBillsEntityDataFactory(obj).MyBillsEntityDataFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).BuiltInFictitiousFunctionClassFactory((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory(imageView);
            }
        }
        TextView textView2 = this.scheduleImpl;
        if (textView2 != null) {
            CashierVariables cashierVariables2 = CashierVariables.INSTANCE;
            textView2.setText(CashierVariables.MyBillsEntityDataFactory());
        }
        CashierVariables cashierVariables3 = CashierVariables.INSTANCE;
        if (CashierVariables.PlaceComponentResult()) {
            CashierVariables cashierVariables4 = CashierVariables.INSTANCE;
            String BuiltInFictitiousFunctionClassFactory = CashierVariables.BuiltInFictitiousFunctionClassFactory();
            TextView textView3 = this.lookAheadTest;
            if (textView3 != null) {
                textView3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
                textView3.setSingleLine(true);
                textView3.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                textView3.setMarqueeRepeatLimit(-1);
                textView3.setMaxWidth(Integer.MAX_VALUE);
                textView3.setText(BuiltInFictitiousFunctionClassFactory);
                textView3.setSelected(true);
                return;
            }
            return;
        }
        TextView textView4 = this.lookAheadTest;
        if (textView4 != null) {
            CashierVariables cashierVariables5 = CashierVariables.INSTANCE;
            textView4.setText(CashierVariables.BuiltInFictitiousFunctionClassFactory());
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        FragmentActivity activity;
        if (!NetworkUserEntityData$$ExternalSyntheticLambda5() || (activity = getActivity()) == null) {
            return;
        }
        activity.finish();
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public void KClassImpl$Data$declaredNonStaticMembers$2() {
        String string = getString(R.string.title_risk);
        Intrinsics.checkNotNullExpressionValue(string, "");
        MyBillsEntityDataFactory(string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getErrorConfigVersion() {
        FragmentActivity activity = getActivity();
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(2, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        Context context = getContext();
        if (context != null) {
            if (Intrinsics.areEqual(p0, ErrorCode.ERROR_CODE_DANA_ACCOUNT_FROZEN_TEMPORARY)) {
                CashierPinOtpLimiterDialog.BuiltInFictitiousFunctionClassFactory(context, p1, R.string.ok_got_it, new Function1<View, Unit>(this) { // from class: id.dana.cashier.fragment.BaseCashierRiskFragment$showPinOtpLimiterDialog$1$1
                    final /* synthetic */ BaseCashierRiskFragment<VB> this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                        FragmentActivity activity = this.this$0.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                });
            } else if (Intrinsics.areEqual(p0, "AE15112158065208")) {
                CashierPinOtpLimiterDialog.BuiltInFictitiousFunctionClassFactory(context, p1, R.string.account_freeze_dialog_positive_btn, new Function1<View, Unit>(this) { // from class: id.dana.cashier.fragment.BaseCashierRiskFragment$showPinOtpLimiterDialog$1$2
                    final /* synthetic */ BaseCashierRiskFragment<VB> this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                        Intent intent = new Intent("android.intent.action.DIAL");
                        intent.setData(Uri.parse("tel:1500445"));
                        this.this$0.startActivity(intent);
                        FragmentActivity activity = this.this$0.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(TopUpVerifyRequestModel p0) {
        TopUpVerifyRequestModel topUpVerifyRequestModel = this.moveToNextValue;
        if (topUpVerifyRequestModel != null) {
            if (Intrinsics.areEqual(topUpVerifyRequestModel != null ? topUpVerifyRequestModel.getAuthRequestContext : null, p0 != null ? p0.getAuthRequestContext : null)) {
                return;
            }
        }
        this.moveToNextValue = p0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void DatabaseTableConfigUtil() {
        this.initRecordTimeStamp = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void PlaceComponentResult() {
        this.DatabaseTableConfigUtil += DateTimeUtil.BuiltInFictitiousFunctionClassFactory() - this.initRecordTimeStamp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, Throwable p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        if (p1.length() > 0) {
            MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(requireContext(), p0, p1, TrackerDataKey.Source.CASHIER_NATIVE, p2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        FragmentActivity activity = getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        if (payActivity != null) {
            payActivity.setDismissAllowed(true);
        }
        super.onDestroy();
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, androidx.fragment.app.Fragment
    public void onResume() {
        FragmentActivity activity = getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        if (payActivity != null) {
            payActivity.setDismissAllowed(false);
        }
        super.onResume();
    }
}
