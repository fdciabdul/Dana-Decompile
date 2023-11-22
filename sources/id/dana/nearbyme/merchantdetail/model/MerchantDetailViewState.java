package id.dana.nearbyme.merchantdetail.model;

import androidx.view.LiveData;
import androidx.view.MutableLiveData;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.nearbyme.model.ShopModel;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\u0007\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/MerchantDetailViewState;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/lang/String;", "Landroidx/lifecycle/MutableLiveData;", "Lid/dana/nearbyme/merchantdetail/model/MerchantInfoModel;", "PlaceComponentResult", "Landroidx/lifecycle/MutableLiveData;", "getAuthRequestContext", "Lid/dana/nearbyme/model/ShopModel;", "Lid/dana/nearbyme/model/ShopModel;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "p0", "p1", "<init>", "(Lid/dana/nearbyme/model/ShopModel;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDetailViewState {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ShopModel PlaceComponentResult;
    public String MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final MutableLiveData<MerchantInfoModel> getAuthRequestContext;

    public MerchantDetailViewState(ShopModel shopModel, String str) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = shopModel;
        this.MyBillsEntityDataFactory = str;
        this.getAuthRequestContext = new MutableLiveData<>();
    }

    public /* synthetic */ MerchantDetailViewState(ShopModel shopModel, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(shopModel, (i & 2) != 0 ? TrackerKey.SourceType.NEARBY_ME_DETAIL : str);
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            List<String> list = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda5;
            Intrinsics.checkNotNullExpressionValue(list, "");
            for (Object obj : list) {
                String str = (String) obj;
                Intrinsics.checkNotNullExpressionValue(str, "");
                if (str.length() > 0) {
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    return (String) obj;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        } catch (Exception unused) {
            Object obj2 = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
            if (obj2 == LiveData.MyBillsEntityDataFactory) {
                obj2 = null;
            }
            MerchantInfoModel merchantInfoModel = (MerchantInfoModel) obj2;
            String authRequestContext = merchantInfoModel != null ? merchantInfoModel.getAuthRequestContext() : null;
            return authRequestContext != null ? authRequestContext : "";
        }
    }
}
