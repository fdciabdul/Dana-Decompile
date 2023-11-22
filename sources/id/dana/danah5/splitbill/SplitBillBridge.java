package id.dana.danah5.splitbill;

import android.app.Application;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.constant.BridgeName;
import id.dana.data.util.NumberUtils;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.DefaultObserver;
import id.dana.domain.featureconfig.model.RequestMoneyInfo;
import id.dana.domain.featureconfig.model.SplitBillConfig;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper;
import id.dana.splitbill.SplitBillEventHandler;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J=\u0010\u000b\u001a\u00020\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/danah5/splitbill/SplitBillBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "", "onInitialized", "()V", "", "amount", "notes", "source", "Lcom/alibaba/ariver/app/api/Page;", "page", BridgeName.SPLIT_BILL_BRIDGE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/ariver/app/api/Page;)V", "Lid/dana/splitbill/SplitBillEventHandler;", "splitBillEventHandler", "Lid/dana/splitbill/SplitBillEventHandler;", "getSplitBillEventHandler", "()Lid/dana/splitbill/SplitBillEventHandler;", "setSplitBillEventHandler", "(Lid/dana/splitbill/SplitBillEventHandler;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitBillBridge extends SimpleBridgeExtension {
    @Inject
    public SplitBillEventHandler splitBillEventHandler;

    @JvmName(name = "getSplitBillEventHandler")
    public final SplitBillEventHandler getSplitBillEventHandler() {
        SplitBillEventHandler splitBillEventHandler = this.splitBillEventHandler;
        if (splitBillEventHandler != null) {
            return splitBillEventHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSplitBillEventHandler")
    public final void setSplitBillEventHandler(SplitBillEventHandler splitBillEventHandler) {
        Intrinsics.checkNotNullParameter(splitBillEventHandler, "");
        this.splitBillEventHandler = splitBillEventHandler;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void splitBillBridge(@BindingParam(name = {"amount"}) String amount, @BindingParam(name = {"notes"}) String notes, @BindingParam(name = {"source"}) String source, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(page, "");
        final SplitBillEventHandler splitBillEventHandler = getSplitBillEventHandler();
        Intrinsics.checkNotNullParameter(page, "");
        splitBillEventHandler.getAuthRequestContext = BridgeExtensionExtKt.getActivity(page);
        splitBillEventHandler.NetworkUserEntityData$$ExternalSyntheticLambda0 = page;
        String cleanAll = NumberUtils.getCleanAll(amount);
        if (cleanAll == null) {
            cleanAll = "0";
        }
        splitBillEventHandler.MyBillsEntityDataFactory = cleanAll;
        splitBillEventHandler.getErrorConfigVersion = notes;
        if (source == null) {
            source = "";
        }
        splitBillEventHandler.lookAheadTest = source;
        splitBillEventHandler.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<SplitBillConfig>() { // from class: id.dana.splitbill.SplitBillEventHandler$getSplitBillSplitConfig$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                SplitBillConfig splitBillConfig = (SplitBillConfig) obj;
                Intrinsics.checkNotNullParameter(splitBillConfig, "");
                SplitBillEventHandler.this.PlaceComponentResult = splitBillConfig.getMaxRecipient();
                r2.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<RequestMoneyInfo>() { // from class: id.dana.splitbill.SplitBillEventHandler$getSplitBillAmountConfig$1
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final /* synthetic */ void onNext(Object obj2) {
                        RequestMoneyInfo requestMoneyInfo = (RequestMoneyInfo) obj2;
                        Intrinsics.checkNotNullParameter(requestMoneyInfo, "");
                        SplitBillEventHandler.this.moveToNextValue = new RequestMoneyInfoModelMapper().apply(requestMoneyInfo);
                        SplitBillEventHandler.getAuthRequestContext(SplitBillEventHandler.this);
                    }

                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final void onError(Throwable p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        SplitBillEventHandler.PlaceComponentResult(SplitBillEventHandler.this);
                        StringBuilder sb = new StringBuilder();
                        sb.append("onError: ");
                        sb.append(p0.getMessage());
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SPLIT_BILL_TAG, sb.toString());
                    }
                });
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SplitBillEventHandler.PlaceComponentResult(SplitBillEventHandler.this);
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(p0.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SPLIT_BILL_TAG, sb.toString());
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
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
}
