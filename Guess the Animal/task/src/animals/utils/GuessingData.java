package animals.utils;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public class GuessingData {

    private List<String> positivesResponses;
    private List<String> negativesResponses;
    private List<String> questions;
    private List<String> byeOptions;

    public GuessingData() {
    }

    public List<String> getPositivesResponses() {
        return positivesResponses;
    }

    public void setPositivesResponses(List<String> positivesResponses) {
        this.positivesResponses = positivesResponses;
    }

    public List<String> getNegativesResponses() {
        return negativesResponses;
    }

    public void setNegativesResponses(List<String> negativesResponses) {
        this.negativesResponses = negativesResponses;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public List<String> getByeOptions() {
        return byeOptions;
    }

    public void setByeOptions(List<String> byeOptions) {
        this.byeOptions = byeOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GuessingData)) return false;
        GuessingData that = (GuessingData) o;
        return Objects.equals(getPositivesResponses(), that.getPositivesResponses()) && Objects.equals(getNegativesResponses(), that.getNegativesResponses()) && Objects.equals(getQuestions(), that.getQuestions()) && Objects.equals(getByeOptions(), that.getByeOptions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPositivesResponses(), getNegativesResponses(), getQuestions(), getByeOptions());
    }


}
