package id.dana.domain.recentrecipient.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.recentrecipient.interactor.GetRecentTransaction;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/recentrecipient/interactor/GetRecentTransaction;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "Lid/dana/domain/recentrecipient/interactor/GetRecentTransaction$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/recentrecipient/interactor/GetRecentTransaction$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;", "recentRecipientRepository", "Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;", "<init>", "(Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetRecentTransaction extends BaseUseCase<List<? extends RecentRecipient>, Params> {
    private final RecentRecipientRepository recentRecipientRepository;

    @Inject
    public GetRecentTransaction(RecentRecipientRepository recentRecipientRepository) {
        Intrinsics.checkNotNullParameter(recentRecipientRepository, "");
        this.recentRecipientRepository = recentRecipientRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<RecentRecipient>> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable map = this.recentRecipientRepository.getRecentTransaction(params.getFilter()).map(new Function() { // from class: id.dana.domain.recentrecipient.interactor.GetRecentTransaction$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2447buildUseCase$lambda1;
                m2447buildUseCase$lambda1 = GetRecentTransaction.m2447buildUseCase$lambda1(GetRecentTransaction.Params.this, (List) obj);
                return m2447buildUseCase$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final List m2447buildUseCase$lambda1(Params params, List list) {
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (params.getRecipientType() != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                int type = ((RecentRecipient) obj).getType();
                Integer recipientType = params.getRecipientType();
                if (recipientType != null && type == recipientType.intValue()) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        return list;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001d\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/recentrecipient/interactor/GetRecentTransaction$Params;", "", "", "filter", "Ljava/lang/String;", "getFilter$domain_productionRelease", "()Ljava/lang/String;", "", "recipientType", "Ljava/lang/Integer;", "getRecipientType$domain_productionRelease", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String filter;
        private final Integer recipientType;

        public /* synthetic */ Params(String str, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, num);
        }

        @JvmStatic
        public static final Params forGetLastTransferDate(String str, Integer num) {
            return INSTANCE.forGetLastTransferDate(str, num);
        }

        @JvmStatic
        public static final Params forSearchRecentTransaction(String str) {
            return INSTANCE.forSearchRecentTransaction(str);
        }

        private Params(String str, Integer num) {
            this.filter = str;
            this.recipientType = num;
        }

        /* synthetic */ Params(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : num);
        }

        @JvmName(name = "getFilter$domain_productionRelease")
        /* renamed from: getFilter$domain_productionRelease  reason: from getter */
        public final String getFilter() {
            return this.filter;
        }

        @JvmName(name = "getRecipientType$domain_productionRelease")
        /* renamed from: getRecipientType$domain_productionRelease  reason: from getter */
        public final Integer getRecipientType() {
            return this.recipientType;
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/recentrecipient/interactor/GetRecentTransaction$Params$Companion;", "", "", "filter", "", "recipientType", "Lid/dana/domain/recentrecipient/interactor/GetRecentTransaction$Params;", "forGetLastTransferDate", "(Ljava/lang/String;Ljava/lang/Integer;)Lid/dana/domain/recentrecipient/interactor/GetRecentTransaction$Params;", "forSearchRecentTransaction", "(Ljava/lang/String;)Lid/dana/domain/recentrecipient/interactor/GetRecentTransaction$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ Params forSearchRecentTransaction$default(Companion companion, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = "";
                }
                return companion.forSearchRecentTransaction(str);
            }

            /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Integer] */
            @JvmStatic
            public final Params forSearchRecentTransaction(String filter) {
                Intrinsics.checkNotNullParameter(filter, "");
                ?? r1 = 0;
                return new Params(filter, r1, 2, r1);
            }

            @JvmStatic
            public final Params forGetLastTransferDate(String filter, Integer recipientType) {
                Intrinsics.checkNotNullParameter(filter, "");
                return new Params(filter, recipientType, null);
            }
        }
    }
}
