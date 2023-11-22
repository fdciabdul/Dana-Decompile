package id.dana.nearbyme.merchantdetail.mediaviewer;

import android.os.Parcelable;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.griver.api.h5.appinfo.GriverH5AppInfo;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.huawei.hms.push.e;
import id.dana.base.AbstractContractKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MediaViewerContract {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\t\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$View;", "", "T", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)V", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View<T> extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(List<? extends T> p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(List<? extends T> p0);
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016JI\u0010\u0015\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0004\u0012\u00020\u00160\u00182%\u0010\u001a\u001a!\u0012\u0017\u0012\u00150\u001bj\u0002`\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00160\u0018H&J\b\u0010 \u001a\u00020\u0016H\u0016JI\u0010 \u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0004\u0012\u00020\u00160\u00182%\u0010\u001a\u001a!\u0012\u0017\u0012\u00150\u001bj\u0002`\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00160\u0018H&J\b\u0010!\u001a\u00020\u0016H\u0016JI\u0010!\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0004\u0012\u00020\u00160\u00182%\u0010\u001a\u001a!\u0012\u0017\u0012\u00150\u001bj\u0002`\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00160\u0018H&J\u0014\u0010\"\u001a\u00020\u00162\n\u0010#\u001a\u00060\u001bj\u0002`\u001cH\u0016R\u0018\u0010\u0004\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u0018\u0010\u000b\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006$À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$Presenter;", "T", "Landroid/os/Parcelable;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "isLoadingNext", "", "()Z", "setLoadingNext", "(Z)V", "isLoadingPrevious", "setLoadingPrevious", "mediaViewerModel", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerModel;", "getMediaViewerModel", "()Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerModel;", "setMediaViewerModel", "(Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerModel;)V", "view", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$View;", "getView", "()Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$View;", "loadInitial", "", "onSuccess", "Lkotlin/Function1;", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", e.PlaceComponentResult, "loadNext", GriverH5AppInfo.UpdatePolicy.LOAD_PREVIOUS, "logError", "it", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter<T extends Parcelable> extends AbstractContractKt.AbstractPresenter {
        MediaViewerModel BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(Function1<? super List<? extends T>, Unit> function1, Function1<? super Exception, Unit> function12);

        boolean KClassImpl$Data$declaredNonStaticMembers$2();

        View<T> MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(MediaViewerModel mediaViewerModel);

        void MyBillsEntityDataFactory(Exception exc);

        void MyBillsEntityDataFactory(Function1<? super List<? extends T>, Unit> function1, Function1<? super Exception, Unit> function12);

        void NetworkUserEntityData$$ExternalSyntheticLambda0();

        void PlaceComponentResult(boolean z);

        boolean PlaceComponentResult();

        void getAuthRequestContext();

        void getAuthRequestContext(Function1<? super List<? extends T>, Unit> function1, Function1<? super Exception, Unit> function12);

        void getAuthRequestContext(boolean z);

        void scheduleImpl();

        @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
        /* renamed from: id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC<T extends Parcelable> {
            public static void BuiltInFictitiousFunctionClassFactory(final Presenter presenter) {
                presenter.getAuthRequestContext(new Function1<List<? extends T>, Unit>() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract$Presenter$loadInitial$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke((List) ((List) obj));
                        return Unit.INSTANCE;
                    }

                    public final void invoke(List<? extends T> list) {
                        Intrinsics.checkNotNullParameter(list, "");
                        presenter.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(list);
                    }
                }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract$Presenter$loadInitial$2
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
                        Intrinsics.checkNotNullParameter(exc, "");
                        presenter.MyBillsEntityDataFactory(exc);
                    }
                });
            }

            public static void PlaceComponentResult(final Presenter presenter) {
                if (presenter.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    return;
                }
                presenter.getAuthRequestContext(true);
                presenter.MyBillsEntityDataFactory(new Function1<List<? extends T>, Unit>() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract$Presenter$loadNext$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke((List) ((List) obj));
                        return Unit.INSTANCE;
                    }

                    public final void invoke(List<? extends T> list) {
                        Intrinsics.checkNotNullParameter(list, "");
                        presenter.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext++;
                        presenter.getAuthRequestContext(false);
                        presenter.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(list);
                    }
                }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract$Presenter$loadNext$2
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
                        Intrinsics.checkNotNullParameter(exc, "");
                        presenter.MyBillsEntityDataFactory(exc);
                    }
                });
            }

            public static void MyBillsEntityDataFactory(final Presenter presenter) {
                if (presenter.BuiltInFictitiousFunctionClassFactory().moveToNextValue <= 0 || presenter.PlaceComponentResult()) {
                    return;
                }
                presenter.PlaceComponentResult(true);
                presenter.BuiltInFictitiousFunctionClassFactory(new Function1<List<? extends T>, Unit>() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract$Presenter$loadPrevious$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke((List) ((List) obj));
                        return Unit.INSTANCE;
                    }

                    public final void invoke(List<? extends T> list) {
                        Intrinsics.checkNotNullParameter(list, "");
                        MediaViewerModel BuiltInFictitiousFunctionClassFactory = presenter.BuiltInFictitiousFunctionClassFactory();
                        BuiltInFictitiousFunctionClassFactory.moveToNextValue--;
                        presenter.PlaceComponentResult(false);
                        presenter.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(list);
                    }
                }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract$Presenter$loadPrevious$2
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
                        Intrinsics.checkNotNullParameter(exc, "");
                        presenter.MyBillsEntityDataFactory(exc);
                    }
                });
            }

            public static void BuiltInFictitiousFunctionClassFactory(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, exc.getMessage(), exc);
            }
        }
    }
}
