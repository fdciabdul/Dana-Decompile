package id.dana.data.user;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.RxWorker;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.data.user.source.network.request.UserInfoRequest;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/user/UserInfoWorker;", "Landroidx/work/RxWorker;", "Lid/dana/domain/user/UserInfoResponse;", "userInfoResponse", "Landroidx/work/ListenableWorker$Result;", "checkResult", "(Lid/dana/domain/user/UserInfoResponse;)Landroidx/work/ListenableWorker$Result;", "Lio/reactivex/Single;", "createWork", "()Lio/reactivex/Single;", "Landroidx/work/WorkerParameters;", "params", "Landroidx/work/WorkerParameters;", "Lid/dana/domain/user/repository/UserRepository;", "userRepository", "Lid/dana/domain/user/repository/UserRepository;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lid/dana/domain/user/repository/UserRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserInfoWorker extends RxWorker {
    private static final long BACKOFF_TIME = 3000;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "UserInfoWorker";
    public static final String USER_INFO_FACE_AUTH_WORKER_KEY = "USER_INFO_FACE_AUTH_WORKER_KEY";
    public static final String USER_INFO_FULL_WORKER_KEY = "USER_INFO_FULL_WORKER_KEY";
    public static final String USER_INFO_KYC_INFO_WORKER_KEY = "USER_INFO_KYC_INFO_WORKER_KEY";
    public static final String USER_INFO_STATUS_INFO_WORKER_KEY = "USER_INFO_STATUS_INFO_WORKER_KEY";
    public static final String USER_INFO_USER_PAN_WORKER_KEY = "USER_INFO_USER_INFO_WORKER_KEY";
    public static final String USER_INFO_WORKER_KEY = "USER_INFO_WORKER_KEY";
    private final WorkerParameters params;
    private final UserRepository userRepository;

    @JvmStatic
    public static final boolean isWorkerUncompleted(Context context, String str) {
        return INSTANCE.isWorkerUncompleted(context, str);
    }

    @JvmStatic
    public static final void startWorker(Context context, String str) {
        INSTANCE.startWorker(context, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInfoWorker(Context context, WorkerParameters workerParameters, UserRepository userRepository) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(workerParameters, "");
        Intrinsics.checkNotNullParameter(userRepository, "");
        this.params = workerParameters;
        this.userRepository = userRepository;
    }

    @Override // androidx.work.RxWorker
    public final Single<ListenableWorker.Result> createWork() {
        Object obj = this.params.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.get(USER_INFO_WORKER_KEY);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            switch (str.hashCode()) {
                case -1651707873:
                    if (str.equals(USER_INFO_STATUS_INFO_WORKER_KEY)) {
                        Single<ListenableWorker.Result> firstOrError = this.userRepository.getUserStatusInfo(true).map(new Function() { // from class: id.dana.data.user.UserInfoWorker$$ExternalSyntheticLambda4
                            @Override // io.reactivex.functions.Function
                            public final Object apply(Object obj2) {
                                ListenableWorker.Result m2103createWork$lambda4;
                                m2103createWork$lambda4 = UserInfoWorker.m2103createWork$lambda4(UserInfoWorker.this, (UserInfoResponse) obj2);
                                return m2103createWork$lambda4;
                            }
                        }).firstOrError();
                        Intrinsics.checkNotNullExpressionValue(firstOrError, "");
                        return firstOrError;
                    }
                    break;
                case -1257768088:
                    if (str.equals(USER_INFO_KYC_INFO_WORKER_KEY)) {
                        Single<ListenableWorker.Result> firstOrError2 = this.userRepository.getUserInfoWithKyc(true).map(new Function() { // from class: id.dana.data.user.UserInfoWorker$$ExternalSyntheticLambda2
                            @Override // io.reactivex.functions.Function
                            public final Object apply(Object obj2) {
                                ListenableWorker.Result m2101createWork$lambda2;
                                m2101createWork$lambda2 = UserInfoWorker.m2101createWork$lambda2(UserInfoWorker.this, (UserInfoResponse) obj2);
                                return m2101createWork$lambda2;
                            }
                        }).firstOrError();
                        Intrinsics.checkNotNullExpressionValue(firstOrError2, "");
                        return firstOrError2;
                    }
                    break;
                case -207869640:
                    if (str.equals(USER_INFO_USER_PAN_WORKER_KEY)) {
                        Single<ListenableWorker.Result> firstOrError3 = this.userRepository.getUserInfoWithUserPan().map(new Function() { // from class: id.dana.data.user.UserInfoWorker$$ExternalSyntheticLambda3
                            @Override // io.reactivex.functions.Function
                            public final Object apply(Object obj2) {
                                ListenableWorker.Result m2102createWork$lambda3;
                                m2102createWork$lambda3 = UserInfoWorker.m2102createWork$lambda3(UserInfoWorker.this, (UserInfoResponse) obj2);
                                return m2102createWork$lambda3;
                            }
                        }).firstOrError();
                        Intrinsics.checkNotNullExpressionValue(firstOrError3, "");
                        return firstOrError3;
                    }
                    break;
                case 1530703889:
                    if (str.equals(USER_INFO_FULL_WORKER_KEY)) {
                        Single<ListenableWorker.Result> firstOrError4 = this.userRepository.getUserInfo(true).map(new Function() { // from class: id.dana.data.user.UserInfoWorker$$ExternalSyntheticLambda0
                            @Override // io.reactivex.functions.Function
                            public final Object apply(Object obj2) {
                                ListenableWorker.Result m2099createWork$lambda0;
                                m2099createWork$lambda0 = UserInfoWorker.m2099createWork$lambda0(UserInfoWorker.this, (UserInfoResponse) obj2);
                                return m2099createWork$lambda0;
                            }
                        }).firstOrError();
                        Intrinsics.checkNotNullExpressionValue(firstOrError4, "");
                        return firstOrError4;
                    }
                    break;
                case 2095429264:
                    if (str.equals(USER_INFO_FACE_AUTH_WORKER_KEY)) {
                        Single<ListenableWorker.Result> firstOrError5 = this.userRepository.getFaceAuthInfo(true).map(new Function() { // from class: id.dana.data.user.UserInfoWorker$$ExternalSyntheticLambda1
                            @Override // io.reactivex.functions.Function
                            public final Object apply(Object obj2) {
                                ListenableWorker.Result m2100createWork$lambda1;
                                m2100createWork$lambda1 = UserInfoWorker.m2100createWork$lambda1(UserInfoWorker.this, (UserInfoResponse) obj2);
                                return m2100createWork$lambda1;
                            }
                        }).firstOrError();
                        Intrinsics.checkNotNullExpressionValue(firstOrError5, "");
                        return firstOrError5;
                    }
                    break;
            }
        }
        Single<ListenableWorker.Result> MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(ListenableWorker.Result.getAuthRequestContext());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* renamed from: createWork$lambda-0 */
    public static final ListenableWorker.Result m2099createWork$lambda0(UserInfoWorker userInfoWorker, UserInfoResponse userInfoResponse) {
        Intrinsics.checkNotNullParameter(userInfoWorker, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        return userInfoWorker.checkResult(userInfoResponse);
    }

    /* renamed from: createWork$lambda-1 */
    public static final ListenableWorker.Result m2100createWork$lambda1(UserInfoWorker userInfoWorker, UserInfoResponse userInfoResponse) {
        Intrinsics.checkNotNullParameter(userInfoWorker, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        return userInfoWorker.checkResult(userInfoResponse);
    }

    /* renamed from: createWork$lambda-2 */
    public static final ListenableWorker.Result m2101createWork$lambda2(UserInfoWorker userInfoWorker, UserInfoResponse userInfoResponse) {
        Intrinsics.checkNotNullParameter(userInfoWorker, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        return userInfoWorker.checkResult(userInfoResponse);
    }

    /* renamed from: createWork$lambda-3 */
    public static final ListenableWorker.Result m2102createWork$lambda3(UserInfoWorker userInfoWorker, UserInfoResponse userInfoResponse) {
        Intrinsics.checkNotNullParameter(userInfoWorker, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        return userInfoWorker.checkResult(userInfoResponse);
    }

    /* renamed from: createWork$lambda-4 */
    public static final ListenableWorker.Result m2103createWork$lambda4(UserInfoWorker userInfoWorker, UserInfoResponse userInfoResponse) {
        Intrinsics.checkNotNullParameter(userInfoWorker, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        return userInfoWorker.checkResult(userInfoResponse);
    }

    private final ListenableWorker.Result checkResult(UserInfoResponse userInfoResponse) {
        ListenableWorker.Result BuiltInFictitiousFunctionClassFactory = userInfoResponse.getLoginId().length() > 0 ? ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory() : ListenableWorker.Result.getAuthRequestContext();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011"}, d2 = {"Lid/dana/data/user/UserInfoWorker$Companion;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "key", "", "isWorkerUncompleted", "(Landroid/content/Context;Ljava/lang/String;)Z", "queryType", "", "startWorker", "(Landroid/content/Context;Ljava/lang/String;)V", "", "BACKOFF_TIME", "J", "TAG", "Ljava/lang/String;", UserInfoWorker.USER_INFO_FACE_AUTH_WORKER_KEY, UserInfoWorker.USER_INFO_FULL_WORKER_KEY, UserInfoWorker.USER_INFO_KYC_INFO_WORKER_KEY, UserInfoWorker.USER_INFO_STATUS_INFO_WORKER_KEY, "USER_INFO_USER_PAN_WORKER_KEY", UserInfoWorker.USER_INFO_WORKER_KEY, "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @JvmStatic
        public final void startWorker(Context r9, String queryType) {
            String str;
            WorkManager PlaceComponentResult;
            Intrinsics.checkNotNullParameter(r9, "");
            Intrinsics.checkNotNullParameter(queryType, "");
            switch (queryType.hashCode()) {
                case 2169487:
                    if (queryType.equals("FULL")) {
                        str = UserInfoWorker.USER_INFO_FULL_WORKER_KEY;
                        break;
                    }
                    str = "";
                    break;
                case 517433865:
                    if (queryType.equals(UserInfoRequest.USER_PAN)) {
                        str = UserInfoWorker.USER_INFO_USER_PAN_WORKER_KEY;
                        break;
                    }
                    str = "";
                    break;
                case 1044132426:
                    if (queryType.equals("FACE_AUTH")) {
                        str = UserInfoWorker.USER_INFO_FACE_AUTH_WORKER_KEY;
                        break;
                    }
                    str = "";
                    break;
                case 1253344792:
                    if (queryType.equals(UserInfoRequest.KYC_INFO)) {
                        str = UserInfoWorker.USER_INFO_KYC_INFO_WORKER_KEY;
                        break;
                    }
                    str = "";
                    break;
                case 1290991835:
                    if (queryType.equals(UserInfoRequest.STATUS_INFO)) {
                        str = UserInfoWorker.USER_INFO_STATUS_INFO_WORKER_KEY;
                        break;
                    }
                    str = "";
                    break;
                default:
                    str = "";
                    break;
            }
            if (isWorkerUncompleted(r9, str)) {
                return;
            }
            if (str.length() == 0) {
                return;
            }
            Constraints.Builder builder = new Constraints.Builder();
            builder.PlaceComponentResult = NetworkType.CONNECTED;
            Constraints constraints = new Constraints(builder);
            Intrinsics.checkNotNullExpressionValue(constraints, "");
            Data.Builder builder2 = new Data.Builder();
            builder2.MyBillsEntityDataFactory.put(UserInfoWorker.USER_INFO_WORKER_KEY, str);
            OneTimeWorkRequest.Builder authRequestContext = new OneTimeWorkRequest.Builder(UserInfoWorker.class).getAuthRequestContext(BackoffPolicy.EXPONENTIAL, 3000L, TimeUnit.MILLISECONDS);
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = constraints;
            OneTimeWorkRequest.Builder MyBillsEntityDataFactory = authRequestContext.MyBillsEntityDataFactory();
            Data data = new Data(builder2.MyBillsEntityDataFactory);
            Data.getAuthRequestContext(data);
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = data;
            OneTimeWorkRequest KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2();
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            OneTimeWorkRequest oneTimeWorkRequest = KClassImpl$Data$declaredNonStaticMembers$2;
            try {
                PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(r9);
                PlaceComponentResult.PlaceComponentResult(str, ExistingWorkPolicy.KEEP, Collections.singletonList(oneTimeWorkRequest));
            } catch (Exception e) {
                Crashlytics.Companion companion = Crashlytics.INSTANCE;
                Crashlytics authRequestContext2 = Crashlytics.Companion.getAuthRequestContext();
                Exception exc = e;
                Intrinsics.checkNotNullParameter(exc, "");
                authRequestContext2.getAuthRequestContext.recordException(exc);
            }
        }

        @JvmStatic
        public final boolean isWorkerUncompleted(Context r5, String key) {
            WorkManager PlaceComponentResult;
            Intrinsics.checkNotNullParameter(r5, "");
            Intrinsics.checkNotNullParameter(key, "");
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(r5);
            List<WorkInfo> list = PlaceComponentResult.PlaceComponentResult(key).get();
            try {
                Intrinsics.checkNotNullExpressionValue(list, "");
                List<WorkInfo> list2 = list;
                if ((list2 instanceof Collection) && list2.isEmpty()) {
                    return false;
                }
                for (WorkInfo workInfo : list2) {
                    if (WorkInfo.State.RUNNING == workInfo.KClassImpl$Data$declaredNonStaticMembers$2 || WorkInfo.State.ENQUEUED == workInfo.KClassImpl$Data$declaredNonStaticMembers$2) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(UserInfoWorker.TAG, e.getMessage(), e);
                return false;
            }
        }
    }
}
