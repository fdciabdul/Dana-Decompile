package id.dana.splitbill;

import android.app.Activity;
import com.alibaba.ariver.app.api.Page;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.requestmoney.model.RequestMoneyInfoModel;
import id.dana.splitbill.view.SplitBillActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0007"}, d2 = {"Lid/dana/splitbill/SplitBillEventHandler;", "", "Landroid/app/Activity;", "getAuthRequestContext", "Landroid/app/Activity;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "Lid/dana/domain/featureconfig/interactor/GetRequestMoneyInfoFeature;", "lookAheadTest", "Lid/dana/domain/featureconfig/interactor/GetRequestMoneyInfoFeature;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/featureconfig/interactor/GetSplitBillConfig;", "Lid/dana/domain/featureconfig/interactor/GetSplitBillConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "I", "PlaceComponentResult", "getErrorConfigVersion", "Lcom/alibaba/ariver/app/api/Page;", "Lcom/alibaba/ariver/app/api/Page;", "Lid/dana/requestmoney/model/RequestMoneyInfoModel;", "Lid/dana/requestmoney/model/RequestMoneyInfoModel;", "moveToNextValue", "p0", "p1", "<init>", "(Lid/dana/domain/featureconfig/interactor/GetRequestMoneyInfoFeature;Lid/dana/domain/featureconfig/interactor/GetSplitBillConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SplitBillEventHandler {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final GetSplitBillConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public Page NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private int PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String getErrorConfigVersion;
    public Activity getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private RequestMoneyInfoModel moveToNextValue;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetRequestMoneyInfoFeature BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String lookAheadTest;

    @Inject
    public SplitBillEventHandler(GetRequestMoneyInfoFeature getRequestMoneyInfoFeature, GetSplitBillConfig getSplitBillConfig) {
        Intrinsics.checkNotNullParameter(getRequestMoneyInfoFeature, "");
        Intrinsics.checkNotNullParameter(getSplitBillConfig, "");
        this.BuiltInFictitiousFunctionClassFactory = getRequestMoneyInfoFeature;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getSplitBillConfig;
    }

    public static final /* synthetic */ void PlaceComponentResult(SplitBillEventHandler splitBillEventHandler) {
        splitBillEventHandler.BuiltInFictitiousFunctionClassFactory.dispose();
        splitBillEventHandler.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }

    public static final /* synthetic */ void getAuthRequestContext(SplitBillEventHandler splitBillEventHandler) {
        Activity activity = splitBillEventHandler.getAuthRequestContext;
        if (activity != null) {
            RequestMoneyInfoModel requestMoneyInfoModel = splitBillEventHandler.moveToNextValue;
            String str = splitBillEventHandler.MyBillsEntityDataFactory;
            activity.startActivity(SplitBillActivity.createSplitBillIntentBridge(activity, requestMoneyInfoModel, str != null ? Long.parseLong(str) : 0L, splitBillEventHandler.getErrorConfigVersion, splitBillEventHandler.PlaceComponentResult, Boolean.TRUE, splitBillEventHandler.lookAheadTest));
        }
    }
}
