package id.dana.danapoly.ui.splash.viewmodel;

import id.dana.danapoly.ui.model.PlayBoardModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r"}, d2 = {"Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState;", "", "<init>", "()V", "DanapolyLoading", "None", "OnErrorLoadConfiguration", "OnEventNotExist", "OnSuccessLoadConfiguration", "Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState$None;", "Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState$DanapolyLoading;", "Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState$OnSuccessLoadConfiguration;", "Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState$OnEventNotExist;", "Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState$OnErrorLoadConfiguration;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class DanapolyConfigUiState {
    public /* synthetic */ DanapolyConfigUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DanapolyConfigUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState$None;", "Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class None extends DanapolyConfigUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState$DanapolyLoading;", "Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DanapolyLoading extends DanapolyConfigUiState {
        public final boolean BuiltInFictitiousFunctionClassFactory;

        public DanapolyLoading(boolean z) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState$OnSuccessLoadConfiguration;", "Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "Lid/dana/danapoly/ui/model/PlayBoardModel;", "MyBillsEntityDataFactory", "Lid/dana/danapoly/ui/model/PlayBoardModel;", "PlaceComponentResult", "p0", "p1", "<init>", "(Ljava/lang/String;Lid/dana/danapoly/ui/model/PlayBoardModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnSuccessLoadConfiguration extends DanapolyConfigUiState {
        public final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final PlayBoardModel PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessLoadConfiguration(String str, PlayBoardModel playBoardModel) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(playBoardModel, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.PlaceComponentResult = playBoardModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState$OnEventNotExist;", "Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnEventNotExist extends DanapolyConfigUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnEventNotExist(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.getAuthRequestContext = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState$OnErrorLoadConfiguration;", "Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Throwable;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnErrorLoadConfiguration extends DanapolyConfigUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final Throwable KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnErrorLoadConfiguration(Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = th;
        }
    }
}
