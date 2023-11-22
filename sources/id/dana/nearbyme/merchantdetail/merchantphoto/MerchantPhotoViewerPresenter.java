package id.dana.nearbyme.merchantdetail.merchantphoto;

import id.dana.domain.nearbyme.interactor.GetMerchantImage;
import id.dana.domain.nearbyme.model.MerchantImage;
import id.dana.nearbyme.extension.NearbyExtensionKt;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerModel;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0014\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020#¢\u0006\u0004\b(\u0010)JY\u0010\r\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u001f\u0010\t\u001a\u001b\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b0\u00052\u001f\u0010\f\u001a\u001b\u0012\u0011\u0012\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJJ\u0010\u000f\u001a\u00020\b2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00052\u001f\u0010\t\u001a\u001b\u0012\u0011\u0012\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\b2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00052\u001f\u0010\t\u001a\u001b\u0012\u0011\u0012\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016¢\u0006\u0004\b\r\u0010\u0010JJ\u0010\u0011\u001a\u00020\b2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00052\u001f\u0010\t\u001a\u001b\u0012\u0011\u0012\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\r\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u000f\u001a\u00020\u00178\u0017@\u0017X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u000f\u0010\u001bR\"\u0010\u0015\u001a\u00020\u00178\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u0015\u0010\u001a\"\u0004\b\u0015\u0010\u001bR\"\u0010\u0019\u001a\u00020\u001d8\u0017@\u0017X\u0097.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\u0011\u0010\u001f\"\u0004\b\r\u0010 R\u0012\u0010\u0011\u001a\u00020!X\u0087\u0002¢\u0006\u0006\n\u0004\b\r\u0010\"R\u0012\u0010\u001c\u001a\u00020!X\u0087\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\"R \u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020#8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\r\u0010&"}, d2 = {"Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoViewerPresenter;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$Presenter;", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "", "p0", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "", "p1", "Ljava/lang/Exception;", "Lkotlin/Exception;", "p2", "MyBillsEntityDataFactory", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getAuthRequestContext", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "BuiltInFictitiousFunctionClassFactory", "onDestroy", "()V", "Lid/dana/domain/nearbyme/interactor/GetMerchantImage;", "PlaceComponentResult", "Lid/dana/domain/nearbyme/interactor/GetMerchantImage;", "", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "(Z)V", "getErrorConfigVersion", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerModel;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerModel;", "()Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerModel;", "(Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerModel;)V", "", "Ljava/lang/String;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$View;", "scheduleImpl", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$View;", "()Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$View;", "lookAheadTest", "<init>", "(Lid/dana/domain/nearbyme/interactor/GetMerchantImage;Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantPhotoViewerPresenter implements MediaViewerContract.Presenter<MerchantImageModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean getAuthRequestContext;
    public MediaViewerModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetMerchantImage MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final MediaViewerContract.View<MerchantImageModel> lookAheadTest;

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.Presenter
    public final /* synthetic */ void MyBillsEntityDataFactory(Exception exc) {
        MediaViewerContract.Presenter.CC.BuiltInFictitiousFunctionClassFactory(exc);
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.Presenter
    public final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        MediaViewerContract.Presenter.CC.MyBillsEntityDataFactory(this);
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.Presenter
    public final /* synthetic */ void getAuthRequestContext() {
        MediaViewerContract.Presenter.CC.BuiltInFictitiousFunctionClassFactory(this);
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.Presenter
    public final /* synthetic */ void scheduleImpl() {
        MediaViewerContract.Presenter.CC.PlaceComponentResult(this);
    }

    @Inject
    public MerchantPhotoViewerPresenter(GetMerchantImage getMerchantImage, MediaViewerContract.View<MerchantImageModel> view) {
        Intrinsics.checkNotNullParameter(getMerchantImage, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = getMerchantImage;
        this.lookAheadTest = view;
        this.BuiltInFictitiousFunctionClassFactory = "";
        this.getErrorConfigVersion = "";
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.Presenter
    @JvmName(name = "MyBillsEntityDataFactory")
    public final MediaViewerContract.View<MerchantImageModel> MyBillsEntityDataFactory() {
        return this.lookAheadTest;
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.Presenter
    @JvmName(name = "PlaceComponentResult")
    public final void PlaceComponentResult(boolean z) {
        this.PlaceComponentResult = z;
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.Presenter
    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.Presenter
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.Presenter
    @JvmName(name = "getAuthRequestContext")
    public final void getAuthRequestContext(boolean z) {
        this.getAuthRequestContext = z;
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.Presenter
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final MediaViewerModel BuiltInFictitiousFunctionClassFactory() {
        MediaViewerModel mediaViewerModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (mediaViewerModel != null) {
            return mediaViewerModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.Presenter
    @JvmName(name = "MyBillsEntityDataFactory")
    public final void MyBillsEntityDataFactory(MediaViewerModel mediaViewerModel) {
        Intrinsics.checkNotNullParameter(mediaViewerModel, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = mediaViewerModel;
    }

    private final void MyBillsEntityDataFactory(int p0, final Function1<? super List<MerchantImageModel>, Unit> p1, final Function1<? super Exception, Unit> p2) {
        GetMerchantImage getMerchantImage = this.MyBillsEntityDataFactory;
        String str = this.BuiltInFictitiousFunctionClassFactory;
        String str2 = this.getErrorConfigVersion;
        MediaViewerModel mediaViewerModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (mediaViewerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            mediaViewerModel = null;
        }
        getMerchantImage.invoke(new GetMerchantImage.Param(str, str2, p0, mediaViewerModel.MyBillsEntityDataFactory, false, 16, null), new Function1<List<? extends MerchantImage>, Unit>() { // from class: id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerPresenter$getMerchantImages$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                List<MerchantImageModel> authRequestContext;
                Intrinsics.checkNotNullParameter(list, "");
                Function1<List<MerchantImageModel>, Unit> function1 = p1;
                authRequestContext = NearbyExtensionKt.getAuthRequestContext(list, 0);
                function1.invoke(authRequestContext);
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerPresenter$getMerchantImages$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, exc.getMessage(), exc);
                p2.invoke(exc);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.Presenter
    public final void getAuthRequestContext(Function1<? super List<? extends MerchantImageModel>, Unit> p0, Function1<? super Exception, Unit> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        MediaViewerModel mediaViewerModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (mediaViewerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            mediaViewerModel = null;
        }
        p0.invoke(mediaViewerModel.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.Presenter
    public final void MyBillsEntityDataFactory(Function1<? super List<? extends MerchantImageModel>, Unit> p0, Function1<? super Exception, Unit> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        MediaViewerModel mediaViewerModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        MediaViewerModel mediaViewerModel2 = null;
        if (mediaViewerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            mediaViewerModel = null;
        }
        if (mediaViewerModel.getPlaceComponentResult()) {
            MediaViewerModel mediaViewerModel3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (mediaViewerModel3 != null) {
                mediaViewerModel2 = mediaViewerModel3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            MyBillsEntityDataFactory(mediaViewerModel2.getAuthRequestContext, p0, p1);
        }
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(Function1<? super List<? extends MerchantImageModel>, Unit> p0, Function1<? super Exception, Unit> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        MediaViewerModel mediaViewerModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        MediaViewerModel mediaViewerModel2 = null;
        if (mediaViewerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            mediaViewerModel = null;
        }
        if (mediaViewerModel.getPlaceComponentResult()) {
            MediaViewerModel mediaViewerModel3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (mediaViewerModel3 != null) {
                mediaViewerModel2 = mediaViewerModel3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            MyBillsEntityDataFactory(mediaViewerModel2.moveToNextValue, p0, p1);
        }
    }
}
