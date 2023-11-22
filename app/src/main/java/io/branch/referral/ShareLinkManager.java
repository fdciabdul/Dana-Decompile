package io.branch.referral;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import io.branch.referral.Branch;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ShareLinkManager {
    private static int lookAheadTest = 100;
    private static int moveToNextValue = 2;
    private List<ResolveInfo> DatabaseTableConfigUtil;
    private Branch.ShareLinkBuilder GetContactSyncConfig;
    Branch.BranchLinkShareListener KClassImpl$Data$declaredNonStaticMembers$2;
    Branch.IChannelProperties MyBillsEntityDataFactory;
    Context getAuthRequestContext;
    private Intent isLayoutRequested;
    AnimatedDialog scheduleImpl;
    private final int getErrorConfigVersion = Color.argb(60, 17, 4, 56);
    private final int NetworkUserEntityData$$ExternalSyntheticLambda0 = Color.argb(20, 17, 4, 56);
    private boolean newProxyInstance = false;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8 = -1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1 = 50;
    final int BuiltInFictitiousFunctionClassFactory = 5;
    final int PlaceComponentResult = 100;
    private List<String> NetworkUserEntityData$$ExternalSyntheticLambda2 = new ArrayList();
    private List<String> initRecordTimeStamp = new ArrayList();

    ShareLinkManager() {
    }

    static /* synthetic */ Branch.ShareLinkBuilder BuiltInFictitiousFunctionClassFactory(ShareLinkManager shareLinkManager) {
        shareLinkManager.GetContactSyncConfig = null;
        return null;
    }

    static /* synthetic */ boolean NetworkUserEntityData$$ExternalSyntheticLambda0(ShareLinkManager shareLinkManager) {
        shareLinkManager.newProxyInstance = false;
        return false;
    }

    public final void PlaceComponentResult(boolean z) {
        AnimatedDialog animatedDialog = this.scheduleImpl;
        if (animatedDialog == null || !animatedDialog.isShowing()) {
            return;
        }
        if (z) {
            this.scheduleImpl.cancel();
        } else {
            this.scheduleImpl.dismiss();
        }
    }

    /* renamed from: io.branch.referral.ShareLinkManager$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements AdapterView.OnItemClickListener {
        final /* synthetic */ ShareLinkManager BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ ChooserArrayAdapter MyBillsEntityDataFactory;
        final /* synthetic */ List PlaceComponentResult;
        final /* synthetic */ ListView getAuthRequestContext;

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (view.getTag() instanceof MoreShareItem) {
                this.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil = this.PlaceComponentResult;
                this.MyBillsEntityDataFactory.notifyDataSetChanged();
                return;
            }
            if (this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                String charSequence = (view.getTag() == null || this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext == null || ((ResolveInfo) view.getTag()).loadLabel(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.getPackageManager()) == null) ? "" : ((ResolveInfo) view.getTag()).loadLabel(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.getPackageManager()).toString();
                this.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(((ResolveInfo) view.getTag()).loadLabel(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.getPackageManager()).toString());
                this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(charSequence);
            }
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = i - this.getAuthRequestContext.getHeaderViewsCount();
            this.MyBillsEntityDataFactory.notifyDataSetChanged();
            ShareLinkManager.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, (ResolveInfo) view.getTag());
            if (this.BuiltInFictitiousFunctionClassFactory.scheduleImpl != null) {
                this.BuiltInFictitiousFunctionClassFactory.scheduleImpl.cancel();
            }
        }
    }

    /* renamed from: io.branch.referral.ShareLinkManager$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass2 implements DialogInterface.OnDismissListener {
        final /* synthetic */ ShareLinkManager PlaceComponentResult;

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                Branch.BranchLinkShareListener branchLinkShareListener = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }
            if (!this.PlaceComponentResult.newProxyInstance) {
                this.PlaceComponentResult.getAuthRequestContext = null;
                ShareLinkManager.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
            }
            this.PlaceComponentResult.scheduleImpl = null;
        }
    }

    /* loaded from: classes9.dex */
    class ChooserArrayAdapter extends BaseAdapter {
        public int BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ ShareLinkManager MyBillsEntityDataFactory;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.MyBillsEntityDataFactory.DatabaseTableConfigUtil.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.MyBillsEntityDataFactory.DatabaseTableConfigUtil.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ShareItemView shareItemView;
            if (view == null) {
                ShareLinkManager shareLinkManager = this.MyBillsEntityDataFactory;
                shareItemView = new ShareItemView(shareLinkManager.getAuthRequestContext);
            } else {
                shareItemView = (ShareItemView) view;
            }
            ResolveInfo resolveInfo = (ResolveInfo) this.MyBillsEntityDataFactory.DatabaseTableConfigUtil.get(i);
            shareItemView.setLabel(resolveInfo.loadLabel(this.MyBillsEntityDataFactory.getAuthRequestContext.getPackageManager()).toString(), resolveInfo.loadIcon(this.MyBillsEntityDataFactory.getAuthRequestContext.getPackageManager()), i == this.BuiltInFictitiousFunctionClassFactory);
            shareItemView.setTag(resolveInfo);
            shareItemView.setClickable(false);
            return shareItemView;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return this.BuiltInFictitiousFunctionClassFactory < 0;
        }
    }

    /* loaded from: classes9.dex */
    class ShareItemView extends TextView {
        Context BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;

        public ShareItemView(Context context) {
            super(context);
            this.BuiltInFictitiousFunctionClassFactory = context;
            setPadding(100, 5, 5, 5);
            setGravity(8388627);
            setMinWidth(this.BuiltInFictitiousFunctionClassFactory.getResources().getDisplayMetrics().widthPixels);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ShareLinkManager.this.NetworkUserEntityData$$ExternalSyntheticLambda1 != 0 ? Math.round(ShareLinkManager.this.NetworkUserEntityData$$ExternalSyntheticLambda1 * (context.getResources().getDisplayMetrics().xdpi / 160.0f)) : 0;
        }

        public void setLabel(String str, Drawable drawable, boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("\t");
            sb.append(str);
            setText(sb.toString());
            setTag(str);
            if (drawable == null) {
                setTextAppearance(this.BuiltInFictitiousFunctionClassFactory, 16973890);
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (i != 0) {
                    drawable.setBounds(0, 0, i, i);
                    setCompoundDrawables(drawable, null, null, null);
                } else {
                    setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                setTextAppearance(this.BuiltInFictitiousFunctionClassFactory, 16973892);
                int unused = ShareLinkManager.lookAheadTest = Math.max(ShareLinkManager.lookAheadTest, (drawable.getCurrent().getBounds().centerY() * ShareLinkManager.moveToNextValue) + 5);
            }
            setMinHeight(ShareLinkManager.lookAheadTest);
            setTextColor(this.BuiltInFictitiousFunctionClassFactory.getResources().getColor(17170444));
            if (z) {
                setBackgroundColor(ShareLinkManager.this.getErrorConfigVersion);
            } else {
                setBackgroundColor(ShareLinkManager.this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
        }
    }

    /* loaded from: classes9.dex */
    class MoreShareItem extends ResolveInfo {
        final /* synthetic */ ShareLinkManager getAuthRequestContext;

        @Override // android.content.pm.ResolveInfo
        public CharSequence loadLabel(PackageManager packageManager) {
            return this.getAuthRequestContext.GetContactSyncConfig.getAuthRequestContext;
        }

        @Override // android.content.pm.ResolveInfo
        public Drawable loadIcon(PackageManager packageManager) {
            return this.getAuthRequestContext.GetContactSyncConfig.MyBillsEntityDataFactory;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class CopyLinkItem extends ResolveInfo {
        final /* synthetic */ ShareLinkManager BuiltInFictitiousFunctionClassFactory;

        @Override // android.content.pm.ResolveInfo
        public CharSequence loadLabel(PackageManager packageManager) {
            return this.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // android.content.pm.ResolveInfo
        public Drawable loadIcon(PackageManager packageManager) {
            return this.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory;
        }
    }

    static /* synthetic */ void getAuthRequestContext(ShareLinkManager shareLinkManager, final ResolveInfo resolveInfo) {
        shareLinkManager.newProxyInstance = true;
        final String charSequence = resolveInfo.loadLabel(shareLinkManager.getAuthRequestContext.getPackageManager()).toString();
        shareLinkManager.GetContactSyncConfig.moveToNextValue.MyBillsEntityDataFactory(new Branch.BranchLinkCreateListener() { // from class: io.branch.referral.ShareLinkManager.3
            @Override // io.branch.referral.Branch.BranchLinkCreateListener
            public void onLinkCreate(String str, BranchError branchError) {
                if (branchError != null) {
                    String str2 = ShareLinkManager.this.GetContactSyncConfig.PlaceComponentResult;
                    if (str2 != null && str2.trim().length() > 0) {
                        ShareLinkManager.PlaceComponentResult(ShareLinkManager.this, resolveInfo, str2, charSequence);
                        return;
                    }
                    if (ShareLinkManager.this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                        ShareLinkManager.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(str, charSequence, branchError);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unable to share link ");
                        sb.append(branchError.BuiltInFictitiousFunctionClassFactory);
                        PrefHelper.MyBillsEntityDataFactory(sb.toString());
                    }
                    if (branchError.MyBillsEntityDataFactory != -113 && branchError.MyBillsEntityDataFactory != -117) {
                        ShareLinkManager.this.PlaceComponentResult(false);
                        ShareLinkManager.NetworkUserEntityData$$ExternalSyntheticLambda0(ShareLinkManager.this);
                        return;
                    }
                }
                ShareLinkManager.PlaceComponentResult(ShareLinkManager.this, resolveInfo, str, charSequence);
            }
        });
    }

    static /* synthetic */ void PlaceComponentResult(ShareLinkManager shareLinkManager, ResolveInfo resolveInfo, String str, String str2) {
        Branch.BranchLinkShareListener branchLinkShareListener = shareLinkManager.KClassImpl$Data$declaredNonStaticMembers$2;
        if (branchLinkShareListener != null) {
            branchLinkShareListener.MyBillsEntityDataFactory(str, str2, null);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Shared link with ");
            sb.append(str2);
            PrefHelper.MyBillsEntityDataFactory(sb.toString());
        }
        if (!(resolveInfo instanceof CopyLinkItem)) {
            shareLinkManager.isLayoutRequested.setPackage(resolveInfo.activityInfo.packageName);
            String str3 = shareLinkManager.GetContactSyncConfig.lookAheadTest;
            String str4 = shareLinkManager.GetContactSyncConfig.getErrorConfigVersion;
            Branch.IChannelProperties iChannelProperties = shareLinkManager.MyBillsEntityDataFactory;
            if (iChannelProperties != null) {
                String authRequestContext = iChannelProperties.getAuthRequestContext();
                String MyBillsEntityDataFactory = shareLinkManager.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
                if (!TextUtils.isEmpty(authRequestContext)) {
                    str3 = authRequestContext;
                }
                if (!TextUtils.isEmpty(MyBillsEntityDataFactory)) {
                    str4 = MyBillsEntityDataFactory;
                }
            }
            if (str3 != null && str3.trim().length() > 0) {
                shareLinkManager.isLayoutRequested.putExtra("android.intent.extra.SUBJECT", str3);
            }
            Intent intent = shareLinkManager.isLayoutRequested;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str4);
            sb2.append("\n");
            sb2.append(str);
            intent.putExtra("android.intent.extra.TEXT", sb2.toString());
            shareLinkManager.getAuthRequestContext.startActivity(shareLinkManager.isLayoutRequested);
            return;
        }
        String str5 = shareLinkManager.GetContactSyncConfig.getErrorConfigVersion;
        if (Build.VERSION.SDK_INT < 11) {
            ((ClipboardManager) shareLinkManager.getAuthRequestContext.getSystemService("clipboard")).setText(str);
        } else {
            ((android.content.ClipboardManager) shareLinkManager.getAuthRequestContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str5, str));
        }
        Toast.makeText(shareLinkManager.getAuthRequestContext, shareLinkManager.GetContactSyncConfig.scheduleImpl, 0).show();
    }
}
