package id.dana.contract.globalsearch;

import com.alibaba.ariver.kernel.RVEvents;
import id.dana.contract.globalsearch.GlobalSearchBottomSheetContract;
import id.dana.domain.nearbyme.interactor.GetMerchantInfo;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.nearbyme.merchantdetail.mapper.MerchantInfoMapper;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.Calendar;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0011\u0012\u0006\u0010\u0004\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u000e\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/contract/globalsearch/GlobalSearchBottomSheetPresenter;", "Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$Presenter;", "", "p0", "p1", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "()V", "Lid/dana/domain/nearbyme/interactor/GetMerchantInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/nearbyme/interactor/GetMerchantInfo;", "Lid/dana/nearbyme/merchantdetail/mapper/MerchantInfoMapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantdetail/mapper/MerchantInfoMapper;", "getAuthRequestContext", "Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$View;", "PlaceComponentResult", "Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$View;", "p2", "<init>", "(Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$View;Lid/dana/domain/nearbyme/interactor/GetMerchantInfo;Lid/dana/nearbyme/merchantdetail/mapper/MerchantInfoMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GlobalSearchBottomSheetPresenter implements GlobalSearchBottomSheetContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final MerchantInfoMapper getAuthRequestContext;
    private final GetMerchantInfo KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GlobalSearchBottomSheetContract.View BuiltInFictitiousFunctionClassFactory;

    @Inject
    public GlobalSearchBottomSheetPresenter(GlobalSearchBottomSheetContract.View view, GetMerchantInfo getMerchantInfo, MerchantInfoMapper merchantInfoMapper) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getMerchantInfo, "");
        Intrinsics.checkNotNullParameter(merchantInfoMapper, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getMerchantInfo;
        this.getAuthRequestContext = merchantInfoMapper;
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchBottomSheetContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new GetMerchantInfo.Params(p0, p1, false, 4, null), new Function1<Shop, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchBottomSheetPresenter$getMerchantDetail$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Shop shop) {
                invoke2(shop);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Shop shop) {
                GlobalSearchBottomSheetContract.View view;
                GlobalSearchBottomSheetContract.View view2;
                MerchantInfoMapper unused;
                Intrinsics.checkNotNullParameter(shop, "");
                view = GlobalSearchBottomSheetPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                view2 = GlobalSearchBottomSheetPresenter.this.BuiltInFictitiousFunctionClassFactory;
                unused = GlobalSearchBottomSheetPresenter.this.getAuthRequestContext;
                String displayName = Calendar.getInstance().getDisplayName(7, 2, Locale.US);
                Intrinsics.checkNotNullExpressionValue(displayName, "");
                view2.getAuthRequestContext(MerchantInfoMapper.MyBillsEntityDataFactory(shop, displayName));
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.contract.globalsearch.GlobalSearchBottomSheetPresenter$getMerchantDetail$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                GlobalSearchBottomSheetContract.View view;
                GlobalSearchBottomSheetContract.View view2;
                Intrinsics.checkNotNullParameter(exc, "");
                view = GlobalSearchBottomSheetPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                DanaLog.BuiltInFictitiousFunctionClassFactory(RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, exc.toString());
                view2 = GlobalSearchBottomSheetPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view2.onError(String.valueOf(exc.getMessage()));
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }
}
