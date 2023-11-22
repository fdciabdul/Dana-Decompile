package id.dana.sendmoney_v2.landing.contract;

import android.content.Context;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.core.ui.model.UiTextModel;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.recentbank.interactor.RemoveRecentSavedBank;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.recentcontact.interactor.RemoveRecentSavedContact;
import id.dana.domain.recentrecipient.interactor.GetMaxFavoriteAccount;
import id.dana.domain.recentrecipient.interactor.RemoveRecentGroup;
import id.dana.domain.sendmoney.interactor.DeleteGroup;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.util.SendMoneyErrorHelper;
import id.dana.sendmoney_v2.landing.contract.ManageAccountContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\u00020\u0001:\u0001-BI\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u000f\u0012\u0006\u0010\u000b\u001a\u00020\"\u0012\u0006\u0010\r\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020\u001a\u0012\u0006\u0010'\u001a\u00020\u001c\u0012\u0006\u0010(\u001a\u00020\u0017\u0012\u0006\u0010)\u001a\u00020\u0014\u0012\u0006\u0010*\u001a\u00020\u0011¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0003\u0010\u000eR\u0014\u0010\b\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$"}, d2 = {"Lid/dana/sendmoney_v2/landing/contract/ManageAccountPresenter;", "Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$Presenter;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "onDestroy", "Lid/dana/sendmoney/model/RecipientModel;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/model/RecipientModel;)V", "", "p1", "", "p2", "(Lid/dana/sendmoney/model/RecipientModel;Ljava/lang/String;Z)V", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/domain/sendmoney/interactor/DeleteGroup;", "MyBillsEntityDataFactory", "Lid/dana/domain/sendmoney/interactor/DeleteGroup;", "Lid/dana/domain/recentrecipient/interactor/GetMaxFavoriteAccount;", "PlaceComponentResult", "Lid/dana/domain/recentrecipient/interactor/GetMaxFavoriteAccount;", "Lid/dana/domain/recentrecipient/interactor/RemoveRecentGroup;", "getAuthRequestContext", "Lid/dana/domain/recentrecipient/interactor/RemoveRecentGroup;", "Lid/dana/domain/recentbank/interactor/RemoveRecentSavedBank;", "Lid/dana/domain/recentbank/interactor/RemoveRecentSavedBank;", "Lid/dana/domain/recentcontact/interactor/RemoveRecentSavedContact;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/recentcontact/interactor/RemoveRecentSavedContact;", "Lid/dana/domain/recentbank/interactor/SaveRecentBank;", "getErrorConfigVersion", "Lid/dana/domain/recentbank/interactor/SaveRecentBank;", "Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$View;", "scheduleImpl", "Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$View;", "lookAheadTest", "p3", "p4", "p5", "p6", "p7", "<init>", "(Landroid/content/Context;Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$View;Lid/dana/domain/recentbank/interactor/SaveRecentBank;Lid/dana/domain/recentbank/interactor/RemoveRecentSavedBank;Lid/dana/domain/recentcontact/interactor/RemoveRecentSavedContact;Lid/dana/domain/recentrecipient/interactor/RemoveRecentGroup;Lid/dana/domain/recentrecipient/interactor/GetMaxFavoriteAccount;Lid/dana/domain/sendmoney/interactor/DeleteGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManageAccountPresenter implements ManageAccountContract.Presenter {
    private final RemoveRecentSavedBank BuiltInFictitiousFunctionClassFactory;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final DeleteGroup MyBillsEntityDataFactory;
    private final RemoveRecentSavedContact NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final GetMaxFavoriteAccount PlaceComponentResult;
    private final RemoveRecentGroup getAuthRequestContext;
    private final SaveRecentBank getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final ManageAccountContract.View lookAheadTest;

    @Inject
    public ManageAccountPresenter(Context context, ManageAccountContract.View view, SaveRecentBank saveRecentBank, RemoveRecentSavedBank removeRecentSavedBank, RemoveRecentSavedContact removeRecentSavedContact, RemoveRecentGroup removeRecentGroup, GetMaxFavoriteAccount getMaxFavoriteAccount, DeleteGroup deleteGroup) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(saveRecentBank, "");
        Intrinsics.checkNotNullParameter(removeRecentSavedBank, "");
        Intrinsics.checkNotNullParameter(removeRecentSavedContact, "");
        Intrinsics.checkNotNullParameter(removeRecentGroup, "");
        Intrinsics.checkNotNullParameter(getMaxFavoriteAccount, "");
        Intrinsics.checkNotNullParameter(deleteGroup, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.lookAheadTest = view;
        this.getErrorConfigVersion = saveRecentBank;
        this.BuiltInFictitiousFunctionClassFactory = removeRecentSavedBank;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = removeRecentSavedContact;
        this.getAuthRequestContext = removeRecentGroup;
        this.PlaceComponentResult = getMaxFavoriteAccount;
        this.MyBillsEntityDataFactory = deleteGroup;
    }

    @Override // id.dana.sendmoney_v2.landing.contract.ManageAccountContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(RecipientModel p0, String p1, final boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        SaveRecentBank saveRecentBank = this.getErrorConfigVersion;
        DefaultObserver<Boolean> defaultObserver = new DefaultObserver<Boolean>() { // from class: id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$updateRecentBankName$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ManageAccountContract.View view;
                ManageAccountContract.View view2;
                Boolean bool = (Boolean) obj;
                if (p2) {
                    view2 = this.lookAheadTest;
                    view2.getErrorConfigVersion();
                    return;
                }
                view = this.lookAheadTest;
                view.lookAheadTest();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                ManageAccountContract.View view;
                ManageAccountContract.View view2;
                Context context;
                Intrinsics.checkNotNullParameter(p02, "");
                view = this.lookAheadTest;
                view.KClassImpl$Data$declaredNonStaticMembers$2(p02);
                view2 = this.lookAheadTest;
                SendMoneyErrorHelper sendMoneyErrorHelper = SendMoneyErrorHelper.INSTANCE;
                UiTextModel uiTextModel = SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(p02).BuiltInFictitiousFunctionClassFactory;
                context = this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.BuiltInFictitiousFunctionClassFactory(p02, uiTextModel.asString(context), TrackerDataKey.NetworkErrorOperationTypeProperty.SAVE_USER_CONFIG, TrackerDataKey.Source.SEND_MONEY_UPDATE_BANK_NAME);
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getName());
                sb.append(", on Error: ");
                sb.append(p02);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TAG, sb.toString());
            }
        };
        String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda5;
        String str2 = p0.BuiltInFictitiousFunctionClassFactory;
        String str3 = p0.getErrorConfigVersion;
        String BuiltInFictitiousFunctionClassFactory = p0.BuiltInFictitiousFunctionClassFactory();
        String KClassImpl$Data$declaredNonStaticMembers$2 = p0.KClassImpl$Data$declaredNonStaticMembers$2();
        String str4 = p0.BuiltInFictitiousFunctionClassFactory;
        String str5 = p0.NetworkUserEntityData$$ExternalSyntheticLambda2;
        String str6 = p0.DatabaseTableConfigUtil;
        String str7 = p0.initRecordTimeStamp;
        String str8 = p0.NetworkUserEntityData$$ExternalSyntheticLambda8;
        String str9 = p0.getErrorConfigVersion;
        String str10 = p0.FragmentBottomSheetPaymentSettingBinding;
        int i = p0.NetworkUserEntityData$$ExternalSyntheticLambda1;
        long j = p0.NetworkUserEntityData$$ExternalSyntheticLambda0;
        saveRecentBank.execute(defaultObserver, SaveRecentBank.Params.forUpdateRecentBank(str, str2, str3, BuiltInFictitiousFunctionClassFactory, p1, KClassImpl$Data$declaredNonStaticMembers$2, str4, str5, str6, str7, str8, str9, str10, i, Long.valueOf(j), p0.getErrorConfigVersion()));
    }

    @Override // id.dana.sendmoney_v2.landing.contract.ManageAccountContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        BaseUseCase.execute$default(this.PlaceComponentResult, NoParams.INSTANCE, new Function1<Integer, Unit>() { // from class: id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$getMaxFavoriteAccount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                ManageAccountContract.View view;
                view = ManageAccountPresenter.this.lookAheadTest;
                view.getAuthRequestContext(i);
            }
        }, null, 4, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getErrorConfigVersion.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.PlaceComponentResult.dispose();
        this.getAuthRequestContext.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(final ManageAccountPresenter manageAccountPresenter, final RecipientModel recipientModel) {
        DeleteGroup deleteGroup = manageAccountPresenter.MyBillsEntityDataFactory;
        String KClassImpl$Data$declaredNonStaticMembers$2 = recipientModel.KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        deleteGroup.execute(KClassImpl$Data$declaredNonStaticMembers$2, new Function1<String, Unit>() { // from class: id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$doWhenRemoveRecentGroupComplete$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                ManageAccountContract.View view;
                Intrinsics.checkNotNullParameter(str, "");
                view = ManageAccountPresenter.this.lookAheadTest;
                view.BuiltInFictitiousFunctionClassFactory(recipientModel);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$doWhenRemoveRecentGroupComplete$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                ManageAccountPresenter.getAuthRequestContext(ManageAccountPresenter.this, th, TrackerDataKey.Source.SEND_MONEY_QUICK_SEND_REMOVE_GROUP);
            }
        });
    }

    public static final /* synthetic */ void getAuthRequestContext(ManageAccountPresenter manageAccountPresenter, Throwable th, String str) {
        ManageAccountContract.View view = manageAccountPresenter.lookAheadTest;
        SendMoneyErrorHelper sendMoneyErrorHelper = SendMoneyErrorHelper.INSTANCE;
        view.BuiltInFictitiousFunctionClassFactory(th, TrackerDataKey.NetworkErrorOperationTypeProperty.SAVE_USER_CONFIG, SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(th).BuiltInFictitiousFunctionClassFactory.asString(manageAccountPresenter.KClassImpl$Data$declaredNonStaticMembers$2), str);
        manageAccountPresenter.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(th);
        StringBuilder sb = new StringBuilder();
        sb.append(manageAccountPresenter.getClass().getName());
        sb.append(", on Error: ");
        sb.append(th.getMessage());
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TAG, sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r3.equals(id.dana.sendmoney.recipient.RecipientType.GROUP_CONTACT) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0095, code lost:
    
        if (r3.equals(id.dana.sendmoney.recipient.RecipientType.GROUP_BANK) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0097, code lost:
    
        r3 = r24.getAuthRequestContext;
        r4 = r25.KClassImpl$Data$declaredNonStaticMembers$2();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "");
        r3.execute(new id.dana.domain.recentrecipient.interactor.RemoveRecentGroup.Params(r4), new id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$removeRecentTransaction$3(r24, r25), new id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$removeRecentTransaction$4(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b6, code lost:
    
        return;
     */
    @Override // id.dana.sendmoney_v2.landing.contract.ManageAccountContract.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final id.dana.sendmoney.model.RecipientModel r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r3 = r1.readMicros
            if (r3 == 0) goto Lb7
            int r4 = r3.hashCode()
            r5 = -1483531941(0xffffffffa793195b, float:-4.0828187E-15)
            if (r4 == r5) goto L8f
            r5 = 3016252(0x2e063c, float:4.226669E-39)
            if (r4 == r5) goto L2a
            r5 = 602097825(0x23e348a1, float:2.4642149E-17)
            if (r4 != r5) goto Lb7
            java.lang.String r4 = "groupContact"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L97
            goto Lb7
        L2a:
            java.lang.String r2 = "bank"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto Lb7
            id.dana.domain.recentbank.interactor.RemoveRecentSavedBank r2 = r0.BuiltInFictitiousFunctionClassFactory
            id.dana.domain.recentbank.interactor.RemoveRecentSavedBank$Params$Companion r3 = id.dana.domain.recentbank.interactor.RemoveRecentSavedBank.Params.INSTANCE
            java.lang.String r5 = r1.NetworkUserEntityData$$ExternalSyntheticLambda5
            java.lang.String r6 = r1.getErrorConfigVersion
            java.lang.String r7 = r25.PlaceComponentResult()
            java.lang.String r8 = r25.BuiltInFictitiousFunctionClassFactory()
            java.lang.String r9 = r1.getAuthRequestContext
            java.lang.String r10 = r25.KClassImpl$Data$declaredNonStaticMembers$2()
            java.lang.String r11 = r1.BuiltInFictitiousFunctionClassFactory
            java.lang.String r12 = r1.NetworkUserEntityData$$ExternalSyntheticLambda2
            java.lang.String r13 = r1.DatabaseTableConfigUtil
            java.lang.String r14 = r1.initRecordTimeStamp
            java.lang.String r15 = r1.NetworkUserEntityData$$ExternalSyntheticLambda8
            java.lang.String r4 = r1.getErrorConfigVersion
            r16 = r4
            java.lang.String r4 = r1.FragmentBottomSheetPaymentSettingBinding
            r17 = r4
            int r4 = r1.NetworkUserEntityData$$ExternalSyntheticLambda1
            r18 = r4
            r21 = r2
            r22 = r3
            long r2 = r1.NetworkUserEntityData$$ExternalSyntheticLambda0
            boolean r20 = r25.getErrorConfigVersion()
            id.dana.domain.recentrecipient.model.RecentBankRecipient r4 = new id.dana.domain.recentrecipient.model.RecentBankRecipient
            r23 = r4
            java.lang.Long r19 = java.lang.Long.valueOf(r2)
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r2 = r22
            r3 = r23
            id.dana.domain.recentbank.interactor.RemoveRecentSavedBank$Params r2 = r2.create(r3)
            id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$removeRecentTransaction$1 r3 = new id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$removeRecentTransaction$1
            r3.<init>()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$removeRecentTransaction$2 r1 = new id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$removeRecentTransaction$2
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r4 = r21
            r4.execute(r2, r3, r1)
            return
        L8f:
            java.lang.String r4 = "groupBank"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto Lb7
        L97:
            id.dana.domain.recentrecipient.interactor.RemoveRecentGroup r3 = r0.getAuthRequestContext
            java.lang.String r4 = r25.KClassImpl$Data$declaredNonStaticMembers$2()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            id.dana.domain.recentrecipient.interactor.RemoveRecentGroup$Params r2 = new id.dana.domain.recentrecipient.interactor.RemoveRecentGroup$Params
            r2.<init>(r4)
            id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$removeRecentTransaction$3 r4 = new id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$removeRecentTransaction$3
            r4.<init>()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$removeRecentTransaction$4 r1 = new id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$removeRecentTransaction$4
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r3.execute(r2, r4, r1)
            return
        Lb7:
            id.dana.domain.recentcontact.interactor.RemoveRecentSavedContact r2 = r0.NetworkUserEntityData$$ExternalSyntheticLambda0
            id.dana.domain.recentcontact.interactor.RemoveRecentSavedContact$Params$Companion r3 = id.dana.domain.recentcontact.interactor.RemoveRecentSavedContact.Params.INSTANCE
            java.lang.String r5 = r25.KClassImpl$Data$declaredNonStaticMembers$2()
            java.lang.String r6 = r1.getErrorConfigVersion
            java.lang.String r7 = r25.PlaceComponentResult()
            java.lang.String r8 = r25.BuiltInFictitiousFunctionClassFactory()
            int r9 = r1.NetworkUserEntityData$$ExternalSyntheticLambda1
            boolean r10 = r25.getErrorConfigVersion()
            id.dana.domain.recentrecipient.model.RecentContactRecipient r11 = new id.dana.domain.recentrecipient.model.RecentContactRecipient
            r4 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            id.dana.domain.recentcontact.interactor.RemoveRecentSavedContact$Params r3 = r3.create(r11)
            id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$removeRecentTransaction$5 r4 = new id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$removeRecentTransaction$5
            r4.<init>()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$removeRecentTransaction$6 r1 = new id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter$removeRecentTransaction$6
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r2.execute(r3, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.sendmoney.model.RecipientModel):void");
    }
}
