package j$.util.stream;

/* loaded from: classes.dex */
abstract class AbstractSpinedBuffer {
    protected int KClassImpl$Data$declaredNonStaticMembers$2;
    protected final int MyBillsEntityDataFactory;
    protected long[] PlaceComponentResult;
    protected int getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractSpinedBuffer() {
        this.MyBillsEntityDataFactory = 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractSpinedBuffer(int i) {
        if (i >= 0) {
            this.MyBillsEntityDataFactory = Math.max(4, 32 - Integer.numberOfLeadingZeros(i - 1));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal Capacity: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public final long s_() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return i == 0 ? this.getAuthRequestContext : this.PlaceComponentResult[i] + this.getAuthRequestContext;
    }

    public abstract void t_();
}
