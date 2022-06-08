package com.zy.actinium.study.multi.thread.programming.sync.syncblock;

/**
 * @author Neo
 */
public class SyncBlockTaskWithoutThis {

    private String usernameValue;
    private String passwordValue;
    private String anyString = new String();

    public void setValue(String username, String password) {
        //String anyString = new String();
        synchronized (anyString) {
            try {
                System.out.println(Thread.currentThread().getName() + " come in synchronized block at -- "
                        + System.currentTimeMillis());
                usernameValue = username;
                Thread.sleep(3000);
                passwordValue = password;
                System.out.println(Thread.currentThread().getName() + " come out synchronized block at -- "
                        + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
