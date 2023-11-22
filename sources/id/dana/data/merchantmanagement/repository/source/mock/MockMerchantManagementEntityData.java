package id.dana.data.merchantmanagement.repository.source.mock;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.data.R;
import id.dana.data.merchantmanagement.MerchantManagementEntityData;
import id.dana.data.merchantmanagement.repository.source.network.request.UnbindMerchantRequest;
import id.dana.data.merchantmanagement.repository.source.network.result.BoundMerchantResult;
import id.dana.data.merchantmanagement.repository.source.network.result.UnbindConsultResult;
import id.dana.data.merchantmanagement.repository.source.network.result.UnbindEligibilityCheckResult;
import id.dana.data.storage.Serializer;
import id.dana.data.util.RawUtils;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b \u0010!J/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/data/merchantmanagement/repository/source/mock/MockMerchantManagementEntityData;", "Lid/dana/data/merchantmanagement/MerchantManagementEntityData;", "", "clientId", "merchantId", "divisionId", "Lio/reactivex/Observable;", "Lid/dana/data/merchantmanagement/repository/source/network/result/UnbindEligibilityCheckResult;", "checkUnbindEligibility", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", ZdocRecordService.PAGE_NUMBER, "Lid/dana/data/merchantmanagement/repository/source/network/result/BoundMerchantResult;", "getLinkedMerchants", "(I)Lio/reactivex/Observable;", "Lid/dana/data/merchantmanagement/repository/source/network/result/UnbindConsultResult;", "unbindConsult", "Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindMerchantRequest;", "unbindMerchantRequest", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "unbindMerchant", "(Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindMerchantRequest;)Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "getSerializer", "()Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MockMerchantManagementEntityData implements MerchantManagementEntityData {
    private final Context context;
    private final Serializer serializer;

    @Inject
    public MockMerchantManagementEntityData(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.context = context;
        this.serializer = serializer;
    }

    @JvmName(name = "getContext")
    public final Context getContext() {
        return this.context;
    }

    @JvmName(name = "getSerializer")
    public final Serializer getSerializer() {
        return this.serializer;
    }

    @Override // id.dana.data.merchantmanagement.MerchantManagementEntityData
    public final Observable<BoundMerchantResult> getLinkedMerchants(int pageNumber) {
        Observable<BoundMerchantResult> just = Observable.just(this.serializer.deserialize(RawUtils.jsonRawToString(this.context, R.raw.PlaceComponentResult_res_0x7f120022), BoundMerchantResult.class));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.domain.auth.face.result.SecurityContext, java.lang.String] */
    @Override // id.dana.data.merchantmanagement.MerchantManagementEntityData
    public final Observable<UnbindConsultResult> unbindConsult(String clientId, String merchantId, String divisionId) {
        Intrinsics.checkNotNullParameter(clientId, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        ?? r3 = 0;
        UnbindConsultResult unbindConsultResult = new UnbindConsultResult(r3, r3, 3, r3);
        unbindConsultResult.success = false;
        Observable<UnbindConsultResult> just = Observable.just(unbindConsultResult);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.merchantmanagement.MerchantManagementEntityData
    public final Observable<BaseRpcResult> unbindMerchant(UnbindMerchantRequest unbindMerchantRequest) {
        Intrinsics.checkNotNullParameter(unbindMerchantRequest, "");
        BaseRpcResult baseRpcResult = new BaseRpcResult();
        baseRpcResult.success = true;
        Observable<BaseRpcResult> just = Observable.just(baseRpcResult);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.merchantmanagement.MerchantManagementEntityData
    public final Observable<UnbindEligibilityCheckResult> checkUnbindEligibility(String clientId, String merchantId, String divisionId) {
        Intrinsics.checkNotNullParameter(clientId, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        UnbindEligibilityCheckResult unbindEligibilityCheckResult = new UnbindEligibilityCheckResult("123456789");
        unbindEligibilityCheckResult.success = true;
        Observable<UnbindEligibilityCheckResult> just = Observable.just(unbindEligibilityCheckResult);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
