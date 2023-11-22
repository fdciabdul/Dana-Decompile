package androidx.constraintlayout.core.parser;

/* loaded from: classes6.dex */
public class CLParsingException extends Exception {
    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;

    public CLParsingException(String str, CLElement cLElement) {
        this.mReason = str;
        if (cLElement == null) {
            this.mElementClass = "unknown";
            this.mLineNumber = 0;
            return;
        }
        String obj = cLElement.getClass().toString();
        this.mElementClass = obj.substring(obj.lastIndexOf(46) + 1);
        this.mLineNumber = cLElement.PlaceComponentResult;
    }

    public String reason() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mReason);
        sb.append(" (");
        sb.append(this.mElementClass);
        sb.append(" at line ");
        sb.append(this.mLineNumber);
        sb.append(")");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CLParsingException (");
        sb.append(hashCode());
        sb.append(") : ");
        sb.append(reason());
        return sb.toString();
    }
}
