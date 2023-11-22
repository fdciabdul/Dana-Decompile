package id.dana.domain.wallet_v3.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/wallet_v3/model/WalletConfig;", "", "", "featureWalletNew", "Z", "getFeatureWalletNew", "()Z", "Lid/dana/domain/wallet_v3/model/WalletV3Config;", "walletV3", "Lid/dana/domain/wallet_v3/model/WalletV3Config;", "getWalletV3", "()Lid/dana/domain/wallet_v3/model/WalletV3Config;", "<init>", "(ZLid/dana/domain/wallet_v3/model/WalletV3Config;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WalletConfig {
    public boolean featureWalletNew;
    public WalletV3Config walletV3;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.domain.wallet_v3.model.WalletV3Config] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public WalletConfig() {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            r2 = 3
            r3.<init>(r1, r0, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.wallet_v3.model.WalletConfig.<init>():void");
    }

    public WalletConfig(boolean z, WalletV3Config walletV3Config) {
        Intrinsics.checkNotNullParameter(walletV3Config, "");
        this.featureWalletNew = z;
        this.walletV3 = walletV3Config;
    }

    @JvmName(name = "getFeatureWalletNew")
    public final boolean getFeatureWalletNew() {
        return this.featureWalletNew;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ WalletConfig(boolean r22, id.dana.domain.wallet_v3.model.WalletV3Config r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r21 = this;
            r0 = r24 & 1
            if (r0 == 0) goto L6
            r0 = 0
            goto L8
        L6:
            r0 = r22
        L8:
            r1 = r24 & 2
            if (r1 == 0) goto L2d
            id.dana.domain.wallet_v3.model.WalletV3Config r1 = new id.dana.domain.wallet_v3.model.WalletV3Config
            r2 = r1
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 65535(0xffff, float:9.1834E-41)
            r20 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r2 = r21
            goto L31
        L2d:
            r2 = r21
            r1 = r23
        L31:
            r2.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.wallet_v3.model.WalletConfig.<init>(boolean, id.dana.domain.wallet_v3.model.WalletV3Config, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getWalletV3")
    public final WalletV3Config getWalletV3() {
        return this.walletV3;
    }
}
