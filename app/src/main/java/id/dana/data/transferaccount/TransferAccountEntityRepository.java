package id.dana.data.transferaccount;

import id.dana.data.transferaccount.source.local.TransferAccountPreference;
import id.dana.data.transferaccount.source.network.DeletionChangeNumberResult;
import id.dana.data.transferaccount.source.network.TransferAccountQueryType;
import id.dana.data.transferaccount.source.network.TransferAccountStatusResult;
import id.dana.domain.transferaccount.StatusTransferAccount;
import id.dana.domain.transferaccount.TransferAccountRepository;
import id.dana.domain.transferaccount.TransferAccountStatus;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Singleton
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0015\u001a\u00020\u0007X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\r\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0014\u0010\u0011\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0019"}, d2 = {"Lid/dana/data/transferaccount/TransferAccountEntityRepository;", "Lid/dana/domain/transferaccount/TransferAccountRepository;", "Lio/reactivex/Observable;", "", "clearCache", "()Lio/reactivex/Observable;", "deletionChangeNumber", "", "getStatus", "Lid/dana/domain/transferaccount/TransferAccountStatus;", "getTransferAccountStatus", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "saveToken", "(Ljava/lang/String;)Lio/reactivex/Observable;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/data/transferaccount/TransferAccountEntityDataFactory;", "Lid/dana/data/transferaccount/TransferAccountEntityDataFactory;", "Lid/dana/data/transferaccount/source/local/TransferAccountPreference;", "Lid/dana/data/transferaccount/source/local/TransferAccountPreference;", "p1", "<init>", "(Lid/dana/data/transferaccount/TransferAccountEntityDataFactory;Lid/dana/data/transferaccount/source/local/TransferAccountPreference;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransferAccountEntityRepository implements TransferAccountRepository {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final TransferAccountPreference KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final TransferAccountEntityDataFactory PlaceComponentResult;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[StatusTransferAccount.values().length];
            iArr[StatusTransferAccount.PENDING.ordinal()] = 1;
            MyBillsEntityDataFactory = iArr;
        }
    }

    @Inject
    public TransferAccountEntityRepository(TransferAccountEntityDataFactory transferAccountEntityDataFactory, TransferAccountPreference transferAccountPreference) {
        Intrinsics.checkNotNullParameter(transferAccountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(transferAccountPreference, "");
        this.PlaceComponentResult = transferAccountEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = transferAccountPreference;
        this.getAuthRequestContext = "";
    }

    @Override // id.dana.domain.transferaccount.TransferAccountRepository
    public final Observable<Boolean> saveToken(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Boolean> doOnNext = Observable.just(Boolean.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(p0))).doOnNext(new Consumer() { // from class: id.dana.data.transferaccount.TransferAccountEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Boolean bool = (Boolean) obj;
                TransferAccountEntityRepository.MyBillsEntityDataFactory(TransferAccountEntityRepository.this, p0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        return doOnNext;
    }

    @Override // id.dana.domain.transferaccount.TransferAccountRepository
    public final Observable<TransferAccountStatus> getTransferAccountStatus() {
        if (this.getAuthRequestContext.length() == 0) {
            String string = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getString("transfer_account_token");
            if (string == null) {
                string = "";
            }
            this.getAuthRequestContext = string;
        }
        Observable<TransferAccountStatus> takeUntil = Observable.interval(2000L, TimeUnit.MILLISECONDS).flatMap(new Function() { // from class: id.dana.data.transferaccount.TransferAccountEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TransferAccountEntityRepository.MyBillsEntityDataFactory(TransferAccountEntityRepository.this, (Long) obj);
            }
        }).takeUntil(new Predicate() { // from class: id.dana.data.transferaccount.TransferAccountEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean KClassImpl$Data$declaredNonStaticMembers$2;
                KClassImpl$Data$declaredNonStaticMembers$2 = TransferAccountEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(TransferAccountEntityRepository.this, (TransferAccountStatus) obj);
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(takeUntil, "");
        return takeUntil;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(TransferAccountEntityRepository transferAccountEntityRepository, TransferAccountStatus transferAccountStatus) {
        Intrinsics.checkNotNullParameter(transferAccountEntityRepository, "");
        Intrinsics.checkNotNullParameter(transferAccountStatus, "");
        return KClassImpl$Data$declaredNonStaticMembers$2(transferAccountStatus.getStatus());
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        StatusTransferAccount value = StatusTransferAccount.INSTANCE.getValue(p0);
        return (value == null ? -1 : WhenMappings.MyBillsEntityDataFactory[value.ordinal()]) != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransferAccountStatus PlaceComponentResult(String str, TransferAccountStatusResult transferAccountStatusResult) {
        Object m3179constructorimpl;
        Object m3179constructorimpl2;
        Object m3179constructorimpl3;
        Object m3179constructorimpl4;
        Object m3179constructorimpl5;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(transferAccountStatusResult, "");
        String str2 = transferAccountStatusResult.extendInfo.get(TransferAccountStatusResult.OPERATION_STATUS);
        try {
            Result.Companion companion = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(str2 != null ? new JSONObject(str2) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m3185isFailureimpl(m3179constructorimpl)) {
            m3179constructorimpl = null;
        }
        JSONObject jSONObject = (JSONObject) m3179constructorimpl;
        String status = transferAccountStatusResult.getStatus();
        try {
            Result.Companion companion3 = Result.INSTANCE;
            m3179constructorimpl2 = Result.m3179constructorimpl(jSONObject != null ? jSONObject.getString(TransferAccountStatusResult.DELETE_USER) : null);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            m3179constructorimpl2 = Result.m3179constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m3185isFailureimpl(m3179constructorimpl2)) {
            m3179constructorimpl2 = null;
        }
        String str3 = (String) m3179constructorimpl2;
        try {
            Result.Companion companion5 = Result.INSTANCE;
            m3179constructorimpl3 = Result.m3179constructorimpl(jSONObject != null ? jSONObject.getString(TransferAccountStatusResult.CHANGE_MOBILE) : null);
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.INSTANCE;
            m3179constructorimpl3 = Result.m3179constructorimpl(ResultKt.createFailure(th3));
        }
        if (Result.m3185isFailureimpl(m3179constructorimpl3)) {
            m3179constructorimpl3 = null;
        }
        String str4 = (String) m3179constructorimpl3;
        try {
            Result.Companion companion7 = Result.INSTANCE;
            m3179constructorimpl4 = Result.m3179constructorimpl(jSONObject != null ? jSONObject.getString(TransferAccountStatusResult.CHANGE_PIN) : null);
        } catch (Throwable th4) {
            Result.Companion companion8 = Result.INSTANCE;
            m3179constructorimpl4 = Result.m3179constructorimpl(ResultKt.createFailure(th4));
        }
        if (Result.m3185isFailureimpl(m3179constructorimpl4)) {
            m3179constructorimpl4 = null;
        }
        String str5 = (String) m3179constructorimpl4;
        try {
            Result.Companion companion9 = Result.INSTANCE;
            m3179constructorimpl5 = Result.m3179constructorimpl(jSONObject != null ? jSONObject.getString(TransferAccountStatusResult.TRANSFER_BALANCE) : null);
        } catch (Throwable th5) {
            Result.Companion companion10 = Result.INSTANCE;
            m3179constructorimpl5 = Result.m3179constructorimpl(ResultKt.createFailure(th5));
        }
        return new TransferAccountStatus(status, str, str3, str4, str5, Result.m3185isFailureimpl(m3179constructorimpl5) ? null : m3179constructorimpl5, transferAccountStatusResult.errorMessage);
    }

    @Override // id.dana.domain.transferaccount.TransferAccountRepository
    public final Observable<Boolean> deletionChangeNumber() {
        if (this.getAuthRequestContext.length() == 0) {
            String string = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getString("transfer_account_token");
            if (string == null) {
                string = "";
            }
            this.getAuthRequestContext = string;
        }
        Observable map = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext).doOnError(new Consumer() { // from class: id.dana.data.transferaccount.TransferAccountEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Throwable th = (Throwable) obj;
                TransferAccountEntityRepository.BuiltInFictitiousFunctionClassFactory(TransferAccountEntityRepository.this);
            }
        }).map(new Function() { // from class: id.dana.data.transferaccount.TransferAccountEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TransferAccountEntityRepository.PlaceComponentResult((DeletionChangeNumberResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    private void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0.length() == 0) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(p0);
    }

    @Override // id.dana.domain.transferaccount.TransferAccountRepository
    public final Observable<Boolean> clearCache() {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.transferaccount.TransferAccountRepository
    public final Observable<String> getStatus() {
        Observable<String> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.transferaccount.TransferAccountEntityRepository$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return TransferAccountEntityRepository.MyBillsEntityDataFactory(TransferAccountEntityRepository.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    public static /* synthetic */ String MyBillsEntityDataFactory(TransferAccountEntityRepository transferAccountEntityRepository) {
        Intrinsics.checkNotNullParameter(transferAccountEntityRepository, "");
        String string = transferAccountEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getString("transfer_account_token");
        if (string == null) {
            string = "";
        }
        if (!(string.length() > 0)) {
            throw new IllegalStateException("Transfer account is not processing");
        }
        String string2 = transferAccountEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getString("transfer_account_status");
        return string2 == null ? "" : string2;
    }

    public static /* synthetic */ void getAuthRequestContext(TransferAccountEntityRepository transferAccountEntityRepository, TransferAccountStatusResult transferAccountStatusResult) {
        Intrinsics.checkNotNullParameter(transferAccountEntityRepository, "");
        transferAccountEntityRepository.PlaceComponentResult(transferAccountStatusResult.getStatus());
    }

    public static /* synthetic */ Boolean PlaceComponentResult(DeletionChangeNumberResult deletionChangeNumberResult) {
        Intrinsics.checkNotNullParameter(deletionChangeNumberResult, "");
        return Boolean.TRUE;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(TransferAccountEntityRepository transferAccountEntityRepository) {
        Intrinsics.checkNotNullParameter(transferAccountEntityRepository, "");
        transferAccountEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(final TransferAccountEntityRepository transferAccountEntityRepository, Long l) {
        Intrinsics.checkNotNullParameter(transferAccountEntityRepository, "");
        Intrinsics.checkNotNullParameter(l, "");
        final String str = transferAccountEntityRepository.getAuthRequestContext;
        TransferAccountQueryType transferAccountQueryType = TransferAccountQueryType.TOKEN;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(transferAccountQueryType, "");
        ObservableSource map = transferAccountEntityRepository.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(str, transferAccountQueryType).doOnNext(new Consumer() { // from class: id.dana.data.transferaccount.TransferAccountEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransferAccountEntityRepository.getAuthRequestContext(TransferAccountEntityRepository.this, (TransferAccountStatusResult) obj);
            }
        }).map(new Function() { // from class: id.dana.data.transferaccount.TransferAccountEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                TransferAccountStatus PlaceComponentResult;
                PlaceComponentResult = TransferAccountEntityRepository.PlaceComponentResult(str, (TransferAccountStatusResult) obj);
                return PlaceComponentResult;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(TransferAccountEntityRepository transferAccountEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(transferAccountEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str, "");
        transferAccountEntityRepository.PlaceComponentResult(StatusTransferAccount.INITIAL.getStatus());
        transferAccountEntityRepository.getAuthRequestContext = str;
    }
}
