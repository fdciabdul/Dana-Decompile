package id.dana.danapoly.ui.cards.viewmodel;

import id.dana.danapoly.ui.model.CardItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState;", "", "<init>", "()V", "None", "OnCardDetailListEmpty", "OnCardDetailListError", "OnCardDetailListLoaded", "OnCardDetailLoading", "OnCardPaginationError", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState$None;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState$OnCardDetailListLoaded;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState$OnCardDetailListError;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState$OnCardDetailLoading;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState$OnCardDetailListEmpty;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState$OnCardPaginationError;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class DanapolyCardsDetailUiState {
    public /* synthetic */ DanapolyCardsDetailUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DanapolyCardsDetailUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState$None;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class None extends DanapolyCardsDetailUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState$OnCardDetailListLoaded;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState;", "", "Lid/dana/danapoly/ui/model/CardItemModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "", "getAuthRequestContext", "Z", "()Z", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnCardDetailListLoaded extends DanapolyCardsDetailUiState {
        public final List<CardItemModel> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnCardDetailListLoaded(List<CardItemModel> list, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState$OnCardDetailListError;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState;", "", "getAuthRequestContext", "Ljava/lang/Throwable;", "PlaceComponentResult", "p0", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnCardDetailListError extends DanapolyCardsDetailUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final Throwable PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnCardDetailListError(Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            this.PlaceComponentResult = th;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState$OnCardDetailLoading;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnCardDetailLoading extends DanapolyCardsDetailUiState {
        public static final OnCardDetailLoading INSTANCE = new OnCardDetailLoading();

        private OnCardDetailLoading() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState$OnCardDetailListEmpty;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnCardDetailListEmpty extends DanapolyCardsDetailUiState {
        public static final OnCardDetailListEmpty INSTANCE = new OnCardDetailListEmpty();

        private OnCardDetailListEmpty() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState$OnCardPaginationError;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnCardPaginationError extends DanapolyCardsDetailUiState {
        public static final OnCardPaginationError INSTANCE = new OnCardPaginationError();

        private OnCardPaginationError() {
            super(null);
        }
    }
}
