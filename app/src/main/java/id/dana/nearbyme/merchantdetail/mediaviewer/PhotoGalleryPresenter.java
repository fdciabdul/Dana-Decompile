package id.dana.nearbyme.merchantdetail.mediaviewer;

import id.dana.domain.nearbyme.interactor.GetMerchantImage;
import id.dana.domain.nearbyme.model.MerchantImage;
import id.dana.nearbyme.extension.NearbyExtensionKt;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B!\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\n8\u0017X\u0096\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0012\u0010\u000f\u001a\u00020\u0011X\u0087\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u0012R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0015\u001a\u00020\u0017X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryPresenter;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "Lid/dana/nearbyme/model/ShopModel;", "p0", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/nearbyme/model/ShopModel;)V", "onDestroy", "", "I", "getAuthRequestContext", "()I", "Lid/dana/domain/nearbyme/interactor/GetMerchantImage;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/nearbyme/interactor/GetMerchantImage;", "", "Z", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "PlaceComponentResult", "Ljava/util/List;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MerchantPhotoGalleryModel;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MerchantPhotoGalleryModel;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$View;", "lookAheadTest", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p1", "p2", "<init>", "(Lid/dana/nearbyme/merchantdetail/mediaviewer/MerchantPhotoGalleryModel;Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$View;Lid/dana/domain/nearbyme/interactor/GetMerchantImage;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhotoGalleryPresenter implements PhotoGalleryContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public MerchantPhotoGalleryModel PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetMerchantImage MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final List<MerchantImageModel> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final PhotoGalleryContract.View NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public PhotoGalleryPresenter(MerchantPhotoGalleryModel merchantPhotoGalleryModel, PhotoGalleryContract.View view, GetMerchantImage getMerchantImage) {
        Intrinsics.checkNotNullParameter(merchantPhotoGalleryModel, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getMerchantImage, "");
        this.PlaceComponentResult = merchantPhotoGalleryModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        this.MyBillsEntityDataFactory = getMerchantImage;
        this.BuiltInFictitiousFunctionClassFactory = 1;
        this.getAuthRequestContext = new ArrayList();
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract.Presenter
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final int getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract.Presenter
    public final void MyBillsEntityDataFactory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.MyBillsEntityDataFactory.invoke(new GetMerchantImage.Param(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, 50, true), new Function1<List<? extends MerchantImage>, Unit>() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryPresenter$loadMerchantImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends MerchantImage> list) {
                invoke2((List<MerchantImage>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<MerchantImage> list) {
                List list2;
                PhotoGalleryContract.View view;
                List<MerchantImageModel> list3;
                Intrinsics.checkNotNullParameter(list, "");
                PhotoGalleryPresenter.this.BuiltInFictitiousFunctionClassFactory++;
                PhotoGalleryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                list2 = PhotoGalleryPresenter.this.getAuthRequestContext;
                list2.addAll(NearbyExtensionKt.getAuthRequestContext(list));
                view = PhotoGalleryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                list3 = PhotoGalleryPresenter.this.getAuthRequestContext;
                view.MyBillsEntityDataFactory(list3);
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryPresenter$loadMerchantImage$2
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
                PhotoGalleryContract.View view;
                Intrinsics.checkNotNullParameter(exc, "");
                PhotoGalleryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, exc.getMessage(), exc);
                view = PhotoGalleryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.onError(exc.getMessage());
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final ShopModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.cancelChildren();
        Intrinsics.checkNotNullExpressionValue(p0.NetworkUserEntityData$$ExternalSyntheticLambda4, "");
        if ((!r1.isEmpty()) != false || p0.DatabaseTableConfigUtil()) {
            PhotoGalleryContract.View view = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            List<MerchantImageModel> list = p0.NetworkUserEntityData$$ExternalSyntheticLambda4;
            Intrinsics.checkNotNullExpressionValue(list, "");
            view.BuiltInFictitiousFunctionClassFactory(list, p0);
            return;
        }
        String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda3;
        Intrinsics.checkNotNullExpressionValue(str, "");
        String str2 = p0.BottomSheetCardBindingView$watcherCardNumberView$1;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        MerchantPhotoGalleryModel PlaceComponentResult = MerchantPhotoGalleryModel.PlaceComponentResult(str, str2);
        this.PlaceComponentResult = PlaceComponentResult;
        this.MyBillsEntityDataFactory.invoke(new GetMerchantImage.Param(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, 1, 5, true), new Function1<List<? extends MerchantImage>, Unit>() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryPresenter$loadPreviewImages$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends MerchantImage> list2) {
                invoke2((List<MerchantImage>) list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<MerchantImage> list2) {
                PhotoGalleryContract.View view2;
                Intrinsics.checkNotNullParameter(list2, "");
                view2 = PhotoGalleryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view2.BuiltInFictitiousFunctionClassFactory(NearbyExtensionKt.getAuthRequestContext(list2, 1), p0);
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryPresenter$loadPreviewImages$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                PhotoGalleryContract.View view2;
                Intrinsics.checkNotNullParameter(exc, "");
                view2 = PhotoGalleryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view2.BuiltInFictitiousFunctionClassFactory(CollectionsKt.emptyList(), p0);
            }
        });
    }
}
