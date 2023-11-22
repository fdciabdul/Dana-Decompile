package id.dana.danapoly.ui.cards.viewmodel;

import id.dana.danapoly.ui.enums.RewardType;
import id.dana.danapoly.ui.model.CardListWrapperModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState;", "", "<init>", "()V", "None", "OnCardListEmpty", "OnCardListError", "OnInitialCardListLoaded", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState$None;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState$OnInitialCardListLoaded;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState$OnCardListError;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState$OnCardListEmpty;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class DanapolyCardsUiState {
    public /* synthetic */ DanapolyCardsUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DanapolyCardsUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState$None;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class None extends DanapolyCardsUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002¢\u0006\u0004\b\t\u0010\nR#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState$OnInitialCardListLoaded;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState;", "", "Lkotlin/Pair;", "Lid/dana/danapoly/ui/enums/RewardType;", "Lid/dana/danapoly/ui/model/CardListWrapperModel;", "getAuthRequestContext", "Ljava/util/List;", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnInitialCardListLoaded extends DanapolyCardsUiState {
        public final List<Pair<RewardType, CardListWrapperModel>> getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public OnInitialCardListLoaded(List<? extends Pair<? extends RewardType, CardListWrapperModel>> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.getAuthRequestContext = list;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState$OnCardListError;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState;", "", "getAuthRequestContext", "Ljava/lang/Throwable;", "PlaceComponentResult", "p0", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnCardListError extends DanapolyCardsUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final Throwable PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnCardListError(Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            this.PlaceComponentResult = th;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState$OnCardListEmpty;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnCardListEmpty extends DanapolyCardsUiState {
        public static final OnCardListEmpty INSTANCE = new OnCardListEmpty();

        private OnCardListEmpty() {
            super(null);
        }
    }
}
