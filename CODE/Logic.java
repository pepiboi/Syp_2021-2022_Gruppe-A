public class Logic{

    private Interest selectedInterest;
    private Document selectedDocument;

    public void addInterest(String interestName){
        // Database.add(new Interest(interestName));
    }

    public void removeInterest(Interest interest){
        // Database.remove(interest);
    }

    public Interest getSelectedInterest(){
        return selectedInterest;
    }

    public Document getSelectedDocument(){
        return selectedDocument;
    }
}