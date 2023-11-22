package id.dana.danapoly.ui.enums;

import id.dana.domain.payasset.model.PayMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\bj\u0002\b\tj\u0002\b\n"}, d2 = {"Lid/dana/danapoly/ui/enums/CardFilterUiType;", "", "", "", "getStatusBasedOnFilterType", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;I)V", PayMethod.ALL, "IN_PROGRESS", "DONE"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public enum CardFilterUiType {
    ALL,
    IN_PROGRESS,
    DONE;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[CardFilterUiType.values().length];
            iArr[CardFilterUiType.IN_PROGRESS.ordinal()] = 1;
            iArr[CardFilterUiType.DONE.ordinal()] = 2;
            BuiltInFictitiousFunctionClassFactory = iArr;
        }
    }

    public final List<String> getStatusBasedOnFilterType() {
        int i = WhenMappings.BuiltInFictitiousFunctionClassFactory[ordinal()];
        if (i != 1) {
            if (i == 2) {
                return CollectionsKt.listOf((Object[]) new String[]{"DONE", "EXPIRED"});
            }
            return CollectionsKt.emptyList();
        }
        return CollectionsKt.listOf("PENDING");
    }
}
