package id.dana.ocr;

import Catalano.Imaging.FastBitmap;
import android.graphics.Bitmap;
import dagger.internal.Preconditions;
import id.dana.appcontainer.plugin.ocrreceipt.usecase.GetOcrSnapLimit;
import id.dana.danah5.ocrreceipt.usecase.GetOcrPreprocessingConfig;
import id.dana.danah5.ocrreceipt.usecase.model.OcrImagePreprocessingConfigModel;
import id.dana.domain.DefaultObserver;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.ocr.interactor.GetOcrFromReceipt;
import id.dana.domain.ocr.model.ReceiptInfoModel;
import id.dana.extension.view.FastBitmapExtKt;
import id.dana.ocr.PreprocessingAndOcrContract;
import id.dana.ocr.model.OCRRequestModel;
import id.dana.ocr.model.OCRResultModel;
import id.dana.utils.BitmapUtil;
import id.dana.utils.ImageUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleDoOnError;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u00010B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020'\u0012\u0006\u0010\f\u001a\u00020!\u0012\u0006\u0010*\u001a\u00020\u0015\u0012\u0006\u0010+\u001a\u00020\u0018\u0012\u0006\u0010,\u001a\u00020\u001c\u0012\u0006\u0010-\u001a\u00020\u001a¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0005\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0007\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ'\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\b\u0012\u0004\u0012\u00020\u000b0\u00102\u0006\u0010\u0003\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0012J/\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010*\b\u0012\u0004\u0012\u00020\u00130\u00102\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u0014\u0010\u000f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u001e\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\"\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010%\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lid/dana/ocr/PreprocessingAndOcrPresenter;", "Lid/dana/ocr/PreprocessingAndOcrContract$Presenter;", "Lid/dana/ocr/model/OCRRequestModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/ocr/model/OCRRequestModel;)V", "MyBillsEntityDataFactory", "()V", "onDestroy", "", "Landroid/graphics/Bitmap;", "p1", "(Ljava/lang/String;Landroid/graphics/Bitmap;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthRequestContext", "Lio/reactivex/Single;", "Lid/dana/domain/ocr/model/ReceiptInfoModel;", "(Lio/reactivex/Single;Ljava/lang/String;)Lio/reactivex/Single;", "Lid/dana/ocr/model/OCRResultModel;", "(Lio/reactivex/Single;Ljava/lang/String;Landroid/graphics/Bitmap;)Lio/reactivex/Single;", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/ocr/interactor/GetOcrFromReceipt;", "Lid/dana/domain/ocr/interactor/GetOcrFromReceipt;", "Lid/dana/danah5/ocrreceipt/usecase/GetOcrPreprocessingConfig;", "Lid/dana/danah5/ocrreceipt/usecase/GetOcrPreprocessingConfig;", "Lid/dana/appcontainer/plugin/ocrreceipt/usecase/GetOcrSnapLimit;", "Lid/dana/appcontainer/plugin/ocrreceipt/usecase/GetOcrSnapLimit;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/ocr/model/OCRRequestModel;", "PlaceComponentResult", "Lid/dana/domain/PostExecutionThread;", "getErrorConfigVersion", "Lid/dana/domain/PostExecutionThread;", "", "lookAheadTest", "J", "Lid/dana/ocr/PreprocessingAndOcrContract$View;", "scheduleImpl", "Lid/dana/ocr/PreprocessingAndOcrContract$View;", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/ocr/PreprocessingAndOcrContract$View;Lid/dana/domain/PostExecutionThread;Lio/reactivex/disposables/CompositeDisposable;Lid/dana/domain/ocr/interactor/GetOcrFromReceipt;Lid/dana/appcontainer/plugin/ocrreceipt/usecase/GetOcrSnapLimit;Lid/dana/danah5/ocrreceipt/usecase/GetOcrPreprocessingConfig;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class PreprocessingAndOcrPresenter implements PreprocessingAndOcrContract.Presenter {
    private static final String PlaceComponentResult;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetOcrFromReceipt MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final CompositeDisposable BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetOcrSnapLimit getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private OCRRequestModel PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetOcrPreprocessingConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final PostExecutionThread NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private long getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final PreprocessingAndOcrContract.View lookAheadTest;

    @Inject
    public PreprocessingAndOcrPresenter(PreprocessingAndOcrContract.View view, PostExecutionThread postExecutionThread, CompositeDisposable compositeDisposable, GetOcrFromReceipt getOcrFromReceipt, GetOcrSnapLimit getOcrSnapLimit, GetOcrPreprocessingConfig getOcrPreprocessingConfig) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(compositeDisposable, "");
        Intrinsics.checkNotNullParameter(getOcrFromReceipt, "");
        Intrinsics.checkNotNullParameter(getOcrSnapLimit, "");
        Intrinsics.checkNotNullParameter(getOcrPreprocessingConfig, "");
        this.lookAheadTest = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = postExecutionThread;
        this.BuiltInFictitiousFunctionClassFactory = compositeDisposable;
        this.MyBillsEntityDataFactory = getOcrFromReceipt;
        this.getAuthRequestContext = getOcrSnapLimit;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getOcrPreprocessingConfig;
    }

    @Override // id.dana.ocr.PreprocessingAndOcrContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(OCRRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult = p0;
    }

    @Override // id.dana.ocr.PreprocessingAndOcrContract.Presenter
    public final void MyBillsEntityDataFactory(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Single PlaceComponentResult2 = Single.PlaceComponentResult(new Callable() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda19
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreprocessingAndOcrPresenter.MyBillsEntityDataFactory(p1);
            }
        });
        Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleSubscribeOn(PlaceComponentResult2, MyBillsEntityDataFactory));
        Scheduler scheduler = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getScheduler();
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        Disposable MyBillsEntityDataFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(BuiltInFictitiousFunctionClassFactory, scheduler)).MyBillsEntityDataFactory(new Consumer() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PreprocessingAndOcrPresenter.KClassImpl$Data$declaredNonStaticMembers$2(PreprocessingAndOcrPresenter.this, p0, (Bitmap) obj);
            }
        }, new Consumer() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Throwable th = (Throwable) obj;
                PreprocessingAndOcrPresenter.MyBillsEntityDataFactory(PreprocessingAndOcrPresenter.this, p0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        Preconditions.getAuthRequestContext(MyBillsEntityDataFactory2);
        Preconditions.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(MyBillsEntityDataFactory2);
    }

    @Override // id.dana.ocr.PreprocessingAndOcrContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final Bitmap p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getErrorConfigVersion = System.currentTimeMillis();
        Single<Bitmap> MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda6
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                PreprocessingAndOcrPresenter.KClassImpl$Data$declaredNonStaticMembers$2(PreprocessingAndOcrPresenter.this, p0, p1, singleEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        Single<ReceiptInfoModel> authRequestContext = getAuthRequestContext(MyBillsEntityDataFactory, p0);
        Function function = new Function() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreprocessingAndOcrPresenter.PlaceComponentResult(PreprocessingAndOcrPresenter.this, (ReceiptInfoModel) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        Single<OCRResultModel> BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(authRequestContext, function));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        Single<OCRResultModel> authRequestContext2 = getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, p0, p1);
        Scheduler scheduler = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getScheduler();
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        Disposable MyBillsEntityDataFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(authRequestContext2, scheduler)).MyBillsEntityDataFactory(new Consumer() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PreprocessingAndOcrPresenter.BuiltInFictitiousFunctionClassFactory(PreprocessingAndOcrPresenter.this, p0, (OCRResultModel) obj);
            }
        }, new Consumer() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PreprocessingAndOcrPresenter.PlaceComponentResult(PreprocessingAndOcrPresenter.this, p0, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        Preconditions.getAuthRequestContext(MyBillsEntityDataFactory2);
        Preconditions.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(MyBillsEntityDataFactory2);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.lookAheadTest.dismissProgress();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }

    private final Single<ReceiptInfoModel> getAuthRequestContext(Single<Bitmap> single, final String str) {
        Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(single, PlaceComponentResult2));
        Function function = new Function() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreprocessingAndOcrPresenter.PlaceComponentResult(PreprocessingAndOcrPresenter.this, str, (Bitmap) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        Single BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(BuiltInFictitiousFunctionClassFactory, function));
        Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory3 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(BuiltInFictitiousFunctionClassFactory2, MyBillsEntityDataFactory));
        Function function2 = new Function() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreprocessingAndOcrPresenter.MyBillsEntityDataFactory(PreprocessingAndOcrPresenter.this, (Bitmap) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(function2, "mapper is null");
        Single BuiltInFictitiousFunctionClassFactory4 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleFlatMap(BuiltInFictitiousFunctionClassFactory3, function2));
        Consumer consumer = new Consumer() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Throwable th = (Throwable) obj;
                PreprocessingAndOcrPresenter.getAuthRequestContext(PreprocessingAndOcrPresenter.this, str);
            }
        };
        ObjectHelper.PlaceComponentResult(consumer, "onError is null");
        Single<ReceiptInfoModel> BuiltInFictitiousFunctionClassFactory5 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleDoOnError(BuiltInFictitiousFunctionClassFactory4, consumer));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory5, "");
        return BuiltInFictitiousFunctionClassFactory5;
    }

    private final Single<OCRResultModel> getAuthRequestContext(Single<OCRResultModel> single, final String str, final Bitmap bitmap) {
        Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(single, PlaceComponentResult2));
        Function function = new Function() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreprocessingAndOcrPresenter.MyBillsEntityDataFactory(PreprocessingAndOcrPresenter.this, str, (OCRResultModel) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        Single BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(BuiltInFictitiousFunctionClassFactory, function));
        Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory3 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(BuiltInFictitiousFunctionClassFactory2, MyBillsEntityDataFactory));
        Function function2 = new Function() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PreprocessingAndOcrPresenter.KClassImpl$Data$declaredNonStaticMembers$2(PreprocessingAndOcrPresenter.this, bitmap, (OCRResultModel) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(function2, "mapper is null");
        Single<OCRResultModel> BuiltInFictitiousFunctionClassFactory4 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(BuiltInFictitiousFunctionClassFactory3, function2));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory4, "");
        return BuiltInFictitiousFunctionClassFactory4;
    }

    private final void getAuthRequestContext(String p0, String p1) {
        MyBillsEntityDataFactory();
        this.lookAheadTest.dismissProgress();
        PreprocessingAndOcrContract.View view = this.lookAheadTest;
        OCRRequestModel oCRRequestModel = this.PlaceComponentResult;
        if (oCRRequestModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            oCRRequestModel = null;
        }
        view.BuiltInFictitiousFunctionClassFactory(p0, oCRRequestModel, new OCRResultModel.Builder(p1).getAuthRequestContext());
    }

    private final void MyBillsEntityDataFactory() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.getErrorConfigVersion == 0) {
            this.getErrorConfigVersion = currentTimeMillis - 300;
        }
        String str = PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append("Ocr until write to file process delay: ");
        sb.append(currentTimeMillis - this.getErrorConfigVersion);
        DanaLog.MyBillsEntityDataFactory(str, sb.toString());
    }

    static {
        Intrinsics.checkNotNullExpressionValue("PreprocessingAndOcrPresenter", "");
        PlaceComponentResult = "PreprocessingAndOcrPresenter";
    }

    public static /* synthetic */ OCRResultModel PlaceComponentResult(PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, ReceiptInfoModel receiptInfoModel) {
        OCRResultModel.Builder builder;
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(receiptInfoModel, "");
        if (receiptInfoModel.getIsFulFilled()) {
            builder = new OCRResultModel.Builder();
        } else {
            builder = new OCRResultModel.Builder("004");
        }
        return builder.getAuthRequestContext();
    }

    public static /* synthetic */ FastBitmap KClassImpl$Data$declaredNonStaticMembers$2(FastBitmap fastBitmap) {
        Intrinsics.checkNotNullParameter(fastBitmap, "");
        return FastBitmapExtKt.KClassImpl$Data$declaredNonStaticMembers$2(fastBitmap);
    }

    public static /* synthetic */ void PlaceComponentResult(PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append("Error occur ");
        sb.append(th.getMessage());
        DanaLog.BuiltInFictitiousFunctionClassFactory(str2, sb.toString());
        preprocessingAndOcrPresenter.getAuthRequestContext(str, "001");
    }

    public static /* synthetic */ FastBitmap MyBillsEntityDataFactory(FastBitmap fastBitmap) {
        Intrinsics.checkNotNullParameter(fastBitmap, "");
        return FastBitmapExtKt.getAuthRequestContext(fastBitmap);
    }

    public static /* synthetic */ FastBitmap BuiltInFictitiousFunctionClassFactory(PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(bitmap, "");
        return new FastBitmap(bitmap.copy(bitmap.getConfig(), true));
    }

    public static /* synthetic */ OCRResultModel MyBillsEntityDataFactory(PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, String str, OCRResultModel oCRResultModel) {
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(oCRResultModel, "");
        preprocessingAndOcrPresenter.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(str);
        return oCRResultModel;
    }

    public static /* synthetic */ SingleSource MyBillsEntityDataFactory(final PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, final Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(bitmap, "");
        Single MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda18
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                PreprocessingAndOcrPresenter.getAuthRequestContext(PreprocessingAndOcrPresenter.this, bitmap, singleEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public static /* synthetic */ FastBitmap PlaceComponentResult(FastBitmap fastBitmap) {
        Intrinsics.checkNotNullParameter(fastBitmap, "");
        return FastBitmapExtKt.MyBillsEntityDataFactory(fastBitmap);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, final String str, final Bitmap bitmap, final SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bitmap, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        try {
            Single<OcrImagePreprocessingConfigModel> invoke = preprocessingAndOcrPresenter.KClassImpl$Data$declaredNonStaticMembers$2.invoke();
            Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
            ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
            RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleSubscribeOn(invoke, MyBillsEntityDataFactory)).MyBillsEntityDataFactory(new Consumer() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PreprocessingAndOcrPresenter.getAuthRequestContext(SingleEmitter.this, preprocessingAndOcrPresenter, str, bitmap, (OcrImagePreprocessingConfigModel) obj);
                }
            }, Functions.DatabaseTableConfigUtil);
        } catch (Exception e) {
            singleEmitter.onError(e);
        }
    }

    public static /* synthetic */ void getAuthRequestContext(PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, Bitmap bitmap, final SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(bitmap, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        GetOcrFromReceipt getOcrFromReceipt = preprocessingAndOcrPresenter.MyBillsEntityDataFactory;
        DefaultObserver<ReceiptInfoModel> defaultObserver = new DefaultObserver<ReceiptInfoModel>() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$executeOcr$1$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ReceiptInfoModel receiptInfoModel = (ReceiptInfoModel) obj;
                Intrinsics.checkNotNullParameter(receiptInfoModel, "");
                singleEmitter.onSuccess(receiptInfoModel);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                singleEmitter.onError(p0);
            }
        };
        OCRRequestModel oCRRequestModel = preprocessingAndOcrPresenter.PlaceComponentResult;
        OCRRequestModel oCRRequestModel2 = null;
        if (oCRRequestModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            oCRRequestModel = null;
        }
        String str = oCRRequestModel.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str != null) {
            OCRRequestModel oCRRequestModel3 = preprocessingAndOcrPresenter.PlaceComponentResult;
            if (oCRRequestModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                oCRRequestModel2 = oCRRequestModel3;
            }
            getOcrFromReceipt.execute(defaultObserver, new GetOcrFromReceipt.Params(str, oCRRequestModel2.MyBillsEntityDataFactory, bitmap));
        }
    }

    public static /* synthetic */ void getAuthRequestContext(PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, String str) {
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        preprocessingAndOcrPresenter.getAuthRequestContext(str, "006");
    }

    public static /* synthetic */ Bitmap MyBillsEntityDataFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return BitmapUtil.BuiltInFictitiousFunctionClassFactory(str);
    }

    public static /* synthetic */ OCRResultModel KClassImpl$Data$declaredNonStaticMembers$2(PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, Bitmap bitmap, OCRResultModel oCRResultModel) {
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(bitmap, "");
        Intrinsics.checkNotNullParameter(oCRResultModel, "");
        ImageUtil imageUtil = ImageUtil.PlaceComponentResult;
        String path = preprocessingAndOcrPresenter.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2().getPath();
        Intrinsics.checkNotNullExpressionValue(path, "");
        Long r_ = preprocessingAndOcrPresenter.getAuthRequestContext.getAuthRequestContext.getSnapSizeLimit().r_();
        Intrinsics.checkNotNullExpressionValue(r_, "");
        String absolutePath = ImageUtil.PlaceComponentResult(bitmap, path, r_.longValue()).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "");
        Intrinsics.checkNotNullParameter(absolutePath, "");
        return new OCRResultModel(oCRResultModel.getLookAheadTest(), oCRResultModel.getAuthRequestContext, oCRResultModel.PlaceComponentResult, oCRResultModel.BuiltInFictitiousFunctionClassFactory, oCRResultModel.NetworkUserEntityData$$ExternalSyntheticLambda0, oCRResultModel.MyBillsEntityDataFactory, oCRResultModel.getErrorConfigVersion, absolutePath);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, String str, OCRResultModel oCRResultModel) {
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        Unit unit = null;
        OCRRequestModel oCRRequestModel = null;
        if (oCRResultModel != null) {
            preprocessingAndOcrPresenter.MyBillsEntityDataFactory();
            preprocessingAndOcrPresenter.lookAheadTest.dismissProgress();
            PreprocessingAndOcrContract.View view = preprocessingAndOcrPresenter.lookAheadTest;
            OCRRequestModel oCRRequestModel2 = preprocessingAndOcrPresenter.PlaceComponentResult;
            if (oCRRequestModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                oCRRequestModel = oCRRequestModel2;
            }
            view.BuiltInFictitiousFunctionClassFactory(str, oCRRequestModel, oCRResultModel);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            preprocessingAndOcrPresenter.getAuthRequestContext(str, "001");
        }
    }

    public static /* synthetic */ void getAuthRequestContext(SingleEmitter singleEmitter, final PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, final String str, final Bitmap bitmap, OcrImagePreprocessingConfigModel ocrImagePreprocessingConfigModel) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        Scheduler KClassImpl$Data$declaredNonStaticMembers$22;
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bitmap, "");
        if (ocrImagePreprocessingConfigModel.getEnable()) {
            long timeout = ocrImagePreprocessingConfigModel.getTimeout();
            Single PlaceComponentResult2 = Single.PlaceComponentResult(new Callable() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return PreprocessingAndOcrPresenter.BuiltInFictitiousFunctionClassFactory(PreprocessingAndOcrPresenter.this, str, bitmap);
                }
            });
            Scheduler PlaceComponentResult3 = AndroidSchedulers.PlaceComponentResult();
            ObjectHelper.PlaceComponentResult(PlaceComponentResult3, "scheduler is null");
            Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleSubscribeOn(PlaceComponentResult2, PlaceComponentResult3));
            KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
            ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
            Single BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2));
            Function function = new Function() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda11
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PreprocessingAndOcrPresenter.BuiltInFictitiousFunctionClassFactory(PreprocessingAndOcrPresenter.this, (Bitmap) obj);
                }
            };
            ObjectHelper.PlaceComponentResult(function, "mapper is null");
            Single BuiltInFictitiousFunctionClassFactory3 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(BuiltInFictitiousFunctionClassFactory2, function));
            Function function2 = new Function() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda13
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PreprocessingAndOcrPresenter.KClassImpl$Data$declaredNonStaticMembers$2((FastBitmap) obj);
                }
            };
            ObjectHelper.PlaceComponentResult(function2, "mapper is null");
            Single BuiltInFictitiousFunctionClassFactory4 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(BuiltInFictitiousFunctionClassFactory3, function2));
            Function function3 = new Function() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda14
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PreprocessingAndOcrPresenter.PlaceComponentResult((FastBitmap) obj);
                }
            };
            ObjectHelper.PlaceComponentResult(function3, "mapper is null");
            Single BuiltInFictitiousFunctionClassFactory5 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(BuiltInFictitiousFunctionClassFactory4, function3));
            Function function4 = new Function() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda15
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PreprocessingAndOcrPresenter.MyBillsEntityDataFactory((FastBitmap) obj);
                }
            };
            ObjectHelper.PlaceComponentResult(function4, "mapper is null");
            Single BuiltInFictitiousFunctionClassFactory6 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(BuiltInFictitiousFunctionClassFactory5, function4));
            Function function5 = new Function() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda16
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PreprocessingAndOcrPresenter.BuiltInFictitiousFunctionClassFactory((FastBitmap) obj);
                }
            };
            ObjectHelper.PlaceComponentResult(function5, "mapper is null");
            Single BuiltInFictitiousFunctionClassFactory7 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(BuiltInFictitiousFunctionClassFactory6, function5));
            Function function6 = new Function() { // from class: id.dana.ocr.PreprocessingAndOcrPresenter$$ExternalSyntheticLambda17
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PreprocessingAndOcrPresenter.getAuthRequestContext((FastBitmap) obj);
                }
            };
            ObjectHelper.PlaceComponentResult(function6, "mapper is null");
            Single BuiltInFictitiousFunctionClassFactory8 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(BuiltInFictitiousFunctionClassFactory7, function6));
            TimeUnit timeUnit = TimeUnit.SECONDS;
            KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
            ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
            ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22, "scheduler is null");
            Single BuiltInFictitiousFunctionClassFactory9 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleTimeout(BuiltInFictitiousFunctionClassFactory8, timeout, timeUnit, KClassImpl$Data$declaredNonStaticMembers$22));
            ObjectHelper.PlaceComponentResult(bitmap, "value is null");
            Single BuiltInFictitiousFunctionClassFactory10 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleOnErrorReturn(BuiltInFictitiousFunctionClassFactory9, null, bitmap));
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory10, "");
            singleEmitter.onSuccess(BuiltInFictitiousFunctionClassFactory10.r_());
            return;
        }
        singleEmitter.onSuccess(bitmap);
    }

    public static /* synthetic */ FastBitmap BuiltInFictitiousFunctionClassFactory(FastBitmap fastBitmap) {
        Intrinsics.checkNotNullParameter(fastBitmap, "");
        return FastBitmapExtKt.PlaceComponentResult(fastBitmap);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, String str) {
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        preprocessingAndOcrPresenter.getAuthRequestContext(str, "013");
    }

    public static /* synthetic */ Bitmap BuiltInFictitiousFunctionClassFactory(PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, String str, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bitmap, "");
        preprocessingAndOcrPresenter.lookAheadTest.MyBillsEntityDataFactory(str);
        return bitmap;
    }

    public static /* synthetic */ Bitmap getAuthRequestContext(FastBitmap fastBitmap) {
        Intrinsics.checkNotNullParameter(fastBitmap, "");
        return fastBitmap.BuiltInFictitiousFunctionClassFactory();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, String str, Bitmap bitmap) {
        Unit unit;
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (bitmap != null) {
            preprocessingAndOcrPresenter.KClassImpl$Data$declaredNonStaticMembers$2(str, bitmap);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            preprocessingAndOcrPresenter.getAuthRequestContext(str, "013");
        }
    }

    public static /* synthetic */ Bitmap PlaceComponentResult(PreprocessingAndOcrPresenter preprocessingAndOcrPresenter, String str, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(preprocessingAndOcrPresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bitmap, "");
        preprocessingAndOcrPresenter.lookAheadTest.getAuthRequestContext(str);
        return bitmap;
    }
}
