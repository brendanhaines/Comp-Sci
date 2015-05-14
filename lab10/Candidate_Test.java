
import java.util.*;
public class Candidate_Test
{
  public static void main(String[] args)
    {
        System.out.println("Testing the Candidate class:");
        Candidate test = new Candidate(0, "Engineer", 10.2);
        
        System.out.print("- getPosition works: ");
        boolean pass = test.getPosition() != null &&
                       test.getPosition().equals("Engineer");
        System.out.println(pass);
        if (!pass) {
            System.out.println("(Hint: Check your constructor?)");
            return;
        }
        
        System.out.print("- getInterviewScore works: ");
        System.out.println(test.getInterviewScore() == 10.2);
        
        System.out.println("\nTesting the CandidatePool class:");
        CandidatePool p = new CandidatePool();
        Candidate best = new Candidate(2, "Developer", 13.2);
        
        p.addCandidate(new Candidate(0, "Developer", 10.2));
        p.addCandidate(new Candidate(1, "Designer", 11.4));
        int n1 = p.pool.size();
        p.addCandidate(best);
        p.addCandidate(new Candidate(3, "Developer", 9.2));
        p.addCandidate(new Candidate(4, "Planner", 12.2));
        int n2 = p.pool.size();
        System.out.print("- addCandidate works: ");
        System.out.println(n1 == 2 && n2 == 5);
        
        
        List<Candidate> developers = p.getCandidatesForPosition("Developer");
        System.out.print("- getCandidatesForPosition works: ");
        System.out.println(developers.size() == 3);
        
        System.out.print("- getBestCandidate works: ");
        System.out.println(p.getBestCandidate("Developer") == best);
        
        p.removeCandidatesForPosition("Developer");
        System.out.print("- removeCandidatesForPosition works: ");
        developers = p.getCandidatesForPosition("Developer");
        System.out.println(developers.size() == 0);
    }
}
