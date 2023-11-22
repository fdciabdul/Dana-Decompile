package io.split.android.client.shared;

/* loaded from: classes6.dex */
public enum UserConsent {
    GRANTED,
    DECLINED,
    UNKNOWN;

    /* renamed from: io.split.android.client.shared.UserConsent$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$shared$UserConsent;

        static {
            int[] iArr = new int[UserConsent.values().length];
            $SwitchMap$io$split$android$client$shared$UserConsent = iArr;
            try {
                iArr[UserConsent.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$shared$UserConsent[UserConsent.GRANTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$shared$UserConsent[UserConsent.DECLINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public final int intValue() {
        int i = AnonymousClass1.$SwitchMap$io$split$android$client$shared$UserConsent[ordinal()];
        if (i != 1) {
            if (i != 2) {
                return i != 3 ? 0 : 3;
            }
            return 2;
        }
        return 1;
    }
}
