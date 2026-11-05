package org.example;

public class GitCommit {
    private String hash;
    private String branch;
    private String message;
    private boolean isMerge;
    private String author;

    public GitCommit(String hash, String branch, String message, boolean isMerge, String author) {
        this.hash = hash;
        this.branch = branch;
        this.message = message;
        this.isMerge = isMerge;
        this.author = author;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isMerge() {
        return isMerge;
    }

    public void setMerge(boolean merge) {
        isMerge = merge;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayInfo() {
        if (isMerge) {
            System.out.printf("*   commit %s (HEAD -> main)%n|\\  Merge: %s%n| | Author: %s%n| | Message: %s%n|%n",
                    hash, branch, author, message);
        } else {
            System.out.printf("| * commit %s (%s)%n|   Author: %s%n|   Message: %s%n|%n",
                    hash, branch, author, message);
        }
    }
}
