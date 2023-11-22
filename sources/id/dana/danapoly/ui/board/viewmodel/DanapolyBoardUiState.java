package id.dana.danapoly.ui.board.viewmodel;

import id.dana.danapoly.ui.model.BackgroundColorType;
import id.dana.danapoly.ui.model.PlayBoardModel;
import id.dana.danapoly.ui.model.PlayerInfoModel;
import id.dana.danapoly.ui.model.play.RollDiceModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u000e\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000e\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "", "<init>", "()V", "DanapolyBoardLoading", "None", "OnCheckInHistoryFetched", "OnCheckShownTutorial", "OnConfigurationError", "OnConfigurationLoaded", "OnEventNotExist", "OnGetLastBackgroundColor", "OnPlayerInfoError", "OnPlayerInfoLoaded", "OutOfDiceError", "RollDiceError", "RollDiceLoading", "RollDiceSuccess", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$None;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnConfigurationLoaded;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnEventNotExist;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnConfigurationError;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnPlayerInfoLoaded;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnPlayerInfoError;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$DanapolyBoardLoading;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$RollDiceLoading;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$RollDiceSuccess;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$RollDiceError;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OutOfDiceError;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnGetLastBackgroundColor;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnCheckShownTutorial;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnCheckInHistoryFetched;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class DanapolyBoardUiState {

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$DanapolyBoardLoading;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class DanapolyBoardLoading extends DanapolyBoardUiState {
    }

    public /* synthetic */ DanapolyBoardUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DanapolyBoardUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$None;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class None extends DanapolyBoardUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\t\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnConfigurationLoaded;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "", "MyBillsEntityDataFactory", "Z", "PlaceComponentResult", "()Z", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/danapoly/ui/model/PlayBoardModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/ui/model/PlayBoardModel;", "p0", "p1", "<init>", "(Lid/dana/danapoly/ui/model/PlayBoardModel;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnConfigurationLoaded extends DanapolyBoardUiState {
        public final PlayBoardModel KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnConfigurationLoaded(PlayBoardModel playBoardModel, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(playBoardModel, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = playBoardModel;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnEventNotExist;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnEventNotExist extends DanapolyBoardUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnEventNotExist(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.getAuthRequestContext = str;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnConfigurationError;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnConfigurationError extends DanapolyBoardUiState {
        public static final OnConfigurationError INSTANCE = new OnConfigurationError();

        private OnConfigurationError() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnPlayerInfoLoaded;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "Lid/dana/danapoly/ui/model/PlayerInfoModel;", "getAuthRequestContext", "Lid/dana/danapoly/ui/model/PlayerInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/danapoly/ui/model/PlayerInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnPlayerInfoLoaded extends DanapolyBoardUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final PlayerInfoModel KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPlayerInfoLoaded(PlayerInfoModel playerInfoModel) {
            super(null);
            Intrinsics.checkNotNullParameter(playerInfoModel, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = playerInfoModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnPlayerInfoError;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Throwable;", "MyBillsEntityDataFactory", "p0", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnPlayerInfoError extends DanapolyBoardUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final Throwable MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPlayerInfoError(Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            this.MyBillsEntityDataFactory = th;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$RollDiceLoading;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "", "MyBillsEntityDataFactory", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "PlaceComponentResult", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class RollDiceLoading extends DanapolyBoardUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final boolean PlaceComponentResult;

        public RollDiceLoading(boolean z) {
            super(null);
            this.PlaceComponentResult = z;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$RollDiceSuccess;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/ui/model/play/RollDiceModel;", "Lid/dana/danapoly/ui/model/play/RollDiceModel;", "MyBillsEntityDataFactory", "", "I", "getAuthRequestContext", "PlaceComponentResult", "Ljava/lang/Integer;", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/danapoly/ui/model/play/RollDiceModel;ZILjava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class RollDiceSuccess extends DanapolyBoardUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final RollDiceModel MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final int getAuthRequestContext;
        public final Integer PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RollDiceSuccess(RollDiceModel rollDiceModel, boolean z, int i, Integer num) {
            super(null);
            Intrinsics.checkNotNullParameter(rollDiceModel, "");
            this.MyBillsEntityDataFactory = rollDiceModel;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.getAuthRequestContext = i;
            this.PlaceComponentResult = num;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$RollDiceError;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "", "MyBillsEntityDataFactory", "Ljava/lang/Throwable;", "p0", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class RollDiceError extends DanapolyBoardUiState {
        public final Throwable MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RollDiceError(Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            this.MyBillsEntityDataFactory = th;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OutOfDiceError;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OutOfDiceError extends DanapolyBoardUiState {
        public static final OutOfDiceError INSTANCE = new OutOfDiceError();

        private OutOfDiceError() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnGetLastBackgroundColor;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "Lid/dana/danapoly/ui/model/BackgroundColorType;", "PlaceComponentResult", "Lid/dana/danapoly/ui/model/BackgroundColorType;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/danapoly/ui/model/BackgroundColorType;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnGetLastBackgroundColor extends DanapolyBoardUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final BackgroundColorType KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnGetLastBackgroundColor(BackgroundColorType backgroundColorType) {
            super(null);
            Intrinsics.checkNotNullParameter(backgroundColorType, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = backgroundColorType;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnCheckShownTutorial;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "()Z", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnCheckShownTutorial extends DanapolyBoardUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;

        public OnCheckShownTutorial() {
            this(false, 1, null);
        }

        public OnCheckShownTutorial(boolean z) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        public /* synthetic */ OnCheckShownTutorial(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState$OnCheckInHistoryFetched;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "()Z", "getAuthRequestContext", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnCheckInHistoryFetched extends DanapolyBoardUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final boolean getAuthRequestContext;

        public OnCheckInHistoryFetched(boolean z) {
            super(null);
            this.getAuthRequestContext = z;
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }
    }
}
