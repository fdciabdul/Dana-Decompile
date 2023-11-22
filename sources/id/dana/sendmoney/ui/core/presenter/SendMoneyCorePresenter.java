package id.dana.sendmoney.ui.core.presenter;

import id.dana.core.ui.model.UiTextModel;
import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.sendmoney.R;
import id.dana.sendmoney.domain.core.interactor.GetSendMoneyApiMigrationConfig;
import id.dana.sendmoney.domain.core.interactor.GetTransferBalanceInit;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
import id.dana.sendmoney.util.HybridCoroutinePresenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0013\u0012\u0006\u0010\u000b\u001a\u00020\u0016\u0012\u0006\u0010\f\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0014\u0010\t\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0014\u0010\u0014\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001aR\u0014\u0010\u000f\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001c"}, d2 = {"Lid/dana/sendmoney/ui/core/presenter/SendMoneyCorePresenter;", "Lid/dana/sendmoney/util/HybridCoroutinePresenter;", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;", "", "p0", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "p2", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lid/dana/domain/account/interactor/GetPhoneNumber;", "Lid/dana/domain/account/interactor/GetPhoneNumber;", "Lid/dana/sendmoney/domain/core/interactor/GetSendMoneyApiMigrationConfig;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/domain/core/interactor/GetSendMoneyApiMigrationConfig;", "Lid/dana/sendmoney/domain/core/interactor/GetTransferBalanceInit;", "Lid/dana/sendmoney/domain/core/interactor/GetTransferBalanceInit;", "PlaceComponentResult", "Lid/dana/domain/account/interactor/GetUserId;", "Lid/dana/domain/account/interactor/GetUserId;", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$View;", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$View;", "p4", "<init>", "(Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$View;Lid/dana/sendmoney/domain/core/interactor/GetSendMoneyApiMigrationConfig;Lid/dana/sendmoney/domain/core/interactor/GetTransferBalanceInit;Lid/dana/domain/account/interactor/GetUserId;Lid/dana/domain/account/interactor/GetPhoneNumber;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyCorePresenter extends HybridCoroutinePresenter implements SendMoneyCoreContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetTransferBalanceInit PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final SendMoneyCoreContract.View getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetSendMoneyApiMigrationConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetUserId MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetPhoneNumber BuiltInFictitiousFunctionClassFactory;

    @Inject
    public SendMoneyCorePresenter(SendMoneyCoreContract.View view, GetSendMoneyApiMigrationConfig getSendMoneyApiMigrationConfig, GetTransferBalanceInit getTransferBalanceInit, GetUserId getUserId, GetPhoneNumber getPhoneNumber) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getSendMoneyApiMigrationConfig, "");
        Intrinsics.checkNotNullParameter(getTransferBalanceInit, "");
        Intrinsics.checkNotNullParameter(getUserId, "");
        Intrinsics.checkNotNullParameter(getPhoneNumber, "");
        this.getAuthRequestContext = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getSendMoneyApiMigrationConfig;
        this.PlaceComponentResult = getTransferBalanceInit;
        this.MyBillsEntityDataFactory = getUserId;
        this.BuiltInFictitiousFunctionClassFactory = getPhoneNumber;
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        BuildersKt.launch$default(this, null, null, new SendMoneyCorePresenter$getSendMoneyApiMigrationConfig$1(this, null), 3, null);
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory(p0, p1);
        BuildersKt.launch$default(this, null, null, new SendMoneyCorePresenter$getTransferBalanceInit$1(this, p0, p1, p2, null), 3, null);
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (p0.length() > 0) {
            BuildersKt.launch$default(this, null, null, new SendMoneyCorePresenter$checkIfUserSendToSelf$1(this, p0, null), 3, null);
        }
        if (p1.length() > 0) {
            BuildersKt.launch$default(this, null, null, new SendMoneyCorePresenter$checkIfUserSendToSelf$2(this, p1, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getAuthRequestContext(String p0, String p1) {
        if (p0.length() > 0) {
            return Intrinsics.areEqual(PhoneNumberUtilKt.replaceIndoPhonePrefixWithRegionDash(p0), PhoneNumberUtilKt.replaceIndoPhonePrefixWithRegionDash(p1));
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Object[]] */
    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(SendMoneyCorePresenter sendMoneyCorePresenter) {
        ?? r3 = 0;
        sendMoneyCorePresenter.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new UiTextModel.StringResource(R.string.send_to_self_number_error, r3, 2, r3));
        sendMoneyCorePresenter.getAuthRequestContext.PlaceComponentResult();
    }
}
