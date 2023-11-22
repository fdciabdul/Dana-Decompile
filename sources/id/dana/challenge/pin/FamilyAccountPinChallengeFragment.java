package id.dana.challenge.pin;

import android.os.Bundle;
import android.view.View;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.ChallengeScenario;
import id.dana.challenge.pin.AbstractPinContract;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\n"}, d2 = {"Lid/dana/challenge/pin/FamilyAccountPinChallengeFragment;", "Lid/dana/challenge/pin/PinChallengeFragment;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/os/Bundle;)V", "Ljava/lang/String;", "moveToNextValue", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "KClassImpl$Data$declaredNonStaticMembers$2", "lookAheadTest", "MyBillsEntityDataFactory", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FamilyAccountPinChallengeFragment extends PinChallengeFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2 = "";

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory = "";
    private String PlaceComponentResult = "";

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private String getAuthRequestContext = "";

    @Override // id.dana.challenge.pin.PinChallengeFragment
    protected final void BuiltInFictitiousFunctionClassFactory(Bundle p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String string = p0.getString(ChallengeControl.Key.PHONE_NUMBER, "");
        Intrinsics.checkNotNullExpressionValue(string, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = string;
        String string2 = p0.getString("address", "");
        Intrinsics.checkNotNullExpressionValue(string2, "");
        this.PlaceComponentResult = string2;
        String string3 = p0.getString(ChallengeControl.Key.RELATION, "");
        Intrinsics.checkNotNullExpressionValue(string3, "");
        this.MyBillsEntityDataFactory = string3;
        String string4 = p0.getString("invitation_id", "");
        Intrinsics.checkNotNullExpressionValue(string4, "");
        this.getAuthRequestContext = string4;
    }

    @Override // id.dana.challenge.pin.PinChallengeFragment
    protected final void PlaceComponentResult(String p0) {
        String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
        Unit unit = null;
        if (BuiltInFictitiousFunctionClassFactory != null) {
            if (Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, "family_account")) {
                AbstractPinContract.Presenter presenter = this.presenter;
                AbstractPinContract.FamilyAccountPinPresenter familyAccountPinPresenter = presenter instanceof AbstractPinContract.FamilyAccountPinPresenter ? (AbstractPinContract.FamilyAccountPinPresenter) presenter : null;
                if (familyAccountPinPresenter != null) {
                    familyAccountPinPresenter.getAuthRequestContext(p0, MyBillsEntityDataFactory(), getErrorConfigVersion(), this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.PlaceComponentResult);
                }
            }
            if (Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, ChallengeScenario.REMOVE_FAMILY_ACCOUNT)) {
                AbstractPinContract.Presenter presenter2 = this.presenter;
                AbstractPinContract.FamilyAccountPinPresenter familyAccountPinPresenter2 = presenter2 instanceof AbstractPinContract.FamilyAccountPinPresenter ? (AbstractPinContract.FamilyAccountPinPresenter) presenter2 : null;
                if (familyAccountPinPresenter2 != null) {
                    familyAccountPinPresenter2.getAuthRequestContext(p0, getErrorConfigVersion());
                }
            }
            if (Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, ChallengeScenario.REMOVE_FAMILY_MEMBER)) {
                AbstractPinContract.Presenter presenter3 = this.presenter;
                AbstractPinContract.FamilyAccountPinPresenter familyAccountPinPresenter3 = presenter3 instanceof AbstractPinContract.FamilyAccountPinPresenter ? (AbstractPinContract.FamilyAccountPinPresenter) presenter3 : null;
                if (familyAccountPinPresenter3 != null) {
                    familyAccountPinPresenter3.MyBillsEntityDataFactory(p0, getErrorConfigVersion(), this.getAuthRequestContext);
                }
            }
            if (Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, ChallengeScenario.JOIN_INVITATION_FAMILY_ACCOUNT)) {
                AbstractPinContract.Presenter presenter4 = this.presenter;
                AbstractPinContract.FamilyAccountPinPresenter familyAccountPinPresenter4 = presenter4 instanceof AbstractPinContract.FamilyAccountPinPresenter ? (AbstractPinContract.FamilyAccountPinPresenter) presenter4 : null;
                if (familyAccountPinPresenter4 != null) {
                    familyAccountPinPresenter4.PlaceComponentResult(p0, getErrorConfigVersion(), this.getAuthRequestContext);
                }
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            super.PlaceComponentResult(p0);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/challenge/pin/FamilyAccountPinChallengeFragment$Companion;", "", "Landroid/os/Bundle;", "p0", "Lid/dana/challenge/pin/FamilyAccountPinChallengeFragment;", "MyBillsEntityDataFactory", "(Landroid/os/Bundle;)Lid/dana/challenge/pin/FamilyAccountPinChallengeFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static FamilyAccountPinChallengeFragment MyBillsEntityDataFactory(Bundle p0) {
            FamilyAccountPinChallengeFragment familyAccountPinChallengeFragment = new FamilyAccountPinChallengeFragment();
            familyAccountPinChallengeFragment.setArguments(p0);
            return familyAccountPinChallengeFragment;
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }
}
