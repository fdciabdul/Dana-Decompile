package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.FloatRect;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class MotionKeyTrigger extends MotionKey {
    private float PrepareContext;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    private String DatabaseTableConfigUtil = null;
    private int NetworkUserEntityData$$ExternalSyntheticLambda4 = MyBillsEntityDataFactory;
    private String isLayoutRequested = null;
    private String NetworkUserEntityData$$ExternalSyntheticLambda5 = null;
    private int NetworkUserEntityData$$ExternalSyntheticLambda6 = MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda3 = MyBillsEntityDataFactory;
    float getErrorConfigVersion = 0.1f;
    private boolean initRecordTimeStamp = true;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
    private boolean newProxyInstance = true;
    private float NetworkUserEntityData$$ExternalSyntheticLambda7 = Float.NaN;
    private boolean FragmentBottomSheetPaymentSettingBinding = false;
    int GetContactSyncConfig = MyBillsEntityDataFactory;
    int NetworkUserEntityData$$ExternalSyntheticLambda1 = MyBillsEntityDataFactory;
    int NetworkUserEntityData$$ExternalSyntheticLambda0 = MyBillsEntityDataFactory;
    FloatRect scheduleImpl = new FloatRect();
    FloatRect moveToNextValue = new FloatRect();

    public MotionKeyTrigger() {
        this.lookAheadTest = 5;
        this.getAuthRequestContext = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public MotionKeyTrigger PlaceComponentResult(MotionKey motionKey) {
        super.PlaceComponentResult(motionKey);
        MotionKeyTrigger motionKeyTrigger = (MotionKeyTrigger) motionKey;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = motionKeyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda2;
        this.DatabaseTableConfigUtil = motionKeyTrigger.DatabaseTableConfigUtil;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = motionKeyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda4;
        this.isLayoutRequested = motionKeyTrigger.isLayoutRequested;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = motionKeyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = motionKeyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = motionKeyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda3;
        this.getErrorConfigVersion = motionKeyTrigger.getErrorConfigVersion;
        this.initRecordTimeStamp = motionKeyTrigger.initRecordTimeStamp;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = motionKeyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda8;
        this.newProxyInstance = motionKeyTrigger.newProxyInstance;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = motionKeyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda7;
        this.PrepareContext = motionKeyTrigger.PrepareContext;
        this.FragmentBottomSheetPaymentSettingBinding = motionKeyTrigger.FragmentBottomSheetPaymentSettingBinding;
        this.scheduleImpl = motionKeyTrigger.scheduleImpl;
        this.moveToNextValue = motionKeyTrigger.moveToNextValue;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: MyBillsEntityDataFactory */
    public final MotionKey clone() {
        return new MotionKeyTrigger().PlaceComponentResult(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new MotionKeyTrigger().PlaceComponentResult(this);
    }
}
