package com.otaliastudios.cameraview.video.encoding;

/* loaded from: classes8.dex */
public class AudioConfig {
    public String PlaceComponentResult;
    public int getAuthRequestContext;
    public int MyBillsEntityDataFactory = 1;
    public String getErrorConfigVersion = "audio/mp4a-latm";
    public int NetworkUserEntityData$$ExternalSyntheticLambda0 = 44100;
    final int BuiltInFictitiousFunctionClassFactory = 2;
    final int lookAheadTest = 2;
    final int KClassImpl$Data$declaredNonStaticMembers$2 = 88200;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int KClassImpl$Data$declaredNonStaticMembers$2() {
        return 500;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAuthRequestContext() {
        return 50;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int BuiltInFictitiousFunctionClassFactory() {
        int i = this.MyBillsEntityDataFactory;
        if (i == 1) {
            return 16;
        }
        if (i == 2) {
            return 12;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid number of channels: ");
        sb.append(this.MyBillsEntityDataFactory);
        throw new RuntimeException(sb.toString());
    }
}
