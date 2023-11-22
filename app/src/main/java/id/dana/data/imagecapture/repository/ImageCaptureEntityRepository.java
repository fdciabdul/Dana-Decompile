package id.dana.data.imagecapture.repository;

import id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda10;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityData;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.domain.imagecapture.ImageCaptureRepository;
import id.dana.domain.promotion.Space;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u0006*\u00020\u00100\u0010X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\n\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0014"}, d2 = {"Lid/dana/data/imagecapture/repository/ImageCaptureEntityRepository;", "Lid/dana/domain/imagecapture/ImageCaptureRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "", "p0", "Lio/reactivex/Observable;", "Lid/dana/domain/promotion/Space;", "getCdpImageCapture", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;", "MyBillsEntityDataFactory", "Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;", "PlaceComponentResult", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "getAuthRequestContext", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/content/source/ContentDeliveryEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "Lid/dana/data/content/mapper/SpaceResultMapper;", "Lid/dana/data/content/mapper/SpaceResultMapper;", "p1", "p2", "<init>", "(Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;Lid/dana/data/content/mapper/SpaceResultMapper;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ImageCaptureEntityRepository implements ImageCaptureRepository, HoldLoginV1Repository {
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ContentDeliveryEntityDataFactory PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final SpaceResultMapper MyBillsEntityDataFactory;
    private final HoldLoginV1EntityRepository getAuthRequestContext;

    @Inject
    public ImageCaptureEntityRepository(ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, SpaceResultMapper spaceResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(contentDeliveryEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(spaceResultMapper, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.PlaceComponentResult = contentDeliveryEntityDataFactory;
        this.MyBillsEntityDataFactory = spaceResultMapper;
        this.getAuthRequestContext = holdLoginV1EntityRepository;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<ContentDeliveryEntityData>() { // from class: id.dana.data.imagecapture.repository.ImageCaptureEntityRepository$networkCdpGuideEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ContentDeliveryEntityData invoke() {
                ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory2;
                contentDeliveryEntityDataFactory2 = ImageCaptureEntityRepository.this.PlaceComponentResult;
                return contentDeliveryEntityDataFactory2.createData2("network");
            }
        });
    }

    @Override // id.dana.domain.imagecapture.ImageCaptureRepository
    public final Observable<Space> getCdpImageCapture(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ObservableSource map = ((ContentDeliveryEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).get(p0).map(new CashierEntityRepository$$ExternalSyntheticLambda10(this.MyBillsEntityDataFactory));
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<Space> authenticatedRequest = this.getAuthRequestContext.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }
}
