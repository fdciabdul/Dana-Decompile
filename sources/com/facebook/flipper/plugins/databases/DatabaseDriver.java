package com.facebook.flipper.plugins.databases;

import com.facebook.flipper.plugins.databases.DatabaseDescriptor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\u00020\u0003:\u0004\u0004\u0005\u0006\u0007"}, d2 = {"Lcom/facebook/flipper/plugins/databases/DatabaseDriver;", "Lcom/facebook/flipper/plugins/databases/DatabaseDescriptor;", "DESCRIPTOR", "", "DatabaseExecuteSqlResponse", "DatabaseGetTableDataResponse", "DatabaseGetTableInfoResponse", "DatabaseGetTableStructureResponse"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public abstract class DatabaseDriver<DESCRIPTOR extends DatabaseDescriptor> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003"}, d2 = {"Lcom/facebook/flipper/plugins/databases/DatabaseDriver$DatabaseExecuteSqlResponse;", "", "Companion", "Type"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes2.dex */
    public static final class DatabaseExecuteSqlResponse {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u001b\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000"}, d2 = {"Lcom/facebook/flipper/plugins/databases/DatabaseDriver$DatabaseExecuteSqlResponse$Type;", ""}, k = 1, mv = {1, 4, 2})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        /* loaded from: classes2.dex */
        public @interface Type {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0018\u00002\u00020\u0001"}, d2 = {"Lcom/facebook/flipper/plugins/databases/DatabaseDriver$DatabaseGetTableDataResponse;", ""}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes7.dex */
    public static final class DatabaseGetTableDataResponse {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0018\u00002\u00020\u0001"}, d2 = {"Lcom/facebook/flipper/plugins/databases/DatabaseDriver$DatabaseGetTableInfoResponse;", ""}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes7.dex */
    public static final class DatabaseGetTableInfoResponse {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0018\u00002\u00020\u0001"}, d2 = {"Lcom/facebook/flipper/plugins/databases/DatabaseDriver$DatabaseGetTableStructureResponse;", ""}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes7.dex */
    public static final class DatabaseGetTableStructureResponse {
    }
}
