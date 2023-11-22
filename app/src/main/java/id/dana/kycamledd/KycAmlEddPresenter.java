package id.dana.kycamledd;

import dagger.Lazy;
import id.dana.domain.kycamledd.interactor.GetKycAmlEddConsult;
import id.dana.domain.kycamledd.interactor.SubmitEddAmlKyc;
import id.dana.kycamledd.KycAmlEddContract;
import id.dana.kycamledd.model.EddSubmitInfoDTOModel;
import id.dana.kycamledd.model.EddSubmitInfoModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00150\n\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\n¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR0\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\r"}, d2 = {"Lid/dana/kycamledd/KycAmlEddPresenter;", "Lid/dana/kycamledd/KycAmlEddContract$Presenter;", "", "p0", "Lid/dana/kycamledd/model/EddSubmitInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/kycamledd/model/EddSubmitInfoModel;", "", "onDestroy", "()V", "Ldagger/Lazy;", "Lid/dana/domain/kycamledd/interactor/GetKycAmlEddConsult;", "getAuthRequestContext", "Ldagger/Lazy;", "PlaceComponentResult", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "Lid/dana/domain/kycamledd/interactor/SubmitEddAmlKyc;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Lid/dana/kycamledd/KycAmlEddContract$View;", "p1", "p2", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KycAmlEddPresenter implements KycAmlEddContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Lazy<SubmitEddAmlKyc> MyBillsEntityDataFactory;
    public final HashMap<String, String> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Lazy<KycAmlEddContract.View> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Lazy<GetKycAmlEddConsult> PlaceComponentResult;

    @Inject
    public KycAmlEddPresenter(Lazy<KycAmlEddContract.View> lazy, Lazy<GetKycAmlEddConsult> lazy2, Lazy<SubmitEddAmlKyc> lazy3) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.PlaceComponentResult = lazy2;
        this.MyBillsEntityDataFactory = lazy3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap<>();
    }

    public final EddSubmitInfoModel KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.KClassImpl$Data$declaredNonStaticMembers$2.entrySet()) {
            arrayList.add(new EddSubmitInfoDTOModel(entry.getKey(), entry.getValue()));
        }
        return new EddSubmitInfoModel(p0, arrayList);
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
    }
}
