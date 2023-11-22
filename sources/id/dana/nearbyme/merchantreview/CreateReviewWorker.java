package id.dana.nearbyme.merchantreview;

import android.content.Context;
import androidx.view.LiveData;
import androidx.view.MutableLiveData;
import androidx.work.ArrayCreatingInputMerger;
import androidx.work.BackoffPolicy;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import com.alibaba.griver.core.GriverParams;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.base.extension.WorkManagerFailure;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.nearbyme.interactor.merchantreview.CreateMerchantReview;
import id.dana.domain.nearbyme.model.MerchantCreateReview;
import id.dana.domain.social.Result;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0004\u0010\bR\u0012\u0010\n\u001a\u00020\tX\u0087\"¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\f8\u0015X\u0095D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/nearbyme/merchantreview/CreateReviewWorker;", "Lid/dana/nearbyme/merchantreview/MerchantReviewWorker;", "", "Lid/dana/domain/social/Result;", "getAuthRequestContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/di/component/ApplicationComponent;", "p0", "(Lid/dana/di/component/ApplicationComponent;)V", "Lid/dana/domain/nearbyme/interactor/merchantreview/CreateMerchantReview;", "createReview", "Lid/dana/domain/nearbyme/interactor/merchantreview/CreateMerchantReview;", "", "PlaceComponentResult", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "()I", "MyBillsEntityDataFactory", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CreateReviewWorker extends MerchantReviewWorker<Unit> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final int MyBillsEntityDataFactory;
    @Inject
    public CreateMerchantReview createReview;

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewWorker
    public final /* synthetic */ ListenableWorker.Result KClassImpl$Data$declaredNonStaticMembers$2(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "");
        ListenableWorker.Result BuiltInFictitiousFunctionClassFactory = ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateReviewWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(workerParameters, "");
        this.MyBillsEntityDataFactory = 3;
    }

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewWorker
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    protected final int getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewWorker
    protected final void getAuthRequestContext(ApplicationComponent p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.MyBillsEntityDataFactory(this);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/nearbyme/merchantreview/CreateReviewWorker$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "Landroidx/lifecycle/LiveData;", "", "Landroidx/work/WorkInfo;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "Lid/dana/nearbyme/merchantreview/CreateReviewWorker$Param;", "Landroidx/work/OneTimeWorkRequest;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/nearbyme/merchantreview/CreateReviewWorker$Param;)Landroidx/work/OneTimeWorkRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static OneTimeWorkRequest KClassImpl$Data$declaredNonStaticMembers$2(Param p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            OneTimeWorkRequest.Builder authRequestContext = new OneTimeWorkRequest.Builder(CreateReviewWorker.class).getAuthRequestContext(BackoffPolicy.LINEAR, 10000L, TimeUnit.MILLISECONDS);
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1 = ArrayCreatingInputMerger.class.getName();
            Data.Builder builder = new Data.Builder();
            builder.MyBillsEntityDataFactory.put("review", p0.KClassImpl$Data$declaredNonStaticMembers$2);
            builder.MyBillsEntityDataFactory.put("rating", Integer.valueOf(p0.MyBillsEntityDataFactory));
            Object[] array = p0.PlaceComponentResult.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            builder.MyBillsEntityDataFactory.put("positiveTags", (String[]) array);
            Object[] array2 = p0.BuiltInFictitiousFunctionClassFactory.toArray(new String[0]);
            if (array2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            builder.MyBillsEntityDataFactory.put("negativeTags", (String[]) array2);
            builder.MyBillsEntityDataFactory.put(FeatureParams.SHOP_ID, p0.NetworkUserEntityData$$ExternalSyntheticLambda0);
            builder.MyBillsEntityDataFactory.put("shareToFeed", Boolean.valueOf(p0.lookAheadTest));
            builder.MyBillsEntityDataFactory.put("isUpdateReview", Boolean.valueOf(p0.getAuthRequestContext));
            String str = p0.scheduleImpl;
            if (str == null) {
                str = "";
            }
            builder.MyBillsEntityDataFactory.put("reviewId", str);
            Data data = new Data(builder.MyBillsEntityDataFactory);
            Data.getAuthRequestContext(data);
            Intrinsics.checkNotNullExpressionValue(data, "");
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = data;
            OneTimeWorkRequest.Builder MyBillsEntityDataFactory = authRequestContext.MyBillsEntityDataFactory();
            StringBuilder sb = new StringBuilder();
            sb.append("merchantReviewWorkId_");
            sb.append(p0.moveToNextValue);
            MyBillsEntityDataFactory.PlaceComponentResult.add(sb.toString());
            OneTimeWorkRequest.Builder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("merchantReviewShopId_");
            sb2.append(p0.NetworkUserEntityData$$ExternalSyntheticLambda0);
            MyBillsEntityDataFactory2.PlaceComponentResult.add(sb2.toString());
            OneTimeWorkRequest.Builder MyBillsEntityDataFactory3 = MyBillsEntityDataFactory2.MyBillsEntityDataFactory();
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory3, "");
            OneTimeWorkRequest KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory3.KClassImpl$Data$declaredNonStaticMembers$2();
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public static LiveData<List<WorkInfo>> BuiltInFictitiousFunctionClassFactory(Context p0, String p1) {
            LiveData<List<WorkInfo>> liveData;
            WorkManager PlaceComponentResult;
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            try {
                PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(p0);
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                StringBuilder sb = new StringBuilder();
                sb.append("merchantReviewWorkId_");
                sb.append(p1);
                liveData = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(sb.toString());
            } catch (Exception e) {
                try {
                    Crashlytics.Companion companion = Crashlytics.INSTANCE;
                    Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                    WorkManagerFailure workManagerFailure = new WorkManagerFailure(e);
                    Intrinsics.checkNotNullParameter(workManagerFailure, "");
                    authRequestContext.getAuthRequestContext.recordException(workManagerFailure);
                } catch (Exception unused) {
                }
                liveData = null;
            }
            return liveData == null ? new MutableLiveData(CollectionsKt.emptyList()) : liveData;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u000f\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u000f\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\"\u001a\u00020\t¢\u0006\u0004\b#\u0010$J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0011\u0010\u0010\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0013\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0011\u0010\u0018\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015"}, d2 = {"Lid/dana/nearbyme/merchantreview/CreateReviewWorker$Param;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Z", "getAuthRequestContext", "", "MyBillsEntityDataFactory", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "Ljava/lang/String;", "moveToNextValue", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "getErrorConfigVersion", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Param {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final int MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final List<String> BuiltInFictitiousFunctionClassFactory;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public final boolean lookAheadTest;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final boolean getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final List<String> PlaceComponentResult;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        final String moveToNextValue;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public final String scheduleImpl;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        final String NetworkUserEntityData$$ExternalSyntheticLambda0;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Param) {
                Param param = (Param) p0;
                return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, param.KClassImpl$Data$declaredNonStaticMembers$2) && this.MyBillsEntityDataFactory == param.MyBillsEntityDataFactory && Intrinsics.areEqual(this.PlaceComponentResult, param.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, param.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, param.NetworkUserEntityData$$ExternalSyntheticLambda0) && this.lookAheadTest == param.lookAheadTest && this.getAuthRequestContext == param.getAuthRequestContext && Intrinsics.areEqual(this.scheduleImpl, param.scheduleImpl) && Intrinsics.areEqual(this.moveToNextValue, param.moveToNextValue);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
            int i = this.MyBillsEntityDataFactory;
            int hashCode2 = this.PlaceComponentResult.hashCode();
            int hashCode3 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
            int hashCode4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
            boolean z = this.lookAheadTest;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            boolean z2 = this.getAuthRequestContext;
            int i3 = z2 ? 1 : z2 ? 1 : 0;
            String str = this.scheduleImpl;
            return (((((((((((((((hashCode * 31) + i) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i2) * 31) + i3) * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.moveToNextValue.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append(", lookAheadTest=");
            sb.append(this.lookAheadTest);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", scheduleImpl=");
            sb.append(this.scheduleImpl);
            sb.append(", moveToNextValue=");
            sb.append(this.moveToNextValue);
            sb.append(')');
            return sb.toString();
        }

        public Param(String str, int i, List<String> list, List<String> list2, String str2, boolean z, boolean z2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(list2, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str4, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.MyBillsEntityDataFactory = i;
            this.PlaceComponentResult = list;
            this.BuiltInFictitiousFunctionClassFactory = list2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str2;
            this.lookAheadTest = z;
            this.getAuthRequestContext = z2;
            this.scheduleImpl = str3;
            this.moveToNextValue = str4;
        }
    }

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewWorker
    protected final Object getAuthRequestContext(Continuation<? super Result<? extends Unit>> continuation) {
        int[] iArr;
        CreateMerchantReview createMerchantReview = this.createReview;
        if (createMerchantReview == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            createMerchantReview = null;
        }
        Data inputData = getInputData();
        Intrinsics.checkNotNullExpressionValue(inputData, "");
        Object obj = inputData.MyBillsEntityDataFactory.get("review");
        String[] strArr = obj instanceof String[] ? (String[]) obj : null;
        String str = strArr != null ? strArr[0] : null;
        String str2 = str == null ? "" : str;
        Object obj2 = inputData.MyBillsEntityDataFactory.get("rating");
        if (obj2 instanceof Integer[]) {
            Integer[] numArr = (Integer[]) obj2;
            iArr = new int[numArr.length];
            for (int i = 0; i < numArr.length; i++) {
                iArr[i] = numArr[i].intValue();
            }
        } else {
            iArr = null;
        }
        int i2 = iArr != null ? iArr[0] : 0;
        Object obj3 = inputData.MyBillsEntityDataFactory.get("positiveTags");
        String[] strArr2 = obj3 instanceof String[] ? (String[]) obj3 : null;
        if (strArr2 == null) {
            strArr2 = new String[0];
        }
        List list = ArraysKt.toList(strArr2);
        Object obj4 = inputData.MyBillsEntityDataFactory.get("negativeTags");
        String[] strArr3 = obj4 instanceof String[] ? (String[]) obj4 : null;
        if (strArr3 == null) {
            strArr3 = new String[0];
        }
        List list2 = ArraysKt.toList(strArr3);
        Object obj5 = inputData.MyBillsEntityDataFactory.get(GriverParams.ShareParams.IMAGE_URL);
        String[] strArr4 = obj5 instanceof String[] ? (String[]) obj5 : null;
        if (strArr4 == null) {
            strArr4 = new String[0];
        }
        List list3 = ArraysKt.toList(strArr4);
        Object obj6 = inputData.MyBillsEntityDataFactory.get(FeatureParams.SHOP_ID);
        String[] strArr5 = obj6 instanceof String[] ? (String[]) obj6 : null;
        String str3 = strArr5 != null ? strArr5[0] : null;
        String str4 = str3 == null ? "" : str3;
        boolean[] KClassImpl$Data$declaredNonStaticMembers$2 = inputData.KClassImpl$Data$declaredNonStaticMembers$2("shareToFeed");
        boolean z = KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2[0] : false;
        boolean[] KClassImpl$Data$declaredNonStaticMembers$22 = inputData.KClassImpl$Data$declaredNonStaticMembers$2("isUpdateReview");
        boolean z2 = KClassImpl$Data$declaredNonStaticMembers$22 != null ? KClassImpl$Data$declaredNonStaticMembers$22[0] : false;
        Object obj7 = inputData.MyBillsEntityDataFactory.get("reviewId");
        String[] strArr6 = obj7 instanceof String[] ? (String[]) obj7 : null;
        String str5 = strArr6 != null ? strArr6[0] : null;
        return createMerchantReview.invoke(new MerchantCreateReview(str2, i2, list, list2, list3, str4, z, z2, str5 == null ? "" : str5), continuation);
    }
}
