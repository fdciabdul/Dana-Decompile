package id.dana.contract.sendmoney.v2;

import android.text.TextUtils;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.senddigitalmoney.interactor.CheckCardNoPrefixFeature;
import id.dana.domain.senddigitalmoney.interactor.QueryCardWithoutPrefix;
import id.dana.domain.senddigitalmoney.model.CardPrefixQueryInfo;
import id.dana.domain.sendmoney.interactor.GetAllBillerX2B;
import id.dana.domain.sendmoney.model.BillerX2B;
import id.dana.miniprogram.ExtensionsKt;
import id.dana.sendmoney.model.BaseRecipientModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney_v2.model.BillerX2BModel;
import id.dana.sendmoney_v2.model.BillerX2BModelKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*BA\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u001e\u0012\u0006\u0010\"\u001a\u00020\u0015\u0012\u0006\u0010#\u001a\u00020\u000f\u0012\u0006\u0010$\u001a\u00020\u0019\u0012\u0006\u0010%\u001a\u00020\u0017\u0012\u0006\u0010&\u001a\u00020\u0013\u0012\u0006\u0010'\u001a\u00020\u001b¢\u0006\u0004\b(\u0010)J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0005\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0010\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0014\u0010\n\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Lid/dana/contract/sendmoney/v2/BillerX2BPresenter;", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "Lid/dana/sendmoney/model/BaseRecipientModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/model/BaseRecipientModel;)V", "PlaceComponentResult", "()V", "", "getAuthRequestContext", "(Lid/dana/sendmoney/model/BaseRecipientModel;)Z", "onDestroy", "Lid/dana/sendmoney_v2/model/BillerX2BModel;", "(Lid/dana/sendmoney_v2/model/BillerX2BModel;)V", "Lid/dana/domain/senddigitalmoney/interactor/CheckCardNoPrefixFeature;", "MyBillsEntityDataFactory", "Lid/dana/domain/senddigitalmoney/interactor/CheckCardNoPrefixFeature;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/domain/sendmoney/interactor/GetAllBillerX2B;", "Lid/dana/domain/sendmoney/interactor/GetAllBillerX2B;", "Lid/dana/domain/authcode/interactor/GetAuthCode;", "Lid/dana/domain/authcode/interactor/GetAuthCode;", "Lid/dana/domain/senddigitalmoney/interactor/QueryCardWithoutPrefix;", "Lid/dana/domain/senddigitalmoney/interactor/QueryCardWithoutPrefix;", "Lid/dana/domain/recentbank/interactor/SaveRecentBank;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/recentbank/interactor/SaveRecentBank;", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$View;", "moveToNextValue", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$View;", "lookAheadTest", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Lid/dana/contract/sendmoney/v2/BillerX2BContract$View;Lid/dana/domain/sendmoney/interactor/GetAllBillerX2B;Lid/dana/domain/senddigitalmoney/interactor/CheckCardNoPrefixFeature;Lid/dana/domain/senddigitalmoney/interactor/QueryCardWithoutPrefix;Lid/dana/domain/authcode/interactor/GetAuthCode;Lid/dana/data/config/DeviceInformationProvider;Lid/dana/domain/recentbank/interactor/SaveRecentBank;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class BillerX2BPresenter implements BillerX2BContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetAuthCode KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetAllBillerX2B getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final CheckCardNoPrefixFeature BuiltInFictitiousFunctionClassFactory;
    private final SaveRecentBank NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final QueryCardWithoutPrefix PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final DeviceInformationProvider MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final BillerX2BContract.View lookAheadTest;

    @Inject
    public BillerX2BPresenter(BillerX2BContract.View view, GetAllBillerX2B getAllBillerX2B, CheckCardNoPrefixFeature checkCardNoPrefixFeature, QueryCardWithoutPrefix queryCardWithoutPrefix, GetAuthCode getAuthCode, DeviceInformationProvider deviceInformationProvider, SaveRecentBank saveRecentBank) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getAllBillerX2B, "");
        Intrinsics.checkNotNullParameter(checkCardNoPrefixFeature, "");
        Intrinsics.checkNotNullParameter(queryCardWithoutPrefix, "");
        Intrinsics.checkNotNullParameter(getAuthCode, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        Intrinsics.checkNotNullParameter(saveRecentBank, "");
        this.lookAheadTest = view;
        this.getAuthRequestContext = getAllBillerX2B;
        this.BuiltInFictitiousFunctionClassFactory = checkCardNoPrefixFeature;
        this.PlaceComponentResult = queryCardWithoutPrefix;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getAuthCode;
        this.MyBillsEntityDataFactory = deviceInformationProvider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = saveRecentBank;
    }

    @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final BillerX2BModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(GetAuthCode.Params.INSTANCE.forGetAuthCode(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, p0.BuiltInFictitiousFunctionClassFactory, p0.scheduleImpl, p0.getGetAuthRequestContext()), new Function1<AuthCodeResult, Unit>() { // from class: id.dana.contract.sendmoney.v2.BillerX2BPresenter$openBillerPage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(AuthCodeResult authCodeResult) {
                invoke2(authCodeResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AuthCodeResult authCodeResult) {
                DeviceInformationProvider deviceInformationProvider;
                String PlaceComponentResult;
                BillerX2BContract.View view;
                DeviceInformationProvider deviceInformationProvider2;
                Intrinsics.checkNotNullParameter(authCodeResult, "");
                if (BillerX2BModel.this.getLookAheadTest()) {
                    BillerX2BModel billerX2BModel = BillerX2BModel.this;
                    String authCode = authCodeResult.getAuthCode();
                    Intrinsics.checkNotNullExpressionValue(authCode, "");
                    deviceInformationProvider2 = this.MyBillsEntityDataFactory;
                    String deviceUUID = deviceInformationProvider2.getDeviceUUID();
                    Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
                    PlaceComponentResult = BillerX2BModelKt.KClassImpl$Data$declaredNonStaticMembers$2(billerX2BModel, authCode, deviceUUID);
                } else {
                    BillerX2BModel billerX2BModel2 = BillerX2BModel.this;
                    String authCode2 = authCodeResult.getAuthCode();
                    Intrinsics.checkNotNullExpressionValue(authCode2, "");
                    deviceInformationProvider = this.MyBillsEntityDataFactory;
                    String deviceUUID2 = deviceInformationProvider.getDeviceUUID();
                    Intrinsics.checkNotNullExpressionValue(deviceUUID2, "");
                    PlaceComponentResult = BillerX2BModelKt.PlaceComponentResult(billerX2BModel2, authCode2, deviceUUID2);
                }
                view = this.lookAheadTest;
                view.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.sendmoney.v2.BillerX2BPresenter$openBillerPage$2
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
                BillerX2BContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(BillerX2BPresenter.this.getClass().getName());
                sb.append(", on Error: ");
                sb.append(th);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TO_BILLER_TAG, sb.toString());
                if (!(th instanceof GetAuthCode.MissingRequiredUserInfoException)) {
                    view = BillerX2BPresenter.this.lookAheadTest;
                    String message = th.getMessage();
                    view.getAuthRequestContext(message != null ? message : "");
                    return;
                }
                ExtensionsKt.BuiltInFictitiousFunctionClassFactory((GetAuthCode.MissingRequiredUserInfoException) th, "", "Biller", null, "", "", "", false);
            }
        });
    }

    @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.Presenter
    public final void PlaceComponentResult() {
        this.getAuthRequestContext.execute(NoParams.INSTANCE, new Function1<List<? extends BillerX2B>, Unit>() { // from class: id.dana.contract.sendmoney.v2.BillerX2BPresenter$getAllBillerX2B$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends BillerX2B> list) {
                invoke2((List<BillerX2B>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<BillerX2B> list) {
                BillerX2BContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                view = BillerX2BPresenter.this.lookAheadTest;
                view.BuiltInFictitiousFunctionClassFactory(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.sendmoney.v2.BillerX2BPresenter$getAllBillerX2B$2
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
                StringBuilder sb = new StringBuilder();
                sb.append(BillerX2BPresenter.this.getClass().getName());
                sb.append(", on Error: ");
                sb.append(th);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TO_BILLER_TAG, sb.toString());
            }
        });
    }

    @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.Presenter
    public final void PlaceComponentResult(final BaseRecipientModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.lookAheadTest.PlaceComponentResult(true);
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.contract.sendmoney.v2.BillerX2BPresenter$getPrefixBiller$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    String authRequestContext = BaseRecipientModel.this.getAuthRequestContext();
                    if (!(authRequestContext == null || StringsKt.isBlank(authRequestContext))) {
                        BillerX2BPresenter.MyBillsEntityDataFactory(this, BaseRecipientModel.this);
                        return;
                    }
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2(BaseRecipientModel.this);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.sendmoney.v2.BillerX2BPresenter$getPrefixBiller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                BillerX2BContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(BillerX2BPresenter.this.getClass().getName());
                sb.append(", on Error: ");
                sb.append(th);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TO_BILLER_TAG, sb.toString());
                BillerX2BPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                view = BillerX2BPresenter.this.lookAheadTest;
                view.PlaceComponentResult(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final BaseRecipientModel p0) {
        this.getAuthRequestContext.execute(NoParams.INSTANCE, new Function1<List<? extends BillerX2B>, Unit>() { // from class: id.dana.contract.sendmoney.v2.BillerX2BPresenter$checkIsSendToBillerPage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends BillerX2B> list) {
                invoke2((List<BillerX2B>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<BillerX2B> list) {
                BillerX2BContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                BillerX2BPresenter.BuiltInFictitiousFunctionClassFactory(BillerX2BPresenter.this, list, p0);
                view = BillerX2BPresenter.this.lookAheadTest;
                view.PlaceComponentResult(false);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.sendmoney.v2.BillerX2BPresenter$checkIsSendToBillerPage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                BillerX2BContract.View view;
                BillerX2BContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(BillerX2BPresenter.this.getClass().getName());
                sb.append(", on Error: ");
                sb.append(th);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TO_BILLER_TAG, sb.toString());
                view = BillerX2BPresenter.this.lookAheadTest;
                view.getAuthRequestContext(p0);
                view2 = BillerX2BPresenter.this.lookAheadTest;
                view2.PlaceComponentResult(false);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getAuthRequestContext.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.PlaceComponentResult.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
    }

    private static boolean getAuthRequestContext(BaseRecipientModel p0) {
        if (p0 instanceof RecipientModel) {
            RecipientModel recipientModel = (RecipientModel) p0;
            return Intrinsics.areEqual("bank", recipientModel.readMicros) && !StringsKt.equals("Manual Input", recipientModel.SubSequence, true);
        }
        return true;
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BillerX2BPresenter billerX2BPresenter, List list, BaseRecipientModel baseRecipientModel) {
        ArrayList arrayList = new ArrayList();
        BillerX2BModel billerX2BModel = new BillerX2BModel(null, null, null, null, null, null, false, null, false, 511, null);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String instId = ((BillerX2B) next).getInstId();
            String KClassImpl$Data$declaredNonStaticMembers$2 = baseRecipientModel.KClassImpl$Data$declaredNonStaticMembers$2();
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            if (StringsKt.contains$default((CharSequence) instId, (CharSequence) KClassImpl$Data$declaredNonStaticMembers$2, false, 2, (Object) null)) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(Boolean.valueOf(arrayList.add((BillerX2B) it2.next())));
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator it3 = arrayList.iterator();
        while (true) {
            boolean z = true;
            if (!it3.hasNext()) {
                break;
            }
            Object next2 = it3.next();
            BillerX2B billerX2B = (BillerX2B) next2;
            String str = baseRecipientModel.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(str, "");
            if (!StringsKt.startsWith$default(str, billerX2B.getPrefix(), false, 2, (Object) null)) {
                String MyBillsEntityDataFactory = baseRecipientModel.MyBillsEntityDataFactory();
                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                if (!StringsKt.startsWith$default(MyBillsEntityDataFactory, billerX2B.getPrefix(), false, 2, (Object) null)) {
                    z = false;
                }
            }
            if (z) {
                arrayList5.add(next2);
            }
        }
        ArrayList<BillerX2B> arrayList6 = arrayList5;
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
        for (BillerX2B billerX2B2 : arrayList6) {
            String str2 = baseRecipientModel.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            billerX2BModel = BillerX2BModelKt.MyBillsEntityDataFactory(billerX2B2, str2);
            arrayList7.add(Unit.INSTANCE);
        }
        if (billerX2BModel.KClassImpl$Data$declaredNonStaticMembers$2.length() > 0) {
            if (getAuthRequestContext(baseRecipientModel)) {
                billerX2BModel.lookAheadTest = true;
                Intrinsics.checkNotNullParameter("", "");
                billerX2BModel.PlaceComponentResult = "";
            }
            billerX2BPresenter.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(billerX2BModel);
            return;
        }
        billerX2BPresenter.lookAheadTest.getAuthRequestContext(baseRecipientModel);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(final BillerX2BPresenter billerX2BPresenter, final BaseRecipientModel baseRecipientModel) {
        String MyBillsEntityDataFactory = baseRecipientModel.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory == null || MyBillsEntityDataFactory.length() == 0) {
            QueryCardWithoutPrefix queryCardWithoutPrefix = billerX2BPresenter.PlaceComponentResult;
            QueryCardWithoutPrefix.Params.Companion companion = QueryCardWithoutPrefix.Params.INSTANCE;
            String authRequestContext = baseRecipientModel.getAuthRequestContext();
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            queryCardWithoutPrefix.execute(companion.create(authRequestContext), new Function1<CardPrefixQueryInfo, Unit>() { // from class: id.dana.contract.sendmoney.v2.BillerX2BPresenter$getPrefixNumber$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(CardPrefixQueryInfo cardPrefixQueryInfo) {
                    invoke2(cardPrefixQueryInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(CardPrefixQueryInfo cardPrefixQueryInfo) {
                    Intrinsics.checkNotNullParameter(cardPrefixQueryInfo, "");
                    String prefix = cardPrefixQueryInfo.getPrefix();
                    if (!TextUtils.isEmpty(prefix)) {
                        BaseRecipientModel.this.KClassImpl$Data$declaredNonStaticMembers$2(prefix);
                        BillerX2BPresenter.getAuthRequestContext(billerX2BPresenter, BaseRecipientModel.this);
                    }
                    billerX2BPresenter.KClassImpl$Data$declaredNonStaticMembers$2(BaseRecipientModel.this);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.sendmoney.v2.BillerX2BPresenter$getPrefixNumber$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    BillerX2BContract.View view;
                    Intrinsics.checkNotNullParameter(th, "");
                    StringBuilder sb = new StringBuilder();
                    sb.append(BillerX2BPresenter.this.getClass().getName());
                    sb.append(", on Error: ");
                    sb.append(th);
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TO_BILLER_TAG, sb.toString());
                    view = BillerX2BPresenter.this.lookAheadTest;
                    view.PlaceComponentResult(baseRecipientModel);
                }
            });
            return;
        }
        billerX2BPresenter.KClassImpl$Data$declaredNonStaticMembers$2(baseRecipientModel);
    }

    public static final /* synthetic */ void getAuthRequestContext(BillerX2BPresenter billerX2BPresenter, BaseRecipientModel baseRecipientModel) {
        SaveRecentBank saveRecentBank = billerX2BPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0;
        DefaultObserver<Boolean> defaultObserver = new DefaultObserver<Boolean>() { // from class: id.dana.contract.sendmoney.v2.BillerX2BPresenter$updateRecentBank$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getName());
                sb.append(", on Error: ");
                sb.append(p0);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TO_BILLER_TAG, sb.toString());
            }
        };
        String NetworkUserEntityData$$ExternalSyntheticLambda0 = baseRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda0();
        String str = baseRecipientModel.BuiltInFictitiousFunctionClassFactory;
        String str2 = baseRecipientModel.getErrorConfigVersion;
        String BuiltInFictitiousFunctionClassFactory = baseRecipientModel.BuiltInFictitiousFunctionClassFactory();
        String str3 = baseRecipientModel.getAuthRequestContext;
        String KClassImpl$Data$declaredNonStaticMembers$2 = baseRecipientModel.KClassImpl$Data$declaredNonStaticMembers$2();
        String str4 = baseRecipientModel.BuiltInFictitiousFunctionClassFactory;
        String str5 = baseRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
        String str6 = baseRecipientModel.DatabaseTableConfigUtil;
        String str7 = baseRecipientModel.initRecordTimeStamp;
        String authRequestContext = baseRecipientModel.getAuthRequestContext();
        String str8 = baseRecipientModel.getErrorConfigVersion;
        String MyBillsEntityDataFactory = baseRecipientModel.MyBillsEntityDataFactory();
        int i = baseRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
        long j = baseRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        saveRecentBank.execute(defaultObserver, SaveRecentBank.Params.forUpdateRecentBank(NetworkUserEntityData$$ExternalSyntheticLambda0, str, str2, BuiltInFictitiousFunctionClassFactory, str3, KClassImpl$Data$declaredNonStaticMembers$2, str4, str5, str6, str7, authRequestContext, str8, MyBillsEntityDataFactory, i, Long.valueOf(j), baseRecipientModel.getErrorConfigVersion()));
    }
}
