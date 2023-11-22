package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import id.dana.cashier.view.InputCardNumberView;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes8.dex */
public class Not implements Clause, NeedsFutureClause {
    private Comparison comparison = null;
    private Exists exists = null;

    public Not() {
    }

    public Not(Clause clause) {
        setMissingClause(clause);
    }

    @Override // com.j256.ormlite.stmt.query.NeedsFutureClause
    public void setMissingClause(Clause clause) {
        if (this.comparison != null) {
            throw new IllegalArgumentException("NOT operation already has a comparison set");
        }
        if (clause instanceof Comparison) {
            this.comparison = (Comparison) clause;
        } else if (clause instanceof Exists) {
            this.exists = (Exists) clause;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("NOT operation can only work with comparison SQL clauses, not ");
            sb.append(clause);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Override // com.j256.ormlite.stmt.query.Clause
    public void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        Comparison comparison = this.comparison;
        if (comparison == null && this.exists == null) {
            throw new IllegalStateException("Clause has not been set in NOT operation");
        }
        if (comparison == null) {
            sb.append("(NOT ");
            this.exists.appendSql(databaseType, str, sb, list);
        } else {
            sb.append("(NOT ");
            if (str != null) {
                databaseType.appendEscapedEntityName(sb, str);
                sb.append('.');
            }
            databaseType.appendEscapedEntityName(sb, this.comparison.getColumnName());
            sb.append(InputCardNumberView.DIVIDER);
            this.comparison.appendOperation(sb);
            this.comparison.appendValue(databaseType, sb, list);
        }
        sb.append(") ");
    }

    public String toString() {
        if (this.comparison == null) {
            return "NOT without comparison";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("NOT comparison ");
        sb.append(this.comparison);
        return sb.toString();
    }
}
