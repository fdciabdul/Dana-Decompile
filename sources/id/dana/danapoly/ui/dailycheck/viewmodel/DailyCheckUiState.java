package id.dana.danapoly.ui.dailycheck.viewmodel;

import id.dana.danapoly.ui.model.DailyCheckItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b"}, d2 = {"Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState;", "", "<init>", "()V", "None", "OnDoCheckInComplete", "OnGetCheckInHistoryError", "OnGetCheckInHistorySuccess", "Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState$None;", "Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState$OnGetCheckInHistorySuccess;", "Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState$OnGetCheckInHistoryError;", "Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState$OnDoCheckInComplete;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class DailyCheckUiState {
    public /* synthetic */ DailyCheckUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DailyCheckUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState$None;", "Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class None extends DailyCheckUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState$OnGetCheckInHistorySuccess;", "Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState;", "", "Lid/dana/danapoly/ui/model/DailyCheckItemModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnGetCheckInHistorySuccess extends DailyCheckUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final List<DailyCheckItemModel> BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnGetCheckInHistorySuccess(List<DailyCheckItemModel> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.BuiltInFictitiousFunctionClassFactory = list;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState$OnGetCheckInHistoryError;", "Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/Throwable;", "MyBillsEntityDataFactory", "p0", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnGetCheckInHistoryError extends DailyCheckUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final Throwable MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnGetCheckInHistoryError(Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            this.MyBillsEntityDataFactory = th;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState$OnDoCheckInComplete;", "Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState;", "", "PlaceComponentResult", "Z", "MyBillsEntityDataFactory", "()Z", "getAuthRequestContext", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnDoCheckInComplete extends DailyCheckUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final boolean getAuthRequestContext;

        public OnDoCheckInComplete(boolean z) {
            super(null);
            this.getAuthRequestContext = z;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }
    }
}
