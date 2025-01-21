import java.util.*;

class Voter {
    private String voterId;
    private String name;
    private boolean hasVoted;

    public Voter(String voterId, String name) {
        this.voterId = voterId;
        this.name = name;
        this.hasVoted = false;
    }

    public String getVoterId() {
        return voterId;
    }

    public String getName() {
        return name;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void vote() {
        this.hasVoted = true;
    }
}

class Candidate {
    private String candidateId;
    private String name;
    private int votes;

    public Candidate(String candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
        this.votes = 0;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote() {
        this.votes++;
    }
}

class VotingSystem {
    private Map<String, Voter> voters;
    private Map<String, Candidate> candidates;

    public VotingSystem() {
        voters = new HashMap<>();
        candidates = new HashMap<>();
    }

    public void registerVoter(String voterId, String name) {
        if (!voters.containsKey(voterId)) {
            voters.put(voterId, new Voter(voterId, name));
            System.out.println("Voter registered successfully.");
        } else {
            System.out.println("Voter ID already exists.");
        }
    }

    public void addCandidate(String candidateId, String name) {
        if (!candidates.containsKey(candidateId)) {
            candidates.put(candidateId, new Candidate(candidateId, name));
            System.out.println("Candidate added successfully.");
        } else {
            System.out.println("Candidate ID already exists.");
        }
    }

    public void vote(String voterId, String candidateId) {
        Voter voter = voters.get(voterId);
        Candidate candidate = candidates.get(candidateId);

        if (voter == null) {
            System.out.println("Invalid voter ID.");
            return;
        }
        if (candidate == null) {
            System.out.println("Invalid candidate ID.");
            return;
        }
        if (voter.hasVoted()) {
            System.out.println("You have already voted.");
            return;
        }

        voter.vote();
        candidate.addVote();
        System.out.println("Vote cast successfully.");
    }

    public void displayResults() {
        System.out.println("Election Results:");
        for (Candidate candidate : candidates.values()) {
            System.out.println(candidate.getName() + " - " + candidate.getVotes() + " votes");
        }
    }

    public void displayVoterDetails() {
        System.out.println("Voter Details:");
        for (Voter voter : voters.values()) {
            System.out.println("ID: " + voter.getVoterId() + ", Name: " + voter.getName() + ", Has Voted: "
                    + (voter.hasVoted() ? "Yes" : "No"));
        }
    }

    public void displayCandidateDetails() {
        System.out.println("Candidate Details:");
        for (Candidate candidate : candidates.values()) {
            System.out.println("ID: " + candidate.getCandidateId() + ", Name: " + candidate.getName() + ", Votes: "
                    + candidate.getVotes());
        }
    }
}

public class digitalVotingSyste {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nDigital Voting System");
            System.out.println("1. Register Voter");
            System.out.println("2. Add Candidate");
            System.out.println("3. Cast Vote");
            System.out.println("4. Display Results");
            System.out.println("5. Display Voter Details");
            System.out.println("6. Display Candidate Details");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Voter ID: ");
                    String voterId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String voterName = scanner.nextLine();
                    votingSystem.registerVoter(voterId, voterName);
                    break;
                case 2:
                    System.out.print("Enter Candidate ID: ");
                    String candidateId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String candidateName = scanner.nextLine();
                    votingSystem.addCandidate(candidateId, candidateName);
                    break;
                case 3:
                    System.out.print("Enter Voter ID: ");
                    voterId = scanner.nextLine();
                    System.out.print("Enter Candidate ID: ");
                    candidateId = scanner.nextLine();
                    votingSystem.vote(voterId, candidateId);
                    break;
                case 4:
                    votingSystem.displayResults();
                    break;
                case 5:
                    votingSystem.displayVoterDetails();
                    break;
                case 6:
                    votingSystem.displayCandidateDetails();
                    break;
                case 7:
                    System.out.println("Exiting... Thank you for using the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
