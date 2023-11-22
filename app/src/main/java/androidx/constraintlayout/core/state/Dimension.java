package androidx.constraintlayout.core.state;

/* loaded from: classes6.dex */
public class Dimension {
    private final int GetContactSyncConfig;
    float NetworkUserEntityData$$ExternalSyntheticLambda1;
    String NetworkUserEntityData$$ExternalSyntheticLambda2;
    boolean getErrorConfigVersion;
    int initRecordTimeStamp;
    int lookAheadTest;
    Object moveToNextValue;
    int scheduleImpl;
    public static final Object getAuthRequestContext = new Object();
    public static final Object NetworkUserEntityData$$ExternalSyntheticLambda0 = new Object();
    public static final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();
    public static final Object MyBillsEntityDataFactory = new Object();
    public static final Object PlaceComponentResult = new Object();
    public static final Object BuiltInFictitiousFunctionClassFactory = new Object();

    /* loaded from: classes6.dex */
    public enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    private Dimension() {
        this.GetContactSyncConfig = -2;
        this.lookAheadTest = 0;
        this.scheduleImpl = Integer.MAX_VALUE;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 1.0f;
        this.initRecordTimeStamp = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        this.moveToNextValue = NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.getErrorConfigVersion = false;
    }

    private Dimension(Object obj) {
        this.GetContactSyncConfig = -2;
        this.lookAheadTest = 0;
        this.scheduleImpl = Integer.MAX_VALUE;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 1.0f;
        this.initRecordTimeStamp = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        this.getErrorConfigVersion = false;
        this.moveToNextValue = obj;
    }

    public static Dimension PlaceComponentResult(Object obj) {
        Dimension dimension = new Dimension(getAuthRequestContext);
        dimension.moveToNextValue = obj;
        if (obj instanceof Integer) {
            dimension.initRecordTimeStamp = ((Integer) obj).intValue();
            dimension.moveToNextValue = null;
        }
        return dimension;
    }
}
