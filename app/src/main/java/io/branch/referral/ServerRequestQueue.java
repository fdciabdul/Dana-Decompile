package io.branch.referral;

import android.content.Context;
import android.content.SharedPreferences;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.ServerRequest;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ServerRequestQueue {
    private static ServerRequestQueue BuiltInFictitiousFunctionClassFactory;
    private static final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();
    private final List<ServerRequest> MyBillsEntityDataFactory;
    private SharedPreferences PlaceComponentResult;
    private SharedPreferences.Editor getAuthRequestContext;

    public static ServerRequestQueue BuiltInFictitiousFunctionClassFactory(Context context) {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            synchronized (ServerRequestQueue.class) {
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    BuiltInFictitiousFunctionClassFactory = new ServerRequestQueue(context);
                }
            }
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    private ServerRequestQueue(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("BNC_Server_Request_Queue", 0);
        this.PlaceComponentResult = sharedPreferences;
        this.getAuthRequestContext = sharedPreferences.edit();
        this.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2(context);
    }

    /* renamed from: io.branch.referral.ServerRequestQueue$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
            ServerRequestQueue.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject NetworkUserEntityData$$ExternalSyntheticLambda2;
            JSONArray jSONArray = new JSONArray();
            synchronized (ServerRequestQueue.KClassImpl$Data$declaredNonStaticMembers$2) {
                for (ServerRequest serverRequest : ServerRequestQueue.this.MyBillsEntityDataFactory) {
                    if (serverRequest.scheduleImpl() && (NetworkUserEntityData$$ExternalSyntheticLambda2 = serverRequest.NetworkUserEntityData$$ExternalSyntheticLambda2()) != null) {
                        jSONArray.put(NetworkUserEntityData$$ExternalSyntheticLambda2);
                    }
                }
            }
            try {
                ServerRequestQueue.this.getAuthRequestContext.putString("BNCServerRequestQueue", jSONArray.toString()).commit();
            } catch (Exception e) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to persit queue");
                if (message == null) {
                    message = "";
                }
                sb.append(message);
                PrefHelper.MyBillsEntityDataFactory(sb.toString());
            }
        }
    }

    private List<ServerRequest> KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        String string = this.PlaceComponentResult.getString("BNCServerRequestQueue", null);
        List<ServerRequest> synchronizedList = Collections.synchronizedList(new LinkedList());
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            if (string != null) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    int min = Math.min(jSONArray.length(), 25);
                    for (int i = 0; i < min; i++) {
                        ServerRequest BuiltInFictitiousFunctionClassFactory2 = ServerRequest.BuiltInFictitiousFunctionClassFactory(jSONArray.getJSONObject(i), context);
                        if (BuiltInFictitiousFunctionClassFactory2 != null) {
                            synchronizedList.add(BuiltInFictitiousFunctionClassFactory2);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        }
        return synchronizedList;
    }

    public final int lookAheadTest() {
        int size;
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            size = this.MyBillsEntityDataFactory.size();
        }
        return size;
    }

    public final void MyBillsEntityDataFactory(ServerRequest serverRequest) {
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            if (serverRequest != null) {
                this.MyBillsEntityDataFactory.add(serverRequest);
                if (lookAheadTest() >= 25) {
                    this.MyBillsEntityDataFactory.remove(1);
                }
                new Thread(new AnonymousClass1()).start();
            }
        }
    }

    public final ServerRequest MyBillsEntityDataFactory() {
        ServerRequest serverRequest;
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            try {
                serverRequest = this.MyBillsEntityDataFactory.remove(0);
                try {
                    new Thread(new AnonymousClass1()).start();
                } catch (IndexOutOfBoundsException | NoSuchElementException unused) {
                }
            } catch (IndexOutOfBoundsException | NoSuchElementException unused2) {
                serverRequest = null;
            }
        }
        return serverRequest;
    }

    public final ServerRequest NetworkUserEntityData$$ExternalSyntheticLambda0() {
        ServerRequest serverRequest;
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            try {
                serverRequest = this.MyBillsEntityDataFactory.get(0);
            } catch (IndexOutOfBoundsException | NoSuchElementException unused) {
                serverRequest = null;
            }
        }
        return serverRequest;
    }

    public final ServerRequest getAuthRequestContext(int i) {
        ServerRequest serverRequest;
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            try {
                serverRequest = this.MyBillsEntityDataFactory.get(i);
            } catch (IndexOutOfBoundsException | NoSuchElementException unused) {
                serverRequest = null;
            }
        }
        return serverRequest;
    }

    public final void MyBillsEntityDataFactory(ServerRequest serverRequest, int i) {
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            try {
                if (this.MyBillsEntityDataFactory.size() < i) {
                    i = this.MyBillsEntityDataFactory.size();
                }
                this.MyBillsEntityDataFactory.add(i, serverRequest);
                new Thread(new AnonymousClass1()).start();
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(ServerRequest serverRequest) {
        boolean z;
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            try {
                z = this.MyBillsEntityDataFactory.remove(serverRequest);
                try {
                    new Thread(new AnonymousClass1()).start();
                } catch (UnsupportedOperationException unused) {
                }
            } catch (UnsupportedOperationException unused2) {
                z = false;
            }
        }
        return z;
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            try {
                this.MyBillsEntityDataFactory.clear();
                new Thread(new AnonymousClass1()).start();
            } catch (UnsupportedOperationException unused) {
            }
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            for (ServerRequest serverRequest : this.MyBillsEntityDataFactory) {
                if (serverRequest != null && serverRequest.NetworkUserEntityData$$ExternalSyntheticLambda0.equals(Defines.RequestPath.RegisterClose.getPath())) {
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean getAuthRequestContext() {
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            for (ServerRequest serverRequest : this.MyBillsEntityDataFactory) {
                if (serverRequest != null && ((serverRequest instanceof ServerRequestRegisterInstall) || (serverRequest instanceof ServerRequestRegisterOpen))) {
                    return true;
                }
            }
            return false;
        }
    }

    public final void getAuthRequestContext(ServerRequest serverRequest, int i) {
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            Iterator<ServerRequest> it = this.MyBillsEntityDataFactory.iterator();
            while (it.hasNext()) {
                ServerRequest next = it.next();
                if (next != null && ((next instanceof ServerRequestRegisterInstall) || (next instanceof ServerRequestRegisterOpen))) {
                    it.remove();
                    break;
                }
            }
        }
        MyBillsEntityDataFactory(serverRequest, i == 0 ? 0 : 1);
    }

    public final void PlaceComponentResult(Branch.BranchReferralInitListener branchReferralInitListener) {
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            for (ServerRequest serverRequest : this.MyBillsEntityDataFactory) {
                if (serverRequest != null) {
                    if (serverRequest instanceof ServerRequestRegisterInstall) {
                        ServerRequestRegisterInstall serverRequestRegisterInstall = (ServerRequestRegisterInstall) serverRequest;
                        if (branchReferralInitListener != null) {
                            serverRequestRegisterInstall.getErrorConfigVersion = branchReferralInitListener;
                        }
                    } else if (serverRequest instanceof ServerRequestRegisterOpen) {
                        ServerRequestRegisterOpen serverRequestRegisterOpen = (ServerRequestRegisterOpen) serverRequest;
                        if (branchReferralInitListener != null) {
                            serverRequestRegisterOpen.scheduleImpl = branchReferralInitListener;
                        }
                    }
                }
            }
        }
    }

    public final void MyBillsEntityDataFactory(ServerRequest.PROCESS_WAIT_LOCK process_wait_lock) {
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            for (ServerRequest serverRequest : this.MyBillsEntityDataFactory) {
                if (serverRequest != null) {
                    serverRequest.getAuthRequestContext.remove(process_wait_lock);
                }
            }
        }
    }

    public final void scheduleImpl() {
        ServerRequest.PROCESS_WAIT_LOCK process_wait_lock;
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            for (ServerRequest serverRequest : this.MyBillsEntityDataFactory) {
                if (serverRequest != null && (serverRequest instanceof ServerRequestInitSession) && (process_wait_lock = ServerRequest.PROCESS_WAIT_LOCK.STRONG_MATCH_PENDING_WAIT_LOCK) != null) {
                    serverRequest.getAuthRequestContext.add(process_wait_lock);
                }
            }
        }
    }
}
