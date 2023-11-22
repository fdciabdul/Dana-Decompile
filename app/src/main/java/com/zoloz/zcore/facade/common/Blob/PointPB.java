package com.zoloz.zcore.facade.common.Blob;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;

/* loaded from: classes2.dex */
public final class PointPB extends Message {
    public static final Float DEFAULT_X;
    public static final Float DEFAULT_Y;
    public static final int TAG_X = 1;
    public static final int TAG_Y = 2;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public Integer x;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public Integer y;

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
    }

    public PointPB(PointPB pointPB) {
        super(pointPB);
        if (pointPB == null) {
            return;
        }
        this.x = pointPB.x;
        this.y = pointPB.y;
    }

    public PointPB() {
    }

    public final PointPB fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.x = (Integer) obj;
        } else if (i == 2) {
            this.y = (Integer) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PointPB) {
            PointPB pointPB = (PointPB) obj;
            return equals(this.x, pointPB.x) && equals(this.y, pointPB.y);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.x;
            int hashCode = num != null ? num.hashCode() : 0;
            Integer num2 = this.y;
            int hashCode2 = (hashCode * 37) + (num2 != null ? num2.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i;
    }
}
