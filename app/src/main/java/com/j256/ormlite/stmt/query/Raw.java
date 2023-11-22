package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import id.dana.cashier.view.InputCardNumberView;
import java.util.List;

/* loaded from: classes8.dex */
public class Raw implements Clause {
    private final ArgumentHolder[] args;
    private final String statement;

    public Raw(String str, ArgumentHolder[] argumentHolderArr) {
        this.statement = str;
        this.args = argumentHolderArr;
    }

    @Override // com.j256.ormlite.stmt.query.Clause
    public void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List<ArgumentHolder> list) {
        sb.append(this.statement);
        sb.append(InputCardNumberView.DIVIDER);
        for (ArgumentHolder argumentHolder : this.args) {
            list.add(argumentHolder);
        }
    }
}
