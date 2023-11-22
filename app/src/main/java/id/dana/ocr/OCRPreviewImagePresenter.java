package id.dana.ocr;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.otaliastudios.cameraview.PictureResult;
import dagger.internal.Preconditions;
import id.dana.domain.PostExecutionThread;
import id.dana.ocr.OCRPreviewImageContract;
import id.dana.ocr.model.OCRRequestModel;
import id.dana.ocr.preview.BottomSheetPromptView;
import id.dana.utils.ExifHelper;
import id.dana.utils.ImageUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u001d\u0012\u0006\u0010!\u001a\u00020\u0017\u0012\u0006\u0010\"\u001a\u00020\u000f¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\b\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u0004\u0018\u00010\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0012\u0010\u0015\u001a\u00020\u0013X\u0086\"¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0012\u0010\n\u001a\u00020\u0002X\u0086\"¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/ocr/OCRPreviewImagePresenter;", "Lid/dana/ocr/OCRPreviewImageContract$Presenter;", "Lid/dana/ocr/model/OCRRequestModel;", "p0", "", "PlaceComponentResult", "(Lid/dana/ocr/model/OCRRequestModel;)V", "Lcom/otaliastudios/cameraview/PictureResult;", "BuiltInFictitiousFunctionClassFactory", "(Lcom/otaliastudios/cameraview/PictureResult;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "(Ljava/lang/String;)V", "onDestroy", "Lio/reactivex/disposables/CompositeDisposable;", "getAuthRequestContext", "Lio/reactivex/disposables/CompositeDisposable;", "Ljava/lang/String;", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "MyBillsEntityDataFactory", "Lid/dana/ocr/model/OCRRequestModel;", "Lid/dana/domain/PostExecutionThread;", "getErrorConfigVersion", "Lid/dana/domain/PostExecutionThread;", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "J", "Lid/dana/ocr/OCRPreviewImageContract$View;", "moveToNextValue", "Lid/dana/ocr/OCRPreviewImageContract$View;", "lookAheadTest", "p1", "p2", "<init>", "(Lid/dana/ocr/OCRPreviewImageContract$View;Lid/dana/domain/PostExecutionThread;Lio/reactivex/disposables/CompositeDisposable;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class OCRPreviewImagePresenter implements OCRPreviewImageContract.Presenter {
    public static final String MyBillsEntityDataFactory;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Bitmap MyBillsEntityDataFactory;
    public OCRRequestModel KClassImpl$Data$declaredNonStaticMembers$2;
    private long NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;
    private final CompositeDisposable getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final PostExecutionThread PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final OCRPreviewImageContract.View lookAheadTest;

    @Inject
    public OCRPreviewImagePresenter(OCRPreviewImageContract.View view, PostExecutionThread postExecutionThread, CompositeDisposable compositeDisposable) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(compositeDisposable, "");
        this.lookAheadTest = view;
        this.PlaceComponentResult = postExecutionThread;
        this.getAuthRequestContext = compositeDisposable;
    }

    @Override // id.dana.ocr.OCRPreviewImageContract.Presenter
    public final void PlaceComponentResult(OCRRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
    }

    @Override // id.dana.ocr.OCRPreviewImageContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final PictureResult p0) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(p0, "");
        this.lookAheadTest.showProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = System.currentTimeMillis();
        Single PlaceComponentResult = Single.PlaceComponentResult(new Callable() { // from class: id.dana.ocr.OCRPreviewImagePresenter$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return OCRPreviewImagePresenter.KClassImpl$Data$declaredNonStaticMembers$2(PictureResult.this, this);
            }
        });
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
        final Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleSubscribeOn(PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        OCRRequestModel oCRRequestModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (oCRRequestModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            oCRRequestModel = null;
        }
        if (oCRRequestModel.getPlaceComponentResult()) {
            Scheduler MyBillsEntityDataFactory2 = Schedulers.MyBillsEntityDataFactory();
            ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory2, "scheduler is null");
            Single BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleSubscribeOn(BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory2));
            Function function = new Function() { // from class: id.dana.ocr.OCRPreviewImagePresenter$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return OCRPreviewImagePresenter.BuiltInFictitiousFunctionClassFactory(OCRPreviewImagePresenter.this, (Bitmap) obj);
                }
            };
            ObjectHelper.PlaceComponentResult(function, "mapper is null");
            Single BuiltInFictitiousFunctionClassFactory3 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(BuiltInFictitiousFunctionClassFactory2, function));
            Function function2 = new Function() { // from class: id.dana.ocr.OCRPreviewImagePresenter$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return OCRPreviewImagePresenter.BuiltInFictitiousFunctionClassFactory(Single.this, (Unit) obj);
                }
            };
            ObjectHelper.PlaceComponentResult(function2, "mapper is null");
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleFlatMap(BuiltInFictitiousFunctionClassFactory3, function2));
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        }
        Scheduler scheduler = this.PlaceComponentResult.getScheduler();
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        Disposable MyBillsEntityDataFactory3 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(BuiltInFictitiousFunctionClassFactory, scheduler)).MyBillsEntityDataFactory(new Consumer() { // from class: id.dana.ocr.OCRPreviewImagePresenter$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OCRPreviewImagePresenter.MyBillsEntityDataFactory(OCRPreviewImagePresenter.this, (Bitmap) obj);
            }
        }, new Consumer() { // from class: id.dana.ocr.OCRPreviewImagePresenter$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OCRPreviewImagePresenter.KClassImpl$Data$declaredNonStaticMembers$2(OCRPreviewImagePresenter.this, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory3, "");
        Preconditions.getAuthRequestContext(MyBillsEntityDataFactory3);
        Preconditions.getAuthRequestContext(this.getAuthRequestContext);
        this.getAuthRequestContext.getAuthRequestContext(MyBillsEntityDataFactory3);
    }

    @Override // id.dana.ocr.OCRPreviewImageContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (!Intrinsics.areEqual(p0, BottomSheetPromptView.Result.POSITIVE_BUTTON_CLICKED)) {
            if (Intrinsics.areEqual(p0, BottomSheetPromptView.Result.NEGATIVE_BUTTON_CLICKED)) {
                this.lookAheadTest.closePage();
                return;
            }
            return;
        }
        OCRRequestModel oCRRequestModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Unit unit = null;
        Bitmap bitmap = null;
        OCRRequestModel oCRRequestModel2 = null;
        if (oCRRequestModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            oCRRequestModel = null;
        }
        if (!oCRRequestModel.getPlaceComponentResult()) {
            this.lookAheadTest.showProgress();
            OCRPreviewImageContract.View view = this.lookAheadTest;
            Bitmap bitmap2 = this.MyBillsEntityDataFactory;
            if (bitmap2 != null) {
                bitmap = bitmap2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            view.processImageOnForeground(bitmap);
            return;
        }
        String str = this.BuiltInFictitiousFunctionClassFactory;
        if (str != null) {
            OCRPreviewImageContract.View view2 = this.lookAheadTest;
            OCRRequestModel oCRRequestModel3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (oCRRequestModel3 != null) {
                oCRRequestModel2 = oCRRequestModel3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            view2.processImageOnBackground(oCRRequestModel2, str);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.lookAheadTest.onFilePathNull();
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.lookAheadTest.dismissProgress();
        this.getAuthRequestContext.dispose();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = currentTimeMillis - 300;
        }
        String str = MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("Display process delay: ");
        sb.append(currentTimeMillis - this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        DanaLog.MyBillsEntityDataFactory(str, sb.toString());
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        String simpleName = companion.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "");
        MyBillsEntityDataFactory = simpleName;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(OCRPreviewImagePresenter oCRPreviewImagePresenter, Throwable th) {
        Intrinsics.checkNotNullParameter(oCRPreviewImagePresenter, "");
        oCRPreviewImagePresenter.KClassImpl$Data$declaredNonStaticMembers$2();
        oCRPreviewImagePresenter.lookAheadTest.dismissProgress();
        oCRPreviewImagePresenter.lookAheadTest.onError(th.getMessage());
    }

    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(OCRPreviewImagePresenter oCRPreviewImagePresenter, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(oCRPreviewImagePresenter, "");
        Intrinsics.checkNotNullParameter(bitmap, "");
        ImageUtil imageUtil = ImageUtil.PlaceComponentResult;
        String path = oCRPreviewImagePresenter.lookAheadTest.getStorageDir().getPath();
        Intrinsics.checkNotNullExpressionValue(path, "");
        oCRPreviewImagePresenter.BuiltInFictitiousFunctionClassFactory = ImageUtil.PlaceComponentResult(bitmap, path, 0L).getAbsolutePath();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ SingleSource BuiltInFictitiousFunctionClassFactory(Single single, Unit unit) {
        Intrinsics.checkNotNullParameter(single, "");
        Intrinsics.checkNotNullParameter(unit, "");
        return single;
    }

    public static /* synthetic */ Bitmap KClassImpl$Data$declaredNonStaticMembers$2(PictureResult pictureResult, OCRPreviewImagePresenter oCRPreviewImagePresenter) {
        Intrinsics.checkNotNullParameter(pictureResult, "");
        Intrinsics.checkNotNullParameter(oCRPreviewImagePresenter, "");
        byte[] BuiltInFictitiousFunctionClassFactory = pictureResult.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        BitmapFactory.Options options = new BitmapFactory.Options();
        byte[] BuiltInFictitiousFunctionClassFactory2 = pictureResult.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        int i = pictureResult.getAuthRequestContext;
        String str = MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("original orientation ");
        sb.append(i);
        DanaLog.MyBillsEntityDataFactory(str, sb.toString());
        Integer valueOf = Integer.valueOf(ExifHelper.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2));
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        int intValue = valueOf != null ? valueOf.intValue() : i;
        if (i == 0 || 180 == i) {
            intValue = 90;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("expected orientation ");
        sb2.append(intValue);
        DanaLog.MyBillsEntityDataFactory(str, sb2.toString());
        return ImageUtil.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, options, intValue);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(OCRPreviewImagePresenter oCRPreviewImagePresenter, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(oCRPreviewImagePresenter, "");
        Intrinsics.checkNotNullExpressionValue(bitmap, "");
        Intrinsics.checkNotNullParameter(bitmap, "");
        oCRPreviewImagePresenter.MyBillsEntityDataFactory = bitmap;
        oCRPreviewImagePresenter.lookAheadTest.onSuccessConvertImage(bitmap);
        oCRPreviewImagePresenter.KClassImpl$Data$declaredNonStaticMembers$2();
        oCRPreviewImagePresenter.lookAheadTest.dismissProgress();
    }
}
