package id.dana.danah5.tnccardpayment;

import android.app.Application;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.cashier.TncCardPaymentEventHandler;
import id.dana.danah5.constant.BridgeName;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J/\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/danah5/tnccardpayment/TncCardPaymentBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", "onFinalized", "()V", "onInitialized", "", TncCardPaymentBridge.IS_SIGN, "", "spaceCode", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", BridgeName.TNC_CARD_PAYMENT, "(ZLjava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Lid/dana/cashier/TncCardPaymentEventHandler;", "tncCardPaymentEventHandler", "Lid/dana/cashier/TncCardPaymentEventHandler;", "getTncCardPaymentEventHandler", "()Lid/dana/cashier/TncCardPaymentEventHandler;", "setTncCardPaymentEventHandler", "(Lid/dana/cashier/TncCardPaymentEventHandler;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TncCardPaymentBridge extends BaseBridge {
    private static final String IS_SIGN = "isSign";
    private static final String SPACE_CODE = "spaceCode";
    @Inject
    public TncCardPaymentEventHandler tncCardPaymentEventHandler;

    @JvmName(name = "getTncCardPaymentEventHandler")
    public final TncCardPaymentEventHandler getTncCardPaymentEventHandler() {
        TncCardPaymentEventHandler tncCardPaymentEventHandler = this.tncCardPaymentEventHandler;
        if (tncCardPaymentEventHandler != null) {
            return tncCardPaymentEventHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTncCardPaymentEventHandler")
    public final void setTncCardPaymentEventHandler(TncCardPaymentEventHandler tncCardPaymentEventHandler) {
        Intrinsics.checkNotNullParameter(tncCardPaymentEventHandler, "");
        this.tncCardPaymentEventHandler = tncCardPaymentEventHandler;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void tncCardPayment(@BindingParam(name = {"isSign"}) boolean isSign, @BindingParam(name = {"spaceCode"}) String spaceCode, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        if (isSign) {
            String str = spaceCode;
            if (!(str == null || str.length() == 0)) {
                final TncCardPaymentEventHandler tncCardPaymentEventHandler = getTncCardPaymentEventHandler();
                Intrinsics.checkNotNullParameter(spaceCode, "");
                ?? r4 = 0;
                tncCardPaymentEventHandler.KClassImpl$Data$declaredNonStaticMembers$2.execute(new ConsultAgreementOnlyParamSpaceCodes.Params(CollectionsKt.listOf(spaceCode), r4, 2, r4), new Function1<ConsultAgreementResponse, Unit>() { // from class: id.dana.cashier.TncCardPaymentEventHandler$recordTncCardPaymentAgreement$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(ConsultAgreementResponse consultAgreementResponse) {
                        invoke2(consultAgreementResponse);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(ConsultAgreementResponse consultAgreementResponse) {
                        RecordAgreementOnlyAgreementKey recordAgreementOnlyAgreementKey;
                        Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
                        List<AgreementInfo> agreementInfos = consultAgreementResponse.getAgreementInfos();
                        if (agreementInfos == null || !consultAgreementResponse.getNeedUserAgreement()) {
                            return;
                        }
                        List BuiltInFictitiousFunctionClassFactory = TncCardPaymentEventHandler.BuiltInFictitiousFunctionClassFactory(agreementInfos);
                        recordAgreementOnlyAgreementKey = TncCardPaymentEventHandler.this.PlaceComponentResult;
                        recordAgreementOnlyAgreementKey.execute(new RecordAgreementOnlyAgreementKey.Params(BuiltInFictitiousFunctionClassFactory, true), new Function1<Boolean, Unit>() { // from class: id.dana.cashier.TncCardPaymentEventHandler$recordTncCardPaymentAgreement$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z) {
                                TncCardPaymentEventHandler.Companion companion = TncCardPaymentEventHandler.INSTANCE;
                                TncCardPaymentEventListener MyBillsEntityDataFactory = TncCardPaymentEventHandler.Companion.MyBillsEntityDataFactory();
                                if (MyBillsEntityDataFactory != null) {
                                    MyBillsEntityDataFactory.getAuthRequestContext(z);
                                }
                            }
                        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.TncCardPaymentEventHandler$recordTncCardPaymentAgreement$1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th) {
                                Intrinsics.checkNotNullParameter(th, "");
                                TncCardPaymentEventHandler.Companion companion = TncCardPaymentEventHandler.INSTANCE;
                                TncCardPaymentEventListener MyBillsEntityDataFactory = TncCardPaymentEventHandler.Companion.MyBillsEntityDataFactory();
                                if (MyBillsEntityDataFactory != null) {
                                    MyBillsEntityDataFactory.getAuthRequestContext(false);
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append("onError: ");
                                sb.append(th.getMessage());
                                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TNC_CARD_PAYMENT, sb.toString());
                            }
                        });
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.TncCardPaymentEventHandler$recordTncCardPaymentAgreement$2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                        TncCardPaymentEventHandler.Companion companion = TncCardPaymentEventHandler.INSTANCE;
                        TncCardPaymentEventListener MyBillsEntityDataFactory = TncCardPaymentEventHandler.Companion.MyBillsEntityDataFactory();
                        if (MyBillsEntityDataFactory != null) {
                            MyBillsEntityDataFactory.getAuthRequestContext(false);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("onError: ");
                        sb.append(th.getMessage());
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TNC_CARD_PAYMENT, sb.toString());
                    }
                });
                JSONObject jSONObject = new JSONObject();
                jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
                bridgeCallback.sendJSONResponse(jSONObject);
                return;
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        bridgeCallback.sendJSONResponse(jSONObject2);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        super.onFinalized();
        TncCardPaymentEventHandler tncCardPaymentEventHandler = getTncCardPaymentEventHandler();
        tncCardPaymentEventHandler.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        tncCardPaymentEventHandler.PlaceComponentResult.dispose();
    }
}
