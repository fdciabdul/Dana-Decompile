package id.dana.nearbyme.merchantreview;

import android.content.Context;
import android.webkit.URLUtil;
import androidx.work.BackoffPolicy;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkerParameters;
import com.alibaba.griver.core.GriverParams;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.nearbyme.interactor.merchantreview.UploadMerchantReviewImage;
import id.dana.domain.social.Result;
import id.dana.utils.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0004\u0010\tJ\u0017\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0004\u0010\fR\u001a\u0010\u0012\u001a\u00020\r8\u0015X\u0094D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u00020\u0013X\u0087\"¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/nearbyme/merchantreview/UploadImageWorker;", "Lid/dana/nearbyme/merchantreview/MerchantReviewWorker;", "", "Lid/dana/domain/social/Result;", "getAuthRequestContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/di/component/ApplicationComponent;", "p0", "", "(Lid/dana/di/component/ApplicationComponent;)V", "Landroidx/work/Data;", "", "(Landroidx/work/Data;)Z", "", "MyBillsEntityDataFactory", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "()I", "PlaceComponentResult", "Lid/dana/domain/nearbyme/interactor/merchantreview/UploadMerchantReviewImage;", "uploadImage", "Lid/dana/domain/nearbyme/interactor/merchantreview/UploadMerchantReviewImage;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UploadImageWorker extends MerchantReviewWorker<String> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final int PlaceComponentResult;
    @Inject
    public UploadMerchantReviewImage uploadImage;

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewWorker
    public final /* synthetic */ ListenableWorker.Result KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "");
        Data.Builder builder = new Data.Builder();
        builder.MyBillsEntityDataFactory.put(GriverParams.ShareParams.IMAGE_URL, str2);
        Data data = new Data(builder.MyBillsEntityDataFactory);
        Data.getAuthRequestContext(data);
        Intrinsics.checkNotNullExpressionValue(data, "");
        ListenableWorker.Result BuiltInFictitiousFunctionClassFactory = ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory(data);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadImageWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(workerParameters, "");
        this.PlaceComponentResult = 1;
    }

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewWorker
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    protected final int getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewWorker
    protected final void getAuthRequestContext(ApplicationComponent p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.PlaceComponentResult(this);
    }

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewWorker
    protected final Object getAuthRequestContext(Continuation<? super Result<? extends String>> continuation) {
        String str;
        Data inputData = getInputData();
        Intrinsics.checkNotNullExpressionValue(inputData, "");
        if (getAuthRequestContext(inputData)) {
            UploadMerchantReviewImage uploadMerchantReviewImage = this.uploadImage;
            if (uploadMerchantReviewImage == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                uploadMerchantReviewImage = null;
            }
            Data inputData2 = getInputData();
            Intrinsics.checkNotNullExpressionValue(inputData2, "");
            Context applicationContext = getApplicationContext();
            Object obj = inputData2.MyBillsEntityDataFactory.get("imageFile");
            str = obj instanceof String ? (String) obj : null;
            if (str == null) {
                str = "";
            }
            File MyBillsEntityDataFactory = FileUtil.MyBillsEntityDataFactory(applicationContext, str);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            return uploadMerchantReviewImage.invoke(MyBillsEntityDataFactory, continuation);
        }
        Object obj2 = getInputData().MyBillsEntityDataFactory.get("imageFile");
        str = obj2 instanceof String ? (String) obj2 : null;
        return new Result.Success(str != null ? str : "");
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/nearbyme/merchantreview/UploadImageWorker$Companion;", "", "", "", "p0", "Landroidx/work/OneTimeWorkRequest;", "PlaceComponentResult", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static List<OneTimeWorkRequest> PlaceComponentResult(List<String> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            List<String> list = p0;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str : list) {
                OneTimeWorkRequest.Builder authRequestContext = new OneTimeWorkRequest.Builder(UploadImageWorker.class).getAuthRequestContext(BackoffPolicy.LINEAR, 10000L, TimeUnit.MILLISECONDS);
                Companion companion = UploadImageWorker.INSTANCE;
                Data.Builder builder = new Data.Builder();
                builder.MyBillsEntityDataFactory.put("imageFile", str);
                Data data = new Data(builder.MyBillsEntityDataFactory);
                Data.getAuthRequestContext(data);
                Intrinsics.checkNotNullExpressionValue(data, "");
                authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = data;
                arrayList.add(authRequestContext.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2());
            }
            return arrayList;
        }
    }

    private static boolean getAuthRequestContext(Data p0) {
        Object obj = p0.MyBillsEntityDataFactory.get("imageFile");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        return (str.length() > 0) && URLUtil.isContentUrl(str);
    }
}
