package main.java;

/**
 * Created by Maciek on 31.10.2017.
 */
public class JuniorSchoolResults {

    private int mathNatureExamResult;
    private int humanisticExamResult;
    private int languageExamResult;
    private TestResultsGenerator testResultsGenerator;

    public JuniorSchoolResults(double middle) {
        testResultsGenerator = new TestResultsGenerator();
        this.mathNatureExamResult = testResultsGenerator.nextResult(middle);
        this.humanisticExamResult = testResultsGenerator.nextResult(middle);
        this.languageExamResult = testResultsGenerator.nextResult(middle);
    }

    public String toString(){
        return mathNatureExamResult + "\t" + humanisticExamResult + "\t" + languageExamResult;
    }

    public int getMathNatureExamResult() {
        return mathNatureExamResult;
    }

    public int getHumanisticExamResult() {
        return humanisticExamResult;
    }

    public int getLanguageExamResult() {
        return languageExamResult;
    }


}
