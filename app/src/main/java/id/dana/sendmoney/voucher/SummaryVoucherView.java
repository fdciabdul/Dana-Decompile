package id.dana.sendmoney.voucher;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.contract.sendmoney.voucher.ChangeVoucherContract;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.ChangeVoucherComponent;
import id.dana.di.component.DaggerChangeVoucherComponent;
import id.dana.di.modules.ChangeVoucherModule;
import id.dana.dialog.DialogWithImage;
import id.dana.model.CurrencyAmountModel;
import id.dana.sendmoney.model.VoucherModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001XB'\b\u0016\u0012\u0006\u0010P\u001a\u00020O\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010Q\u0012\b\b\u0002\u0010S\u001a\u00020\u0002¢\u0006\u0004\bT\u0010UB+\b\u0016\u0012\u0006\u0010P\u001a\u00020O\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u0012\u0006\u0010S\u001a\u00020\u0002\u0012\u0006\u0010V\u001a\u00020\u0002¢\u0006\u0004\bT\u0010WJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\u001d\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0007J'\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010 \u001a\u00020\u00052\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\t¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u0007J\u000f\u0010&\u001a\u00020\u0005H\u0002¢\u0006\u0004\b&\u0010\u0007R*\u0010-\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010'8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b \u0010.R.\u00104\u001a\u0004\u0018\u00010\t2\b\u0010/\u001a\u0004\u0018\u00010\t8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u0010$R.\u0010:\u001a\u0004\u0018\u00010\u001d2\b\u0010/\u001a\u0004\u0018\u00010\u001d8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0018\u0010 \u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010<R$\u0010D\u001a\u0004\u0018\u00010=8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bE\u00100R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010'8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bF\u0010(R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bG\u0010.R\"\u0010I\u001a\u00020H8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N"}, d2 = {"Lid/dana/sendmoney/voucher/SummaryVoucherView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "MyBillsEntityDataFactory", "()V", "hideSummaryVoucherView", "", "amount", "transferMethod", "initPrePay", "(Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "getAuthRequestContext", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "Lid/dana/sendmoney/model/VoucherModel;", "p0", "p1", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;Ljava/lang/String;)V", "version", "setVoucherViewVersion", "(Ljava/lang/String;)V", "setup", "PlaceComponentResult", "", "Ljava/util/List;", "getAvailablePayMethods", "()Ljava/util/List;", "setAvailablePayMethods", "(Ljava/util/List;)V", "availablePayMethods", "Z", "value", "Ljava/lang/String;", "getPayMethod", "()Ljava/lang/String;", "setPayMethod", "payMethod", "Lid/dana/sendmoney/model/VoucherModel;", "getSelectedVoucher", "()Lid/dana/sendmoney/model/VoucherModel;", "setSelectedVoucher", "(Lid/dana/sendmoney/model/VoucherModel;)V", "selectedVoucher", "Lid/dana/di/component/ChangeVoucherComponent;", "Lid/dana/di/component/ChangeVoucherComponent;", "Lid/dana/sendmoney/voucher/SummaryVoucherView$SummaryVoucherListener;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/sendmoney/voucher/SummaryVoucherView$SummaryVoucherListener;", "getSummaryVoucherListener", "()Lid/dana/sendmoney/voucher/SummaryVoucherView$SummaryVoucherListener;", "setSummaryVoucherListener", "(Lid/dana/sendmoney/voucher/SummaryVoucherView$SummaryVoucherListener;)V", "summaryVoucherListener", "scheduleImpl", "lookAheadTest", "moveToNextValue", "Lid/dana/contract/sendmoney/voucher/ChangeVoucherContract$Presenter;", "voucherPresenter", "Lid/dana/contract/sendmoney/voucher/ChangeVoucherContract$Presenter;", "getVoucherPresenter", "()Lid/dana/contract/sendmoney/voucher/ChangeVoucherContract$Presenter;", "setVoucherPresenter", "(Lid/dana/contract/sendmoney/voucher/ChangeVoucherContract$Presenter;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "SummaryVoucherListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SummaryVoucherView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private List<String> availablePayMethods;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private VoucherModel selectedVoucher;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private SummaryVoucherListener summaryVoucherListener;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private ChangeVoucherComponent BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String payMethod;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private List<VoucherModel> MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String PlaceComponentResult;
    @Inject
    public ChangeVoucherContract.Presenter voucherPresenter;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/voucher/SummaryVoucherView$SummaryVoucherListener;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "Lid/dana/sendmoney/model/VoucherModel;", "PlaceComponentResult", "(Lid/dana/sendmoney/model/VoucherModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface SummaryVoucherListener {
        void KClassImpl$Data$declaredNonStaticMembers$2(String p0);

        void PlaceComponentResult(VoucherModel p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SummaryVoucherView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SummaryVoucherView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_voucher_summary;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SummaryVoucherView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ SummaryVoucherView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SummaryVoucherView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getVoucherPresenter")
    public final ChangeVoucherContract.Presenter getVoucherPresenter() {
        ChangeVoucherContract.Presenter presenter = this.voucherPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setVoucherPresenter")
    public final void setVoucherPresenter(ChangeVoucherContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.voucherPresenter = presenter;
    }

    @JvmName(name = "getSummaryVoucherListener")
    public final SummaryVoucherListener getSummaryVoucherListener() {
        return this.summaryVoucherListener;
    }

    @JvmName(name = "setSummaryVoucherListener")
    public final void setSummaryVoucherListener(SummaryVoucherListener summaryVoucherListener) {
        this.summaryVoucherListener = summaryVoucherListener;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "setPayMethod")
    public final void setPayMethod(String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str != null ? !Intrinsics.areEqual(str, this.payMethod) : false;
        this.payMethod = str;
        BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, str);
    }

    @JvmName(name = "getSelectedVoucher")
    public final VoucherModel getSelectedVoucher() {
        return this.selectedVoucher;
    }

    @JvmName(name = "setSelectedVoucher")
    public final void setSelectedVoucher(VoucherModel voucherModel) {
        String str;
        String authRequestContext;
        this.selectedVoucher = voucherModel;
        if (voucherModel != null) {
            ((AppCompatTextView) _$_findCachedViewById(R.id.codePointIndexToCharIndex)).setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f22912131099753));
            String str2 = voucherModel.MyBillsEntityDataFactory;
            if (str2 == null || str2.length() == 0) {
                getAuthRequestContext();
            } else {
                String str3 = voucherModel.lookAheadTest;
                AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.getLogSourceName);
                if (appCompatTextView != null) {
                    appCompatTextView.setText(str3);
                }
                CurrencyAmountModel currencyAmountModel = voucherModel.DatabaseTableConfigUtil;
                if (currencyAmountModel != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0987_summaryactivity_handleaccountfreezesmartfriction_1);
                    if (appCompatImageView != null) {
                        appCompatImageView.setVisibility(0);
                    }
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.codePointIndexToCharIndex);
                    if (appCompatTextView2 != null) {
                        if (currencyAmountModel == null || (authRequestContext = currencyAmountModel.getAuthRequestContext()) == null) {
                            str = null;
                        } else {
                            ((AppCompatTextView) _$_findCachedViewById(R.id.codePointIndexToCharIndex)).setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f27152131100507));
                            StringBuilder sb = new StringBuilder();
                            sb.append('-');
                            sb.append(authRequestContext);
                            str = sb.toString();
                        }
                        appCompatTextView2.setText(str);
                    }
                } else {
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0987_summaryactivity_handleaccountfreezesmartfriction_1);
                    if (appCompatImageView2 != null) {
                        appCompatImageView2.setVisibility(8);
                    }
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) _$_findCachedViewById(R.id.codePointIndexToCharIndex);
                    if (appCompatTextView3 != null) {
                        appCompatTextView3.setText(getContext().getString(R.string.voucher_select));
                    }
                }
                setVisibility(0);
            }
        }
        SummaryVoucherListener summaryVoucherListener = this.summaryVoucherListener;
        if (summaryVoucherListener != null) {
            summaryVoucherListener.PlaceComponentResult(this.selectedVoucher);
        }
    }

    @JvmName(name = "getAvailablePayMethods")
    public final List<String> getAvailablePayMethods() {
        return this.availablePayMethods;
    }

    @JvmName(name = "setAvailablePayMethods")
    public final void setAvailablePayMethods(List<String> list) {
        this.availablePayMethods = list;
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        byte b = 0;
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            DaggerChangeVoucherComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerChangeVoucherComponent.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (ChangeVoucherModule) Preconditions.getAuthRequestContext(new ChangeVoucherModule(new ChangeVoucherContract.View() { // from class: id.dana.sendmoney.voucher.SummaryVoucherView$changeVoucherModule$1
                @Override // id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                }

                @Override // id.dana.contract.sendmoney.voucher.ChangeVoucherContract.View
                public final void getAuthRequestContext(ArrayList<VoucherModel> p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (!p0.isEmpty()) {
                        SummaryVoucherView.this.setVisibility(0);
                        ArrayList<VoucherModel> arrayList = p0;
                        SummaryVoucherView.this.MyBillsEntityDataFactory = arrayList;
                        SummaryVoucherView summaryVoucherView = SummaryVoucherView.this;
                        summaryVoucherView.BuiltInFictitiousFunctionClassFactory(arrayList, summaryVoucherView.getPayMethod());
                        return;
                    }
                    SummaryVoucherView.this.setVisibility(8);
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                    SummaryVoucherView.this.showWarningDialog(p0);
                    SummaryVoucherView.this.setVisibility(8);
                }
            }));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, ChangeVoucherModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, ApplicationComponent.class);
            this.BuiltInFictitiousFunctionClassFactory = new DaggerChangeVoucherComponent.ChangeVoucherComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, b);
        }
        ChangeVoucherComponent changeVoucherComponent = this.BuiltInFictitiousFunctionClassFactory;
        if (changeVoucherComponent != null) {
            changeVoucherComponent.PlaceComponentResult(this);
        }
        registerPresenter(getVoucherPresenter());
    }

    private final void getAuthRequestContext() {
        String string = getContext().getString(R.string.no_voucher);
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.getLogSourceName);
        if (appCompatTextView != null) {
            appCompatTextView.setText(string);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.codePointIndexToCharIndex);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(getContext().getString(R.string.voucher_select));
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0987_summaryactivity_handleaccountfreezesmartfriction_1);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(8);
        }
    }

    public final void initPrePay(String amount, String transferMethod) {
        Intrinsics.checkNotNullParameter(amount, "");
        Intrinsics.checkNotNullParameter(transferMethod, "");
        if (Intrinsics.areEqual(amount, "0")) {
            return;
        }
        getVoucherPresenter().MyBillsEntityDataFactory(amount, transferMethod);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(List<? extends VoucherModel> p0, String p1) {
        String str = p1;
        if ((str == null || str.length() == 0) || p0 == null || !(!p0.isEmpty()) == true) {
            return;
        }
        int size = p0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            VoucherModel voucherModel = p0.get(i);
            voucherModel.PlaceComponentResult = i;
            voucherModel.BuiltInFictitiousFunctionClassFactory = voucherModel.MyBillsEntityDataFactory(p1);
            if (voucherModel.BuiltInFictitiousFunctionClassFactory() && !z) {
                if (!KClassImpl$Data$declaredNonStaticMembers$2()) {
                    PlaceComponentResult();
                }
                setSelectedVoucher(voucherModel);
                z = true;
            }
        }
        if (!z) {
            MyBillsEntityDataFactory();
        }
        this.getAuthRequestContext = true;
    }

    private final void MyBillsEntityDataFactory() {
        List<String> list;
        Object obj;
        SummaryVoucherListener summaryVoucherListener;
        setSelectedVoucher(new VoucherModel());
        if (this.getAuthRequestContext) {
            getAuthRequestContext();
            return;
        }
        List<String> list2 = this.availablePayMethods;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        List<VoucherModel> list3 = this.MyBillsEntityDataFactory;
        if ((list3 == null || list3.isEmpty()) || (list = this.availablePayMethods) == null) {
            return;
        }
        for (String str : list) {
            List<VoucherModel> list4 = this.MyBillsEntityDataFactory;
            if (list4 != null) {
                Iterator<T> it = list4.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((VoucherModel) obj).MyBillsEntityDataFactory(str) && this.summaryVoucherListener != null) {
                        break;
                    }
                }
                if (((VoucherModel) obj) != null && (summaryVoucherListener = this.summaryVoucherListener) != null) {
                    summaryVoucherListener.KClassImpl$Data$declaredNonStaticMembers$2(str);
                }
            }
        }
    }

    private final void PlaceComponentResult() {
        if (getBaseActivity() == null || !this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        DialogWithImage.Builder KClassImpl$Data$declaredNonStaticMembers$2 = new DialogWithImage.Builder().MyBillsEntityDataFactory(false).KClassImpl$Data$declaredNonStaticMembers$2(false);
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = R.drawable.ic_voucher_dialog;
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = getContext().getString(R.string.sendmoney_voucher_dialog_title_V2);
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = getContext().getString(R.string.sendmoney_voucher_dialog_desc_V2);
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = getContext().getString(R.string.sendmoney_voucher_dialog_action_V2);
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = new DialogInterface.OnClickListener() { // from class: id.dana.sendmoney.voucher.SummaryVoucherView$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SummaryVoucherView.m2927$r8$lambda$z5qgeML6fIxXHglXZFwXrxVSuc(dialogInterface, i);
            }
        };
        new DialogWithImage(getContext(), KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest, KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).MyBillsEntityDataFactory();
    }

    public final void hideSummaryVoucherView() {
        setVisibility(8);
    }

    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        VoucherModel voucherModel;
        if (requestCode != VoucherDetailActivity.CHANGE_VOUCHER_REQUEST_CODE || resultCode != -1 || data == null || (voucherModel = (VoucherModel) data.getParcelableExtra("voucher")) == null) {
            return;
        }
        setSelectedVoucher(voucherModel);
    }

    public final void setVoucherViewVersion(String version) {
        Intrinsics.checkNotNullParameter(version, "");
        this.PlaceComponentResult = version;
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        String str = this.PlaceComponentResult;
        if (str != null) {
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            }
            if (Intrinsics.areEqual(str, "3.0")) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void $r8$lambda$4ffRorkApgs9dF0LdcGiotm0rWU(SummaryVoucherView summaryVoucherView, View view) {
        Intrinsics.checkNotNullParameter(summaryVoucherView, "");
        if (summaryVoucherView.MyBillsEntityDataFactory == null || summaryVoucherView.payMethod == null) {
            return;
        }
        VoucherModel voucherModel = summaryVoucherView.selectedVoucher;
        summaryVoucherView.getBaseActivity().startActivityForResult(VoucherDetailActivity.createTransferIntent(summaryVoucherView.getBaseActivity(), summaryVoucherView.MyBillsEntityDataFactory, voucherModel != null ? voucherModel.PlaceComponentResult : -99), VoucherDetailActivity.CHANGE_VOUCHER_REQUEST_CODE);
    }

    /* renamed from: $r8$lambda$qmd-Ir_afOVXAEsfbNmN85QfJBE  reason: not valid java name */
    public static /* synthetic */ void m2926$r8$lambda$qmdIr_afOVXAEsfbNmN85QfJBE(SummaryVoucherView summaryVoucherView, View view) {
        Intrinsics.checkNotNullParameter(summaryVoucherView, "");
        String string = summaryVoucherView.getContext().getString(R.string.sendmoney_summary_use_voucher_title);
        AppCompatTextView appCompatTextView = (AppCompatTextView) summaryVoucherView._$_findCachedViewById(R.id.getLogSourceName);
        if (appCompatTextView != null) {
            appCompatTextView.setText(string);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) summaryVoucherView._$_findCachedViewById(R.id.codePointIndexToCharIndex);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(summaryVoucherView.getContext().getString(R.string.voucher_select));
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) summaryVoucherView._$_findCachedViewById(R.id.res_0x7f0a0987_summaryactivity_handleaccountfreezesmartfriction_1);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(8);
        }
        ((AppCompatTextView) summaryVoucherView._$_findCachedViewById(R.id.codePointIndexToCharIndex)).setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(summaryVoucherView.getContext(), R.color.f22912131099753));
        summaryVoucherView.setSelectedVoucher(null);
    }

    /* renamed from: $r8$lambda$z5qgeML6f-IxXHglXZFwXrxVSuc  reason: not valid java name */
    public static /* synthetic */ void m2927$r8$lambda$z5qgeML6fIxXHglXZFwXrxVSuc(DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogInterface, "");
        if (-1 == i) {
            dialogInterface.dismiss();
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.voucher.SummaryVoucherView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SummaryVoucherView.$r8$lambda$4ffRorkApgs9dF0LdcGiotm0rWU(SummaryVoucherView.this, view);
            }
        });
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0987_summaryactivity_handleaccountfreezesmartfriction_1);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.voucher.SummaryVoucherView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SummaryVoucherView.m2926$r8$lambda$qmdIr_afOVXAEsfbNmN85QfJBE(SummaryVoucherView.this, view);
                }
            });
        }
    }
}
