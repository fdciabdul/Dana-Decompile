package j$.util;

/* loaded from: classes.dex */
public final class OptionalLong {
    private static final OptionalLong MyBillsEntityDataFactory = new OptionalLong();
    final boolean PlaceComponentResult;
    final long getAuthRequestContext;

    private OptionalLong() {
        this.PlaceComponentResult = false;
        this.getAuthRequestContext = 0L;
    }

    private OptionalLong(long j) {
        this.PlaceComponentResult = true;
        this.getAuthRequestContext = j;
    }

    public static OptionalLong PlaceComponentResult(long j) {
        return new OptionalLong(j);
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OptionalLong) {
            OptionalLong optionalLong = (OptionalLong) obj;
            boolean z = this.PlaceComponentResult;
            if (z && optionalLong.PlaceComponentResult) {
                if (this.getAuthRequestContext == optionalLong.getAuthRequestContext) {
                    return true;
                }
            } else if (z == optionalLong.PlaceComponentResult) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        if (this.PlaceComponentResult) {
            long j = this.getAuthRequestContext;
            return (int) (j ^ (j >>> 32));
        }
        return 0;
    }

    public final String toString() {
        return this.PlaceComponentResult ? String.format("OptionalLong[%s]", Long.valueOf(this.getAuthRequestContext)) : "OptionalLong.empty";
    }
}
