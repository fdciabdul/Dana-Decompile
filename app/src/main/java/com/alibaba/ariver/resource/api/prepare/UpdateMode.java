package com.alibaba.ariver.resource.api.prepare;

/* loaded from: classes3.dex */
public enum UpdateMode {
    SYNC_FORCE(2),
    SYNC_TRY(1),
    ASYNC(0);

    public int value;

    UpdateMode(int i) {
        this.value = i;
    }

    public static UpdateMode fromString(String str) {
        str.hashCode();
        if (str.equals("synctry")) {
            return SYNC_TRY;
        }
        if (str.equals("syncforce")) {
            return SYNC_FORCE;
        }
        return ASYNC;
    }

    /* renamed from: com.alibaba.ariver.resource.api.prepare.UpdateMode$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$resource$api$prepare$UpdateMode;

        static {
            int[] iArr = new int[UpdateMode.values().length];
            $SwitchMap$com$alibaba$ariver$resource$api$prepare$UpdateMode = iArr;
            try {
                iArr[UpdateMode.SYNC_FORCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$resource$api$prepare$UpdateMode[UpdateMode.SYNC_TRY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$resource$api$prepare$UpdateMode[UpdateMode.ASYNC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public final String toReqMode() {
        int i = AnonymousClass1.$SwitchMap$com$alibaba$ariver$resource$api$prepare$UpdateMode[ordinal()];
        return i != 1 ? i != 2 ? "async" : "synctry" : "syncforce";
    }

    public final boolean isSync() {
        return this.value > 0;
    }
}
