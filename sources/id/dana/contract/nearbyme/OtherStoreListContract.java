package id.dana.contract.nearbyme;

import id.dana.base.AbstractContractKt;
import id.dana.model.OtherStoreListResultModel;
import id.dana.nearbyme.model.MerchantCategoryModel;
import id.dana.nearbyme.model.ShopModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/nearbyme/OtherStoreListContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface OtherStoreListContract {

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0003\u0010\bJ?\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH&¢\u0006\u0004\b\u0011\u0010\u0012J?\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00158'X¦\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0016R\u0014\u0010\u0011\u001a\u00020\r8'X¦\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/nearbyme/OtherStoreListContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "PlaceComponentResult", "()V", "", "Lid/dana/nearbyme/model/MerchantCategoryModel;", "p0", "(Ljava/util/List;)V", "", "", "p1", "p2", "", "p3", "p4", "p5", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;)V", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "", "()Z", "()I"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        int KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, double d, double d2, String str2, String str3);

        void MyBillsEntityDataFactory(String str, double d, double d2, String str2, String str3);

        @JvmName(name = "MyBillsEntityDataFactory")
        boolean MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(List<MerchantCategoryModel> p0);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lid/dana/contract/nearbyme/OtherStoreListContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onGetPromo", "", "shopModelsWithPromo", "", "Lid/dana/nearbyme/model/ShopModel;", "onGetShopListFail", "onGetShopListSuccess", "result", "Lid/dana/model/OtherStoreListResultModel;", "shopModels", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.contract.nearbyme.OtherStoreListContract$View$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static void MyBillsEntityDataFactory(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static void PlaceComponentResult(OtherStoreListResultModel otherStoreListResultModel) {
                Intrinsics.checkNotNullParameter(otherStoreListResultModel, "");
            }
        }

        void BuiltInFictitiousFunctionClassFactory(List<? extends ShopModel> list);

        void getAuthRequestContext();

        void getAuthRequestContext(OtherStoreListResultModel otherStoreListResultModel);

        void getAuthRequestContext(List<? extends ShopModel> list);
    }
}
