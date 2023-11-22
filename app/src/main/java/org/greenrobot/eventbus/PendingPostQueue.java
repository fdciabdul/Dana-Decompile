package org.greenrobot.eventbus;

/* loaded from: classes6.dex */
final class PendingPostQueue {
    private PendingPost head;
    private PendingPost tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void enqueue(PendingPost pendingPost) {
        synchronized (this) {
            if (pendingPost == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            PendingPost pendingPost2 = this.tail;
            if (pendingPost2 != null) {
                pendingPost2.next = pendingPost;
                this.tail = pendingPost;
            } else if (this.head == null) {
                this.tail = pendingPost;
                this.head = pendingPost;
            } else {
                throw new IllegalStateException("Head present, but no tail");
            }
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PendingPost poll() {
        PendingPost pendingPost;
        synchronized (this) {
            pendingPost = this.head;
            if (pendingPost != null) {
                PendingPost pendingPost2 = pendingPost.next;
                this.head = pendingPost2;
                if (pendingPost2 == null) {
                    this.tail = null;
                }
            }
        }
        return pendingPost;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PendingPost poll(int i) throws InterruptedException {
        PendingPost poll;
        synchronized (this) {
            if (this.head == null) {
                wait(i);
            }
            poll = poll();
        }
        return poll;
    }
}
