package id.dana.domain.expresspurchase.interaction.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\f\u0010\rB\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/AddonOffer;", "", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo;", "addonInfo", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo;", "getAddonInfo", "()Lid/dana/domain/expresspurchase/interaction/model/AddonInfo;", "", "hasOffer", "Z", "getHasOffer", "()Z", "<init>", "()V", "(Lid/dana/domain/expresspurchase/interaction/model/AddonInfo;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddonOffer {
    private final AddonInfo addonInfo;
    private final boolean hasOffer;

    public AddonOffer(AddonInfo addonInfo, boolean z) {
        this.addonInfo = addonInfo;
        this.hasOffer = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AddonOffer(id.dana.domain.expresspurchase.interaction.model.AddonInfo r1, boolean r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L5
            r1 = 0
        L5:
            r3 = r3 & 2
            if (r3 == 0) goto Le
            if (r1 == 0) goto Ld
            r2 = 1
            goto Le
        Ld:
            r2 = 0
        Le:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.expresspurchase.interaction.model.AddonOffer.<init>(id.dana.domain.expresspurchase.interaction.model.AddonInfo, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getAddonInfo")
    public final AddonInfo getAddonInfo() {
        return this.addonInfo;
    }

    @JvmName(name = "getHasOffer")
    public final boolean getHasOffer() {
        return this.hasOffer;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.domain.expresspurchase.interaction.model.AddonInfo] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AddonOffer() {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            r3.<init>(r0, r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.expresspurchase.interaction.model.AddonOffer.<init>():void");
    }
}
