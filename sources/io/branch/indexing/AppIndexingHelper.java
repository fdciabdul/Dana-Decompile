package io.branch.indexing;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.firebase.appindexing.Action;
import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.FirebaseUserActions;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.Indexables;
import io.branch.referral.BranchShortLinkBuilder;
import io.branch.referral.PrefHelper;
import io.branch.referral.util.LinkProperties;

/* loaded from: classes9.dex */
class AppIndexingHelper {
    private static FirebaseUserActions BuiltInFictitiousFunctionClassFactory;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {Ascii.EM, -104, -116, 103, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int MyBillsEntityDataFactory = 78;
    private static final LinkProperties getAuthRequestContext;

    AppIndexingHelper() {
    }

    static {
        LinkProperties linkProperties = new LinkProperties();
        linkProperties.BuiltInFictitiousFunctionClassFactory = "google_search";
        getAuthRequestContext = linkProperties;
    }

    /* renamed from: io.branch.indexing.AppIndexingHelper$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    static final class AnonymousClass1 implements Runnable {
        final /* synthetic */ BranchUniversalObject BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ Context MyBillsEntityDataFactory;
        final /* synthetic */ LinkProperties PlaceComponentResult;

        @Override // java.lang.Runnable
        public final void run() {
            String authRequestContext;
            try {
                FirebaseUserActions unused = AppIndexingHelper.BuiltInFictitiousFunctionClassFactory = FirebaseUserActions.getInstance();
            } catch (NoClassDefFoundError unused2) {
                PrefHelper.MyBillsEntityDataFactory("Firebase app indexing is not available. Please consider enabling Firebase app indexing for your app for better indexing experience with Google.");
            } catch (Throwable unused3) {
                PrefHelper.MyBillsEntityDataFactory("Failed to index your contents using Firebase. Please make sure Firebase  is enabled and initialised in your app");
            }
            LinkProperties linkProperties = this.PlaceComponentResult;
            if (linkProperties == null) {
                BranchUniversalObject branchUniversalObject = this.BuiltInFictitiousFunctionClassFactory;
                Context context = this.MyBillsEntityDataFactory;
                authRequestContext = branchUniversalObject.KClassImpl$Data$declaredNonStaticMembers$2(new BranchShortLinkBuilder(context), AppIndexingHelper.getAuthRequestContext).getAuthRequestContext();
            } else {
                authRequestContext = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(new BranchShortLinkBuilder(this.MyBillsEntityDataFactory), linkProperties).getAuthRequestContext();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Indexing BranchUniversalObject with Google using URL ");
            sb.append(authRequestContext);
            PrefHelper.MyBillsEntityDataFactory(sb.toString());
            if (TextUtils.isEmpty(authRequestContext)) {
                return;
            }
            try {
                if (AppIndexingHelper.BuiltInFictitiousFunctionClassFactory != null) {
                    AppIndexingHelper.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, this.BuiltInFictitiousFunctionClassFactory);
                } else {
                    AppIndexingHelper.MyBillsEntityDataFactory(authRequestContext, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
                }
            } catch (Throwable unused4) {
                PrefHelper.MyBillsEntityDataFactory("Warning: Unable to list your content in Google search. Please make sure you have added latest Firebase app indexing SDK to your project dependencies.");
            }
        }
    }

    /* renamed from: io.branch.indexing.AppIndexingHelper$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    static final class AnonymousClass2 implements Runnable {
        final /* synthetic */ LinkProperties BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ BranchUniversalObject MyBillsEntityDataFactory;
        final /* synthetic */ Context PlaceComponentResult;

        @Override // java.lang.Runnable
        public final void run() {
            String authRequestContext;
            try {
                LinkProperties linkProperties = this.BuiltInFictitiousFunctionClassFactory;
                if (linkProperties == null) {
                    authRequestContext = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(new BranchShortLinkBuilder(this.PlaceComponentResult), AppIndexingHelper.getAuthRequestContext).getAuthRequestContext();
                } else {
                    authRequestContext = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(new BranchShortLinkBuilder(this.PlaceComponentResult), linkProperties).getAuthRequestContext();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Removing indexed BranchUniversalObject with link ");
                sb.append(authRequestContext);
                PrefHelper.MyBillsEntityDataFactory(sb.toString());
                FirebaseAppIndex.getInstance().remove(new String[]{authRequestContext});
            } catch (NoClassDefFoundError unused) {
                PrefHelper.MyBillsEntityDataFactory("Failed to remove the BranchUniversalObject from Firebase local indexing. Please make sure Firebase is enabled and initialised in your app");
            } catch (Throwable unused2) {
                PrefHelper.MyBillsEntityDataFactory("Failed to index your contents using Firebase. Please make sure Firebase is enabled and initialised in your app");
            }
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str, BranchUniversalObject branchUniversalObject) {
        StringBuilder sb = new StringBuilder();
        sb.append(branchUniversalObject.lookAheadTest);
        sb.append("\n");
        sb.append(branchUniversalObject.getAuthRequestContext);
        String obj = sb.toString();
        if (branchUniversalObject.PlaceComponentResult()) {
            FirebaseAppIndex.getInstance().update(new Indexable[]{Indexables.newSimple(obj, str)});
        }
        BuiltInFictitiousFunctionClassFactory.end(new Action.Builder("ViewAction").setObject(obj, str).setMetadata(new Action.Metadata.Builder().setUpload(branchUniversalObject.KClassImpl$Data$declaredNonStaticMembers$2())).build());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0127  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x01ad -> B:11:0x01ba). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void MyBillsEntityDataFactory(java.lang.String r21, android.content.Context r22, io.branch.indexing.BranchUniversalObject r23) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.indexing.AppIndexingHelper.MyBillsEntityDataFactory(java.lang.String, android.content.Context, io.branch.indexing.BranchUniversalObject):void");
    }
}
