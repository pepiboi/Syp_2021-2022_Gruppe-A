public class Loading{
    public static void startLoadingScreen(Context context, String loadingName, Runnable worker){
        ProgessDialog dialog = new ProgressDialog(this, "Loading...", true, false);
        new Thread(() -> {
            worker.run();
            dialog.dismiss();
        }).start();
    }
}