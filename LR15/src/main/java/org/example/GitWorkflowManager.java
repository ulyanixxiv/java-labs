package org.example;

import java.util.ArrayList;
import java.util.List;

public class GitWorkflowManager {
    private String repositoryName;
    private List<GitCommit> commits;
    private List<GitBranch> branches;
    private int commitCounter = 1;

    public GitWorkflowManager(String repositoryName) {
        this.repositoryName = repositoryName;
        this.commits = new ArrayList<>();
        this.branches = new ArrayList<>();
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public List<GitCommit> getCommits() {
        return commits;
    }

    public List<GitBranch> getBranches() {
        return branches;
    }

    private String generateShortHash() {
        return String.format("%07x", (commitCounter++ * 0x1f3d5b7) & 0xfffffff);
    }

    /**
     * Симуляция переноса лабораторной работы в репозиторий через ветку и merge-коммит.
     */
    public void processLabWork(String labBranchName, String labDescription) {
        branches.add(new GitBranch(labBranchName, labDescription));

        // 1. Коммит с изменениями в тематической ветке
        String featHash = generateShortHash();
        GitCommit featCommit = new GitCommit(
                featHash,
                labBranchName,
                "Реализация заданий " + labBranchName + ": " + labDescription,
                false,
                "Студент <student@example.com>"
        );
        commits.add(featCommit);

        // 2. Слияние через Pull Request с созданием явного merge-коммита (git merge --no-ff)
        String mergeHash = generateShortHash();
        GitCommit mergeCommit = new GitCommit(
                mergeHash,
                labBranchName + " into main",
                "Merge pull request #" + branches.size() + " from " + labBranchName,
                true,
                "Студент <student@example.com>"
        );
        commits.add(mergeCommit);
    }

    /**
     * Печать графа коммитов в стиле команды `git log --graph --oneline`.
     */
    public void printCommitLogGraph() {
        System.out.println("--- История коммитов репозитория «" + repositoryName + "» (git log --graph --oneline): ---");
        System.out.println("*   Initial commit (README.md, .gitignore)");
        for (int i = 0; i < commits.size(); i += 2) {
            GitCommit feat = commits.get(i);
            GitCommit merge = commits.get(i + 1);
            System.out.printf("*   %s %s%n", merge.getHash(), merge.getMessage());
            System.out.printf("|\\%n");
            System.out.printf("| * %s %s%n", feat.getHash(), feat.getMessage());
            System.out.printf("|/%n");
        }
        System.out.println("*   [master/main] Репозиторий полностью синхронизирован.");
    }
}
