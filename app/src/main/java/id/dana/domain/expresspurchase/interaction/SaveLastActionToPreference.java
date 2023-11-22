package id.dana.domain.expresspurchase.interaction;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchaseAction;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/SaveLastActionToPreference;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/expresspurchase/interaction/SaveLastActionToPreference$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/expresspurchase/interaction/SaveLastActionToPreference$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "expressPurchaseRepository", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "<init>", "(Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;)V", "Companion", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveLastActionToPreference extends BaseUseCase<Boolean, Param> {
    public static final String DISMISS_EP = "dismiss";
    private final ExpressPurchaseRepository expressPurchaseRepository;

    @Inject
    public SaveLastActionToPreference(ExpressPurchaseRepository expressPurchaseRepository) {
        Intrinsics.checkNotNullParameter(expressPurchaseRepository, "");
        this.expressPurchaseRepository = expressPurchaseRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        if (Intrinsics.areEqual(params.getAction(), ExpressPurchaseAction.DISMISS.name())) {
            return this.expressPurchaseRepository.saveLastOfferCancelTransaction(params.getAddonId(), params.getType());
        }
        return this.expressPurchaseRepository.saveLastOfferSucceedTransaction(params.getAddonId());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/SaveLastActionToPreference$Param;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "addonId", "action", "type", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/expresspurchase/interaction/SaveLastActionToPreference$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAction", "getAddonId", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final String action;
        private final String addonId;
        private final String type;

        public static /* synthetic */ Param copy$default(Param param, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = param.addonId;
            }
            if ((i & 2) != 0) {
                str2 = param.action;
            }
            if ((i & 4) != 0) {
                str3 = param.type;
            }
            return param.copy(str, str2, str3);
        }

        /* renamed from: component1  reason: from getter */
        public final String getAddonId() {
            return this.addonId;
        }

        /* renamed from: component2  reason: from getter */
        public final String getAction() {
            return this.action;
        }

        /* renamed from: component3  reason: from getter */
        public final String getType() {
            return this.type;
        }

        public final Param copy(String addonId, String action, String type) {
            Intrinsics.checkNotNullParameter(addonId, "");
            Intrinsics.checkNotNullParameter(action, "");
            Intrinsics.checkNotNullParameter(type, "");
            return new Param(addonId, action, type);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return Intrinsics.areEqual(this.addonId, param.addonId) && Intrinsics.areEqual(this.action, param.action) && Intrinsics.areEqual(this.type, param.type);
            }
            return false;
        }

        public final int hashCode() {
            return (((this.addonId.hashCode() * 31) + this.action.hashCode()) * 31) + this.type.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(addonId=");
            sb.append(this.addonId);
            sb.append(", action=");
            sb.append(this.action);
            sb.append(", type=");
            sb.append(this.type);
            sb.append(')');
            return sb.toString();
        }

        public Param(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.addonId = str;
            this.action = str2;
            this.type = str3;
        }

        @JvmName(name = "getAddonId")
        public final String getAddonId() {
            return this.addonId;
        }

        @JvmName(name = "getAction")
        public final String getAction() {
            return this.action;
        }

        @JvmName(name = "getType")
        public final String getType() {
            return this.type;
        }
    }
}
