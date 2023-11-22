package id.dana.challenge.pin;

import android.os.Bundle;
import android.view.View;
import com.alipay.iap.android.common.utils.security.RSAHelper;
import id.dana.cardbinding.model.CashierPayParamModel;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.pin.AbstractPinContract;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ!\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\b\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u000f"}, d2 = {"Lid/dana/challenge/pin/CardBindingPinChallengeFragment;", "Lid/dana/challenge/pin/PinChallengeFragment;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/os/Bundle;)V", "Lid/dana/cashier/model/CashierPayModel;", "", "p1", "(Lid/dana/cashier/model/CashierPayModel;Z)V", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "getErrorConfigVersion", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "lookAheadTest", "scheduleImpl", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardBindingPinChallengeFragment extends PinChallengeFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String PlaceComponentResult;

    @Override // id.dana.challenge.pin.PinChallengeFragment
    protected final void BuiltInFictitiousFunctionClassFactory(Bundle p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String string = p0.getString(ChallengeControl.Key.VERIFICATION_METHOD);
        this.PlaceComponentResult = string != null ? string : "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0.getBoolean(ChallengeControl.Key.IS_RISK_PHASE_2);
        this.getAuthRequestContext = p0.getString(ChallengeControl.Key.CASHIER_ORDER_ID);
        this.MyBillsEntityDataFactory = (CashierPayMethodModel.CardPayMethod) p0.getParcelable(ChallengeControl.Key.PAY_METHOD_MODEL);
        this.BuiltInFictitiousFunctionClassFactory = p0.getString(ChallengeControl.Key.PIN_PUB_KEY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.challenge.pin.PinChallengeFragment
    public final void PlaceComponentResult(String p0) {
        CashierPayMethodModel.CardPayMethod cardPayMethod = this.MyBillsEntityDataFactory;
        if (cardPayMethod != null) {
            CashierPayMethodModel.CardPayMethod cardPayMethod2 = cardPayMethod;
            String str = this.getAuthRequestContext;
            String str2 = str == null ? "" : str;
            if (p0 == null) {
                p0 = "";
            }
            String str3 = this.BuiltInFictitiousFunctionClassFactory;
            if (str3 == null) {
                str3 = "";
            }
            String encrypt = RSAHelper.encrypt(p0, str3);
            Intrinsics.checkNotNullExpressionValue(encrypt, "");
            CashierPayParamModel cashierPayParamModel = new CashierPayParamModel(str2, null, null, false, encrypt, this.PlaceComponentResult, cardPayMethod2, false, 142, null);
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                AbstractPinContract.Presenter presenter = this.presenter;
                if (presenter == null) {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.challenge.pin.AbstractPinContract.CardBindingPinPresenter");
                }
                ((AbstractPinContract.CardBindingPinPresenter) presenter).BuiltInFictitiousFunctionClassFactory(cashierPayParamModel);
                return;
            }
            AbstractPinContract.Presenter presenter2 = this.presenter;
            if (presenter2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.challenge.pin.AbstractPinContract.CardBindingPinPresenter");
            }
            ((AbstractPinContract.CardBindingPinPresenter) presenter2).KClassImpl$Data$declaredNonStaticMembers$2(cashierPayParamModel);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/challenge/pin/CardBindingPinChallengeFragment$Companion;", "", "Landroid/os/Bundle;", "p0", "Lid/dana/challenge/pin/CardBindingPinChallengeFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/os/Bundle;)Lid/dana/challenge/pin/CardBindingPinChallengeFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static CardBindingPinChallengeFragment KClassImpl$Data$declaredNonStaticMembers$2(Bundle p0) {
            CardBindingPinChallengeFragment cardBindingPinChallengeFragment = new CardBindingPinChallengeFragment();
            cardBindingPinChallengeFragment.setArguments(p0);
            return cardBindingPinChallengeFragment;
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.challenge.pin.PinChallengeFragment, id.dana.challenge.pin.AbstractPinContract.View
    public final void BuiltInFictitiousFunctionClassFactory(CashierPayModel p0, boolean p1) {
        AttributeCashierPayModel attributeCashierPayModel;
        boolean z = false;
        if (!p1) {
            if (p0 != null && (attributeCashierPayModel = p0.KClassImpl$Data$declaredNonStaticMembers$2) != null && attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
                z = true;
            }
            if (z) {
                getBaseActivity().getIntent().putExtra(ChallengeControl.Key.IS_RISK_PHASE_2, true);
                getBaseActivity().getIntent().putExtra(ChallengeControl.Key.CASHIER_PAY_MODEL, p0);
                getAuthRequestContext();
                return;
            }
            String str = p0 != null ? p0.MyBillsEntityDataFactory : null;
            if (str == null) {
                str = "";
            }
            CashierPayParamModel cashierPayParamModel = new CashierPayParamModel(str, null, null, false, null, null, null, false, 254, null);
            AbstractPinContract.Presenter presenter = this.presenter;
            if (presenter == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.challenge.pin.AbstractPinContract.CardBindingPinPresenter");
            }
            ((AbstractPinContract.CardBindingPinPresenter) presenter).KClassImpl$Data$declaredNonStaticMembers$2(cashierPayParamModel);
            return;
        }
        getBaseActivity().getIntent().putExtra(ChallengeControl.Key.IS_RISK_PHASE_2, false);
        getBaseActivity().getIntent().putExtra(ChallengeControl.Key.CASHIER_PAY_MODEL, p0);
        getAuthRequestContext();
    }
}
