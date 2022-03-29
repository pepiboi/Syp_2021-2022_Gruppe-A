public class UserSicht extends BaseActivity{

    private Logic logic;
    
    public AdminSicht(Logic logic){
        this.logic = logic;
    }
    
    public void onDownloadDocumentButtonClick(View view){
        Document selectedDocument = logic.selectedDocument();
        Loading.startLoadingScreen(this, "Downloading...", () -> {
            // Download document...
        });
    }
}