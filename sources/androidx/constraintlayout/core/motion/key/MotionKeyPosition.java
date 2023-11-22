package androidx.constraintlayout.core.motion.key;

/* loaded from: classes6.dex */
public class MotionKeyPosition extends MotionKey {
    public int scheduleImpl = MyBillsEntityDataFactory;
    public String newProxyInstance = null;
    public int NetworkUserEntityData$$ExternalSyntheticLambda2 = MyBillsEntityDataFactory;
    public int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    public float initRecordTimeStamp = Float.NaN;
    public float NetworkUserEntityData$$ExternalSyntheticLambda1 = Float.NaN;
    public float GetContactSyncConfig = Float.NaN;
    public float DatabaseTableConfigUtil = Float.NaN;
    public float getErrorConfigVersion = Float.NaN;
    public float moveToNextValue = Float.NaN;
    public int isLayoutRequested = 0;
    private float PrepareContext = Float.NaN;
    private float NetworkUserEntityData$$ExternalSyntheticLambda7 = Float.NaN;

    public MotionKeyPosition() {
        this.lookAheadTest = 2;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public final MotionKey PlaceComponentResult(MotionKey motionKey) {
        super.PlaceComponentResult(motionKey);
        MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
        this.newProxyInstance = motionKeyPosition.newProxyInstance;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = motionKeyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = motionKeyPosition.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.initRecordTimeStamp = motionKeyPosition.initRecordTimeStamp;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = Float.NaN;
        this.GetContactSyncConfig = motionKeyPosition.GetContactSyncConfig;
        this.DatabaseTableConfigUtil = motionKeyPosition.DatabaseTableConfigUtil;
        this.getErrorConfigVersion = motionKeyPosition.getErrorConfigVersion;
        this.moveToNextValue = motionKeyPosition.moveToNextValue;
        this.PrepareContext = motionKeyPosition.PrepareContext;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = motionKeyPosition.NetworkUserEntityData$$ExternalSyntheticLambda7;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: MyBillsEntityDataFactory */
    public final MotionKey clone() {
        return new MotionKeyPosition().PlaceComponentResult(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new MotionKeyPosition().PlaceComponentResult(this);
    }
}
