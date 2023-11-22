package id.dana.data.holdlogin.v2.interceptor;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.functions.Function0;

/* loaded from: classes4.dex */
public final /* synthetic */ class HoldLoginV2InterceptorImpl$$ExternalSyntheticLambda0 implements SingleOnSubscribe {
    public final /* synthetic */ HoldLoginV2InterceptorImpl KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ Function0 MyBillsEntityDataFactory;
    public final /* synthetic */ String PlaceComponentResult;
    public final /* synthetic */ Object getAuthRequestContext;

    public /* synthetic */ HoldLoginV2InterceptorImpl$$ExternalSyntheticLambda0(HoldLoginV2InterceptorImpl holdLoginV2InterceptorImpl, String str, Function0 function0, Object obj) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = holdLoginV2InterceptorImpl;
        this.PlaceComponentResult = str;
        this.MyBillsEntityDataFactory = function0;
        this.getAuthRequestContext = obj;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter singleEmitter) {
        HoldLoginV2InterceptorImpl.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.getAuthRequestContext, singleEmitter);
    }
}
