package id.dana.notification;

import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.notification.TransactionDetailNotificationBus;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u0006\u001a\u00020\n2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bH\u0007¢\u0006\u0004\b\u0006\u0010\u000bR\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\r"}, d2 = {"Lid/dana/notification/TransactionDetailNotificationBus;", "", "", "", "p0", "", "PlaceComponentResult", "(Ljava/util/Map;)V", "Lkotlin/Function1;", "Lid/dana/notification/TransactionDetailNotificationBus$TransactionDetailInfo;", "Lio/reactivex/disposables/Disposable;", "(Lkotlin/jvm/functions/Function1;)Lio/reactivex/disposables/Disposable;", "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Lazy;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V", "TransactionDetailInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransactionDetailNotificationBus {
    public static final TransactionDetailNotificationBus INSTANCE = new TransactionDetailNotificationBus();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<PublishSubject<TransactionDetailInfo>>() { // from class: id.dana.notification.TransactionDetailNotificationBus$transactionDetailNotifier$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PublishSubject<TransactionDetailNotificationBus.TransactionDetailInfo> invoke() {
            return PublishSubject.PlaceComponentResult();
        }
    });

    private TransactionDetailNotificationBus() {
    }

    @JvmStatic
    public static final void PlaceComponentResult(Map<String, String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p0.get(ShareToFeedBridge.REDIRECT_VALUE);
        String str2 = p0.get("contentType");
        Object value = BuiltInFictitiousFunctionClassFactory.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        ((PublishSubject) value).onNext(new TransactionDetailInfo(str, str2));
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\r"}, d2 = {"Lid/dana/notification/TransactionDetailNotificationBus$TransactionDetailInfo;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final /* data */ class TransactionDetailInfo {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof TransactionDetailInfo) {
                TransactionDetailInfo transactionDetailInfo = (TransactionDetailInfo) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, transactionDetailInfo.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, transactionDetailInfo.getAuthRequestContext);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.BuiltInFictitiousFunctionClassFactory;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.getAuthRequestContext;
            return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TransactionDetailInfo(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        public TransactionDetailInfo(String str, String str2) {
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.getAuthRequestContext = str2;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(Function1 function1, TransactionDetailInfo transactionDetailInfo) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullExpressionValue(transactionDetailInfo, "");
        function1.invoke(transactionDetailInfo);
    }

    @JvmStatic
    public static final Disposable PlaceComponentResult(final Function1<? super TransactionDetailInfo, Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Object value = BuiltInFictitiousFunctionClassFactory.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        Disposable subscribe = ((PublishSubject) value).subscribe(new Consumer() { // from class: id.dana.notification.TransactionDetailNotificationBus$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransactionDetailNotificationBus.getAuthRequestContext(Function1.this, (TransactionDetailNotificationBus.TransactionDetailInfo) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        return subscribe;
    }
}
