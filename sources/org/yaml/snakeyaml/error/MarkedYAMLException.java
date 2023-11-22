package org.yaml.snakeyaml.error;

/* loaded from: classes6.dex */
public class MarkedYAMLException extends YAMLException {
    private static final long serialVersionUID = -9119388488683035101L;
    private final String context;
    private final Mark contextMark;
    private final String note;
    private final String problem;
    private final Mark problemMark;

    public MarkedYAMLException(String str, Mark mark, String str2, Mark mark2, String str3) {
        this(str, mark, str2, mark2, str3, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MarkedYAMLException(java.lang.String r3, org.yaml.snakeyaml.error.Mark r4, java.lang.String r5, org.yaml.snakeyaml.error.Mark r6, java.lang.String r7, java.lang.Throwable r8) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r1 = "; "
            r0.append(r1)
            r0.append(r5)
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0, r8)
            r2.context = r3
            r2.contextMark = r4
            r2.problem = r5
            r2.problemMark = r6
            r2.note = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.error.MarkedYAMLException.<init>(java.lang.String, org.yaml.snakeyaml.error.Mark, java.lang.String, org.yaml.snakeyaml.error.Mark, java.lang.String, java.lang.Throwable):void");
    }

    public MarkedYAMLException(String str, Mark mark, String str2, Mark mark2) {
        this(str, mark, str2, mark2, null, null);
    }

    public MarkedYAMLException(String str, Mark mark, String str2, Mark mark2, Throwable th) {
        this(str, mark, str2, mark2, null, th);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.context;
        if (str != null) {
            sb.append(str);
            sb.append("\n");
        }
        Mark mark = this.contextMark;
        if (mark != null && (this.problem == null || this.problemMark == null || mark.getName().equals(this.problemMark.getName()) || this.contextMark.getLine() != this.problemMark.getLine() || this.contextMark.getColumn() != this.problemMark.getColumn())) {
            sb.append(this.contextMark);
            sb.append("\n");
        }
        String str2 = this.problem;
        if (str2 != null) {
            sb.append(str2);
            sb.append("\n");
        }
        Mark mark2 = this.problemMark;
        if (mark2 != null) {
            sb.append(mark2);
            sb.append("\n");
        }
        String str3 = this.note;
        if (str3 != null) {
            sb.append(str3);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getContext() {
        return this.context;
    }

    public Mark getContextMark() {
        return this.contextMark;
    }

    public String getProblem() {
        return this.problem;
    }

    public Mark getProblemMark() {
        return this.problemMark;
    }
}
