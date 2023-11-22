package okio;

import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class Segment {
    final byte[] BuiltInFictitiousFunctionClassFactory;
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory;
    int PlaceComponentResult;
    Segment getAuthRequestContext;
    Segment lookAheadTest;
    boolean moveToNextValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment() {
        this.BuiltInFictitiousFunctionClassFactory = new byte[8192];
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.moveToNextValue = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.BuiltInFictitiousFunctionClassFactory = bArr;
        this.PlaceComponentResult = i;
        this.MyBillsEntityDataFactory = i2;
        this.moveToNextValue = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Segment KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Segment((byte[]) this.BuiltInFictitiousFunctionClassFactory.clone(), this.PlaceComponentResult, this.MyBillsEntityDataFactory, false, true);
    }

    @Nullable
    public final Segment MyBillsEntityDataFactory() {
        Segment segment = this.getAuthRequestContext;
        Segment segment2 = segment != this ? segment : null;
        Segment segment3 = this.lookAheadTest;
        segment3.getAuthRequestContext = segment;
        this.getAuthRequestContext.lookAheadTest = segment3;
        this.getAuthRequestContext = null;
        this.lookAheadTest = null;
        return segment2;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Segment segment, int i) {
        if (!segment.KClassImpl$Data$declaredNonStaticMembers$2) {
            throw new IllegalArgumentException();
        }
        int i2 = segment.MyBillsEntityDataFactory;
        int i3 = i2 + i;
        if (i3 > 8192) {
            if (segment.moveToNextValue) {
                throw new IllegalArgumentException();
            }
            int i4 = segment.PlaceComponentResult;
            if (i3 - i4 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment.BuiltInFictitiousFunctionClassFactory;
            System.arraycopy(bArr, i4, bArr, 0, i2 - i4);
            segment.MyBillsEntityDataFactory -= segment.PlaceComponentResult;
            segment.PlaceComponentResult = 0;
        }
        System.arraycopy(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, segment.BuiltInFictitiousFunctionClassFactory, segment.MyBillsEntityDataFactory, i);
        segment.MyBillsEntityDataFactory += i;
        this.PlaceComponentResult += i;
    }
}
