public class AdminSicht extends BaseActivity{

    private Logic logic;

    public AdminSicht(Logic logic){
        this.logic = logic;
    }

    public void onPlusInterestButtonClick(View view){
        AlertDialog.Builder alert = AlertDialog.Builder(this);
        alert.setTitle("Creating Interest...");
        alert.setMessage("Type in the name of the interest!");
        EditText nameField = new EditText();
        alert.setPositiveButton("finish", (dialog, which) -> {
            logic.addInterest(nameField.getText().toString());
        });
        alert.setNegativButton("cancel");
        alert.show();
    }

    public void onEditInterestButtonClick(View view){
        Interest selectedInterest = logic.getSelectedInterest();
        AlertDialog.Builder alert = AlertDialog.Builder(this);
        alert.setTitle("Editing Interest...");
        alert.setMessage("Type in the new name of the interest!");
        EditText nameField = new EditText();
        alert.setPositiveButton("finish", (dialog, which) -> {
            selectedInterest.setName(nameField.getText().toString());
        });
        alert.setNegativButton("cancel");
        alert.show();
    }

    public void onDeleteInterestButtonClick(View view){
        Interest selectedInterest = logic.getSelectedInterest();
        AlertDialog.Builder alert = AlertDialog.Builder(this);
        alert.setTitle("Removing Interest...");
        alert.setMessage("Do you really want to remove the interest?");
        EditText nameField = new EditText();
        alert.setPositiveButton("finish", (dialog, which) -> {
            logic.removeInterest(selectedInterest);
        });
        alert.setNegativButton("cancel");
        alert.show();
    }

    public void onPlusDocumentButtonClick(View view){
        Interest selectedInterest = logic.getSelectedInterest();
        AlertDialog.Builder alert = AlertDialog.Builder(this);
        alert.setTitle("Creating Document...");
        alert.setMessage("Upload a document!");
        EditText pathField = new EditText();
        alert.setPositiveButton("finish", (dialog, which) -> {
            selectedInterest.addDocument(pathField.getText().toString());
        });
        alert.setNegativButton("cancel");
        alert.show();
    }

    public void onEditDocumentButtonClick(View view){
        Interest selectedInterest = logic.getSelectedInterest();
        Document selectedDocument = logic.getSelectedDocument();
        AlertDialog.Builder alert = AlertDialog.Builder(this);
        alert.setTitle("Editing Document...");
        alert.setMessage("Type in the new name of the document!");
        EditText nameField = new EditText();
        alert.setPositiveButton("finish", (dialog, which) -> {
            selectedDocument.setName(nameField.getText().toString());
        });
        alert.setNegativButton("cancel");
        alert.show();
    }

    public void onRemoveDocumentButtonClick(View view){
        Interest selectedInterest = logic.getSelectedInterest();
        Document selectedDocument = logic.getSelectedDocument();
        AlertDialog.Builder alert = AlertDialog.Builder(this);
        alert.setTitle("Removing Document...");
        alert.setMessage("Do you really want to remove the document?");
        EditText nameField = new EditText();
        alert.setPositiveButton("finish", (dialog, which) -> {
            selectedInterest.removeDocument(selectedDocument);
        });
        alert.setNegativButton("cancel");
        alert.show();
    }

    public void onUserViewButtonClick(View view){
        Intent intent = new Intent(this, UserSicht.class);
        startActivity(intent);
    }

    public void onAdminViewButtonClick(View view){
        Intent intent = new Intent(this, AdminSicht.class);
        startActivity(intent);
    }
}