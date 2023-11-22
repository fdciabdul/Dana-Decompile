package id.dana.sendmoney.ui.globalsend.form.viewmodel;

import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CountryModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationUiState;", "", "<init>", "()V", "Error", "None", "OnSuccessGetCountryList", "ShimmerLoading", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationUiState$None;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationUiState$ShimmerLoading;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationUiState$Error;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationUiState$OnSuccessGetCountryList;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class SelectCountryDestinationUiState {
    public /* synthetic */ SelectCountryDestinationUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SelectCountryDestinationUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationUiState$None;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends SelectCountryDestinationUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationUiState$ShimmerLoading;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationUiState;", "", "PlaceComponentResult", "Z", "getAuthRequestContext", "()Z", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ShimmerLoading extends SelectCountryDestinationUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;

        public ShimmerLoading(boolean z) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationUiState$Error;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationUiState;", "", "BuiltInFictitiousFunctionClassFactory", "I", "getAuthRequestContext", "p0", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Error extends SelectCountryDestinationUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final int getAuthRequestContext;

        public Error() {
            this(0, 1, null);
        }

        private Error(int i) {
            super(null);
            this.getAuthRequestContext = i;
        }

        public /* synthetic */ Error(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? R.string.SchedulerPoolFactory : i);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationUiState$OnSuccessGetCountryList;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationUiState;", "", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;", "PlaceComponentResult", "Ljava/util/List;", "getAuthRequestContext", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetCountryList extends SelectCountryDestinationUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final List<CountryModel> getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetCountryList(List<CountryModel> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.getAuthRequestContext = list;
        }
    }
}
