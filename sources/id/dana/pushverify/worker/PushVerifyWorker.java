package id.dana.pushverify.worker;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.RxWorker;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.domain.pushverify.interactor.GetPushVerifyChallenge;
import id.dana.domain.pushverify.interactor.GetVerifyPushChallenge;
import id.dana.domain.pushverify.model.PushVerifyChallenge;
import id.dana.domain.pushverify.model.PushVerifyParam;
import id.dana.domain.pushverify.model.VerifyPushChallenge;
import id.dana.domain.pushverify.model.VerifyPushChallengeParam;
import id.dana.pushverify.constant.PushVerifyConstants;
import id.dana.pushverify.mapper.PushVerifyModelMapperKt;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.pushverify.worker.PushVerifyWorker;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB/\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0007\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u000b\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012"}, d2 = {"Lid/dana/pushverify/worker/PushVerifyWorker;", "Landroidx/work/RxWorker;", "Lio/reactivex/Single;", "Landroidx/work/ListenableWorker$Result;", "createWork", "()Lio/reactivex/Single;", "Lid/dana/domain/pushverify/interactor/GetPushVerifyChallenge;", "MyBillsEntityDataFactory", "Lid/dana/domain/pushverify/interactor/GetPushVerifyChallenge;", "PlaceComponentResult", "Lid/dana/domain/pushverify/interactor/GetVerifyPushChallenge;", "getAuthRequestContext", "Lid/dana/domain/pushverify/interactor/GetVerifyPushChallenge;", "Lid/dana/pushverify/tracker/PushVerifyTracker;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/pushverify/tracker/PushVerifyTracker;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/work/WorkerParameters;", "Landroidx/work/WorkerParameters;", "Landroid/content/Context;", HummerConstants.CONTEXT, "workerParameters", "getPushVerifyChallenge", "getVerifyPushChallenge", "pushVerifyTracker", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lid/dana/domain/pushverify/interactor/GetPushVerifyChallenge;Lid/dana/domain/pushverify/interactor/GetVerifyPushChallenge;Lid/dana/pushverify/tracker/PushVerifyTracker;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PushVerifyWorker extends RxWorker {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final PushVerifyTracker BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetPushVerifyChallenge PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final WorkerParameters getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetVerifyPushChallenge MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushVerifyWorker(Context context, WorkerParameters workerParameters, GetPushVerifyChallenge getPushVerifyChallenge, GetVerifyPushChallenge getVerifyPushChallenge, PushVerifyTracker pushVerifyTracker) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(workerParameters, "");
        Intrinsics.checkNotNullParameter(getPushVerifyChallenge, "");
        Intrinsics.checkNotNullParameter(getVerifyPushChallenge, "");
        Intrinsics.checkNotNullParameter(pushVerifyTracker, "");
        this.getAuthRequestContext = workerParameters;
        this.PlaceComponentResult = getPushVerifyChallenge;
        this.MyBillsEntityDataFactory = getVerifyPushChallenge;
        this.BuiltInFictitiousFunctionClassFactory = pushVerifyTracker;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0010\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u000e\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011"}, d2 = {"Lid/dana/pushverify/worker/PushVerifyWorker$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "getAuthRequestContext", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Params {
        private final boolean BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Params) {
                Params params = (Params) p0;
                return Intrinsics.areEqual(this.getAuthRequestContext, params.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, params.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, params.KClassImpl$Data$declaredNonStaticMembers$2) && this.BuiltInFictitiousFunctionClassFactory == params.BuiltInFictitiousFunctionClassFactory;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.getAuthRequestContext.hashCode();
            int hashCode2 = this.MyBillsEntityDataFactory.hashCode();
            int hashCode3 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
            boolean z = this.BuiltInFictitiousFunctionClassFactory;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.getAuthRequestContext = str;
            this.MyBillsEntityDataFactory = str2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @JvmName(name = "getAuthRequestContext")
        public final boolean getAuthRequestContext() {
            return (StringsKt.isBlank(this.getAuthRequestContext) ^ true) && (StringsKt.isBlank(this.MyBillsEntityDataFactory) ^ true) && (StringsKt.isBlank(this.KClassImpl$Data$declaredNonStaticMembers$2) ^ true);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/pushverify/worker/PushVerifyWorker$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "p2", "p3", "", "p4", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void MyBillsEntityDataFactory(Context p0, String p1, String p2, String p3, boolean p4) {
            WorkManager PlaceComponentResult;
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Data.Builder builder = new Data.Builder();
            builder.MyBillsEntityDataFactory.put("TRANSACTION_ID", p1);
            builder.MyBillsEntityDataFactory.put("CACHE_LEY", p2);
            builder.MyBillsEntityDataFactory.put("TOKEN", p3);
            builder.MyBillsEntityDataFactory.put("APPROVE_VERIFY", Boolean.valueOf(p4));
            Data data = new Data(builder.MyBillsEntityDataFactory);
            Data.getAuthRequestContext(data);
            Intrinsics.checkNotNullExpressionValue(data, "");
            Constraints.Builder builder2 = new Constraints.Builder();
            builder2.PlaceComponentResult = NetworkType.CONNECTED;
            Constraints constraints = new Constraints(builder2);
            Intrinsics.checkNotNullExpressionValue(constraints, "");
            OneTimeWorkRequest.Builder builder3 = new OneTimeWorkRequest.Builder(PushVerifyWorker.class);
            builder3.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = data;
            OneTimeWorkRequest.Builder MyBillsEntityDataFactory = builder3.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = constraints;
            OneTimeWorkRequest KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2();
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(p0.getApplicationContext());
            PlaceComponentResult.PlaceComponentResult(Collections.singletonList(KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    public static /* synthetic */ PushVerifyChallenge PlaceComponentResult(PushVerifyWorker pushVerifyWorker, PushVerifyChallenge pushVerifyChallenge, String str, VerifyPushChallenge verifyPushChallenge) {
        Intrinsics.checkNotNullParameter(pushVerifyWorker, "");
        Intrinsics.checkNotNullParameter(pushVerifyChallenge, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(verifyPushChallenge, "");
        pushVerifyWorker.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(PushVerifyModelMapperKt.BuiltInFictitiousFunctionClassFactory(pushVerifyChallenge), str, true);
        return pushVerifyChallenge;
    }

    public static /* synthetic */ ListenableWorker.Result MyBillsEntityDataFactory(PushVerifyChallenge pushVerifyChallenge) {
        Intrinsics.checkNotNullParameter(pushVerifyChallenge, "");
        return ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory();
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(Params params, final PushVerifyWorker pushVerifyWorker, final String str, final PushVerifyChallenge pushVerifyChallenge) {
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(pushVerifyWorker, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(pushVerifyChallenge, "");
        VerifyPushChallengeParam verifyPushChallengeParam = new VerifyPushChallengeParam(params.KClassImpl$Data$declaredNonStaticMembers$2, pushVerifyChallenge.getTokenPair(), params.getBuiltInFictitiousFunctionClassFactory(), params.getAuthRequestContext, params.MyBillsEntityDataFactory);
        pushVerifyWorker.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(PushVerifyModelMapperKt.BuiltInFictitiousFunctionClassFactory(pushVerifyChallenge), str, "Push Notification");
        return pushVerifyWorker.MyBillsEntityDataFactory.buildUseCase(verifyPushChallengeParam).map(new Function() { // from class: id.dana.pushverify.worker.PushVerifyWorker$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PushVerifyWorker.PlaceComponentResult(PushVerifyWorker.this, pushVerifyChallenge, str, (VerifyPushChallenge) obj);
            }
        }).doOnError(new Consumer() { // from class: id.dana.pushverify.worker.PushVerifyWorker$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PushVerifyWorker.KClassImpl$Data$declaredNonStaticMembers$2(PushVerifyWorker.this, str, (Throwable) obj);
            }
        });
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(PushVerifyWorker pushVerifyWorker, Throwable th) {
        Intrinsics.checkNotNullParameter(pushVerifyWorker, "");
        PushVerifyTracker pushVerifyTracker = pushVerifyWorker.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(th, "");
        pushVerifyTracker.KClassImpl$Data$declaredNonStaticMembers$2(th);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PushVerifyWorker pushVerifyWorker, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(pushVerifyWorker, "");
        Intrinsics.checkNotNullParameter(str, "");
        PushVerifyTracker pushVerifyTracker = pushVerifyWorker.BuiltInFictitiousFunctionClassFactory;
        pushVerifyTracker.getAuthRequestContext(null, str, false);
        Intrinsics.checkNotNullExpressionValue(th, "");
        pushVerifyTracker.MyBillsEntityDataFactory(th);
    }

    @Override // androidx.work.RxWorker
    public final Single<ListenableWorker.Result> createWork() {
        Data data = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
        Object obj = data.MyBillsEntityDataFactory.get("TRANSACTION_ID");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        Object obj2 = data.MyBillsEntityDataFactory.get("CACHE_LEY");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        if (str2 == null) {
            str2 = "";
        }
        Object obj3 = data.MyBillsEntityDataFactory.get("TOKEN");
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        if (str3 == null) {
            str3 = "";
        }
        final Params params = new Params(str, str2, str3, data.getAuthRequestContext("APPROVE_VERIFY"));
        if (!params.getAuthRequestContext()) {
            Single<ListenableWorker.Result> MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(ListenableWorker.Result.getAuthRequestContext());
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            return MyBillsEntityDataFactory;
        }
        final String str4 = params.getBuiltInFictitiousFunctionClassFactory() ? "Allow" : PushVerifyConstants.REJECT;
        Single firstOrError = this.PlaceComponentResult.buildUseCase(new PushVerifyParam(params.getAuthRequestContext, params.MyBillsEntityDataFactory)).doOnError(new Consumer() { // from class: id.dana.pushverify.worker.PushVerifyWorker$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj4) {
                PushVerifyWorker.MyBillsEntityDataFactory(PushVerifyWorker.this, (Throwable) obj4);
            }
        }).switchMap(new Function() { // from class: id.dana.pushverify.worker.PushVerifyWorker$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj4) {
                return PushVerifyWorker.BuiltInFictitiousFunctionClassFactory(PushVerifyWorker.Params.this, this, str4, (PushVerifyChallenge) obj4);
            }
        }).firstOrError();
        Function function = new Function() { // from class: id.dana.pushverify.worker.PushVerifyWorker$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj4) {
                return PushVerifyWorker.MyBillsEntityDataFactory((PushVerifyChallenge) obj4);
            }
        };
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(firstOrError, function));
        ListenableWorker.Result authRequestContext = ListenableWorker.Result.getAuthRequestContext();
        ObjectHelper.PlaceComponentResult(authRequestContext, "value is null");
        Single<ListenableWorker.Result> BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleOnErrorReturn(BuiltInFictitiousFunctionClassFactory, null, authRequestContext));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        return BuiltInFictitiousFunctionClassFactory2;
    }
}
