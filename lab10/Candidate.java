import java.util.*;

public class Candidate
{
    // fields
    private int idNum;
    private String pos;
    private double score;
    
    
    // constructor
    public Candidate(int idNumber, String position, double interviewScore)
    {
        this.idNum = idNumber;
        this.pos = position;
        this.score = interviewScore;
    }
    
    // fetch methods
    public String getPosition()
    {
        return this.pos;
    }
    
    public double getInterviewScore()
    {
        return this.score;
    }
}
